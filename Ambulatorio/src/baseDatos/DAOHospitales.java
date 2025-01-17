package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.clases.Hospital;
import java.util.ArrayList;

/* 
 * @author Martín Suárez García
 */
public class DAOHospitales extends AbstractDAO {

    //Contructor
    public DAOHospitales(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite consultar un hospital asociado con el ambulatorio
    public ArrayList<Hospital> consultarHospitalAsociado(Integer ambulatorio, String nombre, String provincia, Integer codigo, Float distancia) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmHospital = null;
        ResultSet rsHospital = null;
        ArrayList<Hospital> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Obtenemos strings de codigo y distancia
        String codH = codigo == null ? "" : "and hos.codigoHospital = ? ";
        String disH = distancia == null ? "" : "and aso.distancia <= ? ";

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para consultar en la tabla de hospital
            //con sus datos correspondientes dados
            stmHospital = con.prepareStatement(
                    "select hos.*, aso.distancia "
                    + "from hospital as hos, asociado as aso "
                    + "where hos.nombre like ? "
                    + "and hos.provincia like ? "
                    + "and hos.codigoHospital = aso.hospital "
                    + "and aso.ambulatorio = ? "
                    + codH
                    + disH
            );
            //Sustituimos
            stmHospital.setString(1, "%" + nombre + "%");
            stmHospital.setString(2, "%" + provincia + "%");
            stmHospital.setInt(3, ambulatorio);
            boolean cd = codigo == null;
            boolean dt = distancia == null;
            if (cd && !dt) {
                stmHospital.setFloat(4, distancia);
            } else if (!cd && dt) {
                stmHospital.setInt(4, codigo);
            } else if (!cd && !dt) {
                stmHospital.setInt(4, codigo);
                stmHospital.setFloat(5, distancia);
            }

            //Ejecutamos
            rsHospital = stmHospital.executeQuery();

            //Recogemos resultado
            while (rsHospital.next()) {

                resultado.add(new Hospital(
                        rsHospital.getInt("codigoHospital"),
                        rsHospital.getString("nombre"),
                        rsHospital.getString("direccion"),
                        rsHospital.getString("telefono"),
                        rsHospital.getString("provincia"),
                        rsHospital.getFloat("distancia")
                ));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmHospital.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}

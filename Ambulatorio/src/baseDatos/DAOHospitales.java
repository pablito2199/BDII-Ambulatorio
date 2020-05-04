package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Hospital;
import java.util.ArrayList;

/* 
 * @author Ainhoa Vivel Couso
 */
public class DAOHospitales extends AbstractDAO {

    //Contructor
    public DAOHospitales(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar un nuevo ambulatorio en la base de datos
    public ArrayList<Hospital> consultarHospital(String nombre, String provincia, Integer codigo, Float distancia) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmHospital = null;
        ResultSet rsHospital = null;
        ArrayList<Hospital> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Obtenemos strings de codigo y distancia
        String codH = codigo == null ? "" : "and codigo = ? ";
        String disH = distancia == null ? "" : "and distancia <= ? ";

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de ambulatorios un nuevo ambulatorio con el id de ambulatorio, nombre
            //clave, dirección, email y tipo de ambulatorio especificados
            stmHospital = con.prepareStatement(
                    "select * "
                    + "from hospital "
                    + "where nombre like ? "
                    + "and provincia like = ? "
                    + codH
                    + disH
            );
            //Sustituimos
            stmHospital.setString(1, nombre);
            stmHospital.setString(2, provincia);
            boolean cd = codigo == null;
            boolean dt = distancia == null;
            if (cd && !dt) {
                stmHospital.setFloat(3, distancia);
            } else if (!cd && dt) {
                stmHospital.setInt(3, codigo);
            } else if (!cd && !dt) {
                stmHospital.setInt(3, codigo);
                stmHospital.setFloat(4, distancia);
            }

            //Ejecutamos
            rsHospital = stmHospital.executeQuery();

            //Recogemos resultado
            while (rsHospital.next()) {

                resultado.add(new Hospital(
                        rsHospital.getInt("codigo"),
                        rsHospital.getString("nombre"),
                        rsHospital.getString("direccion"),
                        rsHospital.getString("telefono"),
                        rsHospital.getString("provincia")
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

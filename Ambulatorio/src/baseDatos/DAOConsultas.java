package baseDatos;

import aplicacion.clases.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pablo Tarrío Otero
 */
public class DAOConsultas extends AbstractDAO {

    //Contructor
    public DAOConsultas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar una nueva consulta en la base de datos
    public void insertarConsulta(Consulta consulta) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmConsulta = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de consultas una nueva consulta 
            //con el identificador, ambulatorio y especialidad de consulta especificados
            stmConsulta = con.prepareStatement("insert into consulta (identificador, ambulatorio, especialidad) "
                    + "values (?,?,?)");
            //Sustituimos
            stmConsulta.setInt(1, consulta.getIdentificador());
            stmConsulta.setInt(2, consulta.getAmbulatorio());
            stmConsulta.setString(3, consulta.getEspecialidad());

            //Actualizamos
            stmConsulta.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmConsulta.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar una consulta de la base de datos
    public void borrarConsulta(Integer identificador) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmConsulta = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de consultas aquel con el identificador especificado por argumentos
            stmConsulta = con.prepareStatement("delete from consulta where identificador = ?");
            //Sustituimos
            stmConsulta.setString(1, CIP);  //CIP del consulta
            //Actualizamos
            stmConsulta.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmConsulta.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite buscar consultas por su identificador
    public java.util.List<Consulta> consultarConsultas(Integer identificador) {
        //Declaramos variables
        java.util.List<Consulta> resultado = new java.util.ArrayList<>();
        Consulta consultaActual;
        Connection con;
        PreparedStatement stmConsultas = null;
        ResultSet rsConsultas;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el identificador, ambulatorio y especialdiad
            //que tengan el identificador dado
            String consulta = "select identificador, ambulatorio, especialidad "
                    + "from consulta "
                    + "where identificador like ?";

            //Preparamos la consulta
            stmConsultas = con.prepareStatement(consulta);
            //Sustituimos
            stmConsultas.setString(1, "%" + identificador + "%"); //Identificador
            //Ejecutamos
            rsConsultas = stmConsultas.executeQuery();
            //Mientras haya coincidencias
            while (rsConsultas.next()) {
                //Se crea una instancia de consulta con los datos recuperados de la base de datos
                consultaActual = new Consulta(rsConsultas.getInt("identificador"), rsConsultas.getInt("ambulatorio"), rsConsultas.getString("especialidad"));
                //Y se añade la instancia a la lista de consultas
                resultado.add(consultaActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmConsultas.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de consultas)
        return resultado;
    }
}

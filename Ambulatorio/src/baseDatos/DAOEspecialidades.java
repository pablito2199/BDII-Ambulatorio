package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.clases.Especialidad;

/**
 *
 * @author Pablo Tarrío Otero
 */
public class DAOEspecialidades extends AbstractDAO {

    //Contructor
    public DAOEspecialidades(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite consultar las especialidades existentes en la base de datos
    public java.util.List<Especialidad> consultarEspecialidades() {
        //Declaramos variables
        java.util.List<Especialidad> resultado = new java.util.ArrayList<Especialidad>();
        Especialidad especialidadActual;
        Connection con;
        PreparedStatement stmEspecialidades = null;
        ResultSet rsEspecialidad;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el la descripción
            //que tengan el nombre dado
            String consulta = "select nombre, descripcion "
                    + "from especialidad "
                    + "order by nombre ASC";

            //Preparamos la consulta
            stmEspecialidades = con.prepareStatement(consulta);
            //Ejecutamos
            rsEspecialidad = stmEspecialidades.executeQuery();
            //Mientras haya coincidencias
            while (rsEspecialidad.next()) {
                //Se crea una instancia de especialidad con los datos recuperados de la base de datos
                especialidadActual = new Especialidad(rsEspecialidad.getString("nombre"), rsEspecialidad.getString("descripcion"));
                //Y se añade la instancia a la lista de especialidades
                resultado.add(especialidadActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmEspecialidades.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }
}
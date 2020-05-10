package baseDatos;

import aplicacion.clases.PasswordUtils;
import aplicacion.clases.PersonalAdministrador;
import aplicacion.clases.PersonalSanitario;
import java.sql.*;
import java.util.ArrayList;

//Las transacciones de este DAO fueron implementadas por varios compañeros

public class DAOPersonal extends AbstractDAO {

    //Contructor
    public DAOPersonal(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /*
    * @author Pablo Tarrío Otero y Martín Suárez García
    */
    //Permite recuperar un usuario de la base de datos a partir de su dni y contraseña
    public Boolean validarAdministrador(String dni, String contrasena) {
        //Declaramos variables
        PersonalAdministrador resultado = null;
        Connection con;
        PreparedStatement stmAdministrador = null;
        ResultSet rsAdministrador;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia donde se selecciona el id, clave, nombre, dirección, email y tipo de usuario
            //de la tabla de usuarios que tengan como usuario y contraseña los proporcionados por argumentos
            stmAdministrador = con.prepareStatement(
                    "select * "
                    + "from personaladministrador "
                    + "where personal = ?");
            //Sustituimos
            stmAdministrador.setString(1, dni);             //Id del usuario (nombre de usuario)

            //Ejecutamos
            rsAdministrador = stmAdministrador.executeQuery();
            //Si existe algún resultado (que debe ser único)
            if (rsAdministrador.next()) {
                //Generamos una instancia de usuario con los datos recuperados
                resultado = new PersonalAdministrador(
                        rsAdministrador.getString("contrasena"),
                        rsAdministrador.getInt("ambulatorio"),
                        rsAdministrador.getString("personal"));
            }
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            //Finalmente se intenta cerrar los cursores
        } finally {
            try {
                stmAdministrador.close();
                //De no poder se notifica de ello
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        if (resultado == null) {
            this.getFachadaAplicacion().muestraExcepcion("Error al intentar obtener la contraseña.");
            return false;
        }
        return PasswordUtils.verificarClave(contrasena, resultado.getContrasena());
    }

    /*
    * @author Martín Suárez García
    */
    //Permite recuperar la especialidad de un personal sanitario
    public ArrayList<String> obtenerEspecialidades(String dni, Integer ambulatorio) {
        //Declaramos variables
        ArrayList<String> resultado = new ArrayList<>();
        Connection con;
        PreparedStatement stmPersonal = null;
        ResultSet rsPersonal;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia donde se selecciona el id, clave, nombre, dirección, email y tipo de usuario
            //de la tabla de usuarios que tengan como usuario y contraseña los proporcionados por argumentos
            stmPersonal = con.prepareStatement(
                    "select especialidad "
                    + "from especializacionpersonal "
                    + "where personal = ? "
                    + "and ambulatorio = ?"
            );

            //Sustituimos
            stmPersonal.setString(1, dni);
            stmPersonal.setInt(2, ambulatorio);

            //Ejecutamos
            rsPersonal = stmPersonal.executeQuery();

            //Si existe algún resultado
            while (rsPersonal.next()) {
                resultado.add(rsPersonal.getString("especialidad"));
            }
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            //Finalmente se intenta cerrar los cursores
        } finally {
            try {
                stmPersonal.close();
                //De no poder se notifica de ello
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    /*
    * @author Pablo Tarrío Otero
    */
    //Permite buscar personal sanitario por su dni y nombre
    public java.util.List<PersonalSanitario> consultarPersonal(String dni, String nombre, Integer ambulatorio) {
        //Declaramos variables
        java.util.List<PersonalSanitario> resultado = new java.util.ArrayList<PersonalSanitario>();
        PersonalSanitario personalActual;
        Connection con;
        PreparedStatement stmPersonal = null;
        ResultSet rsPersonal;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos todos los datos
            //que tengan el nombre y dni dado
            String consulta = "select ambulatorio, dni, nombre, fechaIncorporacion, telefono, sueldo, "
                    + "CAST ( EXTRACT(YEAR FROM age(current_date, fechaIncorporacion)) as varchar(4)) as antiguedad "
                    + "from personalSanitario "
                    + "where nombre like ? "
                    + "and dni like ? "
                    + "and ambulatorio = ? "
                    + "order by nombre ASC";

            //Preparamos la consulta
            stmPersonal = con.prepareStatement(consulta);
            //Sustituimos
            stmPersonal.setString(1, "%" + nombre + "%"); //Nombre
            stmPersonal.setString(2, "%" + dni + "%");    //DNI
            stmPersonal.setInt(3, ambulatorio);           //Ambulatorio
            //Ejecutamos
            rsPersonal = stmPersonal.executeQuery();
            //Mientras haya coincidencias
            while (rsPersonal.next()) {
                //Se crea una instancia de personal sanitario con los datos recuperados de la base de datos
                personalActual = new PersonalSanitario(
                        rsPersonal.getInt("ambulatorio"),
                        rsPersonal.getString("dni"),
                        rsPersonal.getString("nombre"),
                        rsPersonal.getDate("fechaIncorporacion"),
                        rsPersonal.getString("telefono"),
                        rsPersonal.getFloat("sueldo"),
                        rsPersonal.getString("antiguedad"));
                //Y se añade la instancia a la lista de personal sanitario
                resultado.add(personalActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmPersonal.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de personal sanitario)
        return resultado;
    }
}

package baseDatos;

import aplicacion.clases.Administrador;
import java.sql.*;


public class DAOPersonal extends AbstractDAO {

    //Contructor
    public DAOPersonal(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite recuperar un usuario de la base de datos a partir de su dni y contraseña
    public Boolean validarAdministrador(String dni, String contrasena) {
        //Declaramos variables
        Administrador resultado = null;
        Connection con;
        PreparedStatement stmAdministrador = null;
        ResultSet rsAdministrador;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia donde se selecciona el id, clave, nombre, dirección, email y tipo de usuario
            //de la tabla de usuarios que tengan como usuario y contraseña los proporcionados por argumentos
            stmAdministrador = con.prepareStatement("select ambulatorio, personal, contrasena "
                    + "from personaladministrador "
                    + "where dni = ? and contrasena = ?");
            //Sustituimos
            stmAdministrador.setString(1, dni);  //Id del usuario (nombre de usuario)
            stmAdministrador.setString(2, contrasena);      //Clave (contraseña)
            //Ejecutamos
            rsAdministrador = stmAdministrador.executeQuery();
            //Si existe algún resultado (que debe ser único)
            if (rsAdministrador.next()) {
                //Generamos una instancia de usuario con los datos recuperados
                resultado = new Administrador(rsAdministrador.getInt("ambulatorio"), rsAdministrador.getString("dni"),
                        rsAdministrador.getString("contrasena"));
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
        if (resultado != null) 
            return true;
        else
            return false;
    }
}

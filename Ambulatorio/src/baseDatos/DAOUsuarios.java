package baseDatos;

import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

    //Contructor
    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite recuperar un usuario de la base de datos a partir de su id y contraseña
    public Usuario validarUsuario(String idUsuario, String clave) {
        //Declaramos variables
        Usuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia donde se selecciona el id, clave, nombre, dirección, email y tipo de usuario
            //de la tabla de usuarios que tengan como usuario y contraseña los proporcionados por argumentos
            stmUsuario = con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario, edad  "
                    + "from usuario "
                    + "where id_usuario = ? and clave = ?");
            //Sustituimos
            stmUsuario.setString(1, idUsuario);  //Id del usuario (nombre de usuario)
            stmUsuario.setString(2, clave);      //Clave (contraseña)
            //Ejecutamos
            rsUsuario = stmUsuario.executeQuery();
            //Si existe algún resultado (que debe ser único)
            if (rsUsuario.next()) {
                //Generamos una instancia de usuario con los datos recuperados
                resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")), rsUsuario.getString("edad"));
            }
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            //Finalmente se intenta cerrar los cursores
        } finally {
            try {
                stmUsuario.close();
                //De no poder se notifica de ello
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve la información del usuario recuperada
        return resultado;
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void insertarUsuario(Usuario usuario) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmUsuario = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de usuarios un nuevo usuario con el id de usuario, nombre
            //clave, dirección, email y tipo de usuario especificados
            stmUsuario = con.prepareStatement("insert into usuario(id_usuario, clave, nombre, direccion, email, tipo_usuario, edad) "
                    + "values (?,?,?,?,?,?,?)");
            //Sustituimos
            stmUsuario.setString(1, usuario.getIdUsuario());  //Id del usuario
            stmUsuario.setString(2, usuario.getClave());        //Contraseña
            stmUsuario.setString(3, usuario.getNombre());      //Nombre
            stmUsuario.setString(4, usuario.getDireccion());    //Dirección
            stmUsuario.setString(5, usuario.getEmail());        //Correo electrónico
            stmUsuario.setString(6, usuario.getTipoUsuario().toString());   //Tipo de Usuario (convertido a String)
            stmUsuario.setString(7, usuario.getEdad());   //Edad

            //Actualizamos
            stmUsuario.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar un usuario de la base de datos
    public void borrarUsuario(String idUsuario) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmUsuario = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de usuarios aquel con la id especificada por argumentos
            stmUsuario = con.prepareStatement("delete from usuario where id_usuario = ?");
            //Sustituimos
            stmUsuario.setString(1, idUsuario);  //Id
            //Actualizamos
            stmUsuario.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar los datos de un usuario de la base de datos
    public void modificarUsuario(Usuario usuario) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmUsuario = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para actualizar los datos del usuario con la id especificada
            stmUsuario = con.prepareStatement("update usuario "
                    + "set clave = ?, "
                    + "nombre = ?, "
                    + "direccion = ?, "
                    + "email = ?, "
                    + "tipo_usuario = ?, "
                    + "edad = ? "
                    + "where id_usuario = ?");
            //Actualizamos
            stmUsuario.setString(1, usuario.getClave());  //Contraseña
            stmUsuario.setString(2, usuario.getNombre());  //Nombre
            stmUsuario.setString(3, usuario.getDireccion()); //Dirección
            stmUsuario.setString(4, usuario.getEmail()); //Correo electrónico
            stmUsuario.setString(5, usuario.getTipoUsuario().toString()); //Tipo de usuario
            stmUsuario.setString(6, usuario.getEdad());  //Edad del usuario
            stmUsuario.setString(7, usuario.getIdUsuario());  //Id de usuario
            //NOTA: El ID de usuario no se modificará

            //Actualizamos
            stmUsuario.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar si existe un usuario con el id especificado en la base de datos
    public boolean consultarUsuario(String id) {
        //Declaramos variables
        boolean resultado = false;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta que permita recuperar el id, clave, nombre, direccion, email y tipo de usuario
            //de la tabla de usuarios del usuario que tenga la id especificada
            stmUsuario = con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario "
                    + "from usuario where id_usuario = ?");
            //Sustituimos
            stmUsuario.setString(1, id);  //Id del usuario
            //Ejecutamos
            rsUsuario = stmUsuario.executeQuery();
            //Como solo puede haber un usuario con esa id basta con comprobar si hay o no resultado
            if (rsUsuario.next()) {
                //De haberlo setteamos resultado a verdadero
                resultado = true;
            } else {
                //De no, a falso
                resultado = false;
            }
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (verdadero si hya coincidencia en la base o falso si no)
        return resultado;
    }

    //Permite buscar usuarios por su id y/o nombre de usuario
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre) {
        //Declaramos variables
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el id, clave, nombre, direccion, email y tipo de usuario de la tabla de usuarios
            //que tengan el nombre dado
            String consulta = "select id_usuario, clave, nombre, direccion, email, tipo_usuario, edad "
                    + "from usuario as u "
                    + "where nombre like ?";

            //En caso de aportar el id
            if (id != null) {
                //También se busca por id y, por tanto, se especifica en la consulta
                consulta = consulta + " and id_usuario like ?";
            }

            //Preparamos la consulta
            stmUsuarios = con.prepareStatement(consulta);
            //Sustituimos
            stmUsuarios.setString(1, "%" + nombre + "%"); //Nombre
            if (id != null) {
                stmUsuarios.setString(2, "%" + id + "%"); //ID, en caso de no ser nulo
            }
            //Ejecutamos
            rsUsuarios = stmUsuarios.executeQuery();
            //Mientras haya coincidencias
            while (rsUsuarios.next()) {
                //Se crea una instancia de usuario con los datos recuperados de la base de datos
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                        rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                        rsUsuarios.getString("email"), TipoUsuario.CTU(rsUsuarios.getString("tipo_usuario")), rsUsuarios.getString("edad"));
                //Y se añade la instancia a la lista de usuarios
                resultado.add(usuarioActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmUsuarios.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de usuarios)
        return resultado;
    }

    //Permite consultar la información de los usuarios buscados por su id y/o nombre 
    //Incluye además infrormación sobre sus préstamos vencidos
    public java.util.List<Usuario> consultarPUsuarios(String id, String nombre) {
        //Declaramos variables
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios = null;
        PreparedStatement stmPrestamos = null;
        ResultSet rsUsuarios;
        ResultSet rsPrestamos;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el id, clave, nombre, direccion, email y tipo de usuario de la tabla de usuarios
            //que tengan el nombre dado
            String consulta = "select id_usuario, clave, nombre, direccion, email, tipo_usuario, edad "
                    + "from usuario as u "
                    + "where nombre like ?";
            if (id != null) {
                consulta = consulta + " and id_usuario like ?";
            }

            //En caso de aportar el id
            if (id != null) {
                //También se busca por id y, por tanto, se especifica en la consulta
                consulta = consulta + " and id_usuario like ?";
            }

            //Preparamos la consulta
            stmUsuarios = con.prepareStatement(consulta);
            //Sustituimos
            stmUsuarios.setString(1, "%" + nombre + "%"); //Nombre
            if (id != null) {
                stmUsuarios.setString(2, "%" + id + "%"); //ID, en caso de no ser nulo
            }
            //Ejecutamos
            rsUsuarios = stmUsuarios.executeQuery();
            //Mientras haya coincidencias
            while (rsUsuarios.next()) {
                //Se crea una instancia de usuario con los datos recuperados de la base de datos
                usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                        rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                        rsUsuarios.getString("email"), TipoUsuario.CTU(rsUsuarios.getString("tipo_usuario")), rsUsuarios.getString("edad"));

                //Se intenta consultar la tabla de préstamos
                try {
                    //Construimos una consulta que cuente el número de préstamos vencidos
                    //Para elllo se comprueba que los ejemplares no estén devueltos y que la fecha 
                    //actual (current_date) supere la de préstamo + 30 (fecha de devolución) para el usuario dado
                    consulta = "select COUNT(distinct ejemplar) as vencidos from prestamo where "
                            + "usuario like ? and fecha_devolucion is null and current_date > fecha_prestamo + 30";
                    //Preparamos la consulta
                    stmPrestamos = con.prepareStatement(consulta);
                    //Sustituimos
                    stmPrestamos.setString(1, usuarioActual.getIdUsuario());  //Id del usuario
                    //Ejecutamos
                    rsPrestamos = stmPrestamos.executeQuery();
                    //Como solo devuelve un valor lo recuperamos
                    rsPrestamos.next();
                    //Y lo guardamos como el número de préstamos vencidos (que han superado la fecha límite 
                    //para su devolución)
                    usuarioActual.setNumPrestamosVencidos(rsPrestamos.getInt("vencidos"));

                    //En caso de error se captura la excepción
                } catch (SQLException e) {
                    //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Finalmente intentamos cerrar el cursor de PRESTAMOS. El de usuarios sigue abierto.
                    try {
                        stmPrestamos.close();
                    } catch (SQLException e) {
                        //Si no se puede se imprime el error por pantalla
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Se añade el usuario a la lista de usuarios
                resultado.add(usuarioActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar el cursor de usuarios 
            try {
                stmUsuarios.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error por pantalla
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el resultado (lista de usuarios con información de préstamos vencidos)
        return resultado;
    }

}

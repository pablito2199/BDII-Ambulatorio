package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.clases.Enfermedad;

/**
 *
 * @author Pablo Tarrío Otero
 */
public class DAOEnfermedades extends AbstractDAO {

    //Contructor
    public DAOEnfermedades(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar una nueva enfermedad en la base de datos
    public void insertarEnfermedad(Enfermedad enfermedad) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmEnfermedad = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de enfermedades una nueva enfermedad con el nombre de enfermedad y su descripción
            stmEnfermedad = con.prepareStatement("insert into enfermedad (nombre, descripcion) "
                    + "values (?,?)");
            //Sustituimos
            stmEnfermedad.setString(1, enfermedad.getNombre());
            stmEnfermedad.setString(2, enfermedad.getDescripcion());

            //Actualizamos
            stmEnfermedad.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Enfermedad añadida correctamente.");

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmEnfermedad.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar un enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmEnfermedad = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de enfermedades aquella con el nombre especificado por argumentos
            stmEnfermedad = con.prepareStatement("delete from enfermedad where nombre = ?");
            //Sustituimos
            stmEnfermedad.setString(1, nombre);  //nombre del paciente
            //Actualizamos
            stmEnfermedad.executeUpdate();
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmEnfermedad.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar los datos de una enfermedad en la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmEnfermedad = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para actualizar los datos de la enfermedad con el nombre especificado
            stmEnfermedad = con.prepareStatement("update enfermedad "
                    + "set descripcion = ? "
                    + "where nombre = ?");
            //Actualizamos
            stmEnfermedad.setString(1, enfermedad.getDescripcion());

            stmEnfermedad.setString(2, enfermedad.getNombre());  //nombre de la enfermedad
            //NOTA: El nombre de la enfermedad no se puede modificar

            //Actualizamos
            stmEnfermedad.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Enfermedad modificada correctamente.");

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmEnfermedad.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar las enfermedades existentes en la base de datos
    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        //Declaramos variables
        java.util.List<Enfermedad> resultado = new java.util.ArrayList<Enfermedad>();
        Enfermedad enfermedadActual;
        Connection con;
        PreparedStatement stmEnfermedades = null;
        ResultSet rsEnfermedad;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el la descripción
            //que tengan el nombre dado
            String consulta = "select nombre, descripcion "
                    + "from enfermedad "
                    + "where nombre like ? "
                    + "order by nombre ASC";

            //Preparamos la consulta
            stmEnfermedades = con.prepareStatement(consulta);
            //Sustituimos
            stmEnfermedades.setString(1, "%" + nombre + "%"); //Nombre
            //Ejecutamos
            rsEnfermedad = stmEnfermedades.executeQuery();
            //Mientras haya coincidencias
            while (rsEnfermedad.next()) {
                //Se crea una instancia de enfermedad con los datos recuperados de la base de datos
                enfermedadActual = new Enfermedad(rsEnfermedad.getString("nombre"), rsEnfermedad.getString("descripcion"));
                //Y se añade la instancia a la lista de enfermedades
                resultado.add(enfermedadActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmEnfermedades.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }

    //Permite recuperar los datos de la enfermedad con el nombre correspondiente
    public Enfermedad consultarEnfermedadActual(String nombre) {
        //Declaramos variables
        Enfermedad resultado = null;
        Enfermedad enfermedadActual;
        Connection con;
        PreparedStatement stmEnfermedades = null;
        ResultSet rsEnfermedad;

        //Establecemos conexión
        con = this.getConexion();

        //cuenta el número de prestamos cuya diferencia de días es mayor o igual a 30 con respecto al día de hoy
        String consulta = "select nombre, descripcion "
                + "from enfermedad "
                + "where nombre = ?";

        try {
            stmEnfermedades = con.prepareStatement(consulta);
            stmEnfermedades.setString(1, nombre);
            rsEnfermedad = stmEnfermedades.executeQuery();
            rsEnfermedad.next();
            resultado = new Enfermedad(rsEnfermedad.getString("nombre"), rsEnfermedad.getString("descripcion"));
        } catch (SQLException e) {
        } finally {
            try {
                stmEnfermedades.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    //Permite consultar las enfermedades existentes sin actualizar una lista
    public java.util.List<String> obtenerEnfermedadesNoActualizadas(java.util.List<String> enfermedades, String enfermedad) {
        //Declaramos variables
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        String enfermedadActual;
        Connection con;
        PreparedStatement stmEnfermedades = null;
        ResultSet rsEnfermedad;
        String parametros = "and nombre not in (?";
        for (int i = 1; i < enfermedades.size(); i++) {
            parametros += ",?";
        }
        parametros += ") ";
        String nom = "";
        if (!enfermedades.isEmpty()) {
            nom = parametros;
        }

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el la descripción
            //que tengan el nombre dado
            String consulta = "select nombre "
                    + "from enfermedad "
                    + "where nombre like ? "
                    + nom
                    + "order by nombre ASC";

            //Preparamos la consulta
            stmEnfermedades = con.prepareStatement(consulta);
            stmEnfermedades.setString(1, "%" + enfermedad + "%"); //Nombre
            for (int i = 1; i <= enfermedades.size(); i++) {
                //Sustituimos
                stmEnfermedades.setString(i + 1, enfermedades.get(i - 1)); //Enfermedades
            }
            //Ejecutamos
            rsEnfermedad = stmEnfermedades.executeQuery();
            //Mientras haya coincidencias
            while (rsEnfermedad.next()) {
                //Se crea una instancia de enfermedad con los datos recuperados de la base de datos
                enfermedadActual = rsEnfermedad.getString("nombre");
                //Y se añade la instancia a la lista de enfermedades
                resultado.add(enfermedadActual);
            }
            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmEnfermedades.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }
}

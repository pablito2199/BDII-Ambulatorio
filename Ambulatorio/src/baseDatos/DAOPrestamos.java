package baseDatos;

import aplicacion.Ejemplar;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOPrestamos extends AbstractDAO {

    //Constructor
    public DAOPrestamos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar un nuevo préstamo en la base de datos
    public void nuevoPrestamo(Integer idLibro, Ejemplar ej) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPrestamo = null;

        //Establecemos la conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia para insertar en la tabla de préstamos un nuevo préstamo con
            //la fecha de préstamo actual y con el usuario, libro y ejemplar dados
            stmPrestamo = con.prepareStatement("insert into prestamo(fecha_prestamo, usuario, libro, ejemplar) "
                    + "values (current_date,?,?,?)");
            //Sustituimos
            stmPrestamo.setString(1, ej.getUsuario());  //Id del usuario
            stmPrestamo.setInt(2, idLibro);     //Id del libro
            stmPrestamo.setInt(3, ej.getNumEjemplar());  //Numero del ejemplar
            //Actualizamos
            stmPrestamo.executeUpdate();
            //En caso de fallo capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el mensaje de error y generamos la ventana 
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmPrestamo.close();
            } catch (SQLException e) {
                //En caso de no poder se captura la excepción y se notifica de ello al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    //Permite devolver un ejemplar prestado y así reflejarlo en la base de datos
    public void devolverPrestamo(Integer idLibro, Ejemplar fp) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPrestamo = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia que permita MODIFICAR en la tabla de préstamos aquel cuya fecha de prestamo,
            //ejemplar, usuario y libro sean los especificados. Además el ejemplar debe estar actualmente prestado para
            //poder devolverlo (fecha de devolución debe ser null)
            stmPrestamo = con.prepareStatement("update prestamo set fecha_devolucion = current_date where fecha_prestamo = ? "
                    + "and libro = ? and ejemplar = ? and fecha_devolucion is null and usuario = ?");
            //Sustituimos
            stmPrestamo.setDate(1, fp.getFechaPrestamo());  //Feca de préstamo
            stmPrestamo.setInt(2, idLibro);                          //Id del libro
            stmPrestamo.setInt(3, fp.getNumEjemplar());       //Número del ejemplar
            stmPrestamo.setString(4, fp.getUsuario());          //Id del usuario que lo pidió prestado
            //Actualizamos
            stmPrestamo.executeUpdate();
            //En caso de fallo capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el mensaje de error y generamos la ventana 
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmPrestamo.close();
            } catch (SQLException e) {
                //En caso de no poder se captura la excepción y se notifica de ello al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //NOTA: No se ha implementado una función "eliminar préstamo" dado
    //que la base de datos debe recoger todos los préstamos que se han realizado
}

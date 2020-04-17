package baseDatos;

import aplicacion.Categoria;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {

    //Constructor
    public DAOCategorias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Función para consultar la información de las categorías
    public java.util.List<Categoria> consultarCategorias() {
        //Se declaran variables
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos realizar la consulta SQL
        try {
            //Tomamos el nombre y la descripción de categorías
            stmCategorias = con.prepareStatement("select nombre, descripcion from categoria");
            //Ejecutamos
            rsCategorias = stmCategorias.executeQuery();
            //Mientras haya categorías sin procesar
            while (rsCategorias.next()) {
                //Creamos una instancia de categoría en el programa con los datos obtenidos de la consulta
                categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
                //Añadimos el resultado a un array de categorías
                resultado.add(categoriaActual);
            }
        //Si hubo alguna excepción la capturamos
        } catch (SQLException e) {
            //Imprimimos el error
            System.out.println(e.getMessage());
            //Mostramos una ventana con la excepción
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar la conexión
            try {
                stmCategorias.close();
                //En caso de producirse un error imprimimos un mensaje
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el array con todas la categorías de la base de datos
        return resultado;
    }

    //Se inserta una nueva categoría en la base de datos
    public void nuevaCategoria(String n, String d) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmCategoria = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos hacer la consulta SQL
        try {
            //Insertamos en la tabla categoría los parámetros nombre y descripción con valores dados
            stmCategoria = con.prepareStatement("insert into categoria(nombre, descripcion) "
                    + "values (?,?)");
            //Sustituimos las interrogaciones con datos concretos
            stmCategoria.setString(1, n); //Nombre de la categoría
            stmCategoria.setString(2, d); //Descripción de la categoría
            stmCategoria.executeUpdate(); //Actualizamos
           
            //En caso de que se produzca un error capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el mensaje y mostramos el error en una ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar la conexión
            try {
                stmCategoria.close();
                //De no poder imprimimos un mensaje
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    //Permite eliminar una categoría de la base de datos
    public void eliminarCategoria(String nombre) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmCategoria = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Borramos de la tabla categorias la instancia cuyo nombre sea el dado
            stmCategoria = con.prepareStatement("delete from categoria where nombre = ?");
            //Sustituimos la ? por el nombre de la categoría puesto que es la PK
            stmCategoria.setString(1, nombre);
            //Actualizamos
            stmCategoria.executeUpdate();

            //En caso de error capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos y mostramos en ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                //Si no se pudo cerrar imprimimos un mensaje avisando
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}

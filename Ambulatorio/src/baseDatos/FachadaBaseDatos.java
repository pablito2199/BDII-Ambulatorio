package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Usuario;
import aplicacion.Categoria;
import aplicacion.Libro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;    // Enlace a la fachada de aplicación
    private java.sql.Connection conexion;       // Conexión SQL
    private DAOLibros daoLibros;                   // Enlace al DAO de Libros
    private DAOCategorias daoCategorias;      // Enlace al DAO de Categorías
    private DAOUsuarios daoUsuarios;            // Enlace al DAO de Usuarios
    private DAOPrestamos daoPrestamos;       // Enlace al DAO de Préstamos

    //Contructor
    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        //Se configura la conexión con el archivo .properties
        try {
            //Inicialiamos e instanciamos
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            //Establecemos propiedades de usuario y contraseña
            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            //Creamos la conexión
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            //Inicializamos los DAOS
            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoPrestamos = new DAOPrestamos(conexion, fa);

            //En caso de error capturamos la excepciones, imprimirmos el mensaje y genereramos la ventana de excepción
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

////////////////
//DAOLIBROS
///////////////
    //Permite recuperar un array de libros
    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor) {
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    //Consultar la información de un libro
    public Libro consultarLibro(Integer idLibro) {
        return daoLibros.consultarLibro(idLibro);
    }

    //Consultar los ejemplares de un libro a partir de su id
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return daoLibros.consultarEjemplaresLibro(idLibro);
    }

    //Obtener el resto de categorías que no están en el libro
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro) {
        return daoLibros.obtenerRestoCategorias(idLibro);
    }

    //Permite insertar un nuevo libro en la base de datos
    public Integer insertarLibro(Libro libro) {
        return daoLibros.insertarLibro(libro);
    }

    //Permite borrar un libro de la base de datos
    public void borrarLibro(Integer idLibro) {
        daoLibros.borrarLibro(idLibro);
    }

    //Permite modificar un libro de la base de datos
    public void modificarLibro(Libro libro) {
        daoLibros.modificarLibro(libro);
    }

    //Permite modificar las categorías de un libro de la base de datos
    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        daoLibros.modificarCategoriasLibro(idLibro, categorias);
    }

    //Permite insertar ejemplares de un libro en la base de datos
    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.insertarEjemplarLibro(idLibro, ejemplar);
    }

    //Permite borrar ejemplares de un libro de la base de datos
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar) {
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }

    //Permite modificar los ejemplares de un libro de la base de datos
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.modificarEjemplarLibro(idLibro, ejemplar);
    }

//////////////////////
//DAOCATEGORIAS
/////////////////////
    //Función para consultar la información de las categorías
    public java.util.List<Categoria> consultarCategorias() {
        return daoCategorias.consultarCategorias();
    }

    //Se inserta una nueva categoría en la base de datos
    public void nuevaCategoria(String n, String d) {
        daoCategorias.nuevaCategoria(n, d);
    }

    //Permite eliminar una categoría de la base de datos
    public void eliminarCategoria(String n) {
        daoCategorias.eliminarCategoria(n);
    }

//////////////////
//DAOUSUARIOS
//////////////////
    //Permite recuperar un usuario de la base de datos a partir de su id y contraseña
    public Usuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void insertarUsuario(Usuario user) {
        daoUsuarios.insertarUsuario(user);
    }

    //Permite eliminar un usuario de la base de datos
    public void borrarUsuario(String id) {
        daoUsuarios.borrarUsuario(id);
    }

    //Permite modificar los datos de un usuario de la base de datos
    public void modificarUsuario(Usuario user) {
        daoUsuarios.modificarUsuario(user);
    }

    //Permite consultar si existe un usuario con el id especificado en la base de datos
    public boolean consultarUsuario(String id) {
        return daoUsuarios.consultarUsuario(id);
    }

    //Permite buscar usuarios por su id y/o nombre de usuario
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre) {
        return daoUsuarios.consultarUsuarios(id, nombre);
    }

    //Permite consultar la información de los usuarios buscados por su id y/o nombre 
    //Incluye además infrormación sobre sus préstamos vencidos
    public java.util.List<Usuario> consultarPUsuarios(String id, String nombre) {
        return daoUsuarios.consultarPUsuarios(id, nombre);
    }

////////////////////
//DAOPRESTAMOS
////////////////////
    //Permite insertar un nuevo préstamo en la base de datos
    public void nuevoPrestamo(Integer idLibro, Ejemplar ej) {
        daoPrestamos.nuevoPrestamo(idLibro, ej);
    }

    //Permite devolver un ejemplar prestado y así reflejarlo en la base de datos
    public void devolverPrestamo(Integer idLibro, Ejemplar fp) {
        daoPrestamos.devolverPrestamo(idLibro, fp);
    }

}

package aplicacion;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {

    gui.FachadaGui fgui;                            // Enlace a la fachada de la GUI
    baseDatos.FachadaBaseDatos fbd;         // Enlace a la fachada de base de datos
    GestionCitas gc;                                 // Enlace a la clase gestión de libros
    GestionPacientes gp;                           // Enlace a la clase gestión de usuarios
    GestionEnfermedades ge;                     // Enlace a la clase gestión de categorías
    GestionMedicamentos gm;                    // Enlace a la clase gestión de prestamos

    //Constructor
    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cl = new GestionLibros(fgui, fbd);
        cu = new GestionUsuarios(fgui, fbd);
        cg = new GestionCategorias(fgui, fbd);
        cp = new GestionPrestamos(fgui, fbd);
    }

    //Main
    public static void main(String args[]) {
        FachadaAplicacion fa;                   //Declaramos la variable fachada
        fa = new FachadaAplicacion();       //La inicializamos
        fa.iniciaInterfazUsuario();              //LLamamos a la interfaz de usuario
    }

    //Llamada para mostrar una excepción
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

/////////////////////////
//GESTIÓN DE LIBROS
/////////////////////////
    //Función que permite obtener un array de libros a partir de su id, titulo, isbn y/o autor
    public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor) {
        return cl.obtenerLibros(id, titulo, isbn, autor);
    }

    //Permite recuperar los datos de un libro
    public void visualizarLibro(Integer idLibro) {
        cl.visualizarLibro(idLibro);
    }

    //Permite registrar un nuevo libro en la base de datos
    public void nuevoLibro() {
        cl.nuevoLibro();
    }

    //Permite actualizar los datos de un libro
    public Integer actualizarLibro(Libro l) {
        return cl.actualizarLibro(l);
    }

    //Permite borrar un libro de la base de datos
    public void borrarLibro(Integer idLibro) {
        cl.borrarLibro(idLibro);
    }

    //Permite actualizar la información de las categorías de un libro
    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        cl.actualizarCategoriasLibro(idLibro, categorias);
    }

    //Permite actualizar (consultar y modificar) la información de los ejemplares de un libro
    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar) {
        return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
    }

    //Permite modificar los ejemplares de un libro
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        cl.modificarEjemplarLibro(idLibro, ejemplar);
    }

    //Permite consutar las información sobre los ejemplares de un libro
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return cl.consultarEjemplaresLibro(idLibro);
    }

////////////////////////////
//GESTIÓN DE USUARIOS
////////////////////////////
    //Llamada a la interfaz de usuario
    public void iniciaInterfazUsuario() {
        cu.iniciaInterfazUsuario();
    }

    //Permite comprobar si el usuario que intenta acceder al programa tiene los credenciales necesarios
    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return cu.comprobarAutentificacion(idUsuario, clave);
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void nuevoUsuario(Usuario user) {
        cu.nuevoUsuario(user);
    }

    //Permite abrir una nueva ventana de usuarios
    public void accesoUsuarios() {
        cu.accesoUsuarios();
    }

    //Permite modificar la unformación de un usuario
    public void actualizarUsuario(Usuario U) {
        cu.actualizarUsuario(U);
    }

    //Permite eliminar un usuario de la base de datos
    public void borrarUsuario(String idUsuario) {
        cu.borrarUsuario(idUsuario);
    }

    //Permite saber si existe un usuario en la base de datos
    public boolean consultarUsuario(String id) {
        return cu.consultarUsuario(id);
    }

    //Permite recuperar una lista de usuarios con información sobre sus préstamos vencidos
    public java.util.List<Usuario> consultarPUsuarios(String id, String nombre) {
        return cu.consultarPUsuarios(id, nombre);
    }

    //Función que permite obtener un array de usuarios a partir de su id y/o nombre
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre) {
        return cu.obtenerUsuarios(id, nombre);
    }

///////////////////////////////
//GESTIÓN DE CATEGORIAS
///////////////////////////////
    //Permite añadir una categoría
    public void nuevaCategoria(String nombre, String d) {
        cg.nuevaCategoria(nombre, d);
    }

    //Permite eliminar una categoría
    public void eliminarCategoria(String nombre) {
        cg.eliminarCategoria(nombre);
    }

    //Permite abrir una nueva ventana de categorías
    public void accesoCategorias() {
        cg.accesoCategorias();
    }

    //Perminte consultar todas las categorías existentes
    public java.util.List<Categoria> consultarCategorias() {
        return cg.consultarCategorias();
    }

//////////////////////////////
//GESTIÓN DE PRESTAMOS
//////////////////////////////
    //Permite abrir una nueva ventana de préstamos
    public void accesoPrestamos(gui.VLibro parent, Integer idLibro, Ejemplar e) {
        cp.accesoPrestamos(parent, idLibro, e);
    }

    //Permite registrar un nuevo préstamo de un ejemplar en la base de datos
    public void nuevoPrestamo(Integer idLibro, Ejemplar e) {
        cp.nuevoPrestamo(idLibro, e);
    }

    //Permite finalizar el préstamos. No lo borra, lo marca como devuelto
    public void devolverPrestamo(Integer idLibro, Ejemplar p) {
        cp.devolverPrestamo(idLibro, p);
    }

}

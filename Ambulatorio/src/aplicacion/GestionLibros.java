package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionLibros {

    FachadaGui fgui;                    //Enlace a la fachada de la GUI
    FachadaBaseDatos fbd;           //Enlace a la fachada de Base de Datos

    //Constructor
    public GestionLibros(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //////////
    //LIBROS
    //////////
    //Permite obtener un array de libros a partir de su id, titulo, isbn y/o autor
    public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor) {
        return fbd.consultarCatalogo(id, titulo, isbn, autor);
    }

    //Permite obtener un array de libros a partir de su id, titulo, isbn y/o autor
    public void visualizarLibro(Integer idLibro) {
        java.util.List<String> restoCategorias;
        java.util.List<Ejemplar> ejemplares;
        Libro l;
        l = fbd.consultarLibro(idLibro);
        restoCategorias = fbd.obtenerRestoCategorias(idLibro);
        fgui.visualizaLibro(l, restoCategorias);
    }

    //Permite introducir un nuevo dato en la base de datos
    public void nuevoLibro() {
        java.util.List<String> restoCategorias = new java.util.ArrayList<String>();

        for (Categoria c : fbd.consultarCategorias()) {
            restoCategorias.add(c.getNombre());
        }

        fgui.nuevoLibro(restoCategorias);
    }

    //Permite actualizar los datos de un libro
    public Integer actualizarLibro(Libro l) {

        Integer idLibro;

        if (l.getIdLibro() == null) {
            idLibro = fbd.insertarLibro(l);
        } else {
            fbd.modificarLibro(l);
            idLibro = l.getIdLibro();
        }

        return idLibro;
    }

    //Permite borrar un libro de la base de datos
    public void borrarLibro(Integer idLibro) {
        fbd.borrarLibro(idLibro);
    }

    ////////////////
    //CATEGORIAS
    ////////////////
    //Permite actualizar los datos de las categorías de un libro
    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        fbd.modificarCategoriasLibro(idLibro, categorias);
    }

    ////////////////
    //EJEMPLARES
    ////////////////
    //Permite actualizar (consultar y modificar) los datos de los ejemplares de un libro
    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar) {

        for (Ejemplar e : ejemplares) {
            if (e.getNumEjemplar() == null) {
                fbd.insertarEjemplarLibro(idLibro, e);
            } else {
                fbd.modificarEjemplarLibro(idLibro, e);
            }
        }

        fbd.borrarEjemplaresLibro(idLibro, borrar);

        return fbd.consultarEjemplaresLibro(idLibro);
    }

    //Permite recuperar los ejemplares de un libro a partir de su id
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return fbd.consultarEjemplaresLibro(idLibro);
    }

    //Permite modificar los datos de un ejemplar de un libro
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        fbd.modificarEjemplarLibro(idLibro, ejemplar);
    }

}

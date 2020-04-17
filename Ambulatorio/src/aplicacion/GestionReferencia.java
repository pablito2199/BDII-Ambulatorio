/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionLibros {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionLibros(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //obtiene los libros existentes en el catálogo
    public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor) {
        return fbd.consultarCatalogo(id, titulo, isbn, autor);
    }

    //permite visualizar las características de un libro
    public void visualizarLibro(Integer idLibro) {
        java.util.List<String> restoCategorias;
        Libro l;
        //consulta el libro en la base de datos
        l = fbd.consultarLibro(idLibro);
        //obtiene las categorías existentes
        restoCategorias = fbd.obtenerRestoCategorias(idLibro);
        fgui.visualizaLibro(l, restoCategorias);
    }

    //operación para crear la ventana de libro
    public void nuevoLibro() {
        java.util.List<String> restoCategorias = new java.util.ArrayList<String>();

        //añade las categorías existentes
        for (Categoria c : fbd.consultarCategorias()) {
            restoCategorias.add(c.getNombre());
        }

        fgui.nuevoLibro(restoCategorias);
    }

    //modifica los datos de un libro
    public Integer actualizarLibro(Libro l) {

        Integer idLibro;

        //si el libro no está en la base de datos, lo inserta, en caso contrario modifica los datos del ID concreto
        if (l.getIdLibro() == null) {
            idLibro = fbd.insertarLibro(l);
        } else {
            fbd.modificarLibro(l);
            idLibro = l.getIdLibro();
        }

        return idLibro;
    }

    //elimina un libro de la base de datos
    public void borrarLibro(Integer idLibro) {
        fbd.borrarLibro(idLibro);
    }

    //actualiza las categorías de un libro
    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        fbd.modificarCategoriasLibro(idLibro, categorias);
    }

    //modifica los ejemplares de un libro
    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar) {

        //en caso de no existir el ejemplar, lo añade, en caso de existir, modifca el elegido
        for (Ejemplar e : ejemplares) {
            if (e.getNumEjemplar() == null) {
                fbd.insertarEjemplarLibro(idLibro, e);
            } else {
                fbd.modificarEjemplarLibro(idLibro, e);
            }
        }

        //elimina el ejemplar
        fbd.borrarEjemplaresLibro(idLibro, borrar);

        return fbd.consultarEjemplaresLibro(idLibro);
    }

    //consulta los ejemplares que tiene un libro
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return fbd.consultarEjemplaresLibro(idLibro);
    }
}

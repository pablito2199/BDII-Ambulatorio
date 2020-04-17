package gui;

import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.Usuario;
import aplicacion.Ejemplar;

/**
 *
 * @author alumno
 */
public class FachadaGui {

    aplicacion.FachadaAplicacion fa;     // Enlace a la fachada de aplicación
    VPrincipal vp;                              // Enlace a la ventana principal de la aplicación

    //Constructor
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        //Se crea la ventana principal
        this.vp = new VPrincipal(fa);
    }

////////////////////////
//VENTANA DE LIBRO
////////////////////////
    //Permite generar una ventana para visualizar información de un libro
    public void visualizaLibro(Libro l, java.util.List<String> restoCategorias) {
        //Declaramos variables
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();

        //Recuperamos el nombre de las categorías del libro
        for (Categoria c : l.getCategorias()) {
            categorias.add(c.getNombre());
        }

        //Generamos la ventana
        vl = new VLibro(vp, true, fa, l, categorias, restoCategorias);

        //Hacemos visible la ventana
        vl.setVisible(true);
    }

    //Permite generar una ventana para crear un nuevo libro
    public void nuevoLibro(java.util.List<String> restoCategorias) {
        //Declaramos la ventana
        VLibro vl;
        //La inicializamos
        vl = new VLibro(vp, true, fa, restoCategorias);
        //La hacemos visible
        vl.setVisible(true);
    }

///////////////////////////
//VENTANA DE USUARIO
///////////////////////////
    //Permite crear una nueva ventana de usuario 
    public void nuevoUsuario() {
        //Generamos la ventana
        VUsuario vu;
        //La inicializamos
        vu = new VUsuario(vp, true, fa);
        //La hacemos visible
        vu.setVisible(true);
    }


////////////////////////////////
//VENTANA DE CATEGORIAS
////////////////////////////////
    //Permite crear una nueva ventana de cateogorías
    public void nuevaCategoria() {
        //Declaramos
        VCategoria v;
        //Instanciamos la ventana
        v = new VCategoria(vp, true, fa);
        //La hacemos visible
        v.setVisible(true);
    }

/////////////////////////////
//VENTANA DE PRESTAMO
/////////////////////////////
    //Permite crear una nueva ventana de préstamos
    public void accesoPrestamo(VLibro parent, Integer idLibro, Ejemplar e) {
        //Declaramos
        VPrestamo p;
        //Instanciamos la ventana
        p = new VPrestamo(parent, true, fa, idLibro, e);
        //La hacemos visible
        p.setVisible(true);
    }

//////////////////////
//OTRAS VENTANAS
//////////////////////
    //Permite iniciar la vista de la aplicación
    public void iniciaVista() {
        //Generamos una ventana de autentificación que permite ingresarse en la base de datos
        VAutentificacion va;
        va  = new VAutentificacion(vp, true, fa);
        //En caso de poder acceder entonces hacemos la ventana principal visible
        vp.setVisible(true);
        //Hacemos la ventana de autentificación invisible
        va.setVisible(true);
    }

    //Permite generar una ventana que muestre excepciones
    public void muestraExcepcion(String txtExcepcion) {
        //Declaramos la ventana
        VAviso va;
        //Instanciamos
        va  = new VAviso(vp, true, txtExcepcion);
        //La hacemos visible
        va.setVisible(true);
    }

}

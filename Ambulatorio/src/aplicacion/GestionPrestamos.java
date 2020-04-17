package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionPrestamos {

    FachadaGui fgui;                //Enlace a la fachada de la GUI
    FachadaBaseDatos fbd;       //Enlace a la fachada de Base de Datos

    //Constructor
    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite abrir una nueva ventana de préstamos
    public void accesoPrestamos(gui.VLibro parent, Integer idLibro, Ejemplar e) {
        fgui.accesoPrestamo(parent, idLibro, e);
    }

    //Permite registrar un nuevo préstamo de un ejemplar en la base de datos
    public void nuevoPrestamo(Integer idLibro, Ejemplar e) {
        fbd.nuevoPrestamo(idLibro, e);
    }

    //Permite finalizar el préstamos. No lo borra, lo marca como devuelto
    public void devolverPrestamo(Integer idLibro, Ejemplar p) {
        fbd.devolverPrestamo(idLibro, p);
    }
}

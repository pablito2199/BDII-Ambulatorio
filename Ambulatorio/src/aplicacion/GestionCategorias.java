package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */

public class GestionCategorias {

    FachadaGui fgui;                    //Enlace a la fachada de la GUI
    FachadaBaseDatos fbd;           //Enlace a la fachada de Base de Datos

    //Constructor
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite el acceso a la ventana de categorías
    public void accesoCategorias() {
        fgui.nuevaCategoria();
    }
    
    //Permite crear una nueva categoría
    public void nuevaCategoria(String nombre, String d){
        fbd.nuevaCategoria(nombre,d);
    }
    
    //Permite eliminar una categoría existente
    public void eliminarCategoria(String nombre){
        fbd.eliminarCategoria(nombre);
    }

    //Permite consultar todas las categorías existentes
    public java.util.List<Categoria> consultarCategorias(){        
        return fbd.consultarCategorias();
    }
}

package aplicacion;

import aplicacion.clases.Especialidad;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionEspecialidades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    /**
     *
     * @param fgui
     * @param fbd
     */
    public GestionEspecialidades(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Especialidad> consultarEspecialidades() {
        return fbd.consultarEspecialidades();
    }
}
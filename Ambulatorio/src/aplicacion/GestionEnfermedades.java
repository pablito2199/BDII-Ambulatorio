package aplicacion;

import aplicacion.clases.Enfermedad;
import gui.ventanas.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionEnfermedades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    /**
     *
     * @param fgui
     * @param fbd
     */
    public GestionEnfermedades(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite insertar una nueva enfermedad en la base de datos
    public void anadirEnfermedad(Enfermedad enfermedad) {
        fbd.insertarEnfermedad(enfermedad);
    }

    //Permite consultar las enfermedades existentes en la base de datos
    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return fbd.consultarEnfermedades(nombre);
    }

    //Permite recuperar los datos de la enfermedad con el nombre correspondiente
    public Enfermedad consultarEnfermedadActual(String nombre) {
        return fbd.consultarEnfermedadActual(nombre);
    }

    //Permite modificar los datos de una enfermedad en la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        fbd.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        fbd.borrarEnfermedad(nombre);
    }

    //Permite consultar las enfermedades existentes sin actualizar una lista
    public java.util.List<String> obtenerEnfermedadesNoActualizadas(java.util.List<String> enfermedades, String enfermedad) {
        return fbd.obtenerEnfermedadesNoActualizadas(enfermedades, enfermedad);
    }

    //Permite crear una nueva ventana de enfermedades
    public void nuevaVEnfermedades() {
        fgui.nuevaVEnfermedades();
    }
}

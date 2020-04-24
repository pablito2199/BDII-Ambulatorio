/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.clases.Enfermedad;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionEnfermedades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

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

    //Permite modificar los datos de una enfermedad en la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        fbd.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        fbd.borrarEnfermedad(nombre);
    }
    
    //Permite crear una nueva ventana de enfermedades
    public void nuevaVEnfermedades(java.util.List<String> enfermedades){
        fgui.nuevaVEnfermedades(enfermedades);
    }
}

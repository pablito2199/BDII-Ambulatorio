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

    public void anadirEnfermedad(Enfermedad enfermedad) {
        fbd.insertarEnfermedad(enfermedad);
    }

    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return fbd.consultarEnfermedades(nombre);
    }

    public void modificarEnfermedad(Enfermedad enfermedad) {
        fbd.modificarEnfermedad(enfermedad);
    }

    public void borrarEnfermedad(String nombre) {
        fbd.borrarEnfermedad(nombre);
    }
}

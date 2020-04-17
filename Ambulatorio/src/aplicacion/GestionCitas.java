/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionCitas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionCitas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Agrega una nueva cita a la base de datos
    public void insertarCita(Cita cita){
        fbd.insertarCita(cita);
    }
    
    //Elimina una cita de la base de datos
    public void eliminarCita(Cita cita) {
        fbd.borrarCita(cita);
    }
    
}

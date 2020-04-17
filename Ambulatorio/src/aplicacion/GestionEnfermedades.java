/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionEnfermedades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionEnfermedades(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
}
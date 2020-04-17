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
public class GestionConsultas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionConsultas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
}
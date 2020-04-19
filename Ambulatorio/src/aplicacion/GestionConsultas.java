/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.clases.Consulta;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionConsultas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionConsultas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void anadirConsulta(Consulta consulta) {
        fbd.anadirConsulta(consulta);
    }

    public java.util.List<Consulta> consultarConsultas(Integer identificador) {
        return fbd.consultarConsultas(identificador);
    }

    public void borrarConsulta(Integer identificador) {
        fbd.borrarConsulta(identificador);
    }
}

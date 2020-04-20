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

    public java.util.List<Consulta> consultarConsultas(Integer identificador, Integer ambulatorio, String especialidad) {
        return fbd.consultarConsultas(identificador, ambulatorio, especialidad);
    }

    public void borrarConsulta(Integer identificador, Integer ambulatorio, String especialidad) {
        fbd.borrarConsulta(identificador, ambulatorio, especialidad);
    }
    
    public void traspasarCitas(Integer identificador, Integer ambulatorio) {
        fbd.traspasarCitas(identificador, ambulatorio);
    }
}

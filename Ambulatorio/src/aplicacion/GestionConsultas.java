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

    //Permite insertar una nueva consulta en la base de datos
    public void anadirConsulta(Consulta consulta) {
        fbd.anadirConsulta(consulta);
    }

    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Consulta> consultarConsultas(Integer identificador, Integer ambulatorio, String especialidad) {
        return fbd.consultarConsultas(identificador, ambulatorio, especialidad);
    }

    //Permite eliminar una consulta de la base de datos
    public void borrarConsulta(Integer identificador, Integer ambulatorio, String especialidad) {
        fbd.borrarConsulta(identificador, ambulatorio, especialidad);
    }
    
    public void traspasarCitas(Integer identificador, Integer ambulatorio) {
        fbd.traspasarCitas(identificador, ambulatorio);
    }

    //Devuelve el número de consultas de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad) {
        return fbd.numeroConsultas(ambulatorio, especialidad);
    }
    
    //Permite crear una nueva ventana de consultas
    public void nuevaVConsultas(java.util.List<Integer> consultas, Integer ambulatorio){
        fgui.nuevaVConsultas(consultas, ambulatorio);
    }
}

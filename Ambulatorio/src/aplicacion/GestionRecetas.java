package aplicacion;

import aplicacion.clases.Cita;
import aplicacion.clases.Paciente;
import aplicacion.clases.Receta;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import gui.VCitasPendientes;

public class GestionRecetas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionRecetas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Agrega una nueva receta a la base de datos
    public void insertarReceta(Receta receta) {
        fbd.insertarReceta(receta);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin, Integer codigoReceta, String medicamento) {
        return fbd.consultarHistorialReceta(paciente, fechaInicio, fechaFin, codigoReceta, medicamento);
    }
    
    //Permite crear una nueva ventana de recetas
    public void nuevaVRecetar(VCitasPendientes vcit, Cita cita) {
        fgui.nuevaVRecetar(vcit, cita);
    }
}

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

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
    public void atenderCita(Cita cita) {
        fbd.atenderCita(cita);
    }
    
    //Agrega una nueva cita a la base de datos
    public void insertarUrgencia(Urgencia urgencia){
        fbd.insertarUrgencia(urgencia);
    }
    
    //Elimina una cita de la base de datos
    public void atenderUrgencia(Urgencia urgencia) {
        fbd.atenderUrgencia(urgencia);
    }
    
    //Consulta las citas pendientes
    public ArrayList<Cita> citasPendientes(){
        return fbd.citasPendientes();
    }
    
    //Consulta las urgencias pendientes
    public ArrayList<Urgencia> urgenciasPendientes(){
        return fbd.urgenciasPendientes();
    }
    
    //Consulta las citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente){
        return fbd.citasPaciente(paciente);
    }
    
    //Consulta las citas pendientes de un medico
    public ArrayList<Urgencia> citasMedico(Personal medico){
        return fbd.citasMedico(medico);
    }
}

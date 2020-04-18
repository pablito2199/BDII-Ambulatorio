package aplicacion;

import aplicacion.clases.Paciente;
import aplicacion.clases.Hospital;
import aplicacion.clases.Cita;
import aplicacion.clases.PersonalSanitario;
import aplicacion.clases.Urgencia;
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
    public void insertarCita(Cita cita, Paciente paciente){
        fbd.insertarCita(cita, paciente);
    }
        
    //Agrega una nueva cita a la base de datos
    public void insertarUrgencia(Urgencia urgencia){
        fbd.insertarUrgencia(urgencia);
    }
    
    //Atiende una cita o una urgencia
    public void atenderCita(Cita cita) {
        fbd.atenderCita(cita);
    }
    
    //Deriva una cita o urgencia a un hospital
    public void derivarHospital(Hospital hospital, Cita cita){
        fbd.derivarHospital(hospital, cita);
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
    public ArrayList<Urgencia> citasMedico(PersonalSanitario medico){
        return fbd.citasMedico(medico);
    }
}

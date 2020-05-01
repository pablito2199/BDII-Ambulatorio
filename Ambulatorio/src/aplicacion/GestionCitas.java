package aplicacion;

import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Paciente;
import aplicacion.clases.Hospital;
import aplicacion.clases.Cita;
import aplicacion.clases.Consulta;
import aplicacion.clases.PersonalSanitario;
import aplicacion.clases.Rango;
import aplicacion.clases.Urgencia;
import aplicacion.clases.TipoCita;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import gui.VCitasPendientes;
import gui.VPacientes;
import gui.VPersonal;

public class GestionCitas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionCitas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Agrega una nueva cita a la base de datos
    public void insertarCita(Cita cita, Paciente paciente) {
        fbd.insertarCita(cita, paciente);
    }

    //Agrega una nueva urgencia a la base de datos
    public void insertarUrgencia(Urgencia urgencia) {
        fbd.insertarUrgencia(urgencia);
    }

    //Atiende una cita o una urgencia
    public void atenderCita(Cita cita) {
        fbd.atenderCita(cita);
    }

    //Deriva una cita o urgencia a un hospital
    public void derivarHospital(Hospital hospital, Cita cita) {
        fbd.derivarHospital(hospital, cita);
    }

    //Devuelve una lista de horas de las citas que el paciente no puede reservar
    public ArrayList<Timestamp> citasOcupadas(Paciente paciente, Consulta consulta, Date inicio, Date fin) {

        if (paciente.getRango() == Rango.DELUXE) {
            return new ArrayList<>();
        }
        return fbd.citasOcupadas(consulta, inicio, fin);
    }

    //Consulta las urgencias pendientes de atender
    public ArrayList<Urgencia> urgenciasPendientes(Ambulatorio ambulatorio) {
        return fbd.urgenciasPendientes(ambulatorio);
    }

    //Consulta las citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente) {
        return fbd.citasPaciente(paciente);
    }

    //Consulta las citas pendientes de atender de un médico
    public ArrayList<Cita> citasMedico(PersonalSanitario medico) {
        return fbd.citasMedico(medico);
    }

    //Consulta la lista tipos de cita buscando por especialidad
    public ArrayList<TipoCita> obtenerTiposDeCita(String especialidad){
        return fbd.obtenerTiposDeCita(especialidad);
    }
    
    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVReservarCita(VCitasPendientes vcit, Paciente paciente) {
        fgui.nuevaVReservarCita(vcit, paciente);
    }

    //Permite generar una ventana para escoger un hospital al que derivar la cita o urgencia
    public void nuevaVDerivarHospital(Cita cita) {
        fgui.nuevaVDerivarHospital(cita);
    }

    //Permite generar una ventana para insertar una nueva urgencia del paciente
    public void nuevaVUrgencias(VPacientes vpac, Paciente paciente) {
        fgui.nuevaVUrgencias(vpac, paciente);
    }

    //Permite generar una ventana para consultar la lista de urgencias pendientes por antender
    public void nuevaVSalaUrgencias(Ambulatorio ambulatorio) {
        fgui.nuevaVSalaUrgencias(ambulatorio);
    }

    //Permite generar una ventana para consultar las citas pendientes de un médico
    public void nuevaVCitasPendientes(VPersonal vper, PersonalSanitario personal) {
        fgui.nuevaVCitasPendientes(vper, personal);
    }
}

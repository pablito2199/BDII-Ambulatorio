package aplicacion;

import aplicacion.clases.*;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Date;

public class FachadaAplicacion {

    gui.FachadaGui fgui;                            // Enlace a la fachada de la GUI
    baseDatos.FachadaBaseDatos fbd;         // Enlace a la fachada de base de datos
    GestionAmbulatorios gamb;                   // Enlace a la clase gestión de ambulatorio
    GestionCitas gcit;                               // Enlace a la clase gestión de citas
    GestionPacientes gpac;                       // Enlace a la clase gestión de pacientes
    GestionEnfermedades genf;                  // Enlace a la clase gestión de enfermedades
    GestionConsultas gcon;                       // Enlace a la clase gestión de consultas
    GestionRecetas grec;                          // Enlace a la clase gestión de recetas
    GestionAdministradores gadm;              // Enlace a la clase gestión de administradores

    //Constructor
    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gamb = new GestionAmbulatorios(fgui, fbd);
        gcit = new GestionCitas(fgui, fbd);
        gpac = new GestionPacientes(fgui, fbd);
        genf = new GestionEnfermedades(fgui, fbd);
        gcon = new GestionConsultas(fgui, fbd);
        grec = new GestionRecetas(fgui, fbd);
        gadm = new GestionAdministradores(fgui, fbd);
    }

    //Main
    public static void main(String args[]) {
        FachadaAplicacion fa;                //Declaramos la variable fachada
        fa = new FachadaAplicacion();    //La inicializamos
        fa.iniciarFachadaUsuario();         //Llamamos a la interfaz de usuario
    }

    //Comprueba si la autentificación es correcta
    public Boolean comprobarAutentificacion(String dni, String constrasena) {
        return gadm.comprobarAutentificacion(dni, constrasena);
    }

    //Llamada para mostrar una excepción
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

/////////////////////////
//GESTIÓN DE AMBULATORIOS
/////////////////////////
    //Permite insertar un nuevo usuario en la base de datos
    public void insertarAmbulatorio(Ambulatorio ambulatorio) {
        gamb.insertarAmbulatorio(ambulatorio);
    }

    //Permite modificar los datos de un ambulatorio de la base de datos
    public void modificarAmbulatorio(Ambulatorio ambulatorio) {
        gamb.modificarAmbulatorio(ambulatorio);
    }

    //Permite eliminar un ambulatorio de la base de datos
    public void borrarAmbulatorio(Integer ambulatorio) {
        gamb.borrarAmbulatorio(ambulatorio);
    }

    //Permite buscar ambulatorios por su id y/o nombre de ambulatorio
    public java.util.List<Ambulatorio> obtenerAmbulatorios(String nombre, Integer codigo, String Provincia) {
        return gamb.consultarAmbulatorios(nombre, codigo, Provincia);
    }
    
/////////////////////////
//GESTIÓN DE CITAS
/////////////////////////
    //Agrega una nueva cita
    public void insertarCita(Cita cita, Paciente paciente) {
        gcit.insertarCita(cita, paciente);
    }

    //Agrega una nueva urgencia
    public void insertarUrgencia(Urgencia urgencia) {
        gcit.insertarUrgencia(urgencia);
    }

    //Atiende una cita o una urgencia
    public void atenderCita(Cita cita) {
        gcit.atenderCita(cita);
    }

    //Deriva una cita o urgencia a un hospital
    public void derivarHospital(Hospital hospital, Cita cita) {
        gcit.derivarHospital(hospital, cita);
    }

    //Devuelve una lista de horas de las citas que el paciente no puede reservar
    public ArrayList<Timestamp> citasOcupadas(Ambulatorio ambulatorio, Paciente paciente, TipoCita tipocita, Date inicio, Date fin) {
        return gcit.citasOcupadas(ambulatorio, paciente, tipocita, inicio, fin);
    }

    //Lista de urgencias pendientes de atender
    public ArrayList<Urgencia> urgenciasPendientes(Ambulatorio ambulatorio) {
        return gcit.urgenciasPendientes(ambulatorio);
    }

    //Lista de citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente) {
        return gcit.citasPaciente(paciente);
    }

    //Lista de citas pendientes de todas las consultas donde el medico trabaja
    public ArrayList<Cita> citasMedico(PersonalSanitario medico) {
        return gcit.citasMedico(medico);
    }
    
    //Nueva ventana de reserva de citas
    public void nuevaVReservarCita(Ambulatorio ambulatorio, Paciente paciente){
        fgui.nuevaVReservarCita(ambulatorio, paciente);
    }
    
    //Nueva ventana de derivar a hospital
    public void nuevaVDerivarHospital(Cita cita){
        fgui.nuevaVDerivarHospital(cita);
    }
    
    //Nueva ventana de nuerva urgencia
    public void nuevaVUrgencias(Paciente paciente){
        fgui.nuevaVUrgencias(paciente);
    }
    
    //Nueva ventana de sala de urgencias
    public void nuevaVSalaUrgencias(Ambulatorio ambulatorio){
        fgui.nuevaVSalaUrgencias(ambulatorio);
    }
    
    //Nueva ventana de reserva de citas
    public void nuevaVCitasPendientes(Paciente paciente){
        fgui.nuevaVCitasPendientes(paciente);
    }

/////////////////////////
//GESTIÓN DE PACIENTES
/////////////////////////
    //Permite insertar un nuevo paciente en la base de datos
    public void insertarPaciente(Paciente paciente) {
        gpac.insertarPaciente(paciente);
    }

    //Permite modificar los datos de un paciente de la base de datos
    public void modificarPaciente(Paciente paciente) {
        gpac.modificarPaciente(paciente);
    }

    //Permite eliminar un paciente de la base de datos
    public void borrarPaciente(Paciente paciente) {
        gpac.borrarPaciente(paciente);
    }

    //Permite buscar pacientes por su id y/o nombre de paciente
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, Integer NSS, String grupo) {
        return gpac.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
    }

    //Permite saber si existe un paciente en la base de datos con el mismo identificador o no
    public boolean existePaciente(String CIP) {
        return gpac.existePaciente(CIP);
    }
    
    //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente, TipoCita tipoCita, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin) {
        return gpac.consultarHistorialClinico(paciente, tipoCita, fechaInicio, fechaFin);
    }

/////////////////////////
//GESTIÓN DE ENFERMEDADES
/////////////////////////
    //Permite insertar una nueva enfermedad en la base de datos
    public void anadirEnfermedad(Enfermedad enfermedad) {
        genf.anadirEnfermedad(enfermedad);
    }

    //Permite consultar las enfermedades existentes en la base de datos
    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return genf.consultarEnfermedades(nombre);
    }

    //Permite modificar los datos de una enfermedad en la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        genf.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        genf.borrarEnfermedad(nombre);
    }

/////////////////////////
//GESTIÓN DE CONSULTAS
/////////////////////////
    //Permite insertar una nueva consulta en la base de datos
    public void anadirConsulta(Consulta consulta) {
        gcon.anadirConsulta(consulta);
    }

    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Consulta> consultarConsultas(Integer identificador, Integer ambulatorio, String especialidad) {
        return gcon.consultarConsultas(identificador, ambulatorio, especialidad);
    }

    //Permite eliminar una consulta de la base de datos
    public void borrarConsulta(Integer identificador, Integer ambulatorio, String especialidad) {
        gcon.borrarConsulta(identificador, ambulatorio, especialidad);
    }
    
    public void traspasarCitas(Integer identificador, Integer ambulatorio) {
        gcon.traspasarCitas(identificador, ambulatorio);
    }

    //Devuelve el número de consultas de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad) {
        return gcon.numeroConsultas(ambulatorio, especialidad);
    }

/////////////////////////
//GESTIÓN DE RECETAS
/////////////////////////
    public void insertarReceta(Receta receta) {
        grec.insertarReceta(receta);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin, Integer codigoReceta, String medicamento) {
        return grec.consultarHistorialReceta(paciente, fechaInicio, fechaFin, codigoReceta, medicamento);
    }
}

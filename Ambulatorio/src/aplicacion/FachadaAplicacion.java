package aplicacion;

import aplicacion.clases.*;
import gui.ventanas.VCitasPendientes;
import gui.ventanas.VPacientes;
import gui.ventanas.VPersonal;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Date;

public class FachadaAplicacion {

    //////////////////////////////////////////////////
    //Atributos
    gui.ventanas.FachadaGui fgui;          // Enlace a la fachada de la GUI
    baseDatos.FachadaBaseDatos fbd;    // Enlace a la fachada de base de datos
    GestionAmbulatorios gamb;              // Enlace a la clase gestión de ambulatorio
    GestionCitas gcit;                           // Enlace a la clase gestión de citas
    GestionPacientes gpac;                   // Enlace a la clase gestión de pacientes
    GestionEnfermedades genf;              // Enlace a la clase gestión de enfermedades
    GestionConsultas gcon;                   // Enlace a la clase gestión de consultas
    GestionEspecialidades gesp;             // Enlace a la clase gestión de especialidades
    GestionRecetas grec;                      // Enlace a la clase gestión de recetas
    GestionPersonal gper;                     // Enlace a la clase gestión de administradores
    GestionHospitales ghos;                  // Enlace a la clase gestión de hospitales

    //////////////////////////////////////////////////
    //Constructor
    public FachadaAplicacion() {
        fgui = new gui.ventanas.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gamb = new GestionAmbulatorios(fgui, fbd);
        gcit = new GestionCitas(fgui, fbd);
        gpac = new GestionPacientes(fgui, fbd);
        genf = new GestionEnfermedades(fgui, fbd);
        gcon = new GestionConsultas(fgui, fbd);
        gesp = new GestionEspecialidades(fgui, fbd);
        grec = new GestionRecetas(fgui, fbd);
        gper = new GestionPersonal(fgui, fbd);
        ghos = new GestionHospitales(fgui, fbd);
    }

    //////////////////////////////////////////////////
    //Main
    public static void main(String args[]) {

        FachadaAplicacion fa;                //Declaramos la variable fachada
        fa = new FachadaAplicacion();    //La inicializamos
        fa.iniciaInterfazUsuario();           //Llamamos a la interfaz de usuario
    }

////////////////////////////
//MENSAJES AL USUARIO
////////////////////////////
    //Llamada para mostrar un mensaje de error (una excepción)
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    //Llamada para mostrar un mensaje de confirmación (feedback)
    public void muestraMensaje(String e) {
        fgui.muestraMensaje(e);
    }

/////////////////////////////
//GESTIÓN DE PERSONAL
/////////////////////////////
    //Comprueba si la autentificación es correcta
    public Boolean comprobarAutentificacion(String dni, String constrasena) {
        return gper.comprobarAutentificacion(dni, constrasena);
    }

    //Permite recuperar la especialidad de un personal sanitario
    public ArrayList<String> obtenerEspecialidades(String dni, Integer ambulatorio) {
        return gper.obtenerEspecialidades(dni, ambulatorio);
    }

    //Permite buscar personal sanitario de un ambulatorio por su dni y nombre
    public java.util.List<PersonalSanitario> consultarPersonal(String dni, String nombre, Integer ambulatorio) {
        return gper.consultarPersonal(dni, nombre, ambulatorio);
    }

    //Permite abrir una nueva ventana de usuarios para autentificarse
    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPersonal(Integer ambulatorio) {
        gper.nuevaVPersonal(ambulatorio);
    }

//////////////////////////////////
//GESTIÓN DE AMBULATORIOS
//////////////////////////////////
    //Permite insertar un nuevo ambulatorio en la base de datos
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

    //Permite buscar ambulatorios por su nombre, código y/o provincia
    public java.util.List<Ambulatorio> obtenerAmbulatorios(String nombre, Integer codigo, String Provincia) {
        return gamb.consultarAmbulatorios(nombre, codigo, Provincia);
    }

    //Permite recuperar los datos del ambulatorio con el nombre y provincia correspondientes
    public Ambulatorio consultarAmbulatorioActual(String nombre, String provincia) {
        return gamb.consultarAmbulatorioActual(nombre, provincia);
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
    public ArrayList<Timestamp> citasOcupadas(Paciente paciente, Consulta consulta, Date inicio, Date fin) {
        return gcit.citasOcupadas(paciente, consulta, inicio, fin);
    }

    //Lista de urgencias pendientes de atender
    public ArrayList<Urgencia> urgenciasPendientes(Ambulatorio ambulatorio) {
        return gcit.urgenciasPendientes(ambulatorio);
    }

    //Lista de citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente, String ambulatorio, Integer consulta, Date inicio, Date fin) {
        return gcit.citasPaciente(paciente, ambulatorio, consulta, inicio, fin);
    }

    //Lista de citas pendientes de todas las consultas donde el medico trabaja
    public ArrayList<Cita> citasMedico(PersonalSanitario medico, String ambulatorio, Date inicio, Date fin) {
        return gcit.citasMedico(medico, ambulatorio, inicio, fin);
    }

    //Consulta la lista tipos de cita buscando por especialidad
    public ArrayList<TipoCita> obtenerTiposDeCita(String especialidad) {
        return gcit.obtenerTiposDeCita(especialidad);
    }

    //Consulta la lista citas pendientes del paciente filtrada
    public void borrarCita(Cita cita) {
        gcit.borrarCita(cita);
    }

    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVReservarCita(VPacientes vcit, Paciente paciente) {
        gcit.nuevaVReservarCita(vcit, paciente);
    }

    //Permite generar una ventana para escoger un hospital al que derivar la cita o urgencia
    public void nuevaVDerivarHospital(Cita cita) {
        gcit.nuevaVDerivarHospital(cita);
    }

    //Permite generar una ventana para insertar una nueva urgencia del paciente
    public void nuevaVUrgencias(VPacientes vpac, Paciente paciente) {
        gcit.nuevaVUrgencias(vpac, paciente);
    }

    //Permite generar una ventana para consultar la lista de urgencias pendientes por antender
    public void nuevaVSalaUrgencias(Ambulatorio ambulatorio) {
        gcit.nuevaVSalaUrgencias(ambulatorio);
    }

    //Permite generar una ventana para consultar las citas pendientes de un médico
    public void nuevaVCitasPendientes(VPersonal vper, PersonalSanitario personal) {
        gcit.nuevaVCitasPendientes(vper, personal);
    }

    //Permite generar una ventana para consultar las citas pendientes de un paciente
    public void nuevaVCitasPendientes(VPacientes vpac, Paciente paciente) {
        gcit.nuevaVCitasPendientes(vpac, paciente);
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

    //Permite buscar pacientes por sus atributos
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, Integer NSS, String grupo) {
        return gpac.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
    }

    //Permite saber si existe un paciente en la base de datos con el mismo identificador o no
    public boolean existePaciente(String CIP) {
        return gpac.existePaciente(CIP);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente, TipoCita tipoCita, Date fechaInicio, Date fechaFin) {
        return gpac.consultarHistorialClinico(paciente, tipoCita, fechaInicio, fechaFin);
    }

    //Permite recuperar las enfermedades no padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesNoPadecidas(String cip, String enfermedad) {
        return gpac.obtenerEnfermedadesNoPadecidas(cip, enfermedad);
    }

    //Permite recuperar las enfermedades padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesPadecidas(String cip, String enfermedad) {
        return gpac.obtenerEnfermedadesPadecidas(cip, enfermedad);
    }

    //Permite actualizar las enfermedades de un paciente de la base de datos
    public void actualizarEnfermedadesPaciente(String cip, java.util.List<String> enfermedades) {
        gpac.actualizarEnfermedadesPaciente(cip, enfermedades);
    }

    //Permite generar una ventana para visualizar información de un paciente
    public void nuevaVPacientes() {
        gpac.nuevaVPacientes();
    }

    //Permite generar una nueva ventana de gestión de enfermedades de un paciente
    public void nuevaVGestionEnfermedades(VPacientes vpac, String cip) {
        gpac.nuevaVGestionEnfermedades(vpac, cip);
    }

    //Permite generar una ventana para visualizar información sobre el historial médico del paciente
    public void nuevaVHistorialMedico(VPacientes vpac, Paciente paciente) {
        gpac.nuevaVHistorialMedico(vpac, paciente);
    }

    //Permite generar una ventana para visualizar información sobre el historial de recetas del paciente
    public void nuevaVHistorialRecetas(VPacientes vpac, Paciente paciente) {
        gpac.nuevaVHistorialRecetas(vpac, paciente);
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

    //Permite recuperar los datos de la enfermedad con el nombre correspondiente
    public Enfermedad consultarEnfermedadActual(String nombre) {
        return genf.consultarEnfermedadActual(nombre);
    }

    //Permite modificar los datos de una enfermedad en la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        genf.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        genf.borrarEnfermedad(nombre);
    }

    //Permite consultar las enfermedades existentes sin actualizar una lista
    public java.util.List<String> obtenerEnfermedadesNoActualizadas(java.util.List<String> enfermedades, String enfermedad) {
        return genf.obtenerEnfermedadesNoActualizadas(enfermedades, enfermedad);
    }

    //Permite crear una nueva ventana de enfermedades
    public void nuevaVEnfermedades() {
        genf.nuevaVEnfermedades();
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

    //Devuelve el número de consultas de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad, Integer identificador) {
        return gcon.numeroConsultas(ambulatorio, especialidad, identificador);
    }

    //Permite obtener la consulta con menos citas pendientes
    public Consulta menorNumeroPacientes(Integer ambulatorio, String especialidad) {
        return gcon.menorNumeroPacientes(ambulatorio, especialidad);
    }

    //Permite crear una nueva ventana de consultas
    public void nuevaVConsultas(Integer ambulatorio) {
        java.util.List<Integer> restoConsultas = new java.util.ArrayList<>();
        for (Consulta c : this.consultarConsultas(null, ambulatorio, null)) {
            restoConsultas.add(c.getIdentificador());
        }
        gcon.nuevaVConsultas(ambulatorio, restoConsultas);
    }

////////////////////
//DAOESPECIALIDADES
//////////////////// 
    //Permite consultar las especialidades existentes en la base de datos
    public java.util.List<Especialidad> consultarEspecialidades() {
        return gesp.consultarEspecialidades();
    }

/////////////////////////
//GESTIÓN DE RECETAS
/////////////////////////
    //Agrega una nueva receta a la base de datos
    public void insertarReceta(Receta receta) {
        grec.insertarReceta(receta);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente, java.sql.Date fechaInicio, java.sql.Date fechaFin, Integer codigoReceta, String medicamento) {
        return grec.consultarHistorialReceta(paciente, fechaInicio, fechaFin, codigoReceta, medicamento);
    }

    //Permite consultar medicamentos en la base de datos
    public java.util.List<String> consultarMedicamentos(String nombre) {
        return grec.consultarMedicamentos(nombre);
    }

    //Permite crear una nueva ventana de recetas
    public void nuevaVRecetar(VCitasPendientes vcit, Cita cita) {
        grec.nuevaVRecetar(vcit, cita);
    }

/////////////////////////
//GESTIÓN DE HOSPITALES
/////////////////////////
    //Permite consultar un hospital asociado con el ambulatorio
    public ArrayList<Hospital> consultarHospitalAsociado(Integer ambulatorio, String nombre, String provincia, Integer codigo, Float distancia) {
        return ghos.consultarHospitalAsociado(ambulatorio, nombre, provincia, codigo, distancia);
    }
}

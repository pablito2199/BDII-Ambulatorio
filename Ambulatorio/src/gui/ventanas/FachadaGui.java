package gui.ventanas;

import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Cita;
import aplicacion.clases.Paciente;
import aplicacion.clases.PersonalSanitario;

public class FachadaGui {

    aplicacion.FachadaAplicacion fa;     // Enlace a la fachada de aplicación
    VPrincipal vp;                       // Enlace a la ventana principal de la aplicación

    //Constructor
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        //Se crea la ventana principal
        this.vp = new VPrincipal(fa);
    }

/////////////////////////////
//VENTANAS DE PERSONAL
/////////////////////////////
    //Permite abrir una nueva ventana de usuarios para autentificarse
    public void iniciaVista() {
        VAutentificacion va;

        va  = new VAutentificacion(vp, true, fa);
        //abre la ventana
        vp.setVisible(true);
        va.setVisible(true);
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPersonal(Integer ambulatorio) {
        //Declaramos variables
        VPersonal vP;
        //Generamos la ventana
        vP = new VPersonal(vp, true, fa, ambulatorio);
        //Hacemos visible la ventana
        vP.setVisible(true);
    }

////////////////////////////////
//VENTANAS DE CITAS
////////////////////////////////
    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVReservarCita(VPacientes vcit, Paciente paciente) {
        //Declaramos variables
        VReservarCita vRC;
        //Generamos la ventana
        vRC = new VReservarCita(vcit, true, fa, paciente);
        //Hacemos visible la ventana
        vRC.setVisible(true);
    }

    //Permite generar una ventana para escoger un hospital al que derivar la cita o urgencia
    public void nuevaVDerivarHospital(Cita cita) {
        //Declaramos variables
        VDerivarHospital vDH;
        //Generamos la ventana
        vDH = new VDerivarHospital(vp, true, fa, cita);
        //Hacemos visible la ventana
        vDH.setVisible(true);
    }

    //Permite generar una ventana para consultar las citas pendientes de un médico
    public void nuevaVCitasPendientes(VPersonal vper, PersonalSanitario personal) {
        //Declaramos variables
        VCitasPendientes vCP;
        //Generamos la ventana
        vCP = new VCitasPendientes(vper, true, fa, personal);
        //Hacemos visible la ventana
        vCP.setVisible(true);
    }

    //Permite generar una ventana para consultar las citas pendientes de un paciente
    public void nuevaVCitasPendientes(VPacientes vpac, Paciente paciente) {
        //Declaramos variables
        VCitasPendientes vCP;
        //Generamos la ventana
        vCP = new VCitasPendientes(vpac, true, fa, paciente);
        //Hacemos visible la ventana
        vCP.setVisible(true);
    }

    //Permite generar una ventana para consultar la lista de urgencias pendientes por antender
    public void nuevaVSalaUrgencias(Ambulatorio ambulatorio) {
        //Declaramos variables
        VSalaUrgencias vSU;
        //Generamos la ventana
        vSU = new VSalaUrgencias(vp, true, fa, ambulatorio);
        //Hacemos visible la ventana
        vSU.setVisible(true);
    }

    //Permite generar una ventana para insertar una nueva urgencia del paciente
    public void nuevaVUrgencias(VPacientes vpac, Paciente paciente) {
        //Declaramos variables
        VUrgencias vU;
        //Generamos la ventana
        vU = new VUrgencias(vpac, true, fa, paciente);
        //Hacemos visible la ventana
        vU.setVisible(true);
    }

////////////////////////////////
//VENTANAS DE PACIENTES
////////////////////////////////
    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPacientes() {
        //Declaramos variables
        VPacientes vP;
        //Generamos la ventana
        vP = new VPacientes(vp, true, fa);
        //Hacemos visible la ventana
        vP.setVisible(true);
    }

    //Permite generar una ventana para visualizar información sobre el historial médico del paciente
    public void nuevaVHistorialMedico(VPacientes vpac, Paciente paciente) {
        //Declaramos variables
        VHistorialMedico vHM;
        //Generamos la ventana
        vHM = new VHistorialMedico(vpac, true, fa, paciente);
        //Hacemos visible la ventana
        vHM.setVisible(true);
    }

    //Permite generar una ventana para visualizar información sobre el historial de recetas del paciente
    public void nuevaVHistorialRecetas(VPacientes vpac, Paciente paciente) {
        //Declaramos variables
        VHistorialRecetas vHR;
        //Generamos la ventana
        vHR = new VHistorialRecetas(vpac, true, fa, paciente);
        //Hacemos visible la ventana
        vHR.setVisible(true);
    }

    //Permite generar una ventana para visualizar la gestión de enfermedades de un paciente
    public void nuevaVGestionEnfermedades(VPacientes vpac, String cip) {
        //Declaramos variables
        VGestionEnfermedades vGE;
        //Generamos la ventana
        vGE = new VGestionEnfermedades(vpac, true, fa, cip);
        //Hacemos visible la ventana
        vGE.setVisible(true);
    }

/////////////////////////////
//VENTANA DE ENFERMEDADES
/////////////////////////////
    //Permite crear una nueva ventana de enfermedades
    public void nuevaVEnfermedades() {
        //Declaramos
        VEnfermedades vE;
        //Instanciamos la ventana
        vE = new VEnfermedades(vp, true, fa);
        //La hacemos visible
        vE.setVisible(true);
    }

/////////////////////////////
//VENTANA DE CONSULTAS
/////////////////////////////
    //Permite crear una nueva ventana de consultas
    public void nuevaVConsultas(Integer ambulatorio, java.util.List<Integer> restoConsultas) {
        //Declaramos
        VConsultas vC;
        //Instanciamos la ventana
        vC = new VConsultas(vp, true, fa, ambulatorio, restoConsultas);
        //La hacemos visible
        vC.setVisible(true);
    }

/////////////////////////////
//VENTANA DE RECETAS
/////////////////////////////
    //Permite crear una nueva ventana de recetas
    public void nuevaVRecetar(VCitasPendientes vcit, Cita cita) {
        //Declaramos
        VRecetar vR;
        //Instanciamos la ventana
        vR = new VRecetar(vcit, true, fa, cita);
        //La hacemos visible
        vR.setVisible(true);
    }

//////////////////////
//OTRAS VENTANAS
//////////////////////
    //Permite iniciar la vista de la aplicación
    public void nuevaVAutentificacion() {
        //Generamos una ventana de autentificación que permite ingresarse en la base de datos
        VAutentificacion va;
        va  = new VAutentificacion(vp, true, fa);
        //En caso de poder acceder entonces hacemos la ventana principal visible
        vp.setVisible(true);
        //Hacemos la ventana de autentificación invisible
        va.setVisible(true);
    }

    //Abre una ventana que muestra una excepción en pantalla
    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    //Abre una ventana que muestra un mensaje en pantalla
    public void muestraMensaje(String txtMensaje) {
        VMensaje va;

        va  = new VMensaje(vp, true, txtMensaje);
        va.setVisible(true);
    }
}

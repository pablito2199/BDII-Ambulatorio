package gui;

import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Cita;
import aplicacion.clases.Paciente;

public class FachadaGui {

    aplicacion.FachadaAplicacion fa;     // Enlace a la fachada de aplicación
    VPrincipal vp;                              // Enlace a la ventana principal de la aplicación

    //Constructor
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        //Se crea la ventana principal
        this.vp = new VPrincipal(fa);
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPacientes() {
        //Declaramos variables
        VPacientes vP;
        //Generamos la ventana
        vP = new VPacientes(vp, true, fa);
        //Hacemos visible la ventana
        vP.setVisible(true);
    }

////////////////////////////////
//VENTANA DE CITAS
////////////////////////////////
    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVReservarCita(Ambulatorio ambulatorio, Paciente paciente) {
        //Declaramos variables
        VReservarCita vRC;
        //Generamos la ventana
        vRC = new VReservarCita(vp, true, fa, ambulatorio, paciente);
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

    //Permite generar una ventana para escoger un paciente al que consultar sus citas pendientes
    public void nuevaVCitasPendientes(Paciente paciente) {
        //Declaramos variables
        VCitasPendientes vCP;
        //Generamos la ventana
        vCP = new nuevaVCitasPendientes(vp, true, fa, paciente);
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
    public void nuevaVUrgencias(Paciente paciente) {
        //Declaramos variables
        VUrgencias vU;
        //Generamos la ventana
        vU = new VUrgencias(vp, true, fa, paciente);
        //Hacemos visible la ventana
        vU.setVisible(true);
    }

////////////////////////////////
//VENTANA DE PACIENTES
////////////////////////////////
    //Permite generar una ventana para visualizar información de un paciente
    public void nuevaVPacientes() {
        //Declaramos variables
        VPacientes vP;
        //Generamos la ventana
        vP = new VPacientes(vp, true, fa);
        //Hacemos visible la ventana
        vP.setVisible(true);
    }

    //Permite generar una ventana para visualizar información sobre el historial médico del paciente
    public void nuevaVHistorialMedico() {
        //Declaramos variables
        VHistorialMedico vHM;
        //Generamos la ventana
        vHM = new VHistorialMedico(vp, true, fa);
        //Hacemos visible la ventana
        vHM.setVisible(true);
    }

    //Permite generar una ventana para visualizar información sobre el historial de recetas del paciente
    public void nuevaVHistorialRecetas() {
        //Declaramos variables
        VHistorialRecetas vHR;
        //Generamos la ventana
        vHR = new VHistorialRecetas(vp, true, fa);
        //Hacemos visible la ventana
        vHR.setVisible(true);
    }

    //Permite generar una ventana para visualizar la gestión de enfermedades de un paciente
    public void nuevaVGestionEnfermedades(VPacientes vpac, String cip, java.util.List<String> enfermedades, java.util.List<String> restoEnfermedades) {
        //Declaramos variables
        VGestionEnfermedades vGE;
        //Generamos la ventana
        vGE = new VGestionEnfermedades(vpac, true, fa, cip, enfermedades, restoEnfermedades);
        //Hacemos visible la ventana
        vGE.setVisible(true);
    }

/////////////////////////////
//VENTANA DE ENFERMEDADES
/////////////////////////////
    //Permite crear una nueva ventana de enfermedades
    public void nuevaVEnfermedades(java.util.List<String> enfermedades) {
        //Declaramos
        VEnfermedades vE;
        //Instanciamos la ventana
        vE = new VEnfermedades(vp, true, fa, enfermedades);
        //La hacemos visible
        vE.setVisible(true);
    }

/////////////////////////////
//VENTANA DE CONSULTAS
/////////////////////////////
    //Permite crear una nueva ventana de consultas
    public void nuevaVConsultas(java.util.List<Integer> consultas, Integer ambulatorio) {
        //Declaramos
        VConsultas vC;
        //Instanciamos la ventana
        vC = new VConsultas(vp, true, fa, consultas, ambulatorio);
        //La hacemos visible
        vC.setVisible(true);
    }

/////////////////////////////
//VENTANA DE RECETAS
/////////////////////////////
    //Permite crear una nueva ventana de recetas
    public void nuevaVRecetar(Cita cita) {
        //Declaramos
        VRecetar vR;
        //Instanciamos la ventana
        vR = new VRecetar(parent, true, fa, cita);
        //La hacemos visible
        vR.setVisible(true);
    }

//////////////////////
//OTRAS VENTANAS
//////////////////////
    //Abre la ventana de VAutentificación
    public void iniciaVista() {
        VAutentificacion va;

        va  = new VAutentificacion(vp, true, fa);
        //abre la ventana
        vp.setVisible(true);
        va.setVisible(true);
    }

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

    //abre una ventana que muestra una excepción en pantalla
    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }
}

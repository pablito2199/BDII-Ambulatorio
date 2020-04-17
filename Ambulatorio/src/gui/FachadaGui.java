package gui;

import aplicacion.Paciente;

public class FachadaGui {

    aplicacion.FachadaAplicacion fa;     // Enlace a la fachada de aplicación
    VPrincipal vp;                              // Enlace a la ventana principal de la aplicación

    //Constructor
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        //Se crea la ventana principal
        this.vp = new VPrincipal(fa);
    }

////////////////////////////////
//VENTANA DE CITAS
////////////////////////////////
    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVReservarCita() {
        //Declaramos variables
        VReservarCita vC;
        //Generamos la ventana
        vRC = new VReservarCita(vp, true, fa);
        //Hacemos visible la ventana
        vRC.setVisible(true);
    }

    //Permite generar una ventana para escoger un hospital al que derivar al paciente
    public void nuevaVDerivarHospital(Paciente paciente) {
        //Declaramos variables
        VCita vDH;
        //Generamos la ventana
        vDH = new VDerivarHospital(vp, true, fa, paciente);
        //Hacemos visible la ventana
        vDH.setVisible(true);
    }

    //Permite generar una ventana para escoger un paciente al que consultar sus consultas pendientes
    public void nuevaVCitasPendientes(Paciente paciente) {
        //Declaramos variables
        VCitasPendientes vCP;
        //Generamos la ventana
        vCP = new VCitas(vp, true, fa, paciente);
        //Hacemos visible la ventana
        vCP.setVisible(true);
    }


////////////////////////////////
//VENTANA DE PACIENTES
////////////////////////////////
    //Permite generar una ventana para visualizar información de una cita
    public void nuevaVPacientes() {
        //Declaramos variables
        VPaciente vP;
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
    public void nuevaVGestionarEnfermedades() {
        //Declaramos variables
        VGestionarEnfermedades vGE;
        //Generamos la ventana
        vGE = new VGestionarEnfermedades(vp, true, fa);
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
        vE = new VEnfermedades(parent, true, fa);
        //La hacemos visible
        vE.setVisible(true);
    }

/////////////////////////////
//VENTANA DE CONSULTAS
/////////////////////////////
    //Permite crear una nueva ventana de consultas
    public void nuevaVConsultas() {
        //Declaramos
        VConsulta vC;
        //Instanciamos la ventana
        vC = new VConsulta(parent, true, fa);
        //La hacemos visible
        vC.setVisible(true);
    }
    
    //Permite crear una nueva ventana de consultas
    public void nuevaVGestionarMedicos() {
        //Declaramos
        VGestionarMedicos vGM;
        //Instanciamos la ventana
        vGM = new VGestionarMedicos(parent, true, fa);
        //La hacemos visible
        vGM.setVisible(true);
    }

/////////////////////////////
//VENTANA DE RECETAS
/////////////////////////////
    //Permite crear una nueva ventana de préstamos
    public void nuevaVRecetar() {
        //Declaramos
        VRecetas vR;
        //Instanciamos la ventana
        vR = new VRecetas(parent, true, fa);
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
    
    //Permite generar una ventana que muestre excepciones
    public void nuevaVError(String mensajeError) {
        //Declaramos la ventana
        VMensaje vM;
        //Instanciamos
        vM  = new VMensaje(vp, true, mensajeError);
        //La hacemos visible
        vM.setVisible(true);
    }
}
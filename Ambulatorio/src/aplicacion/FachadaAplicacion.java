package aplicacion;

public class FachadaAplicacion {

    gui.FachadaGui fgui;                    // Enlace a la fachada de la GUI
    baseDatos.FachadaBaseDatos fbd;         // Enlace a la fachada de base de datos
    GestionAmbulatorios gamb;               // Enlace a la clase gestión de ambulatorio
    GestionCitas gcit;                      // Enlace a la clase gestión de citas
    GestionPacientes gpac;                  // Enlace a la clase gestión de pacientes
    GestionEnfermedades genf;               // Enlace a la clase gestión de enfermedades
    GestionConsultas gcon;                  // Enlace a la clase gestión de consultas
    GestionRecetas grec;                    // Enlace a la clase gestión de recetas

    //Constructor
    public FachadaAplicacion() {
        cgui = new gui.FachadaGui(this);
        cbd = new baseDatos.FachadaBaseDatos(this);
        ccit = new GestionAmbulatorios(fgui, fbd);
        ccit = new GestionCitas(fgui, fbd);
        cpac = new GestionPacientes(fgui, fbd);
        cenf = new GestionEnfermedades(fgui, fbd);
        cpac = new GestionConsultas(fgui, fbd);
        crec = new GestionRecetas(fgui, fbd);
    }

    //Main
    public static void main(String args[]) {
        FachadaAplicacion fa;                   //Declaramos la variable fachada
        fa = new FachadaAplicacion();       //La inicializamos
        fa.iniciaInterfazUsuario();              //LLamamos a la interfaz de usuario
    }

    //Llamada para mostrar una excepción
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

/////////////////////////
//GESTIÓN DE AMBULATORIOS
/////////////////////////

/////////////////////////
//GESTIÓN DE CITAS
/////////////////////////

/////////////////////////
//GESTIÓN DE PACIENTES
/////////////////////////

/////////////////////////
//GESTIÓN DE ENFERMEDADES
/////////////////////////

/////////////////////////
//GESTIÓN DE CONSULTAS
/////////////////////////

/////////////////////////
//GESTIÓN DE RECETAS
/////////////////////////
}
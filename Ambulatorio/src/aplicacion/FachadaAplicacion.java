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
    GestionAdministradores gadm;            // Enlace a la clase gestión de administradores

    //Constructor
    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gamb = new GestionAmbulatorios(fgui, fbd);
        gcit = new GestionCitas(fgui, fbd);
        gpac = new GestionPacientes(fgui, fbd);
        genf = new GestionEnfermedades(fgui, fbd);
        gpac = new GestionConsultas(fgui, fbd);
        grec = new GestionRecetas(fgui, fbd);
        gadm = new GestionAdministradores(fgui, fbd);
    }

    //Main
    public static void main(String args[]) {
        FachadaAplicacion fa;                   //Declaramos la variable fachada
        fa = new FachadaAplicacion();       //La inicializamos
        fa.iniciaInterfazAdministrador();              //LLamamos a la interfaz de usuario
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

/////////////////////////
//GESTIÓN DE CITAS
/////////////////////////

/////////////////////////
//GESTIÓN DE PACIENTES
/////////////////////////

/////////////////////////
//GESTIÓN DE ENFERMEDADES
/////////////////////////
public void anadirEnfermedad(Enfermedad enfermedad) {
    genf.anadirEnfermedad(enfermedad);
}

public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return genf.consultarEnfermedades(nombre);
    }

public void modificarEnfermedad(Enfermedad enfermedad) {
    genf.modificarEnfermedad(enfermedad);
}

public void borrarEnfermedad(String nombre) {
    genf.borrarEnfermedad(nombre);
}

/////////////////////////
//GESTIÓN DE CONSULTAS
/////////////////////////

/////////////////////////
//GESTIÓN DE RECETAS
/////////////////////////
}
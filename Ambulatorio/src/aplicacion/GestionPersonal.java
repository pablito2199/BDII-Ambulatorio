package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionPersonal {

    FachadaGui fgui;                //Enlace a la facha de la GUI
    FachadaBaseDatos fbd;       //Enlace a la facha de Base de datos

    //Constructor
    public GestionPersonal(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite abrir una nueva ventana de usuarios
    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    //Permite comprobar si el administrador que intenta acceder al programa tiene los credenciales necesarios
    public Boolean comprobarAutentificacion(String dni, String clave) {
        return fbd.validarAdministrador(dni, clave);
    }
    
    //Permite recuperar la especialidad de un personal sanitario
    public String obtenerEspecialidad(String dni){
        return fbd.obtenerEspecialidad(dni);
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPersonal() {
        fgui.nuevaVPersonal();
    }
}

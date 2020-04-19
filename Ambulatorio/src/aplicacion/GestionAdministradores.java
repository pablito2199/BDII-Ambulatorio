package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionAdministradores {

    FachadaGui fgui;                //Enlace a la facha de la GUI
    FachadaBaseDatos fbd;       //Enlace a la facha de Base de datos

    //Constructor
    public GestionAdministradores(FachadaGui fgui, FachadaBaseDatos fbd) {
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

    //Permite abrir una nueva ventana de usuarios
    public void accesoAdministrador() {
        fgui.nuevoAdministrador();
    }
}

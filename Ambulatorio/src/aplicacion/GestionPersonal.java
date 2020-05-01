package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

public class GestionPersonal {

    FachadaGui fgui;            //Enlace a la facha de la GUI
    FachadaBaseDatos fbd;       //Enlace a la facha de Base de datos

    //Constructor
    public GestionPersonal(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite comprobar si el administrador que intenta acceder al programa tiene los credenciales necesarios
    public Boolean comprobarAutentificacion(String dni, String clave) {
        return fbd.validarAdministrador(dni, clave);
    }

    //Permite recuperar la especialidad de un personal sanitario
    public ArrayList<String> obtenerEspecialidades(String dni, Integer ambulatorio) {
        return fbd.obtenerEspecialidades(dni, ambulatorio);
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPersonal() {
        fgui.nuevaVPersonal();
    }
}

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionPacientes {

    FachadaGui fgui;                //Enlace a la facha de la GUI
    FachadaBaseDatos fbd;       //Enlace a la facha de Base de datos

    //Constructor
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite abrir una nueva ventana de usuarios
    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    //Función que permite obtener un array de usuarios a partir de su id y/o nombre
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre) {
        return fbd.consultarUsuarios(id, nombre);
    }

    //Permite comprobar si el usuario que intenta acceder al programa tiene los credenciales necesarios
    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u;

        u = fbd.validarUsuario(idUsuario, clave);
        if (u != null) {
            return u.getTipoUsuario() == TipoUsuario.Administrador;
        } else {
            return false;
        }
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void nuevoUsuario(Usuario user) {
        fbd.insertarUsuario(user);
    }

    //Permite abrir una nueva ventana de usuarios
    public void accesoUsuarios() {
        fgui.nuevoUsuario();
    }

    //Permite modificar la unformación de un usuario
    public void actualizarUsuario(Usuario U) {
        fbd.modificarUsuario(U);

    }

    //Permite eliminar un usuario de la base de datos
    public void borrarUsuario(String idUsuario) {
        fbd.borrarUsuario(idUsuario);
    }

    //Permite saber si existe un usuario en la base de datos
    public boolean consultarUsuario(String id) {
        return fbd.consultarUsuario(id);
    }

    //Permite recuperar una lista de usuarios con información sobre sus préstamos vencidos
    public java.util.List<Usuario> consultarPUsuarios(String id, String nombre) {
        return fbd.consultarPUsuarios(id, nombre);
    }

}

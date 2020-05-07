package aplicacion;

import aplicacion.clases.PersonalSanitario;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

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

    //Permite buscar personal sanitario por su dni y nombre
    public java.util.List<PersonalSanitario> consultarPersonal(String dni, String nombre, Integer ambulatorio) {
        return fbd.consultarPersonal(dni, nombre, ambulatorio);
    }

    //Permite generar una ventana para visualizar información de un trabajador
    public void nuevaVPersonal(Integer ambulatorio) {
        fgui.nuevaVPersonal(ambulatorio);
    }
}

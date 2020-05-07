package aplicacion.clases;

import java.sql.Date;

public class PersonalAdministrador extends PersonalNoSanitario {

    private String contrasena;

    //Constructor
    public PersonalAdministrador(String contrasena, Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo, String antiguedad, String clase) {
        super(ambulatorio, dni, nombre, fechaIncorporacion, telefono, sueldo, antiguedad, clase);
        this.contrasena = contrasena;
    }

    public PersonalAdministrador(String contrasena, Integer ambulatorio, String DNI) {
        super(ambulatorio, DNI);
        this.contrasena = contrasena;
    }

    //Getters y Setters
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}

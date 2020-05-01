/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.clases;

import java.sql.Date;

public class PersonalAdministrador extends PersonalNoSanitario {

    private String contrasena;

    //Constructor
    public PersonalAdministrador(String contrasena, Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo, String clase) {
        super(ambulatorio, dni, nombre, fechaIncorporacion, telefono, sueldo, clase);
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

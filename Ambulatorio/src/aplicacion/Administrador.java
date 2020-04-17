/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

public class Administrador {
    private Integer ambulatorio;
    private String personal;
    private String contrasena;

    //Constructor
    public Administrador(Integer ambulatorio, String personal, String contrasena) {
        this.ambulatorio = ambulatorio;
        this.personal = personal;
        this.contrasena = contrasena;
    }

    //Getters y Setters
    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }    
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Administrador) {
            return ((Administrador) obj).getPersonal().equals(this.personal) && ((Administrador) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}
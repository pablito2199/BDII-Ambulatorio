/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.clases;

import java.sql.Date;

public class PersonalSanitario {

    private Integer ambulatorio;
    private String DNI;
    private String nombre;
    private Date fechaIncorporacion;
    private String telefono;
    private Float sueldo;

    public PersonalSanitario(Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo) {
        this.ambulatorio = ambulatorio;
        this.DNI = dni;
        this.nombre = nombre;
        this.fechaIncorporacion = fechaIncorporacion;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PersonalSanitario) {
            return ((PersonalSanitario) obj).getDNI().equals(this.DNI) && ((PersonalSanitario) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}

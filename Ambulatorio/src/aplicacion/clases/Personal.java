package aplicacion.clases;

import java.sql.Date;

public abstract class Personal {

    //////////////////////////////////////////////////
    //Atributos
    private Integer ambulatorio;
    private String DNI;
    private String nombre;
    private Date fechaIncorporacion;
    private String telefono;
    private Float sueldo;
    private String antiguedad;

    //////////////////////////////////////////////////
    //Constructores
    public Personal(Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo, String antiguedad) {
        this.ambulatorio = ambulatorio;
        this.DNI = dni;
        this.nombre = nombre;
        this.fechaIncorporacion = fechaIncorporacion;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }

    public Personal(Integer ambulatorio, String DNI) {
        this.ambulatorio = ambulatorio;
        this.DNI = DNI;
    }

    //////////////////////////////////////////////////
    //Getters y Setters
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

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    //////////////////////////////////////////////////
    //Sobreescribimos el método "equals"
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Personal) {
            return ((Personal) obj).getDNI().equals(this.DNI) && ((Personal) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}

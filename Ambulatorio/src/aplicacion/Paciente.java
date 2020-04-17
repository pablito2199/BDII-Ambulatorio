package aplicacion;

import java.sql.Date;


public class Paciente {
    private String CIP;
    private String DNI;
    private Integer NSS;    //NSS
    private String nombre;
    private java.sql.Date fechaNacimiento;
    private String sexo;
    private GrupoSangre grupo;
    private String nacionalidad;
    private String direccion;
    private String telefono;
    private Integer edad;

    //Constructor
    public Paciente(String CIP, String DNI, int NSS, String nombre, java.sql.Date fechaNacimiento, String sexo, GrupoSangre grupo, String nacionalidad, String direccion, String telefono) {
        this.CIP = CIP;
        this.DNI = DNI;
        this.NSS = NSS;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.grupo = grupo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Getters y Setters
    public String getCIP() {
        return CIP;
    }

    public void setCIP(String CIP) {
        this.CIP = CIP;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public GrupoSangre getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoSangre grupo) {
        this.grupo = grupo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Paciente) {
            return ((Paciente) obj).getCIP().equals(this.CIP);
        }
        return false;
    }
}

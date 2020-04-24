package aplicacion.clases;

import java.sql.Date;

public class Paciente {

    private String CIP;
    private String DNI;
    private Integer NSS;    //NSS
    private String nombre;
    private Date fechaNacimiento;
    private String sexo;
    private GrupoSanguineo grupo;
    private String nacionalidad;
    private String direccion;
    private String telefono;
    private Integer edad;
    private Rango rango;

    //Constructor
    public Paciente(String CIP, String DNI, Integer NSS, String nombre, Date fechaNacimiento, String sexo, GrupoSanguineo grupo, String nacionalidad, String direccion, String telefono) {
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

    //Constructor por si le quieres meter la edad
    public Paciente(String CIP, String DNI, int NSS, String nombre, Date fechaNacimiento, String sexo, GrupoSanguineo grupo, String nacionalidad, String direccion, String telefono, Integer edad, Rango rango) {
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
        this.edad = edad;
        this.rango = rango;
    }

    //Constructor solo para borrado
    public Paciente(String CIP) {
        this.CIP = CIP;
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

    public Integer getNSS() {
        return NSS;
    }

    public void setNSS(Integer NSS) {
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

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public GrupoSanguineo getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoSanguineo grupo) {
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

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Paciente) {
            return ((Paciente) obj).getCIP().equals(this.CIP);
        }
        return false;
    }
}

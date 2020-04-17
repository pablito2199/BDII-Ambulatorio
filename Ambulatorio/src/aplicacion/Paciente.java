package aplicacion;

import java.sql.Date;

/**
 *
 * @author Martín Suárez García
 */
public class Paciente {

    private String cip;
    private String dni;
    private Integer numSeguridadSocial;
    private String nombre;
    private Date fechaNacimiento;
    private String sexo;
    private GrupoSangre grupo;
    private String nacionalidad;
    private String direccion;
    private String telefono;

    //Constructor
    public Paciente(String cip, String dni, int numSeguridadSocial, String nombre, Date fechaNacimiento, String sexo, GrupoSangre grupo, String nacionalidad, String direccion, String telefono) {
        this.cip = cip;
        this.dni = dni;
        this.numSeguridadSocial = numSeguridadSocial;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.grupo = grupo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Getters y Setters
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(int numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Paciente) {
            return ((Paciente) obj).getCip().equals(this.cip);
        }
        return false;
    }
}

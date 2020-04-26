/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.clases;

import java.sql.Timestamp;

public class Urgencia extends Cita {

    private Float soborno;
    private Integer gravedad;
    private Integer prioridad;
    private String nombre;

    //Constructor
    public Urgencia(Float soborno, Integer gravedad, Integer prioridad, String nombrePaciente, Timestamp fechaHoraInicio, String paciente, Integer consulta, Integer ambulatorio) {
        super(fechaHoraInicio, paciente, consulta, ambulatorio, "Urgencia", "General");
        this.soborno = soborno;
        this.gravedad = gravedad;
        this.prioridad = prioridad;
        this.nombre = nombrePaciente;
    }

    public Urgencia(Float soborno, Integer gravedad, Integer prioridad, Timestamp fechaHoraInicio, String paciente, Integer consulta, Integer ambulatorio) {
        super(fechaHoraInicio, paciente, consulta, ambulatorio, "Urgencia", "General");
        this.soborno = soborno;
        this.gravedad = gravedad;
        this.prioridad = prioridad;
    }

    public Urgencia(Float soborno, Integer gravedad, Timestamp fechaHoraInicio, String paciente, Integer consulta, Integer ambulatorio) {
        super(fechaHoraInicio, paciente, consulta, ambulatorio, "Urgencia", "General");
        this.soborno = soborno;
        this.gravedad = gravedad;
    }

    //Getters y Setters
    public Float getSoborno() {
        return soborno;
    }

    public void setSoborno(Float soborno) {
        this.soborno = soborno;
    }

    public Integer getGravedad() {
        return gravedad;
    }

    public void setGravedad(Integer gravedad) {
        this.gravedad = gravedad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

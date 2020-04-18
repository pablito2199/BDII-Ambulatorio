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
    
    //Constructor
    public Urgencia(Float soborno, Integer gravedad, Integer prioridad, Timestamp fechaHoraInicio, Timestamp fechaHoraFin, String paciente, Integer consulta, Integer ambulatorio, String tipo, String especialidad) {
        super(fechaHoraInicio, fechaHoraFin, paciente, consulta, ambulatorio, tipo, especialidad);
        this.soborno = soborno;
        this.gravedad = gravedad;
        this.prioridad = prioridad;
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import java.sql.Timestamp;

public class Urgencia extends Cita {

    private Float soborno;
    private Integer gravedad;
    
    //Constructor
    public Urgencia(Float soborno, Integer gravedad, Timestamp fechaHoraInicio, Timestamp fechaHoraFin, String paciente, Integer consulta, Integer ambulatorio, String tipo, String especialidad) {
        super(fechaHoraInicio, fechaHoraFin, paciente, consulta, ambulatorio, tipo, especialidad);
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
}

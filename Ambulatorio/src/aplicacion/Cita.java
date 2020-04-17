package aplicacion;

import java.sql.Timestamp;

/**
 *
 * @author Martín Suárez García
 */
public class Cita {

    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;
    private String paciente;
    private Integer consulta;
    private Integer ambulatorio;
    private String tipo;
    private String especialidad;

    //Constructor
    public Cita(Timestamp fechaHoraInicio, Timestamp fechaHoraFin, String paciente, Integer consulta, Integer ambulatorio, String tipo, String especialidad) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.paciente = paciente;
        this.consulta = consulta;
        this.ambulatorio = ambulatorio;
        this.tipo = tipo;
        this.especialidad = especialidad;
    }

    //Getters y Setters
    public Timestamp getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Timestamp getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Timestamp fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Integer getConsulta() {
        return consulta;
    }

    public void setConsulta(Integer consulta) {
        this.consulta = consulta;
    }

    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cita) {
            return ((Cita) obj).getFechaHoraInicio().equals(this.fechaHoraInicio)
                    && ((Cita) obj).getPaciente().equals(this.paciente)
                    && ((Cita) obj).getAmbulatorio().equals(this.ambulatorio)
                    && ((Cita) obj).getConsulta().equals(this.consulta);
        }
        return false;
    }
}

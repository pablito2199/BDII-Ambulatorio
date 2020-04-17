package aplicacion;

import java.sql.Timestamp;
import java.sql.Date;

/**
 *
 * @author Martín Suárez García
 */
public class Receta {
    private Timestamp cita;
    private String paciente;
    private Integer consulta;
    private Integer ambulatorio;
    private Integer codigo;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    
    //Constructor
    public Receta(Timestamp cita, String paciente, Integer consulta, Integer ambulatorio, Integer codigo, String descripcion, Date fechaInicio, Date fechaFin) {
        this.cita = cita;
        this.paciente = paciente;
        this.consulta = consulta;
        this.ambulatorio = ambulatorio;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
        
    //Getters y Setters
    public Timestamp getCita() {
        return cita;
    }

    public void setCita(Timestamp cita) {
        this.cita = cita;
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Receta) {
            return ((Receta) obj).getCita().equals(this.cita)
                    && ((Receta) obj).getPaciente().equals(this.paciente)
                    && ((Receta) obj).getAmbulatorio().equals(this.ambulatorio)
                    && ((Receta) obj).getConsulta().equals(this.consulta)
                    && ((Receta) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}

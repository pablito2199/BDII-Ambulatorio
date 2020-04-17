package aplicacion;

import java.sql.Date;

/**
 *
 * @author Martín Suárez García
 */
public class Subvencion {

    private Integer codigo;
    private Integer ambulatorio;
    private Date fecha;
    private Float cantidad;
    private String motivo;

    //Constructor
    public Subvencion(Integer codigo, Integer ambulatorio, Date fecha, Float cantidad, String motivo) {
        this.codigo = codigo;
        this.ambulatorio = ambulatorio;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    //Getters y Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subvencion) {
            return ((Subvencion) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}

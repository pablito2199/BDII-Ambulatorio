package aplicacion;

import java.sql.Date;

/**
 *
 * @author Martín Suárez García
 */
public class Material {

    private Integer codigo;
    private String tipo;
    private Integer ambulatorio;
    private String descripcion;
    private Float coste;
    private Date fechaCompra;

    //Constructor
    public Material(Integer codigo, String tipo, Integer ambulatorio, String descripcion, Float coste, Date fechaCompra) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.ambulatorio = ambulatorio;
        this.descripcion = descripcion;
        this.coste = coste;
        this.fechaCompra = fechaCompra;
    }

    //Setters y Getters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getCoste() {
        return coste;
    }

    public void setCoste(Float coste) {
        this.coste = coste;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Material) {
            return ((Material) obj).getCodigo().equals(this.codigo) && ((Material) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}

package aplicacion;

import java.sql.Date;

public class Donativo {

    private Integer codigo;
    private Integer ambulatorio;
    private Date fecha;
    private Float cantidad;
    private String donante;

    //Constructor
    public Donativo(Integer codigo, Integer ambulatorio, Date fecha, Float cantidad, String motivo) {
        this.codigo = codigo;
        this.ambulatorio = ambulatorio;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.donante = motivo;
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

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donativo) {
            return ((Donativo) obj).getCodigo().equals(this.codigo) && ((Donativo) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}

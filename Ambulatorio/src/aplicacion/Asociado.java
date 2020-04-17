package aplicacion;

/**
 *
 * @author Martín Suárez García
 */
public class Asociado {

    private Integer ambulatorio;
    private Integer hospital;
    private Float distancia;

    //Constructor
    public Asociado(Integer ambulatorio, Integer hospital, Float distancia) {
        this.ambulatorio = ambulatorio;
        this.hospital = hospital;
        this.distancia = distancia;
    }

    //Getters y Setters
    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public Integer getHospital() {
        return hospital;
    }

    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Asociado) {
            return ((Asociado) obj).getAmbulatorio().equals(this.ambulatorio) && ((Asociado) obj).getHospital().equals(this.hospital);
        }
        return false;
    }
}

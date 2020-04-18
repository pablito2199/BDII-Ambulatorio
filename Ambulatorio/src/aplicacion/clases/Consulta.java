package aplicacion.clases;

public class Consulta {

    private Integer identificador;
    private Integer ambulatorio;
    private String especialidad;

    //Constructor
    public Consulta(Integer identificador, Integer ambulatorio, String especialidad) {
        this.identificador = identificador;
        this.ambulatorio = ambulatorio;
        this.especialidad = especialidad;
    }

    //Getters y Setters
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(Integer ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Consulta) {
            return ((Consulta) obj).getIdentificador().equals(this.identificador) && ((Consulta) obj).getAmbulatorio().equals(this.ambulatorio);
        }
        return false;
    }
}

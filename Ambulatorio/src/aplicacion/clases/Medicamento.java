package aplicacion.clases;

public class Medicamento {

    private String nombre;
    private String prospecto;

    //Constructor
    public Medicamento(String nombre, String prospecto) {
        this.nombre = nombre;
        this.prospecto = prospecto;
    }

    //Constructor para búsquedas en Recetas
    public Medicamento(String nombre) {
        this.nombre = nombre;
        prospecto = "No disponible en estos momentos";
    }

    //Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProspecto() {
        return prospecto;
    }

    public void setProspecto(String prospecto) {
        this.prospecto = prospecto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Medicamento) {
            return ((Medicamento) obj).getNombre().equals(this.nombre) && ((Medicamento) obj).getProspecto().equals(this.prospecto);
        }
        return false;
    }
}

package aplicacion.clases;

public class TipoCita {

    //////////////////////////////////////////////////
    //Atributos
    private String nombre;
    private String especialidad;
    private String descripcion;

    //////////////////////////////////////////////////
    //Constructor
    public TipoCita(String nombre, String especialidad, String descripcion) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

    //////////////////////////////////////////////////
    //Getters y Setters
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //////////////////////////////////////////////////
    //Sobreescribimos el método "equals"
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoCita) {
            return ((TipoCita) obj).getNombre().equals(this.nombre) && ((TipoCita) obj).getEspecialidad().equals(this.especialidad);
        }
        return false;
    }
}

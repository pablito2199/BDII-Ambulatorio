package aplicacion.clases;

public class Enfermedad {

    //////////////////////////////////////////////////
    //Atributos
    private String nombre;
    private String descripcion;

    //////////////////////////////////////////////////
    //Constructor
    public Enfermedad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //////////////////////////////////////////////////
    //Setters y gettees
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (obj instanceof Enfermedad) {
            return ((Enfermedad) obj).getNombre().equals(this.nombre);
        }
        return false;
    }
}

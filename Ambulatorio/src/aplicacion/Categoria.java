package aplicacion;

/**
 *
 * @author basesdatos
 */
public class Categoria {

    private final String nombre;          //Nombre de la categoría
    private final String descripcion;     //Descripción de la categoría

    //Constructor
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}

package aplicacion;

/**
 *
 * @author Martín Suárez García
 */
public class Hospital {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String provincia;

    //Constructor
    public Hospital(Integer codigo, String nombre, String direccion, String telefono, String provincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.provincia = provincia;
    }

    //Getters y Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hospital) {
            return ((Hospital) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}

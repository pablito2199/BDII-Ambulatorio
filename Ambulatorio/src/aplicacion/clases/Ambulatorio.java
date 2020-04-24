
package aplicacion.clases;

public class Ambulatorio {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private String anoConstruccion;
    private String provicia;
    private String telefono;
    private String antiguedad;
    private Double ingresos;

    //Constructor

    public Ambulatorio(Integer codigo, String nombre, String direccion, String anoConstruccion, String provicia, String telefono, String antiguedad, Double ingresos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provicia = provicia;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.ingresos = ingresos;
    }

    public Ambulatorio(Integer codigo, String nombre, String direccion, String anoConstruccion, String provicia, String telefono, String antiguedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provicia = provicia;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.ingresos = 0.0;
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

    public String getAnoConstruccion() {
        return anoConstruccion;
    }

    public void setAnoConstruccion(String anoConstruccion) {
        this.anoConstruccion = anoConstruccion;
    }

    public String getProvicia() {
        return provicia;
    }

    public void setProvicia(String provicia) {
        this.provicia = provicia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Double getIngresos() {
        return ingresos;
    }

    public void setIngresos(Double ingresos) {
        this.ingresos = ingresos;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ambulatorio) {
            return ((Ambulatorio) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}
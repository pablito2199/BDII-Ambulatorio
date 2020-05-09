package aplicacion.clases;

import java.util.Objects;

public class Ambulatorio {

    //////////////////////////////////////////////////
    //Atributos
    private Integer codigo;
    private String nombre;
    private String direccion;
    private String anoConstruccion;
    private String provincia;
    private String telefono;
    private String antiguedad;
    private Double ingresos;

    //////////////////////////////////////////////////
    //Constructores
    public Ambulatorio(Integer codigo, String nombre, String direccion, String anoConstruccion, String provincia, String telefono, String antiguedad, Double ingresos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.ingresos = ingresos;
    }

    public Ambulatorio(Integer codigo, String nombre, String direccion, String anoConstruccion, String provincia, String telefono, String antiguedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
        this.ingresos = 0.0;
    }

    public Ambulatorio(String nombre, String direccion, String anoConstruccion, String provincia, String telefono, String antiguedad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provincia = provincia;
        this.telefono = telefono;
        this.antiguedad = antiguedad;
    }

    public Ambulatorio(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    //////////////////////////////////////////////////
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    //////////////////////////////////////////////////
    //Sobreescribimos el método "equals"
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ambulatorio) {
            return ((Ambulatorio) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}

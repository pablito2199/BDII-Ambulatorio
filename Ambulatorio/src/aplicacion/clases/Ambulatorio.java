/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.clases;

import java.time.Year;

public class Ambulatorio {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private Year anoConstruccion;
    private String provicia;
    private String telefono;

    //Constructor
    public Ambulatorio(Integer codigo, String nombre, String direccion, Year anoConstruccion, String provicia, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anoConstruccion = anoConstruccion;
        this.provicia = provicia;
        this.telefono = telefono;
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

    public Year getAnoConstruccion() {
        return anoConstruccion;
    }

    public void setAnoConstruccion(Year anoConstruccion) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ambulatorio) {
            return ((Ambulatorio) obj).getCodigo().equals(this.codigo);
        }
        return false;
    }
}

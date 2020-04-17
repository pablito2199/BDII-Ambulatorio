package aplicacion;

import java.sql.Date;

/**
 *
 * @author basesdatos
 */
public class Ejemplar {

    private final Integer numEjemplar;    //Número del ejemplar. Único para cada ejermplar de un libro
    private String localizador;               //Id del lugar donde se almacena el ejemplar 
    private String anoCompra;              //Año en el que se compró el ejemplar
    private final Libro libro;                  //Libro correspondiente

    //Atributos añadidos 
    private java.sql.Date fechaPrestamo;         //Fecha en la que se prestó el ejemplar
    private java.sql.Date fechaVencimiento;     //Fecha en la que vence el préstamo
    private String id_usuario;                         //Id del usuario que tiene el ejemplar prestado

    //Constructores
    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra) {
        this.numEjemplar = numEjemplar;
        this.anoCompra = anoCompra;
        this.localizador = localizador;
        this.libro = libro;
    }

    //Función que permite sumar X días a una fecha
    public static Date addDays(Date date, int days) {
        //Se crea un calendario
        java.util.Calendar c = java.util.Calendar.getInstance();
        //Se establece la fecha
        c.setTime(date);
        //Añadimos los días a la fecha
        c.add(java.util.Calendar.DATE, days);
        //Se devuelve la fecha resultante
        return new Date(c.getTimeInMillis());
    }

    //Getters (permiten recuperar datos)
    public Integer getNumEjemplar() {
        return this.numEjemplar;
    }

    public String getAnoCompra() {
        return this.anoCompra;
    }

    public String getLocalizador() {
        return this.localizador;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    //Setters (permiten sobreescribir datos)
    public void setLocalizador(String l) {
        localizador = l;
    }

    public void setAnoCompra(String a) {
        anoCompra = a;
    }

    public void setPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = Ejemplar.addDays(fechaPrestamo, 30);
    }

    public void setUsuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return id_usuario;
    }

}

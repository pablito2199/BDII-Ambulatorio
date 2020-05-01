package aplicacion.clases;

import java.sql.Date;

public class PersonalNoSanitario extends Personal {

    private String clase;

    //Constructor
    public PersonalNoSanitario(Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo, String clase) {
        super(ambulatorio, dni, nombre, fechaIncorporacion, telefono, sueldo);
        this.clase = clase;
    }

    public PersonalNoSanitario(Integer ambulatorio, String DNI) {
        super(ambulatorio, DNI);
    }

    //Getters y Setters
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}

package aplicacion.clases;

import java.sql.Date;

public final class PersonalSanitario extends Personal {

    //Constructor
    public PersonalSanitario(Integer ambulatorio, String dni, String nombre, Date fechaIncorporacion, String telefono, Float sueldo) {
        super(ambulatorio, dni, nombre, fechaIncorporacion, telefono, sueldo);
    }

    public PersonalSanitario(Integer ambulatorio, String DNI) {
        super(ambulatorio, DNI);
    }

}

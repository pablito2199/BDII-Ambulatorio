package aplicacion.clases;


public enum Rango {
    BASE("base"), PREMIUM("premiun"), DELUXE("deluxe");

    private String tipo;

    private Rango(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    //Permite obtener un GrupoSangre a partir de un String
    //En caso de no ser válido devuelve un nulo.
    public static Rango getTipo(String tipo) {
        Rango temp;
        switch (tipo) {
                case "deluxe":
                temp = DELUXE;
                break;
            case "premium":
                temp = PREMIUM;
                break;
            default:
                temp = BASE;
                break;
        }

        return temp;
    }
}

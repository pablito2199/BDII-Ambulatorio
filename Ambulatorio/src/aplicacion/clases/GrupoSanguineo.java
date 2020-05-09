package aplicacion.clases;

public enum GrupoSanguineo {

    //////////////////////////////////////////////////
    //Valores
    NZERO("0-"), PZERO("0+"), NA("A-"), PA("A+"), NB("B-"), PB("B+"), NAB("AB-"), PAB("AB+");

    //////////////////////////////////////////////////
    //Atributos
    private final String tipo;

    //////////////////////////////////////////////////
    //Métodos
    private GrupoSanguineo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    //Permite obtener un GrupoSangre a partir de un String
    //En caso de no ser válido devuelve un nulo.
    public static GrupoSanguineo getTipo(String tipo) {

        GrupoSanguineo temp = null;

        switch (tipo) {

            case "0-":
                temp = NZERO;
                break;
            case "A-":
                temp = NA;
                break;
            case "A+":
                temp = PA;
                break;
            case "B-":
                temp = NB;
                break;
            case "B+":
                temp = PB;
                break;
            case "AB-":
                temp = NAB;
                break;
            case "AB+":
                temp = PAB;
                break;
            case "0+":
                temp = PZERO;
                break;
        }

        return temp;
    }
}

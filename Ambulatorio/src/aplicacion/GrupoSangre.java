package aplicacion;

public enum GrupoSangre {

    NZERO("0-"), PZERO("0+"), NA("A-"), PA("A+"), NB("B-"), PB("B+"), NAB("AB-"), PAB("AB+");

    private String tipo;

    private GrupoSangre(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public GrupoSangre getTipo(String tipo) {

        GrupoSangre temp = null;

        switch (tipo) {

            case "0-":
                temp = NZERO;
                break;
            case "0+":
                temp = PZERO;
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
        }

        return temp;
    }
}

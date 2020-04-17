package aplicacion;

/**
 *
 * @author Martín Suárez García
 */
public enum GrupoSangre {
    
    NZERO("0-"), PZERO("0+"), NA("A-"), PA("A+"), NB("B-"), PB("B+"), NAB("AB-"), PAB("AB+");

    private String tipo;
    
    private GrupoSangre(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}


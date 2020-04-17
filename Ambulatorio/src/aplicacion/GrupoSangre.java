/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


package gui;

import aplicacion.Ejemplar;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaEjemplares extends AbstractTableModel {

    private java.util.List<Ejemplar> ejemplares;    //Listado de ejemplares

    //Constructor
    public ModeloTablaEjemplares(aplicacion.FachadaAplicacion fa) {
        this.ejemplares = new java.util.ArrayList<Ejemplar>();
    }

    //Recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 6;
    }

    //Recuperar el número de filas
    @Override
    public int getRowCount() {
        return ejemplares.size();
    }

    //Recuperar el nombre de la columna especificada
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera columna es el ID del ejemplar
            case 0:
                nombre = "Id";
                break;
            //La segunda, el localizador del ejemplar
            case 1:
                nombre = "Localizador";
                break;
            //La tercera columna es el año de compra
            case 2:
                nombre = "Año de compra";
                break;
            //La cuarta el usuario que tiene el ejemplar prestado
            case 3:
                nombre = "Usuario";
                break;
            //La quinta es la fecha en la que se emitió el préstamo
            case 4:
                nombre = "Fecha";
                break;
            //La sexta y última la fecha de vencimiento del préstamo
            case 5:
                nombre = "Vencimiento";
                break;
        }
        //Devolvemos el nombre de la columna
        return nombre;
    }

    //Permite obtener el tipo de elemento que contiene la columna
    @Override
    public Class getColumnClass(int col) {
        Class clase = null;
        switch (col) {
            //El ID es un Integer
            case 0:
                clase = java.lang.Integer.class;
                break;
            //El localizador un String
            case 1:
                clase = java.lang.String.class;
                break;
            //El año de compra un String
            case 2:
                clase = java.lang.String.class;
                break;
            //El usuario un string
            case 3:
                clase = java.lang.String.class;
                break;
            //La fecha de préstamo un Date
            case 4:
                clase = java.sql.Date.class;
                break;
            //La fecha de vencimiento un Date
            case 5:
                clase = java.sql.Date.class;
                break;
        }
        //Devolvemos la clase
        return clase;
    }

    //Permite saber si una columna es o no modificable
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso solo las columnas 1 y 2 lo son. El resto no.
        return col > 0 && col < 3;
    }

    //Permite recuperar el valor de la fila y columna especificados
    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        switch (col) {
            //La primera columna regresa el número de ejemplar (ID)
            case 0:
                resultado = ejemplares.get(row).getNumEjemplar();
                break;
            //La segunda el localizador
            case 1:
                resultado = ejemplares.get(row).getLocalizador();
                break;
            //La tercera el año
            case 2:
                resultado = ejemplares.get(row).getAnoCompra();
                break;
            //La cuarta el usuario asociado (en caso de haberlo)
            //De no existir se regresa un nulo
            case 3:
                resultado = (ejemplares.get(row)).getUsuario();
                break;
            //La quinta la fecha de préstamo
            case 4:
                resultado = (ejemplares.get(row)).getFechaPrestamo();
                break;
            //La sexta y última, la fecha de vencimiento
            case 5:
                resultado = (ejemplares.get(row)).getFechaVencimiento();
                break;
        }
        //Regresamos el valor recuperado de la tabla
        return resultado;
    }

    //Modificar el valor en la fila y columan especificados
    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            //Como solo son modificables la segunda (case 1) columna y la tercera (case 2)
            //Modificamos el localizador
            case 1:
                ejemplares.get(row).setLocalizador((String) v);
                break;
            //O modificamos el año de compra
            case 2:
                ejemplares.get(row).setAnoCompra((String) v);
                break;
            //En otro caso no hace nada
        }
    }

    //Permite sobreescribir los datos de ejemplares que ya teníamos
    public void setFilas(java.util.List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
        //Función que notifica a los listeners que los valores de la celda han cambiado
        fireTableDataChanged(); 
    }

    //Permite añadir un nuevo ejemplar a la tabla
    public void nuevoEjemplar(Ejemplar e) {
        this.ejemplares.add(e);
        //Función que notifica a los listeners que se insertó una fila en la tabla
        fireTableRowsInserted(this.ejemplares.size() - 1, this.ejemplares.size() - 1);
    }

    //Permite borra el ejemplar de la tabla
    public void borrarEjemplar(int indice) {
        this.ejemplares.remove(indice);
        //Función que notifica a los listeners que se eliminó una fila de la tabla
        fireTableRowsDeleted(indice, indice);
    }

    //Permite obtener la lista de todos los ejemplares de la tabla
    public java.util.List<Ejemplar> getFilas() {
        return this.ejemplares;
    }

    //Permite recuperar el ejemplar i de la lista de ejemplares de la tabla
    public Ejemplar obtenerEjemplar(int i) {
        return this.ejemplares.get(i);
    }
}

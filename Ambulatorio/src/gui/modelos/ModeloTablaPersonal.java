package gui.modelos;

import aplicacion.clases.PersonalSanitario;
import javax.swing.table.*;

public class ModeloTablaPersonal extends AbstractTableModel {

    private java.util.List<PersonalSanitario> personal;   //Listado del personal de la tabla

    //Constructor
    public ModeloTablaPersonal() {
        this.personal = new java.util.ArrayList<>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 5;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return personal.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera columna es el DNI  del trabajador
            case 0:
                nombre = "DNI";
                break;
            //La segunda el nombre
            case 1:
                nombre = "Nombre";
                break;
            //La tercera el tipo
            case 2:
                nombre = "Tipo";
                break;
            //La cuarta la clase
            case 3:
                nombre = "Clase";
                break;
            //La quinta es el teléfono
            case 4:
                nombre = "Teléfono";
                break;
        }
        //Devolvemos el nombre de la columna
        return nombre;
    }

    //Permite recuperar la clase o tipo de elementos de una columna
    @Override
    public Class getColumnClass(int col) {
        Class clase = null;
        switch (col) {
            //El DNI es un String
            case 0:
                clase = java.lang.String.class;
                break;
            //El nombre es un String
            case 1:
                clase = java.lang.String.class;
                break;
            //El tipo es un String
            case 2:
                clase = java.lang.String.class;
                break;
            //La clase es un String
            case 3:
                clase = java.lang.String.class;
                break;
            //El teléfono es un String
            case 4:
                clase = java.lang.String.class;
                break;
        }
        //Devolvemos el tipo especificado
        return clase;
    }

    //Permite saber si la celda es o no editable
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso ninguna es editable
        return false;
    }

    //Permite recuperar el valor de la celda especificada
    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            //Permite recuperar el DNI
            case 0:
                resultado = personal.get(row).getDNI();
                break;
            //Permite recuperar el nombre
            case 1:
                resultado = personal.get(row).getNombre();
                break;
            //Permite recuperar el tipo
            case 2:
                resultado = "Sanitario";
                break;
            //Permite recuperar la clase del trabajador
            case 3:
                resultado = "Sanitario";
                break;
            //Permite recuperar el teléfono
            case 4:
                resultado = personal.get(row).getTelefono();
                break;
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<PersonalSanitario> personal) {
        this.personal = personal;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar un usuario determinado
    public PersonalSanitario obtenerPersonal(int i) {
        return this.personal.get(i);
    }

}

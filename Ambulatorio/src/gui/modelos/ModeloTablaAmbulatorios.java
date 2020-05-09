package gui.modelos;

import aplicacion.clases.Ambulatorio;
import javax.swing.table.*;

public class ModeloTablaAmbulatorios extends AbstractTableModel {

    private java.util.List<Ambulatorio> ambulatorios;       //Listado de ambulatorios de la tabla

    //Constructor
    public ModeloTablaAmbulatorios() {
        this.ambulatorios = new java.util.ArrayList<>();
    }

    //Permite obtener el número de columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Permite obtener el número de filas de la tabla
    @Override
    public int getRowCount() {
        return ambulatorios.size();
    }

    //Permite obtener el nombre de las columnas de la tabla
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera es el código del ambulatorio
            case 0:
                nombre = "Código";
                break;
            //La segunda el nombre
            case 1:
                nombre = "Nombre";
                break;
            //La tercera la provincia
            case 2:
                nombre = "Provincia";
                break;
            //La cuarta el teléfono
            case 3:
                nombre = "Teléfono";
                break;
            //La quinta el año de publicación
        }
        //Regresamos el nombre de la columna correspondiente
        return nombre;
    }

    //Permite obtener la clase de elemento que hay en la columna
    @Override
    public Class getColumnClass(int col) {
        Class clase = null;
        switch (col) {
            //El código es un Integer
            case 0:
                clase = java.lang.Integer.class;
                break;
            //El nombre es un String
            case 1:
                clase = java.lang.String.class;
                break;
            //La provincia es un String
            case 2:
                clase = java.lang.String.class;
                break;
            //El teléfono es un String  
            case 3:
                clase = java.lang.String.class;
                break;
        }
        //Regresamos la clase
        return clase;
    }

    //Permite saber si la celda especificada es editable
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso ninguna es editable
        return false;
    }

    //Permite obtener el valor de la celda especificada
    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        switch (col) {
            //En la primera columna recuperamos el código del ambulatorio
            case 0:
                resultado = ambulatorios.get(row).getCodigo();
                break;
            //Recuperamos el nombre del ambulatorio
            case 1:
                resultado = ambulatorios.get(row).getNombre();
                break;
            //Recuperamos la provincia del ambulatorio
            case 2:
                resultado = ambulatorios.get(row).getProvincia();
                break;
            //Recuperamos el teléfono del ambulatorio
            case 3:
                resultado = ambulatorios.get(row).getTelefono();
                break;
        }
        //Devolvemos el resultado
        return resultado;
    }

    //Permite cambiar las filas de la tabla
    public void setFilas(java.util.List<Ambulatorio> ambulatorios) {
        this.ambulatorios = ambulatorios;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar el ambulatorio especificado
    public Ambulatorio obtenerAmbulatorio(int i) {
        return this.ambulatorios.get(i);
    }
}

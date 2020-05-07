package gui;

import aplicacion.clases.Cita;
import javax.swing.table.*;

public class ModeloTablaCitas extends AbstractTableModel {

    private java.util.List<Cita> citas;   //Listado de usuarios de la tabla

    //Constructor
    public ModeloTablaCitas() {
        this.citas = new java.util.ArrayList<>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return citas.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //Timestamp de la cita
            case 0:
                nombre = "Fecha y Hora";
                break;
            //Ambulatorio de la cita
            case 1:
                nombre = "Ambulatorio";
                break;
            //Consulta de la cita
            case 2:
                nombre = "Consulta";
                break;
            //Tipo de la cita
            case 3:
                nombre = "Tipo";
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
            //Fecha y Hora lo mostramos como un String
            case 0:
                clase = java.lang.String.class;
                break;
            //Ambulatorio es un Integer
            case 1:
                clase = java.lang.Integer.class;
                break;
            //Consulta es un Integer
            case 2:
                clase = java.lang.Integer.class;
                break;
            //Tipo es un string
            case 3:
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
            //Permite recuperar la fecha y hora de inicio
            case 0:
                resultado = citas.get(row).getFechaHoraInicio().toString();
                break;
            //Permite recuperar el ambulatorio
            case 1:
                resultado = citas.get(row).getAmbulatorio();
                break;
            //Permite recuperar la consulta
            case 2:
                resultado = citas.get(row).getConsulta();
                break;
            //Permite recuperar el tipo
            case 3:
                resultado = citas.get(row).getTipo() + "-" + citas.get(row).getEspecialidad();
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<Cita> citas) {
        this.citas = citas;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar la cita
    public Cita obtenerCita(int i) {

        //Obtenemos cita
        Cita c = this.citas.get(i);

        return c;
    }

    //Permite recuperar la cita
    public void quitarCita(int i) {

        //Eliminamos cita
        this.citas.remove(i);
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }
}

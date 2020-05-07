package gui;

import aplicacion.clases.Cita;
import javax.swing.table.*;

public class ModeloTablaHistorialMedico extends AbstractTableModel {

    private java.util.List<Cita> citas;   //Listado de pacientes de la tabla

    //Constructor
    public ModeloTablaHistorialMedico() {
        this.citas = new java.util.ArrayList<Cita>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 5;
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
            //La primera columna es la fecha inicio de la receta
            case 0:
                nombre = "Fecha Inicio";
                break;
            //La segunda es la fecha de fin de la misma
            case 1:
                nombre = "Fecha Fin";
                break;
            //La tercera el código del ambulatorio
            case 2:
                nombre = "Ambulatorio";
                break;
            //La cuarta el código de la consulta
            case 3:
                nombre = "Consulta";
                break;
            //La quinta es el tipo de cita
            case 4:
                nombre = "Tipo de cita";
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
            //Fecha Inicio es una fecha
            case 0:
                clase = java.lang.String.class;
                break;
            //Fecha Fin es una fecha
            case 1:
                clase =  java.lang.String.class;
                break;
            //Número receta es un Integer
            case 2:
                clase = java.lang.Integer.class;
                break;
            //Medicamento es un String
            case 3:
                clase = java.lang.Integer.class;
                break;
            //Cantidad es un Integer
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
            //Permite recuperar fecha inicio
            case 0:
                resultado = citas.get(row).getFechaHoraInicio().toString();
                break;
            //Permite recuperar fecha fin
            case 1:
                resultado = citas.get(row).getFechaHoraFin().toString();
                break;
            //Permite recuperar el código del ambulatorio
            case 2:
                resultado = citas.get(row).getAmbulatorio();
                break;
            //Permite recuperar el código de la consulta
            case 3:
                resultado = citas.get(row).getConsulta();
                break;
            //Permite recuperar el tipo de cita
            case 4:
                resultado = citas.get(row).getTipo() + " - " + citas.get(row).getEspecialidad();
                break;
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

    //Permite recuperar un usuario determinado
    public Cita obtenerPaciente(int i) {
        return this.citas.get(i);
    }

}

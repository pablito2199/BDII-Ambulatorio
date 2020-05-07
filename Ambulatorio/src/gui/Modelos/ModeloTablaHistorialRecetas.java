package gui.Modelos;

import aplicacion.clases.Receta;
import javax.swing.table.*;

public class ModeloTablaHistorialRecetas extends AbstractTableModel {

    private java.util.List<Receta> recetas;   //Listado de pacientes de la tabla

    //Constructor
    public ModeloTablaHistorialRecetas() {
        this.recetas = new java.util.ArrayList<Receta>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 5;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return recetas.size();
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
            //La tercera el número de la receta
            case 2:
                nombre = "Número receta";
                break;
            //La cuarta el medicamento
            case 3:
                nombre = "Medicamento";
                break;
            //La quinta es la cantidad
            case 4:
                nombre = "Cantidad";
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
                clase = java.sql.Date.class;
                break;
            //Fecha Fin es una fecha
            case 1:
                clase = java.sql.Date.class;
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
                resultado = recetas.get(row).getFechaInicio();
                break;
            //Permite recuperar fecha fin
            case 1:
                resultado = recetas.get(row).getFechaFin();
                break;
            //Permite recuperar número (código) receta
            case 2:
                resultado = recetas.get(row).getCodigo();
                break;
            //Permite recuperar el nombre del medicamento recetado
            case 3:
                resultado = recetas.get(row).getMedicamento();
                break;
            //Permite recuperar la cantidad del medicamento
            case 4:
                resultado = recetas.get(row).getCantidad();
                break;
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<Receta> recetas) {
        this.recetas = recetas;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar un usuario determinado
    public Receta obtenerPaciente(int i) {
        return this.recetas.get(i);
    }

}

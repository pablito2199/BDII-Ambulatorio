package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.clases.Urgencia;
import javax.swing.table.*;

public class ModeloTablaUrgencias extends AbstractTableModel {

    private java.util.List<Urgencia> urgencias;   //Listado de usuarios de la tabla

    //Constructor
    public ModeloTablaUrgencias() {
        this.urgencias = new java.util.ArrayList<Urgencia>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return urgencias.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //Prioridad general
            case 0:
                nombre = "Prioridad";
                break;
            //Nombre del paciente
            case 1:
                nombre = "Nombre";
                break;
            //Gravedad del paciente
            case 2:
                nombre = "Gravedad";
                break;
            //Soborno aplicado
            case 3:
                nombre = "Soborno";
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
            //Prioridad es un Integer
            case 0:
                clase = java.lang.Integer.class;
                break;
            //Nombre es un String
            case 1:
                clase = java.lang.String.class;
                break;
            //Gravedad es un Integer
            case 2:
                clase = java.lang.Integer.class;
                break;
            //Soborno es un Float
            case 3:
                clase = java.lang.Float.class;
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
            //Permite recuperar la prioridad
            case 0:
                resultado = urgencias.get(row).getPrioridad();
                break;
            //Permite recuperar el nombre
            case 1:
                resultado = urgencias.get(row).getNombre();
                break;
            //Permite recuperar la gravedad
            case 2:
                resultado = urgencias.get(row).getGravedad();
                break;
            //Permite recuperar el soborno
            case 3:
                resultado = urgencias.get(row).getSoborno();
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<Urgencia> urgencias) {
        this.urgencias = urgencias;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar la primera urgencia
    public Urgencia obtenerUrgencia() {

        //Obtenemos urgencia
        Urgencia u = this.urgencias.get(0);

        //Eliminamos urgencia y actualizamos
        this.urgencias.remove(u);
        fireTableDataChanged();

        return u;
    }

}

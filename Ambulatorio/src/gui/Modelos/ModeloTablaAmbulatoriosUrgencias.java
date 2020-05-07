package gui.Modelos;

import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import javax.swing.table.*;

public class ModeloTablaAmbulatoriosUrgencias extends AbstractTableModel {

    private java.util.List<Ambulatorio> ambulatorios;       //Listado de ambulatorios de la tabla
    private FachadaAplicacion fa;

    //Constructor
    public ModeloTablaAmbulatoriosUrgencias(FachadaAplicacion fa) {
        this.ambulatorios = new java.util.ArrayList<>();
        this.fa = fa;
    }

    //Permite obtener el número de columnas
    @Override
    public int getColumnCount() {
        return 3;
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
            //Codigo del ambulatorio
            case 0:
                nombre = "Código";
                break;
            //Nombre del ambulatorio
            case 1:
                nombre = "Nombre";
                break;
            //Pacientes en sala de urgencias
            case 2:
                nombre = "En espera";
                break;
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
            //Los pacientes en espera son un Integer
            case 2:
                clase = java.lang.Integer.class;
                break;
        }
        //Regresamos la clase
        return clase;
    }

    //Permite saber si la celda especificada es editable
    @Override
    public boolean isCellEditable(int row, int col) {
        //No es editable
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
            //Recuperamos los pacientes en espera
            case 2:
                resultado = fa.urgenciasPendientes(ambulatorios.get(row)).size();
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

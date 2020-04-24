package gui;

import aplicacion.clases.Paciente;
import javax.swing.table.*;

public class ModeloTablaPacientes extends AbstractTableModel {

    private java.util.List<Paciente> pacientes;   //Listado de pacientes de la tabla

    //Constructor
    public ModeloTablaPacientes() {
        this.pacientes = new java.util.ArrayList<Paciente>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 6;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera columna es el DNI  del usuario
            case 0:
                nombre = "DNI";
                break;
            //La segunda el nombre
            case 1:
                nombre = "Nombre";
                break;
            //La tercera el rango
            case 2:
                nombre = "Rango";
                break;
            //La cuarta la edad
            case 3:
                nombre = "Edad";
                break;
            //La quinta es el sexo
            case 4:
                nombre = "Sexo";
                break;
           //La sexta y última el grupo sanguíneo
            case 5:
                nombre = "GS";
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
            //El ID es un String
            case 0:
                clase = java.lang.String.class;
                break;
            //El nombre es un String
            case 1:
                clase = java.lang.String.class;
                break;
            //El correo es un String
            case 2:
                clase = java.lang.String.class;
                break;
            //El tipo es un String
            case 3:
                clase = java.lang.Integer.class;
                break;
            //La edad es un Integer
            case 4:
                clase = java.lang.String.class;
                break;
            case 5:
                clase = java.lang.String.class;
                break;
            /* Una forma más abreviada puesto que todos son Strings:
            case 0:
            case 1:
            case 2:
            case 3:
                clase = java.lang.String.class;
                break;
             */
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
            //Permite recuperar el ID del usuario
            case 0:
                resultado = pacientes.get(row).getDNI();
                break;
            //Permite recuperar el nombre
            case 1:
                resultado = pacientes.get(row).getNombre();
                break;
            //Permite recuperar el email
            case 2:
                resultado = pacientes.get(row).getRango();
                break;
            //Permite recuperar el tipo del usuario (Administrador o normal)
            case 3:
                resultado = pacientes.get(row).getEdad();
                break;
            //Permite recuperar la edad del usuario
            case 4:
                resultado = pacientes.get(row).getSexo();
                break;
            case 5:
                resultado = pacientes.get(row).getGrupo();
                break;
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<Paciente> pacientes) {
        this.pacientes = pacientes;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar un usuario determinado
    public Paciente obtenerPaciente(int i) {
        return this.pacientes.get(i);
    }

}

package gui;

import aplicacion.Usuario;
import javax.swing.table.*;

public class ModeloTablaUsuarios extends AbstractTableModel {

    private java.util.List<Usuario> usuarios;   //Listado de usuarios de la tabla

    //Constructor
    public ModeloTablaUsuarios() {
        this.usuarios = new java.util.ArrayList<Usuario>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 5;
    }

    //Permite recuperar el número de filas
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera columna es el ID del usuario
            case 0:
                nombre = "Id";
                break;
            //La segunda el nombre
            case 1:
                nombre = "Nombre";
                break;
            //La tercera el email
            case 2:
                nombre = "Email";
                break;
            //La cuarta el tipo del usuario
            case 3:
                nombre = "Tipo";
                break;
            //La quinta es la edad del usuario
            case 4:
                nombre = "Edad";
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
                clase = java.lang.String.class;
                break;
            //La edad es un Integer
            case 4:
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
                resultado = usuarios.get(row).getIdUsuario();
                break;
            //Permite recuperar el nombre
            case 1:
                resultado = usuarios.get(row).getNombre();
                break;
            //Permite recuperar el email
            case 2:
                resultado = usuarios.get(row).getEmail();
                break;
            //Permite recuperar el tipo del usuario (Administrador o normal)
            case 3:
                resultado = usuarios.get(row).getTipoUsuario().toString();
                break;
            //Permite recuperar la edad del usuario
            case 4:
                resultado = usuarios.get(row).getEdad();
                break;
        }
        //Devolvemos el valor recuperado
        return resultado;
    }

    //Permite sobreescribir las filas de la tabla
    public void setFilas(java.util.List<Usuario> usuarios) {
        this.usuarios = usuarios;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar un usuario determinado
    public Usuario obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

}

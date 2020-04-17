package gui;

import aplicacion.Usuario;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaPrestamos extends AbstractTableModel {

    private java.util.List<Usuario> usuarios;    //Listado de usuarios

    //Constructor
    public ModeloTablaPrestamos() {
        this.usuarios = new java.util.ArrayList<Usuario>();
    }

    //Permite recuperar el número de columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Permite recuperar el número de filas (y por tanto número de usuarios en la tabla)
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    //Permite recuperar el nombre de las columnas
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //ID del usuario candidato al préstamo
            case 0:
                nombre = "Id";
                break;
            //Nombre del usuario
            case 1:
                nombre = "Nombre";
                break;
            //Correo electrónico del usuario
            case 2:
                nombre = "Email";
                break;
            //Número de préstamos vencidos del usuario
            case 3:
                nombre = "Prestamos vencidos";
                break;
        }
        //Regresamos el nombre de la columna
        return nombre;
    }

    //Permite recuperar el tipo de elemto que hay en cada columna
    @Override
    public Class getColumnClass(int col) {
        Class clase = null;
        switch (col) {
            //El id es un String
            case 0:
                clase = java.lang.String.class;
                break;
            //El nombre de usuario es un String
            case 1:
                clase = java.lang.String.class;
                break;
            //El correo electrónico es un String
            case 2:
                clase = java.lang.String.class;
                break;
            //El número de préstamos expirados en un Integer
            case 3:
                clase = java.lang.Integer.class;
                break;
        }
        //Regresamos la clase de elemento que hay en la columna
        return clase;
    }

    //Permite saber si se puede modificar el contenido de la celda seleccionada
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso no. No se modifica ninguna celda.
        return false;
    }

    //Permite recuperar el valor de la celda seleccionada
    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        switch (col) {
            //Permite recuperar el ID del usuarios seleccionado
            case 0:
                resultado = usuarios.get(row).getIdUsuario();
                break;
            //Permite recuperar el nombre
            case 1:
                resultado = usuarios.get(row).getNombre();
                break;
            //Permite recuperar el correo electrónico
            case 2:
                resultado = usuarios.get(row).getEmail();
                break;
            //Permite recuperar el número de préstamos vencidos
            case 3:
                resultado = usuarios.get(row).getNumPrestamosVencidos();
                break;
        }
        //Devolvemos el dato recuperado
        return resultado;
    }

    //Permite sobreescribir los usuarios que hay en la tabla
    public void setFilas(java.util.List<Usuario> usuarios) {
        this.usuarios = usuarios;
        //Se notifica a los listeners que han cambiado el valor de las celdas
        fireTableDataChanged();
    }

    //Permite recuperar un usuario de la tabla
    public Usuario obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

}

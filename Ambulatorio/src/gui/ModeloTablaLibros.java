package gui;

import aplicacion.Libro;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaLibros extends AbstractTableModel {

    private java.util.List<Libro> libros;       //Listado de libros de la tabla

    //Constructor
    public ModeloTablaLibros() {
        this.libros = new java.util.ArrayList<Libro>();
    }

    //Permite obtener el número de columnas
    @Override
    public int getColumnCount() {
        return 5;
    }

    //Permite obtener el número de filas de la tabla
    @Override
    public int getRowCount() {
        return libros.size();
    }

    //Permite obtener el nombre de las columnas de la tabla
    @Override
    public String getColumnName(int col) {
        String nombre = "";
        switch (col) {
            //La primera es el ID del libro
            case 0:
                nombre = "Id";
                break;
            //La segunda los autores
            case 1:
                nombre = "Autores";
                break;
            //La tercera el título
            case 2:
                nombre = "Título";
                break;
            //La cuarta la editorial
            case 3:
                nombre = "Editorial";
                break;
            //La quinta el año de publicación
            case 4:
                nombre = "Año";
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
            //El ID es un Integer
            case 0:
                clase = java.lang.Integer.class;
                break;
            //Los autores son String
            case 1:
                clase = java.lang.String.class;
                break;
            //El título un String
            case 2:
                clase = java.lang.String.class;
                break;
            //La editorial un String  
            case 3:
                clase = java.lang.String.class;
                break;
            //El año de pubilcación un Integer
            case 4:
                clase = java.lang.Integer.class;
                break;
        }
        //Regresamos la clase
        return clase;
    }

    //Permite saber si la celda especificada es editable
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso ninguna lo es
        return false;
    }

    //Permite obtener el valor de la celda especificada
    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        switch (col) {
            //En la primera columna recuperamos el id del libro
            case 0:
                resultado = libros.get(row).getIdLibro();
                break;
            //Recuperamos los nombre de los autores
            case 1:
                resultado = libros.get(row).getAutoresAsString();
                break;
            //Recuperamos el título del libro
            case 2:
                resultado = libros.get(row).getTitulo();
                break;
            //Recuperamos el nombre de la editorial que lo publicó
            case 3:
                resultado = libros.get(row).getEditorial();
                break;
            //Recuperamos el año de pubilcación
            case 4:
                resultado = libros.get(row).getAno();
                break;
        }
        //Devolvemos el resultado
        return resultado;
    }

    //Permite cambiar las filas de la tabla
    public void setFilas(java.util.List<Libro> libros) {
        this.libros = libros;
        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar el libro de la tabla especificado
    public Libro obtenerLibro(int i) {
        return this.libros.get(i);
    }

}

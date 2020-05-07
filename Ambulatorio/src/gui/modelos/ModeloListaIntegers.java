package gui.modelos;

public class ModeloListaIntegers extends javax.swing.AbstractListModel {

    java.util.List<Integer> elementos;   //Listado de los elementos

    //Contructor
    public ModeloListaIntegers() {
        this.elementos = new java.util.ArrayList<Integer>();
    }

    //Función que permite recuperar el número de filas
    @Override
    public int getSize() {
        return this.elementos.size();
    }

    //Permite recuperar el elemento en la fila i
    @Override
    public Integer getElementAt(int i) {
        return elementos.get(i);
    }

    //Permite meter un nuevo elemento en la lista
    public void nuevoElemento(Integer e) {
        this.elementos.add(e);
        //Función que notifica a los listeners de que se añadió un elemento a la lista
        fireIntervalAdded(this, this.elementos.size() - 1, this.elementos.size() - 1);
    }

    //Permite borrar el elementos i de la lista
    public void borrarElemento(int i) {
        Integer e;
        e = this.elementos.get(i);
        this.elementos.remove(i);
        //Función que notifica a los listeners de que se ha borrado un elemento
        fireIntervalRemoved(this, i, i);
    }

    //Permite sobreescribir los elementos existentes por otros nuevos
    public void setElementos(java.util.List<Integer> elementos) {
        this.elementos = elementos;
        //Función que notifica a los listeners que se han cambiado los contenidos de las celdas
        fireContentsChanged(this, 0, elementos.size() - 1);
    }

    //Permite recuperar los elementos
    public java.util.List<Integer> getElementos() {
        return this.elementos;
    }

}

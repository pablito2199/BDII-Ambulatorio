package gui;

import aplicacion.clases.Especialidad;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class ModeloComboEspecialidades implements ComboBoxModel {

    private ArrayList<Especialidad> tipos;
    private Integer selected;

    //Constructor
    ModeloComboEspecialidades() {
        tipos = null;
        selected = null;
    }

    ModeloComboEspecialidades(ArrayList<Especialidad> tipos) {
        this.tipos = tipos;
        selected = null;
    }

    //Getters y Setters
    void setTipos(ArrayList<Especialidad> tipos) {
        this.tipos = tipos;
    }

    ArrayList<Especialidad> getTipos() {
        return tipos;
    }

    //Implementaciones
    @Override
    public void setSelectedItem(Object o) {
        if (o instanceof String) {
            selected = tipos.indexOf((Especialidad) o);
        } else {
            selected = null;
        }
    }

    @Override
    public Object getSelectedItem() {
        if (selected != null && tipos != null) {
            return tipos.get(selected);
        } else {
            return null;
        }
    }

    @Override
    public int getSize() {
        if (tipos != null) {
            return tipos.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getElementAt(int i) {
        if (i < tipos.size() && tipos != null) {
            return tipos.get(i).getNombre();
        } else {
            return null;
        }
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Paciente;
import aplicacion.clases.Rango;
import aplicacion.clases.TipoCita;

import java.sql.Date;
import java.time.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.table.*;

public class ModeloTablaHoras extends AbstractTableModel {

    private FachadaAplicacion fa;
    private Paciente pa;
    private java.util.List<Ambulatorio> ambulatorios; //Listado de ambulatorios de la tabla
    private java.util.List<Timestamp> horas; //Listado de horas disponibles

    //Constructor
    public ModeloTablaHoras(FachadaAplicacion fa, Paciente pa) {
        this.fa = fa;
        this.pa = pa;
        this.ambulatorios = new ArrayList<>();
        this.horas = new ArrayList<>();
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
            //La primera es el nombre del ambulatorio
            case 0:
                nombre = "Ambulatorio";
                break;
            //La segunda la fecha
            case 1:
                nombre = "Fecha";
                break;
            //La tercera la hora
            case 2:
                nombre = "Hora";
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
                clase = java.lang.String.class;
                break;
            //El nombre es un String
            case 1:
                clase = java.time.LocalDate.class;
                break;
            //La provincia es un String
            case 2:
                clase = java.time.LocalTime.class;
                break;
        }
        //Regresamos la clase
        return clase;
    }

    //Permite saber si la celda especificada es editable
    @Override
    public boolean isCellEditable(int row, int col) {
        //En este caso el nombre y el teléfono
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
            //Recuperamos la fecha
            case 1:
                resultado = horas.get(row).toLocalDateTime().toLocalDate();
                break;
            //Recuperamos la hora
            case 2:
                resultado = horas.get(row).toLocalDateTime().toLocalTime();
                break;
        }
        //Devolvemos el resultado
        return resultado;
    }

    //Permite cambiar las filas de la tabla
    public void setFilas(java.util.List<Ambulatorio> ambulatorios, TipoCita tipo, Date inicio, Date fin) {

        //Creamos array de horas posibles desde las 9 hasta las 17 
        LocalTime t = LocalTime.of(9, 0);
        ArrayList<LocalTime> a = new ArrayList<>();

        while (t.getHour() < 17) {

            a.add(t);
            t.plusMinutes(30);
        }

        ArrayList<Timestamp> ocupadas;
        for (Ambulatorio ambulatorio : ambulatorios) {

            //Obtenemos citas no posibles para el paciente
            if (pa.getRango() == Rango.DELUXE) {
                ocupadas = fa.citasOcupadas(fa.menorNumeroPacientes(ambulatorio, tipo), inicio, fin);
            } else {
                ocupadas = new ArrayList<>();
            }

            //Actualizamos lista de horas
            LocalDate actual = inicio.toLocalDate();
            while (actual.compareTo(fin.toLocalDate()) != 0) {
                for (LocalTime hora : a) {

                    Timestamp temp = Timestamp.valueOf(LocalDateTime.of(actual, hora));
                    if (!ocupadas.contains(temp)) {

                        this.ambulatorios.add(ambulatorio);
                        horas.add(temp);
                    }

                }
                actual.plusDays(1);
            }
        }

        //Notifica a los listeners del cambio
        fireTableDataChanged();
    }

    //Permite recuperar el ambulatorio especificado
    public Ambulatorio obtenerAmbulatorio(int i) {
        return this.ambulatorios.get(i);
    }

    //Permite recuperar el Timestamp especificado
    public Timestamp obtenerFechaHora(int i) {
        return this.horas.get(i);
    }
}

package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Consulta;
import aplicacion.clases.Paciente;
import aplicacion.clases.TipoCita;

import java.sql.Date;
import java.time.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.*;

public class ModeloTablaHoras extends AbstractTableModel {

    private FachadaAplicacion fa;
    private Paciente pa;
    private java.util.List<Ambulatorio> ambulatorios; //Listado de ambulatorios de la tabla
    private HashMap<Ambulatorio, Consulta> consultas; //Listado de consultas con menos pacientes recogidas en la tabla
    private java.util.List<Timestamp> horas; //Listado de horas disponibles

    //Constructor
    public ModeloTablaHoras(FachadaAplicacion fa, Paciente pa) {
        this.fa = fa;
        this.pa = pa;
        this.ambulatorios = new ArrayList<>();
        this.consultas = new HashMap<>();
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
    public void setFilas(java.util.List<Ambulatorio> ambulatorios, TipoCita tipocita, Date inicio, Date fin) {

        //Vaciamos elementos
        this.ambulatorios.clear();
        this.consultas.clear();
        this.horas.clear();

        //Creamos array de horas posibles desde las 9 hasta las 17 
        LocalTime t = LocalTime.of(9, 0);
        ArrayList<LocalTime> arr = new ArrayList<>();

        while (t.getHour() < 13) {

            arr.add(t);
            t.plusMinutes(30);
        }
        
        //Comprobamos que la fecha de fin no sea mas de 

        ArrayList<Timestamp> ocupadas;
        for (Ambulatorio ambulatorio : ambulatorios) {

            //Obtenemos citas no posibles para el paciente
            consultas.put(ambulatorio, fa.menorNumeroPacientes(ambulatorio.getCodigo(), tipocita));
            ocupadas = fa.citasOcupadas(pa, consultas.get(ambulatorio), inicio, fin);

            //Actualizamos lista de horas
            LocalDate actual = inicio.toLocalDate();
            while (!actual.isAfter(fin.toLocalDate())) {

                //Añadimos Timestamp del dia y la hora si no esta ocupada
                for (LocalTime hora : arr) {

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

    //Permite recuperar la Consulta especificada
    public Consulta obtenerConsulta(Ambulatorio ambulatorio) {
        return this.consultas.get(ambulatorio);
    }
}

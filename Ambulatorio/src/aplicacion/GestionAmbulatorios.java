package aplicacion;

import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Cita;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionAmbulatorios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionAmbulatorios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void insertarAmbulatorio(Ambulatorio ambulatorio) {
        fbd.insertarAmbulatorio(ambulatorio);
    }

    //Permite modificar los datos de un ambulatorio de la base de datos
    public void modificarAmbulatorio(Ambulatorio ambulatorio) {
        fbd.modificarAmbulatorio(ambulatorio);
    }

    //Permite eliminar un ambulatorio de la base de datos
    public void borrarAmbulatorio(Ambulatorio ambulatorio) {
        fbd.borrarAmbulatorio(ambulatorio);
    }

    //Permite buscar ambulatorios por su id y/o nombre de ambulatorio
    public java.util.List<Ambulatorio> consultarAmbulatorios(String nombre, Integer codigo, String Provincia) {
        return fbd.consultarAmbulatorios(nombre, codigo, Provincia);
    }

    //Permite consultar el historial clínico de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad) {
        return fbd.numeroConsultas(ambulatorio, especialidad);
    }
}

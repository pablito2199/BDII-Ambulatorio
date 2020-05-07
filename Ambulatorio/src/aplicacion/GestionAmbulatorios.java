package aplicacion;

import aplicacion.clases.Ambulatorio;
import gui.ventanas.FachadaGui;
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
    public void borrarAmbulatorio(Integer ambulatorio) {
        fbd.borrarAmbulatorio(ambulatorio);
    }

    //Permite buscar ambulatorios por su id y/o nombre de ambulatorio
    public java.util.List<Ambulatorio> consultarAmbulatorios(String nombre, Integer codigo, String provincia) {
        return fbd.consultarAmbulatorios(nombre, codigo, provincia);
    }
    
    //Permite recuperar los datos del ambulatorio con el nombre y provincia correspondientes
    public Ambulatorio consultarAmbulatorioActual(String nombre, String provincia) {
        return fbd.consultarAmbulatorioActual(nombre, provincia);
    }
}

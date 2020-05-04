package aplicacion;

import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Hospital;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

public class GestionHospitales {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionHospitales(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Inserta un nuevo ambulatorio en la base de datos
    public ArrayList<Hospital> consultarHospital(String nombre, String provincia, Integer codigo, Float distancia) {
        return fbd.consultarHospital(nombre, provincia, codigo, distancia);
    }
}

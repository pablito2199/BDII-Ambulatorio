package aplicacion;

import aplicacion.clases.Hospital;
import gui.ventanas.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

public class GestionHospitales {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionHospitales(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite consultar un hospital asociado con el ambulatorio
    public ArrayList<Hospital> consultarHospitalAsociado(Integer ambulatorio, String nombre, String provincia, Integer codigo, Float distancia) {
        return fbd.consultarHospitalAsociado(ambulatorio, nombre, provincia, codigo, distancia);
    }
}

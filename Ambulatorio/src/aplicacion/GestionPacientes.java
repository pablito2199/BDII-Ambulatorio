package aplicacion;

import aplicacion.clases.Paciente;
import aplicacion.clases.Cita;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionPacientes {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionPacientes(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Permite insertar un nuevo usuario en la base de datos
    public void insertarPaciente(Paciente paciente) {
        fbd.insertarPaciente(paciente);
    }

    //Permite modificar los datos de un paciente de la base de datos
    public void modificarPaciente(Paciente paciente) {
        fbd.modificarPaciente(paciente);
    }

    //Permite eliminar un paciente de la base de datos
    public void borrarPaciente(Paciente paciente) {
        fbd.borrarPaciente(paciente);
    }

    //Permite buscar pacientes por su id y/o nombre de paciente
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, String NSS, String grupo) {
        return fbd.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente, String tipo, String especialidad, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin) {
        return fbd.consultarHistorialClinico(paciente, tipo, especialidad, fechaInicio, fechaFin);
    }
}

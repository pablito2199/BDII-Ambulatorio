package aplicacion;

import aplicacion.clases.Paciente;
import aplicacion.clases.Cita;
import aplicacion.clases.TipoCita;
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
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, Integer NSS, String grupo) {
        return fbd.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente, TipoCita tipoCita, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin) {
        return fbd.consultarHistorialClinico(paciente, tipoCita, fechaInicio, fechaFin);
    }

    //Permite saber si existe un paciente en la base de datos con el mismo identificador o no
    public boolean existePaciente(String CIP) {
        return fbd.existePaciente(CIP);
    }

    //Permite recuperar las enfermedades no padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesNoPadecidas(String cip, String enfermedad) {
        return fbd.obtenerEnfermedadesNoPadecidas(cip, enfermedad);
    }

    //Permite recuperar las enfermedades padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesPadecidas(String cip, String enfermedad) {
        return fbd.obtenerEnfermedadesPadecidas(cip, enfermedad);
    }

    //Permite actualizar las enfermedades de un paciente de la base de datos
    public void actualizarEnfermedadesPaciente(String cip, java.util.List<String> enfermedades) {
        fbd.actualizarEnfermedadesPaciente(cip, enfermedades);
    }

    //Permite generar una ventana para visualizar información de un paciente
    public void nuevaVPacientes() {
        fgui.nuevaVPacientes();
    }

    //Permite generar una nueva ventana de gestión de enfermedades de un paciente
    public void nuevaVGestionEnfermedades(String cip, java.util.List<String> enfermedades, java.util.List<String> restoEnfermedades) {
        fgui.nuevaVGestionEnfermedades(cip, enfermedades, restoEnfermedades);
    }
}

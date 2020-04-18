package baseDatos;

import aplicacion.clases.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;    // Enlace a la fachada de aplicación
    private java.sql.Connection conexion;       // Conexión SQL
    private DAOAmbulatorios daoAmbulatorios;    // Enlace al DAO de Ambulatorios
    private DAOCitas daoCitas;                  // Enlace al DAO de Citas
    private DAOPacientes daoPacientes;          // Enlace al DAO de Pacientes
    private DAOEnfermedades daoEnfermedades;    // Enlace al DAO de Enfermedades
    private DAOConsultas daoConsultas;          // Enlace al DAO de Consultas
    private DAORecetas daoRecetas;              // Enlace al DAO de Recetas
    private DAOPersonal daoPersonal;            // Enlace al DAO de Personal

    //Contructor
    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        //Se configura la conexión con el archivo .properties
        try {
            //Inicialiamos e instanciamos
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            //Establecemos propiedades de usuario y contraseña
            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            //Creamos la conexión
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            //Inicializamos los DAOS
            daoAmbulatorios = new DAOAmbulatorios(conexion, fa);    // Enlace al DAO de Ambulatorios
            daoCitas = new DAOCitas(conexion, fa);                  // Enlace al DAO de Citas
            daoPacientes = new DAOPacientes(conexion, fa);          // Enlace al DAO de Pacientes
            daoEnfermedades = new DAOEnfermedades(conexion, fa);    // Enlace al DAO de Enfermedades
            daoConsultas = new DAOConsultas(conexion, fa);          // Enlace al DAO de Consultas
            daoRecetas = new DAORecetas(conexion, fa);              // Enlace al DAO de Recetas
            daoPersonal = new DAOPersonal(conexion, fa);            // Enlace al DAO de Personal

            //En caso de error capturamos la excepciones, imprimimos el mensaje y genereramos la ventana de excepción
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

////////////////
//DAOAMBULATORIOS
////////////////
    //Permite insertar un nuevo ambulatorio en la base de datos
    public void insertarAmbulatorio(Ambulatorio ambulatorio) {
        daoAmbulatorios.insertarAmbulatorio(ambulatorio);
    }

    //Permite borrar un ambulatorio de la base de datos
    public void borrarAmbulatorio(Ambulatorio ambulatorio) {
        daoAmbulatorios.borrarAmbulatorio(ambulatorio);
    }

    //Permite modificar un ambulatorio de la base de datos
    public void modificarAmbulatorio(Ambulatorio ambulatorio) {
        daoAmbulatorios.modificarAmbulatorio(ambulatorio);
    }

///////////////
//DAOCITAS
///////////////
    //Permite insertar una nueva cita en la base de datos
    public void insertarCita(Cita cita, Paciente paciente) {
        daoCitas.insertarCita(cita, paciente);
    }

    //Permite insertar una nueva urgencia en la base de datos
    public void insertarUrgencia(Urgencia urgencia) {
        daoCitas.insertarUrgencia(urgencia);
    }

    //Atiende una cita o una urgencia
    public void atenderCita(Cita cita) {
        daoCitas.atenderCita(cita);
    }

    //Deriva una cita o urgencia a un hospital
    public void derivarHospital(Hospital hospital, Cita cita) {
        daoCitas.derivarHospital(hospital, cita);
    }

    //Consulta las citas pendientes
    public ArrayList<Cita> citasPendientes() {
        return daoCitas.citasPendientes();
    }

    //Consulta las urgencias pendientes
    public ArrayList<Urgencia> urgenciasPendientes() {
        return daoCitas.urgenciasPendientes();
    }

    //Consulta las citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente) {
        return daoCitas.citasPaciente(paciente);
    }

    //Consulta las citas pendientes de un medico
    public ArrayList<Urgencia> citasMedico(PersonalSanitario medico) {
        return daoCitas.citasMedico(medico);
    }

//////////////////////
//DAOPACIENTES
/////////////////////
    //Permite insertar un nuevo usuario en la base de datos
    public void insertarPaciente(Paciente paciente) {
        daoPacientes.insertarPaciente(paciente);
    }

    //Permite modificar los datos de un paciente de la base de datos
    public void modificarPaciente(Paciente paciente) {
        daoPacientes.modificarPaciente(paciente);
    }

    //Permite eliminar un paciente de la base de datos
    public void borrarPaciente(Paciente paciente) {
        daoPacientes.borrarPaciente(paciente);
    }
    
     //Permite buscar pacientes por su id y/o nombre de paciente
     public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, String NSS, String grupo) {
         return daoPacientes.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
     }

      //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente,  String tipo, String especialidad, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin){
        return daoPacientes.consultarHistorialClinico(paciente, tipo, especialidad, fechaInicio, fechaFin);
    }

//////////////////
//DAOENFERMEDADES
////////////////// 
    //Permite insertar una nueva enfermedad en la base de datos
    public void insertarEnfermedad(Enfermedad enfermedad) {
        daoEnfermedades.insertarEnfermedad(enfermedad);
    }

    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return daoEnfermedades.consultarEnfermedades(nombre);
    }

    //Permite modificar los datos de una enfermedad de la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        daoEnfermedades.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        daoEnfermedades.borrarEnfermedad(nombre);
    }

////////////////////
//DAOCONSULTAS
////////////////////
    //Permite insertar una nueva consulta en la base de datos
    public void insertarConsulta(Consulta consulta) {
        daoConsultas.insertarConsulta(consulta);
    }

    //Permite modificar los datos de una consulta de la base de datos
    public void modificarConsulta(Consulta consulta) {
        daoConsultas.modificarConsulta(consulta);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarConsulta(Consulta consulta) {
        daoConsultas.borrarConsulta(consulta);
    }

////////////////////
//DAORECETAS
////////////////////
    //Permite insertar una nueva receta en la base de datos
    public void insertarReceta(Receta receta) {
        daoRecetas.insertarReceta(receta);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente,  java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin, Integer codigoReceta, String medicamento){
        return daoRecetas.consultarHistorialReceta(paciente, fechaInicio, fechaFin, codigoReceta, medicamento);
    }

////////////////////
//DAOPERSONAL
////////////////////
    //Permite recuperar un administrador de la base de datos a partir de su id y contraseña
    public Boolean validarAdministrador(String dni, String contrasena) {
        return daoPersonal.validarAdministrador(dni, contrasena);
    }
}

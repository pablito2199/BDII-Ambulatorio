package baseDatos;

import aplicacion.clases.*;
import java.sql.Timestamp;
import java.sql.Date;
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
    private DAOEspecialidades daoEspecialidades;// Enlace al DAO de Especialidades
    private DAORecetas daoRecetas;              // Enlace al DAO de Recetas
    private DAOPersonal daoPersonal;            // Enlace al DAO de Personal
    private DAOHospitales daoHospitales;        // Enlace al DAO de Hospitales

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
            daoEspecialidades = new DAOEspecialidades(conexion, fa);// Enlace al DAO de Especialidades
            daoRecetas = new DAORecetas(conexion, fa);              // Enlace al DAO de Recetas
            daoPersonal = new DAOPersonal(conexion, fa);            // Enlace al DAO de Personal
            daoHospitales = new DAOHospitales(conexion, fa);        // Enlace al DAO de Hospitales
            //En caso de error capturamos la excepciones, imprimimos el mensaje y genereramos la ventana de excepción
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException | java.sql.SQLException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
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
    public void borrarAmbulatorio(Integer ambulatorio) {
        daoAmbulatorios.borrarAmbulatorio(ambulatorio);
    }

    //Permite modificar un ambulatorio de la base de datos
    public void modificarAmbulatorio(Ambulatorio ambulatorio) {
        daoAmbulatorios.modificarAmbulatorio(ambulatorio);
    }

    //Permite consultar los ambulatorios de la red
    public java.util.List<Ambulatorio> consultarAmbulatorios(String nombre, Integer codigo, String provincia) {
        return daoAmbulatorios.consultarAmbulatorios(nombre, codigo, provincia);
    }
    
    //Permite recuperar los datos del ambulatorio con el nombre y provincia correspondientes
    public Ambulatorio consultarAmbulatorioActual(String nombre, String provincia) {
        return daoAmbulatorios.consultarAmbulatorioActual(nombre, provincia);
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

    //Devuelve una lista de las horas de las citas reservadas entre dos fechas
    public ArrayList<Timestamp> citasOcupadas(Consulta consulta, Date inicio, Date fin) {
        return daoCitas.citasOcupadas(consulta, inicio, fin);
    }

    //Consulta las urgencias pendientes
    public ArrayList<Urgencia> urgenciasPendientes(Ambulatorio ambulatorio) {
        return daoCitas.urgenciasPendientes(ambulatorio);
    }

    //Consulta las citas pendientes de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente, String ambulatorio, Integer consulta, Date inicio, Date fin) {
        return daoCitas.citasPaciente(paciente, ambulatorio, consulta, inicio, fin);
    }

    //Consulta las citas pendientes de un medico
    public ArrayList<Cita> citasMedico(PersonalSanitario medico, String ambulatorio, Date inicio, Date fin) {
        return daoCitas.citasMedico(medico, ambulatorio, inicio, fin);
    }

    //Consulta la lista tipos de cita buscando por especialidad
    public ArrayList<TipoCita> obtenerTiposDeCita(String especialidad) {
        return daoCitas.obtenerTiposDeCita(especialidad);
    }

    //Consulta la lista citas pendientes del paciente filtrada
    public void borrarCita(Cita cita) {
        daoCitas.borrarCita(cita);
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
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, Integer NSS, String grupo) {
        return daoPacientes.consultarPacientes(CIP, DNI, nombre, edad, sexo, NSS, grupo);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente, TipoCita tipoCita, java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        return daoPacientes.consultarHistorialClinico(paciente, tipoCita, fechaInicio, fechaFin);
    }

    //Permite saber si existe un paciente en la base de datos con el mismo identificador o no
    public boolean existePaciente(String CIP) {
        return daoPacientes.existePaciente(CIP);
    }

    //Permite recuperar las enfermedades no padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesNoPadecidas(String cip, String enfermedad) {
        return daoPacientes.obtenerEnfermedadesNoPadecidas(cip, enfermedad);
    }

    //Permite recuperar las enfermedades padecidas por el paciente
    public java.util.List<String> obtenerEnfermedadesPadecidas(String cip, String enfermedad) {
        return daoPacientes.obtenerEnfermedadesPadecidas(cip, enfermedad);
    }

    //Permite actualizar las enfermedades de un paciente de la base de datos
    public void actualizarEnfermedadesPaciente(String cip, java.util.List<String> enfermedades) {
        daoPacientes.actualizarEnfermedadesPaciente(cip, enfermedades);
    }

//////////////////
//DAOENFERMEDADES
////////////////// 
    //Permite insertar una nueva enfermedad en la base de datos
    public void insertarEnfermedad(Enfermedad enfermedad) {
        daoEnfermedades.insertarEnfermedad(enfermedad);
    }

    //Permite consultar las enfermedades existentes en la base de datos
    public java.util.List<Enfermedad> consultarEnfermedades(String nombre) {
        return daoEnfermedades.consultarEnfermedades(nombre);
    }

    //Permite recuperar los datos de la enfermedad con el nombre correspondiente
    public Enfermedad consultarEnfermedadActual(String nombre) {
        return daoEnfermedades.consultarEnfermedadActual(nombre);
    }

    //Permite modificar los datos de una enfermedad de la base de datos
    public void modificarEnfermedad(Enfermedad enfermedad) {
        daoEnfermedades.modificarEnfermedad(enfermedad);
    }

    //Permite eliminar una enfermedad de la base de datos
    public void borrarEnfermedad(String nombre) {
        daoEnfermedades.borrarEnfermedad(nombre);
    }

    //Permite consultar las enfermedades existentes sin actualizar una lista
    public java.util.List<String> obtenerEnfermedadesNoActualizadas(java.util.List<String> enfermedades, String enfermedad) {
        return daoEnfermedades.obtenerEnfermedadesNoActualizadas(enfermedades, enfermedad);
    }

////////////////////
//DAOCONSULTAS
////////////////////
    //Permite insertar una nueva consulta en la base de datos
    public void anadirConsulta(Consulta consulta) {
        daoConsultas.insertarConsulta(consulta);
    }

    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Consulta> consultarConsultas(Integer identificador, Integer ambulatorio, String especialidad) {
        return daoConsultas.consultarConsultas(identificador, ambulatorio, especialidad);
    }

    //Permite eliminar una consulta de la base de datos
    public void borrarConsulta(Integer identificador, Integer ambulatorio, String especialidad) {
        daoConsultas.borrarConsulta(identificador, ambulatorio, especialidad);
    }

    //Devuelve el número de consultas de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad) {
        return daoConsultas.numeroConsultas(ambulatorio, especialidad);
    }

    //Permite obtener la consulta con menos citas pendientes
    public Consulta menorNumeroPacientes(Integer ambulatorio, String especialidad) {
        return daoConsultas.menorNumeroPacientes(ambulatorio, especialidad);
    }
    
////////////////////
//DAOESPECIALIDADES
//////////////////// 
    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Especialidad> consultarEspecialidades() {
        return daoEspecialidades.consultarEspecialidades();
    }

////////////////////
//DAORECETAS
////////////////////
    //Permite insertar una nueva receta en la base de datos
    public void insertarReceta(Receta receta) {
        daoRecetas.insertarReceta(receta);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente, java.sql.Date fechaInicio, java.sql.Date fechaFin, Integer codigoReceta, String medicamento) {
        return daoRecetas.consultarHistorialReceta(paciente, fechaInicio, fechaFin, codigoReceta, medicamento);
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<String> consultarMedicamentos(String nombre) {
        return daoRecetas.consultarMedicamentos(nombre);
    }

////////////////////
//DAOPERSONAL
////////////////////
    //Permite recuperar un administrador de la base de datos a partir de su id y contraseña
    public Boolean validarAdministrador(String dni, String contrasena) {
        return daoPersonal.validarAdministrador(dni, contrasena);
    }

    //Permite recuperar la especialidad de un personal sanitario
    public ArrayList<String> obtenerEspecialidades(String dni, Integer ambulatorio) {
        return daoPersonal.obtenerEspecialidades(dni, ambulatorio);
    }

    //Permite buscar personal sanitario por su dni y nombre
    public java.util.List<PersonalSanitario> consultarPersonal(String dni, String nombre) {
        return daoPersonal.consultarPersonal(dni, nombre);
    }

////////////////////
//DAOHOSPITALES
////////////////////
    //Permite consultar un hospital asociado con el ambulatorio
    public ArrayList<Hospital> consultarHospitalAsociado(Integer ambulatorio, String nombre, String provincia, Integer codigo, Float distancia) {
        return daoHospitales.consultarHospitalAsociado(ambulatorio, nombre, provincia, codigo, distancia);
    }
}

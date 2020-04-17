package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.Cita;
import aplicacion.Urgencia;

public class DAOCitas extends AbstractDAO {

    //Contructor
    public DAOCitas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar una nueva cita en la base de datos
    public void insertarCita(Cita cita) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmCita = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar una nueva cita
            stmCita = con.prepareStatement(
                    "insert into cita "
                    + "(paciente,"
                    + "consulta,"
                    + "ambulatorio,"
                    + "fechaHoraInicio,"
                    + "tipo,"
                    + "especialidad) "
                    + "values (?,?,?,?,?,?,?)"
            );
            //Sustituimos
            stmCita.setString(1, cita.getPaciente());
            stmCita.setInt(2, cita.getConsulta());
            stmCita.setInt(3, cita.getAmbulatorio());
            stmCita.setTimestamp(4, cita.getFechaHoraInicio());
            stmCita.setString(5, cita.getTipo());
            stmCita.setString(6, cita.getEspecialidad());

            //Actualizamos
            stmCita.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmCita.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Pone la fecha de finalizacion de la cita a la actual del sistema gestor
    public void atenderCita(Cita cita) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPaciente = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para insertar una fecha de finalización
            stmPaciente = con.prepareStatement(
                    "update from cita "
                    + "set fechaHoraFin = CURRENT_TIMESTAMP"
                    + "where fechaHoraInicio = ?"
                    + "and consulta = ?"
                    + "and ambulatorio = ?"
                    + "and paciente = ?"
            );

            //Sustituimos
            stmPaciente.setTimestamp(1, cita.getFechaHoraInicio());
            stmPaciente.setInt(2, cita.getConsulta());
            stmPaciente.setInt(3, cita.getAmbulatorio());
            stmPaciente.setString(4, cita.getPaciente());
            
            //Actualizamos
            stmPaciente.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmPaciente.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar los datos de un paciente de la base de datos
    public void modificarPaciente(Paciente paciente) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPaciente = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para actualizar los datos del paciente con la id especificada
            stmPaciente = con.prepareStatement("update paciente "
                    + "set numSeguridadSocial = ?, "
                    + "nombre = ?, "
                    + "fechaNacimiento = ?, "
                    + "sexo = ?, "
                    + "grupoSanguineo = ?, "
                    + "nacionalidad = ? "
                    + "direccion = ? "
                    + "telefono = ? "
                    + "where cip = ?");
            //Actualizamos
            stmPaciente.setInt(1, paciente.getNSS());
            stmPaciente.setString(2, paciente.getNombre());
            stmPaciente.setDate(3, paciente.getFechaNacimiento());
            stmPaciente.setString(4, paciente.getSexo());
            stmPaciente.setString(5, paciente.getGrupo().getTipo());
            stmPaciente.setString(6, paciente.getNacionalidad());
            stmPaciente.setString(7, paciente.getDireccion());
            stmPaciente.setString(8, paciente.getTelefono());

            stmPaciente.setString(9, paciente.getCIP());  //Id de paciente
            //NOTA: El DNI y el CIP de un paciente no se pueden modificar

            //Actualizamos
            stmPaciente.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmPaciente.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite buscar pacientes por su id y/o nombre de paciente
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, String NSS, Strign grupo) {
        //Declaramos variables
        java.util.List<Paciente> resultado = new java.util.ArrayList<Paciente>();
        Paciente pacienteActual;
        Connection con;
        PreparedStatement stmPacientes = null;
        ResultSet rsPacientes;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el id, clave, nombre, direccion, email y tipo de paciente de la tabla de pacientes
            //que tengan el nombre dado
            String consulta = "select dni, nombre, current_date-fechaNacimiento as edad, sexo, grupoSanguineo "
                    + "from paciente "
                    + "where cip like ? "
                    + "and dni like ?"
                    + "and nombre like ?"
                    + "and current_date-fechaNacimiento = "
                    + "and dni like ?"
                    + "and dni like ?"
                    + "and dni like ?";

            //Preparamos la consulta
            stmPacientes = con.prepareStatement(consulta);
            //Sustituimos
            stmPacientes.setString(1, "%" + nombre + "%"); //Nombre
            if (id != null) {
                stmPacientes.setString(2, "%" + id + "%"); //ID, en caso de no ser nulo
            }
            //Ejecutamos
            rsPacientes = stmPacientes.executeQuery();
            //Mientras haya coincidencias
            while (rsPacientes.next()) {
                //Se crea una instancia de paciente con los datos recuperados de la base de datos
                pacienteActual = new Paciente(rsPacientes.getString("id_paciente"), rsPacientes.getString("clave"),
                        rsPacientes.getString("nombre"), rsPacientes.getString("direccion"),
                        rsPacientes.getString("email"), TipoPaciente.CTU(rsPacientes.getString("tipo_paciente")), rsPacientes.getString("edad"));
                //Y se añade la instancia a la lista de pacientes
                resultado.add(pacienteActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmPacientes.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }
}

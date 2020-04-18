package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import aplicacion.clases.Cita;
import aplicacion.clases.TipoCita;
import aplicacion.clases.Urgencia;
import aplicacion.clases.Paciente;
import aplicacion.clases.Rango;
import aplicacion.clases.Hospital;
import aplicacion.clases.Ambulatorio;

/**
 *
 * @author Martín Suárez García
 */
public class DAOCitas extends AbstractDAO {

    //Contructor
    public DAOCitas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar una nueva cita en la base de datos
    public void insertarCita(Cita cita, Paciente paciente) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmCita = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {

            //Quitamos autocommit
            con.setAutoCommit(false);

            //Preparamos la consulta SQL para insertar una nueva cita
            stmCita = con.prepareStatement(
                    "insert into cita "
                    + "(paciente,"
                    + "consulta,"
                    + "ambulatorio,"
                    + "fechaHoraInicio,"
                    + "tipo,"
                    + "especialidad) "
                    + "values (?,?,?,?,?,?)"
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

            //Hacemos commit
            con.commit();

            //En caso de error se captura la excepción
        } catch (SQLException e) {

            try {
                //Si unique no se cumple entonces la hora esta ocupada
                if (e.getSQLState().equals("unique_violation") && paciente.getRango() == Rango.DELUXE) {

                    //Preparamos la consulta SQL para actualizar la cita
                    stmCita = con.prepareStatement(
                            "update from cita "
                            + "set paciente = ?,"
                            + "tipo = ?,"
                            + "especialidad = ? "
                            + "where consulta = ? "
                            + "and ambulatorio = ? "
                            + "and fechaHoraInicio = ?"
                    );

                    //Sustituimos
                    stmCita.setString(1, paciente.getCIP());
                    stmCita.setString(2, cita.getTipo());
                    stmCita.setString(3, cita.getEspecialidad());
                    stmCita.setInt(4, cita.getConsulta());
                    stmCita.setInt(5, cita.getAmbulatorio());
                    stmCita.setTimestamp(6, cita.getFechaHoraInicio());

                    //Actualizamos
                    stmCita.executeUpdate();

                    //Hacemos commit
                    con.commit();

                } else {

                    //Hacemos rollback
                    con.rollback();

                    //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }
            } catch (SQLException e2) {

                String mensajeExcepcion = e2.getMessage();

                try {

                    //Hacemos rollback
                    con.rollback();

                } catch (SQLException e3) {

                    //Se añade el mensaje de excepcion
                    mensajeExcepcion += "\n" + e3.getMessage();

                } finally {

                    //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                    System.out.println(mensajeExcepcion);
                    this.getFachadaAplicacion().muestraExcepcion(mensajeExcepcion);
                }

            }

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

    //Permite insertar una nueva urgencia en la base de datos
    public void insertarUrgencia(Urgencia urgencia) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmUrgencia = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {

            //Quitamos autocommit
            con.setAutoCommit(false);

            //Preparamos la consulta SQL para insertar una nueva cita de urgencia
            stmUrgencia = con.prepareStatement(
                    "insert into cita "
                    + "(paciente,"
                    + "consulta,"
                    + "ambulatorio,"
                    + "fechaHoraInicio,"
                    + "tipo,"
                    + "especialidad) "
                    + "values (?,?,?,?,?,?)"
            );
            //Sustituimos
            stmUrgencia.setString(1, urgencia.getPaciente());
            stmUrgencia.setInt(2, urgencia.getConsulta());
            stmUrgencia.setInt(3, urgencia.getAmbulatorio());
            stmUrgencia.setTimestamp(4, urgencia.getFechaHoraInicio());
            stmUrgencia.setString(5, urgencia.getTipo());
            stmUrgencia.setString(6, urgencia.getEspecialidad());

            //Actualizamos
            stmUrgencia.executeUpdate();

            //Preparamos la consulta SQL para insertar la referencia
            //a la cita en la tabla de urgencias
            stmUrgencia = con.prepareStatement(
                    "insert into urgencia "
                    + "(paciente,"
                    + "consulta,"
                    + "ambulatorio,"
                    + "cita,"
                    + "soborno,"
                    + "gravedad) "
                    + "values (?,?,?,?,?,?)"
            );
            //Sustituimos
            stmUrgencia.setString(1, urgencia.getPaciente());
            stmUrgencia.setInt(2, urgencia.getConsulta());
            stmUrgencia.setInt(3, urgencia.getAmbulatorio());
            stmUrgencia.setTimestamp(4, urgencia.getFechaHoraInicio());
            stmUrgencia.setFloat(5, urgencia.getSoborno());
            stmUrgencia.setInt(6, urgencia.getGravedad());

            //Actualizamos
            stmUrgencia.executeUpdate();

            //Hacemos commit
            con.commit();

            //En caso de error se captura la excepción
        } catch (SQLException e) {

            String mensajeExcepcion = e.getMessage();

            try {
                //Hacemos rollback
                con.rollback();

            } catch (SQLException e2) {

                //Juntamos mensajes de excepcion
                mensajeExcepcion += "\n" + e2.getMessage();
            }
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(mensajeExcepcion);
            this.getFachadaAplicacion().muestraExcepcion(mensajeExcepcion);

        } finally {

            //Finalmente intentamos cerrar los cursores
            try {

                stmUrgencia.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Pone el timestamp de finalizacion de la cita a la actual del sistema gestor
    public void atenderCita(Cita cita) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmCita = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para insertar una fecha de finalización
            stmCita = con.prepareStatement(
                    "update from cita "
                    + "set fechaHoraFin = CURRENT_TIMESTAMP"
                    + "where fechaHoraInicio = ? "
                    + "and consulta = ? "
                    + "and ambulatorio = ? "
                    + "and paciente = ?"
            );

            //Sustituimos
            stmCita.setTimestamp(1, cita.getFechaHoraInicio());
            stmCita.setInt(2, cita.getConsulta());
            stmCita.setInt(3, cita.getAmbulatorio());
            stmCita.setString(4, cita.getPaciente());

            //Actualizamos
            stmCita.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmCita.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite insertar una relacion derivarHospital en la base de datos e
    //inserta un timestamp de finalizacion en la cita relacionada
    public void derivarHospital(Hospital hospital, Cita cita) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmDerivarHospital = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {

            //Quitamos el autocommit
            con.setAutoCommit(false);

            //Preparamos la sentencia para insertar una fecha de
            //finalización en la cita
            stmDerivarHospital = con.prepareStatement(
                    "update from cita "
                    + "set fechaHoraFin = CURRENT_TIMESTAMP"
                    + "where fechaHoraInicio = ? "
                    + "and consulta = ? "
                    + "and ambulatorio = ? "
                    + "and paciente = ?"
            );

            //Sustituimos
            stmDerivarHospital.setTimestamp(1, cita.getFechaHoraInicio());
            stmDerivarHospital.setInt(2, cita.getConsulta());
            stmDerivarHospital.setInt(3, cita.getAmbulatorio());
            stmDerivarHospital.setString(4, cita.getPaciente());

            //Actualizamos
            stmDerivarHospital.executeUpdate();

            //Preparamos la sentencia para agregar una relacion de derivarHospital
            stmDerivarHospital = con.prepareStatement(
                    "insert into derivarHospital "
                    + "(cita,"
                    + "consulta,"
                    + "ambulatorio,"
                    + "paciente,"
                    + "hospital) "
                    + "values(?,?,?,?,?)"
            );

            //Sustituimos
            stmDerivarHospital.setTimestamp(1, cita.getFechaHoraInicio());
            stmDerivarHospital.setInt(2, cita.getConsulta());
            stmDerivarHospital.setInt(3, cita.getAmbulatorio());
            stmDerivarHospital.setString(4, cita.getPaciente());
            stmDerivarHospital.setInt(5, hospital.getCodigo());

            //Actualizamos
            stmDerivarHospital.executeUpdate();

            //Hacemos commit
            con.commit();

            //En caso de error se captura la excepción
        } catch (SQLException e) {

            String mensajeExcepcion = e.getMessage();

            try {
                //Hacemos rollback
                con.rollback();

            } catch (SQLException e2) {

                //Juntamos mensajes de excepcion
                mensajeExcepcion += "\n" + e2.getMessage();
            }
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(mensajeExcepcion);
            this.getFachadaAplicacion().muestraExcepcion(mensajeExcepcion);

        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmDerivarHospital.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar las citas ocupadas entre dos fechas
    //La fecha minima siempre será el día posterior a la consulta
    public ArrayList<Timestamp> citasOcupadas(Ambulatorio ambulatorio, TipoCita tipocita, Date inicio, Date fin) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas = null;
        ArrayList<Timestamp> resultado = new ArrayList<>();

        //Comprobamos la fecha de incio
        LocalDateTime minimo = LocalDate.now().plusDays(1).atStartOfDay();
        LocalDateTime inicioLDT = inicio.toLocalDate().atStartOfDay();

        if (minimo.compareTo(inicioLDT) < 0) {
            minimo = inicioLDT;
        }

        //Recogemos la fecha en un Timestamp
        //Fecha de fin sera a las 00:00 del dia siguiente al especificado
        Timestamp inicioTS = Timestamp.valueOf(minimo);
        Timestamp finTS = Timestamp.valueOf(fin.toLocalDate().atStartOfDay().plusDays(1));

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para recoger las citas
            stmCitas = con.prepareStatement(
                    "select fechaHoraInicio"
                    + "from cita as ci, consulta as co, tipocita as t, especialidad as e"
                    + "where ci.fechaHoraInicio > ? "
                    + "and ci.fechaHoraInicio < ? "
                    + "and ci.consulta = co.identificador "
                    + "and t.tipo = ? "
                    + "and t.especialidad = e.nombre "
                    + "and e.nombre = co.especialidad "
                    + "and ci.ambulatorio = co.ambulatorio "
                    + "and co.ambulatorio = ? "
                    + "order by fechaHoraInicio asc"
            );

            //Sustituimos
            stmCitas.setTimestamp(1, inicioTS);
            stmCitas.setTimestamp(2, finTS);
            stmCitas.setString(3, tipocita.getNombre());
            stmCitas.setInt(4, ambulatorio.getCodigo());

            //Actualizamos
            rsCitas = stmCitas.executeQuery();

            //Recogemos valores de resultado
            while (rsCitas.next()) {

                resultado.add(rsCitas.getTimestamp("fechaHoraInicio"));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmCitas.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}

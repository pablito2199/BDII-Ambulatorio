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
import aplicacion.clases.Consulta;
import aplicacion.clases.PersonalSanitario;

/*
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
        ResultSet rsCita;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {

            //Quitamos autocommit
            con.setAutoCommit(false);

            if (paciente.getRango() == Rango.DELUXE) {

                //Consultamos si existe cita en la hora deseada en la consulta establecida
                //Preparamos la consulta SQL para insertar una nueva cita
                stmCita = con.prepareStatement(
                        "select * "
                        + "from cita "
                        + "where fechaHoraInicio = ? "
                        + "and consulta = ? "
                        + "and ambulatorio = ? "
                );
                //Sustituimos
                stmCita.setTimestamp(1, cita.getFechaHoraInicio());
                stmCita.setInt(2, cita.getConsulta());
                stmCita.setInt(3, cita.getAmbulatorio());

                //Actualizamos
                rsCita = stmCita.executeQuery();

                //Comprobamos si existe cita anterior y en caso afirmativo actualizamos
                if (rsCita.next()) {

                    //Preparamos la consulta SQL para actualizar la cita
                    stmCita = con.prepareStatement(
                            "update cita "
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

                } //Insertamos cita de forma normal en caso de que nadie la haya cogido anteriormente
                else {

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
                }
                //En caso de ser un usuario normal intentamos introducir de manera directa
            } else {

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
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {

            //Obtenemos mensaje
            String mensajeExcepcion = e.getMessage();

            try {

                //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());

                //Hacemos rollback
                con.rollback();

            } catch (SQLException e2) {

                //Obtenemos mensaje
                mensajeExcepcion += "\n" + e2.getMessage();

            } finally {

                //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                System.out.println(mensajeExcepcion);
                this.getFachadaAplicacion().muestraExcepcion(mensajeExcepcion);
            }

        } finally {

            //Finalmente intentamos cerrar los cursores
            try {

                //Activamos de nuevo autocommit
                con.setAutoCommit(true);

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
                    + "values (?,?,?,?,'Urgencia','General')"
            );
            //Sustituimos
            stmUrgencia.setString(1, urgencia.getPaciente());
            stmUrgencia.setInt(2, urgencia.getConsulta());
            stmUrgencia.setInt(3, urgencia.getAmbulatorio());
            stmUrgencia.setTimestamp(4, urgencia.getFechaHoraInicio());

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

                //Activamos de nuevo autocommit
                con.setAutoCommit(true);

                stmUrgencia.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Pone el timestamp de finalizacion de la cita al actual del sistema gestor
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
                    "update cita "
                    + "set fechaHoraFin = CURRENT_TIMESTAMP "
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

            //Feedback
            this.getFachadaAplicacion().muestraMensaje("Paciente atendido correctamente.");

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            String mensaje;
            if (e.getSQLState().equals("23514"/*check_violation*/)) {
                mensaje = "La cita que se intenta finalizar aun no ha podido ser atendida.";
            } else {
                mensaje = e.getMessage();
            }

            System.out.println(mensaje);
            this.getFachadaAplicacion().muestraExcepcion(mensaje);

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
                    "update cita "
                    + "set fechaHoraFin = CURRENT_TIMESTAMP "
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

            //Feedback
            this.getFachadaAplicacion().muestraMensaje("Paciente derivado correctamente.");

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
            String mensaje;
            if (e.getSQLState().equals("23514"/*check_violation*/)) {
                mensaje = "La cita que se intenta derivar aun no ha podido ser atendida.";
            } else {
                mensaje = mensajeExcepcion;
            }

            System.out.println(mensaje);
            this.getFachadaAplicacion().muestraExcepcion(mensaje);

        } finally {
            //Finalmente intentamos cerrar cursores
            try {

                //Activamos de nuevo autocommit
                con.setAutoCommit(true);

                stmDerivarHospital.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar las horas ocupadas entre dos fechas en una consulta
    //La fecha minima siempre será el día posterior a la consulta
    public ArrayList<Timestamp> citasOcupadas(Consulta consulta, Date inicio, Date fin) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas;
        ArrayList<Timestamp> resultado = new ArrayList<>();

        //Comprobamos la fecha de incio
        LocalDateTime minimo = LocalDate.now().atStartOfDay();
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
                    "select ci.fechaHoraInicio "
                    + "from cita as ci "
                    + "where ci.fechaHoraInicio > ? "
                    + "and ci.fechaHoraInicio < ? "
                    + "and ci.fechaHoraFin is null "
                    + "and ci.consulta = ? "
                    + "and ci.ambulatorio = ? "
                    + "and not exists (select ur.cita "
                    + "from urgencia as ur "
                    + "where ur.cita = ci.fechaHoraInicio "
                    + "and ci.consulta = ur.consulta "
                    + "and ci.ambulatorio = ur.ambulatorio "
                    + "and ci.paciente = ur.paciente) "
                    + "order by ci.fechaHoraInicio asc"
            );

            //Sustituimos
            stmCitas.setTimestamp(1, inicioTS);
            stmCitas.setTimestamp(2, finTS);
            stmCitas.setInt(3, consulta.getIdentificador());
            stmCitas.setInt(4, consulta.getAmbulatorio());

            //Obtenemos resultado
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

    //Permite consultar la lista de urgencias pendientes de atender en un ambulatorio
    public ArrayList<Urgencia> urgenciasPendientes(Ambulatorio ambulatorio) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmUrgencias = null;
        ResultSet rsUrgencias;
        ArrayList<Urgencia> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para recoger las citas
            stmUrgencias = con.prepareStatement(
                    "select c.*, u.*, least(10, u.gravedad + floor(u.soborno * 0.01)) as prioridad, p.nombre "
                    + "from cita as c, urgencia as u, paciente as p "
                    + "where c.fechaHoraInicio = u.cita "
                    + "and c.fechaHoraFin is null "
                    + "and c.consulta = u.consulta "
                    + "and c.ambulatorio = u.ambulatorio "
                    + "and c.ambulatorio = ? "
                    + "and p.cip = c.paciente "
                    + "order by prioridad desc, c.fechaHoraInicio asc"
            );

            //Sustituimos
            stmUrgencias.setInt(1, ambulatorio.getCodigo());

            //Obtenemos resultado
            rsUrgencias = stmUrgencias.executeQuery();

            //Recogemos valores de resultado
            while (rsUrgencias.next()) {

                resultado.add(new Urgencia(
                        rsUrgencias.getFloat("soborno"),
                        rsUrgencias.getInt("gravedad"),
                        rsUrgencias.getInt("prioridad"),
                        rsUrgencias.getString("nombre"),
                        rsUrgencias.getTimestamp("fechaHoraInicio"),
                        rsUrgencias.getString("paciente"),
                        rsUrgencias.getInt("consulta"),
                        rsUrgencias.getInt("ambulatorio")
                ));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmUrgencias.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    //Permite consultar la lista de citas pendientes de atender de un paciente
    public ArrayList<Cita> citasPaciente(Paciente paciente, String ambulatorio, Integer consulta, Date inicio, Date fin) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas;
        ArrayList<Cita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Ajustamos las lineas de la consulta para ajustarnos a los argumentos
        String lineaHoras = "";
        Timestamp inicioTS = null;
        Timestamp finTS = null;
        //Horas
        if (inicio != null && fin != null) {
            lineaHoras = "and ci.fechaHoraInicio > ? and ci.fechaHoraInicio < ? ";

            //Establecemos timestamps
            inicioTS = Timestamp.valueOf(inicio.toLocalDate().atStartOfDay());
            finTS = Timestamp.valueOf(fin.toLocalDate().plusDays(1).atStartOfDay());
        }
        //Consulta
        String lineaConsulta = consulta == null ? "" : "and ci.consulta = ? ";

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes
            //Nos aseguramos que las citas no sean urgencias
            stmCitas = con.prepareStatement(
                    "select ci.* "
                    + "from cita as ci, ambulatorio as am "
                    + "where paciente = ? "
                    + "and fechaHoraFin is null "
                    + "and ci.tipo not in (select ti.nombre"
                    + "                    from tipocita as ti "
                    + "                    where ti.especialidad = 'General') "
                    + "and am.codigoAmbulatorio = ci.ambulatorio "
                    + "and am.nombre like ? "
                    + lineaHoras
                    + lineaConsulta
                    + "order by ci.fechaHoraInicio asc"
            );
            //Obtenemos string del ambulatorio
            String ambulatorioBusq = ambulatorio == null ? "%%" : "%" + ambulatorio + "%";

            //Sustituimos
            stmCitas.setString(1, paciente.getCIP());
            stmCitas.setString(2, ambulatorioBusq);
            //Comprobamos si se consultan horas
            int index = 3; //Indice del string de consulta
            if (!lineaHoras.isEmpty()) {
                stmCitas.setTimestamp(3, inicioTS);
                stmCitas.setTimestamp(4, finTS);
                index += 2; //Ajustamos indices
            } //Compribamos si se consultan las consultas
            if (!lineaConsulta.isEmpty()) {
                stmCitas.setInt(index, consulta);
            }

            //Obtenemos resultado
            rsCitas = stmCitas.executeQuery();

            //Recogemos valores de resultado
            while (rsCitas.next()) {

                resultado.add(new Cita(
                        rsCitas.getTimestamp("fechaHoraInicio"),
                        rsCitas.getString("paciente"),
                        rsCitas.getInt("consulta"),
                        rsCitas.getInt("ambulatorio"),
                        rsCitas.getString("tipo"),
                        rsCitas.getString("especialidad")
                ));
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

    //Permite consultar la lista de citas pendientes de atender de un paciente
    public ArrayList<Cita> citasMedico(PersonalSanitario medico, String ambulatorio, Date inicio, Date fin) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas;
        ArrayList<Cita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Ajustamos las lineas de la consulta para ajustarnos a los argumentos
        String lineaHoras = "";
        Timestamp inicioTS = null;
        Timestamp finTS = null;
        //Horas
        if (inicio != null && fin != null) {
            lineaHoras = "and ci.fechaHoraInicio > ? and ci.fechaHoraInicio < ? ";

            //Establecemos timestamps
            inicioTS = Timestamp.valueOf(inicio.toLocalDate().atStartOfDay());
            finTS = Timestamp.valueOf(fin.toLocalDate().plusDays(1).atStartOfDay());
        }

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes de
            //todas las consultas donde trabaja un medico
            stmCitas = con.prepareStatement(
                    "select ci.* "
                    + "from cita as ci, ambulatorio as am, personalsanitario as pe, consulta as co, pertenecer as pt "
                    + "where fechaHoraFin is null "
                    + "and am.codigoAmbulatorio = co.ambulatorio "
                    + "and am.codigoAmbulatorio = pe.ambulatorio "
                    + "and pt.ambulatorioPersonal = pe.ambulatorio "
                    + "and pt.personal = pe.dni "
                    + "and pt.consulta = co.identificador "
                    + "and pt.ambulatorioConsulta = co.ambulatorio "
                    + "and co.identificador = ci.consulta "
                    + "and co.ambulatorio = ci.ambulatorio "
                    + "and co.especialidad in (select ep.especialidad "
                    + "                        from especializacionpersonal as ep "
                    + "                        where ep.personal = pe.dni "
                    + "                        and not ep.especialidad = 'General') "
                    + "and am.nombre like ? "
                    + "and pe.dni = ? "
                    + lineaHoras
                    + "order by ci.fechaHoraInicio asc"
            );

            //Obtenemos string del ambulatorio
            String ambulatorioBusq = ambulatorio == null ? "%%" : "%" + ambulatorio + "%";

            //Sustituimos
            stmCitas.setString(1, ambulatorioBusq);
            stmCitas.setString(2, medico.getDNI());
            //Comprobamos si se consultan horas
            if (!lineaHoras.isEmpty()) {
                stmCitas.setTimestamp(3, inicioTS);
                stmCitas.setTimestamp(4, finTS);
            }
            //Obtenemos resultado
            rsCitas = stmCitas.executeQuery();

            //Recogemos valores de resultado
            while (rsCitas.next()) {

                resultado.add(new Cita(
                        rsCitas.getTimestamp("fechaHoraInicio"),
                        rsCitas.getString("paciente"),
                        rsCitas.getInt("consulta"),
                        rsCitas.getInt("ambulatorio"),
                        rsCitas.getString("tipo"),
                        rsCitas.getString("especialidad")
                ));
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

    //Permite consultar la lista tipos de cita buscando por especialidad
    public ArrayList<TipoCita> obtenerTiposDeCita(String especialidad) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmTipo = null;
        ResultSet rsTipo;
        ArrayList<TipoCita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes de
            //todas las consultas donde trabaja un medico
            stmTipo = con.prepareStatement(
                    "select ti.* "
                    + "from tipocita as ti "
                    + "where ti.especialidad like ?"
            );

            //Obtenemos string
            String esp = especialidad == null ? "%%" : "%" + especialidad + "%";

            //Sustituimos
            stmTipo.setString(1, esp);

            //Obtenemos resultado
            rsTipo = stmTipo.executeQuery();

            //Recogemos valores de resultado
            while (rsTipo.next()) {

                resultado.add(new TipoCita(
                        rsTipo.getString("nombre"),
                        rsTipo.getString("especialidad"),
                        rsTipo.getString("descripcion")
                ));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmTipo.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    //Permite consultar la lista citas pendientes del paciente filtrada
    public void borrarCita(Cita cita) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCita = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes de
            //todas las consultas donde trabaja un medico
            stmCita = con.prepareStatement(
                    "delete from cita "
                    + "where fechaHoraInicio = ? "
                    + "and paciente = ? "
                    + "and consulta = ? "
                    + "and ambulatorio = ?"
            );

            //Sustituimos
            stmCita.setTimestamp(1, cita.getFechaHoraInicio());
            stmCita.setString(2, cita.getPaciente());
            stmCita.setInt(3, cita.getConsulta());
            stmCita.setInt(4, cita.getAmbulatorio());

            //Borramos
            stmCita.executeUpdate();

            //Feedback
            this.getFachadaAplicacion().muestraMensaje("Cita cancelada correctamente.");

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
}

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
                //Actualizamos la cita si el paciente es deluxe
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
                    "update from cita "
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

    //Permite consultar las citas ocupadas entre dos fechas en una consulta
    //La fecha minima siempre será el día posterior a la consulta
    public ArrayList<Timestamp> citasOcupadas(Consulta consulta, Date inicio, Date fin) {

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
                    + "from cita as ci "
                    + "where ci.fechaHoraInicio > ? "
                    + "and ci.fechaHoraInicio < ? "
                    + "and ci.fechaHoraFin is null"
                    + "and ci.consulta = ? "
                    + "and ci.ambulatorio = ? "
                    + "and not exists (select u.cita "
                    + "from urgencia as u "
                    + "where u.cita = ci.fechaHoraInicio "
                    + "and ci.consulta = u.consulta "
                    + "and ci.ambulatorio = u.ambulatorio"
                    + "and ci.paciente = u.paciente) "
                    + "order by fechaHoraInicio asc"
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
    public ArrayList<Cita> citasPaciente(Paciente paciente) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas = null;
        ArrayList<Cita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes
            //Nos aseguramos que las citas no sean urgencias
            stmCitas = con.prepareStatement(
                    "select c.* "
                    + "from cita as c "
                    + "where c.fechaHoraFin is null "
                    + "c.paciente = ? "
                    + "and not exists "
                    + "(select c.fechaHoraInicio "
                    + "from urgencia as u "
                    + "where c.fechaHoraInicio = u.cita "
                    + "and c.ambulatorio = u.ambulatorio "
                    + "and c.consulta = u.consulta "
                    + "and c.paciente = u.paciente) "
                    + "order by c.fechaHoraInicio asc"
            );

            //Sustituimos
            stmCitas.setString(1, paciente.getCIP());

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
    public ArrayList<Cita> citasMedico(PersonalSanitario medico) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas = null;
        ArrayList<Cita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes de
            //todas las consultas donde trabaja un medico
            stmCitas = con.prepareStatement(
                    "select ci.* "
                    + "from cita as ci, consulta as co, pertenecer as p"
                    + "where ci.fechaHoraFin is null "
                    + "and ci.consulta = co.identificador "
                    + "and ci.ambulatorio = co.ambulatorio "
                    + "and p.ambulatorioPersonal = ? "
                    + "and p.ambulatorioPersonal = co.ambulatorio "
                    + "and p.personal = ? "
                    + "and p.consulta = co.identificador "
                    + "and co.especialidad in "
                    + "(select ep.especialidad "
                    + "from especializacionpersonal as ep "
                    + "where ep.personal = p.personal "
                    + "and ep.ambulatorio = p.ambulatorioPersonal) "
                    + "order by ci.fechaHoraInicio asc"
            );

            //Sustituimos
            stmCitas.setInt(1, medico.getAmbulatorio());
            stmCitas.setString(2, medico.getDNI());

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
        ResultSet rsTipo = null;
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
    public ArrayList<Cita> obtenerCitas(String ambulatorio, Integer consulta, Date inicio, Date fin) {

        //Declaramos variables
        Connection con;
        PreparedStatement stmCitas = null;
        ResultSet rsCitas = null;
        ArrayList<Cita> resultado = new ArrayList<>();

        //Establecemos conexión
        con = super.getConexion();

        //Pasamos las fechas a timestamp
        Timestamp inicioTS = inicio == null ? Timestamp.valueOf(LocalDateTime.now()) : Timestamp.valueOf(inicio.toLocalDate().atStartOfDay());
        Timestamp finTS = fin == null ? Timestamp.valueOf(LocalDateTime.now().plusYears(1)) : Timestamp.valueOf(fin.toLocalDate().plusDays(1).atStartOfDay());

        //Comprobamos si se va a buscar por consulta
        String busCons = consulta == null ? "" : "and co.identificador = ? ";

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para obtener las citas pendientes de
            //todas las consultas donde trabaja un medico
            stmCitas = con.prepareStatement(
                    "select ci.* "
                    + "from cita as ci, consulta as co, ambulatorio as am "
                    + "where ci.consulta = co.identificador "
                    + "and co.ambulatorio = ci.ambulatorio "
                    + "and co.ambulatorio = am.codigo "
                    + "and am.nombre like ? "
                    + "and ci.fechaInicioCita > ? "
                    + "and ci.fechaInicioCita < ? "
                    + busCons
            );

            //Obtenemos string
            String amb = ambulatorio == null ? "%%" : "%" + ambulatorio + "%";

            //Sustituimos
            stmCitas.setString(1, ambulatorio);
            stmCitas.setTimestamp(2, inicioTS);
            stmCitas.setTimestamp(3, finTS);
            if (!busCons.isEmpty()) {
                stmCitas.setInt(4, consulta);
            }

            //Actualizamos
            rsCitas = stmCitas.executeQuery();

            //Recogemos valores de resultado
            while (rsCitas.next()) {

                resultado.add(new Cita(
                        rsCitas.getTimestamp("fechaHoraIicio"),
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
                    "delete from cita"
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

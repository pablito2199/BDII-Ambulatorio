package baseDatos;

import aplicacion.clases.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author Pablo Tarrío Otero
 */
public class DAOConsultas extends AbstractDAO {

    //Contructor
    public DAOConsultas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar una nueva consulta en la base de datos
    public void insertarConsulta(Consulta consulta) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmConsulta = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de consultas una nueva consulta 
            //con el identificador, ambulatorio y especialidad de consulta especificados
            stmConsulta = con.prepareStatement("insert into consulta (identificador, ambulatorio, especialidad) "
                    + "values (?,?,?)");
            //Sustituimos
            stmConsulta.setInt(1, consulta.getIdentificador());
            stmConsulta.setInt(2, consulta.getAmbulatorio());
            stmConsulta.setString(3, consulta.getEspecialidad());

            //Actualizamos
            stmConsulta.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Consulta añadida correctamente.");

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmConsulta.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar una consulta de la base de datos
    public void borrarConsulta(Integer identificador, Integer ambulatorio, String especialidad) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmConsulta = null;
        String esp = especialidad == null ? "" : "and especialidad = ?";

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de consultas aquel con el identificador especificado por argumentos del propio ambulatorio
            stmConsulta = con.prepareStatement("delete from consulta where identificador = ? and ambulatorio = ? " + esp);
            //Sustituimos
            stmConsulta.setInt(1, identificador);  //identificador de la consulta
            stmConsulta.setInt(2, ambulatorio);  //ambulatorio de la consulta
            if (especialidad != null) {
                stmConsulta.setString(3, especialidad);  //especialidad de la consulta
            }
            //Actualizamos
            stmConsulta.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Consulta eliminada correctamente.");

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmConsulta.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar las consultas existentes en la base de datos
    public java.util.List<Consulta> consultarConsultas(Integer identificador, Integer ambulatorio, String especialidad) {
        //Declaramos variables
        java.util.List<Consulta> resultado = new java.util.ArrayList<>();
        Consulta consultaActual;
        Connection con;
        PreparedStatement stmConsultas = null;
        ResultSet rsConsultas;//Variable para buscar por codigo
        String esp = especialidad == null ? "" : "and especialidad = ? ";
        String id = identificador == null ? "" : "and identificador = ? ";

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el identificador, ambulatorio y especialdiad
            //que tengan el identificador dado
            String consulta = "select identificador, ambulatorio, especialidad "
                    + "from consulta "
                    + "where ambulatorio = ? "
                    + esp
                    + id
                    + "order by identificador ASC";

            //Preparamos la consulta
            stmConsultas = con.prepareStatement(consulta);
            //Sustituimos
            stmConsultas.setInt(1, ambulatorio); //Ambulatorio
            if (especialidad != null && identificador != null) {
                stmConsultas.setString(2, especialidad); //Especialidad
                stmConsultas.setInt(3, identificador); //Identificador
            } else if (especialidad != null) {
                stmConsultas.setString(2, especialidad); //Especialidad
            } else if (identificador != null) {
                stmConsultas.setInt(2, identificador); //Identificador
            }

            //Ejecutamos
            rsConsultas = stmConsultas.executeQuery();
            //Mientras haya coincidencias
            while (rsConsultas.next()) {
                //Se crea una instancia de consulta con los datos recuperados de la base de datos
                consultaActual = new Consulta(rsConsultas.getInt("identificador"), rsConsultas.getInt("ambulatorio"), rsConsultas.getString("especialidad"));
                //Y se añade la instancia a la lista de consultas
                resultado.add(consultaActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmConsultas.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de consultas)
        return resultado;
    }

    //Devuelve el número de consultas de un ambulatorio
    public Integer numeroConsultas(Integer ambulatorio, String especialidad, Integer identificador) {
        //Declaramos variables
        Integer consultas = 0;
        Connection con;
        PreparedStatement stmAmbulatorios = null;
        ResultSet rsAmbulatorios;
        String esp = especialidad == null ? "" : "and especialidad = ? ";
        String cons = identificador == null ? "" : "and identificador = ?";
        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select COUNT(distinct identificador) as consultas "
                    + "from consulta "
                    + "where ambulatorio = ? "
                    + esp
                    + cons;
            //Preparamos la consulta
            stmAmbulatorios = con.prepareStatement(consulta);

            //Sustituimos
            stmAmbulatorios.setInt(1, ambulatorio);
            if (especialidad != null && identificador != null) {
                stmAmbulatorios.setString(2, especialidad);
                stmAmbulatorios.setInt(3, identificador);
            } else if (especialidad != null) {
                stmAmbulatorios.setString(2, especialidad);
            } else if (identificador != null) {
                stmAmbulatorios.setInt(2, identificador);
            }

            //Ejecutamos
            rsAmbulatorios = stmAmbulatorios.executeQuery();
            rsAmbulatorios.next();

            consultas = rsAmbulatorios.getInt("consultas");
        } //En caso de error se captura la excepción
        catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmAmbulatorios.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (total de consultas de un ambulatorio)
        return consultas;
    }

    //Permite obtener la consulta con menos citas pendientes
    public Consulta menorNumeroPacientes(Integer ambulatorio, String especialidad) {
        //Declaramos variables
        Consulta menorNumero = new Consulta();
        Connection con;
        PreparedStatement stmConsultas = null;
        ResultSet rsConsultas;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos los datos deseamos
            //Según los argumentos pasados
            String consulta
                    = "with menor as (select count(*) as cuenta, co.identificador, co.ambulatorio, co.especialidad "
                    + "from consulta as co, cita as ci "
                    + "where co.especialidad = ? "
                    + "and co.ambulatorio = ? "
                    + "and co.identificador = ci.consulta "
                    + "and co.ambulatorio = ci.ambulatorio "
                    + "and ci.fechaHoraFin is null "
                    + "group by co.identificador, co.ambulatorio, co.especialidad "
                    + "UNION "
                    + "select 0 as cuenta, co.identificador, co.ambulatorio, co.especialidad "
                    + "from consulta as co "
                    + "where co.especialidad = ? "
                    + "and co.ambulatorio = ? "
                    + "and not exists (select co2.identificador "
                    + "				from consulta as co2, cita as ci2 "
                    + "				where co2.especialidad = co.especialidad "
                    + "				and co2.ambulatorio = co.ambulatorio "
                    + "				and co2.identificador = ci2.consulta "
                    + "				and co2.ambulatorio = ci2.ambulatorio "
                    + "				and ci2.fechaHoraFin is null "
                    + "			    and co2.identificador = co.identificador)) "
                    + "select me.identificador, me.ambulatorio, me.especialidad "
                    + "from menor as me "
                    + "where not exists (select me2.* "
                    + "                  from menor as me2 "
                    + "                  where me2.cuenta < me.cuenta)";
            //Preparamos la consulta
            stmConsultas = con.prepareStatement(consulta);

            //Sustituimos
            stmConsultas.setString(1, especialidad); //Especialidad 1
            stmConsultas.setInt(2, ambulatorio);     //Ambulatorio 1
            stmConsultas.setString(3, especialidad); //Especialidad 2
            stmConsultas.setInt(4, ambulatorio);     //Ambulatorio 2

            //Ejecutamos
            rsConsultas = stmConsultas.executeQuery();

            //Cogemos la primera coincidencia
            if (rsConsultas.next()) {
                //Se crea una instancia de consulta con los datos de la consulta con el menor número de pacientes de la base de datos
                menorNumero = new Consulta(
                        rsConsultas.getInt("identificador"),
                        rsConsultas.getInt("ambulatorio"),
                        rsConsultas.getString("especialidad"));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());

        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmConsultas.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }

        return menorNumero;
    }
}

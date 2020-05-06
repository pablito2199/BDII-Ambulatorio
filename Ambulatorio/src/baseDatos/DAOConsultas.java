package baseDatos;

import aplicacion.clases.Consulta;
import aplicacion.clases.TipoCita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
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
            //Preparamos la sentencia para borrar de la tabla de consultas aquel con el identificador especificado por argumentos
            stmConsulta = con.prepareStatement("delete from consulta where identificador = ? and ambulatorio = ? " + esp);
            //Sustituimos
            stmConsulta.setInt(1, identificador);  //identificador de la consulta
            stmConsulta.setInt(2, ambulatorio);  //ambulatorio de la consulta
            if (especialidad != null) {
                stmConsulta.setString(3, especialidad);  //especialidad de la consulta
            }
            //Actualizamos
            stmConsulta.executeUpdate();

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
        String id = identificador == null ? "" : "and identificador = ?";
        String esp = especialidad == null ? "" : "and especialidad = ?";

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
                    + id;

            //Preparamos la consulta
            stmConsultas = con.prepareStatement(consulta);
            //Sustituimos
            stmConsultas.setInt(1, ambulatorio); //Ambulatorio
            if (especialidad != null) {
                stmConsultas.setString(2, especialidad); //Especialidad
            } else if (especialidad != null && identificador != null) {
                stmConsultas.setString(2, especialidad); //Especialidad
                stmConsultas.setInt(2, identificador); //Identificador
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
    public Integer numeroConsultas(Integer ambulatorio, String especialidad) {
        //Declaramos variables
        Integer consultas = 0;
        Connection con;
        PreparedStatement stmAmbulatorios = null;
        ResultSet rsAmbulatorios;
        String esp = especialidad == null ? "" : "and especialidad = ?";

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select COUNT(distinct identificador) as consultas "
                    + "from consulta "
                    + "where ambulatorio = ? "
                    + esp;
            //Preparamos la consulta
            stmAmbulatorios = con.prepareStatement(consulta);

            //Sustituimos
            stmAmbulatorios.setInt(1, ambulatorio);
            if (especialidad != null) {
                stmAmbulatorios.setString(2, "%" + especialidad + "%");
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
    public Consulta menorNumeroPacientes(Integer ambulatorio, TipoCita tipoCita) {
        //Declaramos variables
        Consulta menorNumero = new Consulta();
        Connection con;
        PreparedStatement stmConsultas = null;
        ResultSet rsConsultas;

        //Establecemos conexión
        con = this.getConexion();

        //Impedimos que la confirmación sea automática
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el identificador, ambulatorio y especialdiad
            //que tengan el ambulatorio dado
            String consulta = "select c1.* "
                    + "from consulta as c1 "
                    + "where c1.ambulatorio = ? "
                    + "and c1.especialidad = ? "
                    + "having count(*) <= any(select count(*) from consulta as c2"
                    + "where c1.ambulatorio = ? "
                    + "and c1.especialidad = ? ";
            //Preparamos la consulta
            stmConsultas = con.prepareStatement(consulta);
            //Sustituimos
            stmConsultas.setInt(1, ambulatorio); //Ambulatorio
            stmConsultas.setString(2, tipoCita.getEspecialidad()); //Especialidad
            //Ejecutamos
            rsConsultas = stmConsultas.executeQuery();
            //Mientras haya coincidencias
            while (rsConsultas.next()) {
                //Se crea una instancia de consulta con los datos de la consulta con el menor número de pacientes de la base de datos
                menorNumero = new Consulta(rsConsultas.getInt("identificador"), rsConsultas.getInt("ambulatorio"), rsConsultas.getString("especialidad"));
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            try {
                //Como ha fallado deshacemos
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            //Finalmente se intentan cerrar cursores
            try {
                stmConsultas.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        try {
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }
        //Pedimos que vuelva a hacer los commits automáticamente
        try {
            //Impedimos que se la confirmación sea automática
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }
        return menorNumero;
    }
}

package baseDatos;

import aplicacion.clases.Paciente;
import aplicacion.clases.Receta;
import aplicacion.clases.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* 
 * @author Ainhoa Vivel Couso
 */
public class DAORecetas extends AbstractDAO {
    //Contructor

    public DAORecetas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar un nueva receta en la base de datos
    public void insertarReceta(Receta receta) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmReceta = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de pacientes un nuevo paciente con el id de paciente, nombre
            //clave, dirección, email y tipo de paciente especificados
            stmReceta = con.prepareStatement("insert into receta (cita, paciente, consulta, medicamento, cantidad, descripcion, fechaInicio, fechaFin) "
                    + "values (?, ?, ?, ?, ?, ?, current_date, ?)");
            //Sustituimos
            stmReceta.setTimestamp(1, receta.getCita());
            stmReceta.setString(2, receta.getPaciente());
            stmReceta.setInt(3, receta.getConsulta());
            stmReceta.setString(4, receta.getMedicamento());
            stmReceta.setInt(5, receta.getCantidad());
            stmReceta.setString(6, receta.getDescripcion());
            stmReceta.setDate(7, receta.getFechaFin());

            //Actualizamos
            stmReceta.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmReceta.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<Receta> consultarHistorialReceta(Paciente paciente, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin, Integer codigoReceta, String medicamento) {
        //Declaramos variables
        java.util.List<Receta> resultado = new java.util.ArrayList<Receta>();
        Receta recetaActual;
        Connection con;
        PreparedStatement stmHistorial = null;
        ResultSet rsHistorial;

        //Establecemos conexión
        con = this.getConexion();
        //Impedimos que se la confirmación sea automática
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select cita, fechaHoraInicio, fechaHoraFin, paciente, codigoReceta, medicamento, cantidad "
                    + "from receta where paciente = ? "
                    + "and codigoReceta = ? "
                    + "and medicamento = ? "
                    + "and fechaHoraFin-fechaHoraInicio>=0 "
                    + "and fechaHoraFin <= ? "
                    + "and fechaHoraInicio >= ?;";
            //Preparamos la consulta
            stmHistorial = con.prepareStatement(consulta);
            //Sustituimos
            stmHistorial.setString(1, paciente.getCIP());
            stmHistorial.setInt(2, codigoReceta);
            stmHistorial.setString(3, medicamento);
            stmHistorial.setTimestamp(4, fechaFin);
            stmHistorial.setTimestamp(5, fechaInicio);

            //Ejecutamos
            rsHistorial = stmHistorial.executeQuery();
            //Mientras haya coincidencias
            while (rsHistorial.next()) {
                //Se crea una instancia de cita con los datos recuperados de la base de datos
                recetaActual = new Receta(rsHistorial.getTimestamp("cita"),
                        rsHistorial.getString("paciente"),
                        rsHistorial.getInt("codigoReceta"),
                        rsHistorial.getDate("fechaHoraInicio"),
                        rsHistorial.getDate("fechaHoraFin"),
                        rsHistorial.getString("medicamento"),
                        rsHistorial.getInt("cantidad"));
                //Y se añade la instancia a la lista de pacientes
                resultado.add(recetaActual);
            }
        } //En caso de error se captura la excepción
        catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
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
                stmHistorial.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        try {
            //Confirmamos
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }

    //Permite consultar el historial clínico de un paciente
    public java.util.List<String> consultarMedicamentos(String nombre) {
        //Declaramos variables
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        Connection con;
        PreparedStatement stmMedicamentos = null;
        ResultSet rsMedicamentos;

        //Establecemos conexión
        con = this.getConexion();
        
        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select nombre from Medicamento where nombre like ?;";
            //Preparamos la consulta
            stmMedicamentos = con.prepareStatement(consulta);
            //Sustituimos
            stmMedicamentos.setString(1, "%" + nombre + "%");
            
            //Ejecutamos
            rsMedicamentos = stmMedicamentos.executeQuery();
            //Mientras haya coincidencias
            while (rsMedicamentos.next()) {
                //Y se el resultado a la lista de pacientes
                resultado.add(rsMedicamentos.getString("nombre"));
            }
        } //En caso de error se captura la excepción
        catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
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
                stmMedicamentos.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Se devuelve el resultado (lista de pacientes)
        return resultado;
    }   
}

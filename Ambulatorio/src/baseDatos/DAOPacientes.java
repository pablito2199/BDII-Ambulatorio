package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.Paciente;
import aplicacion.GrupoSanguineo;
import aplicacion.Rango;
import aplicacion.Cita;

/* 
 * @author Ainhoa Vivel Couso
 */
public class DAOPacientes extends AbstractDAO {
    
    //Contructor
    public DAOPacientes(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar un nuevo paciente en la base de datos
    public void insertarPaciente(Paciente paciente) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPaciente = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de pacientes un nuevo paciente con el id de paciente, nombre
            //clave, dirección, email y tipo de paciente especificados
            stmPaciente = con.prepareStatement("insert into paciente (cip, dni, numSeguridadSocial, nombre, fechaNacimiento, "
                    + "sexo, grupoSanguineo, nacionalidad, direccion, telefono) "
                    + "values (?,?,?,?,?,?,?,?,?,?)");
            //Sustituimos
            stmPaciente.setString(1, paciente.getCIP());        
            stmPaciente.setString(2, paciente.getDNI());       
            stmPaciente.setInt(3, paciente.getNSS()); 
            stmPaciente.setString(4, paciente.getNombre());
            stmPaciente.setDate(5, paciente.getFechaNacimiento());     
            stmPaciente.setString(6, paciente.getSexo()); 
            stmPaciente.setString(7, paciente.getGrupo().getTipo()); 
            stmPaciente.setString(8, paciente.getNacionalidad()); 
            stmPaciente.setString(9, paciente.getDireccion()); 
            stmPaciente.setString(10, paciente.getTelefono()); 

            //Actualizamos
            stmPaciente.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmPaciente.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar un paciente de la base de datos
    public void borrarPaciente(Paciente paciente) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmPaciente = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de pacientes aquel con la id especificada por argumentos
            stmPaciente = con.prepareStatement("delete from paciente where cip = ?");
            //Sustituimos
            stmPaciente.setString(1, paciente.getCIP());  //CIP del paciente
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
    public java.util.List<Paciente> consultarPacientes(String CIP, String DNI, String nombre, Integer edad, String sexo, String NSS, String grupo) {
        //Declaramos variables
        java.util.List<Paciente> resultado = new java.util.ArrayList<Paciente>();
        Paciente pacienteActual;
        Connection con;
        PreparedStatement stmPacientes = null;
        ResultSet rsPacientes;
        PreparedStatement stmRango = null;
        ResultSet rsRango;

        String subconsulta;        
        //Establecemos conexión
        con = this.getConexion();
        //Impedimos que se la confirmación sea automática
        try {
            con.setAutoCommit(false);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select cip, dni, nombre, FechaNacimiento, EXTRACT(YEAR FROM age(current_date, FechaNacimiento)) as edad," 
                    + "sexo, grupoSanguineo "
                    + "from paciente "
                    + "where cip like ? "
                    + "and dni like ?"
                    + "and nombre like ?"
                    + "and EXTRACT(YEAR FROM age(current_date, FechaNacimiento)) = ?"
                    + "and sexo like ?"
                    + "and NSS like ?"
                    + "and grupoSanguineo like ?";

            //Preparamos la consulta
            stmPacientes = con.prepareStatement(consulta);
            //Sustituimos
            stmPacientes.setString(1, "%" + CIP + "%");
            stmPacientes.setString(2, "%" + DNI + "%");
            stmPacientes.setString(3, "%" + nombre + "%"); 
            stmPacientes.setInt(4, edad); 
            stmPacientes.setString(5, "%" + sexo + "%"); 
            stmPacientes.setString(6, "%" + NSS + "%"); 
            stmPacientes.setString(7, "%" + nombre + "%"); 
            stmPacientes.setString(8, "%" + grupo + "%"); 
 
            //Ejecutamos
            rsPacientes = stmPacientes.executeQuery();
            //Mientras haya coincidencias
            while (rsPacientes.next()) {
                //Se crea una instancia de paciente con los datos recuperados de la base de datos
                pacienteActual = new Paciente(rsPacientes.getString("cip"), 
                        rsPacientes.getString("dni"),
                        rsPacientes.getInt("numSeguridadSocial"), 
                        rsPacientes.getString("nombre"), 
                        rsPacientes.getDate("fechaNacimiento"),
                        rsPacientes.getString("sexo"), 
                        GrupoSanguineo.getTipo(rsPacientes.getString("grupoSanguineo")), 
                        rsPacientes.getString("nacionalidad"),
                        rsPacientes.getString("direccion"), 
                        rsPacientes.getString("telefono"),
                        rsPacientes.getInt("edad"), 
                        Rango.getTipo(rsPacientes.getString("rango")));
               
                //Intentamos la otra consulta para recuperar los datos del autor
                try {
                    //Recuperamos el nombre del autor de la tabla de autores donde el libro sea el que pedimos y ordenamos
                    subconsulta = "select " 
                        + "CASE " 
                        + "WHEN SUM(distinct soborno)>500 THEN 'deluxe " 
                        + "WHEN COUNT(distinct paciente)>5 and SUM(distinct soborno)>=50  THEN 'premium' "
                        + "ELSE 'base' "
                        + "END  as rango "
                        + "from urgencia where paciente = ?"
                        + "group by paciente, soborno;";
                    stmRango = con.prepareStatement(subconsulta);
                    
                    //Sustituimos con los datos propordionados
                    stmRango.setString(1, pacienteActual.getCIP()); //Id del libro
                    

                    //Ejecutamos la consulta
                    rsRango = stmRango.executeQuery();
                    //Mientras haya coincidencias
                    if (rsRango.next()) {
                        //Añadimos al autor a la lista de autores del libro
                        pacienteActual.setRango(Rango.getTipo(rsRango.getString("rango")));
                    }
                    //En caso de fallar capturamos  la excepción
                } catch (SQLException e) {
                    //Imprimimos y generamos ventana
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                    //Como ha fallado deshacemos
                    con.rollback();
                } finally {
                    //Finalmente cerramos la conexión de AUTORES
                    //La de libros sigue abierta
                    try {
                        stmRango.close();
                    } catch (SQLException e) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Y se añade la instancia a la lista de pacientes
                resultado.add(pacienteActual);
            }
        }
        //En caso de error se captura la excepción
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
                stmPacientes.close();
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
    public java.util.List<Cita> consultarHistorialClinico(Paciente paciente,  String tipo, String especialidad, java.sql.Timestamp fechaInicio, java.sql.Timestamp fechaFin){
    //Declaramos variables
        java.util.List<Cita> resultado = new java.util.ArrayList<Cita>();
        Cita citaActual;
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
            String consulta = "select fechaHoraInicio, fechaHoraFin, paciente, consulta, ambulatorio, tipo, especialidad " 
                    + "from cita where paciente = ? and tipo = ? and especialidad = ? and fechaHoraFin-fechaHoraInicio>=0 "
                    + "and fechaHoraFin <= ? and fechaHoraInicio >= ?;";

            //Preparamos la consulta
            stmHistorial = con.prepareStatement(consulta);
            //Sustituimos
            stmHistorial.setString(1, paciente.getCIP());
            stmHistorial.setString(2, tipo);
            stmHistorial.setString(3, especialidad); 
            stmHistorial.setTimestamp(4, fechaFin); 
            stmHistorial.setTimestamp(5, fechaInicio); 
 
            //Ejecutamos
            rsHistorial = stmHistorial.executeQuery();
            //Mientras haya coincidencias
            while (rsHistorial.next()) {
                //Se crea una instancia de cita con los datos recuperados de la base de datos
                citaActual = new Cita(rsHistorial.getTimestamp("fechaHoraInicio"), 
                        rsHistorial.getTimestamp("fechaHoraFin"),
                        rsHistorial.getString("paciente"), 
                        rsHistorial.getInt("consulta"), 
                        rsHistorial.getInt("ambulatorio"),
                        rsHistorial.getString("tipo"),
                        rsHistorial.getString("especialidad"));
               //Y se añade la instancia a la lista de pacientes
                resultado.add(citaActual);
            }
        }
        //En caso de error se captura la excepción
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
}

package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.Paciente;

public class DAOEnfermedades extends AbstractDAO {
    
    //Contructor
    public DAOEnfermedades(Connection conexion, aplicacion.FachadaAplicacion fa) {
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
                    + "values (?,?,?,?,?,?,?)");
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
    public void borrarPaciente(String CIP) {
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
            stmPaciente.setString(1, CIP);  //CIP del paciente
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

    //Permite consultar la información de los pacientes buscados por su id y/o nombre 
    //Incluye además infrormación sobre sus préstamos vencidos
    public java.util.List<Paciente> consultarPPacientes(String id, String nombre) {
        //Declaramos variables
        java.util.List<Paciente> resultado = new java.util.ArrayList<Paciente>();
        Paciente pacienteActual;
        Connection con;
        PreparedStatement stmPacientes = null;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPacientes;
        ResultSet rsPrestamos;

        //Establecemos conexión
        con = this.getConexion();

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            //Selecionamos el id, clave, nombre, direccion, email y tipo de paciente de la tabla de pacientes
            //que tengan el nombre dado
            String consulta = "select id_paciente, clave, nombre, direccion, email, tipo_paciente, edad "
                    + "from paciente as u "
                    + "where nombre like ?";
            if (id != null) {
                consulta = consulta + " and id_paciente like ?";
            }

            //En caso de aportar el id
            if (id != null) {
                //También se busca por id y, por tanto, se especifica en la consulta
                consulta = consulta + " and id_paciente like ?";
            }

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

                //Se intenta consultar la tabla de préstamos
                try {
                    //Construimos una consulta que cuente el número de préstamos vencidos
                    //Para elllo se comprueba que los ejemplares no estén devueltos y que la fecha 
                    //actual (current_date) supere la de préstamo + 30 (fecha de devolución) para el paciente dado
                    consulta = "select COUNT(distinct ejemplar) as vencidos from prestamo where "
                            + "paciente like ? and fecha_devolucion is null and current_date > fecha_prestamo + 30";
                    //Preparamos la consulta
                    stmPrestamos = con.prepareStatement(consulta);
                    //Sustituimos
                    stmPrestamos.setString(1, pacienteActual.getIdPaciente());  //Id del paciente
                    //Ejecutamos
                    rsPrestamos = stmPrestamos.executeQuery();
                    //Como solo devuelve un valor lo recuperamos
                    rsPrestamos.next();
                    //Y lo guardamos como el número de préstamos vencidos (que han superado la fecha límite 
                    //para su devolución)
                    pacienteActual.setNumPrestamosVencidos(rsPrestamos.getInt("vencidos"));

                    //En caso de error se captura la excepción
                } catch (SQLException e) {
                    //Se imprime el mensaje y se genera la ventana que muestra el mensaje
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Finalmente intentamos cerrar el cursor de PRESTAMOS. El de pacientes sigue abierto.
                    try {
                        stmPrestamos.close();
                    } catch (SQLException e) {
                        //Si no se puede se imprime el error por pantalla
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Se añade el paciente a la lista de pacientes
                resultado.add(pacienteActual);
            }

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar el cursor de pacientes 
            try {
                stmPacientes.close();
            } catch (SQLException e) {
                //Si no se puede se imprime el error por pantalla
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el resultado (lista de pacientes con información de préstamos vencidos)
        return resultado;
    }
    
}

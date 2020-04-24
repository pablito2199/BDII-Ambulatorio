package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import aplicacion.clases.Ambulatorio;

/* 
 * @author Ainhoa Vivel Couso
 */
public class DAOAmbulatorios extends AbstractDAO {

    //Contructor
    public DAOAmbulatorios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite insertar un nuevo ambulatorio en la base de datos
    public void insertarAmbulatorio(Ambulatorio ambulatorio) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmAmbulatorio = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta SQL para insertar en la tabla de ambulatorios un nuevo ambulatorio con el id de ambulatorio, nombre
            //clave, dirección, email y tipo de ambulatorio especificados
            stmAmbulatorio = con.prepareStatement("insert into ambulatorio (nombre, direccionPostal, anoConstruccion, provincia, telefono) "
                    + "values (?,?,?,?,?)");
            //Sustituimos
            stmAmbulatorio.setString(1, ambulatorio.getNombre());
            stmAmbulatorio.setString(2, ambulatorio.getDireccion());
            stmAmbulatorio.setString(3, ambulatorio.getAnoConstruccion());
            stmAmbulatorio.setString(4, ambulatorio.getProvicia());
            stmAmbulatorio.setString(5, ambulatorio.getTelefono());

            //Actualizamos
            stmAmbulatorio.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar los cursores
            try {
                stmAmbulatorio.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite eliminar un ambulatorio de la base de datos
    public void borrarAmbulatorio(Ambulatorio ambulatorio) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmAmbulatorio = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de ambulatorios aquel con la id especificada por argumentos
            stmAmbulatorio = con.prepareStatement("delete from ambulatorio where codigoAmbulatorio = ?");
            //Sustituimos
            stmAmbulatorio.setInt(1, ambulatorio.getCodigo());  //CIP del ambulatorio
            //Actualizamos
            stmAmbulatorio.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmAmbulatorio.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar los datos de un ambulatorio de la base de datos
    public void modificarAmbulatorio(Ambulatorio ambulatorio) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmAmbulatorio = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la sentencia para actualizar los datos del ambulatorio con la id especificada
            stmAmbulatorio = con.prepareStatement("update ambulatorio "
                    + "set  nombre = ? "
                    + "direccionPostal = ? "
                    + "provincia = ? "
                    + "anoConstruccion = ? "
                    + "telefono = ? "
                    + "where codigoAmbulatorio = ?");
            //Actualizamos
            stmAmbulatorio.setString(1, ambulatorio.getNombre());
            stmAmbulatorio.setString(2, ambulatorio.getDireccion());
            stmAmbulatorio.setString(3, ambulatorio.getProvicia());
            stmAmbulatorio.setString(4, ambulatorio.getAnoConstruccion());
            stmAmbulatorio.setString(5, ambulatorio.getTelefono());

            stmAmbulatorio.setInt(6, ambulatorio.getCodigo());
            //NOTA: El codigo del ambulatorio no se pueden modificar

            //Actualizamos
            stmAmbulatorio.executeUpdate();

            //En caso de error se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje y se genera la ventana que muestra el mensaje
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente intentamos cerrar cursores
            try {
                stmAmbulatorio.close();
            } catch (SQLException e) {
                //De no poder se notifica de ello
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite buscar ambulatorios por su codigo, provincia y/o nombre de ambulatorio
    public java.util.List<Ambulatorio> consultarAmbulatorios(String nombre, Integer codigo, String Provincia) {
        //Declaramos variables
        java.util.List<Ambulatorio> resultado = new java.util.ArrayList<Ambulatorio>();
        Ambulatorio ambulatorioActual;
        Connection con;
        PreparedStatement stmAmbulatorios = null;
        ResultSet rsAmbulatorios;
        PreparedStatement stmIngresos = null;
        ResultSet rsIngresos;
        String subconsulta;

        //Establecemos conexión
        con = this.getConexion();

        //Impedimos que se la confirmación sea automática
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }

        //Como el resto de consultas se pueden hacer en una única sentencia SQL pero
        //se requiere como mínimo 1 que lo haga en más proceso a dividir esta consulta
        //en 2 aunque no sería estrictamente necesario.
        //La consulta sin dividir sería
        /*
        
         String consulta = "select codigoAmbulatorio, nombre, anoConstruccion, direccionPostal, provincia, telefono, " 
                    //Calculamos la antiguedad. Como el dato es un varchar necesitamos convertirlo a año para poder calcular
                    //la diferencia de las fechas. Luego lo reconvertimos de nuevo a varchar.
                    + "CAST ( EXTRACT(YEAR FROM age(current_date, TO_DATE(anoConstruccion, 'YYYY'))) as varchar(4)) as antiguedad, "
                    //Calculamos los ingresos que ha tenido ese ambulatorio
                    + "(select SUM(cantidad) from subvencion full join donativo " 
                    + "using (codigoIngreso,ambulatorio,fecha,cantidad) " 
                    //Filtramos por aquellas donaciones realizadas el último año
                    + "where ambulatorio = ? and and EXTRACT(YEAR FROM age(current_date, fecha))<=1"
                    + "group by ambulatorio) as ingresos " 
                    + "from ambulatorio " 
                    + "where codigoAmbulatorio = ? " 
                    + "and nombre like ? "
                    + "and provincia like ? "
                    //Ordenamos alfabéticamente por nombre
                    + "order by nombre ASC"; 

            //Preparamos la consulta
            stmAmbulatorios = con.prepareStatement(consulta);
            //Sustituimos
            stmAmbulatorios.setInt(1, codigo);
            stmAmbulatorios.setInt(2, codigo);
            stmAmbulatorios.setString(3, "%" + nombre + "%");
            stmAmbulatorios.setString(4, "%" + Provincia + "%");
        
         */
        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select codigoAmbulatorio, nombre, anoConstruccion, direccionPostal, provincia, telefono, "
                    //Calculamos la antiguedad. Como el dato es un varchar necesitamos convertirlo a año para poder calcular
                    //la diferencia de las fechas. Luego lo reconvertimos de nuevo a varchar.
                    + "CAST ( EXTRACT(YEAR FROM age(current_date, TO_DATE(anoConstruccion, 'YYYY'))) as varchar(4)) as antiguedad "
                    + "from ambulatorio "
                    + "where codigoAmbulatorio = ? "
                    + "and nombre like ? "
                    + "and provincia like ? "
                    //Ordenamos alfabéticamente por nombre
                    + "order by nombre ASC";

            //Preparamos la consulta
            stmAmbulatorios = con.prepareStatement(consulta);
            //Sustituimos
            stmAmbulatorios.setInt(1, codigo);
            stmAmbulatorios.setString(2, "%" + nombre + "%");
            stmAmbulatorios.setString(3, "%" + Provincia + "%");

            //Ejecutamos
            rsAmbulatorios = stmAmbulatorios.executeQuery();

            //Mientras haya coincidencias
            while (rsAmbulatorios.next()) {
                //Se crea una instancia de ambulatorio con los datos recuperados de la base de datos
                ambulatorioActual = new Ambulatorio(
                        rsAmbulatorios.getInt("codigoAmbulatorio"),
                        rsAmbulatorios.getString("nombre"),
                        rsAmbulatorios.getString("direccionPostal"),
                        rsAmbulatorios.getString("anoConstruccion"),
                        rsAmbulatorios.getString("provincia"),
                        rsAmbulatorios.getString("telefono"),
                        rsAmbulatorios.getString("antiguedad"));

                //Para cada ambulatorio
                try {
                    //Calculamos los ingresos que ha tenido ese ambulatorio
                    subconsulta = "(select SUM(cantidad) from subvencion full join donativo "
                            + "using (codigoIngreso,ambulatorio,fecha,cantidad) "
                            //Filtramos por aquellas donaciones realizadas el último año
                            + "where ambulatorio = ? and and EXTRACT(YEAR FROM age(current_date, fecha))<=1"
                            + "group by ambulatorio) as ingresos ";

                    //Preparamos la consulta
                    stmIngresos = con.prepareStatement(consulta);
                    //Sustituimos
                    stmIngresos.setInt(1, codigo);
                    stmIngresos.setString(2, "%" + nombre + "%");
                    stmIngresos.setString(3, "%" + Provincia + "%");

                    //Ejecutamos
                    rsIngresos = stmIngresos.executeQuery();

                    //Si hay coincidencias
                    if (rsIngresos.next()) {
                        //Si tiene ingresos los recogemos
                        ambulatorioActual.setIngresos(rsAmbulatorios.getDouble("ingresos"));
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
                        stmAmbulatorios.close();
                    } catch (SQLException e) {
                        //Si no se puede se imprime el error
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Y se añade la instancia a la lista de ambulatorios
                resultado.add(ambulatorioActual);
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
                stmAmbulatorios.close();
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
        //Se devuelve el resultado (lista de ambulatorios)
        return resultado;
    }
}
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
            stmAmbulatorio.setString(4, ambulatorio.getProvincia());
            stmAmbulatorio.setString(5, ambulatorio.getTelefono());

            //Actualizamos
            stmAmbulatorio.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Ambulatorio añadido correctamente.");

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
    public void borrarAmbulatorio(Integer ambulatorio) {
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
            stmAmbulatorio.setInt(1, ambulatorio);  //CIP del ambulatorio
            //Actualizamos
            stmAmbulatorio.executeUpdate();
        this.getFachadaAplicacion().muestraMensaje("Ambulatorio eliminado correctamente.");

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
                    + "set nombre = ?, "
                    + "direccionPostal = ?, "
                    + "provincia = ?, "
                    + "anoConstruccion = ?, "
                    + "telefono = ? "
                    + "where codigoAmbulatorio = ?");
            //Actualizamos
            stmAmbulatorio.setString(1, ambulatorio.getNombre());
            stmAmbulatorio.setString(2, ambulatorio.getDireccion());
            stmAmbulatorio.setString(3, ambulatorio.getProvincia());
            stmAmbulatorio.setString(4, ambulatorio.getAnoConstruccion());
            stmAmbulatorio.setString(5, ambulatorio.getTelefono());
            stmAmbulatorio.setInt(6, ambulatorio.getCodigo());
            //NOTA: El codigo del ambulatorio no se pueden modificar

            //Actualizamos
            stmAmbulatorio.executeUpdate();
            this.getFachadaAplicacion().muestraMensaje("Ambulatorio modificado correctamente.");

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
    public java.util.List<Ambulatorio> consultarAmbulatorios(String nombre, Integer codigo, String provincia) {
        //Declaramos variables
        java.util.List<Ambulatorio> resultado = new java.util.ArrayList<>();
        Ambulatorio ambulatorioActual;
        Connection con;
        PreparedStatement stmAmbulatorios = null;
        ResultSet rsAmbulatorios;
        PreparedStatement stmIngresos = null;
        ResultSet rsIngresos;
        String subconsulta;

        //Establecemos conexión
        con = this.getConexion();

        try {
            //Impedimos que se la confirmación sea automática
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
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
         */
        //Variable para buscar por codigo
        String codAmb = codigo == null ? "" : "and codigoAmbulatorio = ? ";

        //Intentamos la consulta SQL
        try {
            //Construimos la consulta
            String consulta = "select codigoAmbulatorio, nombre, anoConstruccion, direccionPostal, provincia, telefono, "
                    //Calculamos la antiguedad. Como el dato es un varchar necesitamos convertirlo a año para poder calcular
                    //la diferencia de las fechas. Luego lo reconvertimos de nuevo a varchar.
                    + "CAST ( EXTRACT(YEAR FROM age(current_date, TO_DATE(anoConstruccion, 'YYYY'))) as varchar(4)) as antiguedad "
                    + "from ambulatorio "
                    + "where nombre like ? "
                    + "and provincia like ? "
                    + codAmb
                    //Ordenamos alfabéticamente por nombre
                    + "order by codigoAmbulatorio ASC";

            //Preparamos la consulta
            stmAmbulatorios = con.prepareStatement(consulta);
            //Sustituimos
            stmAmbulatorios.setString(1, "%" + nombre + "%");
            String provinciaAux = provincia == null ? "" : provincia;
            stmAmbulatorios.setString(2, "%" + provinciaAux + "%");
            if (codigo != null) {
                stmAmbulatorios.setInt(3, codigo);
            }

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
                    subconsulta = "select SUM(cantidad) as ingresos "
                            + "from subvencion full join donativo "
                            + "using(codigoIngreso,ambulatorio,fecha,cantidad) "
                            //Filtramos por aquellas donaciones realizadas el último año
                            + "where ambulatorio = ? "
                            + "and EXTRACT(YEAR FROM AGE(CURRENT_DATE, fecha)) <= 1 "
                            + "group by ambulatorio";

                    //Preparamos la consulta
                    stmIngresos = con.prepareStatement(subconsulta);
                    //Sustituimos
                    stmIngresos.setInt(1, ambulatorioActual.getCodigo());

                    //Ejecutamos
                    rsIngresos = stmIngresos.executeQuery();

                    //Si hay coincidencias
                    if (rsIngresos.next()) {
                        //Si tiene ingresos los recogemos
                        ambulatorioActual.setIngresos(rsIngresos.getDouble("ingresos"));
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
                        stmIngresos.close();
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
        //Pedimos que vuelva a hacer los commits automáticamente
        try {
            //Impedimos que se la confirmación sea automática
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }
        //Se devuelve el resultado (lista de ambulatorios)
        return resultado;
    }

    /* 
    * @author Pablo Tarrío Otero
     */
    //Permite recuperar los datos del ambulatorio con el nombre y provincia correspondientes
    public Ambulatorio consultarAmbulatorioActual(String nombre, String provincia) {
        //Declaramos variables
        Ambulatorio resultado = null;
        Ambulatorio ambulatorioActual;
        Connection con;
        PreparedStatement stmAmbulatorio = null;
        ResultSet rsAmbulatorio;

        //Establecemos conexión
        con = this.getConexion();

        //cuenta el número de prestamos cuya diferencia de días es mayor o igual a 30 con respecto al día de hoy
        String consulta = "select nombre, provincia "
                + "from ambulatorio "
                + "where nombre = ? "
                + "and provincia = ?";

        try {
            stmAmbulatorio = con.prepareStatement(consulta);
            stmAmbulatorio.setString(1, nombre);
            stmAmbulatorio.setString(2, provincia);
            rsAmbulatorio = stmAmbulatorio.executeQuery();
            rsAmbulatorio.next();
            resultado = new Ambulatorio(rsAmbulatorio.getString("nombre"), rsAmbulatorio.getString("provincia"));
        } catch (SQLException e) {
        } finally {
            try {
                stmAmbulatorio.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
}

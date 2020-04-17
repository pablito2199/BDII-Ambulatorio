package baseDatos;

public abstract class AbstractDAO {

    private aplicacion.FachadaAplicacion fa;             // Enlace a la fachada de aplicación
    private java.sql.Connection conexion;                // Conexión SQL

    //Permite obtener la conexión
    protected java.sql.Connection getConexion() {
        return this.conexion;
    }

    //Permite establecer la conexión
    protected void setConexion(java.sql.Connection conexion) {
        this.conexion = conexion;
    }

    //Establece la fachada de aplicación
    protected void setFachadaAplicacion(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
    }

    //Obtener la fachada de aplicación
    protected aplicacion.FachadaAplicacion getFachadaAplicacion() {
        return fa;
    }

}

package aplicacion;

/**
 *
 * @author basesdatos
 */
public class Usuario {

    private final String idUsuario;           // Id del usuario. Único para cada usuario
    private final String clave;                // Contraseña del usuario
    private final String nombre;             // Nombre del usuario
    private final String direccion;           // Dirección del usuario
    private final String email;                // Correo electrónico del usuario
    private final TipoUsuario tipo;          // Tipo de usuario
    private final String edad;                // Edad del usuario

    //ATR añadido para gestionar préstamos
    private Integer numPrestamosVencidos;   //Número de préstamos vencidos que tiene el usuario

    //Constructor
    public Usuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo, String edad) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.tipo = tipo;
        this.numPrestamosVencidos = 0;
        this.edad=edad;
    }

    //Getters (permiten obtener información sobre el usuario)
    public String getIdUsuario() {
        return this.idUsuario;
    }

    public String getClave() {
        return this.clave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public TipoUsuario getTipoUsuario() {
        return this.tipo;
    }

    public Integer getNumPrestamosVencidos() {
        return numPrestamosVencidos;
    }

    public String getEdad(){
        return this.edad;
    }
    
//Setters (permiten modificar información sobre el usuario)
    public void setNumPrestamosVencidos(Integer numPrestamosVencidos) {
        this.numPrestamosVencidos = numPrestamosVencidos;
    }

    
}

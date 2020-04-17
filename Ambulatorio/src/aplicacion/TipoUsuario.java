package aplicacion;

/**
 *
 * @author basesdatos
 */
public enum TipoUsuario {
    Administrador,  // Tiene permisos en el sistema para borrar, insertar o modificar usuarios, préstamos, categorías y libros.
    Normal;           // No tiene acceso al programa para gestionar usuarios, préstamos, categorías y libros, pero puede llevar prestados ejemplares// No tiene acceso al programa para gestionar usuarios, préstamos, categorías y libros, pero puede llevar prestados ejemplares

    //CTU transforma un String a TipoUsuario
    public static TipoUsuario CTU(String tipo) {
        if (tipo.equals("Administrador")) {
            return Administrador;
        } else {
            return Normal;
        }

    }

    //Transforma un TipoUsuario a String
    @Override
    public String toString() {
        String tipo;
        if (this == Administrador) {
            tipo = "Administrador";
        } else {
            tipo = "Normal";
        }
        return tipo;
    }
}

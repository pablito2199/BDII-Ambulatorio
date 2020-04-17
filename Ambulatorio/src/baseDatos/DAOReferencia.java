package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Categoria;
import aplicacion.Libro;
import java.sql.*;

public class DAOLibros extends AbstractDAO {

    //Constructor
    public DAOLibros(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    //Permite recuperar un array de libros
    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor) {
        //Declaramos variables
        java.util.List<Libro> resultado = new java.util.ArrayList<Libro>();
        Libro libroActual;
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;

        //Establecemos conexión
        con = this.getConexion();

        /*
        Construimos la consulta:
            Seleccionamos el id del libro, su título, ibsn, editorial, páginas y año de aquellos
        libros en la tabla de lirbos cuyo titulo e ISBN coincidan con los dados 
         */
        String consulta = "select id_libro, titulo, isbn, editorial, paginas, ano "
                + "from libro as l "
                + "where titulo like ?"
                + "  and isbn like ?";
        //En caso de que el id proporcionado no sea nulo
        if (id != null) {
            //Añadimos que también filtre por id
            consulta = consulta + " and id_libro = " + id.toString();
        }

        //Si el autor no es vacío
        if (!autor.isEmpty()) {
            /*
            Añadimos una subconsulta. Se seleccionan los libros que regresen algo de la subconsulta:
               Escoger todo del autor cuyo libro sea el id del libro de la consulta principal y el nombre del autor
            sea el proporcionado
             */
            consulta = consulta + "  and exists (select * "
                    + "              from autor "
                    + "              where libro=l.id_libro"
                    + "                and nombre like ?)";
        }

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta
            stmCatalogo = con.prepareStatement(consulta);
            //Sustituimos los datos de la consulta
            stmCatalogo.setString(1, "%" + titulo + "%");   // Titulo del libro
            stmCatalogo.setString(2, "%" + isbn + "%");     // ISBN del libro
            //En caso de haber autor
            if (!autor.isEmpty()) {
                //El autor del libro
                stmCatalogo.setString(3, "%" + autor + "%");
            }
            //Ejecutamos
            rsCatalogo = stmCatalogo.executeQuery();
            //Mientras haya coincidencias 
            while (rsCatalogo.next()) {
                //Creamos una nueva instancia de libro con los datos recuperados
                libroActual = new Libro(rsCatalogo.getInt("id_libro"), rsCatalogo.getString("titulo"),
                        rsCatalogo.getString("isbn"), rsCatalogo.getString("editorial"),
                        rsCatalogo.getInt("paginas"), rsCatalogo.getInt("ano"));

                //Intentamos la otra consulta para recuperar los datos del autor
                try {
                    //Recuperamos el nombre del autor de la tabla de autores donde el libro sea el que pedimos y ordenamos
                    stmAutores = con.prepareStatement("select nombre as autor "
                            + "from autor "
                            + "where libro = ? "
                            + "order by orden");
                    //Sustituimos con los datos propordionados
                    stmAutores.setInt(1, libroActual.getIdLibro()); //Id del libro
                    //Ejecutamos la consulta
                    rsAutores = stmAutores.executeQuery();
                    //Mientras haya coincidencias
                    while (rsAutores.next()) {
                        //Añadimos al autor a la lista de autores del libro
                        libroActual.addAutor(rsAutores.getString("autor"));
                    }
                    //En caso de fallar capturamos  la excepción
                } catch (SQLException e) {
                    //Imprimimos y generamos ventana
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Finalmente cerramos la conexión de AUTORES
                    //La de libros sigue abierta
                    try {
                        stmAutores.close();
                    } catch (SQLException e) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Añadimos el resultado a la lista de libros que tenemos
                resultado.add(libroActual);
            }
            //En caso de fallar capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el error y generamos la ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión
            try {
                stmCatalogo.close();
                //De no poder imprimimos el error
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Regresamos el conjunto de libros que cumple el criterio de búsqueda
        return resultado;
    }

    //Consultar la información de un libro
    public Libro consultarLibro(Integer idLibro) {
        //Declaramos variables
        Libro resultado = null;
        Connection con;
        PreparedStatement stmLibro = null;
        ResultSet rsLibro;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;
        PreparedStatement stmEjemplares = null;
        ResultSet rsEjemplares;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;

        //Establecemos conexión
        con = super.getConexion();

        //Preparamos la consulta SQL
        try {
            //Construimos la consulta.
            //Tomamos el id, titulo, ibsn, editorial, paginas y año de un libro cuya id coincida con el id dado 
            stmLibro = con.prepareStatement("select id_libro, titulo, isbn, editorial, paginas, ano "
                    + "from libro "
                    + "where id_libro = ?");
            //Sustituimos el ? por el id del libro que le pasamos por argumentos
            stmLibro.setInt(1, idLibro);
            //Ejecutamos
            rsLibro = stmLibro.executeQuery();
            //Si hay alguna coincidencia (que no podría haber más)
            if (rsLibro.next()) {
                //Creamos una isntancia de libro con los datos recuperados
                resultado = new Libro(rsLibro.getInt("id_libro"), rsLibro.getString("titulo"),
                        rsLibro.getString("isbn"), rsLibro.getString("editorial"),
                        rsLibro.getInt("paginas"), rsLibro.getInt("ano"));
                //Intentamos recuperar también sus autores
                try {
                    //Seleccionamos el nombre del autor de la tabla de autores donde el id del libro sea 
                    //el dado por argumentos
                    stmAutores = con.prepareStatement("select nombre as autor "
                            + "from autor "
                            + "where libro = ? "
                            + "order by orden");
                    //Sustituimos
                    stmAutores.setInt(1, resultado.getIdLibro()); //Id del libro
                    //Ejecutamos
                    rsAutores = stmAutores.executeQuery();
                    //Mientras haya coincidencias
                    while (rsAutores.next()) {
                        //Vamos insertando en la lista de autores
                        resultado.addAutor(rsAutores.getString("autor"));
                    }
                    //En caso de fallo capturamos la excepción
                } catch (SQLException e) {
                    //Imprimimos el error y generamos la ventana
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Cerramos la conexión con los AUTORES. La de libros sigue abierta
                    try {
                        stmAutores.close();
                    } catch (SQLException e) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Intentamos recuperar las categorías del libro
                try {
                    //Recuperamos la categoria (nombre) de las tabla de categorias que tiene un libro 
                    //donde el id del libro coincida con el dado
                    stmCategorias = con.prepareStatement("select categoria "
                            + "from cat_tiene_libro "
                            + "where libro = ?");
                    //Sustituimos
                    stmCategorias.setInt(1, resultado.getIdLibro()); //Id del libro
                    //Ejecutamos
                    rsCategorias = stmCategorias.executeQuery();
                    //Mientras haya coincidencias
                    while (rsCategorias.next()) {
                        //Añadimos el resultado tras instanciarlo a las categorías del libro 
                        resultado.addCategoria(new Categoria(rsCategorias.getString("categoria"), null));
                    }
                    //En caso de error lo capturamos
                } catch (SQLException e) {
                    //Imprimimos el error y generamos la ventana
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Cerramos la conexión de CATEGORIAS. La de libros sigue abierta.
                    try {
                        stmCategorias.close();
                    } catch (SQLException e) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Intentamos recuperar los ejemplares del libro
                try {
                    //Seleccionamos el libro, numero del ejemplar, año de compra y localizador del ejemplar 
                    // de la tabla de ejemplares donde el id del libro sea el proporcionado por argumentos
                    stmEjemplares = con.prepareStatement("select libro, num_ejemplar, ano_compra, localizador "
                            + "from ejemplar "
                            + "where libro = ?");
                    //Sustituimos
                    stmEjemplares.setInt(1, resultado.getIdLibro()); //Id del libro
                    //Ejecutamos
                    rsEjemplares = stmEjemplares.executeQuery();
                    //Mientras haya ejemplares intentamos recuperar los préstamos que pueda tener activos el ejemplar
                    while (rsEjemplares.next()) {
                        //Instanciamos
                        Ejemplar ej = new Ejemplar(null, rsEjemplares.getInt("num_ejemplar"),
                                rsEjemplares.getString("localizador"),
                                rsEjemplares.getString("ano_compra"));
                        try {
                            //Selecionamos todo del préstamo de la tabla de préstamos donde el dia sea el dado, el ejemplar
                            //el que estamos mirando y que carezca de fecha de devolución (sigue prestado)
                            stmPrestamos = con.prepareStatement("select * "
                                    + "from prestamo "
                                    + "where libro = ? and ejemplar = ? and fecha_devolucion is null");
                            //Sustituimos
                            stmPrestamos.setInt(1, idLibro); //Id del libro
                            stmPrestamos.setInt(2, rsEjemplares.getInt("num_ejemplar")); //Numero de ejemplar
                            //Ejecutamos
                            rsPrestamos = stmPrestamos.executeQuery();
                            //Si hay algún préstamo activo
                            if (rsPrestamos.next()) {
                                //Recuperamos el id del usuario que lo tiene y lo metemos en la información del ejemplar
                                ej.setUsuario(rsPrestamos.getString("usuario"));
                                //Recuperamos su fecha de préstamo
                                ej.setPrestamo(rsPrestamos.getDate("fecha_prestamo"));
                            }
                            //En caso de error lo capturamos
                        } catch (SQLException ex) {
                            //Imprimimos el error y creamos la ventana
                            System.out.println(ex.getMessage());
                            this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
                        } finally {
                            //Cerramos la conexión de PRESTAMOS. La de libros sigue abierta.
                            try {
                                stmPrestamos.close();
                            } catch (SQLException e) {
                                //De no poder notificamos al usuario
                                System.out.println("Imposible cerrar cursores");
                            }
                        }
                        //Añadimos el ejemplar a la lista de ejemplares
                        resultado.addEjemplar(ej);
                    }
                    //En caso de fallar capturamos la excepción
                } catch (SQLException e) {
                    //Imprimimos el error y creamos la ventana
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    //Finalmente cerramos la conexión de Ejemplares pero no la de libros.
                    try {
                        stmEjemplares.close();
                    } catch (SQLException e) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
            }
            //En caso de fallar capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el error y creamos la ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión de libros.
            try {
                stmLibro.close();
                //En caso de no poder se notifica del error
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el libro que hemos instanciado con los datos recuperados
        return resultado;
    }

    //Consultar los ejemplares de un libro a partir de su id
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        //Declaramos variables
        java.util.List<Ejemplar> resultado = new java.util.ArrayList<Ejemplar>();
        Connection con;
        PreparedStatement stmEjemplares = null;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        ResultSet rsEjemplares;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Definimos un string con la consulta
            //Tomamos el numero de ejemplar, año de compra y localizador del ejemplar de la tabla de ejemplares 
            //que tenga como id del libro asociado la proporcionada por argumentos
            stmEjemplares = con.prepareStatement("select num_ejemplar, ano_compra, localizador "
                    + "from ejemplar "
                    + "where libro = ?");
            //Sustituimos
            stmEjemplares.setInt(1, idLibro); //Id del libro
            //Ejecutamos
            rsEjemplares = stmEjemplares.executeQuery();
            //Mientras haya coincidencias
            while (rsEjemplares.next()) {
                //Intentamos recuperar la información de préstamos
                //Instanciamos el ejemplar
                Ejemplar e = new Ejemplar(null, rsEjemplares.getInt("num_ejemplar"),
                        rsEjemplares.getString("localizador"),
                        rsEjemplares.getString("ano_compra"));

                try {
                    //Hacemos otra consulta
                    //Seleccionamos todo de la tabla de préstamos cuyo id libro sea el dado, el ejemplar el que
                    //se está trabajando y que no haya sido devuelto (fecha devolución a null)
                    stmPrestamos = con.prepareStatement("select * "
                            + "from prestamo "
                            + "where libro = ? and ejemplar = ? and fecha_devolucion is null");
                    //Sustituimos
                    stmPrestamos.setInt(1, idLibro); //Id del libro
                    stmPrestamos.setInt(2, rsEjemplares.getInt("num_ejemplar")); //Numero de ejemplar
                    //Ejecutamos la consulta
                    rsPrestamos = stmPrestamos.executeQuery();
                    //Si hay algún resultado (que no podría haber más de uno.)
                    if (rsPrestamos.next()) {
                        //Recuperamos los datos del préstamo y los guardamos en la instancia de ejemplar creada
                        e.setUsuario(rsPrestamos.getString("usuario"));
                        e.setPrestamo(rsPrestamos.getDate("fecha_prestamo"));
                    }
                    //En caso de error capturamos la excepción
                } catch (SQLException ex) {
                    //Imprimimos el error y creamos la ventana
                    System.out.println(ex.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
                } finally {
                    //Cerramos la conexión de PRESTAMOS. La de ejemplares sigue abierta.
                    try {
                        stmPrestamos.close();
                    } catch (SQLException exc) {
                        //De no poder notificamos al usuario
                        System.out.println("Imposible cerrar cursores");
                    }
                }
                //Añadimos el ejemplar a la lista de ejemplares del libro
                resultado.add(e);
            }
            //En caso de error capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el error y creamos la ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión de EJEMPLARES
            try {
                stmEjemplares.close();
                //En caso de error capturamos la excepción
            } catch (SQLException e) {
                //En caso de error imprimimos el fallo
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el resultado (una lista de ejemplares de un libro)
        return resultado;
    }

    //Obtener el resto de categorías que no están en el libro
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro) {
        //Declarar variables
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        String categoriaActual;
        Connection con;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;

        //Establecer conexión
        con = super.getConexion();

        //Intentar realizar la consulta SQL
        try {
            //Preparamos la consulta de las categorías que no estén asociadas al libro dado
            //Para ello tomamos el nombre de la categoría c que no forme parte del conjunto
            //de categorías compuesto por aquellas que corresponden al libro proporcionado por
            //argumentos y tengan el mismo nombre
            stmCategorias = con.prepareStatement("select nombre "
                    + "from categoria c "
                    + "where not exists (select *  "
                    + "		  from cat_tiene_libro cl "
                    + "		  where cl.libro=? and cl.categoria=c.nombre)");
            //Sustituimos
            stmCategorias.setInt(1, idLibro); //Id del libro
            //Ejecutamos la consulta
            rsCategorias = stmCategorias.executeQuery();
            //Mientras haya coincidencias
            while (rsCategorias.next()) {
                //Obtenemos el nombre de la categoría
                categoriaActual = rsCategorias.getString("nombre");
                //Y lo insertamos en el array de categorías
                resultado.add(categoriaActual);
            }
            //En caso de que haya un fallo se captura la excepción
        } catch (SQLException e) {
            //Se imprime el error y se genera la ventana que muestra la excepción
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión
            try {
                stmCategorias.close();
                //Si falla
            } catch (SQLException e) {
                //Imprimimos el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el resultado (conjunto de cateogorías que NO se asocian al libro dado)
        return resultado;
    }

    //Permite insertar un nuevo libro en la base de datos
    public Integer insertarLibro(Libro libro) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmLibro = null;
        PreparedStatement stmAutores = null;
        PreparedStatement stmIdLibro = null;
        ResultSet rsIdLibro;
        Integer numAutor;
        Integer idLibro = null;

        //Establecemos la conexión
        con = super.getConexion();

        //Intentamos la consulta SQL
        try {
            //Preparamos la consulta
            //Insertamos en la tabla libro una nueva instancia con titulo, ISBN, editorial, paginas y año dados
            stmLibro = con.prepareStatement("insert into libro(titulo, isbn, editorial, paginas, ano) "
                    + "values (?,?,?,?,?)");
            //Sustituimos
            stmLibro.setString(1, libro.getTitulo()); //Titulo del libro
            stmLibro.setString(2, libro.getIsbn()); //ISBN
            stmLibro.setString(3, libro.getEditorial()); //Editorial
            stmLibro.setInt(4, libro.getPaginas()); //Número de páginas
            stmLibro.setInt(5, libro.getAno()); //Año de publicación
            //Actualizamos
            stmLibro.executeUpdate();
            try {
                //Intentamos recuperar valores de la secuencia dada
                stmIdLibro = con.prepareStatement("select currval('seq_libro_id_libro') as idLibro");
                //Ejecutamos
                rsIdLibro = stmIdLibro.executeQuery();
                rsIdLibro.next();
                //Establecemos el id del libro como el siguiente en la secuencia
                idLibro = rsIdLibro.getInt("idLibro");

                //Este paso se hace para que los libros tenga un id secuencial. Dicho de otro modo,
                //si el último libro registrado (con mayor id) tiene id 5 la función regresará como 
                //valor 6 (el id del nuevo libro a insertar)
            } catch (SQLException e) {
                //En caso de fallo captamos la excepción
                System.out.println(e.getMessage());
            } finally {
                //Cerramos la conexión de IdLibro
                try {
                    stmIdLibro.close();
                } catch (SQLException e) {
                    //De no poder notificamos al usuario
                    System.out.println("Imposible cerrar cursores");
                }
            }
            //Intentamos ahora establecer los autores
            try {
                //Preparamos la sentencia SQL
                //Insertamos en la tabla autores el id del libro, el nombre del autor y la posición que 
                //le corresponde en la lista de autores del libro (orden)
                stmAutores = con.prepareStatement("insert into autor(libro, nombre, orden) "
                        + "values (?,?,?)");
                //El primera autor tiene número 1
                numAutor = 1;
                //Para el resto de autores se les da ordenes secuenciales creciente.
                for (String s : libro.getAutores()) {
                    stmAutores.setInt(1, idLibro);  //Estableces el id del libro
                    stmAutores.setString(2, s);     //El nombre del autor (s)
                    stmAutores.setInt(3, numAutor); //El número de autor que le corresponde
                    stmAutores.executeUpdate();     //Actualizas la tabla
                    numAutor = numAutor + 1;    //Aumentas el número de autor (orden) por si acaso hay más
                }
                //En caso de fallo se captura la excepción
            } catch (SQLException e) {
                //Se imprime el mensaje de error y se genera la ventana
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                //Cerramos la conexión de AUTORES
                try {
                    stmAutores.close();
                } catch (SQLException e) {
                    //De no poder notificamos al usuario
                    System.out.println("Imposible cerrar cursores");
                }
            }
            //En caso de fallo se captura la excepción
        } catch (SQLException e) {
            //Se imprime el mensaje de error y se genera la ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                //Cerramos la conexión de libro
                stmLibro.close();
                //Si no se puede
            } catch (SQLException e) {
                //Se imprime el error
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Devolvemos el id del nuevo libro creado 
        return idLibro;
    }

    //Permite borrar un libro de la base de datos
    public void borrarLibro(Integer idLibro) {
        //Declaramos las variables
        Connection con;
        PreparedStatement stmLibro = null;

        //Establecemos la conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Intentamos borrar de la tabla libro aquella instancia que tenga la id especificada por argumentos
            stmLibro = con.prepareStatement("delete from libro where id_libro = ?");
            //Sustituimos
            stmLibro.setInt(1, idLibro); //Id del libro
            //Actualizamos la tabla
            stmLibro.executeUpdate();
            //En caso de fallo capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el mensaje y generamos la ventana que muestra la excepción al usuario (administrador)
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                //Cerramos la conexión de libro
                stmLibro.close();
            } catch (SQLException e) {
                //De no poder se imprime por pantalla el error
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar un libro de la base de datos
    public void modificarLibro(Libro libro) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmLibro = null;
        PreparedStatement stmAutores = null;
        PreparedStatement stmBorrado = null;
        Integer numAutor;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia
            // Actualiza/modifica el libro que tenga la id especificada modificando el titulo, ISBN,
            //editorial, paginas y año
            stmLibro = con.prepareStatement("update libro "
                    + "set titulo=?, "
                    + "    isbn=?, "
                    + "    editorial=?, "
                    + "    paginas=?, "
                    + "    ano=? "
                    + "where id_libro=?");
            //Sustituimos
            stmLibro.setString(1, libro.getTitulo()); //Titulo
            stmLibro.setString(2, libro.getIsbn());  //ISBN
            stmLibro.setString(3, libro.getEditorial()); //Editorial
            stmLibro.setInt(4, libro.getPaginas()); //Numero de paginas
            stmLibro.setInt(5, libro.getAno()); //Año de publicación
            stmLibro.setInt(6, libro.getIdLibro()); //Id del libro
            //NOTA: La id del libro no se modificará
            //Actualizamos
            stmLibro.executeUpdate();

            //Intentamos modificar los autores
            try {
                //Preparamos la sentencia
                //Primero borramos los autores del libro (aquellos que tengan asociados la id dada)
                stmBorrado = con.prepareStatement("delete from autor where libro=?");
                //Sustituimos
                stmBorrado.setInt(1, libro.getIdLibro()); //Id del libro
                //Actualizamos
                stmBorrado.executeUpdate();
                //En caso de fallo capturamos la excepción
            } catch (SQLException e) {
                //Imprimimos el mensaje y generamos la ventana
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                //Finalmente cerramos la conexión de BORRADO con autores
                try {
                    stmBorrado.close();
                } catch (SQLException e) {
                    //De no poder notificamos al usuario
                    System.out.println("Imposible cerrar cursores");
                }
            }

            //Una vez borrado procedemos a insertar
            try {
                //Preparamos la sentencia SQL para insertar en autor aquellos con libro, nombre y orden dados
                stmAutores = con.prepareStatement("insert into autor (libro, nombre, orden) "
                        + "values (?,?,?)");
                //El número del primer autor es 1
                numAutor = 1;
                //Sustituimos para todos los autores
                for (String s : libro.getAutores()) {
                    stmAutores.setInt(1, libro.getIdLibro()); //Id del libro
                    stmAutores.setString(2, s);  //Nombre del autor
                    stmAutores.setInt(3, numAutor);  //Orden en la lista de autores
                    stmAutores.executeUpdate(); //Actualizamos 
                    numAutor = numAutor + 1; //Aumentamos el numero (orden) por si hay otro autor
                }
                //En caso de error capturamos la excepción
            } catch (SQLException e) {
                //Imprimimos el mensaje y generamos la ventana
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                //Finalmente cerramos la conexión de AUTORES
                try {
                    stmAutores.close();
                } catch (SQLException e) {
                    //De no poder notificamos al usuario
                    System.out.println("Imposible cerrar cursores");
                }
            }
            //En caso de error capturamos la excepción
        } catch (SQLException e) {
            //Imprimimos el mensaje y generamos la ventana
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                //Finalmente cerramos la conexión de libro
                stmLibro.close();
            } catch (SQLException e) {
                //En caso de no poder se notifica de esto al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar las categorías de un libro de la base de datos
    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmBorrado = null;
        PreparedStatement stmInsercion = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la consulta
        try {
            //Preparamos la sentencia de borrado que quita de la tabla de categorias las 
            //instancias con id de libro dado
            stmBorrado = con.prepareStatement("delete from cat_tiene_libro where libro = ?");
            //Sustituimos
            stmBorrado.setInt(1, idLibro); //Id del libro
            //Actualizamos
            stmBorrado.executeUpdate();
        } catch (SQLException e) {
            //Si no se pudo capturamos la excepción, imprimimos el mensaje de error y generamos la ventana 
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión de BORRADO
            try {
                stmBorrado.close();
            } catch (SQLException e) {
                //De no poder notificamos al usuario
                System.out.println("Imposible cerrar cursores");
            }
        }
        //Intentamos la inserción de las categorías actualizadas
        try {
            //Preparamos la sentencia. Insertamos en la tabla de categorías el libro al que le corresponde 
            //la categoría y el nombre de la misma
            stmInsercion = con.prepareStatement("insert into cat_tiene_libro(libro, categoria) values (?,?)");
            //Para cada categoría 
            for (String c : categorias) {
                //Sustituimos
                stmInsercion.setInt(1, idLibro); //Id del libro
                stmInsercion.setString(2, c);  //Nombre de la categoría
                //Actualizamos
                stmInsercion.executeUpdate();
            }
            //En caso de fallo capturamos la excepción, imprimimos el mensaje de error y generamos la ventana 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos la conexión de INSERCION
            try {
                //stmBorrado.close();    //Linea innecesaria que se encontraba en el proyecto original
                //La dejo comentada porque es redundante y no hace nada. La conexión se cerró antes.
                stmInsercion.close();
                //En caso de fallo capturamos la excepción e imprimimos el mensaje de error
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite insertar ejemplares de un libro en la base de datos
    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmEjemplar = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia que permite insertar en la tabla de ejemplares un nuevo ejemplar
            //de libro 'libro' con año de compra y localizador dados.
            stmEjemplar = con.prepareStatement("insert into ejemplar(libro,ano_compra,localizador) "
                    + "values (?,?,?)");
            //Sustituimos
            stmEjemplar.setInt(1, idLibro);   //Id del libro asociado
            stmEjemplar.setString(2, ejemplar.getAnoCompra());   //Año de compra
            stmEjemplar.setString(3, ejemplar.getLocalizador());   //Localizador
            //Actualizamos la tabla
            stmEjemplar.executeUpdate();
            //En caso de fallo capturamos la excepción, imprimimos el mensaje de error y generamos la ventana 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos los cursores
            try {
                stmEjemplar.close();
                //En caso de no poder se captura la excepción y se notifica de ello al usuario (administrador)
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite borrar ejemplares de un libro de la base de datos
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar) {
        //Declaramos variables
        Connection con;
        PreparedStatement stmEjemplar = null;

        //Establecemos conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia para borrar de la tabla de ejemplares aquellos que sean del libro 'libro'
            //y que tengan el número de ejemplar dado
            stmEjemplar = con.prepareStatement("delete from ejemplar where libro=? and num_ejemplar=?");
            //Para cada ejemplar
            for (Integer i : numsEjemplar) {
                //Sustituimos
                stmEjemplar.setInt(1, idLibro);  //Id del libro
                stmEjemplar.setInt(2, i);   //Numero del ejemplar
                //Actualizamos
                stmEjemplar.executeUpdate();
            }
            //En caso de fallo capturamos la excepción, imprimimos el mensaje de error y generamos la ventana 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos los cursores
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                //En caso de no poder se captura la excepción y se notifica de ello al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //Permite modificar los ejemplares de un libro de la base de datos
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        //Declaramos las variables
        Connection con;
        PreparedStatement stmEjemplar = null;

        //Establecemos la conexión
        con = super.getConexion();

        //Intentamos la sentencia SQL
        try {
            //Preparamos la sentencia para actualizar el ejemplar del libro 'libro' y con el 
            //numero ejemplar dado para editar el año de compra y el localizador
            stmEjemplar = con.prepareStatement("update ejemplar "
                    + "set ano_compra=?, "
                    + "   localizador=? "
                    + "where libro=? and num_ejemplar=?");
            //Sustituimos
            stmEjemplar.setString(1, ejemplar.getAnoCompra());  //Año de compra
            stmEjemplar.setString(2, ejemplar.getLocalizador());  //Localizador
            stmEjemplar.setInt(3, idLibro); //Id del libor
            stmEjemplar.setInt(4, ejemplar.getNumEjemplar()); //Número del ejemplar
            //Actualizar
            stmEjemplar.executeUpdate();
            //En caso de fallo capturamos la excepción, imprimimos el mensaje de error y generamos la ventana 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            //Finalmente cerramos los cursores
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                //En caso de no poder se captura la excepción y se notifica de ello al usuario (administrador)
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}

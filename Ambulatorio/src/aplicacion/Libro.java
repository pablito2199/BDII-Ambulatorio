package aplicacion;

/**
 *
 * @author basesdatos
 */
public class Libro {

    private final Integer idLibro;                                 // Id del libro. Único para cada uno
    private final String titulo;                                    // Titulos del libro
    private final String isbn;                                      // ISBN del libro
    private final String editorial;                                // Editorial del libro
    private final Integer paginas;                               // Número de páginas del libro
    private final Integer ano;                                    // Año en el que se publicó el libro
    private java.util.List<String> autores;                   // Listado de autores del libro
    private final java.util.List<Categoria> categorias;    // Listado de las categorías del libro
    private final java.util.List<Ejemplar> ejemplares;      // Listado de ejemplares del libro que existen en la BD 

    //Constructor
    public Libro(Integer idLibro, String titulo, String isbn, String editorial, Integer paginas, Integer ano) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.paginas = paginas;
        this.ano = ano;
        autores = new java.util.ArrayList<String>();
        categorias = new java.util.ArrayList<Categoria>();
        ejemplares = new java.util.ArrayList<Ejemplar>();
    }

    //Getters (permiten obtener información sobre el libro)
    public Integer getIdLibro() {
        return this.idLibro;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public Integer getPaginas() {
        return this.paginas;
    }

    public Integer getAno() {
        return this.ano;
    }

    public java.util.List<String> getAutores() {
        return this.autores;
    }

    public java.util.List<Categoria> getCategorias() {
        return this.categorias;
    }

    public java.util.List<Ejemplar> getEjemplares() {
        return this.ejemplares;
    }

    public String getAutoresAsString() {
        String resultado = "";
        Boolean inicial = true;

        for (String a : this.autores) {
            if (inicial) {
                resultado = a;
                inicial = false;
            } else {
                resultado = resultado + ", " + a;
            }
        }
        return resultado;
    }

    //Setters (permite modificar la información del libro)
    public void setAutores(java.util.List<String> autores) {
        this.autores = autores;
    }

    //Adds (permiten añadir elementos al array)
    public void addAutor(String autor) {
        this.autores.add(autor);
    }

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public void addEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }

}

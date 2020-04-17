/*
 * VLibro.java
 *
 * Created on 16-feb-2011, 18:17:07
 */
package gui;

import aplicacion.Libro;
import aplicacion.Ejemplar;

/**
 *
 * @author basesdatos
 */
public class VLibro extends javax.swing.JDialog {

    private final Integer idLibro;                                        //ID del libro sobre el que se está trabajando
    private final java.util.List<Integer> ejemplaresBorrados;   //Lista de ejemplares del libro que se han borrado
    private final VPrincipal padre;                                      //Enlace a la ventana padre 
    private final aplicacion.FachadaAplicacion fa;                 //Enlace a la fachada de aplicación

    /**
     * Creates new form VLibro
     *
     * @param parent
     * @param modal
     * @param fa
     * @param restoCategorias
     */
    //Constructor para un nuevo libro
    public VLibro(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, java.util.List<String> restoCategorias) {
        //Instanciamos
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        //Desactivamos botones
        btnActualizarCategoriasLibro.setEnabled(false);
        btnActualizarEjemplaresLibro.setEnabled(false);
        btnBorrarLibro.setEnabled(false);
        //Inicializamos
        this.idLibro = null;
        this.ejemplaresBorrados = new java.util.ArrayList<Integer>();

        //Instanciamos la tabla lista con el resto de categorías
        ModeloListaStrings mListaRC = new ModeloListaStrings();
        lstRestoCategorias.setModel(mListaRC);
        mListaRC.setElementos(restoCategorias);
        //Si tiene algún elemento  lo seleccionamos y activamos la flecha derecha
        if (mListaRC.getSize() > 0) {
            lstRestoCategorias.setSelectedIndex(0);
            btnDerecha.setEnabled(true);
            //De no tenerlo se desactiva la flecha
        } else {
            btnDerecha.setEnabled(false);
        }
        //Desactivamos botones
        btnIzquierda.setEnabled(false); //Flecha que apunta hacia la izquierda
        btnBorrarEjemplar.setEnabled(false);
    }

    //Constructor para un libro existente
    public VLibro(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Libro libro, java.util.List<String> categorias, java.util.List<String> restoCategorias) {
        //Instanciamos
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        idLibro = libro.getIdLibro();
        textoAno.setText(libro.getAno().toString());
        textoEditorial.setText(libro.getEditorial());
        textoIsbn.setText(libro.getIsbn());
        textoPaginas.setText((libro.getPaginas()).toString());
        textoTitulo.setText(libro.getTitulo());
        textoId.setText(idLibro.toString());

        //Instanciamos la lista de autores
        ModeloListaStrings mListaAutores = new ModeloListaStrings();
        lstAutores.setModel(mListaAutores);
        mListaAutores.setElementos(libro.getAutores());
        if (mListaAutores.getSize() > 0) {
            lstAutores.setSelectedIndex(0);
            btnBorrarAutor.setEnabled(true);
        } else {
            btnBorrarAutor.setEnabled(false);
        }

        //Instanciamos la lista de resto de categorías
        ModeloListaStrings mListaRC = new ModeloListaStrings();
        lstRestoCategorias.setModel(mListaRC);
        mListaRC.setElementos(restoCategorias);
        if (mListaRC.getSize() > 0) {
            lstRestoCategorias.setSelectedIndex(0);
            btnDerecha.setEnabled(true);
        } else {
            btnDerecha.setEnabled(false);
        }

        //Instanciamos la lista de categorías
        ModeloListaStrings mListaC = new ModeloListaStrings();
        lstCategoriasLibro.setModel(mListaC);
        mListaC.setElementos(categorias);
        if (mListaC.getSize() > 0) {
            lstCategoriasLibro.setSelectedIndex(0);
            btnIzquierda.setEnabled(true);
        } else {
            btnIzquierda.setEnabled(false);
        }

        //Instanciamos la tabla de ejemplares
        ModeloTablaEjemplares mTEjemplares = new ModeloTablaEjemplares(fa);
        tablaEjemplares.setModel(mTEjemplares);
        //Obtenemos los ejemplares del libro
        mTEjemplares.setFilas(libro.getEjemplares());
        //En caso de que haya ejemplares
        if (mTEjemplares.getRowCount() > 0) {
            //Seleccionamos el primero
            tablaEjemplares.setRowSelectionInterval(0, 0);
            //Activamos el borrado
            btnBorrarEjemplar.setEnabled(true);
        } else {
            //Desactivamos el borrado
            btnBorrarEjemplar.setEnabled(false);
        }

        //Inicializamos ejemplares borrados
        this.ejemplaresBorrados = new java.util.ArrayList<Integer>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLibro = new javax.swing.JTabbedPane();
        panelGeneralAutores = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textoTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textoIsbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textoEditorial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textoPaginas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoAno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAutores = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        textoNuevoAutor = new javax.swing.JTextField();
        btnNuevoAutor = new javax.swing.JButton();
        btnBorrarAutor = new javax.swing.JButton();
        btnActualizarLibro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoId = new javax.swing.JTextField();
        panelCategorias = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRestoCategorias = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstCategoriasLibro = new javax.swing.JList();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        btnActualizarCategoriasLibro = new javax.swing.JButton();
        panelEjemplares = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEjemplares = new javax.swing.JTable();
        btnBorrarEjemplar = new javax.swing.JButton();
        btnNuevoEjemplar = new javax.swing.JButton();
        btnActualizarEjemplaresLibro = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        btnBorrarLibro = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de libros");
        setResizable(false);

        panelLibro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Título:");

        jLabel3.setText("Isbn:");

        jLabel4.setText("Editorial:");

        jLabel5.setText("Páginas:");

        jLabel6.setText("Año:");

        lstAutores.setModel(new ModeloListaStrings());
        lstAutores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstAutores);

        jLabel7.setText("Autores:");

        btnNuevoAutor.setText("Añadir");
        btnNuevoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAutorActionPerformed(evt);
            }
        });

        btnBorrarAutor.setText("Borrar");
        btnBorrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAutorActionPerformed(evt);
            }
        });

        btnActualizarLibro.setText("Actualizar");
        btnActualizarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarLibroActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        textoId.setEditable(false);
        textoId.setEnabled(false);

        javax.swing.GroupLayout panelGeneralAutoresLayout = new javax.swing.GroupLayout(panelGeneralAutores);
        panelGeneralAutores.setLayout(panelGeneralAutoresLayout);
        panelGeneralAutoresLayout.setHorizontalGroup(
            panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                    .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                        .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralAutoresLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralAutoresLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoAno)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoId, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 194, Short.MAX_VALUE))))
                    .addComponent(jLabel7)
                    .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBorrarAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralAutoresLayout.createSequentialGroup()
                                .addComponent(btnNuevoAutor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoNuevoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                            .addComponent(btnActualizarLibro))))
                .addContainerGap())
        );
        panelGeneralAutoresLayout.setVerticalGroup(
            panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textoEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(textoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralAutoresLayout.createSequentialGroup()
                        .addGroup(panelGeneralAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoAutor)
                            .addComponent(textoNuevoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarLibro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelLibro.addTab("Libro", panelGeneralAutores);

        jLabel8.setText("Categorías disponibles");

        jLabel9.setText("Categorías del libro");

        lstRestoCategorias.setModel(new ModeloListaStrings());
        jScrollPane2.setViewportView(lstRestoCategorias);

        lstCategoriasLibro.setModel(new ModeloListaStrings());
        jScrollPane3.setViewportView(lstCategoriasLibro);

        btnDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Asociar.png"))); // NOI18N
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        btnIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Desasociar.png"))); // NOI18N
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });

        btnActualizarCategoriasLibro.setText("Actualizar");
        btnActualizarCategoriasLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCategoriasLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCategoriasLayout = new javax.swing.GroupLayout(panelCategorias);
        panelCategorias.setLayout(panelCategoriasLayout);
        panelCategoriasLayout.setHorizontalGroup(
            panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriasLayout.createSequentialGroup()
                .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCategoriasLayout.createSequentialGroup()
                        .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCategoriasLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel8))
                            .addGroup(panelCategoriasLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCategoriasLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel9))
                            .addGroup(panelCategoriasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCategoriasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarCategoriasLibro)))
                .addContainerGap())
        );
        panelCategoriasLayout.setVerticalGroup(
            panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCategoriasLayout.createSequentialGroup()
                .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCategoriasLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCategoriasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnActualizarCategoriasLibro)
                .addContainerGap())
        );

        panelLibro.addTab("Categorías", panelCategorias);

        tablaEjemplares.setModel(new ModeloTablaEjemplares(fa));
        tablaEjemplares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEjemplaresMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaEjemplares);

        btnBorrarEjemplar.setText("Borrar");
        btnBorrarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarEjemplarActionPerformed(evt);
            }
        });

        btnNuevoEjemplar.setText("Nuevo");
        btnNuevoEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEjemplarActionPerformed(evt);
            }
        });

        btnActualizarEjemplaresLibro.setText("Actualizar");
        btnActualizarEjemplaresLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEjemplaresLibroActionPerformed(evt);
            }
        });

        btnPrestar.setText("Prestar");
        btnPrestar.setEnabled(false);
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        btnDevolver.setText("Devolver");
        btnDevolver.setEnabled(false);
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEjemplaresLayout = new javax.swing.GroupLayout(panelEjemplares);
        panelEjemplares.setLayout(panelEjemplaresLayout);
        panelEjemplaresLayout.setHorizontalGroup(
            panelEjemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplaresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnNuevoEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrestar)
                .addGap(18, 18, 18)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarEjemplaresLibro)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplaresLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelEjemplaresLayout.setVerticalGroup(
            panelEjemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplaresLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEjemplaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoEjemplar)
                    .addComponent(btnBorrarEjemplar)
                    .addComponent(btnActualizarEjemplaresLibro)
                    .addComponent(btnPrestar)
                    .addComponent(btnDevolver))
                .addGap(24, 24, 24))
        );

        panelLibro.addTab("Ejemplares", panelEjemplares);

        btnBorrarLibro.setText("Borrar Libro");
        btnBorrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarLibroActionPerformed(evt);
            }
        });

        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel10.setText("GESTIONAR LIBROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(panelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarLibro)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLibro.getAccessibleContext().setAccessibleName("Libro");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Permite salir de la ventana de libro
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        //Buscamos libros
        padre.buscarLibros();
        //Destruimos esta ventana
        this.dispose();

        //NOTA: Si no se presionó el botón actualizar no se guardan los cambios hechos
    }//GEN-LAST:event_btnSalirActionPerformed

    //Permite insertar un nuevo autor
    private void btnNuevoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAutorActionPerformed

        //Declaramos e inicializamos la lista de autores
        ModeloListaStrings ma;
        ma = (ModeloListaStrings) lstAutores.getModel();

        //Si se ha introducido un nombre de autor en el campo de texto NuevoAutor
        if ((textoNuevoAutor.getText() != null)) {
            //Se introduce un nuevo elemento en la lista
            ma.nuevoElemento(textoNuevoAutor.getText());
            lstAutores.setSelectedIndex(ma.getSize() - 1);
            //Se activa el botón de borrado de autor
            btnBorrarAutor.setEnabled(true);
        }
    }//GEN-LAST:event_btnNuevoAutorActionPerformed

    //Permite borrar uno de los autores
    private void btnBorrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAutorActionPerformed
        //Declaramos e inicializamos la lista de autores
        ModeloListaStrings ma;
        ma = (ModeloListaStrings) lstAutores.getModel();

        //Borramos el elemento seleccionado de la lista
        ma.borrarElemento(lstAutores.getSelectedIndex());
        //Si tras borrar no hay autores 
        if (ma.getSize() == 0)
            //Deshabilitamos el botón
            btnBorrarAutor.setEnabled(false);
        else
            //En otro caso seleccionamos el primer autor de la lista
            lstAutores.setSelectedIndex(0);
    }//GEN-LAST:event_btnBorrarAutorActionPerformed

    //Permite asignar una categoría al libro
    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        //Declaramos la lista de categorías y resto de categorías
        ModeloListaStrings mRC;
        ModeloListaStrings mC;
        //Inicializamos la lista de categorías y resto de categorías
        mRC = (ModeloListaStrings) lstRestoCategorias.getModel();
        mC = (ModeloListaStrings) lstCategoriasLibro.getModel();
        //Añadimos el elemento seleccionado a la lista de categorias y lo quitamos de la lista de resto
        mC.nuevoElemento(mRC.getElementAt(lstRestoCategorias.getSelectedIndex()));
        mRC.borrarElemento(lstRestoCategorias.getSelectedIndex());
        //Si el resto de categoría no tiene elementos desactivamos el botón derecha
        if (mRC.getSize() == 0) {
            btnDerecha.setEnabled(false);
        } else {
            //En otro caso seleccionamos automáticamente el primer elemento
            lstRestoCategorias.setSelectedIndex(0);
        }
        lstCategoriasLibro.setSelectedIndex(mC.getSize() - 1);
        //El botón flecha izquierda se habilita
        btnIzquierda.setEnabled(true);
    }//GEN-LAST:event_btnDerechaActionPerformed

    //Permite quitar la categoría del libor
    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        //Declaramos la lista de categorías y resto de categorías
        ModeloListaStrings mRC;
        ModeloListaStrings mC;
        //Inicializamos la lista de categorías y resto de categorías
        mRC = (ModeloListaStrings) lstRestoCategorias.getModel();
        mC = (ModeloListaStrings) lstCategoriasLibro.getModel();
        //Añadimos el elemento seleccionado a la lista de restos de categorias y lo quitamos de categorías
        mRC.nuevoElemento(mC.getElementAt(lstCategoriasLibro.getSelectedIndex()));
        mC.borrarElemento(lstCategoriasLibro.getSelectedIndex());
        //Si categorías no tiene elementos desactivamos el botón izquierda
        if (mC.getSize() == 0) {
            btnIzquierda.setEnabled(false);
        } else {
            //En otro caso seleccionamos automáticamente el primer elemento
            lstCategoriasLibro.setSelectedIndex(0);
        }
        lstRestoCategorias.setSelectedIndex(mRC.getSize() - 1);
        //El botón flecha derecha se habilita
        btnDerecha.setEnabled(true);
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    //Permite insertar un nuevo ejemplar
    private void btnNuevoEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEjemplarActionPerformed
        //Declaramos la tabla de ejemplares y un ejemplar
        ModeloTablaEjemplares me;
        Ejemplar e;
        //Inicializamos la tabla
        me = (ModeloTablaEjemplares) tablaEjemplares.getModel();
        //Creamos un nuevo ejemplar
        e = new Ejemplar(null, null, null, null);
        //Lo insertamos en la tabla
        me.nuevoEjemplar(e);
        tablaEjemplares.setRowSelectionInterval(me.getRowCount() - 1, me.getRowCount() - 1);
        //Se activa el botón de borrado de ejemplares
        btnBorrarEjemplar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoEjemplarActionPerformed

    //Permite borrar un ejemplar
    private void btnBorrarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarEjemplarActionPerformed
        //Declaramos la tabla de ejemplares
        ModeloTablaEjemplares me;
        //Inicializamos la tabla
        me = (ModeloTablaEjemplares) tablaEjemplares.getModel();
        //Hacemos un bucle que borre todos los valores de la tabla
        for (int i = 0; i < me.getRowCount(); i++) {
            if (me.getValueAt(i, 2) != null) {
                //De estar prestado el ejemplar mostramos una excepción (no se puede borrar)
                fa.muestraExcepcion("No se puede borrar el ejemplar. Está prestado.");
                return;
            }
        }

        //Obtenemos los ejemplares
        if (me.obtenerEjemplar(tablaEjemplares.getSelectedRow()).getNumEjemplar() != null) {
            //Y los añadimos a la lista de ejemplares borrados
            ejemplaresBorrados.add(me.obtenerEjemplar(tablaEjemplares.getSelectedRow()).getNumEjemplar());
        }
        //Y los borramos de la tabla
        me.borrarEjemplar(tablaEjemplares.getSelectedRow());
        //Si no quedan ejemplares en la tabla se deshabilita el botón para borrar
        if (me.getRowCount() == 0) {
            btnBorrarEjemplar.setEnabled(false);
        } else {
            //De haberlo, se selecciona el primero
            tablaEjemplares.setRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_btnBorrarEjemplarActionPerformed

    //Permite borrar el libro de la base de datos
    private void btnBorrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarLibroActionPerformed
        //Llamamos a la función para borrar el libro
        fa.borrarLibro(idLibro);
        //Buscamos los libros otra vez
        padre.buscarLibros();
        //Destruimos la ventana de libro actual
        this.dispose();
    }//GEN-LAST:event_btnBorrarLibroActionPerformed

    //Permite actualizar la información del libro
    private void btnActualizarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLibroActionPerformed
        //Declaramos e inicializamos un libro
        Libro l;
        l = new Libro(idLibro, textoTitulo.getText(), textoIsbn.getText(), textoEditorial.getText(),
                Integer.parseInt(textoPaginas.getText()), Integer.parseInt(textoAno.getText()));
        //Declaramos e inicializamos la lista de autores del libro
        ModeloListaStrings ma = (ModeloListaStrings) lstAutores.getModel();
        //Setteamos los autores al libro
        l.setAutores(ma.getElementos());
        //Actualizamos
        if (!fa.actualizarLibro(l).equals(idLibro)) {
            //Es imposible que el ID no sea el mismo, pero por si acaso comprobamos
            fa.muestraExcepcion("Hubo un problema con la generación del libro. Su ID no es el mismo");
            System.exit(ERROR);
        }
        //Setteamos la idLibro el el campo texto ID
        textoId.setText(idLibro.toString());
        //Habilitamos el botón para actualizar categorías y ejemplares y el de borrar el libro
        btnActualizarCategoriasLibro.setEnabled(true);
        btnActualizarEjemplaresLibro.setEnabled(true);
        btnBorrarLibro.setEnabled(true);
    }//GEN-LAST:event_btnActualizarLibroActionPerformed

    //Permite actualizar la información de las categorías del libro
    private void btnActualizarCategoriasLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCategoriasLibroActionPerformed
        //Declaramos e inicializamos la lista de categorías
        ModeloListaStrings ma = (ModeloListaStrings) lstCategoriasLibro.getModel();
        //Actualizamos las categorías
        fa.actualizarCategoriasLibro(idLibro, ma.getElementos());
    }//GEN-LAST:event_btnActualizarCategoriasLibroActionPerformed

    //Permite actualizar la información de los ejemplares del libro
    private void btnActualizarEjemplaresLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEjemplaresLibroActionPerformed
        //Declaramos e inicializamos variables
        java.util.List<Ejemplar> ejemplares;
        ModeloTablaEjemplares me = (ModeloTablaEjemplares) tablaEjemplares.getModel();

        //Comprobamos que, como son caracteres, para el año sean todos ellos de tipo numérico
        String ac = (String) me.getValueAt(tablaEjemplares.getSelectedRow(), 2);
        //Intentamos un cast de String a Integer
        try {
            Integer.parseInt(ac);
            //De no poder capturamos la excepción 
        } catch (NumberFormatException ex) {
            //Y la mostramos en una ventana
            fa.muestraExcepcion("Fecha introducida no válida");
            //Terminamos la función
            return;
        }
        //Si se pudo hacer el cast obtenemos los ejempalres
        ejemplares = me.getFilas();
        //Actualizamos los ejemplares en la base
        fa.actualizarEjemplaresLibro(idLibro, ejemplares, ejemplaresBorrados);
        //Actualizamos también la tabla de ejemplares
        actualizarTablaEjemplares();
    }//GEN-LAST:event_btnActualizarEjemplaresLibroActionPerformed

    //Permite prestar un ejemplar del libro (accedes a la ventana de préstamos)
    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        //Creamos el modelo de tabla de ejemplares
        ModeloTablaEjemplares me = (ModeloTablaEjemplares) tablaEjemplares.getModel();
        //Accedemos a la ventana de préstamos
        fa.accesoPrestamos(this, idLibro, me.obtenerEjemplar(tablaEjemplares.getSelectedRow()));
    }//GEN-LAST:event_btnPrestarActionPerformed

    //Permite devolver un ejemplar del libro
    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        //Creamos el modelo de tabla de ejemplares
        ModeloTablaEjemplares me = (ModeloTablaEjemplares) tablaEjemplares.getModel();
        //Devolvemos el préstamo
        fa.devolverPrestamo(idLibro, me.obtenerEjemplar(tablaEjemplares.getSelectedRow()));
        //Actualizamos la tabla de ejemplares
        actualizarTablaEjemplares();
    }//GEN-LAST:event_btnDevolverActionPerformed

    //Permite actualizar la información del libro
    private void tablaEjemplaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEjemplaresMouseClicked
        //Creamos el modelo de tabla de ejemplares
        ModeloTablaEjemplares me = (ModeloTablaEjemplares) tablaEjemplares.getModel();
        //Si se ha seleccionado una celda donde el valor del usuario es nulo
        if (me.getValueAt(tablaEjemplares.getSelectedRow(), 3) == null) {
            //Permitimos el préstamo y denegamos la devolución
            btnPrestar.setEnabled(true);
            btnDevolver.setEnabled(false);
        } else {
            //En otro caso denegamos el préstamo y permitimos la devolución
            btnDevolver.setEnabled(true);
            btnPrestar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaEjemplaresMouseClicked

    //Permite actualizar la tabla de ejemplares
    public void actualizarTablaEjemplares() {
        //Creamos el modelo de tabla
        ModeloTablaEjemplares mTEjemplares = new ModeloTablaEjemplares(fa);
        tablaEjemplares.setModel(mTEjemplares);
        //Metemos las filas actualizadas en la tabla
        mTEjemplares.setFilas(fa.actualizarEjemplaresLibro(idLibro, mTEjemplares.getFilas(), ejemplaresBorrados));
        //Si hay ejemplares
        if (mTEjemplares.getRowCount() > 0) {
            //Seleccionamos el primero y habilitamos el botón de borrado
            tablaEjemplares.setRowSelectionInterval(0, 0);
            btnBorrarEjemplar.setEnabled(true);
        } else {
            //De no haberlo, deshabillitamos el botón de borrado
            btnBorrarEjemplar.setEnabled(false);
        }

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCategoriasLibro;
    private javax.swing.JButton btnActualizarEjemplaresLibro;
    private javax.swing.JButton btnActualizarLibro;
    private javax.swing.JButton btnBorrarAutor;
    private javax.swing.JButton btnBorrarEjemplar;
    private javax.swing.JButton btnBorrarLibro;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnNuevoAutor;
    private javax.swing.JButton btnNuevoEjemplar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList lstAutores;
    private javax.swing.JList lstCategoriasLibro;
    private javax.swing.JList lstRestoCategorias;
    private javax.swing.JPanel panelCategorias;
    private javax.swing.JPanel panelEjemplares;
    private javax.swing.JPanel panelGeneralAutores;
    private javax.swing.JTabbedPane panelLibro;
    private javax.swing.JTable tablaEjemplares;
    private javax.swing.JTextField textoAno;
    private javax.swing.JTextField textoEditorial;
    private javax.swing.JTextField textoId;
    private javax.swing.JTextField textoIsbn;
    private javax.swing.JTextField textoNuevoAutor;
    private javax.swing.JTextField textoPaginas;
    private javax.swing.JTextField textoTitulo;
    // End of variables declaration//GEN-END:variables

}
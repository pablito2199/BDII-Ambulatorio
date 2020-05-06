package gui;

import aplicacion.clases.Ambulatorio;

public class VPrincipal extends javax.swing.JFrame {

    aplicacion.FachadaAplicacion fa;    //Enlace a la fachada de aplicación

    /**
     * Creates new form VPrincipal
     *
     * @param fa
     */
    //Constructor de la ventana
    public VPrincipal(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoCodigo = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        etiquetaCodigo = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAmbulatorios = new javax.swing.JTable();
        etiquetaTitulo = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        etiquetaProvincia = new javax.swing.JLabel();
        etiquetaFondos = new javax.swing.JLabel();
        etiquetaAntiguedad = new javax.swing.JLabel();
        etiquetaAnoConstruccion = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        textoProvincia = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        textoAnoConstruccion = new javax.swing.JTextField();
        textoAntiguedad = new javax.swing.JTextField();
        textoFondos = new javax.swing.JTextField();
        btnIngresos = new javax.swing.JButton();
        btnMateriales = new javax.swing.JButton();
        btnAsociados = new javax.swing.JButton();
        btnSalaUrgencias = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        menuMedicamentos = new javax.swing.JMenu();
        menuEnfermedades = new javax.swing.JMenu();
        menuPacientes = new javax.swing.JMenu();
        menuEspecialidades = new javax.swing.JMenu();
        menuHospitales = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RED DE AMBULATORIOS");
        setName("vPrincipal"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textoNombre.setToolTipText("Titulo a buscar");

        etiquetaCodigo.setText("Código:");

        etiquetaDireccion.setText("Dirección Postal:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaAmbulatorios.setModel(new ModeloTablaAmbulatorios());
        tablaAmbulatorios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAmbulatorios.getTableHeader().setReorderingAllowed(false);
        tablaAmbulatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAmbulatoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAmbulatorios);
        tablaAmbulatorios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        etiquetaTitulo.setText("Nombre:");

        etiquetaProvincia.setText("Provincia:");

        etiquetaFondos.setText("Fondos:");

        etiquetaAntiguedad.setText("Antigüedad:");

        etiquetaAnoConstruccion.setText("Año Construcción:");

        etiquetaTelefono.setText("Teléfono:");

        textoAntiguedad.setEditable(false);

        textoFondos.setEditable(false);

        btnIngresos.setText("Ingresos");
        btnIngresos.setEnabled(false);

        btnMateriales.setText("Materiales");
        btnMateriales.setEnabled(false);

        btnAsociados.setText("Asociados");
        btnAsociados.setEnabled(false);

        btnSalaUrgencias.setText("Sala Urgencias");
        btnSalaUrgencias.setEnabled(false);
        btnSalaUrgencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaUrgenciasActionPerformed(evt);
            }
        });

        btnConsultas.setText("Consultas");
        btnConsultas.setEnabled(false);
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnPersonal.setText("Personal");
        btnPersonal.setEnabled(false);
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaTitulo)
                            .addComponent(etiquetaCodigo)
                            .addComponent(etiquetaDireccion)
                            .addComponent(etiquetaProvincia)
                            .addComponent(etiquetaTelefono)
                            .addComponent(etiquetaAnoConstruccion)
                            .addComponent(etiquetaFondos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textoFondos, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textoAnoConstruccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(etiquetaAntiguedad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoAntiguedad))
                                .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnBuscar))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsociados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIngresos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalaUrgencias))
                    .addComponent(jScrollPane1))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaProvincia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoAnoConstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaAnoConstruccion)
                            .addComponent(textoAntiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaAntiguedad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoFondos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaFondos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMateriales)
                    .addComponent(btnAsociados)
                    .addComponent(btnIngresos)
                    .addComponent(btnSalaUrgencias)
                    .addComponent(btnPersonal)
                    .addComponent(btnConsultas))
                .addGap(14, 14, 14))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuMedicamentos.setText("Medicamentos");
        menuMedicamentos.setEnabled(false);
        jMenuBar3.add(menuMedicamentos);

        menuEnfermedades.setText("Enfermedades");
        menuEnfermedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEnfermedadesMouseClicked(evt);
            }
        });
        jMenuBar3.add(menuEnfermedades);

        menuPacientes.setText("Pacientes");
        menuPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPacientesMouseClicked(evt);
            }
        });
        jMenuBar3.add(menuPacientes);

        menuEspecialidades.setText("Especialidades");
        menuEspecialidades.setEnabled(false);
        jMenuBar3.add(menuEspecialidades);

        menuHospitales.setText("Hospitales");
        menuHospitales.setEnabled(false);
        jMenuBar3.add(menuHospitales);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getAccessibleContext().setAccessibleName("Biblioteca Informática");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Función que permite terminar la ejecución del programa
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Como esta es la ventana principal cerrarla significa terminar la ejecución
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    //Permite buscar los libros (al hacer click en el botón)
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Buscamos los ambulatorios
        buscarAmbulatorios();
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Botón Eliminar, permite eliminar un ambulatorio
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Obtenemos el ambulatorio deseado de la tabla
        ModeloTablaAmbulatorios ma = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();
        Integer codigoAmbulatorio = ma.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getCodigo();
        //Eliminamos el ambulatorio
        fa.borrarAmbulatorio(codigoAmbulatorio);
        //Ponemos todos los campos de texto en blanco
        textoAnoConstruccion.setText(null);
        textoAntiguedad.setText(null);
        textoCodigo.setText(null);
        textoDireccion.setText(null);
        textoNombre.setText(null);
        textoProvincia.setText(null);
        textoTelefono.setText(null);
        textoFondos.setText(null);
        //Actualizamos la tabla
        buscarAmbulatorios();
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Botón Limpiar, pone todos los campos de texto en blanco, y hace más fácil la inserción de un nuevo ambulatorio
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        ModeloTablaAmbulatorios ma = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();
        ma.setFilas(new java.util.ArrayList<>());
        textoAnoConstruccion.setText(null);
        textoAntiguedad.setText(null);
        textoCodigo.setText(null);
        textoDireccion.setText(null);
        textoNombre.setText(null);
        textoProvincia.setText(null);
        textoTelefono.setText(null);
        textoFondos.setText(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //Botón Actualizar, crea un nuevo ambulatorio o lo modifica
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //si los campos no están vacíos
        if (!textoNombre.getText().isEmpty() || !textoDireccion.getText().isEmpty()
                || !textoProvincia.getText().isEmpty() || !textoTelefono.getText().isEmpty()
                || (isNumeric(textoAnoConstruccion.getText()) || textoAnoConstruccion.getText().isEmpty())) {
            //creamos el ambulatorio
            Ambulatorio a = new Ambulatorio(textoNombre.getText(), textoDireccion.getText(),
                    textoAnoConstruccion.getText(), textoProvincia.getText(), textoTelefono.getText(), null);
            //modificamos o creamos uno nuevo si no está en la tabla
            if (fa.consultarAmbulatorioActual(textoNombre.getText(), textoProvincia.getText()) != null) {
                a.setCodigo(Integer.parseInt(textoCodigo.getText()));
                fa.modificarAmbulatorio(a);
            } else {
                fa.insertarAmbulatorio(a);
            }
            //habilitamos los botones
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnConsultas.setEnabled(true);
            btnSalaUrgencias.setEnabled(true);
            btnPersonal.setEnabled(true);
            //campos de texto en blanco para buscar
            textoAnoConstruccion.setText(null);
            textoAntiguedad.setText(null);
            textoCodigo.setText(null);
            textoDireccion.setText(null);
            textoNombre.setText(null);
            textoProvincia.setText(null);
            textoTelefono.setText(null);
            textoFondos.setText(null);
            buscarAmbulatorios();
        } else {
            fa.muestraExcepcion("!Debes rellenar todos los campos obligatorios!");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    //Botón Sala Urgencias, abre una nueva ventana de urgencias
    private void btnSalaUrgenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaUrgenciasActionPerformed
        //Obtenemos el ambulatorio deseado de la tabla
        ModeloTablaAmbulatorios ma = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();
        fa.nuevaVSalaUrgencias(ma.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()));
    }//GEN-LAST:event_btnSalaUrgenciasActionPerformed

    //Menú de consultas, abre una nueva ventana de Enfermedades
    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        //Obtenemos el ambulatorio deseado de la tabla
        ModeloTablaAmbulatorios ma = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();
        fa.nuevaVConsultas(ma.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getCodigo());
    }//GEN-LAST:event_btnConsultasActionPerformed

    //Botoón Personal, abre una nueva ventana de personal
    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        fa.nuevaVPersonal();
    }//GEN-LAST:event_btnPersonalActionPerformed

    //Al pulsar sobre un ambulatorio de la tabla, se colocan todos sus datos en los campos de texto 
    private void tablaAmbulatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAmbulatoriosMouseClicked
        ModeloTablaAmbulatorios m = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();
        textoCodigo.setText(String.valueOf(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getCodigo()));
        textoNombre.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getNombre());
        textoDireccion.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getDireccion());
        textoProvincia.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getProvincia());
        textoTelefono.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getTelefono());
        textoAnoConstruccion.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getAnoConstruccion());
        textoAntiguedad.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getAntiguedad());
        textoFondos.setText(String.valueOf(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getIngresos()));
    }//GEN-LAST:event_tablaAmbulatoriosMouseClicked

    //menú Enfermedades, abre la ventana de Enfermedades
    private void menuEnfermedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEnfermedadesMouseClicked
        fa.nuevaVEnfermedades();
    }//GEN-LAST:event_menuEnfermedadesMouseClicked

    //menú Pacientes, abre la ventana de Pacientes
    private void menuPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPacientesMouseClicked
        fa.nuevaVPacientes();
    }//GEN-LAST:event_menuPacientesMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsociados;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMateriales;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnSalaUrgencias;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel etiquetaAnoConstruccion;
    private javax.swing.JLabel etiquetaAntiguedad;
    private javax.swing.JLabel etiquetaCodigo;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaFondos;
    private javax.swing.JLabel etiquetaProvincia;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuEnfermedades;
    private javax.swing.JMenu menuEspecialidades;
    private javax.swing.JMenu menuHospitales;
    private javax.swing.JMenu menuMedicamentos;
    private javax.swing.JMenu menuPacientes;
    private javax.swing.JTable tablaAmbulatorios;
    private javax.swing.JTextField textoAnoConstruccion;
    private javax.swing.JTextField textoAntiguedad;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoFondos;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoProvincia;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    //Permite buscar el/los ambulatorio(s) que cumplan el criterio
    public void buscarAmbulatorios() {
        //Creamos el modelo de tabla de ambulatorios
        ModeloTablaAmbulatorios m;
        m = (ModeloTablaAmbulatorios) tablaAmbulatorios.getModel();

        //Obtenemos codigo de ambulatorio si se indica
        Integer codigo;
        try {
            codigo = Integer.parseInt(textoCodigo.getText());
        } catch (NumberFormatException e) {
            codigo = null;
        }

        //Tomamos las filas que regresa la función de búsqueda y por tanto cumplan el criterio
        m.setFilas(fa.obtenerAmbulatorios(textoNombre.getText(), codigo, textoProvincia.getText()));
        //Si hay algún resultado
        if (m.getRowCount() > 0) {
            //Se seleciona la primera fila
            tablaAmbulatorios.setRowSelectionInterval(0, 0);
            //Se habilitan los botones correspondientes
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnConsultas.setEnabled(true);
            btnSalaUrgencias.setEnabled(true);
            btnPersonal.setEnabled(true);
            textoCodigo.setText(String.valueOf(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getCodigo()));
            textoNombre.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getNombre());
            textoDireccion.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getDireccion());
            textoProvincia.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getProvincia());
            textoTelefono.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getTelefono());
            textoAnoConstruccion.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getAnoConstruccion());
            textoAntiguedad.setText(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getAntiguedad());
            textoFondos.setText(String.valueOf(m.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getIngresos()));
        } else {
            //En otro caso se deshabilitan
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnConsultas.setEnabled(false);
            btnSalaUrgencias.setEnabled(false);
            btnPersonal.setEnabled(false);
        }

    }

    //Comprueba si un dato se puede convertir a Integer
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}

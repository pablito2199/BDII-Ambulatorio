    package gui;

import aplicacion.clases.Consulta;

public class VConsultas extends javax.swing.JDialog {

    private VPrincipal padre;                                //Enlace a la ventana padre 
    private aplicacion.FachadaAplicacion fa;                 //Enlace a la fachada de aplicación
    private java.util.List<Consulta> consultas;              //Lista de consultas
    private Integer ambulatorio;                             //Ambulatorio actual

    /**
     * 
     * @param parent
     * @param modal
     * @param fa
     * @param restoConsultas
     * @param ambulatorio 
     */
    public VConsultas(javax.swing.JFrame parent, boolean modal, aplicacion.FachadaAplicacion fa, java.util.List<Integer> restoConsultas, Integer ambulatorio) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        this.ambulatorio = ambulatorio;

        //obtiene la lista de consultas para mostrarlas por pantalla
        ModeloListaIntegers m = new ModeloListaIntegers();
        lstConsultas.setModel(m);
        m.setElementos(restoConsultas);
        consultas = fa.consultarConsultas(null, ambulatorio, null);
        if (m.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstConsultas.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnEliminarConsultas.setEnabled(true);
        } else {
            btnEliminarConsultas.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuario = new javax.swing.JTabbedPane();
        panelGeneral = new javax.swing.JPanel();
        etiquetaNumeroConsulta = new javax.swing.JLabel();
        textoNumeroConsulta = new javax.swing.JTextField();
        btnBuscarConsultas = new javax.swing.JButton();
        btnLimpiarConsultas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstConsultas = new javax.swing.JList();
        btnRegresar = new javax.swing.JButton();
        btnAnadirConsultas = new javax.swing.JButton();
        btnEliminarConsultas = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        etiquetaNumeroConsultasAmbulatorio = new javax.swing.JLabel();
        textoTotalConsultas = new javax.swing.JTextField();
        btnGestionarMedicos = new javax.swing.JButton();
        seleccionEspecialidades = new javax.swing.JComboBox<>();
        etiquetaEspecialidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de libros");
        setResizable(false);

        panelGeneral.setForeground(new java.awt.Color(0, 0, 0));

        etiquetaNumeroConsulta.setText("Número Consulta:");

        btnBuscarConsultas.setText("Buscar");
        btnBuscarConsultas.setToolTipText("");
        btnBuscarConsultas.setActionCommand("Actualizar");
        btnBuscarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConsultasActionPerformed(evt);
            }
        });

        btnLimpiarConsultas.setText("Limpiar");
        btnLimpiarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConsultasActionPerformed(evt);
            }
        });

        lstConsultas.setModel(new ModeloListaStrings());
        lstConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstConsultasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstConsultas);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAnadirConsultas.setText("Añadir");
        btnAnadirConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirConsultasActionPerformed(evt);
            }
        });

        btnEliminarConsultas.setText("Eliminar");
        btnEliminarConsultas.setEnabled(false);
        btnEliminarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConsultasActionPerformed(evt);
            }
        });

        etiquetaNumeroConsultasAmbulatorio.setText("Total:");

        textoTotalConsultas.setEditable(false);

        btnGestionarMedicos.setText("Gestionar Médicos");
        btnGestionarMedicos.setToolTipText("");
        btnGestionarMedicos.setActionCommand("Actualizar");
        btnGestionarMedicos.setEnabled(false);

        seleccionEspecialidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        etiquetaEspecialidad.setText("Especialidad");

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(btnLimpiarConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnadirConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarConsultas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addContainerGap())
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(etiquetaNumeroConsultasAmbulatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoTotalConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addComponent(etiquetaNumeroConsulta)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoNumeroConsulta)
                                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(btnBuscarConsultas)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnGestionarMedicos)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(seleccionEspecialidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetaEspecialidad)
                                .addGap(121, 121, 121))))))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(etiquetaNumeroConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarConsultas)
                            .addComponent(btnGestionarMedicos))
                        .addGap(18, 18, 18)
                        .addComponent(etiquetaEspecialidad)
                        .addGap(5, 5, 5)
                        .addComponent(seleccionEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNumeroConsultasAmbulatorio)
                    .addComponent(textoTotalConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarConsultas)
                    .addComponent(btnRegresar)
                    .addComponent(btnAnadirConsultas)
                    .addComponent(btnEliminarConsultas))
                .addContainerGap())
        );

        panelUsuario.addTab("Consultas", panelGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUsuario.getAccessibleContext().setAccessibleName("Libro");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botón de Limpiar, pone en blanco cada uno de los huecos de texto para poder añadir nuevas consultas, y actualiza la lista
    private void btnLimpiarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConsultasActionPerformed
        textoNumeroConsulta.setText(null);
        //quita la selección actual de la lista
        lstConsultas.clearSelection();
        buscarConsultas();
    }//GEN-LAST:event_btnLimpiarConsultasActionPerformed

    //botón de Buscar, busca las consultas y las muestra en la lista
    private void btnBuscarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConsultasActionPerformed
        buscarConsultas();
    }//GEN-LAST:event_btnBuscarConsultasActionPerformed

    //cuando seleccionas un elemento de la tabla, los datos se pasan a la parte derecha para consultarse
    private void lstConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstConsultasMouseClicked
        // TODO add your handling code here:
        ModeloListaIntegers m = (ModeloListaIntegers) lstConsultas.getModel();
        textoNumeroConsulta.setText(m.getElementAt(lstConsultas.getSelectedIndex()).toString());

        
        
        /*SELECCIÓN DE LA ESPECIALIDAD*/
        
        
        
    }//GEN-LAST:event_lstConsultasMouseClicked

    //botón de Regresar, vuelve a la ventana principal
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //busca los ambulatorios en la ventana padre
        padre.buscarAmbulatorios();
        //cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    //botón de Añadir, añade una consulta nueva
    private void btnAnadirConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirConsultasActionPerformed
        if (!textoNumeroConsulta.getText().isEmpty()) {
            Consulta c = new Consulta(Integer.parseInt(textoNumeroConsulta.getText()), ambulatorio, seleccionEspecialidades.getSelectedItem().toString());
            //si la fila está seleccionada, modifica, en caso contrario, añade la enfermedad
            fa.anadirConsulta(c);
        } else {
            fa.muestraExcepcion("¡¡Debes rellenar todos los campos obligatorios!!");
        }
        //actualizamos la lista de consultas
        buscarConsultas();
        textoNumeroConsulta.setText(null);
        seleccionEspecialidades.setSelectedItem(0);
    }//GEN-LAST:event_btnAnadirConsultasActionPerformed

    //botón de Eliminar, elimina una consulta
    private void btnEliminarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConsultasActionPerformed
        ModeloListaIntegers m = (ModeloListaIntegers) lstConsultas.getModel();
        Integer numero = m.getElementAt(lstConsultas.getSelectedIndex());

        //Intentamos borrar la consulta
        if (fa.numeroConsultas(ambulatorio, seleccionEspecialidades.getSelectedItem().toString()) > 1) {
            fa.borrarConsulta(numero, ambulatorio, seleccionEspecialidades.getSelectedItem().toString());
        } else {
            fa.muestraExcepcion("¡¡No puedes eliminar esta consulta, es la única de la especialidad!!");
        }

        //actualizamos la lista de consultas
        textoNumeroConsulta.setText(null);
        seleccionEspecialidades.setSelectedItem(0);
        buscarConsultas();
    }//GEN-LAST:event_btnEliminarConsultasActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirConsultas;
    private javax.swing.JButton btnBuscarConsultas;
    private javax.swing.JButton btnEliminarConsultas;
    private javax.swing.JButton btnGestionarMedicos;
    private javax.swing.JButton btnLimpiarConsultas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaEspecialidad;
    private javax.swing.JLabel etiquetaNumeroConsulta;
    private javax.swing.JLabel etiquetaNumeroConsultasAmbulatorio;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList lstConsultas;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTabbedPane panelUsuario;
    private javax.swing.JComboBox<String> seleccionEspecialidades;
    private javax.swing.JTextField textoNumeroConsulta;
    private javax.swing.JTextField textoTotalConsultas;
    // End of variables declaration//GEN-END:variables

    //busca las consultas existentes en la tabla
    public void buscarConsultas() {
        ModeloListaIntegers m = new ModeloListaIntegers();
        lstConsultas.setModel(m);
        //buscamos las consultas existentes
        consultas = fa.consultarConsultas(Integer.parseInt(textoNumeroConsulta.getText()), ambulatorio, seleccionEspecialidades.getSelectedItem().toString());
        java.util.ArrayList<Integer> numero = new java.util.ArrayList<>();
        for (int i = 0; i < consultas.size(); i++) {
            numero.add(consultas.get(i).getIdentificador());
        }
        m.setElementos(numero);
        if (m.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstConsultas.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnEliminarConsultas.setEnabled(true);
        } else {
            btnEliminarConsultas.setEnabled(false);
        }
    }
}

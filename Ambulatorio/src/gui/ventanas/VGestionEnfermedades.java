package gui.ventanas;

import gui.Modelos.ModeloListaStrings;

public class VGestionEnfermedades extends javax.swing.JDialog {

    private final VPacientes padre;                                //Enlace a la ventana padre 
    private final aplicacion.FachadaAplicacion fa;                 //Enlace a la fachada de aplicación
    private String cipPaciente;                                    //Paciente actual
    private java.util.List<String> enfermedadesP;                  //Enfermedades padecidas
    private java.util.List<String> enfermedadesNP;                 //Enfermedades no padecidas

    /**
     *
     * @param parent
     * @param modal
     * @param fa
     * @param cipPaciente
     */
    //Constructor para nuevas ventanas de enfermedades asignadas
    public VGestionEnfermedades(java.awt.Dialog parent, boolean modal, aplicacion.FachadaAplicacion fa, String cipPaciente) {
        //Instanciamos
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPacientes) parent;
        this.cipPaciente = cipPaciente;

        enfermedadesNP = fa.obtenerEnfermedadesNoPadecidas(cipPaciente, "");
        //lista de enfermedades no registradas al paciente
        ModeloListaStrings mListaRE = new ModeloListaStrings();
        lstRestoEnfermedades.setModel(mListaRE);
        mListaRE.setElementos(enfermedadesNP);
        if (mListaRE.getSize() > 0) {
            lstRestoEnfermedades.setSelectedIndex(0);
            btnDerecha.setEnabled(true);
        } else {
            btnDerecha.setEnabled(false);
        }
        
        enfermedadesP = fa.obtenerEnfermedadesPadecidas(cipPaciente, "");
        //crea la lista de enfermedades registradas del paciente
        ModeloListaStrings mListaE = new ModeloListaStrings();
        lstEnfermedadesPadecidas.setModel(mListaE);
        mListaE.setElementos(enfermedadesP);
        if (mListaE.getSize() > 0) {
            lstEnfermedadesPadecidas.setSelectedIndex(0);
            btnIzquierda.setEnabled(true);
        } else {
            btnIzquierda.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstEnfermedadesPadecidas = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRestoEnfermedades = new javax.swing.JList();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        etiquetaRestoEnfermedades = new javax.swing.JLabel();
        etiquetaEnfermedadesPadecidas = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Enfermedades");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lstEnfermedadesPadecidas.setModel(new ModeloListaStrings());
        lstEnfermedadesPadecidas.setToolTipText("Lista de enfermedades padecidas");
        jScrollPane3.setViewportView(lstEnfermedadesPadecidas);

        lstRestoEnfermedades.setModel(new ModeloListaStrings());
        lstRestoEnfermedades.setToolTipText("Lista  de enfermedades no padecidas");
        jScrollPane2.setViewportView(lstRestoEnfermedades);

        btnDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ventanas/flechaD.jpg"))); // NOI18N
        btnDerecha.setToolTipText("Asigna enfermedad al paciente");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        btnIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ventanas/flechaI.jpg"))); // NOI18N
        btnIzquierda.setToolTipText("Desasigna enfermedad al paciente");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });

        etiquetaRestoEnfermedades.setText("Enfermedades");

        etiquetaEnfermedadesPadecidas.setText("Enfermedades que padece");

        etiquetaNombre.setText("Nombre:");

        textoNombre.setToolTipText("Nombre de la enfermedad");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca enfermedades");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(etiquetaRestoEnfermedades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaEnfermedadesPadecidas))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaRestoEnfermedades)
                            .addComponent(etiquetaEnfermedadesPadecidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Vuelve a la ventana anterior");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Pone en blanco los cuadros de texto");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("Actualiza las enfermedades de los pacientes");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnLimpiar)
                .addComponent(btnActualizar))
            .addComponent(btnRegresar)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón Buscar, filtra las enfermedades en ambas listas
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEnfermedadesPadecidas(textoNombre.getText());
        buscarEnfermedadesNoPadecidas(textoNombre.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Botón Flecha Derecha, asigna una enfermedad al paciente
    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        ModeloListaStrings mRE = (ModeloListaStrings) lstRestoEnfermedades.getModel();
        ModeloListaStrings mE = (ModeloListaStrings) lstEnfermedadesPadecidas.getModel();
        enfermedadesP.add(mRE.getElementAt(lstRestoEnfermedades.getSelectedIndex())); //añadimos el elemento de la lista
        enfermedadesNP.remove(lstRestoEnfermedades.getSelectedIndex()); //eliminamos el elemento de la lista
        mE.setElementos(enfermedadesP);
        mRE.setElementos(enfermedadesNP);
        if (mRE.getSize() == 0) {
            btnDerecha.setEnabled(false); //desactivamos flecha derecha si no hay elementos
        } else {
            lstRestoEnfermedades.setSelectedIndex(0); //si hay elementos, seleccionamos el primero
        }
        lstEnfermedadesPadecidas.setSelectedIndex(mE.getSize() - 1); //seleccionamos el último elemento (el nuevo de la lista)
        btnIzquierda.setEnabled(true); //activamos flecha izquierda
    }//GEN-LAST:event_btnDerechaActionPerformed

    //Botón Flecha Izquierda, quita una enfermedad al paciente, operación inversa del botón Flecha Derecha
    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        ModeloListaStrings mRE = (ModeloListaStrings) lstRestoEnfermedades.getModel();
        ModeloListaStrings mE = (ModeloListaStrings) lstEnfermedadesPadecidas.getModel();
        enfermedadesNP.add(mE.getElementAt(lstEnfermedadesPadecidas.getSelectedIndex()));
        enfermedadesP.remove(lstEnfermedadesPadecidas.getSelectedIndex());
        mE.setElementos(enfermedadesP);
        mRE.setElementos(enfermedadesNP);
        if (mE.getSize() == 0) {
            btnIzquierda.setEnabled(false);
        } else {
            lstEnfermedadesPadecidas.setSelectedIndex(0);
        }
        lstRestoEnfermedades.setSelectedIndex(mRE.getSize() - 1);
        btnDerecha.setEnabled(true);
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    //Botón Limpiar, pone el campo de texto del nombre a nulo
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        textoNombre.setText(null);
        buscarEnfermedadesPadecidas(textoNombre.getText());
        buscarEnfermedadesNoPadecidas(textoNombre.getText());
    }//GEN-LAST:event_btnLimpiarActionPerformed

    //Botón Actualizar, guarda correctamente las enfermedades padecidas y no padecidas por el paciente
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //actualizamos las enfermedades que padece el paciente
        fa.actualizarEnfermedadesPaciente(cipPaciente, enfermedadesP);
        fa.muestraMensaje("Enfermedades del pacientes actualizadas correctamente.");
    }//GEN-LAST:event_btnActualizarActionPerformed

    //Botón Regresar, vuelve a la ventana anterior, cerrando la ventana actual
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //Cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaEnfermedadesPadecidas;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaRestoEnfermedades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstEnfermedadesPadecidas;
    private javax.swing.JList lstRestoEnfermedades;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

    //busca las enfermedades no padecidas en la lista
    public void buscarEnfermedadesNoPadecidas(String enfermedad) {
        java.util.List<String> enfermedadesNoPadecidas;
        ModeloListaStrings mListaRE = new ModeloListaStrings();
        lstRestoEnfermedades.setModel(mListaRE);
        //obtenemos las enfermedades no padecidas por el paciente
        enfermedadesNoPadecidas = fa.obtenerEnfermedadesNoActualizadas(enfermedadesP, enfermedad);
        //actualizamos la lista
        mListaRE.setElementos(enfermedadesNoPadecidas);
        if (mListaRE.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstRestoEnfermedades.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnDerecha.setEnabled(true);
        } else {
            btnDerecha.setEnabled(false);
        }
    }

    //busca las enfermedades padecidas en la lista
    public void buscarEnfermedadesPadecidas(String enfermedad) {
        java.util.List<String> enfermedadesPadecidas;
        ModeloListaStrings mListaE = new ModeloListaStrings();
        lstEnfermedadesPadecidas.setModel(mListaE);
        //obtenemos las enfermedades padecidas por el paciente
        enfermedadesPadecidas = fa.obtenerEnfermedadesNoActualizadas(enfermedadesNP, enfermedad);
        //actualizamos la lista
        mListaE.setElementos(enfermedadesPadecidas);
        if (mListaE.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstEnfermedadesPadecidas.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnIzquierda.setEnabled(true);
        } else {
            btnIzquierda.setEnabled(false);
        }
    }
}
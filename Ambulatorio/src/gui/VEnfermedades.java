/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Enfermedad;

public class VEnfermedades extends javax.swing.JDialog {

    private VPrincipal padre;
    private aplicacion.FachadaAplicacion fa;
    private java.util.List<Enfermedad> enfermedades;

    public VEnfermedades(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;

        //obtiene la lista de categorías para mostrarlas por pantalla
        ModeloListaEnfermedades mListaE = new ModeloListaEnfermedades();
        lstEnfermedades.setModel(mListaE);
        mListaE.setElementos(listaenfermedades);
        enfermedades = fa.consultarEnfermedades();
        if (mListaE.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstEnfermedades.setSelectedIndex(0);
            //activa el botón de Borrar
            btnEliminarEnfermedad.setEnabled(true);
        } else {
            btnEliminarEnfermedad.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarEnfermedad = new javax.swing.JButton();
        btnLimpiarEnfermedad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEnfermedades = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        btnRegresar = new javax.swing.JButton();
        btnAnadirEnfermedad = new javax.swing.JButton();
        btnEliminarEnfermedad = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de libros");
        setResizable(false);

        panelGeneral.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        btnBuscarEnfermedad.setText("Buscar");
        btnBuscarEnfermedad.setToolTipText("");
        btnBuscarEnfermedad.setActionCommand("Actualizar");
        btnBuscarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEnfermedadActionPerformed(evt);
            }
        });

        btnLimpiarEnfermedad.setText("Limpiar");
        btnLimpiarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEnfermedadActionPerformed(evt);
            }
        });

        lstEnfermedades.setModel(new ModeloListaStrings());
        lstEnfermedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEnfermedadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstEnfermedades);

        textoDescripcion.setColumns(20);
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAnadirEnfermedad.setText("Añadir");
        btnAnadirEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirEnfermedadActionPerformed(evt);
            }
        });

        btnEliminarEnfermedad.setText("Eliminar");
        btnEliminarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEnfermedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(btnLimpiarEnfermedad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnadirEnfermedad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarEnfermedad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addContainerGap())
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnBuscarEnfermedad))
                                    .addComponent(jScrollPane1))
                                .addContainerGap())))))
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarEnfermedad))
                    .addComponent(jScrollPane2))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarEnfermedad)
                    .addComponent(btnRegresar)
                    .addComponent(btnAnadirEnfermedad)
                    .addComponent(btnEliminarEnfermedad))
                .addContainerGap())
        );

        panelUsuario.addTab("Enfermedades", panelGeneral);

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

    //botón de Limpiar, pone en blanco cada uno de los huecos para poder añadir nuevas enfermedades, y actualiza la lista
    private void btnLimpiarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEnfermedadActionPerformed
        // TODO add your handling code here:
        textoNombre.setText(null);
        textoDescripcion.setText(null);
        //quita la selección actual de la lista
        lstEnfermedades.clearSelection();
        buscarEnfermedades();
    }//GEN-LAST:event_btnLimpiarEnfermedadActionPerformed

    //botón de Buscar, busca las enfermedades y las muestra en la lista
    private void btnBuscarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEnfermedadActionPerformed
        // TODO add your handling code here:
        buscarEnfermedades();
    }//GEN-LAST:event_btnBuscarEnfermedadActionPerformed

    //cuando se selecciona un elemento de la tabla, los datos se pasan a la parte derecha para consultarse
    private void lstEnfermedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEnfermedadesMouseClicked
        // TODO add your handling code here:
        ModeloListaEnfermedades mListaE = (ModeloListaEnfermedades) lstEnfermedades.getModel();
        textoNombre.setText(mListaE.getElementAt(lstEnfermedades.getSelectedIndex()));
        for (Enfermedad e : enfermedades) {
            if (e.getNombre().equals(mListaE.getElementAt(lstEnfermedades.getSelectedIndex()))) {
                textoDescripcion.setText(e.getDescripcion());
                break;
            }
        }
    }//GEN-LAST:event_lstEnfermedadesMouseClicked

    //botón de Regresar, vuelve a la ventana anterior
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        padre.buscarAmbulatorios();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    //botón de Añadir, añade una enfermedad a la base de datos
    private void btnAnadirEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirEnfermedadActionPerformed
        // TODO add your handling code here:
        if (!textoNombre.getText().isEmpty()) {
            Enfermedad e = new Enfermedad(textoNombre.getText(), textoDescripcion.getText());
            //si la fila está seleccionada, modifica, en caso contrario, añade la enfermedad
            if (lstEnfermedades.getSelectedIndex() >= 0) {
                fa.modificarEnfermedad(e);//no se va poder modificar el ID del usuario
            } else {
                fa.anadirEnfermedad(e);
            }
        } else {
            fa.muestraExcepcion("¡¡Debes rellenar todos los campos obligatorios!!");
        }
        buscarEnfermedades();
    }//GEN-LAST:event_btnAnadirEnfermedadActionPerformed

    //botón de Eliminar, elimina una enfermedad de la base de datos
    private void btnEliminarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEnfermedadActionPerformed
        // TODO add your handling code here:
        ModeloListaEnfermedades mListaE = (ModeloListaEnfermedades) lstEnfermedades.getModel();
        String nombre = mListaE.obtenerEnfermedad(lstEnfermedades.getSelectedIndex()).getNombre();
        fa.borrarUsuarioID(nombre);
        textoNombre.setText(null);
        textoDescripcion.setText(null);
        buscarEnfermedades();
    }//GEN-LAST:event_btnEliminarEnfermedadActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirEnfermedad;
    private javax.swing.JButton btnBuscarEnfermedad;
    private javax.swing.JButton btnEliminarEnfermedad;
    private javax.swing.JButton btnLimpiarEnfermedad;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList lstEnfermedades;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTabbedPane panelUsuario;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

}

package gui.ventanas;

import gui.modelos.ModeloListaStrings;
import aplicacion.clases.Enfermedad;

public class VEnfermedades extends javax.swing.JDialog {

    private VPrincipal padre;                                //Enlace a la ventana padre 
    private aplicacion.FachadaAplicacion fa;                 //Enlace a la fachada de aplicación
    private java.util.List<Enfermedad> enfermedades;         //Lista de enfermedades

    /**
     *
     * @param parent
     * @param modal
     * @param fa
     */
    public VEnfermedades(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        padre.setVisible(false);

        //obtiene la lista de consultas para mostrarlas por pantalla
        ModeloListaStrings mListaE = new ModeloListaStrings();
        enfermedades = fa.consultarEnfermedades(textoNombre.getText());
        if (mListaE.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstEnfermedades.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnEliminarEnfermedad.setEnabled(true);
            //ponemos los datos seleccionados en la parte derecha
            textoNombre.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getNombre());
            textoDescripcion.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getDescripcion());
        } else {
            //desactiva el botón Eliminar
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

        panelEnfermedad = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEnfermedades = new javax.swing.JList();
        etiquetaNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        etiquetaDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnEliminarEnfermedad = new javax.swing.JButton();
        btnActualizarEnfermedad = new javax.swing.JButton();
        btnLimpiarEnfermedad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enfermedades");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lstEnfermedades.setModel(new ModeloListaStrings());
        lstEnfermedades.setToolTipText("Lista de todas las enfermedades");
        lstEnfermedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEnfermedadesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstEnfermedades);

        etiquetaNombre.setText("Nombre:");

        textoNombre.setToolTipText("Nombre de la enfermedad");

        etiquetaDescripcion.setText("Descripción:");

        textoDescripcion.setColumns(20);
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setRows(5);
        textoDescripcion.setToolTipText("Descripción de la enfermedad");
        jScrollPane1.setViewportView(textoDescripcion);

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca enfermedades");
        btnBuscar.setActionCommand("Actualizar");
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
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaDescripcion)
                        .addGap(146, 146, 146))
                    .addComponent(textoNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNombre)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(etiquetaDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Vuelve a la ventana anterior");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEliminarEnfermedad.setText("Eliminar");
        btnEliminarEnfermedad.setToolTipText("Elimina una enfermedad");
        btnEliminarEnfermedad.setEnabled(false);
        btnEliminarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEnfermedadActionPerformed(evt);
            }
        });

        btnActualizarEnfermedad.setText("Actualizar");
        btnActualizarEnfermedad.setToolTipText("Añade/Modifica una enfermedad");
        btnActualizarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEnfermedadActionPerformed(evt);
            }
        });

        btnLimpiarEnfermedad.setText("Limpiar");
        btnLimpiarEnfermedad.setToolTipText("Pone en blanco los cuadros de texto, así como limpia la lista");
        btnLimpiarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEnfermedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiarEnfermedad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarEnfermedad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarEnfermedad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiarEnfermedad)
                        .addComponent(btnActualizarEnfermedad)
                        .addComponent(btnEliminarEnfermedad))
                    .addComponent(btnRegresar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelEnfermedad.getAccessibleContext().setAccessibleName("Libro");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botón de Limpiar, pone en blanco cada uno de los huecos para poder añadir nuevas enfermedades, y actualiza la lista
    private void btnLimpiarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEnfermedadActionPerformed
        ModeloListaStrings mListaE = (ModeloListaStrings) lstEnfermedades.getModel();
        mListaE.setElementos(new java.util.ArrayList<>());
        //campos de texto en blanco
        textoNombre.setText(null);
        textoDescripcion.setText(null);
        btnEliminarEnfermedad.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarEnfermedadActionPerformed

    //botón de Añadir, añade una enfermedad a la base de datos
    private void btnActualizarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEnfermedadActionPerformed
        if (!textoNombre.getText().isEmpty()) {
            Enfermedad e = new Enfermedad(textoNombre.getText(), textoDescripcion.getText());
            //si existe la enfermedad modifica, si no, añade
            if (fa.consultarEnfermedadActual(textoNombre.getText()) != null) { //no se va poder modificar nombre de la enfermedad
                fa.modificarEnfermedad(e);
            } else {
                fa.anadirEnfermedad(e);
            }
        } else {
            fa.muestraExcepcion("¡¡Debes rellenar todos los campos obligatorios!!");
        }
        textoNombre.setText(null);
        textoDescripcion.setText(null);
        //actualizamos la lista de enfermedades
        buscarEnfermedades();
    }//GEN-LAST:event_btnActualizarEnfermedadActionPerformed

    //botón de Eliminar, elimina una enfermedad de la base de datos
    private void btnEliminarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEnfermedadActionPerformed
        ModeloListaStrings mListaE = (ModeloListaStrings) lstEnfermedades.getModel();
        String nombre = mListaE.getElementAt(lstEnfermedades.getSelectedIndex());
        //borramos la enfermedad seleccionada
        fa.borrarEnfermedad(nombre);
        textoNombre.setText(null);
        textoDescripcion.setText(null);
        //actualizamos la lista de enfermedades
        buscarEnfermedades();
    }//GEN-LAST:event_btnEliminarEnfermedadActionPerformed

    //botón de Regresar, vuelve a la ventana anterior
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        padre.setVisible(true);
        //buscamos los ambulatorios de la ventana padre
        padre.buscarAmbulatorios();
        //cerramos la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    //botón de Buscar, busca las enfermedades y las muestra en la lista
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEnfermedades();
    }//GEN-LAST:event_btnBuscarActionPerformed

    //cuando se selecciona un elemento de la lista, los datos se pasan a la parte derecha para consultarse
    private void lstEnfermedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEnfermedadesMouseClicked
        ModeloListaStrings mListaE = (ModeloListaStrings) lstEnfermedades.getModel();
        //si existe alguna enfermedad
        if (mListaE.getSize() > 0) {
            textoNombre.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getNombre());
            textoDescripcion.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getDescripcion());
        }
    }//GEN-LAST:event_lstEnfermedadesMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEnfermedad;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarEnfermedad;
    private javax.swing.JButton btnLimpiarEnfermedad;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstEnfermedades;
    private javax.swing.JTabbedPane panelEnfermedad;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

    //busca las enfermedades existentes en la lista
    public void buscarEnfermedades() {
        ModeloListaStrings mListaE = new ModeloListaStrings();
        lstEnfermedades.setModel(mListaE);
        //buscamos las enfermedades existentes
        enfermedades = fa.consultarEnfermedades(textoNombre.getText());
        java.util.ArrayList<String> nombres = new java.util.ArrayList<>();
        for (int i = 0; i < enfermedades.size(); i++) {
            nombres.add(enfermedades.get(i).getNombre());
        }
        mListaE.setElementos(nombres);
        if (mListaE.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstEnfermedades.setSelectedIndex(0);
            //activa el botón de Eliminar
            btnEliminarEnfermedad.setEnabled(true);
            textoNombre.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getNombre());
            textoDescripcion.setText(fa.consultarEnfermedadActual(mListaE.getElementAt(lstEnfermedades.getSelectedIndex())).getDescripcion());
        } else {
            btnEliminarEnfermedad.setEnabled(false);
        }
    }
}

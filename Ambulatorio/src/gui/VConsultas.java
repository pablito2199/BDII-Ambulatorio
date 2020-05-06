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
     * @param ambulatorio
     */
    public VConsultas(javax.swing.JFrame parent, boolean modal, aplicacion.FachadaAplicacion fa, Integer ambulatorio) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        this.ambulatorio = ambulatorio;

        //obtiene la lista de consultas para mostrarlas por pantalla
        ModeloListaIntegers m = new ModeloListaIntegers();
        consultas = fa.consultarConsultas(null, ambulatorio, null);
        if (m.getSize() > 0) {
            //selecciona el primer elemento de la lista automáticamente
            lstConsultas.setSelectedIndex(0);
            textoNumeroConsulta.setText(m.getElementAt(lstConsultas.getSelectedIndex()).toString());
            textoTotalConsultas.setText(fa.numeroConsultas(ambulatorio, null).toString());
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

        jPanel1 = new javax.swing.JPanel();
        etiquetaNumeroConsultasAmbulatorio = new javax.swing.JLabel();
        textoTotalConsultas = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstConsultas = new javax.swing.JList();
        etiquetaNumeroConsulta = new javax.swing.JLabel();
        textoNumeroConsulta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGestionarMedicos = new javax.swing.JButton();
        etiquetaEspecialidad = new javax.swing.JLabel();
        seleccionEspecialidades = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnLimpiarConsultas = new javax.swing.JButton();
        btnAnadirConsultas = new javax.swing.JButton();
        btnEliminarConsultas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        etiquetaNumeroConsultasAmbulatorio.setText("Total:");

        textoTotalConsultas.setEditable(false);

        lstConsultas.setModel(new ModeloListaStrings());
        lstConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstConsultasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstConsultas);

        etiquetaNumeroConsulta.setText("Número Consulta:");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.setActionCommand("Actualizar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGestionarMedicos.setText("Gestionar Médicos");
        btnGestionarMedicos.setToolTipText("");
        btnGestionarMedicos.setActionCommand("Actualizar");
        btnGestionarMedicos.setEnabled(false);

        etiquetaEspecialidad.setText("Especialidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNumeroConsultasAmbulatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoTotalConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etiquetaEspecialidad)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textoNumeroConsulta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGestionarMedicos)))
                                .addComponent(etiquetaNumeroConsulta)
                                .addComponent(seleccionEspecialidades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(etiquetaNumeroConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnGestionarMedicos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaEspecialidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNumeroConsultasAmbulatorio)
                    .addComponent(textoTotalConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnLimpiarConsultas.setText("Limpiar");
        btnLimpiarConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConsultasActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnLimpiarConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnadirConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(btnRegresar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiarConsultas)
                        .addComponent(btnAnadirConsultas)
                        .addComponent(btnEliminarConsultas))
                    .addComponent(btnRegresar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //botón de Limpiar, pone en blanco cada uno de los huecos de texto para poder añadir nuevas consultas, y actualiza la lista
    private void btnLimpiarConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConsultasActionPerformed
        ModeloListaIntegers m = (ModeloListaIntegers) lstConsultas.getModel();
        m.setElementos(new java.util.ArrayList<>());
        textoNumeroConsulta.setText(null);
    }//GEN-LAST:event_btnLimpiarConsultasActionPerformed

    //botón de Buscar, busca las consultas y las muestra en la lista
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarConsultas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    //cuando seleccionas un elemento de la tabla, los datos se pasan a la parte derecha para consultarse
    private void lstConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstConsultasMouseClicked
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarConsultas;
    private javax.swing.JButton btnGestionarMedicos;
    private javax.swing.JButton btnLimpiarConsultas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaEspecialidad;
    private javax.swing.JLabel etiquetaNumeroConsulta;
    private javax.swing.JLabel etiquetaNumeroConsultasAmbulatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstConsultas;
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

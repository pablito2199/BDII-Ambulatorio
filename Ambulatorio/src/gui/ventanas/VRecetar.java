package gui.ventanas;

import gui.modelos.ModeloListaStrings;
import aplicacion.clases.Cita;
import aplicacion.clases.Receta;


public class VRecetar extends javax.swing.JDialog {

    private final VCitasPendientes padre;                           //Enlace a la ventana padre
    private final aplicacion.FachadaAplicacion fa;      //Enlace a la fachada de aplicación
    private final Cita cita;
    private String medicamento;

    /**
     * Creates new form VPaciente
     *
     * @param parent
     * @param modal
     * @param fa
     * @param cita
     */
    //Constructor de la ventana
    public VRecetar(java.awt.Dialog parent, boolean modal, aplicacion.FachadaAplicacion fa, Cita cita) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VCitasPendientes) parent;
        this.cita = cita;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnRecetar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelMedicamento = new javax.swing.JLabel();
        varMedicamento = new javax.swing.JTextField();
        varFechaFin = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        varCantidad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        labelMEDICAMENTO = new javax.swing.JLabel();
        labelReceta = new javax.swing.JLabel();
        labelFechaFin = new javax.swing.JLabel();
        labelFechaInicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varDescripcion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMedicamentos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de recetas");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRecetar.setText("Recetar");
        btnRecetar.setToolTipText("Receta lo indicado");
        btnRecetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetarActionPerformed(evt);
            }
        });

        btnSalir.setText("Regresar");
        btnSalir.setToolTipText("Vuelve a la ventana anterior");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRecetar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecetar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelMedicamento.setText("Medicamento:");

        varMedicamento.setToolTipText("Medicamento de la receta");

        varFechaFin.setToolTipText("Fecha fin de la receta");

        labelDescripcion.setText("Descripcion:");

        varCantidad.setToolTipText("Cantidad de medicamento");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca medicamentos");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelMEDICAMENTO.setText("MEDICAMENTO");

        labelReceta.setText("RECETA");

        labelFechaFin.setText("Cantidad:");

        labelFechaInicio.setText("Fecha Fin:");

        varDescripcion.setColumns(20);
        varDescripcion.setRows(5);
        varDescripcion.setToolTipText("Descripción de la receta");
        jScrollPane1.setViewportView(varDescripcion);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listaMedicamentos.setModel(new ModeloListaStrings());
        listaMedicamentos.setToolTipText("Lista de medicamentos");
        listaMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaMedicamentos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelReceta)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelFechaInicio)
                                        .addGap(18, 18, 18)
                                        .addComponent(varFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDescripcion)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelFechaFin)
                                        .addGap(18, 18, 18)
                                        .addComponent(varCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMEDICAMENTO)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedicamento)
                    .addComponent(varMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMEDICAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(varFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFechaInicio))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(varCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFechaFin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Función que permite salir de la ventana de usuario
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Destruimos esta ventana
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    //Función que permite guardar el usuario en la base de datos
    private void btnRecetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetarActionPerformed
        //Comprobarmos que no haya ningún campo obligatorio sin cubrir
        if (varCantidad.getText().isEmpty() || varFechaFin.getText().isEmpty()
                || varDescripcion.getText().isEmpty() || listaMedicamentos.getSelectedIndex() == -1) {
            //Si lo hay activamos el aviso
            fa.muestraExcepcion("Necesitas rellenar todos los campos antes de poder recetar");
            //Regresamos
            return;
        }
        Integer cantidad = 0;
        //Comprobamos que los valores introducidos sean correctos
        if (!varCantidad.getText().isEmpty()) {
            //Intentamos convertir el NSS a entero
            try {
                cantidad = Integer.parseInt(varCantidad.getText());
                //Si al hacerlo es negativo imprimimos el error
                if (cantidad < 0) {
                    fa.muestraExcepcion("No se pueden recetar una cantidad negativa de Medicamento.");
                    return;
                }
                //De no poder convertir a entero se imprime la excepción
            } catch (NumberFormatException ex) {
                fa.muestraExcepcion("El valor introducido como cantidad no es válido.");
                return;
            }
        }
        java.sql.Date Fin = null;
        //Fecha de fin de la receta
        if (!varFechaFin.getText().isEmpty()) {
            //Intentamos convertirla a Date
            try {
                Fin = java.sql.Date.valueOf(varFechaFin.getText());
                //De no poder convertir a entero se imprime la excepción
            } catch (Exception ex) {
                fa.muestraExcepcion("El valor introducido como fecha de fin del tratamiento no es válido.");
                return;
            }
        }
        //Instanciamos la receta
        Receta r = new Receta(cita.getFechaHoraInicio(), cita.getPaciente(), cita.getConsulta(), cita.getAmbulatorio(),
                varDescripcion.getText(), Fin, medicamento, cantidad);
        fa.insertarReceta(r);
    }//GEN-LAST:event_btnRecetarActionPerformed

    //Función que permite buscar el/los usuario(s) una vez hecho click en el botón buscar
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Buscamos
        buscarMedicamentos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void listaMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMedicamentosMouseClicked
        ModeloListaStrings mListaM = (ModeloListaStrings) listaMedicamentos.getModel();
        //si existe alguna enfermedad
        if(mListaM.getSize()>0)
            medicamento = mListaM.getElementAt(listaMedicamentos.getSelectedIndex());
    }//GEN-LAST:event_listaMedicamentosMouseClicked

    //Función que permite buscar un medicamento en la base de datos
    public void buscarMedicamentos() {
        //Creamos el modelo de tabla préstamos
        ModeloListaStrings m;
        m = (ModeloListaStrings) listaMedicamentos.getModel();
        m.setElementos(fa.consultarMedicamentos(varMedicamento.getText()));
        //Seleccionamos la primera
        if(m.getSize()>0){
            listaMedicamentos.setSelectedIndex(0);
            btnRecetar.setEnabled(true);
        }
        else
            btnRecetar.setEnabled(false);
            
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRecetar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JLabel labelFechaInicio;
    private javax.swing.JLabel labelMEDICAMENTO;
    private javax.swing.JLabel labelMedicamento;
    private javax.swing.JLabel labelReceta;
    private javax.swing.JList listaMedicamentos;
    private javax.swing.JTextField varCantidad;
    private javax.swing.JTextArea varDescripcion;
    private javax.swing.JTextField varFechaFin;
    private javax.swing.JTextField varMedicamento;
    // End of variables declaration//GEN-END:variables

}

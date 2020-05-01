package gui;

import aplicacion.clases.Paciente;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VHistorialMedico extends javax.swing.JDialog {

    private final VPacientes padre;                     //Enlace a la ventana padre
    private final aplicacion.FachadaAplicacion fa;      //Enlace a la fachada de aplicación
    private final Paciente paciente;
    
    /**
     * Creates new form VPaciente
     *
     * @param parent
     * @param modal
     * @param fa
     */
    //Constructor de la ventana
    public VHistorialMedico(java.awt.Dialog parent, boolean modal, aplicacion.FachadaAplicacion fa, Paciente paciente) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPacientes) parent;
        this.paciente = paciente;
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
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        etiquetaDesde = new javax.swing.JLabel();
        varDesde = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        etiquetaHasta = new javax.swing.JLabel();
        varHasta = new javax.swing.JTextField();
        SeleccionTipoCita = new javax.swing.JComboBox<>();
        etiquetaResultados = new javax.swing.JLabel();
        textoTotalResultados = new javax.swing.JTextField();
        etiquetaCitasNoAsistidas = new javax.swing.JLabel();
        textoCitasNoAsistidas = new javax.swing.JTextField();
        textoCitasAtrasadas = new javax.swing.JTextField();
        etiquetaCitasAtrasadas = new javax.swing.JLabel();
        etiquetaTotalResultados1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHistorialMedico = new javax.swing.JTable();
        labelRecetar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de usuarios");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        etiquetaDesde.setText("Desde:");

        varDesde.setToolTipText("Domicilio");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        etiquetaHasta.setText("Hasta:");

        varHasta.setToolTipText("Domicilio");

        SeleccionTipoCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        etiquetaResultados.setText("Resultados");

        textoTotalResultados.setEditable(false);
        textoTotalResultados.setToolTipText("Domicilio");

        etiquetaCitasNoAsistidas.setText("Citas no asistidas:");

        textoCitasNoAsistidas.setEditable(false);
        textoCitasNoAsistidas.setToolTipText("Domicilio");

        textoCitasAtrasadas.setEditable(false);
        textoCitasAtrasadas.setToolTipText("Domicilio");

        etiquetaCitasAtrasadas.setText("Citas atrasadas:");

        etiquetaTotalResultados1.setText("Total resultados:");

        tablaHistorialMedico.setModel(new ModeloTablaHistorialMedico());
        tablaHistorialMedico.setAutoscrolls(false);
        tablaHistorialMedico.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaHistorialMedico);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(etiquetaTotalResultados1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiquetaResultados)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(SeleccionTipoCita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiquetaDesde)
                                .addGap(18, 18, 18)
                                .addComponent(varDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaHasta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(varHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textoTotalResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etiquetaCitasNoAsistidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoCitasNoAsistidas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaCitasAtrasadas)
                                .addGap(18, 18, 18)
                                .addComponent(textoCitasAtrasadas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SeleccionTipoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaDesde)
                            .addComponent(varDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaHasta)
                            .addComponent(varHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaResultados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTotalResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCitasNoAsistidas)
                    .addComponent(textoCitasNoAsistidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCitasAtrasadas)
                    .addComponent(textoCitasAtrasadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTotalResultados1))
                .addContainerGap())
        );

        labelRecetar.setText("HISTORIAL MÉDICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRecetar)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRecetar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        padre.buscarPacientes();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        SeleccionTipoCita.setSelectedItem(0);
        varDesde.setText(null);
        varHasta.setText(null);
        textoTotalResultados.setText(null);
        textoCitasNoAsistidas.setText(null);
        textoCitasAtrasadas.setText(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         //Creamos el modelo de tabla préstamos
        ModeloTablaHistorialMedico m;
        m = (ModeloTablaHistorialMedico) tablaHistorialMedico.getModel();
        java.sql.Date Inicio = null;
        java.sql.Date Fin = null;
        //Fecha de fin de la receta
        if (!varHasta.getText().isEmpty()) {
            //Intentamos convertirla a Date
            try {
                Fin = java.sql.Date.valueOf(varHasta.getText());
                //De no poder convertir a entero se imprime la excepción
            } catch (Exception ex) {
                fa.muestraExcepcion("El valor introducido como fecha de incio de la receta no es válido.");
                return;
            }
        }
        if (!varDesde.getText().isEmpty()) {
            //Intentamos convertirla a Date
            try {
                Inicio = java.sql.Date.valueOf(varDesde.getText());
                //De no poder convertir a entero se imprime la excepción
            } catch (Exception ex) {
                fa.muestraExcepcion("El valor introducido como fecha de fin de la receta no es válido.");
                return;
            }
        }
         //ahora converitmos a TimeStamp
        //Comprobamos la fecha de incio
        LocalDateTime minimo = LocalDate.now().plusDays(1).atStartOfDay();
        LocalDateTime inicioLDT = Inicio.toLocalDate().atStartOfDay();

        if (minimo.compareTo(inicioLDT) < 0) {
            minimo = inicioLDT;
        }
        //Recogemos la fecha en un Timestamp
        //Fecha de fin sera a las 00:00 del dia siguiente al especificado
        Timestamp inicioTS = Timestamp.valueOf(minimo);
        Timestamp finTS = Timestamp.valueOf(Fin.toLocalDate().atStartOfDay().plusDays(1));
        
        m.setFilas(fa.consultarHistorialClinico(paciente, inicioTS, finTS, );
    }//GEN-LAST:event_btnBuscarActionPerformed


    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SeleccionTipoCita;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaCitasAtrasadas;
    private javax.swing.JLabel etiquetaCitasNoAsistidas;
    private javax.swing.JLabel etiquetaDesde;
    private javax.swing.JLabel etiquetaHasta;
    private javax.swing.JLabel etiquetaResultados;
    private javax.swing.JLabel etiquetaTotalResultados1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelRecetar;
    private javax.swing.JTable tablaHistorialMedico;
    private javax.swing.JTextField textoCitasAtrasadas;
    private javax.swing.JTextField textoCitasNoAsistidas;
    private javax.swing.JTextField textoTotalResultados;
    private javax.swing.JTextField varDesde;
    private javax.swing.JTextField varHasta;
    // End of variables declaration//GEN-END:variables

}

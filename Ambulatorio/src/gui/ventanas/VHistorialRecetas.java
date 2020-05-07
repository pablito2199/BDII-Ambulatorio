package gui.ventanas;

import gui.modelos.ModeloTablaHistorialRecetas;
import aplicacion.clases.Paciente;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VHistorialRecetas extends javax.swing.JDialog {

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
    public VHistorialRecetas(java.awt.Dialog parent, boolean modal, aplicacion.FachadaAplicacion fa, Paciente paciente) {
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
        etiquetaTotalResultados = new javax.swing.JLabel();
        varTotal = new javax.swing.JTextField();
        etiquetaResultados = new javax.swing.JLabel();
        etiquetaMedicamento = new javax.swing.JLabel();
        varMedicamentos = new javax.swing.JTextField();
        etiquetaNumeroDeReceta = new javax.swing.JLabel();
        varNumeroDeReceta = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHistorialRecetas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial recetas");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Pone en blanco los cuadros de texto, así como limpia la tabla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Vuelve a la ventana anterior");
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

        varDesde.setToolTipText("Recetas desde la fecha");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca recetas");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        etiquetaHasta.setText("Hasta:");

        varHasta.setToolTipText("Recetas hasta la fecha");

        etiquetaTotalResultados.setText("Total resultados:");

        varTotal.setEditable(false);
        varTotal.setToolTipText("Recetas encontradas");

        etiquetaResultados.setText("Resultados");

        etiquetaMedicamento.setText("Medicamento:");

        varMedicamentos.setToolTipText("Medicamento de la receta");

        etiquetaNumeroDeReceta.setText("Número de receta:");

        varNumeroDeReceta.setToolTipText("Número de la receta");

        tablaHistorialRecetas.setModel(new ModeloTablaHistorialRecetas());
        tablaHistorialRecetas.setToolTipText("Tabla de recetas");
        tablaHistorialRecetas.setAutoscrolls(false);
        tablaHistorialRecetas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaHistorialRecetas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiquetaTotalResultados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaResultados)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiquetaDesde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaHasta)
                                .addGap(18, 18, 18)
                                .addComponent(varHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaNumeroDeReceta)))
                        .addGap(3, 6, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varNumeroDeReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiquetaMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varMedicamentos)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(etiquetaResultados))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaDesde)
                            .addComponent(varDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaHasta)
                            .addComponent(varHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaNumeroDeReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varNumeroDeReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaMedicamento)
                            .addComponent(varMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTotalResultados)
                    .addComponent(varTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        padre.buscarPacientes();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        varDesde.setText(null);
        varHasta.setText(null);
        varMedicamentos.setText(null);
        varNumeroDeReceta.setText(null);
        varTotal.setText(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Creamos el modelo de tabla préstamos
        ModeloTablaHistorialRecetas m;
        m = (ModeloTablaHistorialRecetas) tablaHistorialRecetas.getModel();
        Integer Num = 0;
        if (!varNumeroDeReceta.getText().isEmpty()) {
            //Intentamos convertir el numero de la receta a entero
            try {
                Num = Integer.parseInt(varNumeroDeReceta.getText());
                //Si al hacerlo es negativo imprimimos el error
                if (Num < 0) {
                    fa.muestraExcepcion("No se puede introducir un número de receta negativo.");
                    return;
                }
                //De no poder convertir a entero se imprime la excepción
            } catch (NumberFormatException ex) {
                fa.muestraExcepcion("El valor introducido como número de la receta no es válido.");
                return;
            }
        }
        java.sql.Date Inicio = null;
        java.sql.Date Fin = null;
        //Fecha de fin de la receta
        if (!varHasta.getText().isEmpty()) {
            //Intentamos convertirla a Date
            try {
                Fin = java.sql.Date.valueOf(varHasta.getText());
                //De no poder convertir a entero se imprime la excepción
            } catch (Exception ex) {
                fa.muestraExcepcion("El valor introducido como fecha de incio no es válido.");
                return;
            }
        }
        if (!varDesde.getText().isEmpty()) {
            //Intentamos convertirla a Date
            try {
                Inicio = java.sql.Date.valueOf(varDesde.getText());
                //De no poder convertir a entero se imprime la excepción
            } catch (Exception ex) {
                fa.muestraExcepcion("El valor introducido como fecha de fin no es válido.");
                return;
            }
        }
        m.setFilas(fa.consultarHistorialReceta(paciente, Inicio, Fin, Num, varMedicamentos.getText()));
        varTotal.setText(String.valueOf(m.getRowCount()));
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel etiquetaDesde;
    private javax.swing.JLabel etiquetaHasta;
    private javax.swing.JLabel etiquetaMedicamento;
    private javax.swing.JLabel etiquetaNumeroDeReceta;
    private javax.swing.JLabel etiquetaResultados;
    private javax.swing.JLabel etiquetaTotalResultados;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaHistorialRecetas;
    private javax.swing.JTextField varDesde;
    private javax.swing.JTextField varHasta;
    private javax.swing.JTextField varMedicamentos;
    private javax.swing.JTextField varNumeroDeReceta;
    private javax.swing.JTextField varTotal;
    // End of variables declaration//GEN-END:variables

}
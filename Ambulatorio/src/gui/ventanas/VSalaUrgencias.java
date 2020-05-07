package gui.ventanas;

import gui.modelos.ModeloTablaUrgencias;
import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Urgencia;

public class VSalaUrgencias extends javax.swing.JDialog {

    private VPrincipal padre;
    private FachadaAplicacion fa;
    private Ambulatorio ambulatorio;

    public VSalaUrgencias(java.awt.Frame parent, boolean modal, FachadaAplicacion fa, Ambulatorio ambulatorio) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPrincipal) parent;
        this.ambulatorio = ambulatorio;

        //Obtenemos urgencias actuales de la sala de espera
        ModeloTablaUrgencias tu = (ModeloTablaUrgencias) tablaUrgencias.getModel();
        tu.setFilas(fa.urgenciasPendientes(ambulatorio));

        //Contamos urgencias
        labelNumUrgencias.setText(String.valueOf(tu.getRowCount()));
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
        labelPrincipal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUrgencias = new javax.swing.JTable();
        labelCantidad = new javax.swing.JLabel();
        labelNumUrgencias = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAtender = new javax.swing.JButton();
        btnDerivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sala de urgencias");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelPrincipal.setText("Pacientes esperando en la sala de urgencias");

        tablaUrgencias.setModel(new ModeloTablaUrgencias());
        jScrollPane1.setViewportView(tablaUrgencias);

        labelCantidad.setText("Cantidad:");

        labelNumUrgencias.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrincipal)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNumUrgencias, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(labelNumUrgencias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });

        btnDerivar.setText("Derivar al hospital");
        btnDerivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDerivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAtender)
                    .addComponent(btnDerivar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        // TODO add your handling code here:

        //Obtenemos modelo
        ModeloTablaUrgencias tu = (ModeloTablaUrgencias) tablaUrgencias.getModel();

        //Atendemos urgencia en caso de que exista alguna
        if (tu.getRowCount() > 0) {

            //Atendemos la urgencia
            if (fa.atenderCita(tu.obtenerUrgencia())) {

                //Contamos urgencias
                labelNumUrgencias.setText(String.valueOf(tu.getRowCount()));

                //Feedback
                fa.muestraMensaje("Urgencia atendida correctamente.");
            }
            
            tu.setFilas(fa.urgenciasPendientes(ambulatorio));

        }
    }//GEN-LAST:event_btnAtenderActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:

        padre.buscarAmbulatorios();
        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnDerivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerivarActionPerformed
        // TODO add your handling code here:

        //Obtenemos modelo
        ModeloTablaUrgencias tu = (ModeloTablaUrgencias) tablaUrgencias.getModel();

        //Derivamos urgencia en caso de que exista alguna
        if (tu.getRowCount() > 0) {

            //Quitamos urgencia
            Urgencia u = tu.obtenerUrgencia();

            //Contamos urgencias
            labelNumUrgencias.setText(String.valueOf(tu.getRowCount()));

            //Derivamos la urgencia
            fa.nuevaVDerivarHospital(u);

            //Recuperamos urgencias en caso de que se cancelase la operacion
            tu.setFilas(fa.urgenciasPendientes(ambulatorio));
        }
    }//GEN-LAST:event_btnDerivarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtender;
    private javax.swing.JButton btnDerivar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelNumUrgencias;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JTable tablaUrgencias;
    // End of variables declaration//GEN-END:variables
}

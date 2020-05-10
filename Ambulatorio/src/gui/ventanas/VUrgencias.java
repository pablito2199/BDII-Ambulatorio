package gui.ventanas;

import gui.modelos.ModeloTablaAmbulatoriosUrgencias;
import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Consulta;
import aplicacion.clases.Paciente;
import aplicacion.clases.TipoCita;
import aplicacion.clases.Urgencia;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VUrgencias extends javax.swing.JDialog {

    private VPacientes padre;
    private aplicacion.FachadaAplicacion fa;
    private Paciente paciente;

    public VUrgencias(javax.swing.JDialog parent, boolean modal, FachadaAplicacion fa, Paciente paciente) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        padre = (VPacientes) parent;
        this.paciente = paciente;

        //Obtenemos modelo
        ModeloTablaAmbulatoriosUrgencias tau = (ModeloTablaAmbulatoriosUrgencias) tablaAmbulatorios.getModel();
        tau.setFilas(fa.obtenerAmbulatorios(null, null, null));

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
        labelAmbulatorio = new javax.swing.JLabel();
        txtAmbulatorio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAmbulatorios = new javax.swing.JTable();
        labelSoborno = new javax.swing.JLabel();
        txtSoborno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtGravedad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JToggleButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva urgencia");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelAmbulatorio.setText("Ambulatorio:");

        txtAmbulatorio.setToolTipText("Nombre del ambulatorio");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca ambulatorios");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaAmbulatorios.setModel(new ModeloTablaAmbulatoriosUrgencias(fa));
        tablaAmbulatorios.setToolTipText("Tabla de ambulatorios");
        tablaAmbulatorios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaAmbulatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAmbulatoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAmbulatorios);

        labelSoborno.setText("Soborno:");

        txtSoborno.setToolTipText("Soborno de la urgencia");

        jLabel1.setText("Gravedad:");

        txtGravedad.setToolTipText("Gravedad de la urgencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelAmbulatorio)
                        .addGap(18, 18, 18)
                        .addComponent(txtAmbulatorio)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelSoborno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSoborno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAmbulatorio)
                    .addComponent(txtAmbulatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSoborno)
                    .addComponent(txtSoborno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Vuelve a la ventana anterior");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setToolTipText("Confirma la urgencia");
        btnConfirmar.setEnabled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        //Obtenemos modelo
        ModeloTablaAmbulatoriosUrgencias tau = (ModeloTablaAmbulatoriosUrgencias) tablaAmbulatorios.getModel();

        //Buscamos ambulatorios
        ArrayList<Ambulatorio> ambs = (ArrayList<Ambulatorio>) fa.obtenerAmbulatorios(txtAmbulatorio.getText(), null, null);
        ArrayList<Ambulatorio> aux = new ArrayList<>();
        aux.addAll(ambs);
        
        //Comprobamos que tienen urgencias
        for (Ambulatorio a : ambs) {
            if (fa.consultarConsultas(null, a.getCodigo(), "General").isEmpty()) {
                aux.remove(a);
            }
        }
        tau.setFilas(aux);

        if (tau.getRowCount() > 0) {
            tablaAmbulatorios.setRowSelectionInterval(0, 0);
            txtAmbulatorio.setText(tau.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getNombre());
            btnConfirmar.setEnabled(true);
        } else {
            btnConfirmar.setEnabled(false);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:

        //Comprobamos que los datos son validos
        if (datosValidos()) {

            //Obtenemos ambulatorio
            ModeloTablaAmbulatoriosUrgencias tau = (ModeloTablaAmbulatoriosUrgencias) tablaAmbulatorios.getModel();
            Ambulatorio a = tau.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow());

            //Añadimos la urgencia
            Urgencia u = new Urgencia(
                    Float.parseFloat(txtSoborno.getText()),
                    Integer.parseInt(txtGravedad.getText()),
                    Timestamp.valueOf(LocalDateTime.now()),
                    paciente.getCIP(),
                    fa.menorNumeroPacientes(a.getCodigo(), "General").getIdentificador(),
                    a.getCodigo());

            fa.insertarUrgencia(u);

            //Feedback
            fa.muestraMensaje("Urgencia añadida correctamente.");

            //Añadimos urgencia al ambulatorio
            this.dispose();

        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:

        this.dispose();

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tablaAmbulatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAmbulatoriosMouseClicked
        ModeloTablaAmbulatoriosUrgencias tau = (ModeloTablaAmbulatoriosUrgencias) tablaAmbulatorios.getModel();
        txtAmbulatorio.setText(tau.obtenerAmbulatorio(tablaAmbulatorios.getSelectedRow()).getNombre());
    }//GEN-LAST:event_tablaAmbulatoriosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JToggleButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAmbulatorio;
    private javax.swing.JLabel labelSoborno;
    private javax.swing.JTable tablaAmbulatorios;
    private javax.swing.JTextField txtAmbulatorio;
    private javax.swing.JTextField txtGravedad;
    private javax.swing.JTextField txtSoborno;
    // End of variables declaration//GEN-END:variables

    //Comprobacion de que los datos introducidos y escogidos son validos
    private boolean datosValidos() {

        //Comprobamos si los campos de Soborno y Gravedad tienen valores no validos
        if (!(txtSoborno.getText().matches("\\d+(\\.\\d{1,2})?") && txtGravedad.getText().matches("[1-9]|10"))) {

            fa.muestraExcepcion("!Los campos de soborno y gravedad contienen valores no validos!");
            return false;

            //Comprobamos si se ha seleccionado un ambulatorio
        } else if (tablaAmbulatorios.getSelectedRow() < 0) {

            fa.muestraExcepcion("!No se ha seleccionado un ambulatorio de la tabla!");
            return false;
        }

        //Son datos validos
        return true;
    }
}

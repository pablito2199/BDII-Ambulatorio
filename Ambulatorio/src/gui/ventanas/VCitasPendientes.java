package gui.ventanas;

import gui.modelos.ModeloTablaCitas;
import aplicacion.FachadaAplicacion;
import aplicacion.clases.Paciente;
import aplicacion.clases.PersonalSanitario;

import java.sql.Date;
import java.util.ArrayList;

public class VCitasPendientes extends javax.swing.JDialog {

    private javax.swing.JDialog padre;
    private FachadaAplicacion fa;
    private PersonalSanitario ps;
    private Paciente pa;

    /**
     * Creates new form VCitasPendientes
     *
     * @param padre
     * @param modal
     * @param fa
     * @param ps
     */
    public VCitasPendientes(VPersonal padre, boolean modal, FachadaAplicacion fa, PersonalSanitario ps) {
        super(padre, modal);
        initComponents();
        this.padre = padre;
        this.ps = ps;
        this.fa = fa;

        //Ocultamos botones
        btnCancelarCita.setVisible(false);
    }

    public VCitasPendientes(VPacientes padre, boolean modal, FachadaAplicacion fa, Paciente pa) {
        super(padre, modal);
        initComponents();
        this.padre = padre;
        this.pa = pa;
        this.fa = fa;

        //Ocultamos botones
        btnRecetar.setVisible(false);
        btnTerminarCita.setVisible(false);
        btnDerivar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelDesde = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        labelHasta = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
        labelConsulta = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        labelAmbulatorio = new javax.swing.JLabel();
        txtAmbulatorio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        btnRecetar = new javax.swing.JButton();
        btnDerivar = new javax.swing.JButton();
        btnTerminarCita = new javax.swing.JButton();
        btnCancelarCita = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setTitle("Citas pendientes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegresar.setText("Regresar");
        btnRegresar.setToolTipText("Vuelve a la ventana anterior");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("Pone en blanco los cuadros de texto, así como limpia la lista");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelDesde.setText("Desde:");

        txtDesde.setText("aaaa-mm-dd");
        txtDesde.setToolTipText("Primer día a buscar");

        labelHasta.setText("Hasta:");

        txtHasta.setText("aaaa-mm-dd");
        txtHasta.setToolTipText("Último día a buscar");

        labelConsulta.setText("Consulta:");

        txtConsulta.setToolTipText("Número de consulta");

        labelAmbulatorio.setText("Ambulatorio:");

        txtAmbulatorio.setToolTipText("Nombre del ambulatorio");

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca las citas pendientes");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaCitas.setModel(new ModeloTablaCitas());
        tablaCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCitas);

        btnRecetar.setText("Recetar");
        btnRecetar.setToolTipText("Abre la ventana de Recetar");
        btnRecetar.setEnabled(false);
        btnRecetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetarActionPerformed(evt);
            }
        });

        btnDerivar.setText("Derivar al Hospital");
        btnDerivar.setToolTipText("Abre la ventana de Derivar al hospital");
        btnDerivar.setEnabled(false);
        btnDerivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerivarActionPerformed(evt);
            }
        });

        btnTerminarCita.setText("Terminar Cita");
        btnTerminarCita.setToolTipText("Termina la cita");
        btnTerminarCita.setEnabled(false);
        btnTerminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarCitaActionPerformed(evt);
            }
        });

        btnCancelarCita.setText("Cancelar Cita");
        btnCancelarCita.setToolTipText("Cancela la cita");
        btnCancelarCita.setEnabled(false);
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelAmbulatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmbulatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelDesde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelHasta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelConsulta)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRecetar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDerivar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDesde)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHasta)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelConsulta)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAmbulatorio)
                    .addComponent(txtAmbulatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecetar)
                    .addComponent(btnDerivar)
                    .addComponent(btnTerminarCita)
                    .addComponent(btnCancelarCita))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:

        //Limpiamos campos de texto y tabla
        txtDesde.setText("aaaa-mm-dd");
        txtHasta.setText("aaaa-mm-dd");
        txtConsulta.setText(null);
        txtAmbulatorio.setText(null);
        ((ModeloTablaCitas) tablaCitas.getModel()).setFilas(new ArrayList<>());

        //Desactivamos botones
        btnRecetar.setEnabled(false);
        btnTerminarCita.setEnabled(false);
        btnDerivar.setEnabled(false);
        btnCancelarCita.setEnabled(false);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        buscarCitas();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
        // TODO add your handling code here:

        //Obtenemos tabla
        ModeloTablaCitas tc = ((ModeloTablaCitas) tablaCitas.getModel());

        int index = tablaCitas.getSelectedRow();
        if (index >= 0) {

            //Borramos cita
            fa.borrarCita(tc.obtenerCita(index));

            //Quitamos cita
            tc.quitarCita(index);
        }

    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnTerminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarCitaActionPerformed
        // TODO add your handling code here:

        //Obtenemos tabla
        ModeloTablaCitas tc = ((ModeloTablaCitas) tablaCitas.getModel());

        int index = tablaCitas.getSelectedRow();
        if (index >= 0) {

            //Atendemos cita cita
            fa.atenderCita(tc.obtenerCita(index));

            //Rebuscamos citas para comprobar si se atendio correctamente
            buscarCitas();
        }
    }//GEN-LAST:event_btnTerminarCitaActionPerformed

    private void btnDerivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerivarActionPerformed
        // TODO add your handling code here:

        //Obtenemos tabla
        ModeloTablaCitas tc = ((ModeloTablaCitas) tablaCitas.getModel());

        int index = tablaCitas.getSelectedRow();
        if (index >= 0) {

            //Derivamos a un hospital
            fa.nuevaVDerivarHospital(tc.obtenerCita(index));
        }
    }//GEN-LAST:event_btnDerivarActionPerformed

    private void btnRecetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetarActionPerformed
        // TODO add your handling code here:

        //Obtenemos tabla
        ModeloTablaCitas tc = ((ModeloTablaCitas) tablaCitas.getModel());

        int index = tablaCitas.getSelectedRow();
        if (index >= 0) {

            //Añadimos receta
            fa.nuevaVRecetar(this, tc.obtenerCita(index));
        }

    }//GEN-LAST:event_btnRecetarActionPerformed

    private void tablaCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitasMouseClicked
        // TODO add your handling code here:

        //Activamos botones si selecciona una cita
        if (tablaCitas.getSelectedRow() >= 0) {
            btnRecetar.setEnabled(true);
            btnTerminarCita.setEnabled(true);
            btnDerivar.setEnabled(true);
            btnCancelarCita.setEnabled(true);
        }
        else {
            btnRecetar.setEnabled(false);
            btnTerminarCita.setEnabled(false);
            btnDerivar.setEnabled(false);
            btnCancelarCita.setEnabled(false);
        }
    }//GEN-LAST:event_tablaCitasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarCita;
    private javax.swing.JButton btnDerivar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRecetar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTerminarCita;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAmbulatorio;
    private javax.swing.JLabel labelConsulta;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTextField txtAmbulatorio;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables

    private boolean fechasValidas() {
        if ((!txtDesde.getText().matches("[1-2][0-9]{3}-((0[0-9])|(1[0-2]))-(([0-2][0-9])|(3[0-1]))")
                || !txtHasta.getText().matches("[1-2][0-9]{3}-((0[0-9])|(1[0-2]))-(([0-2][0-9])|(3[0-1]))"))
                && (!txtDesde.getText().equals("aaaa-mm-dd")
                || !txtHasta.getText().equals("aaaa-mm-dd"))) {
            fa.muestraExcepcion("El formato de las fechas no es válido.\nEj.: 2000-11-22.");
            return false;
        }
        return true;
    }

    private void buscarCitas() {

        if (fechasValidas()) {

            Date inicio, fin;

            //Solo puede ser un rango valido o si no las dos fechas son nulas
            try {
                inicio = Date.valueOf(txtDesde.getText());
                fin = Date.valueOf(txtHasta.getText());

                //Vemos si inicio es igual o mayor a fin
                if (inicio.after(fin)) {

                    fa.muestraExcepcion("La fecha de inicio es mayor a la de fin.");
                    return; //Cancelamos en caso de que lo sea
                }

            } catch (Exception e) {
                inicio = null;
                fin = null;
            }

            //Obtenemos tabla
            ModeloTablaCitas tc = ((ModeloTablaCitas) tablaCitas.getModel());

            //Obtenemos consulta
            Integer consulta;
            try {
                consulta = Integer.parseInt(txtConsulta.getText());

            } catch (NumberFormatException e) {
                consulta = null;
            }

            //Usamos consulta adecuada
            if (padre instanceof VPacientes) {
                tc.setFilas(fa.citasPaciente(pa, txtAmbulatorio.getText(), consulta, inicio, fin));
            } else {
                tc.setFilas(fa.citasMedico(ps, txtAmbulatorio.getText(), inicio, fin));
            }
            
            if (tc.getRowCount() > 0) {
                tablaCitas.setRowSelectionInterval(0, 0);
                btnCancelarCita.setEnabled(true);
                btnTerminarCita.setEnabled(true);
                btnRecetar.setEnabled(true);
                btnDerivar.setEnabled(true);
            } else {
                btnCancelarCita.setEnabled(false);
                btnTerminarCita.setEnabled(false);
                btnRecetar.setEnabled(false);
                btnDerivar.setEnabled(false);
            }
        }
    }
}

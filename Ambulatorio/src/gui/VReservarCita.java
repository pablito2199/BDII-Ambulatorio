package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.clases.Ambulatorio;
import aplicacion.clases.Cita;
import aplicacion.clases.Consulta;
import aplicacion.clases.Paciente;
import aplicacion.clases.TipoCita;
import java.sql.Date;
import java.util.ArrayList;

public class VReservarCita extends javax.swing.JDialog {

    private FachadaAplicacion fa;
    private VCitasPendientes padre;
    private Paciente pa;
    private Consulta co;

   /**
    * 
    * @param parent
    * @param modal
    * @param fa
    * @param pa 
    */
    public VReservarCita(java.awt.Dialog parent, boolean modal, FachadaAplicacion fa, Paciente pa) {
        super(parent, modal);
        this.fa = fa;
        this.pa = pa;
        this.padre = (VCitasPendientes) parent;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnReservar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        labelTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>(new ModeloComboTipoCita());
        labelDesde = new javax.swing.JLabel();
        labelHasta = new javax.swing.JLabel();
        txtAmbulatorio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHoras = new javax.swing.JTable();
        txtDesde = new javax.swing.JTextField();
        txtHasta = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        labelTipo.setText("Tipo:");

        labelDesde.setText("Desde:");

        labelHasta.setText("Hasta:");

        jLabel1.setText("Ambulatorio:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaHoras.setModel(new ModeloTablaHoras(fa, pa));
        jScrollPane2.setViewportView(tablaHoras);

        txtDesde.setText("01/01/2020");

        txtHasta.setText("01/01/2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReservar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(txtAmbulatorio)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDesde)
                                    .addComponent(labelHasta)
                                    .addComponent(labelTipo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(txtHasta))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTipo)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDesde)
                            .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHasta)
                            .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAmbulatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnReservar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        ArrayList<Ambulatorio> amb = (ArrayList<Ambulatorio>) fa.obtenerAmbulatorios(txtAmbulatorio.getText(), null, null);

        //Comprobamos que las fechas sean validas
        if (fechasValidas()) {

            Date inicio, fin;

            inicio = Date.valueOf(txtDesde.getText());
            fin = Date.valueOf(txtHasta.getText());

            //Vemos si inicio es igual o mayor a fin
            if (!inicio.after(fin)) {

                //Obtenemos tabla
                ModeloTablaHoras th = ((ModeloTablaHoras) tablaHoras.getModel());

                //Pasamos ambulatorios a la tabla
                th.setFilas(amb, (TipoCita) comboTipo.getSelectedItem(), inicio, fin);

            } else {
                fa.muestraExcepcion("¡La fecha de inicio es mayor a la de fin!");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // TODO add your handling code here:

        //No se ha seleccionado fila
        int index;
        if ((index = tablaHoras.getSelectedRow()) >= 0) {

            //Obtenemos modelo
            ModeloTablaHoras th = ((ModeloTablaHoras) tablaHoras.getModel());

            //Auxiliar
            Ambulatorio amb = th.obtenerAmbulatorio(index);
            TipoCita tipocita = (TipoCita) comboTipo.getSelectedItem();

            //Insertamos la cita
            Cita cita = new Cita(th.obtenerFechaHora(index),
                    pa.getCIP(), th.obtenerConsulta(amb).getIdentificador(),
                    amb.getCodigo(),
                    tipocita.getNombre(),
                    tipocita.getEspecialidad());
            
            fa.insertarCita(cita, pa);
            
            //Salimos
            this.dispose();

        } else {
            fa.muestraExcepcion("¡No se ha seleccionado una hora!");
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDesde;
    private javax.swing.JLabel labelHasta;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTable tablaHoras;
    private javax.swing.JTextField txtAmbulatorio;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables

    private boolean fechasValidas() {
        if (!txtDesde.getText().matches("([0-2][0-9])|(3[0-1])/(0[0-9])|(1[0-2])/2[0-9]{3}")
                || !txtHasta.getText().matches("([0-2][0-9])|(3[0-1])/(0[0-9])|(1[0-2])/2[0-9]{3}")) {

            fa.muestraExcepcion("¡El formato de las fechas no es valido! Ej.: 01/01/2020.");
            return false;
        }
        return true;
    }
}

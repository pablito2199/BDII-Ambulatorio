package gui;

import aplicacion.clases.Cita;
import aplicacion.clases.Receta;
import aplicacion.clases.Paciente;
import aplicacion.clases.GrupoSanguineo;
import java.sql.Date;

public class VRecetar extends javax.swing.JDialog {

    private final VCitasPendientes padre;                           //Enlace a la ventana padre
    private final aplicacion.FachadaAplicacion fa;      //Enlace a la fachada de aplicación
    private final Cita cita;
    private final String medicamento;

    /**
     * Creates new form VPaciente
     *
     * @param parent
     * @param modal
     * @param fa
     * @param cita
     */
    //Constructor de la ventana
    public VRecetar(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Cita cita) {
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
        varFechaInicio = new javax.swing.JTextField();
        labelDescripcion = new javax.swing.JLabel();
        varFechaFin = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        labelMEDICAMENTO = new javax.swing.JLabel();
        labelReceta = new javax.swing.JLabel();
        labelFechaFin = new javax.swing.JLabel();
        labelFechaInicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varDescripcion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMedicamentos = new javax.swing.JList<>();
        labelRecetar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de usuarios");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRecetar.setText("Recetar");
        btnRecetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetarActionPerformed(evt);
            }
        });

        btnSalir.setText("Regresar");
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

        varMedicamento.setToolTipText("Domicilio");

        varFechaInicio.setToolTipText("Nombre de usuario");
        varFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varFechaInicioActionPerformed(evt);
            }
        });

        labelDescripcion.setText("Descripcion:");

        varFechaFin.setToolTipText("Nombre del usuario");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelMEDICAMENTO.setText("MEDICAMENTO");

        labelReceta.setText("RECETA");

        labelFechaFin.setText("Fecha Fin:");

        labelFechaInicio.setText("Fecha Inicio:");

        varDescripcion.setColumns(20);
        varDescripcion.setRows(5);
        jScrollPane1.setViewportView(varDescripcion);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane3.setViewportView(listaMedicamentos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelReceta)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelFechaInicio)
                                    .addComponent(labelFechaFin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(varFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(varFechaFin)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDescripcion)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMEDICAMENTO)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedicamento)
                    .addComponent(varMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMEDICAMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(varFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFechaInicio))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(varFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFechaFin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        labelRecetar.setText("RECETAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRecetar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
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

    //Función que permite salir de la ventana de usuario
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Destruimos esta ventana
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    //Función que permite guardar el usuario en la base de datos
    private void btnRecetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetarActionPerformed

        //Comprobarmos que no haya ningún campo obligatorio sin cubrir
        if (varFechaFin.getText().isEmpty() || varFechaInicio.getText().isEmpty() || varDescripcion.getText().isEmpty() || FALTA 
            
            MEDICAMENTO
        
        
            ) {
            //Si lo hay activamos el aviso
            fa.muestraExcepcion("Necesitas rellenar todos los campos antes de poder actualizar");
            //Regresamos
            return;
        }
        //Instanciamos la receta
        Receta r = new Paciente(varCIP.getText(), varDNI.getText(), Integer.parseInt(varNSS.getText()), varNombre.getText(),
                Date.valueOf(varFechaFin.getText()), varSexo.getText(), GrupoSanguineo.valueOf(varGrupoSanguineo.getText()),
                varFechaInicio.getText(), varMedicamento.getText(), varTelefono.getText());
        fa.insertarPaciente(p);
        //Finalmente buscamos otra vez pacientes
        this.dispose();
    }//GEN-LAST:event_btnRecetarActionPerformed

    //Función que permite buscar el/los usuario(s) una vez hecho click en el botón buscar
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Buscamos
        buscarPacientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void varFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varFechaInicioActionPerformed

    //Función que permite buscar un usuario en la base de datos
    public void buscarPacientes() {
        //Creamos el modelo de tabla préstamos
        ModeloTablaPacientes m;
        m = (ModeloTablaPacientes) listaMedicamentos.getModel();
        Integer NSS = 0, edad = 0;
        //Setteamos las filas con el resultado de la búsqueda
        if (!varNSS.getText().isEmpty()) {
            //Intentamos convertir el NSS a entero
            try {
                NSS = Integer.parseInt(varNSS.getText());
                //Si al hacerlo es negativo imprimimos el error
                if (NSS < 0) {
                    fa.muestraExcepcion("El NSS (Número de la Seguridad Social) debe ser un número positivo.");
                    return;
                }
                //De no poder convertir a entero se imprime la excepción
            } catch (NumberFormatException ex) {
                fa.muestraExcepcion("El valor introducido para el NSS (Número de la Seguridad Social) no es válido.");
                return;
            }
        }
        if (!varEdad.getText().isEmpty()) {
            //Intentamos convertirla a entero
            try {
                edad = Integer.parseInt(varEdad.getText());
                //Si al hacerlo la edad es negativa imprimimos el error
                if (edad < 0) {
                    fa.muestraExcepcion("La edad debe ser un número positivo.");
                    return;
                }
                //De no poder convertir a entero se imprime la excepción
            } catch (NumberFormatException ex) {
                fa.muestraExcepcion("El valor introducido para la edad no es válido.");
                return;
            }
        }
        m.setFilas(fa.consultarPacientes(varCIP.getText(), varDNI.getText(), varNombre.getText(),
                edad, varSexo.getText(), NSS, varGrupoSanguineo.getText()));
        //Si hay coincidencias
        if (m.getRowCount() > 0) {
            //Seleccionamos la primera
            listaMedicamentos.setRowSelectionInterval(0, 0);
            //Habilitamos el borrado
            btnBorrar.setEnabled(true);
        } else {
            //De no haberlas, deshabilitamos el borrado
            btnBorrar.setEnabled(false);
        }
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JLabel labelFechaInicio;
    private javax.swing.JLabel labelMEDICAMENTO;
    private javax.swing.JLabel labelMedicamento;
    private javax.swing.JLabel labelReceta;
    private javax.swing.JLabel labelRecetar;
    private javax.swing.JList<String> listaMedicamentos;
    private javax.swing.JTextArea varDescripcion;
    private javax.swing.JTextField varFechaFin;
    private javax.swing.JTextField varFechaInicio;
    private javax.swing.JTextField varMedicamento;
    // End of variables declaration//GEN-END:variables

}
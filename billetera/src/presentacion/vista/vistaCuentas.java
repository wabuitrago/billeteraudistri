/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import presentacion.controlador.ControladorCuentas;
import presentacion.modelo.Modelo;

/**
 *
 * @author Jonathan
 */
public class vistaCuentas extends javax.swing.JFrame {
    
    

private final Modelo modelo;
    private ControladorCuentas control;
    
    public vistaCuentas(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
    }
   public ControladorCuentas getControl() {
        if(control == null){
            control = new ControladorCuentas(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }
    
        public JTextField getTxtnombreCuenta() {
        return TxtnombreCuenta;
    }

    public JButton getBtnCrearCue() {
        return BtnCrearCue;
    }

    public JButton getBtnRegresar() {
        return BtnRegresarCue;
    }

    public JComboBox<String> getCBTipoCuenta() {
        return CBTipoCuenta;
    }

    public JTable getTblCuentasConsulta() {
        return TblCuentasConsulta;
    }

    public JTextField getTxtIdCuenta() {
        return TxtIdCuenta;
    }

    public JButton getBtnEditarCue() {
        return BtnEditarCue;
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtnombreCuenta = new javax.swing.JTextField();
        BtnRegresarCue = new javax.swing.JButton();
        BtnCrearCue = new javax.swing.JButton();
        TxtIdCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CBTipoCuenta = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblCuentasConsulta = new javax.swing.JTable();
        BtnEditarCue = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cuentas");

        jLabel2.setText("Nombre de la Cuenta");

        BtnRegresarCue.setText("Regresar");

        BtnCrearCue.setText("Crear");

        TxtIdCuenta.setEditable(false);
        TxtIdCuenta.setEnabled(false);
        TxtIdCuenta.setFocusCycleRoot(true);

        jLabel4.setText("Tipo de Cuenta");

        CBTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta Debito", "Bolsillo", "Cuenta Ahorros" }));

        TblCuentasConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Cuenta", "Tipo Cuenta", "Nombre Cuenta", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TblCuentasConsulta);

        BtnEditarCue.setText("Editar");

        jLabel6.setText("Id Cuenta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtnombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BtnRegresarCue)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(208, 208, 208)
                                    .addComponent(BtnCrearCue)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnEditarCue))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtnombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCrearCue)
                    .addComponent(BtnEditarCue))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnRegresarCue)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCrearCue;
    private javax.swing.JButton BtnEditarCue;
    private javax.swing.JButton BtnRegresarCue;
    private javax.swing.JComboBox<String> CBTipoCuenta;
    private javax.swing.JTable TblCuentasConsulta;
    public javax.swing.JTextField TxtIdCuenta;
    public javax.swing.JTextField TxtnombreCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
        BtnRegresarCue.addActionListener(getControl());
        BtnCrearCue.addActionListener(getControl());
        BtnEditarCue.addActionListener(getControl());
     }
}

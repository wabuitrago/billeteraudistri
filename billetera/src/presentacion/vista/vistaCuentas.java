/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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

   private void capturarEventos() {
        BtnCrearCat.addActionListener(getControl());
        BtnRegresarCue.addActionListener(getControl());
        BtnEditarCue.addActionListener(getControl());
        Btnlistarcat.addActionListener(getControl());
        Btnokeditar.addActionListener(getControl());
    }
   
    public Modelo getModelo() {
        return modelo;
    }
    
        public JTextField getTxtnombreCuenta() {
        return TxtnombreCuenta;
    }

    public JButton getBtnRegresar() {
        return BtnRegresarCue;
    }

    public void setCBTipoCuenta(JComboBox CBTipoCuenta) {
        this.CBTipoCuenta = CBTipoCuenta;
    }
    
    
    public JComboBox getCBTipoCuenta() {
        return CBTipoCuenta;
    }

    public JTable getTblCuentasConsulta() {
        return TblCuentasConsulta;
    }

    public JButton getBtnCrearCat() {
        return BtnCrearCat;
    }

    public void setBtnCrearCat(JButton BtnCrearCat) {
        this.BtnCrearCat = BtnCrearCat;
    }

    public JButton getBtnEditarCue() {
        return BtnEditarCue;
    }

    public void setBtnEditarCue(JButton BtnEditarCue) {
        this.BtnEditarCue = BtnEditarCue;
    }

    public JButton getBtnRegresarCue() {
        return BtnRegresarCue;
    }

    public void setBtnRegresarCue(JButton BtnRegresarCue) {
        this.BtnRegresarCue = BtnRegresarCue;
    }

    public JButton getBtnlistarcat() {
        return Btnlistarcat;
    }

    public void setBtnlistarcat(JButton Btnlistarcat) {
        this.Btnlistarcat = Btnlistarcat;
    }

    public JButton getBtnokeditar() {
        return Btnokeditar;
    }

    public void setBtnokeditar(JButton Btnokeditar) {
        this.Btnokeditar = Btnokeditar;
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
        jLabel4 = new javax.swing.JLabel();
        CBTipoCuenta = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblCuentasConsulta = new javax.swing.JTable();
        BtnEditarCue = new javax.swing.JButton();
        Btnlistarcat = new javax.swing.JButton();
        BtnCrearCat = new javax.swing.JButton();
        Btnokeditar = new javax.swing.JButton();

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

        jLabel4.setText("Tipo de Cuenta");

        TblCuentasConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Cuenta", "Nombre Cuenta", "ID Tipo Cuenta", "Tipo Cuenta", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TblCuentasConsulta);

        BtnEditarCue.setText("Editar");

        Btnlistarcat.setText("Listar");

        BtnCrearCat.setText("Registrar");

        Btnokeditar.setText("Ok");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Btnlistarcat)
                                            .addGap(18, 18, 18)
                                            .addComponent(BtnCrearCat))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BtnEditarCue)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(CBTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TxtnombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(18, 18, 18)
                                    .addComponent(Btnokeditar)
                                    .addGap(138, 138, 138)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(BtnRegresarCue))))
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
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEditarCue)
                    .addComponent(Btnlistarcat)
                    .addComponent(BtnCrearCat)
                    .addComponent(Btnokeditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnRegresarCue)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearCat;
    private javax.swing.JButton BtnEditarCue;
    private javax.swing.JButton BtnRegresarCue;
    private javax.swing.JButton Btnlistarcat;
    private javax.swing.JButton Btnokeditar;
    private javax.swing.JComboBox CBTipoCuenta;
    private javax.swing.JTable TblCuentasConsulta;
    public javax.swing.JTextField TxtnombreCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


}

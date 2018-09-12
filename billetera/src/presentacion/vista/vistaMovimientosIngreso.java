/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import presentacion.controlador.ControladorMovimientos;
import presentacion.controlador.ControladorMovimientosIng;
import presentacion.modelo.Modelo;

/**
 *
 * @author camilo
 */
public class vistaMovimientosIngreso extends javax.swing.JFrame {


    private Modelo modelo;
    private ControladorMovimientosIng control;
    
    public vistaMovimientosIngreso(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
    }
   
    public ControladorMovimientosIng getControl() {
        if(control == null){
            control = new ControladorMovimientosIng(this);
        }
        return control;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btnregistrar = new javax.swing.JButton();
        Txtnotasmovimiento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Jdcfechamovimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Btnregresar = new javax.swing.JButton();
        CbTipoCuenta = new javax.swing.JComboBox();
        CbTipoCat1 = new javax.swing.JComboBox();
        Txtvalor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btnregistrar.setText("Registrar");

        jLabel3.setText("Notas");

        jLabel5.setText("Categorias");

        jLabel1.setText("Movimientos Ingresos");

        jLabel4.setText("Cuentas");

        jLabel2.setText("Fecha del Movimiento");

        Btnregresar.setText("Regresar");

        jLabel6.setText("Valor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Btnregresar)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(CbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(Txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(CbTipoCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel1)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addGap(81, 81, 81))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Jdcfechamovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                            .addComponent(Txtnotasmovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addComponent(Btnregistrar)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbTipoCat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(59, 59, 59)
                .addComponent(Btnregresar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addGap(119, 119, 119)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Jdcfechamovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Txtnotasmovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(Btnregistrar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Modelo getModelo() {
        return modelo;
    }

    public JButton getBtnregistrar() {
        return Btnregistrar;
    }

    public JTextField getTxtvalor() {
        return Txtvalor;
    }

    public JButton getBtnregresar() {
        return Btnregresar;
    }

    public JDateChooser getJdcfechamovimiento() {
        return Jdcfechamovimiento;
    }

    public JComboBox getCbTipoCat1() {
        return CbTipoCat1;
    }

    public JComboBox getCbTipoCuenta() {
        return CbTipoCuenta;
    }



    public JTextField getTxtnotasmovimiento() {
        return Txtnotasmovimiento;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnregistrar;
    private javax.swing.JButton Btnregresar;
    private javax.swing.JComboBox CbTipoCat1;
    private javax.swing.JComboBox CbTipoCuenta;
    private com.toedter.calendar.JDateChooser Jdcfechamovimiento;
    private javax.swing.JTextField Txtnotasmovimiento;
    private javax.swing.JTextField Txtvalor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
       
        Btnregistrar.addActionListener(getControl());
        Btnregresar.addActionListener(getControl());

    }


}

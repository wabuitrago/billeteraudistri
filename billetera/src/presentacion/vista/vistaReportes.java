/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import presentacion.controlador.ControladorReportes;
import presentacion.modelo.Modelo;

/**
 *
 * @author camilo
 */
public class vistaReportes extends javax.swing.JFrame {

    private final Modelo modelo;
    private ControladorReportes control;
    

    public vistaReportes(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
    }
    
   public ControladorReportes getControl() {
        if(control == null){
            control = new ControladorReportes(this);
        }
        return control;
    }    

    public Modelo getModelo() {
        return modelo;
    }

    public JButton getBtnGenerarReport() {
        return BtnGenerarReport;
    }

    public JButton getBtnexportar() {
        return Btnexportar;
    }

    public JDateChooser getJdcfechafinal() {
        return Jdcfechafinal;
    }

    public JDateChooser getJdcfechainicial() {
        return Jdcfechainicial;
    }

    public JTable getTblresultadoreport() {
        return Tblresultadoreport;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdcfechainicial = new com.toedter.calendar.JDateChooser();
        Jdcfechafinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnGenerarReport = new javax.swing.JButton();
        Btnexportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblresultadoreport = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jdcfechainicial.setDateFormatString("dd/MM/yyyy");

        Jdcfechafinal.setDateFormatString("dd/MM/yyyy");

        jLabel1.setText("REPORTES");

        jLabel2.setText("Fecha de Inicio");

        jLabel3.setText("Fecha Final");

        BtnGenerarReport.setText("Generar Reporte");

        Btnexportar.setText("Exportar a Excel");

        Tblresultadoreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cuenta", "Categoria", "Saldo", "Tipo Movimiento", "Destino"
            }
        ));
        jScrollPane1.setViewportView(Tblresultadoreport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jdcfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(Jdcfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(BtnGenerarReport)
                        .addGap(18, 18, 18)
                        .addComponent(Btnexportar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jdcfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jdcfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGenerarReport)
                    .addComponent(Btnexportar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGenerarReport;
    private javax.swing.JButton Btnexportar;
    private com.toedter.calendar.JDateChooser Jdcfechafinal;
    private com.toedter.calendar.JDateChooser Jdcfechainicial;
    private javax.swing.JTable Tblresultadoreport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
        BtnGenerarReport.addActionListener(getControl());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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

    public JButton getBtngraficar() {
        return Btngraficar;
    }

    public JButton getBtnregresar() {
        return Btnregresar;
    }

    public JRadioButton getRbnCategorias() {
        return RbnCategorias;
    }

    public JRadioButton getRbnFechas() {
        return RbnFechas;
    }

    public JRadioButton getRbningvsegreso() {
        return Rbningvsegreso;
    }
    
  

    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bgptiporeportes = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblresultadoreport = new javax.swing.JTable();
        Jdcfechafinal = new com.toedter.calendar.JDateChooser();
        Jdcfechainicial = new com.toedter.calendar.JDateChooser();
        Btnregresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        RbnFechas = new javax.swing.JRadioButton();
        Rbningvsegreso = new javax.swing.JRadioButton();
        RbnCategorias = new javax.swing.JRadioButton();
        BtnGenerarReport = new javax.swing.JButton();
        Btngraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REPORTES");

        jLabel2.setText("Fecha de Inicio");

        jLabel3.setText("Fecha Final");

        Tblresultadoreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Categoria", "Cuenta", "Tipo Movimiento"
            }
        ));
        jScrollPane1.setViewportView(Tblresultadoreport);

        Btnregresar.setText("Regresar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reportes"));

        Bgptiporeportes.add(RbnFechas);
        RbnFechas.setSelected(true);
        RbnFechas.setText("Fechas");

        Bgptiporeportes.add(Rbningvsegreso);
        Rbningvsegreso.setText("Ingreso vs Egreso");

        Bgptiporeportes.add(RbnCategorias);
        RbnCategorias.setText("Categoria");

        BtnGenerarReport.setText("Generar Reporte");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RbnFechas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnGenerarReport)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RbnCategorias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Rbningvsegreso))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbnFechas)
                    .addComponent(Rbningvsegreso)
                    .addComponent(RbnCategorias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(BtnGenerarReport)
                .addContainerGap())
        );

        Btngraficar.setText("Graficar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jdcfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jdcfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44))))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(Btngraficar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btnregresar)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jdcfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jdcfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btngraficar)
                    .addComponent(Btnregresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Bgptiporeportes;
    private javax.swing.JButton BtnGenerarReport;
    private javax.swing.JButton Btngraficar;
    private javax.swing.JButton Btnregresar;
    private com.toedter.calendar.JDateChooser Jdcfechafinal;
    private com.toedter.calendar.JDateChooser Jdcfechainicial;
    private javax.swing.JRadioButton RbnCategorias;
    private javax.swing.JRadioButton RbnFechas;
    private javax.swing.JRadioButton Rbningvsegreso;
    private javax.swing.JTable Tblresultadoreport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
        BtnGenerarReport.addActionListener(getControl());
        Btngraficar.addActionListener(getControl());
        Btnregresar.addActionListener(getControl());

        
    }
}

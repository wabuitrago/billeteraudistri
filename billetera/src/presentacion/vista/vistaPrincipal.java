
package presentacion.vista;

import javax.swing.JLabel;
import javax.swing.JTextField;
import presentacion.modelo.Modelo;
import presentacion.controlador.ControladorPrincipal;


public class vistaPrincipal extends javax.swing.JFrame {

    private final Modelo modelo;
    private ControladorPrincipal control;
    
    public vistaPrincipal(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
    }
   public ControladorPrincipal getControl() {
        if(control == null){
            control = new ControladorPrincipal(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnMovimientos = new javax.swing.JButton();
        BtnCategorias = new javax.swing.JButton();
        BtnCuentas = new javax.swing.JButton();
        BtnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vista Principal");

        BtnMovimientos.setText("Movimientos");

        BtnCategorias.setText("Configuracion Categorias");

        BtnCuentas.setText("Cuentas");

        BtnReportes.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnCuentas)
                    .addComponent(BtnMovimientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCategorias)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnReportes)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCuentas)
                    .addComponent(BtnReportes))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMovimientos)
                    .addComponent(BtnCategorias))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCategorias;
    public javax.swing.JButton BtnCuentas;
    public javax.swing.JButton BtnMovimientos;
    public javax.swing.JButton BtnReportes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
        BtnCuentas.addActionListener(getControl());
        BtnMovimientos.addActionListener(getControl());
        BtnReportes.addActionListener(getControl());
        BtnCategorias.addActionListener(getControl());
    }

}

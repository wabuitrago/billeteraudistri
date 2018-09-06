
package presentacion.vista;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import presentacion.controlador.ControladorCategoria;
import presentacion.modelo.Modelo;


public class vistaCategorias extends javax.swing.JFrame {

    private Modelo modelo;
    private ControladorCategoria control;
    
    public vistaCategorias(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
    }
   public ControladorCategoria getControl() {
        if(control == null){
            control = new ControladorCategoria(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JComboBox<String> getCbTipoCat() {
        return CbTipoCat;
    }

    public JTextField getTxtNombreCat() {
        return TxtNombreCat;
    }

     
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnCrearCat = new javax.swing.JButton();
        TxtNombreCat = new javax.swing.JTextField();
        CbTipoCat = new javax.swing.JComboBox<>();
        BtnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Categorias");

        BtnCrearCat.setText("Crear");

        CbTipoCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingreso", "Egreso" }));
        CbTipoCat.setToolTipText("");
        CbTipoCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTipoCatActionPerformed(evt);
            }
        });

        BtnRegresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(BtnCrearCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCrearCat)
                    .addComponent(TxtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(BtnRegresar)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbTipoCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTipoCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbTipoCatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearCat;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JComboBox<String> CbTipoCat;
    private javax.swing.JTextField TxtNombreCat;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
        BtnCrearCat.addActionListener(getControl());
        
    }
}

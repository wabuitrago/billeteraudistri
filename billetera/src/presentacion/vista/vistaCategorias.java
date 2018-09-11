
package presentacion.vista;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import presentacion.controlador.ControladorCategoria;
import presentacion.modelo.Modelo;


public class vistaCategorias extends javax.swing.JFrame {

    private final Modelo modelo;
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

   
    public JTextField getTxtNombreCat() {
        return TxtNombreCat;
    }

    public JTable getTblcatconsulta() {
        return Tblcatconsulta;
    }

    public JButton getBtneditarcat() {
        return Btneditarcat;
    }

    public JButton getBtnlistarcat() {
        return Btnlistarcat;
    }

    public JButton getBtnCrearCat() {
        return BtnCrearCat;
    }

    public JButton getBtnRegresar() {
        return BtnRegresar;
    }

    public JButton getBtnokeditar() {
        return Btnokeditar;
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtnCrearCat = new javax.swing.JButton();
        TxtNombreCat = new javax.swing.JTextField();
        BtnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblcatconsulta = new javax.swing.JTable();
        Btneditarcat = new javax.swing.JButton();
        Btnlistarcat = new javax.swing.JButton();
        Btneliminarcat = new javax.swing.JButton();
        Btnokeditar = new javax.swing.JButton();
        CbTipoCat = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Categorias");

        BtnCrearCat.setText("Registrar");

        BtnRegresar.setText("Regresar");

        jLabel2.setText("Nombre de la Categoria");

        jLabel3.setText("Tipo de Movimiento");

        Tblcatconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre Categoria", "Tipo Movimiento"
            }
        ));
        jScrollPane1.setViewportView(Tblcatconsulta);

        Btneditarcat.setText("Editar");

        Btnlistarcat.setText("Listar");

        Btneliminarcat.setText("Eliminar");

        Btnokeditar.setText("Ok");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(BtnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Btnlistarcat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCrearCat)
                        .addGap(28, 28, 28)
                        .addComponent(Btneditarcat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btnokeditar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TxtNombreCat)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 16, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(Btneliminarcat))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btneliminarcat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btnlistarcat)
                        .addComponent(BtnCrearCat)
                        .addComponent(Btneditarcat)
                        .addComponent(Btnokeditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearCat;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JButton Btneditarcat;
    private javax.swing.JButton Btneliminarcat;
    private javax.swing.JButton Btnlistarcat;
    private javax.swing.JButton Btnokeditar;
    private javax.swing.JComboBox CbTipoCat;
    private javax.swing.JTable Tblcatconsulta;
    private javax.swing.JTextField TxtNombreCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
        BtnCrearCat.addActionListener(getControl());
        BtnRegresar.addActionListener(getControl());
        Btneditarcat.addActionListener(getControl());
        Btnlistarcat.addActionListener(getControl());
        Btnokeditar.addActionListener(getControl());
    }


    public JComboBox getCbTipoCat() {
        return CbTipoCat;
    }

    public void setCbTipoCat(JComboBox jC1) {
        this.CbTipoCat = jC1;
    }


}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import presentacion.controlador.ControladorMovimientos;
import presentacion.modelo.Modelo;

/**
 *
 * @author camilo
 */
public class vistaMovimientos extends javax.swing.JPanel {

    private Modelo modelo;
    private ControladorMovimientos control;
    
    public vistaMovimientos(Modelo s) {
        modelo = s;
        initComponents();
        capturarEventos();//aca irir las acciones de cada boton
System.out.println("Aca ahora si llego");
    }
   public ControladorMovimientos getControl() {
        if(control == null){
            control = new ControladorMovimientos(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JButton getBtneditar() {
        return Btneditar;
    }

    public JButton getBtnlistar() {
        return Btnlistar;
    }

    public JButton getBtnok() {
        return Btnok;
    }


    public JScrollPane getTblmovimientos() {
        return Tblmovimientos;
    }

    public JTable getTblresultmovimientos() {
        return Tblresultmovimientos;
    }

    public JButton getBtnegreso() {
        return Btnegreso;
    }

    public JButton getBtningreso() {
        return Btningreso;
    }

    public JButton getBtntranslados() {
        return Btntranslados;
    }

    public JButton getBtnregresar() {
        return Btnregresar;
    }




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Tblmovimientos = new javax.swing.JScrollPane();
        Tblresultmovimientos = new javax.swing.JTable();
        Btnlistar = new javax.swing.JButton();
        Btneditar = new javax.swing.JButton();
        Btnok = new javax.swing.JButton();
        Btnegreso = new javax.swing.JButton();
        Btningreso = new javax.swing.JButton();
        Btntranslados = new javax.swing.JButton();
        Btnregresar = new javax.swing.JButton();

        jLabel1.setText("Movimientos");

        Tblresultmovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        Tblmovimientos.setViewportView(Tblresultmovimientos);

        Btnlistar.setText("Listar");

        Btneditar.setText("Editar");

        Btnok.setText("Ok");

        Btnegreso.setText("Egreso");

        Btningreso.setText("Ingreso");

        Btntranslados.setText("Transferencias");

        Btnregresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tblmovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btnlistar)
                                        .addGap(148, 148, 148)
                                        .addComponent(Btneditar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Btnok))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Btntranslados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Btnegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Btningreso, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(Btnregresar)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btnegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btningreso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btntranslados, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btnlistar)
                    .addComponent(Btneditar)
                    .addComponent(Btnok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tblmovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btnregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btneditar;
    private javax.swing.JButton Btnegreso;
    private javax.swing.JButton Btningreso;
    private javax.swing.JButton Btnlistar;
    private javax.swing.JButton Btnok;
    private javax.swing.JButton Btnregresar;
    private javax.swing.JButton Btntranslados;
    private javax.swing.JScrollPane Tblmovimientos;
    private javax.swing.JTable Tblresultmovimientos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
private void capturarEventos() {
       
        Btneditar.addActionListener(getControl());
        Btnlistar.addActionListener(getControl());
        Btnok.addActionListener(getControl());
        Btnegreso.addActionListener(getControl());
        Btningreso.addActionListener(getControl());
        Btnregresar.addActionListener(getControl());
        Btntranslados.addActionListener(getControl());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.vista;

import java.awt.Canvas;
import javax.swing.JButton;
import presentacion.controlador.ControladorGraficas;
import presentacion.modelo.Modelo;

/**
 *
 * @author camilo
 */
public class vistaGraficas extends javax.swing.JFrame {

    private ControladorGraficas control;
    private final Modelo modelo;
    
    public vistaGraficas(Modelo aThis) {
        modelo = aThis;
        initComponents();
        asignarEventos();
    }

    public ControladorGraficas getControl() {
        if(control == null){
            control = new ControladorGraficas(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Canvas getLienzo() {
        return lienzo;
    }

    public JButton getBtnregresar() {
        return Btnregresar;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new java.awt.Canvas();
        Btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btnregresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(Btnregresar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btnregresar)
                .addContainerGap())
        );

        lienzo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnregresar;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    private void asignarEventos() {
        Btnregresar.addActionListener(getControl());
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaGraficas;

/**
 *
 * @author camilo
 */


public class ControladorGraficas implements ActionListener{

    private final vistaGraficas ventanaGraficas;
    
    public ControladorGraficas(vistaGraficas aThis) {
        ventanaGraficas = aThis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==ventanaGraficas.getBtnregresar()) {
            ventanaGraficas.getModelo().funcionVistaRegresarGrafica();
        }           
       
    }
    
}

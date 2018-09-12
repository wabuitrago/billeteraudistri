/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaMovimientosTrans;

/**
 *
 * @author camilo
 */
public class ControladorMovimientosTra implements ActionListener{
    
private final vistaMovimientosTrans ventanaMovimientostra;

    public ControladorMovimientosTra(vistaMovimientosTrans aThis) {
        ventanaMovimientostra = aThis;
    }
    
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==ventanaMovimientostra.getBtnregistrar()) {
            ventanaMovimientostra.getModelo().funcionMovTraCrear();
        }           
        if (e.getSource()==ventanaMovimientostra.getBtnregresar()) {
               ventanaMovimientostra.getModelo().funcionVistaRegresar();
        }           
        
    }            
    
}

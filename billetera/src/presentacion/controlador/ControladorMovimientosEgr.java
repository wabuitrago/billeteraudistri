/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaMovimientosEgreso;

/**
 *
 * @author camilo
 */
public class ControladorMovimientosEgr implements ActionListener{
 
     private final vistaMovimientosEgreso ventanaMovimientosEgr;

    public ControladorMovimientosEgr(vistaMovimientosEgreso aThis) {
        ventanaMovimientosEgr = aThis;
    }
    
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==ventanaMovimientosEgr.getBtnregistrar()) {
            
        }           
        if (e.getSource()==ventanaMovimientosEgr.getBtnregresar()) {
            
        }           
        
    }    
    
    
}

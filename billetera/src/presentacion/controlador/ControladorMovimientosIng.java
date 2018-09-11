/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaMovimientosIngreso;

/**
 *
 * @author camilo
 */
public class ControladorMovimientosIng implements ActionListener{
    
    private final vistaMovimientosIngreso ventanaMovimientosIng;

    public ControladorMovimientosIng(vistaMovimientosIngreso aThis) {
        ventanaMovimientosIng = aThis;
    }
    
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==ventanaMovimientosIng.getBtnregistrar()) {
            
        }           
        if (e.getSource()==ventanaMovimientosIng.getBtnregresar()) {
            
        }           
        
    }        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaCategorias;
import presentacion.vista.vistaMovimientos;

/**
 *
 * @author camilo
 */
public class ControladorMovimientos implements ActionListener{

    private final vistaMovimientos ventanaMovimientos;

    public ControladorMovimientos(vistaMovimientos aThis) {
        ventanaMovimientos = aThis;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==ventanaMovimientos.getBtnlistar()) {
            
        }           
        if (e.getSource()==ventanaMovimientos.getBtneditar()) {
            
        }           
        if (e.getSource()==ventanaMovimientos.getBtnok()) {
            
        }           
        
    }
public void CargarCategorias(){
    ventanaMovimientos.getModelo().funcionConsultarCat();
}
    
}

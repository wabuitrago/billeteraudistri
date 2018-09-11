/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaMovimiento;
import presentacion.vista.vistaMovimiento;

/**
 *
 * @author camilo
 */
public class ControladorMovimientos implements ActionListener{

    private final vistaMovimiento ventanaMovimientos;

    public ControladorMovimientos(vistaMovimiento aThis) {
        ventanaMovimientos = aThis;

    }
  
    public void actionPerformed(ActionEvent e) {
        

       if (e.getSource()==ventanaMovimientos.getBtnegreso()) {
           ventanaMovimientos.getModelo().funcionVistaMoviEgr();
        }           
        if (e.getSource()==ventanaMovimientos.getBtningreso()) {
           ventanaMovimientos.getModelo().funcionVistaMoviIng();
        }           
        if (e.getSource()==ventanaMovimientos.getBtntransferencia()) {
            ventanaMovimientos.getModelo().funcionVistaMoviTrans();
        }           
        if (e.getSource()==ventanaMovimientos.getBtnregresar()) {
            ventanaMovimientos.getModelo().funcionVistaRegresar();
        }                           
        
    }
public void CargarCategorias(){
    ventanaMovimientos.getModelo().funcionConsultarCat();
}
    
}

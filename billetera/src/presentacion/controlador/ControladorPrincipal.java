/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vista.vistaPrincipal;


public class ControladorPrincipal implements ActionListener{

    private final vistaPrincipal ventanaPrincipal;

    public ControladorPrincipal(vistaPrincipal aThis) {
        ventanaPrincipal = aThis;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ventanaPrincipal.BtnCategorias){
            ventanaPrincipal.getModelo().funcionVistaCatego();
        }
        
        if(e.getSource()== ventanaPrincipal.BtnCuentas){
            ventanaPrincipal.getModelo().funcionVistaCuenta();
        }

        if(e.getSource()== ventanaPrincipal.BtnReportes){
            ventanaPrincipal.getModelo().funcionVistaReporte();
        }        
        
        if(e.getSource()== ventanaPrincipal.BtnMovimientos){
            ventanaPrincipal.getModelo().funcionVistaMovi();
        }         
    }

   
}


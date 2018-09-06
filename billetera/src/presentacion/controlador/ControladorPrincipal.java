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
        ventanaPrincipal.getModelo().funcionVistaCuenta();
    }
    
}


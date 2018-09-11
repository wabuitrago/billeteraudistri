/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import presentacion.vista.vistaCuentas;


public class ControladorCuentas implements ActionListener{
    
    

    private final vistaCuentas ventanaCuentas;

    public ControladorCuentas(vistaCuentas aThis) {
        ventanaCuentas = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ventanaCuentas.getBtnCrearCat()) {
            ventanaCuentas.getModelo().funcionCuentasCrear();    
        }         
        if (e.getSource()==ventanaCuentas.getBtnEditarCue()) {
            int filaeditar=ventanaCuentas.getTblCuentasConsulta().getSelectedRow();
            int filaFS =ventanaCuentas.getTblCuentasConsulta().getSelectedRowCount();

            if (filaeditar>=0 && filaFS==1) {
                ventanaCuentas.getTxtnombreCuenta().setText(String.valueOf(ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 1)));
                ventanaCuentas.getCBTipoCuenta().setSelectedItem(String.valueOf(ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 2)));
                ventanaCuentas.getBtnCrearCat().setEnabled(false);
                ventanaCuentas.getBtnRegresar().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(ventanaCuentas, "Debe seleccionar una fila o al menos una");
            }
        }                
        if (e.getSource()==ventanaCuentas.getBtnEditarCue()) {
            
            int filaeditar=ventanaCuentas.getTblCuentasConsulta().getSelectedRow();
            int filaFS =ventanaCuentas.getTblCuentasConsulta().getSelectedRowCount();
            
            if (filaeditar>=0 && filaFS==1) {
                ventanaCuentas.getBtnCrearCat().setEnabled(false);
                ventanaCuentas.getBtnRegresar().setEnabled(false);
                ventanaCuentas.getBtnlistarcat().setEnabled(false);

                int id =Integer.parseInt(String.valueOf(ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 0)));
                ventanaCuentas.getTxtnombreCuenta().setText(String.valueOf(ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 1)));
                ventanaCuentas.getModelo().seleccionarItem(ventanaCuentas.getCBTipoCuenta(), (int) ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 2));
                
            }else{
                JOptionPane.showMessageDialog(ventanaCuentas, "Debe seleccionar una fila o almenos una");
            }
        }
        if (e.getSource()==ventanaCuentas.getBtnokeditar()) {
            ventanaCuentas.getBtnCrearCat().setEnabled(true);
            ventanaCuentas.getBtnRegresar().setEnabled(true);
            ventanaCuentas.getBtnlistarcat().setEnabled(true);
            int filaeditar=ventanaCuentas.getTblCuentasConsulta().getSelectedRow();
            int id =Integer.parseInt(String.valueOf(ventanaCuentas.getTblCuentasConsulta().getValueAt(filaeditar, 0)));
            ventanaCuentas.getModelo().funcionCuentasEditar(id);
        }
        if (e.getSource()==ventanaCuentas.getBtnRegresar()) {
            ventanaCuentas.getModelo().funcionVistaRegresar();
        } 
    }
    
}
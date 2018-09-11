/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import presentacion.vista.vistaCategorias;


  
public class ControladorCategoria implements ActionListener{

    private final vistaCategorias ventanaCategoria;

    public ControladorCategoria(vistaCategorias aThis) {
        ventanaCategoria = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ventanaCategoria.getBtnCrearCat()) {
            if (ventanaCategoria.getTxtNombreCat().getText().length()==0) {
                JOptionPane.showMessageDialog(ventanaCategoria, "ingrese un nombre para la categoria");
            }else{
            ventanaCategoria.getModelo().funcionCatCrear();        
            }
            
        }
        if (e.getSource()==ventanaCategoria.getBtnlistarcat()) {
            ventanaCategoria.getModelo().funcionConsultarCat();    
        }        
        if (e.getSource()==ventanaCategoria.getBtneditarcat()) {
            int filaeditar=ventanaCategoria.getTblcatconsulta().getSelectedRow();
            int filaFS =ventanaCategoria.getTblcatconsulta().getSelectedRowCount();

            if (filaeditar>=0 && filaFS==1) {
                ventanaCategoria.getTxtNombreCat().setText(String.valueOf(ventanaCategoria.getTblcatconsulta().getValueAt(filaeditar, 1)));
                ventanaCategoria.getModelo().seleccionarItem(ventanaCategoria.getCbTipoCat(), (int) ventanaCategoria.getTblcatconsulta().getValueAt(filaeditar, 2));
                //ventanaCategoria.getCbTipoCat().setSelectedItem(String.valueOf(ventanaCategoria.getTblcatconsulta().getValueAt(filaeditar, 2)));
                ventanaCategoria.getBtnCrearCat().setEnabled(false);
                ventanaCategoria.getBtnRegresar().setEnabled(false);
                ventanaCategoria.getBtnlistarcat().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(ventanaCategoria, "Debe seleccionar una fila o almenos una");
            }
        }                
        if (e.getSource()==ventanaCategoria.getBtnokeditar()) {
            ventanaCategoria.getBtnCrearCat().setEnabled(true);
            ventanaCategoria.getBtnRegresar().setEnabled(true);
            ventanaCategoria.getBtnlistarcat().setEnabled(true);
            int filaeditar=ventanaCategoria.getTblcatconsulta().getSelectedRow();
            int id =Integer.parseInt(String.valueOf(ventanaCategoria.getTblcatconsulta().getValueAt(filaeditar, 0)));
            ventanaCategoria.getModelo().funcionCatEditar(id);
        }
        if (e.getSource()==ventanaCategoria.getBtnRegresar()) {
            ventanaCategoria.getModelo().funcionVistaRegresar();
        }             
    }
    
}

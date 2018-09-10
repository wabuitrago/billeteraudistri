
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import presentacion.vista.vistaReportes;


/**
 *
 * @author camilo
 */
public class ControladorReportes implements ActionListener{
    
    private final vistaReportes ventanaReportes;

    public ControladorReportes(vistaReportes aThis) {
        ventanaReportes = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ventanaReportes.getBtnGenerarReport()) {
            if (ventanaReportes.getRbnFechas().isSelected()) {
                ventanaReportes.getModelo().funcionReportfechas();    
            }else if (ventanaReportes.getRbnCategorias().isSelected()) {
                ventanaReportes.getModelo().funcionReportCat();    
            }else if (ventanaReportes.getRbningvsegreso().isSelected()) {
                ventanaReportes.getModelo().funcionReportIngVSEgre();    
            }
        }
         
        if (e.getSource()==ventanaReportes.getBtngraficar()) {
            int tipoconsulta=1;
            if (ventanaReportes.getRbnFechas().isSelected()) {
                tipoconsulta=1;
            }else if (ventanaReportes.getRbnCategorias().isSelected()) {
                tipoconsulta=2;
            }else if (ventanaReportes.getRbningvsegreso().isSelected()) {
                tipoconsulta=3;
            }            
            ventanaReportes.getModelo().ReportGraficar(tipoconsulta);
        }
        if (e.getSource()==ventanaReportes.getBtnregresar()) {
        ventanaReportes.getModelo().funcionVistaRegresar();
        }
        
        
        
    }    
    
        
    }
    
    


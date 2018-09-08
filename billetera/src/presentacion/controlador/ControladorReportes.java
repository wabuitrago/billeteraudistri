
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
        ventanaReportes.getModelo().funcionReportfechas();
    }    
    
        
    }
    
    


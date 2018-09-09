/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.logBilletera;
import Sistema.DTO.movimiento;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author William
 */
public class pruebaCon {
    public static void main(String[] args) {
        
        //consulta id categoria
        //categoria categoBuscar = catDao.read("3");
        //System.out.println(categoBuscar.getNombreCategoria());
        Logica.logBilletera billetera = new logBilletera();
        List<logBilletera> billeteraCuenta = null;
        /*
        billeteraCuenta = billetera.consultarMovimientos(3);
        
        DefaultPieDataset data = new DefaultPieDataset();
        Iterator<logBilletera> it = billeteraCuenta.iterator();
        System.out.println("Ingresos vs Gastos");
        while(it.hasNext()){
            //ya que es un array nos toca optener los valores de  cada registro
            logBilletera movimiento = it.next();
            System.out.println("Valor del campo" + movimiento.getNombreCuenta());
            data.setValue(movimiento.getNombreTipoMovimiento(), movimiento.getTotal());
        }*/
        
        billeteraCuenta = billetera.consultarMovimientos(2);
        
        DefaultPieDataset data = new DefaultPieDataset();
        Iterator<logBilletera> it = billeteraCuenta.iterator();
        System.out.println("Categorias");
        while(it.hasNext()){
            //ya que es un array nos toca optener los valores de  cada registro
            logBilletera movimiento = it.next();
            data.setValue(movimiento.getNombreCategoria(), movimiento.getTotal());
        }
        // Fuente de Datos
        /*
        data.setValue("C", 42);
        data.setValue("Java", 45);
        data.setValue("Python", 15);
 */
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Ejemplo Rapido de Grafico en un ChartFrame", 
         data, 
         true, 
         true, 
         false);
 
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}

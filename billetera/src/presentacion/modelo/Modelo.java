/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

//Espacio para los imports
import presentacion.vista.vistaPrincipal;
import presentacion.vista.vistaCategorias;
import Logica.logBilletera;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.print.DocFlavor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import presentacion.vista.vistaReportes;

public class Modelo {

//Asignacion de variables
    //private Billetera sistema;
    private vistaPrincipal vistaPrincipal;
    private vistaCategorias vistaCategoria;
    private vistaReportes vistaReportes;
    private logBilletera Logica;

//metodo de la vista principal
    public vistaPrincipal getVistaPrincipal() {
        if(vistaPrincipal == null){
            vistaPrincipal = new vistaPrincipal(this);
        }
        return vistaPrincipal;
    }
     public vistaCategorias getVistaCategorias() {
         if(vistaCategoria == null){
            vistaCategoria = new vistaCategorias(this);
        }
        return vistaCategoria;
    }
     public vistaReportes getVistaReportes(){
         if(vistaReportes == null){
            vistaReportes = new vistaReportes(this);
        }
        return vistaReportes;         
     }
        public logBilletera getLogica() {
        if(Logica == null){
            Logica = new logBilletera();
        }
        return Logica;
    }      
//especificacion de la venta al iniciar    
    public void iniciar() {
        //getVistaPrincipal().setSize(300, 300);
        getVistaPrincipal().setVisible(true);
        //getVistaCategorias().setVisible(false);
/// y demas especificaciones visuales de las ventana
    }

//funciones para los botones de la ventana principal para llevarlas a las demas vistas
//las coloco aunque estoy verificando porque no estoy seguro si lo maneja
//el modelo o el controlador, si algo cualquier cosa la modifcamos

	//para la vista cuentas
	public void funcionVistaCuenta(){
	//Muchas cosas para crear la vista 
            System.out.println("para cuenta");
    }

	//para la vista movimientos
	public void funcionVistaMovi(){
	//Muchas cosas para crear la vista        
    }
	
	//para la vista Categoria
	public void funcionVistaCatego(){
	//Muchas cosas para crear la vista        
           getVistaCategorias().setVisible(true);
           getVistaPrincipal().setVisible(false);  
    }

	//para la vista Reportes
	public void funcionVistaReporte(){
	//Muchas cosas para crear la vista        
           getVistaReportes().setVisible(true);
           getVistaPrincipal().setVisible(false);          
        }	

        public void funcionVistaRegresar(){
	//Muchas cosas para crear la vista        
           getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(true);          
           getVistaCategorias().setVisible(false);                     
        }	        

///funciones para la vista de Cuentas    

	//Crear
	public void funcionCuentasCrear(){
	//Muchas cosas para crear la vista        
    }

	//Editar
    public void funcionCuentasEditar(){
	//Muchas cosas para crear la vista        
    }	
	
	//Consultar
    public void funcionCuentasConsultar(){
	//Muchas cosas para crear la vista        
    }		
        
	//Visualizar
    public void funcionCuentasVisualizar(){
	//Muchas cosas para crear la vista        
    }		

			
    public void funcionCatCrear(){
	String nombreCategoria, tipo;
        int numtipo;
        Boolean resultado;
        
        nombreCategoria=getVistaCategorias().getTxtNombreCat().getText();
        tipo=getVistaCategorias().getCbTipoCat().getSelectedItem().toString();
        if (tipo.equals("INGRESO")) {
            numtipo=1;
        }else{
            numtipo=2;
        }
        getLogica().setNombreCategoria(nombreCategoria);
        getLogica().setIdTipoMovimiento(numtipo);
        
        resultado=getLogica().crearCategoria();
        
        if(resultado)
            //System.out.println("Crear categoria: "+nombreCategoria+" - "+numtipo);
            JOptionPane.showMessageDialog(vistaCategoria, "Categoria creada exitosamente");
        else
            JOptionPane.showMessageDialog(vistaCategoria, "Error al crear categoria: "+nombreCategoria+" - "+numtipo);

//llamo a la funcion de consulta de las categorias
    List<logBilletera> billeteraConsultarCat = new logBilletera().consultarCategorias();
//Llamo la funcion para llenar la tabla de categorias
        ConsultaCat(vistaCategoria.getTblcatconsulta(),billeteraConsultarCat);

    }
    
    public void funcionCatEditar(int id){
	String nombreCategoria, tipo;
        int numtipo;
        Boolean resultado;
        
        nombreCategoria=getVistaCategorias().getTxtNombreCat().getText();
        tipo=getVistaCategorias().getCbTipoCat().getSelectedItem().toString();
        
        if (tipo.equals("INGRESO")) {
            numtipo=1;
        }else{
            numtipo=2;
        }
        
        getLogica().setIdCategoria(id);
        getLogica().setNombreCategoria(nombreCategoria);
        getLogica().setIdTipoMovimiento(numtipo);
        
        resultado=getLogica().actualizarCategoria();
        
        if(resultado){
            JOptionPane.showMessageDialog(vistaCategoria, "Categoria editada exitosamente");
            getVistaCategorias().getTxtNombreCat().setText("");
        }else{
            JOptionPane.showMessageDialog(vistaCategoria, "Error al editar la categoria: "+nombreCategoria+" - "+numtipo);
        }
//llamo a la funcion de consulta de las categorias
    List<logBilletera> billeteraConsultarCat = new logBilletera().consultarCategorias();
//Llamo la funcion para llenar la tabla de categorias
        ConsultaCat(vistaCategoria.getTblcatconsulta(),billeteraConsultarCat);
        
    }
    
    public void funcionConsultarCat(){
//llamo a la funcion de consulta de las categorias
        List<logBilletera> billeteraConsultarCat = new logBilletera().consultarCategorias();
        ConsultaCat(vistaCategoria.getTblcatconsulta(),billeteraConsultarCat);
    }
            
    
    public void funcionReportfechas(){
	//String FechaInicio, FechaFin;
        Date date1, date2;

//conversion de fechas al modelo de sql   
        try {
            date1 = getVistaReportes().getJdcfechainicial().getDate();
            java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
            date2 = getVistaReportes().getJdcfechafinal().getDate();
            java.sql.Date FechaFin = new java.sql.Date(date2.getTime());
            
            System.out.println("fecha1: "+FechaInicio+" fecha2: "+FechaFin);        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaReportes, "Debe indicar las fechas de consulta");
        }
        
//Aca llamo a la funcion de Logica de la consuta 
        List<logBilletera> billeteraConsultar = new logBilletera().consultarMovimientos(1);
//Llamo la funcion para llenar la tabla de consulta
        llenarTabla(vistaReportes.getTblresultadoreport(), billeteraConsultar);
    }
    
    public void funcionReportCat(){
        
    }

    public void funcionReportIngVSEgre(){
        
    }    
    
    public void llenarTabla(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Fecha");
        modelot.addColumn("Categoria");
        modelot.addColumn("Cuenta");
        modelot.addColumn("Tipo Movimiento");
        
        System.out.println("resultado lista movimientos: "+ resultado.size());        
        
        Object[] columna = new Object[4];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 
                
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("resultado lista movimientos: "+ resultado.get(i).getNombreCategoria());        
            columna[0] = resultado.get(i).getFechaIniMovimiento();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCategoria();
            columna[2] = resultado.get(i).getNombreCuenta();
            columna[3] = resultado.get(i).getNombreTipoMovimiento();
            modelot.addRow(columna);
        }
    }
    
    public void ConsultaCat(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Id");
        modelot.addColumn("Nombre Categoria");
        modelot.addColumn("Tipo Movimiento");
        
        
        Object[] columna = new Object[3];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = resultado.get(i).getIdCuenta();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCuenta();//aca debe ir el get del resulado
            columna[2] = resultado.get(i).getNombreTipoCuenta();//aca debe ir el get del resulado
            
            modelot.addRow(columna);
        }

    }    
    
    public void ReportGraficar(int tipoconsulta){
        Logica.logBilletera billetera = new logBilletera();
        List<logBilletera> billeteraCuenta = null;
        
        
        switch (tipoconsulta) {
            case 1:
                billeteraCuenta = billetera.consultarMovimientos(1);
                DefaultPieDataset data = new DefaultPieDataset();
                Iterator<logBilletera> it = billeteraCuenta.iterator();                
                while(it.hasNext()){
                    //ya que es un array nos toca optener los valores de  cada registro
                    logBilletera movimiento = it.next();
                    data.setValue(movimiento.getNombreCategoria(), movimiento.getTotal());
                }       // Creando el Grafico
                JFreeChart chartF = ChartFactory.createPieChart(
                        "Movimientos por fechas",
                        data,
                        true,
                        true,
                        false);// Mostrar Grafico
                ChartFrame frameFecha = new ChartFrame("JFreeChart", chartF);
                frameFecha.pack();
                frameFecha.setVisible(true);
                break;
            case 2:
                billeteraCuenta = billetera.consultarMovimientos(2);                
                DefaultPieDataset data2 = new DefaultPieDataset();
                Iterator<logBilletera> it2 = billeteraCuenta.iterator();                
                while(it2.hasNext()){
                    //ya que es un array nos toca optener los valores de  cada registro
                    logBilletera movimiento = it2.next();
                    data2.setValue(movimiento.getNombreCategoria(), movimiento.getTotal());
                }       // Creando el Grafico
                JFreeChart chartCat = ChartFactory.createPieChart(
                        "Movimientos por Categorias",
                        data2,
                        true,
                        true,
                        false);// Mostrar Grafico
                ChartFrame frameCat = new ChartFrame("JFreeChart", chartCat);
                frameCat.pack();
                frameCat.setVisible(true);
                break;
            default:
                System.out.println("Grafica para ingreso vs egresos");
                break;
        }


        
    }       
	
    }

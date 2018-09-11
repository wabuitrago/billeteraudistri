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
import presentacion.vista.vistaCuentas;



 import java.io.DataOutputStream;
 import java.io.File;
 import java.io.FileOutputStream;
 import java.util.List;
import javax.swing.JComboBox;
 import javax.swing.JTable;
import presentacion.vista.vistaMovimientos;
 //import jxl.Workbook;
 //import jxl.write.Label;
 //import jxl.write.WritableSheet;
 //import jxl.write.WritableWorkbook;

public class Modelo {

//Asignacion de variables
    //private Billetera sistema;
    private vistaPrincipal vistaPrincipal;
    private vistaCategorias vistaCategoria;
    private vistaReportes vistaReportes;
    private logBilletera Logica;
    private vistaCuentas vistaCuentas;
    private vistaMovimientos vistaMovimientos;

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
     public vistaCuentas getVistaCuentas(){
         if(vistaCuentas == null){
            vistaCuentas = new vistaCuentas(this);
        }
        return vistaCuentas;
     }   
     public vistaMovimientos getVistaMovimientos(){
         if(vistaMovimientos == null){
            vistaMovimientos = new vistaMovimientos(this);
        }
        return vistaMovimientos;         
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
           getVistaCuentas().setSize(600,400);           
           getVistaCuentas().setVisible(true);           
           getVistaPrincipal().setVisible(false);
           List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
           ConsultaCue(vistaCuentas.getTblCuentasConsulta(),billeteraCuentas);
           List<logBilletera> billeteraTipoCuentas = new logBilletera().consultarTipoCuentas();
           cargarTipoCuenta(vistaCuentas.getCBTipoCuenta(), billeteraTipoCuentas);
    }

	//para la vista movimientos
	public void funcionVistaMovi(){
           getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(false);          
           getVistaMovimientos().setVisible(true);          
           getVistaCategorias().setVisible(false);        
    }
	
	//para la vista Categoria
	public void funcionVistaCatego(){
	//Muchas cosas para crear la vista        
           getVistaCategorias().setVisible(true);
           getVistaPrincipal().setVisible(false);  
           getVistaMovimientos().setVisible(false);          
           getVistaReportes().setVisible(false);
           cargarTipoMovimiento(vistaCategoria.getCbTipoCat());
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
           getVistaReportes().setVisible(false);
           getVistaCuentas().setVisible(false);
        }	        

///funciones para la vista de Cuentas    

	//Crear
	public void funcionCuentasCrear(){
	String nombreCuenta;
        int numtipo;//saldoCuenta;
        Boolean resultado;
        
        nombreCuenta=getVistaCuentas().getTxtnombreCuenta().getText();
        //saldoCuenta=Integer.parseInt(getVistaCuentas().getTxtsaldoInicial().getText());
        Item tipoCuenta= (Item) getVistaCuentas().getCBTipoCuenta().getSelectedItem();
        numtipo = tipoCuenta.getId();
        
        getLogica().setNombreCuenta(nombreCuenta);
        //getLogica().setTotal(saldoCuenta);
        getLogica().setIdTipoCuenta(numtipo);
        
        resultado=getLogica().crearCuenta();
        
        if(resultado){
            //System.out.println("Crear categoria: "+nombreCategoria+" - "+numtipo);
            JOptionPane.showMessageDialog(vistaCuentas, "Cuenta creada exitosamente");
        }else{
            JOptionPane.showMessageDialog(vistaCuentas, "Error al crear cuenta: "+nombreCuenta+" - "+numtipo);
        }    
        List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
        ConsultaCue(vistaCuentas.getTblCuentasConsulta(),billeteraCuentas);
    }       
    
    public void funcionCuentasEditar(int id){
	String nombreCuenta;
        int numtipo;//saldoCuenta;
        Boolean resultado;
        
        nombreCuenta=getVistaCuentas().getTxtnombreCuenta().getText();
        //saldoCuenta=Integer.parseInt(getVistaCuentas().getTxtsaldoInicial().getText());
        Item tipoCuenta= (Item) getVistaCuentas().getCBTipoCuenta().getSelectedItem();
        numtipo = tipoCuenta.getId();
        
        getLogica().setIdCuenta(id);
        getLogica().setNombreCuenta(nombreCuenta);
        //getLogica().setTotal(saldoCuenta);
        getLogica().setIdTipoCuenta(numtipo);
        
        resultado=getLogica().crearCuenta();
        
        if(resultado){
            JOptionPane.showMessageDialog(vistaCuentas, "Cuenta editada exitosamente");
            getVistaCuentas().getTxtnombreCuenta().setText("");
        }else{
            JOptionPane.showMessageDialog(vistaCuentas, "Error al editar cuenta: "+nombreCuenta+" - "+numtipo);
        }
    List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
    ConsultaCue(vistaCuentas.getTblCuentasConsulta(),billeteraCuentas);
    } 	
	
	//Consultar
    public void funcionCuentasConsultar(){
	List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
        ConsultaCue(vistaCuentas.getTblCuentasConsulta(),billeteraCuentas);        
    }		
        
	//Visualizar
    public void funcionCuentasVisualizar(){
	//Muchas cosas para crear la vista        
    }		

			
    public void funcionCatCrear(){
	String nombreCategoria;
        int numtipo;
        Boolean resultado;
        
        
        nombreCategoria=getVistaCategorias().getTxtNombreCat().getText();
        Item tipo = (Item) getVistaCategorias().getCbTipoCat().getSelectedItem();
        numtipo = tipo.getId();
        /*if (tipo.equals("INGRESO")) {
            numtipo=1;
        }else{
            numtipo=2;
        }*/
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
	String nombreCategoria;
        int numtipo;
        Boolean resultado;
        
        nombreCategoria=getVistaCategorias().getTxtNombreCat().getText();
        Item tipo = (Item) getVistaCategorias().getCbTipoCat().getSelectedItem();
        numtipo = tipo.getId();
        
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
        Logica.logBilletera billetera = new logBilletera();
//conversion de fechas al modelo de sql   
        try {
//Aca llamo a la funcion de Logica de la consuta 
            date1 = getVistaReportes().getJdcfechainicial().getDate();
            java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
            date2 = getVistaReportes().getJdcfechafinal().getDate();
            java.sql.Date FechaFin = new java.sql.Date(date2.getTime());
            
        billetera.setFechaIniMovimiento(FechaInicio);
        billetera.setFechaFinMovimiento(FechaFin);        
    List<logBilletera> billeteraConsultar = billetera.consultarMovimientos(1);
        
//Llamo la funcion para llenar la tabla de consulta
        llenarTabla(vistaReportes.getTblresultadoreport(), billeteraConsultar);            
                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaReportes, "Debe indicar las fechas de consulta");
        }
        

    }
    
    public void funcionReportCat(){
    Logica.logBilletera billetera = new logBilletera();        
    
    if(getVistaReportes().getJdcfechainicial().getDate() != null && getVistaReportes().getJdcfechafinal().getDate() != null){
        Date date1, date2;
        date1 = getVistaReportes().getJdcfechainicial().getDate();
        java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
        date2 = getVistaReportes().getJdcfechafinal().getDate();
        java.sql.Date FechaFin = new java.sql.Date(date2.getTime());
        billetera.setFechaIniMovimiento(FechaInicio);
        billetera.setFechaFinMovimiento(FechaFin); 
    }
        
    List<logBilletera> billeteraConsultar = billetera.consultarMovimientos(2);        
    ConsultaCat(vistaReportes.getTblresultadoreport(), billeteraConsultar);            
    }

    public void funcionReportIngVSEgre(){
    Logica.logBilletera billetera = new logBilletera();                
    
    if(getVistaReportes().getJdcfechainicial().getDate() != null && getVistaReportes().getJdcfechafinal().getDate() != null){
        Date date1, date2;
        date1 = getVistaReportes().getJdcfechainicial().getDate();
        java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
        date2 = getVistaReportes().getJdcfechafinal().getDate();
        java.sql.Date FechaFin = new java.sql.Date(date2.getTime());
        billetera.setFechaIniMovimiento(FechaInicio);
        billetera.setFechaFinMovimiento(FechaFin); 
    }        
        
    List<logBilletera> billeteraConsultar = billetera.consultarMovimientos(3);        
    ConsultaInVSEg(vistaReportes.getTblresultadoreport(), billeteraConsultar);                    
    }    
    
    public void llenarTabla(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Fecha");
        modelot.addColumn("Categoria");
        modelot.addColumn("Cuenta");
        modelot.addColumn("Tipo Movimiento");
        modelot.addColumn("Total");
        
        System.out.println("resultado lista movimientos: "+ resultado.size());        
        
        Object[] columna = new Object[5];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 
                
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("resultado lista movimientos: "+ resultado.get(i).getNombreCategoria());        
            columna[0] = resultado.get(i).getFechaIniMovimiento();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCategoria();
            columna[2] = resultado.get(i).getNombreCuenta();
            columna[3] = resultado.get(i).getNombreTipoMovimiento();
            columna[4] = resultado.get(i).getTotal();
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

    public void ConsultaCue(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Id Cuenta");
        modelot.addColumn("Tipo Cuenta");
        modelot.addColumn("Nombre Cuenta");
        modelot.addColumn("Saldo");
        
        Object[] columna = new Object[4];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = resultado.get(i).getIdCuenta();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreTipoCuenta();//aca debe ir el get del resulado
            columna[2] = resultado.get(i).getNombreCuenta();
            columna[3] = resultado.get(i).getTotal();
            
            modelot.addRow(columna);
        }

    }
    
    public void ConsultaInVSEg (JTable tablaR, List<logBilletera> resultado) {
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Tipo movimiento");
        modelot.addColumn("Total");

        Object[] columna = new Object[2];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 
                
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("resultado lista movimientos: "+ resultado.get(i).getNombreCategoria());        
            columna[0] = resultado.get(i).getNombreTipoMovimiento();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getTotal();
            modelot.addRow(columna);
        }        
    }
    
    public void ReportGraficar(int tipoconsulta){
        Logica.logBilletera billetera = new logBilletera();
        List<logBilletera> billeteraCuenta = null;
        
        
        switch (tipoconsulta) {
            case 1:
                //String FechaInicio, FechaFin;
                Date date1, date2;
                Logica.logBilletera billeterafech = new logBilletera();
        //conversion de fechas al modelo de sql   
                try {
        //Aca llamo a la funcion de Logica de la consuta 
                    date1 = getVistaReportes().getJdcfechainicial().getDate();
                    java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
                    date2 = getVistaReportes().getJdcfechafinal().getDate();
                    java.sql.Date FechaFin = new java.sql.Date(date2.getTime());

                billeterafech.setFechaIniMovimiento(FechaInicio);
                billeterafech.setFechaFinMovimiento(FechaFin);        


                        billeteraCuenta = billeterafech.consultarMovimientos(1);
                        DefaultPieDataset dataf= new DefaultPieDataset();
                        Iterator<logBilletera> it = billeteraCuenta.iterator();                
                        while(it.hasNext()){
                            //ya que es un array nos toca optener los valores de  cada registro
                            logBilletera movimiento = it.next();
                            //dataf.setValue(movimiento.getFechaIniMovimiento(), movimiento.getNombreCategoria(), movimiento.getNombreCuenta(), movimiento.getNombreTipoMovimiento());
                            dataf.setValue(movimiento.getFechaIniMovimiento(), movimiento.getTotal());
                        }       // Creando el Grafico
                        JFreeChart chartF = ChartFactory.createPieChart(
                                "Movimientos por fechas",
                                dataf,
                                true,
                                true,
                                false);// Mostrar Grafico
                        ChartFrame frameFecha = new ChartFrame("JFreeChart", chartF);
                        frameFecha.pack();
                        frameFecha.setVisible(true);


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe indicar las fechas de consulta");
                }

                break;
            case 2:
                Logica.logBilletera billeteracat = new logBilletera();        

                if(getVistaReportes().getJdcfechainicial().getDate() != null && getVistaReportes().getJdcfechafinal().getDate() != null){
                    Date datec1, datec2;
                    datec1 = getVistaReportes().getJdcfechainicial().getDate();
                    java.sql.Date FechaInicio = new java.sql.Date(datec1.getTime());
                    datec2 = getVistaReportes().getJdcfechafinal().getDate();
                    java.sql.Date FechaFin = new java.sql.Date(datec2.getTime());
                    billeteracat.setFechaIniMovimiento(FechaInicio);
                    billeteracat.setFechaFinMovimiento(FechaFin); 
                }                
                billeteraCuenta = billeteracat.consultarMovimientos(2);                
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
                Logica.logBilletera billeteraIE = new logBilletera();                

                if(getVistaReportes().getJdcfechainicial().getDate() != null && getVistaReportes().getJdcfechafinal().getDate() != null){
                    Date dateie1, dateie2;
                    dateie1 = getVistaReportes().getJdcfechainicial().getDate();
                    java.sql.Date FechaInicio = new java.sql.Date(dateie1.getTime());
                    dateie2 = getVistaReportes().getJdcfechafinal().getDate();
                    java.sql.Date FechaFin = new java.sql.Date(dateie2.getTime());
                    billeteraIE.setFechaIniMovimiento(FechaInicio);
                    billeteraIE.setFechaFinMovimiento(FechaFin); 
                }        
                billeteraCuenta = billeteraIE.consultarMovimientos(3);                
                DefaultPieDataset data3 = new DefaultPieDataset();
                Iterator<logBilletera> it3 = billeteraCuenta.iterator();                
                while(it3.hasNext()){
                    //ya que es un array nos toca optener los valores de  cada registro
                    logBilletera movimiento = it3.next();
                    data3.setValue(movimiento.getNombreTipoMovimiento(), movimiento.getTotal());
                }       // Creando el Grafico
                JFreeChart chartIE = ChartFactory.createPieChart(
                        "Movimientos por Ingreso vs Egresos",
                        data3,
                        true,
                        true,
                        false);// Mostrar Grafico
                ChartFrame frameIE = new ChartFrame("JFreeChart", chartIE);
                frameIE.pack();
                frameIE.setVisible(true);
                break;
        }


        
    }       

    private void cargarTipoMovimiento(JComboBox jC1) {
        jC1.removeAllItems();
        jC1.addItem(new Item(1, "Ingreso" ) );
        jC1.addItem( new Item(2, "Egreso" ) );
    }

    

    private void cargarTipoCuenta(JComboBox cbTipoCuenta, List<logBilletera> billeteraTipoCuentas) {
        int numRegistros= billeteraTipoCuentas.size();//hasta el size de la lista resultado 
        cbTipoCuenta.removeAllItems();        
        for (int i = 0; i < numRegistros; i++) {
            cbTipoCuenta.addItem(new Item(billeteraTipoCuentas.get(i).getIdTipoCuenta(), billeteraTipoCuentas.get(i).getNombreTipoCuenta()));
        }
    }

    class Item
    {
        private int id;
        private String description;

        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public int getId()
        {
            return id;
        }

        public String getDescription()
        {
            return description;
        }

        public String toString()
        {
            return description;
        }
    }



}

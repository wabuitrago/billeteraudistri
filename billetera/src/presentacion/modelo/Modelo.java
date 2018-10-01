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
import static com.sun.webkit.graphics.WCImage.getImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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
import java.nio.DoubleBuffer;
 import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
 import javax.swing.JTable;
import presentacion.vista.vistaGraficas;
import presentacion.vista.vistaMovimiento;
import presentacion.vista.vistaMovimientosEgreso;
import presentacion.vista.vistaMovimientosIngreso;
import presentacion.vista.vistaMovimientosTrans;
 //import jxl.Workbook;
 //import jxl.write.Label;
 //import jxl.write.WritableSheet;
 //import jxl.write.WritableWorkbook;
    
    
public class Modelo implements Runnable{

//Asignacion de variables
    //private Billetera sistema;
    private vistaPrincipal vistaPrincipal;
    private vistaCategorias vistaCategoria;
    private vistaReportes vistaReportes;
    private logBilletera Logica;
    private vistaCuentas vistaCuentas;
    private vistaMovimiento vistaMovimiento;
    private vistaMovimientosIngreso vistaMovimientosIng;
    private vistaMovimientosEgreso vistaMovimientosEgr;
    private vistaMovimientosTrans vistaMovimientosTrans;
    private vistaGraficas vistaGraficas;
    private Thread hiloDibujo;
    private boolean animando;
    private BufferedImage dobleBuffer;

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
     public vistaMovimiento getVistaMovimiento(){
         if(vistaMovimiento == null){
            vistaMovimiento = new vistaMovimiento(this);
        }
        return vistaMovimiento;         
     }         
     
     public vistaMovimientosEgreso getVistaMovimientosEgreso(){
         if(vistaMovimientosEgr == null){
            vistaMovimientosEgr = new vistaMovimientosEgreso(this);
        }
        return vistaMovimientosEgr;         
     }              
     public vistaMovimientosIngreso getVistaMovimientosIngreso(){
         if(vistaMovimientosIng == null){
            vistaMovimientosIng = new vistaMovimientosIngreso(this);
        }
        return vistaMovimientosIng;         
     }              
     public vistaMovimientosTrans getVistaMovimientosTrans(){
         if(vistaMovimientosTrans == null){
            vistaMovimientosTrans = new vistaMovimientosTrans(this);
        }
        return vistaMovimientosTrans;         
     }              
     public vistaGraficas getVistGraficas(){
            if(vistaGraficas == null){
            vistaGraficas = new vistaGraficas(this);
        }
        return vistaGraficas;
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
           getVistaMovimiento().setVisible(true);      
           funcionconsulmovimi();
          /*  getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(false);          
           getVistaCategorias().setVisible(false);        */
    }
	public void funcionVistaMoviIng(){
           getVistaMovimientosIngreso().setVisible(true);          
           getVistaMovimiento().setVisible(false);
            
           List<logBilletera> billeteraCuentasIng = new logBilletera().consultarCuentas();
           cargarCuenta(vistaMovimientosIng.getCbTipoCuenta(),billeteraCuentasIng);
           
            logBilletera billeteraCategoriasIng = new logBilletera();
            billeteraCategoriasIng.setIdTipoMovimiento(1);
            List<logBilletera> billeteraCategoriaIng = billeteraCategoriasIng.consultarCategorias();
           cargarCategoria(vistaMovimientosIng.getCbTipoCat1(),billeteraCategoriaIng);
           
        }        
	public void funcionVistaMoviEgr(){
           getVistaMovimientosEgreso().setVisible(true);
           getVistaMovimiento().setVisible(false);
           List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
           cargarCuenta(vistaMovimientosEgr.getCbTipoCuenta(),billeteraCuentas);
           
            logBilletera billeteraCategorias = new logBilletera();
            billeteraCategorias.setIdTipoMovimiento(2);
            List<logBilletera> billeteraCategoria = billeteraCategorias.consultarCategorias();
           cargarCategoria(vistaMovimientosEgr.getCbTipocat(),billeteraCategoria);
          /*  getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(false);          
           getVistaCategorias().setVisible(false);        */
        }	
	public void funcionVistaMoviTrans(){
           getVistaMovimientosTrans().setVisible(true);          
           getVistaMovimiento().setVisible(false);
           List<logBilletera> billeteraCuentas = new logBilletera().consultarCuentas();
           cargarCuenta(vistaMovimientosTrans.getCbCuentaDes(),billeteraCuentas);
           cargarCuenta(vistaMovimientosTrans.getCbCuentaOri(),billeteraCuentas);
           /*  getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(false);          
           getVistaCategorias().setVisible(false);        */
        }        
	//para la vista Categoria
	public void funcionVistaCatego(){
	//Muchas cosas para crear la vista        
           getVistaCategorias().setVisible(true);
           getVistaPrincipal().setVisible(false);  
           getVistaMovimiento().setVisible(false);          
           getVistaReportes().setVisible(false);
           cargarTipoMovimiento(vistaCategoria.getCbTipoCat());
    }
        
        

        
	//para la vista Reportes
	public void funcionVistaReporte(){
	//Muchas cosas para crear la vista        
           getVistaReportes().setVisible(true);
           getVistaPrincipal().setVisible(false);          
       
        }	
        
        public void funcionVistaGraficas(){
        getVistGraficas().setVisible(true);
        iniciarAnimacion();
//        GraficasReporte();
        }

        public void funcionVistaRegresar(){
	//Muchas cosas para crear la vista        
           getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(true);          
           getVistaCategorias().setVisible(false);                     
           getVistaReportes().setVisible(false);
           getVistaCuentas().setVisible(false);
           getVistaMovimiento().setVisible(false);
           getVistaMovimientosEgreso().setVisible(false);
           getVistaMovimientosIngreso().setVisible(false);
           getVistaMovimientosTrans().setVisible(false);
           getVistGraficas().setVisible(false);
           animando=false;
        }	        
        public void funcionVistaRegresarGrafica(){
	//Muchas cosas para crear la vista        
           getVistaReportes().setVisible(false);
           getVistaPrincipal().setVisible(false);          
           getVistaCategorias().setVisible(false);                     
           getVistaReportes().setVisible(true);
           getVistaCuentas().setVisible(false);
           getVistaMovimiento().setVisible(false);
           getVistaMovimientosEgreso().setVisible(false);
           getVistaMovimientosIngreso().setVisible(false);
           getVistaMovimientosTrans().setVisible(false);
           getVistGraficas().setVisible(false);
           animando=false;
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
        
        resultado=getLogica().actualizarCuenta();
        
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
            
    public void funcionMovEgreCrear(){
    Logica.logBilletera Crearmov = new logBilletera();        
    String notasmovimiento;
    int valormov;
    if(getVistaMovimientosEgreso().getJdcfechamovimiento().getDate() != null ){
        Date date1;
        date1 = getVistaMovimientosEgreso().getJdcfechamovimiento().getDate();
        java.sql.Date FechaMov = new java.sql.Date(date1.getTime());

        Crearmov.setFechaIniMovimiento(FechaMov);
        
        notasmovimiento=getVistaMovimientosEgreso().getTxtnotasmovimiento().getText();        
        Crearmov.setNotaMovimiento(notasmovimiento);
        System.out.println(getVistaMovimientosEgreso().getTxtvalor().getText());
        valormov= Integer.valueOf(getVistaMovimientosEgreso().getTxtvalor().getText());
        Item tipo = (Item) getVistaMovimientosEgreso().getCbTipoCuenta().getSelectedItem();
        int numtipo = tipo.getId();        
        Crearmov.setIdCuenta(numtipo);
        Crearmov.setTotal(valormov);
        Item tipoCat = (Item) getVistaMovimientosEgreso().getCbTipocat().getSelectedItem();
        int numtipocat = tipoCat.getId();        
        Crearmov.setIdCategoria(numtipocat);
        boolean resultEgre =Crearmov.crearMovimiento();
        
        if (resultEgre) {
            JOptionPane.showMessageDialog(vistaMovimientosEgr, "Se creo el movimiento");
        }else{
            JOptionPane.showMessageDialog(vistaMovimientosEgr, "No se creo el movimiento");
        }
        
    }else
        JOptionPane.showMessageDialog(vistaMovimientosEgr, "debe especificar una fecha");
    }
    
    public void funcionMovIngCrear(){
    Logica.logBilletera CrearmovIng = new logBilletera();        
    String notasmovimiento;
    int valormov;
    if(getVistaMovimientosIngreso().getJdcfechamovimiento().getDate() != null ){
        Date date1;
        date1 = getVistaMovimientosIngreso().getJdcfechamovimiento().getDate();
        java.sql.Date FechaMov = new java.sql.Date(date1.getTime());

        CrearmovIng.setFechaIniMovimiento(FechaMov);
        valormov= Integer.valueOf(getVistaMovimientosIngreso().getTxtvalor().getText());
        notasmovimiento=getVistaMovimientosIngreso().getTxtnotasmovimiento().getText();        
        CrearmovIng.setNotaMovimiento(notasmovimiento);
        
        Item tipo = (Item) getVistaMovimientosIngreso().getCbTipoCuenta().getSelectedItem();
        int numtipo = tipo.getId();        
        CrearmovIng.setIdCuenta(numtipo);

        Item tipoCat = (Item) getVistaMovimientosIngreso().getCbTipoCat1().getSelectedItem();
        int numtipocat = tipoCat.getId();        
        CrearmovIng.setIdCategoria(numtipocat);
        CrearmovIng.setTotal(valormov);
        boolean resultIng =CrearmovIng.crearMovimiento();
        if (resultIng) {
            JOptionPane.showMessageDialog(vistaMovimientosIng, "Se creo el movimiento");
        }else
        {
            JOptionPane.showMessageDialog(vistaMovimientosIng, "No se creo el movimiento");
        }            
    }else
        JOptionPane.showMessageDialog(vistaMovimientosEgr, "debe especificar una fecha");
    }
        
   public void funcionMovTraCrear(){
   
    
    Logica.logBilletera CrearmovTra = new logBilletera();        
    String notasmovimiento;
    int valormov;
    if(getVistaMovimientosTrans().getJdcfechamovimiento().getDate() != null ){
        Date date1;
        date1 = getVistaMovimientosTrans().getJdcfechamovimiento().getDate();
        java.sql.Date FechaMov = new java.sql.Date(date1.getTime());

        CrearmovTra.setFechaIniMovimiento(FechaMov);
        valormov= Integer.valueOf(getVistaMovimientosTrans().getTxtvalor().getText());
        notasmovimiento=getVistaMovimientosTrans().getTxtnotasmovimiento().getText();        
        CrearmovTra.setNotaMovimiento(notasmovimiento);
        
        Item tipodes = (Item) getVistaMovimientosTrans().getCbCuentaDes().getSelectedItem();
        int numtipo = tipodes.getId();        
        CrearmovTra.setIdCuentaDest(numtipo);

        Item tipoOr = (Item) getVistaMovimientosTrans().getCbCuentaOri().getSelectedItem();
        int numtipoOr = tipoOr.getId();        
        CrearmovTra.setIdCuenta(numtipoOr);
        
        CrearmovTra.setTotal(valormov);
        boolean resultIng =CrearmovTra.transferencias();
        if (resultIng) {
            JOptionPane.showMessageDialog(vistaMovimientosIng, "Se creo el movimiento");
        }else
        {
            JOptionPane.showMessageDialog(vistaMovimientosIng, "No se creo el movimiento");
        }            
    }else
        JOptionPane.showMessageDialog(vistaMovimientosEgr, "debe especificar una fecha");
   
   
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
     
    public void funcionconsulmovimi(){
       Logica.logBilletera llenarmov = new logBilletera();
       List<logBilletera> billeteraConsultarmov = llenarmov.consultarMovimientos(1);
       llenarTablamov(vistaMovimiento.getTblresultadomov(), billeteraConsultarmov);
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
    llenarcat(vistaReportes.getTblresultadoreport(), billeteraConsultar);            
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
    
public void llenarcat(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
         
        modelot.addColumn("Nombre Categoria");
        modelot.addColumn("Total");
 
        
        Object[] columna = new Object[2];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = resultado.get(i).getNombreCategoria();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getTotal();//aca debe ir el get del resulado

           
            modelot.addRow(columna);
        }
        
    }
    
public void llenarTablamov(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Fecha");
        modelot.addColumn("Categoria");
        modelot.addColumn("Cuenta");
        modelot.addColumn("Tipo Movimiento");
        modelot.addColumn("Total");
        modelot.addColumn("notas");
        
        System.out.println("resultado lista movimientos: "+ resultado.size());        
        
        Object[] columna = new Object[6];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 
                
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("resultado lista movimientos: "+ resultado.get(i).getNombreCategoria());        
            columna[0] = resultado.get(i).getFechaIniMovimiento();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCategoria();
            columna[2] = resultado.get(i).getNombreCuenta();
            columna[3] = resultado.get(i).getNombreTipoMovimiento();
            columna[4] = resultado.get(i).getTotal();
            columna[5] = resultado.get(i).getNotaMovimiento();
            modelot.addRow(columna);
        }
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
        modelot.addColumn("Id Tipo Movimiento");
        modelot.addColumn("Tipo Movimiento");
 
        
        Object[] columna = new Object[4];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = resultado.get(i).getIdCategoria();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCategoria();//aca debe ir el get del resulado
            columna[2] = resultado.get(i).getIdTipoMovimiento();//aca debe ir el get del resulado
            columna[3] = resultado.get(i).getNombreTipoMovimiento();//aca debe ir el get del resulado
           
            modelot.addRow(columna);
        }

    }

    public void ConsultaCue(JTable tablaR, List<logBilletera> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Id Cuenta");
        modelot.addColumn("Nombre Cuenta");
        modelot.addColumn("Id Tipo Cuenta");
        modelot.addColumn("Tipo Cuenta");
        modelot.addColumn("Saldo");
        
        Object[] columna = new Object[5];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = resultado.get(i).getIdCuenta();//aca debe ir el get del resulado
            columna[1] = resultado.get(i).getNombreCuenta();
            columna[2] = resultado.get(i).getIdTipoCuenta();
            columna[3] = resultado.get(i).getNombreTipoCuenta();//aca debe ir el get del resulado
            columna[4] = resultado.get(i).getTotal();
            
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
    
    public  void GraficasReporte() {
        Canvas lienzo = getVistGraficas().getLienzo();
    /////ensayo con canvas
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
            
        
        Graphics pincel = dobleBuffer.getGraphics();
        pincel.setColor(Color.YELLOW);
        pincel.drawOval(100, 100, 50, 100);
        pincel.fillOval(100, 100, 50, 100);        
        
        
        
        
                        
        //Image myImage = getImage("/imagenesprueba/ironman.png");  //Sólo en métodos de una subclase de Applet
        //Image myImage = Toolkit.getDefaultToolkit().getImage("/imagenesprueba/ironman.png");

        
        Graphics lapiz = lienzo.getGraphics();
          lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
          
                        
                        //////////
    }
    
    
    public void ReportGraficar(int tipoconsulta){
        Logica.logBilletera billetera = new logBilletera();
        List<logBilletera> billeteraCuenta = null;
////variables canvas
        Canvas lienzo = getVistGraficas().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);        
        Graphics pincel = dobleBuffer.getGraphics();

        
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

                        int suma=0;
                        billeteraCuenta = billeterafech.consultarMovimientos(1);
                        Iterator<logBilletera> it = billeteraCuenta.iterator();                

                        while(it.hasNext()){
                            logBilletera movimiento = it.next();
                            suma=suma+movimiento.getTotal();
                        }
                        
                        int r=(int)Math.random()*255;

                        Iterator<logBilletera> it2 = billeteraCuenta.iterator();  
                        System.out.println("numero iteraciones"+billeteraCuenta.size());
                        vistaGraficas.getEtiTitulo().setText("Grafica por Fechas");
                        int var=0,var2=20,var3=35;
                        while(it2.hasNext()){
                            logBilletera movimiento2 = it2.next();
                            int grado=movimiento2.getTotal()*364/suma;
                            pincel.setColor(new Color(r,var,grado));
                            pincel.fillArc(0,20,100,100,var,grado);
                            pincel.fillRect(200,var2,20,20);
                            pincel.drawString(movimiento2.getFechaIniMovimiento().toString(), 120, var3);   

                            Graphics lapiz = lienzo.getGraphics();
                            lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
                            var=var+grado;
                            var2=var2+30;
                            var3=var3+30;

                        }                        

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
                    int suma=0;
                billeteraCuenta = billeteracat.consultarMovimientos(2);                
                Iterator<logBilletera> it = billeteraCuenta.iterator();                
                
                while(it.hasNext()){
                    logBilletera movimiento = it.next();
                    suma=suma+movimiento.getTotal();
                }    

                int r=(int)Math.random()*255;

                Iterator<logBilletera> it2 = billeteraCuenta.iterator();  
                vistaGraficas.getEtiTitulo().setText("Grafica por Categorias");
                int var=0,var2=20,var3=35;
                while(it2.hasNext()){
                    logBilletera movimiento2 = it2.next();
                    int grado=movimiento2.getTotal()*364/suma;
                    int grado2=grado;
                    if(grado>255)grado2=255;
                    pincel.setColor(new Color(r,var,grado2));
                    pincel.fillArc(0,20,100,100,var,grado);
                    pincel.fillRect(200,var2,20,20);
                    pincel.drawString(movimiento2.getNombreCategoria(), 120, var3);   

                    Graphics lapiz = lienzo.getGraphics();
                    lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
                    var=var+grado;
                    var2=var2+30;
                    var3=var3+30;
                }                        
                
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
                Iterator<logBilletera> it3 = billeteraCuenta.iterator();                
                int suma3=0;
                
                while(it3.hasNext()){
                    //ya que es un array nos toca optener los valores de  cada registro
                    logBilletera movimiento = it3.next();
                    suma3=suma3+movimiento.getTotal();
                }
                int r3=(int)Math.random()*255;

                Iterator<logBilletera> it4 = billeteraCuenta.iterator();  
                vistaGraficas.getEtiTitulo().setText("Grafica por Ingreso Vs Egreso");
                int var4=0,var5=20,var6=35;
                while(it4.hasNext()){
                    logBilletera movimiento2 = it4.next();
                    int grado=movimiento2.getTotal()*364/suma3;
                    int blue=grado;
                    int green=var4;
                    if(grado>255)blue=255;
                    if(var4>255)green=255;
                    pincel.setColor(new Color(r3,green,blue));
                    pincel.fillArc(0,20,100,100,var4,grado);
                    pincel.fillRect(200,var5,20,20);
                    pincel.drawString(movimiento2.getNombreTipoMovimiento(), 120, var6);   

                    Graphics lapiz = lienzo.getGraphics();
                    lapiz.drawImage(dobleBuffer, 0, 0, lienzo);
                    var4=var4+grado;
                    var5=var5+30;
                    var6=var6+30;
                }                        
                
                
                
//                    data3.setValue(movimiento.getNombreTipoMovimiento(), movimiento.getTotal());
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
    
    private void cargarCategoria(JComboBox cbCategoria, List<logBilletera> billeteraCategorias) {
        int numRegistros= billeteraCategorias.size();//hasta el size de la lista resultado 
        System.out.println("Crear categoria");
        cbCategoria.removeAllItems();        
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("Crear categoria"+billeteraCategorias.get(i).getIdCategoria());
            cbCategoria.addItem(new Item(billeteraCategorias.get(i).getIdCategoria(), billeteraCategorias.get(i).getNombreCategoria()));
        }
    }
    
    private void cargarCuenta(JComboBox cbCuenta, List<logBilletera> billeteraCuentas) {
        int numRegistros= billeteraCuentas.size();//hasta el size de la lista resultado 
        System.out.println("Crear categoria");
        cbCuenta.removeAllItems();        
        for (int i = 0; i < numRegistros; i++) {
            System.out.println("Crear categoria"+billeteraCuentas.get(i).getIdCategoria());
            cbCuenta.addItem(new Item(billeteraCuentas.get(i).getIdCuenta(), billeteraCuentas.get(i).getNombreCuenta()));
        }
    }

    public void iniciarAnimacion() {
        animando = true;
        hiloDibujo = new Thread(this);
        hiloDibujo.start();
    }

    @Override
    public void run() {
        int tipoconsulta=1;
        if (vistaReportes.getRbnFechas().isSelected()) {
                tipoconsulta=1;
        }else if (vistaReportes.getRbnCategorias().isSelected()) {
                tipoconsulta=2;
        }else if (vistaReportes.getRbningvsegreso().isSelected()) {
                tipoconsulta=3;
        }            
      
        while(animando){
            try {
                Thread.sleep(400);
                //GraficasReporte();
                ReportGraficar(tipoconsulta);
                animando=false;
            } catch (InterruptedException ex) {
            }
        }
        
    }
  
    public void seleccionarItem(JComboBox cbTipoCuenta,int indice){
        Item item;
        for (int i = 0; i < cbTipoCuenta.getItemCount(); i++)
        {
            item = (Item)cbTipoCuenta.getItemAt(i);
            int valorId = item.getId();
            if (valorId == indice)
            {
                cbTipoCuenta.setSelectedIndex(i);
                break;
            }
        }
    }

    public class Item
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
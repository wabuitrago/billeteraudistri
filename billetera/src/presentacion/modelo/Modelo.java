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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.DocFlavor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
//Funciones Ingresos

	//crear
    public void funcionIngresoCrear(){
	//Muchas cosas para crear la vista      
        
        
    }		

	//consultar
    public void funcionIngresoConsultar(){
	//Muchas cosas para crear la vista        
    }		

	//editar
    public void funcionIngresoEditar(){
	//Muchas cosas para crear la vista        
    }		

	//visualizar
    public void funcionIngresoVisual(){
	//Muchas cosas para crear la vista        
    }		

//Funciones Egresos

	//crear
    public void funcionEgresoCrear(){
	//Muchas cosas para crear la vista        
    }		

	//consultar
    public void funcionEgresoConsultar(){
	//Muchas cosas para crear la vista        
    }		

	//editar
    public void funcionEgresoEditar(){
	//Muchas cosas para crear la vista        
    }		

	//visualizar
    public void funcionEgresoVisual(){
	//Muchas cosas para crear la vista        
    }			

//Funciones Traslas

	//crear
    public void funcionTraslaCrear(){
	//Muchas cosas para crear la vista        
    }		

	//consultar
    public void funcionTraslaConsultar(){
	//Muchas cosas para crear la vista        
    }		

	//editar
    public void funcionTraslaEditar(){
	//Muchas cosas para crear la vista        
    }		

	//visualizar
    public void funcionTraslaVisual(){
	//Muchas cosas para crear la vista        
    }				
    public void funcionCatCrear(){
	String nombreCategoria, tipo;
        int numtipo;
        Boolean resultado;
        
        nombreCategoria=getVistaCategorias().getTxtNombreCat().getText();
        tipo=getVistaCategorias().getCbTipoCat().getSelectedItem().toString();
        if (tipo.equals("Ingreso")) {
            numtipo=1;
        }else{
            numtipo=2;
        }
        getLogica().setNombreCategoria(nombreCategoria);
        getLogica().setIdTipoMovimiento(numtipo);
        
        resultado=getLogica().crearCategoria();
        
        if(resultado)
            System.out.println("Crear categoria: "+nombreCategoria+" - "+numtipo);
        else
            System.out.println("Error al crear categoria: "+nombreCategoria+" - "+numtipo);

//llamo a la funcion de consulta de las categorias
//datos prueba categoria
        List<String> LResultadocat=new ArrayList<String>();
        LResultadocat.add("impuesto");
        LResultadocat.add("ingreso");
        LResultadocat.add("Banco");
        LResultadocat.add("Egreso");
        LResultadocat.add("ventas");
        LResultadocat.add("Ingreso");
        LResultadocat.add("Mercado");
        LResultadocat.add("Egreso");        
////////////////////////////////////////////
//Llamo la funcion para llenar la tabla de categorias
        ConsultaCat(vistaCategoria.getTblcatconsulta(),LResultadocat);

    }
    
    public void funcionReportfechas(){
	//String FechaInicio, FechaFin;
        Date date1, date2;

//conversion de fechas al modelo de sql   
        date1 = getVistaReportes().getJdcfechainicial().getDate();
        java.sql.Date FechaInicio = new java.sql.Date(date1.getTime());
        date2 = getVistaReportes().getJdcfechafinal().getDate();
        java.sql.Date FechaFin = new java.sql.Date(date2.getTime());
        
// Aca defino seria el espacio para el set de las fechas a la logica
        System.out.println("fecha1: "+FechaInicio+" fecha2: "+FechaFin);        
        
//Aca lamaria a la funcion de Logica de la consuta 
        List<logBilletera> billeteraConsultar = new logBilletera().consultarMovimientos(1);
//***********************

//como no tengo la consulta de logica creo estos valores de prueba
//valores de prueba
        List<String> LResultado=new ArrayList<String>();
        LResultado.add("01/08/2017");
        LResultado.add("Banco");
        LResultado.add("bolsillo");
        LResultado.add("Ingreso");
        LResultado.add("01/09/2018");
        LResultado.add("Tersoreria");
        LResultado.add("tajeta debito");
        LResultado.add("Ingreso");
        LResultado.add("12/08/2019");
        LResultado.add("familia");
        LResultado.add("ahorros");
        LResultado.add("Egreso");
        LResultado.add("01/12/2020");
        LResultado.add("universidad");
        LResultado.add("bolsillo");
        LResultado.add("Egreso");
        LResultado.add("01/01/2022");
        LResultado.add("mercado");
        LResultado.add("tarjeta debito");
        LResultado.add("Ingreso");
////////////////////////////////////////////
//Llamo la funcion para llenar la tabla de consulta
        llenarTabla(vistaReportes.getTblresultadoreport(), billeteraConsultar);

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
    
    public void ConsultaCat(JTable tablaR, List<String> resultado){
        DefaultTableModel modelot = new DefaultTableModel();
        tablaR.setModel(modelot);
        
        modelot.addColumn("Nombre Categoria");
        modelot.addColumn("Tipo Movimiento");
        
        Object[] columna = new Object[2];
        
        int numRegistros= resultado.size();//hasta el size de la lista resultado 
        int colum=0;
        
        for (int i = 0; i < numRegistros; i++) {
            columna[colum] = resultado.get(i);//aca debe ir el get del resulado
            colum++;
            if (colum==2) {
            modelot.addRow(columna);
            colum=0;
            }
            
        }
    }    
    
    
	
    }

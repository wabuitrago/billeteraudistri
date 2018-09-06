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

public class Modelo {

//Asignacion de variables
    //private Billetera sistema;
    private vistaPrincipal vistaPrincipal;
    private vistaCategorias vistaCategoria;
    private logBilletera Logica;
//metodo que inicia el sistema
/*    public Billetera getSistema() {
        if(sistema == null){
            sistema = new Billetera();
        }
        return sistema;
    }      
*/	
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
        public logBilletera getLogica() {
        if(Logica == null){
            Logica = new logBilletera();
        }
        return Logica;
    }      
//especificacion de la venta al iniciar    
    public void iniciar() {
        getVistaPrincipal().setSize(300, 300);
        getVistaPrincipal().setVisible(true);
/// y demas especificaciones visuales de las ventana
    }

//funciones para los botones de la ventana principal para llevarlas a las demas vistas
//las coloco aunque estoy verificando porque no estoy seguro si lo maneja
//el modelo o el controlador, si algo cualquier cosa la modifcamos

	//para la vista cuentas
	public void funcionVistaCuenta(){
	//Muchas cosas para crear la vista 
           getVistaCategorias();
          
    }

	//para la vista movimientos
	public void funcionVistaMovi(){
	//Muchas cosas para crear la vista        
    }
	
	//para la vista Categoria
	public void funcionVistaCatego(){
	//Muchas cosas para crear la vista        

    }

	//para la vista Reportes
	public void funcionVistaReporte(){
	//Muchas cosas para crear la vista        
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
	String nombreCategoria;
        int tipo;
        Boolean resultado;
        
        nombreCategoria=getVistaCategorias().getName();
        tipo=Integer.parseInt(getVistaCategorias().getCbTipoCat().toString());
        
        getLogica().setNombreCategoria(nombreCategoria);
        getLogica().setTipoMovimiento(tipo);
        
        resultado=getLogica().crearCategoria();
        
        System.out.println("resultado: "+resultado);
    }
	
    }

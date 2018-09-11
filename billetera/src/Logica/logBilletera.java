/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Sistema.DAO.categoriaDAO;
import Sistema.DAO.cuentaDAO;
import Sistema.DAO.movimientoDAO;
import Sistema.DAO.tipoCuentaDAO;
import Sistema.DTO.categoria;
import Sistema.DTO.cuenta;
import Sistema.DTO.movimiento;
import Sistema.DTO.tipoCuenta;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author William
 */
public class logBilletera {
    
    private String nombreCategoria;
    private String nombreTipoMovimiento;
    private String nombreCuenta;
    private String nombreTipoCuenta;
    private String notaMovimiento;
    private Date fechaIniMovimiento;
    private Date fechaFinMovimiento;

        
    private int idCuenta;
    private int idCuentaDest;
    private int idCategoriaIngTras = 4;
    private int idCategoriaEgrTras = 3;
    private int idTipoCuenta;
    private int idTipoMovimiento;
    private int idCategoria;
    private int documento;
    private int idMovimiento;
    private int total;
    
    public logBilletera(){
    }
    
    /**
    * Funcion para mapear la creacion de una categoria
     * @return booelan dependiendo si se logro o no
    */
    public boolean crearCategoria(){
        //inicializa Dao de categorias
        categoriaDAO categoriasDao = new categoriaDAO();
        //crear categoria
        return categoriasDao.create(new categoria(0, this.nombreCategoria, this.idTipoMovimiento));
    }

    /**
    * Funcion para mapear la creacion de una cuenta
     * @return booelan dependiendo si se logro o no
    */
    public boolean crearCuenta(){
        //inicializa Dao de cuentas
        cuentaDAO cuentasDao = new cuentaDAO();
        //crear cuenta
        this.documento = 1234567890;
        return cuentasDao.create(new cuenta(0, this.nombreCuenta, this.idTipoCuenta, this.documento, 0));
    }
    
    /**
    * Funcion para mapear la creacion de un movimiento
     * @return booelan dependiendo si se logro o no
    */
    public boolean crearMovimiento(){
        //inicializa Dao de movimientos
        movimientoDAO movimientosDao = new movimientoDAO();
        //crear movimiento
        return movimientosDao.create(new movimiento(0, this.fechaIniMovimiento, this.total, this.notaMovimiento, this.idCuenta, this.idCategoria));
    }

    /**
    * Funcion para mapear la actualizacion de una categoria
     * @return booelan dependiendo si se logro o no
    */
    public boolean actualizarCategoria(){
        //inicializa Dao de categorias
        categoriaDAO categoriasDao = new categoriaDAO();
        //actualiza categoria
        return categoriasDao.update(new categoria(this.idCategoria, this.nombreCategoria, this.idTipoMovimiento));
    }

    /**
    * Funcion para mapear la actualizacion de una cuenta
     * @return booelan dependiendo si se logro o no
    */
    public boolean actualizarCuenta(){
        //inicializa Dao de cuentas
        cuentaDAO cuentasDao = new cuentaDAO();
        //actualizar cuenta
        return cuentasDao.update(new cuenta(this.idCuenta, this.nombreCuenta, this.idTipoCuenta, this.documento, 0));
    }
    
    /**
    * Funcion para mapear la actualizacion de un movimiento
     * @return booelan dependiendo si se logro o no
    */
    public boolean actualizarMovimiento(){
        //inicializa Dao de movimientos
        movimientoDAO movimientosDao = new movimientoDAO();
        //actualizar movimiento
        return movimientosDao.update(new movimiento(this.idMovimiento, this.fechaIniMovimiento, this.total, this.notaMovimiento, this.idCuenta, this.idCategoria));
    }
    
    /**
    * Funcion para consultar las cuentas
    * Si se tiene el id se consulta el registro de lo contrario todas las cuentas
     * @return listado de cuentas
    */
    public List<logBilletera> consultarCuentas(){
        //Array de billetera para cuentas consultadas
        ArrayList<logBilletera> billeteraCuenta = new ArrayList();
        //inicializa Dao de cuenta
        cuentaDAO cuentasDao = new cuentaDAO();
        //Listado retornado por el dao
        List<cuenta> cuentaDTO = null;
                
        if (this.idCuenta > 0){
            //consulto cuenta
            cuentaDTO = cuentasDao.read(this.idCuenta);
        } else {
            //consulto cuentas
            cuentaDTO = cuentasDao.readAll();
        }
        //tomamos el iterador para recorrer los resultados del DAO
        Iterator<cuenta> iteradorCuentas = cuentaDTO.listIterator();
        
        while( iteradorCuentas.hasNext() ) {
            //ya que es un array nos toca optener los valores de  cada registro
            cuenta cuenta = iteradorCuentas.next();
            //se inicializa un tipo logbilletera para crear los registros
            logBilletera registroCuenta = new logBilletera();
            registroCuenta.setIdCuenta(cuenta.getIdCuenta());
            registroCuenta.setNombreCuenta(cuenta.getNombreCuenta());
            registroCuenta.setIdTipoCuenta(cuenta.getIdTipoCuenta());
            registroCuenta.setNombreTipoCuenta(cuenta.getNombreTipoCuenta());
            registroCuenta.setTotal(cuenta.getSaldo());
            //se agrega al array el registro
            billeteraCuenta.add(registroCuenta);
        }
        return billeteraCuenta;
    }
    
    /**
    * Funcion para consultar las categorias
    * Si se tiene el id se consulta el registro de lo contrario todas las categorias
     * @return listado de categorias
    */
    public List<logBilletera> consultarCategorias(){
        //Array de billetera para categorias consultadas
        ArrayList<logBilletera> billeteraCategoria = new ArrayList();
        //inicializa Dao de categorias
        categoriaDAO catgoriasDao = new categoriaDAO();
        //Listado retornado por el dao
        List<categoria> categoriaDTO = null;
                
        if (this.idCuenta > 0){
            //consulto cuentas
            categoriaDTO = catgoriasDao.read(this.idCategoria);
        } else {
            //consulto cuentas
            String WhereCate = " where visible=1 ";
            //colocamos las fechas de filtro
            if(this.idTipoMovimiento > 0){
                WhereCate = WhereCate + " and tipoMovimiento = "+this.idTipoMovimiento;
            }
            catgoriasDao.setFiltro(WhereCate);
            categoriaDTO = catgoriasDao.readAll();
        }
        //tomamos el iterador para recorrer los resultados del DAO
        Iterator<categoria> iteradorCategorias = categoriaDTO.listIterator();
        
        while( iteradorCategorias.hasNext() ) {
            //ya que es un array nos toca optener los valores de  cada registro
            categoria categoria = iteradorCategorias.next();
            //se inicializa un tipo logbilletera para crear los registros
            logBilletera registroCategoria = new logBilletera();
            registroCategoria.setIdCuenta(categoria.getIdCategoria());
            registroCategoria.setNombreCuenta(categoria.getNombreCategoria());
            registroCategoria.setIdTipoMovimiento(categoria.getTipoMovimiento());
            registroCategoria.setNombreTipoMovimiento(categoria.getNombreTipoMovimiento());
            //se agrega al array el registro
            billeteraCategoria.add(registroCategoria);
        }
        return billeteraCategoria;
    }
    
    /**
    * Funcion para consultar los movimientos
    * Si se tiene el id se consulta el registro de lo contrario todos los movimientos
     * @return listado de movimientos
    */
    public List<logBilletera> consultarMovimientos(int tipoConsulta){
        //Array de billetera para movimientos consultados
        ArrayList<logBilletera> billeteraMovimiento = new ArrayList();
        //inicializa Dao de movimientos
        movimientoDAO movimientoDao = new movimientoDAO();
        //Listado retornado por el dao
        List<movimiento> movimientoDTO = null;
                
        if (this.idCuenta > 0){
            //consulto movimiento
            movimientoDTO = movimientoDao.read(this.idMovimiento);
        } else {
            String WhereMovi = " where 1=1 ";
            //colocamos las fechas de filtro
            if(this.fechaIniMovimiento != null){
                WhereMovi = WhereMovi + " and fechaMovimiento >= '"+this.fechaIniMovimiento+"' ";
            }
            if(this.fechaFinMovimiento != null){
                WhereMovi = WhereMovi + " and fechaMovimiento <= '"+this.fechaFinMovimiento+"' ";
            }
            movimientoDao.setFiltro(WhereMovi);
            //colocamos el tipo de consulta a realizar
            movimientoDao.setTipoConsulta(tipoConsulta);
            //consulto movimientos
            movimientoDTO = movimientoDao.readFilter();
        }
        //tomamos el iterador para recorrer los resultados del DAO
        Iterator<movimiento> iteradorMovimientos = movimientoDTO.listIterator();
        
        while( iteradorMovimientos.hasNext() ) {
            //ya que es un array nos toca optener los valores de  cada registro
            movimiento movimiento = iteradorMovimientos.next();
            //se inicializa un tipo logbilletera para crear los registros
            logBilletera registroMovimiento = new logBilletera();
            registroMovimiento.setIdMovimiento(movimiento.getIdMovimiento());
            registroMovimiento.setFechaIniMovimiento(movimiento.getFechaMovimiento());
            registroMovimiento.setTotal(movimiento.getValor());
            registroMovimiento.setNotaMovimiento(movimiento.getNota());
            registroMovimiento.setIdTipoCuenta(movimiento.getIdCuenta());
            registroMovimiento.setIdCategoria(movimiento.getIdCategoria());
            registroMovimiento.setNombreCuenta(movimiento.getNombreCuenta());
            registroMovimiento.setNombreCategoria(movimiento.getNombreCategoria());
            registroMovimiento.setIdTipoMovimiento(movimiento.getIdTipoMovimiento());
            registroMovimiento.setNombreTipoMovimiento(movimiento.getNombreTipoMovimiento());
            //se agrega al array el registro
            billeteraMovimiento.add(registroMovimiento);
        }
        return billeteraMovimiento;
    }
    
    /**
    * Funcion para consultar los tipos de cuentas
    * Si se tiene el id se consulta el registro de lo contrario todos los tipos cuentas
     * @return listado de tipo cuentas
    */
    public List<logBilletera> consultarTipoCuentas(){
        //Array de billetera para categorias consultadas
        ArrayList<logBilletera> billeteraTipoCuentas = new ArrayList();
        //inicializa Dao de categorias
        tipoCuentaDAO tipoCuentaDao = new tipoCuentaDAO();
        //Listado retornado por el dao
        List<tipoCuenta> tipoCuentaDTO = null;
                
        if (this.idCuenta > 0){
            //consulto tipocuentas
            tipoCuentaDTO = tipoCuentaDao.read(this.idTipoCuenta);
        } else {
            
            tipoCuentaDTO = tipoCuentaDao.readAll();
        }
        //tomamos el iterador para recorrer los resultados del DAO
        Iterator<tipoCuenta> iteradorTipoCuentas = tipoCuentaDTO.listIterator();
        
        while( iteradorTipoCuentas.hasNext() ) {
            //ya que es un array nos toca optener los valores de  cada registro
            tipoCuenta tipoCuenta = iteradorTipoCuentas.next();
            //se inicializa un tipo logbilletera para crear los registros
            logBilletera registroTipoCuenta = new logBilletera();
            registroTipoCuenta.setIdTipoCuenta(tipoCuenta.getIdTipoCuenta());
            registroTipoCuenta.setNombreTipoCuenta(tipoCuenta.getNombre());
            //se agrega al array el registro
            billeteraTipoCuentas.add(registroTipoCuenta);
        }
        return billeteraTipoCuentas;
    }
    
    public boolean transferencias(){
        boolean resultado = false;
        
        this.idTipoMovimiento = this.idCategoriaEgrTras;
        //crea movimiento egreso
        if(crearMovimiento()){
            //crea movimiento ingreso
            this.idTipoMovimiento = this.idCategoriaIngTras;
            this.idCuenta = this.idCuentaDest;
            if (crearMovimiento())
                resultado = true;
        }
        return resultado;
    }
            
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
            
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }
    
    public String getNombreTipoMovimiento() {
        return nombreTipoMovimiento;
    }

    public void setNombreTipoMovimiento(String nombreTipoMovimiento) {
        this.nombreTipoMovimiento = nombreTipoMovimiento;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public Date getFechaIniMovimiento() {
        return fechaIniMovimiento;
    }

    public void setFechaIniMovimiento(Date fechaIniMovimiento) {
        this.fechaIniMovimiento = fechaIniMovimiento;
    }

    public String getNotaMovimiento() {
        return notaMovimiento;
    }

    public void setNotaMovimiento(String notaMovimiento) {
        this.notaMovimiento = notaMovimiento;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaFinMovimiento() {
        return fechaFinMovimiento;
    }

    public void setFechaFinMovimiento(Date fechaFinMovimiento) {
        this.fechaFinMovimiento = fechaFinMovimiento;
    }

    public int getIdCuentaDest() {
        return idCuentaDest;
    }

    public void setIdCuentaDest(int idCuentaDest) {
        this.idCuentaDest = idCuentaDest;
    }

    
}

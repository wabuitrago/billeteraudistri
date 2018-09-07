/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Sistema.DAO.categoriaDAO;
import Sistema.DAO.cuentaDAO;
import Sistema.DTO.categoria;
import Sistema.DTO.cuenta;
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
    
    private int idCuenta;
    private int idTipoCuenta;
    private int tipoMovimiento;
    private int idCategoria;
    private int documento;
    private int saldo;
    
    public logBilletera(){
    }
    /**
    * Funcion para mapear la creacion de una categoria
    */
    public boolean crearCategoria(){
        //inicializa Dao de categorias
        categoriaDAO categoriasDao = new categoriaDAO();
        
        //crear categoria
        return categoriasDao.create(new categoria(0, this.nombreCategoria, this.tipoMovimiento));
    }

    /**
    * Funcion para mapear la creacion de una categoria
     * @return listado de cuentas
    */
    public List<logBilletera> consultarCuentas(){
        //Array de billetera paar cuentas consultadas
        ArrayList<logBilletera> billeteraCuenta = new ArrayList();
        //inicializa Dao de categorias
        cuentaDAO cuentasDao = new cuentaDAO();
        //Listado retornado por el dao
        List<cuenta> cuentaDTO = null;
        //consulto cuentas
        cuentaDTO = cuentasDao.readAll();
        
        //tomamos el iterador para recorrer los resultados del DAO
        Iterator<cuenta> iteradorCuentas = cuentaDTO.listIterator();
        
        
        while( iteradorCuentas.hasNext() ) {
            //ya que es un array nos toca optener los valores de  cada registro
            cuenta cuenta = iteradorCuentas.next();
            //se inicializa un tipo logbilletera para crear los registros
            logBilletera registroCuenta = new logBilletera();
            //System.out.println("Valor del campo" + iterador.next().getNombreCuenta());
            registroCuenta.setIdCuenta(cuenta.getIdCuenta());
            registroCuenta.setNombreCuenta(cuenta.getNombreCuenta());
            registroCuenta.setIdTipoCuenta(cuenta.getIdTipoCuenta());
            registroCuenta.setNombreTipoCuenta(cuenta.getNombreTipoCuenta());
            //se agrega al array el registro
            billeteraCuenta.add(registroCuenta);
        }
        return billeteraCuenta;
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

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}

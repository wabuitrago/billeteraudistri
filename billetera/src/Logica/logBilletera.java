/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Sistema.DAO.categoriaDAO;
import Sistema.DTO.categoria;

/**
 *
 * @author William
 */
public class logBilletera {
    
    private String nombreCategoria;
    private String nombreTipoMovimiento;
    private int tipoMovimiento;
    private int idCategoria;
    
    /**
    * Funcion para mapear la creacion de una categoria
    */
    public boolean crearCategoria(){
        //inicializa Dao de categorias
        categoriaDAO categoriasDao = new categoriaDAO();
        
        //crear categoria
        return categoriasDao.create(new categoria(0, this.nombreCategoria, this.tipoMovimiento));
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
}

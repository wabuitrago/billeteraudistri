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
    private int tipoMovimiento;
    
    /*public static void main(String[] args) {
        categoriaDAO catDao = new categoriaDAO();
        
        //crear categoria
        catDao.create(new categoria(0, "pruebajava", 1));
        
        //actualizar categoria
        //catDao.update(new categoria(3, "actualizaJava", 2));
        
        //consulta id categoria
        categoria categoBuscar = catDao.read("3");
        System.out.println(categoBuscar.getNombreCategoria());
        
    }*/
    
    public boolean crearCategoria(){
        //inicializa Dao de categorias
        categoriaDAO categoriasDao = new categoriaDAO();
        
        //crear categoria
        return categoriasDao.create(new categoria(0, this.nombreCategoria, this.tipoMovimiento));
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
    
    
}

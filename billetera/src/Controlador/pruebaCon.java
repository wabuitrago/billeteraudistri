/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Sistema.DAO.categoriaDAO;
import Sistema.DTO.categoria;

/**
 *
 * @author William
 */
public class pruebaCon {
    public static void main(String[] args) {
        categoriaDAO catDao = new categoriaDAO();
        
        //crear categoria
        catDao.create(new categoria(0, "pruebajava", 1));
        
        //actualizar categoria
        //catDao.update(new categoria(3, "actualizaJava", 2));
        
        //consulta id categoria
        categoria categoBuscar = catDao.read("3");
        System.out.println(categoBuscar.getNombreCategoria());
        
    }
}

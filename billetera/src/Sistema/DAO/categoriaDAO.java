/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DAO;

import Sistema.Interfaces.CRUD;
import Sistema.Conexion.Conexion;
import Sistema.DTO.categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class categoriaDAO implements CRUD<categoria>{

    private static final String SQL_INSERT = "INSERT INTO categoria (nombreCategoria, tipoMovimiento) values (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM categoria WHERE idCategoria = ?";
    private static final String SQL_UPDATE = "UPDATE categoria SET nombreCategoria = ?, tipoMovimiento = ? WHERE idCategoria = ?";
    private static final String SQL_READ = "SELECT idCategoria, nombreCategoria, tipoMovimiento, case tipoMovimiento when 1 then 'INGRESO' ELSE 'EGRESO' END nombreMovimiento FROM categoriaWHERE idCategoria = ? ";
    private static final String SQL_READALL = "SELECT idCategoria, nombreCategoria, tipoMovimiento, case tipoMovimiento when 1 then 'INGRESO' ELSE 'EGRESO' END nombreMovimiento FROM categoria";
    
    private static final Conexion cn = Conexion.conectarse();
    
    @Override
    public boolean create(categoria campos) {
        PreparedStatement ps;
        try {
                       
            ps = cn.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, campos.getNombreCategoria());
            ps.setInt(2,campos.getTipoMovimiento());
            
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(Object llave) {
        PreparedStatement ps;
        try {
                      
            ps = cn.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, Integer.valueOf(llave.toString()));
                    
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(categoria campos) {
        PreparedStatement ps;
        try {
            
            ps = cn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, campos.getNombreCategoria());
            ps.setInt(2, campos.getTipoMovimiento());
            ps.setInt(3, campos.getIdCategoria());
                    
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<categoria> read(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<categoria> cat = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.valueOf(llave.toString()));
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cat.add(new categoria(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cat;
    }

    @Override
    public List<categoria> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<categoria> categorias = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                categorias.add(new categoria(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(categoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categorias;
    }
    
}

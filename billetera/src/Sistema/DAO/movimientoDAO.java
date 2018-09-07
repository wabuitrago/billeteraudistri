/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DAO;

import Sistema.Interfaces.CRUD;
import Sistema.Conexion.Conexion;
import Sistema.DTO.movimiento;
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
public class movimientoDAO implements CRUD<movimiento>{

    private static final String SQL_INSERT = "INSERT INTO movimiento(fechaMovimiento, valor, nota, idCuenta, idCategoria) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM movimiento WHERE idMovimiento = ?";
    private static final String SQL_UPDATE = "UPDATE movimiento SET fechaMovimiento = ?, valor = ?, nota = ?, idCuenta = ?, idCategoria = ? WHERE idMovimiento = ?";
    private static final String SQL_READ = "SELECT idMovimiento, fechaMovimiento, valor, nota, idCuenta, idCategoria FROM movimiento WHERE idMovimiento = ?";
    private static final String SQL_READALL = "SELECT idMovimiento, fechaMovimiento, valor, nota, idCuenta, idCategoria FROM movimiento";
    
    private static final Conexion cn = Conexion.conectarse();
    
    @Override
    public boolean create(movimiento campos) {
        PreparedStatement ps;
        try {
                       
            ps = cn.getCnn().prepareStatement(SQL_INSERT);
            ps.setDate(1, campos.getFechaMovimiento());
            ps.setInt(2, campos.getValor());
            ps.setString(3, campos.getNota());
            ps.setInt(4, campos.getIdCuenta());
            ps.setInt(5, campos.getIdCategoria());
            
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(movimiento campos) {
        PreparedStatement ps;
        try {
            
            ps = cn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setDate(1, campos.getFechaMovimiento());
            ps.setInt(2, campos.getValor());
            ps.setString(3, campos.getNota());
            ps.setInt(4, campos.getIdCuenta());
            ps.setInt(5, campos.getIdCategoria());
            ps.setInt(5, campos.getIdMovimiento());
                    
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<movimiento> read(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<movimiento> movimien = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.valueOf(llave.toString()));
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                movimien.add(new movimiento(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movimien;
    }

    @Override
    public List<movimiento> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<movimiento> movimientos = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                movimientos.add(new movimiento(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movimientos;
    }
    
}

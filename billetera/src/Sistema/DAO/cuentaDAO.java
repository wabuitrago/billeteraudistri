/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DAO;

import Sistema.Interfaces.CRUD;
import Sistema.Conexion.Conexion;
import Sistema.DTO.cuenta;
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
public class cuentaDAO implements CRUD<cuenta>{

    private static final String SQL_INSERT = "INSERT INTO cuenta(nombreCuenta, idTipoCuenta, documento, saldo) VALUES(?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM cuenta WHERE idCuenta = ?";
    private static final String SQL_UPDATE = "UPDATE cuenta SET nombreCuenta = ?, idTipoCuenta = ?, saldo = ? WHERE idCuenta = ?";
    private static final String SQL_READ = "SELECT idCuenta, nombreCuenta, tc.idTipoCuenta, documento, saldo, tc.Nombre FROM cuenta c inner join tipoCuenta tc on tc.idTipoCuenta=c.idTipoCuenta WHERE idCuenta = ?";
    private static final String SQL_READALL = "SELECT idCuenta, nombreCuenta, tc.idTipoCuenta, documento, saldo, tc.Nombre FROM cuenta c inner join tipoCuenta tc on tc.idTipoCuenta=c.idTipoCuenta";
    
    private static final Conexion cn = Conexion.conectarse();
    
    @Override
    public boolean create(cuenta campos) {
        PreparedStatement ps;
        try {
                       
            ps = cn.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, campos.getNombreCuenta());
            ps.setInt(2, campos.getIdTipoCuenta());
            ps.setInt(3, campos.getDocumento());
            ps.setInt(4, campos.getSaldo());
            
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(cuenta campos) {
        PreparedStatement ps;
        try {
            
            ps = cn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, campos.getNombreCuenta());
            ps.setInt(2, campos.getIdTipoCuenta());
            ps.setInt(3, campos.getSaldo());
            ps.setInt(3, campos.getIdCuenta());
                    
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public List<cuenta> read(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<cuenta> cuent = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.valueOf(llave.toString()));
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Valor del campo" + rs.getInt(1));
                cuent.add(new cuenta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cuent;
    }

    @Override
    public List<cuenta> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<cuenta> cuentas = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cuentas.add(new cuenta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(cuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cuentas;
    }
    
}

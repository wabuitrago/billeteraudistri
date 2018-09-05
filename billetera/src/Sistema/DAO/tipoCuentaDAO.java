/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DAO;

import Sistema.Interfaces.CRUD;
import Sistema.Conexion.Conexion;
import Sistema.DTO.tipoCuenta;
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
public class tipoCuentaDAO implements CRUD<tipoCuenta>{

    private static final String SQL_INSERT = "INSERT INTO tipoCuenta(Nombre) values (?)";
    private static final String SQL_DELETE = "DELETE FROM tipoCuenta where idTipoCuenta = ?";
    private static final String SQL_UPDATE = "UPDATE tipoCuenta SET nombre = ? where idTipoCuenta = ?";
    private static final String SQL_READ = "SELECT idTipoCuenta, nombre from tipoCuenta where idTipoCuenta = ?";
    private static final String SQL_READALL = "SELECT idTipoCuenta, nombre from tipoCuenta ";
    
    private static final Conexion cn = Conexion.conectarse();
    
    @Override
    public boolean create(tipoCuenta campos) {
        PreparedStatement ps;
        try {
                       
            ps = cn.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, campos.getNombre());
            
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(tipoCuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tipoCuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(tipoCuenta campos) {
        PreparedStatement ps;
        try {
            
            ps = cn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, campos.getNombre());
            ps.setInt(2, campos.getIdTipoCuenta());
                    
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(tipoCuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public tipoCuenta read(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        tipoCuenta tipCuen = null;
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.valueOf(llave.toString()));
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                tipCuen = new tipoCuenta(rs.getInt(1), rs.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(tipoCuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipCuen;
    }

    @Override
    public List<tipoCuenta> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<tipoCuenta> tipoCuentas = new ArrayList();
        
        try {
                        
            ps = cn.getCnn().prepareStatement(SQL_READALL);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                tipoCuentas.add(new tipoCuenta(rs.getInt(1), rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(tipoCuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoCuentas;
    }
    
}

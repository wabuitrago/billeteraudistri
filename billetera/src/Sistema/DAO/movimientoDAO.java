/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DAO;

import Sistema.Interfaces.CRUD;
import Sistema.Conexion.Conexion;
import Sistema.DTO.movimiento;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class movimientoDAO implements CRUD<movimiento>{

    public String filtro = "where 1=1 ";
    public int tipoConsulta;
    private static final String SQL_INSERT = "INSERT INTO movimiento(fechaMovimiento, valor, nota, idCuenta, idCategoria) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM movimiento WHERE idMovimiento = ?";
    private static final String SQL_UPDATE = "UPDATE movimiento SET fechaMovimiento = ?, valor = ?, nota = ?, idCuenta = ?, idCategoria = ? WHERE idMovimiento = ?";
    private static final String SQL_READ = "SELECT idMovimiento, fechaMovimiento, valor, nota, c.idCuenta, ca.idCategoria, c.nombreCuenta, ca.nombreCategoria" +
            "FROM movimiento m " +
            "inner join cuenta c on c.idCuenta=m.idCuenta " +
            "inner join categoria ca on ca.idCategoria=m.idCategoria WHERE idMovimiento = ?";
    private static final String SQL_READALL = "SELECT idMovimiento, fechaMovimiento, valor, nota, c.idCuenta, ca.idCategoria, c.nombreCuenta, ca.nombreCategoria, tipoMovimiento, case tipoMovimiento when 1 then 'INGRESO' ELSE 'EGRESO' END nombreMovimiento  "
            + "FROM movimiento m "
            + "inner join cuenta as c on c.idCuenta=m.idCuenta "
            + "inner join categoria as ca on ca.idCategoria=m.idCategoria ?";
    private static final String SQL_GROUPBYTIPOMOVIMIENTO = "SELECT tipoMovimiento, case tipoMovimiento when 1 then 'INGRESO' ELSE 'EGRESO' END nombreMovimiento, sum(valor) total FROM movimiento as m " +
            " inner join categoria as ca on ca.idCategoria=m.idCategoria ? " +
            " group by tipoMovimiento;";
    
    private static final String SQL_GROUPBYCATEGORIA = "SELECT ca.idCategoria, ca.nombreCategoria, sum(valor) total FROM movimiento as m" +
            " inner join categoria as ca on ca.idCategoria=m.idCategoria ? " +
            " group by ca.idCategoria;";
    
    private static final Conexion cn = Conexion.conectarse();
    
    @Override
    public boolean create(movimiento campos) {
        PreparedStatement ps;
        try {
                       
            ps = cn.getCnn().prepareStatement(SQL_INSERT);
            
            java.sql.Date date = new java.sql.Date(campos.getFechaMovimiento().getTime());
            
            ps.setString(1, date.toString());
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
            String consulta = SQL_READALL.replace("?", this.filtro);
            System.out.println(consulta);
            ps = cn.getCnn().prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                movimientos.add(new movimiento(rs.getInt(1), Date.valueOf(rs.getString(2)), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movimientos;
    }
    
    public List<movimiento> readFiltros() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<movimiento> movimientos = new ArrayList();
        
        try {
            String consulta = "";
            if(this.tipoConsulta == 2){
                consulta = SQL_GROUPBYCATEGORIA;
            } else{
                consulta = SQL_GROUPBYTIPOMOVIMIENTO;
            }
            consulta = consulta.replace("?", this.filtro);
            ps = cn.getCnn().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                if(this.tipoConsulta == 2){
                    movimientos.add(new movimiento(0, null, rs.getInt(3), null, 0, rs.getInt(1), null, rs.getString(2), 0, null));
                } else{
                    movimientos.add(new movimiento(0, null, rs.getInt(3), null, 0, 0, null, null, rs.getInt(1), rs.getString(2)));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(movimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movimientos;
    }
    
    public List<movimiento> readFilter() {
        
        List<movimiento> movimientos = new ArrayList();
        
        if(this.tipoConsulta == 1){
            movimientos = readAll();
        }else{
            movimientos = readFiltros();
        }             
        
        return movimientos;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    
}

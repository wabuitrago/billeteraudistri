/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DTO;

import java.sql.Date;

/**
 *
 * @author William
 */
public class movimiento {
    private int idMovimiento;
    private Date fechaMovimiento;
    private int valor;
    private String nota;
    private int idCuenta;
    private int idCategoria;

    public movimiento() {
    }

    public movimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    
    public movimiento(int idMovimiento, Date fechaMovimiento, int valor, String nota, int idCuenta, int idCategoria) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.valor = valor;
        this.nota = nota;
        this.idCuenta = idCuenta;
        this.idCategoria = idCategoria;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}

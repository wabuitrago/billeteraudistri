/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.DTO;

/**
 *
 * @author William
 */
public class cuenta {
    private int idCuenta;
    private String nombreCuenta;
    private int idTipoCuenta;
    private String nombreTipoCuenta;
    private int documento;
    private int saldo;

    public cuenta() {
    }

    public cuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    public cuenta(int idCuenta, String nombreCuenta, int idTipoCuenta, int documento, int saldo, String nombreTipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.idTipoCuenta = idTipoCuenta;
        this.documento = documento;
        this.saldo = saldo;
        this.nombreCuenta = nombreCuenta;
    }
    
    public cuenta(int idCuenta, String nombreCuenta, int idTipoCuenta, int documento, int saldo) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.idTipoCuenta = idTipoCuenta;
        this.documento = documento;
        this.saldo = saldo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }
}

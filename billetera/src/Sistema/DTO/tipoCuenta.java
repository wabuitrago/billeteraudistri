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
public class tipoCuenta {
    private int idTipoCuenta;
    private String Nombre;

    public tipoCuenta() {
    }

    public tipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }
    
    public tipoCuenta(int idTipoCuenta, String Nombre) {
        this.idTipoCuenta = idTipoCuenta;
        this.Nombre = Nombre;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}

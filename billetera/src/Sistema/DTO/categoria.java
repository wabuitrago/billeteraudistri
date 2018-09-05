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
public class categoria {
    private int idCategoria;
    private String nombreCategoria;
    private int tipoMovimiento;

    public categoria() {
    }

    public categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public categoria(int idCategoria, String nombreCategoria, int tipoMovimiento) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

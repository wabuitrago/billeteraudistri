/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Conexion;

/**
 * Paquetes a utilizar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class Conexion {
    public static Conexion instancia; // aplicar el singleton
    private Connection cnn; //objecto de conexion
    
    private Conexion(){
        try {
            cnn = DriverManager.getConnection("jdbc:sqlite:C:/Users/William/Documents/universidad/1 Semestre/billetera.db"); //conexion
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * synchronized es para tener solo una conexion y solo se puede acceder por una peticion
     * @return instancia de la conexion
     */
    public  synchronized static Conexion conectarse(){
        if (instancia == null){
            instancia = new Conexion();            
        }
        return instancia;
    }

    public Connection getCnn() {
        return cnn;
    }
    
    public void cerrarConexion(){
     this.instancia = null;   
    }
}

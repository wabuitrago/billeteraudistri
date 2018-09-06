/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billetera;

import presentacion.modelo.Modelo;


public class Billetera {

private Modelo mibilletera;


    public Billetera() {
        mibilletera = new Modelo();
        mibilletera.iniciar();
    }
    
    public static void main(String[] args) {
        new Billetera();
    }
    


}
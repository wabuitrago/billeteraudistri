/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.logBilletera;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author William
 */
public class pruebaCon {
    public static void main(String[] args) {
        
        //consulta id categoria
        //categoria categoBuscar = catDao.read("3");
        //System.out.println(categoBuscar.getNombreCategoria());
        Logica.logBilletera billetera = new logBilletera();
        List<logBilletera> billeteraCuenta = null;
        
        billeteraCuenta = billetera.consultarCuentas();
        
        Iterator<logBilletera> it = billeteraCuenta.iterator();
        System.out.println("La lista inicial contiene los siguientes datos");
        while(it.hasNext()){
            System.out.println("Valor del campo" + it.next().getNombreCuenta());
        }
    }
}

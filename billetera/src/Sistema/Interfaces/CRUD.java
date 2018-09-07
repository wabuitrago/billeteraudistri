/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema.Interfaces;

import java.util.List;

/**
 *
 * @author William
 */
public interface CRUD <camposTabla> {
    public boolean create(camposTabla campos);
    public boolean delete(Object llave);
    public boolean update(camposTabla campos);
    
    public List<camposTabla> read(Object llave);
    public List<camposTabla> readAll();
}

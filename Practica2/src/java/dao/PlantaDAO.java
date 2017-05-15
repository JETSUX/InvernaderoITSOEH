/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Planta;

/**
 *
 * @author 51737
 */
public interface PlantaDAO {
    
    public Planta selectById(int id);
    
    public List<Planta>SelectAll();
    
    public void insert(Planta planta);
    
    public void update(Planta planta);
    
    public void delate(Planta planta);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Herbicida;

/**
 *
 * @author 51737
 */
public interface HerbicidaDAO {
    
    public Herbicida selectById(int id);
    
    public List<Herbicida>SelectAll();
    
    public void insert(Herbicida herbicida);
    
    public void update(Herbicida herbicida);
    
    public void delate(Herbicida herbicida);
    
}

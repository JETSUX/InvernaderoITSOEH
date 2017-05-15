/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Insecticida;

/**
 *
 * @author 51737
 */
public interface InsecticidaDAO {
    
    public Insecticida selectById(int id);
    
    public List<Insecticida>SelectAll();
    
    public void insert(Insecticida insecticida);
    
    public void update(Insecticida insecticida);
    
    public void delate(Insecticida insecticida);
    
}

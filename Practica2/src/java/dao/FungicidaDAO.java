/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Fungicida;

/**
 *
 * @author 51737
 */
public interface FungicidaDAO {
    
    public Fungicida selectById(int id);
    
    public List<Fungicida>SelectAll();
    
    public void insert(Fungicida fungicida);
    
    public void update(Fungicida fungicida);
    
    public void delate(Fungicida fungicida);
    
}

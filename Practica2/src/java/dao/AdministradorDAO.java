/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;

/**
 *
 * @author 51737
 */
public interface AdministradorDAO {
    
    public Administrador selectById(int id);
    
    public boolean authenticate(String nombre, String password);
    
    public Administrador getUserByNombre(String nombre);   
    
    public List<Administrador>SelectAll();
    
    public void insert(Administrador administrador);
    
    public void update(Administrador administrador);
    
    public void delate(Administrador administrador);
    
}

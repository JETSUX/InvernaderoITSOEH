/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import modelo.Usuario;
/**
 *
 * @author 51737
 */
public interface UsuarioDAO {
   
    public Usuario selectById(int id);
    
    public List<Usuario>SelectAll();
    
    public void insert(Usuario usuario);
    
    public void update(Usuario usuario);
    
    public void delate(Usuario usuario);
    
}

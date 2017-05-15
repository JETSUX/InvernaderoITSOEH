/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import util.HibernateSession;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author 51737
 */
public class HibernateUsuarioDAO implements UsuarioDAO{
 @Override
    public Usuario selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Usuario usuario =(Usuario) session.get(Usuario.class, id);
        session.close();
        return usuario;
    }
    
    @Override
    public List<Usuario>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Usuario>usuario=session.createCriteria(Usuario.class).list();
        session.close();
        return usuario;
    }
    
    @Override
    public void insert(Usuario usuario){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(usuario);
        usuario.setIdUsuario(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Usuario usuario){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Usuario usuario){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }
}

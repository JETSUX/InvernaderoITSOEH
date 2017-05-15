/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.HibernateSession;
import java.util.List;
import modelo.Fungicida;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author 51737
 */
public class HibernateFungicidaDAO implements FungicidaDAO {
 @Override
    public Fungicida selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Fungicida fungicida =(Fungicida) session.get(Fungicida.class, id);
        session.close();
        return fungicida;
    }
    
    @Override
    public List<Fungicida>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Fungicida>fungicida=session.createCriteria(Fungicida.class).list();
        session.close();
        return fungicida;
    }
    
    @Override
    public void insert(Fungicida fungicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(fungicida);
        fungicida.setIdFungicida(id);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Fungicida fungicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(fungicida);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Fungicida fungicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(fungicida);
        session.getTransaction().commit();
        session.close();
    }
}
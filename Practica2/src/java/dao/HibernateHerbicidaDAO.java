/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Herbicida;
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
public class HibernateHerbicidaDAO implements HerbicidaDAO{
 @Override
    public Herbicida selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Herbicida herbicida =(Herbicida) session.get(Herbicida.class, id);
        session.close();
        return herbicida;
    }
    
    @Override
    public List<Herbicida>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Herbicida>herbicida=session.createCriteria(Herbicida.class).list();
        session.close();
        return herbicida;
    }
    
    @Override
    public void insert(Herbicida herbicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(herbicida);
        herbicida.setIdHerbicida(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Herbicida herbicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(herbicida);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Herbicida herbicida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(herbicida);
        session.getTransaction().commit();
        session.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Planta;
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
public class HibernatePlantaDAO implements PlantaDAO{
 @Override
    public Planta selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Planta planta =(Planta) session.get(Planta.class, id);
        session.close();
        return planta;
    }
    
    @Override
    public List<Planta>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Planta>planta=session.createCriteria(Planta.class).list();
        session.close();
        return planta;
    }
    
    @Override
    public void insert(Planta planta){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(planta);
        planta.setIdPlanta(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Planta planta){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(planta);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Planta planta){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(planta);
        session.getTransaction().commit();
        session.close();
    }
}

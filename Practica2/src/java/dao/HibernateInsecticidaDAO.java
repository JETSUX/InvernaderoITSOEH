/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Insecticida;
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
public class HibernateInsecticidaDAO implements InsecticidaDAO{
 @Override
    public Insecticida selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Insecticida insecticida =(Insecticida) session.get(Insecticida.class, id);
        session.close();
        return insecticida;
    }
    
    @Override
    public List<Insecticida>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Insecticida>insecticida=session.createCriteria(Insecticida.class).list();
        session.close();
        return insecticida;
    }
    
    @Override
    public void insert(Insecticida insecticida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(insecticida);
        insecticida.setIdInsecticida(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Insecticida insecticida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(insecticida);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Insecticida insecticida){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(insecticida);
        session.getTransaction().commit();
        session.close();
    }
}

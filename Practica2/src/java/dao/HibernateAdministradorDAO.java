/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateSession;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author 51737
 */
public class HibernateAdministradorDAO implements AdministradorDAO {
    
     @Override
    public boolean authenticate(String nombre, String password) {
	 Administrador user = getUserByNombre(nombre);		
	 if(user!=null && user.getNomAdmin().equals(nombre) && 
                 user.getPassAdmin().equals(password)){
		 return true;
	 }else{
		 return false;
	 }
}

    @Override
    public Administrador getUserByNombre(String nombre) {
	 SessionFactory sessionFactory = HibernateSession.getSessionFactory();
         Session session = sessionFactory.openSession();
        
	 Transaction tx = null;
	 Administrador user = null;
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Administrador "
                         + "where nom_admin='"+nombre+"'");
		 user = (Administrador)query.uniqueResult();
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }
	 return user;
}

     @Override
    public Administrador selectById(int id){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Administrador administrador =(Administrador) session.get(Administrador.class, id);
        session.close();
        return administrador;
    }
    
    @Override
    public List<Administrador>SelectAll(){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Administrador>administrador=session.createCriteria(Administrador.class).list();
        session.close();
        return administrador;
    }
    
    @Override
    public void insert(Administrador administrador){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(administrador);
        administrador.setIdAdmin(id);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void update(Administrador administrador){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(administrador);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void delate(Administrador administrador){
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(administrador);
        session.getTransaction().commit();
        session.close();
    }
}
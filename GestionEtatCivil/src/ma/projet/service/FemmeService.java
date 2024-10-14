/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Pc
 */
public class FemmeService implements IDao<Femme>{
    
    private Object entityManager;
     public Long nbrEnfantBetweenDates(Femme femme, Date dateDebut, Date dateFin) {
    Session session = null;
    Long nbrEnfant = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("nbrEnfantBetweenDates");
        query.setParameter("femmenom", femme.getNom());
        query.setParameter("startDate", dateDebut);
        query.setParameter("endDate", dateFin);
        nbrEnfant = (Long) query.uniqueResult();
    } catch (HibernateException e) {
        // Gérez l'exception comme nécessaire
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    return nbrEnfant;
}
     
 

    

    @Override
    
    public boolean create(Femme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    
    @Override
    public Femme getById(int id) {
        Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return femme;
    }

    @Override
    public List<Femme> getAll() {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return femmes;
    }

  // Méthode pour renvoyer le nombre d'enfants d'une femme entre deux dates
    public int countChildrenBetweenDates(Long femmeId, Date startDate, Date endDate) {
        // Code pour compter les enfants
        return 0;
    } 
}


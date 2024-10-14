/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;

public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {
    @Override
    public boolean create(LigneCommandeProduit ligneCommandeProduit) {
       Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(ligneCommandeProduit);
            tx.commit();
            return true;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            return false;
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public LigneCommandeProduit getById(int id) {
     
         LigneCommandeProduit ligneCommandeProduit = null;
        Session session = null;
        Transaction tx = null;
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduit = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            tx.commit();
            return ligneCommandeProduit;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            return ligneCommandeProduit;
        }
        finally{
            session.close();
        }
    }

   @Override
    public List<LigneCommandeProduit> getAll(){
        List<LigneCommandeProduit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from LigneCommandeProduit").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }

   
    
       
    }
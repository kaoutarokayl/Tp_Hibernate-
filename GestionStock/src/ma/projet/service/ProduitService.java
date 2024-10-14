/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;

public class ProduitService implements IDao<Produit> {
    @Override
    public boolean create(Produit produit) {
       Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(produit);
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
    public Produit getById(int id) {
       Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
            return produit;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            return produit;
        }
        finally{
            session.close();
        }
    }
    
    @Override
    public List<Produit> getAll() {
            List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
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

    public List<Produit> getProduitsAvecPrixSuperieur(double prixLimite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
       
    }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;

public class CommandeService implements IDao<Commande> {
    @Override
    public boolean create(Commande commande) {
         Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(commande);
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
    public Commande getById(int id) {
       Commande commandes = null;
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes = (Commande) session.get(Commande.class, id);
            tx.commit();
            return commandes;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            return commandes;
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<Commande> getAll() {
     List<Commande> commandes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commandes = session.createQuery("from Commande").list();
            tx.commit();
            return commandes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return commandes;
        } finally {
            if(session != null)
                session.close();
        }
    }

    public List<Produit> getProduitsParCommande(int commandeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produit> getProduitsEntreDates(Date dateDebut, Date dateFin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

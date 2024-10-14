
package ma.projet.service;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;

public class CategorieService implements IDao<Categorie> {
    @Override
    public boolean create(Categorie o) {
      Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
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

public Categorie getById(int id) {
      Categorie categories= null;
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories= (Categorie) session.get(Categorie.class, id);
            tx.commit();
            return categories;
        }
        catch(HibernateException ex){
            if(tx != null){
                tx.rollback();
            }
            return categories;
        }
        finally{
            session.close();
        }
    }
    

 @Override
public List<Categorie> getAll() {
    List<Categorie> categories = null; // Initialisation de la liste

    // Obtenez la session et démarrez une transaction
    Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories = session.createQuery("from Categories").list();
            tx.commit();
            return categories;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return categories;
        } finally {
            if(session != null)
                session.close();
        }
}
}

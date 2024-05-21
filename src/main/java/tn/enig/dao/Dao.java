package tn.enig.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tn.enig.model.Enseignant;

public class Dao {
	public ArrayList<Enseignant> LE = new ArrayList<Enseignant>();

	@PersistenceContext
	private EntityManager em;

	public Dao() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		em = sessionFactory.createEntityManager();
		System.out.println("test");
//		Enseignant E = new Enseignant("hammadi", "azaiez", "Software", "Senior");
//		addEnseignat(E);
//		E = new Enseignant("Mokhtar", "beca", "GCR", "Senior");
//		addEnseignat(E);
//		E = new Enseignant("achref", "Lachy", "Security", "Junior");
//		addEnseignat(E);
	}

	public void addEnseignat(Enseignant e) {
		EntityManager em = createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		System.out.println("done");
	}

	public Enseignant getEnsById(int id) {
		EntityManager em = createEntityManager();
		try {
			return em.find(Enseignant.class, (long) id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
	
	public List<Enseignant> getAllEnseignants() {
		EntityManager em = createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Enseignant e");
            List<Enseignant> enseignants = query.getResultList();
            em.getTransaction().commit();
            return enseignants;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
	
	public void remvoeEnseignat(int ide) {
		EntityManager em = createEntityManager();
		try {
			em.getTransaction().begin();
			Enseignant e=em.find(Enseignant.class,ide);
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		System.out.println("done");
	}
	
	private EntityManager createEntityManager() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory.createEntityManager();
    }


}

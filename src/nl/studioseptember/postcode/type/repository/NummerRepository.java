package nl.studioseptember.postcode.type.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import nl.studioseptember.postcode.type.Nummer;

@Repository
//@Transactional(readOnly = false)

public class NummerRepository {

	  @PersistenceContext
	  private EntityManager em;
	  
	  
	  private SessionFactory sessionFactory;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
		public void save(Nummer n) {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(n);
			tx.commit();
			session.close();
		}

	    
}

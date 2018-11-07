package nl.studioseptember.postcode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nl.studioseptember.postcode.type.Woonplaats;

public class Recaller {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		

		Session session = sessionFactory.openSession();

//		EntityManagerFactory entityManagerFactory = session.getEntityManagerFactory();
//		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Woonplaats w = session.get(Woonplaats.class, 1L);
		System.out.println(w);
	}

}

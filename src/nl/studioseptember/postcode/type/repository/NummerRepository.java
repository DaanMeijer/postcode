package nl.studioseptember.postcode.type.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
//@Transactional(readOnly = false)

public class NummerRepository {

	  @PersistenceContext
	  private EntityManager em;
	  
}

package nl.studioseptember.postcode.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lookups")
public class SimpleLookup {
	@Column(length = 6)
	String postcode;
	
	String huisnummer;
	
	@Id
	long id;
	
	
}

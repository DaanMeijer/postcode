package nl.studioseptember.postcode.type;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import nl.kadaster.schemas.imbag.imbag_types.v20090901.StatusNaamgeving;
import nl.kadaster.schemas.imbag.lvc.v20090901.Nummeraanduiding;

@Entity
@Table(name = "numbers")
public class Nummer extends Base {

	
	@Column(name = "number")
	private int nummer;
	
	@Column(name = "status")
	private StatusNaamgeving status;
	
	@Column(name = "suffix")
	private String toevoeging;
	
	@Column(name = "letter")
	private String letter;
	
	@Column(name = "postcode")
	private String postcode;

    @Column(name = "public_space_id")
	private Long openbareRuimteId;
	
    @Column(name = "city_id")
	private Long woonplaatsId;
		

	public Nummer(Nummeraanduiding nummer) {
		super(nummer);
		
		this.status = nummer.getNummeraanduidingStatus();
		this.postcode = nummer.getPostcode();
		this.nummer = nummer.getHuisnummer();
		this.toevoeging = nummer.getHuisnummertoevoeging();
		this.letter = nummer.getHuisletter();

		if(nummer.getGerelateerdeWoonplaats() != null) {
			this.woonplaatsId = (Long.parseLong(nummer.getGerelateerdeWoonplaats().getIdentificatie()));
		}
		if(nummer.getGerelateerdeOpenbareRuimte() != null) {
			this.openbareRuimteId = (Long.parseLong(nummer.getGerelateerdeOpenbareRuimte().getIdentificatie()));
		}
	}
	
	@Override
	public String toString() {
		String base = "";
//		if(this.woonplaats != null) {
//			base += this.woonplaats.getNaam() + " ";
//		}
//
//		if(this.openbareRuimte != null) {
//			base += this.openbareRuimte.getNaam() + " ";
//		}
		
		base += this.nummer;
		
		if(this.letter != null) {
			base += this.letter;
		}
		
		if(this.toevoeging != null) {
			base += "-"+this.toevoeging;
		}
		
		return base;
	}

}

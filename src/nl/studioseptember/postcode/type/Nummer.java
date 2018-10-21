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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "public_space_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private OpenbareRuimte openbareRuimte;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Woonplaats woonplaats;
	
		

	public Nummer(Nummeraanduiding nummer, Map<Long, Woonplaats> woonplaatsLookup, Map<Long, OpenbareRuimte> openbareRuimteLookup) {
		super(nummer);
		
		this.status = nummer.getNummeraanduidingStatus();
		this.postcode = nummer.getPostcode();
		this.nummer = nummer.getHuisnummer();
		this.toevoeging = nummer.getHuisnummertoevoeging();
		this.letter = nummer.getHuisletter();

		if(nummer.getGerelateerdeWoonplaats() != null) {
			this.woonplaats = woonplaatsLookup.get(Long.parseLong(nummer.getGerelateerdeWoonplaats().getIdentificatie()));
		}
		if(nummer.getGerelateerdeOpenbareRuimte() != null) {
			this.openbareRuimte = openbareRuimteLookup.get(Long.parseLong(nummer.getGerelateerdeOpenbareRuimte().getIdentificatie()));
		}
	}

}

package nl.studioseptember.postcode.type;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "public_spaces")
public class OpenbareRuimte extends Base {
	

	@Column(name = "status")
	private String status;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String naam;
	
	@Column(name = "short_name")
	private String korteNaam;
	
	@ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Woonplaats woonplaats;
	
	
	public OpenbareRuimte(nl.kadaster.schemas.imbag.lvc.v20090901.OpenbareRuimte openbareRuimte, Map<Long, Woonplaats> woonplaatsLookup) {
		
		super(openbareRuimte);
		
		this.naam = openbareRuimte.getOpenbareRuimteNaam();
		this.korteNaam = openbareRuimte.getVerkorteOpenbareruimteNaam();
		this.status = openbareRuimte.getOpenbareruimteStatus().value();
		this.type = openbareRuimte.getOpenbareRuimteType().value();

		this.woonplaats = woonplaatsLookup.get(Long.parseLong(openbareRuimte.getGerelateerdeWoonplaats().getIdentificatie()));
		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getKorteNaam() {
		return korteNaam;
	}
	public void setKorteNaam(String korteNaam) {
		this.korteNaam = korteNaam;
	}
	public Woonplaats getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(Woonplaats woonplaats) {
		this.woonplaats = woonplaats;
	}
}

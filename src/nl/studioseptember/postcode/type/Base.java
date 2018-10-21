package nl.studioseptember.postcode.type;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import nl.kadaster.schemas.imbag.imbag_types.v20090901.Bron;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Indicatie;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Tijdvakgeldigheid;

@MappedSuperclass
public abstract class Base {

	@Id
	@Column(name = "id")
	protected Long identificatie;
	
	@Column(name = "record_inactive")
    protected Boolean aanduidingRecordInactief;
	@Column(name = "record_correction")
    protected Integer aanduidingRecordCorrectie;
    
	@Column(name = "is_official")
    protected Boolean officieel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_from")
    protected Date begindatumTijdvakGeldigheid;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_to")
    protected Date einddatumTijdvakGeldigheid;
    
    @Column(name = "is_under_investigation")
    protected Boolean inOnderzoek;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "source_date")
    protected Date bronDatum;
    
    @Column(name = "source_number")
    protected String bronNummer;
    
    
    
    
    
    
    public Long getIdentificatie() {
		return identificatie;
	}
	public void setIdentificatie(Long identificatie) {
		this.identificatie = identificatie;
	}
	public Boolean getAanduidingRecordInactief() {
		return aanduidingRecordInactief;
	}
	public void setAanduidingRecordInactief(Boolean aanduidingRecordInactief) {
		this.aanduidingRecordInactief = aanduidingRecordInactief;
	}
	public Integer getAanduidingRecordCorrectie() {
		return aanduidingRecordCorrectie;
	}
	public void setAanduidingRecordCorrectie(Integer aanduidingRecordCorrectie) {
		this.aanduidingRecordCorrectie = aanduidingRecordCorrectie;
	}
	public Boolean getOfficieel() {
		return officieel;
	}
	public void setOfficieel(Boolean officieel) {
		this.officieel = officieel;
	}
	public Date getBegindatumTijdvakGeldigheid() {
		return begindatumTijdvakGeldigheid;
	}
	public void setBegindatumTijdvakGeldigheid(Date begindatumTijdvakGeldigheid) {
		this.begindatumTijdvakGeldigheid = begindatumTijdvakGeldigheid;
	}
	public Date getEinddatumTijdvakGeldigheid() {
		return einddatumTijdvakGeldigheid;
	}
	public void setEinddatumTijdvakGeldigheid(Date einddatumTijdvakGeldigheid) {
		this.einddatumTijdvakGeldigheid = einddatumTijdvakGeldigheid;
	}
	public Boolean getInOnderzoek() {
		return inOnderzoek;
	}
	public void setInOnderzoek(Boolean inOnderzoek) {
		this.inOnderzoek = inOnderzoek;
	}
	public Date getBronDatum() {
		return bronDatum;
	}
	public void setBronDatum(Date bronDatum) {
		this.bronDatum = bronDatum;
	}
	public String getBronNummer() {
		return bronNummer;
	}
	public void setBronNummer(String bronNummer) {
		this.bronNummer = bronNummer;
	}
	
	public Base(BaseInterface base) {
		this(
			Long.parseLong(base.getIdentificatie()),
	
			base.getAanduidingRecordInactief(),
			base.getAanduidingRecordCorrectie(),
	
			base.getOfficieel(),
	
			base.getTijdvakgeldigheid(),
	
			base.getInOnderzoek(),
	
			base.getBron()
		);
	}
	
	public Base(Long identificatie, 
			Indicatie inactief, BigInteger correctie, 
			Indicatie officieel, 
			Tijdvakgeldigheid tijdvakGeldigheid,
			Indicatie inOnderzoek,
			Bron bron
			) {
		this.identificatie = identificatie;
		
		this.aanduidingRecordInactief = inactief == Indicatie.J;
		this.aanduidingRecordCorrectie = correctie != null ? correctie.intValue() : 0;
		
		this.officieel = officieel == Indicatie.J;
		
		this.begindatumTijdvakGeldigheid = parseDate(tijdvakGeldigheid.getBegindatumTijdvakGeldigheid());
		this.einddatumTijdvakGeldigheid = parseDate(tijdvakGeldigheid.getEinddatumTijdvakGeldigheid());
		
		this.inOnderzoek = inOnderzoek == Indicatie.J;
		
		this.bronDatum = parseDate(bron.getDocumentdatum());
		this.bronNummer = bron.getDocumentnummer();
		
	}

    private static DateFormat[] dateFormats = new SimpleDateFormat[] {
        	new SimpleDateFormat("YYYYMMDDHHmmss"),
        	new SimpleDateFormat("YYYYMMDD"),
    };
    
    private static Date parseDate(String input) {
    	if(input == null) {
    		return null;
    	}
    	
    	for(DateFormat format: dateFormats) {
    		try {
    			return format.parse(input);
    		}catch(ParseException pe) {
    			//ignore a parsing exception
    		}
    	}
    	System.out.println("Not parsing '"+input+"'");
    	
    	return null;
    }
    
}

package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import net.opengis.gml.AbstractRingPropertyType;
import net.opengis.gml.DirectPositionListType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PointType;
import net.opengis.gml.PolygonType;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Gebruiksdoel;
import nl.kadaster.schemas.imbag.lvc.v20090901.Verblijfsobject;

@Entity
@Table(name = "accomodations")
public class VerblijfsObject extends Base {

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "object_id", 
		foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
	)
	@OrderColumn(name = "id", insertable = false, updatable = false)
	private List<Polygon> surface;
	
	private int oppervlakte;
	public int getOppervlakte() {
		return oppervlakte;
	}

	public void setOppervlakte(int oppervlakte) {
		this.oppervlakte = oppervlakte;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDoel() {
		return doel;
	}

	public void setDoel(String doel) {
		this.doel = doel;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	private String status;

	private String doel;

	private Double latitude = null;
	private Double longitude = null;
	private Double height = null;

//	@ManyToOne
	private Long adres = null;
	
	@ElementCollection
	private List<Long> number = new LinkedList<Long>();

	@ElementCollection
	private List<Long> accommodation = new LinkedList<Long>();

	public VerblijfsObject(Verblijfsobject base) throws IOException {
		super(base);
		
		this.status = base.getVerblijfsobjectStatus().value();
		this.oppervlakte = base.getOppervlakteVerblijfsobject();
		
		var gerelateerdeAdressen = base.getGerelateerdeAdressen();
		if(gerelateerdeAdressen != null) {
			var hoofdAdres = gerelateerdeAdressen.getHoofdadres();
			if(hoofdAdres != null) {
				var adresId = Long.parseLong(hoofdAdres.getIdentificatie());
				this.adres = adresId;
				this.number.add(adres);
				
				//this.adres = nummerLookup.get(Long.parseLong(hoofdAdres.getIdentificatie()));
				//this.adressen.add(this.adres);
			}
			
			for(var nevenAdres: gerelateerdeAdressen.getNevenadres()) {
				var adresId = Long.parseLong(nevenAdres.getIdentificatie());
				this.number.add(adresId);
//				this.adressen.add(nummerLookup.get(Long.parseLong(nevenAdres.getIdentificatie())));
			}
		}
		
		for(var pand: base.getGerelateerdPand()) {
			var pandId = Long.parseLong(pand.getIdentificatie());
			this.accommodation.add(pandId);
//			this.pand.add(pandLookup.get(Long.parseLong(pand.getIdentificatie())));
		}
		
		this.surface = new ArrayList<Polygon>();
		var geo = base.getVerblijfsobjectGeometrie();
		
		StringBuilder doelen = new StringBuilder();
		for(Gebruiksdoel doel: base.getGebruiksdoelVerblijfsobject()) {
			if(doelen.length() > 0) {
				doelen.append(",");
			}
			doelen.append(doel.value());
		}
		this.doel = doelen.toString();
		
		
		PointType punt = geo.getPoint();
		if(punt != null) {
			PolygonType type = new PolygonType();
			AbstractRingPropertyType ringType = new AbstractRingPropertyType();
			
			LinearRingType ring = new LinearRingType();
			var posList = new DirectPositionListType();
			
			posList.setCount(BigInteger.valueOf(1));
			posList.setSrsDimension(BigInteger.valueOf(3));
			var list = posList.getValue();
			list.addAll(punt.getPos().getValue());

			ring.setPosList(posList);
			var jaxb = new JAXBElement<LinearRingType>(new QName("nah"), LinearRingType.class, ring);
			ringType.setRing(jaxb);
			type.setExterior(ringType);
			//Polygon poly = new Polygon(type, this.identificatie);
			//surface.add(poly);
		}
		
		var geoSurface = geo.getSurface();
		if(geoSurface != null) {
			PolygonType type = (PolygonType) geoSurface.getValue();
			Polygon poly = new Polygon(type, this.identificatie);
			surface.add(poly);
		}
		
		if(surface.size() > 0) {
			this.latitude = 0.0;
			this.longitude = 0.0;
			this.height = 0.0;
			
			for(Polygon polygon: surface) {
				double latitude = 0, longitude = 0, height = 0;
				for(Point p: polygon.points) {
					latitude += p.getLatitude() / polygon.points.length;
					longitude += p.getLongitude() / polygon.points.length;
					height += p.getHeight() / polygon.points.length;
				}
				this.latitude += latitude / surface.size();
				this.longitude += longitude / surface.size();
				this.height += height / surface.size();
			}
//			System.out.println("Center: " + this.latitude + "," + this.longitude + "," + this.height);
		}
		
	}

}

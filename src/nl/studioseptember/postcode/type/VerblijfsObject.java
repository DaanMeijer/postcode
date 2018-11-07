package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import net.opengis.gml.CoordType;
import net.opengis.gml.PointType;
import net.opengis.gml.PolygonType;
import net.opengis.gml.SurfacePropertyType;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Gebruiksdoel;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.PuntOfVlak;
import nl.kadaster.schemas.imbag.lvc.v20090901.GerelateerdeAdressen;
import nl.kadaster.schemas.imbag.lvc.v20090901.Ligplaats;
import nl.kadaster.schemas.imbag.lvc.v20090901.Standplaats;
import nl.kadaster.schemas.imbag.lvc.v20090901.Verblijfsobject;
import nl.kadaster.schemas.imbag.lvc.v20090901.Verblijfsobject.GerelateerdPand;
import rdnaptrans.Transform;
import rdnaptrans.value.Cartesian;
import rdnaptrans.value.Geographic;

@Entity
@Table(name = "accomodations")
public class VerblijfsObject extends Base {

//	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "object_id", 
//		foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
//	)
//	@OrderColumn(name = "id", insertable = false, updatable = false)
	private Geometry surface;
	
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

	/*
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
	*/
	
	private com.vividsolutions.jts.geom.Point point;

	private String status;

	private String doel;

//	private Double latitude = null;
//	private Double longitude = null;
//	private Double height = null;

//	@ManyToOne
	private Long adres = null;
	
	@ElementCollection
	private List<Long> number = new LinkedList<Long>();

	@ElementCollection
	private List<Long> accommodation = new LinkedList<Long>();
	
	static enum ObjectType {
		VerblijfsObject,
		Standplaats,
		Ligplaats
	}
	
	private ObjectType type;

	public VerblijfsObject(Verblijfsobject base) throws IOException {
		super(base);

		this.type = ObjectType.VerblijfsObject;
		
		this.status = base.getVerblijfsobjectStatus().value();
		this.oppervlakte = base.getOppervlakteVerblijfsobject();
				
		this.setGerelateerdeAdressen(base.getGerelateerdeAdressen());
		this.setGerelateerdePanden(base.getGerelateerdPand());
				
		this.setDoelen(base.getGebruiksdoelVerblijfsobject());
		var geo = base.getVerblijfsobjectGeometrie();
		var geoSurface = geo.getSurface();
		
		if(geoSurface != null) {
			this.setSurface((PolygonType)geoSurface.getValue());
		}
		PointType punt = geo.getPoint();
		if(punt != null) {
			this.setPoint(punt);
		}
		
		
	}
	
	public VerblijfsObject(Ligplaats base) throws IOException {
		super(base);
		
		this.type = ObjectType.Ligplaats;
		
		this.status = base.getLigplaatsStatus().value();
		this.oppervlakte = 0;
				
		this.setGerelateerdeAdressen(base.getGerelateerdeAdressen());
				
		this.setSurface(base.getLigplaatsGeometrie());
	}

	public VerblijfsObject(Standplaats base) throws IOException {
		super(base);

		this.type = ObjectType.Standplaats;
		
		this.status = base.getStandplaatsStatus().value();
		this.oppervlakte = 0;
				
		this.setGerelateerdeAdressen(base.getGerelateerdeAdressen());
				
		this.setSurface(base.getStandplaatsGeometrie());
	}

	
	private void setGerelateerdeAdressen(GerelateerdeAdressen gerelateerdeAdressen) {
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
	}
	
	private void setGerelateerdePanden(List<GerelateerdPand> panden) {
		for(var pand: panden) {
			var pandId = Long.parseLong(pand.getIdentificatie());
			this.accommodation.add(pandId);
//			this.pand.add(pandLookup.get(Long.parseLong(pand.getIdentificatie())));
		}
	}
	
	private void setDoelen(List<Gebruiksdoel> listDoelen) {
		StringBuilder doelen = new StringBuilder();
		for(Gebruiksdoel doel: listDoelen) {
			if(doelen.length() > 0) {
				doelen.append(",");
			}
			doelen.append(doel.value());
		}
		this.doel = doelen.toString();
	}
	
	private void setSurface(SurfacePropertyType ligplaatsGeometrie) throws IOException {
		this.setSurface((PolygonType)ligplaatsGeometrie.getSurface().getValue());
	}
	
	private void setSurface(PolygonType geoSurface) throws IOException {
		var surface = new ArrayList<Polygon>();
		Polygon poly = nl.studioseptember.postcode.type.Polygon.fromPositions(geoSurface);
		
		surface.add(poly);
		this.surface = factory.buildGeometry(surface); 
	}
	
	private void setPoint(PointType punt) throws IOException {
		Cartesian c = null;
		

		CoordType coord = punt.getCoord();
		if(coord != null) {
			c = new Cartesian(
				coord.getX().intValue(), 
				coord.getY().intValue(), 
				coord.getZ().intValue()
			);
		}else if(punt.getPos() != null) {
			var pos = punt.getPos();
			var pointList = pos.getValue();
			
			if(pointList.size() > 2) {
				c = new Cartesian(
						pointList.get(0), 
						pointList.get(1), 
						pointList.get(2)
						);
			}else {
				c = new Cartesian(
						pointList.get(0), 
						pointList.get(1)
						);
			}
		}
		if(c != null) {
			Geographic g = Transform.rdnap2etrs(c);
			this.point = factory.createPoint(new Coordinate(g.phi, g.lambda, g.h));
		}
	}
	
	private static GeometryFactory factory = new GeometryFactory();

}

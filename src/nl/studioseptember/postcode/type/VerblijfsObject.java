package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import net.opengis.gml.AbstractRingPropertyType;
import net.opengis.gml.DirectPositionListType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PointType;
import net.opengis.gml.PolygonType;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Gebruiksdoel;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.StatusVerblijfsobject;
import nl.kadaster.schemas.imbag.lvc.v20090901.Verblijfsobject;

public class VerblijfsObject extends Base {

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "object_id", 
		foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
	)
	@OrderColumn(name = "id", insertable = false, updatable = false)
	private List<Polygon> surface;
	
	private int oppervlakte;
	private StatusVerblijfsobject status;

	private List<Gebruiksdoel> doel;

	public VerblijfsObject(Verblijfsobject base) throws IOException {
		super(base);
		
		this.status = base.getVerblijfsobjectStatus();
		this.oppervlakte = base.getOppervlakteVerblijfsobject();
		
		this.surface = new ArrayList<Polygon>();
		var geo = base.getVerblijfsobjectGeometrie();
		this.doel = base.getGebruiksdoelVerblijfsobject();
		
		
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
			Polygon poly = new Polygon(type, this.identificatie);
			surface.add(poly);
		}
		
		var geoSurface = geo.getSurface();
		if(geoSurface != null) {
			PolygonType type = (PolygonType) geoSurface.getValue();
			Polygon poly = new Polygon(type, this.identificatie);
			surface.add(poly);
		}
		
	}

}

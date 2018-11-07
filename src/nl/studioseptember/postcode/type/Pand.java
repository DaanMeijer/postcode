package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.impl.PackedCoordinateSequenceFactory;

import net.opengis.gml.AbstractRingType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PolygonType;
import net.opengis.gml.SurfacePropertyType;

@Entity
@Table(name = "building")
public class Pand extends Base {

	private int bouwjaar;
	private String status;

//	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "object_id", 
//		foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
//	)
//	@OrderColumn(name = "id", insertable = false, updatable = false)
	private Geometry surface;
	
	private static GeometryFactory factory = new GeometryFactory();
	private static PackedCoordinateSequenceFactory seqFactory = new PackedCoordinateSequenceFactory();
	
	public Pand(nl.kadaster.schemas.imbag.lvc.v20090901.Pand base) throws IOException {
		super(base);
		
		this.bouwjaar = base.getBouwjaar();
		this.status = base.getPandstatus();
		
		
		SurfacePropertyType pandGeometrie = base.getPandGeometrie();
		if (pandGeometrie != null) {

			List<PolygonType> polygons = new LinkedList<PolygonType>();

			polygons.add((PolygonType) pandGeometrie.getSurface().getValue());

			var surface = new ArrayList<Polygon>(polygons.size());

			for (var a = 0; a < polygons.size(); a++) {
				
				var polygon = polygons.get(a);
				
				surface.add(nl.studioseptember.postcode.type.Polygon.fromPositions(polygon));
//				AbstractRingType abstractRing = polygon.getExterior().getRing().getValue();
//				LinearRingType linearRing = (LinearRingType) abstractRing; 
//				
//				var positions = linearRing.getPosList().getValue();
//				
//				double[] target = new double[positions.size()];
//				for (int i = 0; i < target.length; i++) {
//					target[i] = positions.get(i);                // java 1.5+ style (outboxing)
//				}
//				 
//				CoordinateSequence coordinates = seqFactory.create(target, linearRing.getPosList().getSrsDimension().intValue());
//				
//				surface.add(a, factory.createPolygon(coordinates));
			}
			
			this.surface = factory.buildGeometry(surface);
		}
		
	}

}

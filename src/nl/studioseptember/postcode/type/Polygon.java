package nl.studioseptember.postcode.type;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequenceFactory;

import net.opengis.gml.AbstractRingType;
import net.opengis.gml.DirectPositionListType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PolygonType;
import rdnaptrans.Transform;
import rdnaptrans.value.Cartesian;

//@Entity
//@Table(name = "polygons")

//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)

public class Polygon extends com.vividsolutions.jts.geom.Polygon {
	
	public Polygon(LinearRing shell, LinearRing[] holes, GeometryFactory factory) {
		super(shell, holes, factory);
	}
	
	public static com.vividsolutions.jts.geom.Polygon fromPositions(PolygonType polygon) throws IOException{
		
		AbstractRingType abstractRing = polygon.getExterior().getRing().getValue();
		LinearRingType linearRing = (LinearRingType) abstractRing; 
		
		var positions = linearRing.getPosList();
		return Polygon.fromPositions(positions);

	}
	
	public static com.vividsolutions.jts.geom.Polygon fromPositions(DirectPositionListType positions) throws IOException {
		
		var doubles = positions.getValue();
		var pointDims = positions.getSrsDimension().intValue();
		var pointCount = positions.getCount().intValue();

		Coordinate[] coordinates = new Coordinate[pointCount];
		
		for(var a = 0; a < pointCount; a++) {
			var coord = new Cartesian(doubles.get(a * pointDims), doubles.get(a * pointDims + 1));
			if(pointDims > 2) {
				coord = coord.withZ(doubles.get(a * pointDims+2));
			}
			var geographic = Transform.rdnap2etrs(coord);
			coordinates[a] = new Coordinate(geographic.lambda, geographic.phi/*, geographic.h*/);
		}
		
		return factory.createPolygon(coordinates);
		
	}


	private static GeometryFactory factory = new GeometryFactory();
	private static CoordinateArraySequenceFactory seqFactory = CoordinateArraySequenceFactory.instance(); 
	
	/*
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
    private long id;
	
	private static long nextId = 1;

	@Column(name = "object_id")
	private Long objectId;
	
	public Polygon(Long objectId) {

		this.id = nextId++;
		this.objectId = objectId;
		
	}
	
	public Polygon(PolygonType polygon, Long objectId) throws IOException {

		
		this(objectId);
		
		AbstractRingType abstractRing = polygon.getExterior().getRing().getValue();
		LinearRingType linearRing = (LinearRingType) abstractRing; 
		
		var positions = linearRing.getPosList();
		this.setPositions(positions);

	}
	*/

//	public void setPositions(DirectPositionListType positions) throws IOException {
//		var doubles = positions.getValue();
//		var pointDims = positions.getSrsDimension().intValue();
//		var pointCount = positions.getCount().intValue();
//		
//		this.points = new Point[pointCount];
//		
//		for(var a = 0; a < pointCount; a++) {
//			var coord = new Cartesian(doubles.get(a * pointDims), doubles.get(a * pointDims + 1));
//			if(pointDims > 2) {
//				coord = coord.withZ(doubles.get(a * pointDims+2));
//			}
//			this.points[a] = new Point(Transform.rdnap2etrs(coord), this.id);
//		}
//	}
	

//	@Transient
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//	@JoinColumn(name = "polygonId")
//	@OrderColumn(name = "id", insertable = false, updatable = false)
//	Point[] points;
}

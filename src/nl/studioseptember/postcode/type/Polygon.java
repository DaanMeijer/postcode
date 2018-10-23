package nl.studioseptember.postcode.type;

import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import net.opengis.gml.AbstractRingType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PolygonType;
import rdnaptrans.Transform;
import rdnaptrans.value.Cartesian;

@Entity
@Table(name = "polygons")

//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)

public class Polygon {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "seq"*/)	
	@Column(name = "id"/*, insertable = false, updatable = false, nullable = false*/)
    private long id;
	
	private static long nextId = 1;

	@Column(name = "object_id")
	private Long objectId;
	
	public Polygon(PolygonType polygon, Long objectId) throws IOException {

		this.id = nextId++;
		
		this.objectId = objectId;
		AbstractRingType abstractRing = polygon.getExterior().getRing().getValue();
		LinearRingType linearRing = (LinearRingType) abstractRing; 
		
		var positions = linearRing.getPosList();
		
		
		var doubles = positions.getValue();
		var pointDims = positions.getSrsDimension().intValue();
		var pointCount = positions.getCount().intValue();
		
		this.points = new Point[pointCount];
		
		for(var a = 0; a < pointCount; a++) {
			var coord = new Cartesian(doubles.get(a * pointDims), doubles.get(a * pointDims + 1));
			if(pointDims > 2) {
				coord = coord.withZ(doubles.get(a * pointDims+2));
			}
			this.points[a] = new Point(Transform.rdnap2etrs(coord), this.id);
		}

	}

//	@Transient
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "polygonId")
	@OrderColumn(name = "id", insertable = false, updatable = false)
	Point[] points;
}

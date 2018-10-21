package nl.studioseptember.postcode.type;

import java.io.IOException;

import net.opengis.gml.AbstractRingType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.PolygonType;
import rdnaptrans.Transform;
import rdnaptrans.value.Cartesian;
import rdnaptrans.value.Geographic;

public class Polygon {
	public Polygon(PolygonType polygon) throws IOException {
		AbstractRingType abstractRing = polygon.getExterior().getRing().getValue();
		LinearRingType linearRing = (LinearRingType) abstractRing; 
		
		var positions = linearRing.getPosList();
		
		
		var doubles = positions.getValue();
		var pointDims = positions.getSrsDimension().intValue();
		var pointCount = positions.getCount().intValue();
		
		this.points = new Geographic[pointCount];
		
		for(var a = 0; a < pointCount; a++) {
			var coord = new Cartesian(doubles.get(a * pointDims), doubles.get(a * pointDims + 1));
			if(pointDims > 2) {
				coord = coord.withZ(doubles.get(a * pointDims+2));
			}
			this.points[a] = Transform.rdnap2etrs(coord);
		}

	}

	Geographic[] points;
}

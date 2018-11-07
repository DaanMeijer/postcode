package nl.studioseptember.postcode.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import rdnaptrans.value.Geographic;

//@Entity
//@Table(name = "points")
public class Point {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	private static long nextId = 1;

	@Column(name = "polygon_id")
	private Long polygonId;
	
	
	private double latitude;
	private double longitude;
	private double height;
	
	public Point(Geographic g, Long polygonId) {

		this.latitude = g.lambda;
		this.longitude = g.phi;
		this.height = g.h;
		
		this.polygonId = polygonId;
		
		this.id = nextId++;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}

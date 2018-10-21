package nl.studioseptember.postcode.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import rdnaptrans.value.Geographic;

@Entity
@Table(name = "points")
public class Point {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "polygon_id")
	private Long polygonId;
	
	
	private double latitude;
	private double longitude;
	private double height;
	
	public Point(Geographic g) {
		this.latitude = g.lambda;
		this.longitude = g.phi;
		this.height = g.h;
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

package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import net.opengis.gml.PolygonType;
import net.opengis.gml.SurfacePropertyType;

@Entity
@Table(name = "building")
public class Pand extends Base {

	private int bouwjaar;
	private String status;

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "object_id", 
		foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
	)
	@OrderColumn(name = "id", insertable = false, updatable = false)
	private List<Polygon> surface;
	
	public Pand(nl.kadaster.schemas.imbag.lvc.v20090901.Pand base) throws IOException {
		super(base);
		
		this.bouwjaar = base.getBouwjaar();
		this.status = base.getPandstatus();
		
		
		SurfacePropertyType pandGeometrie = base.getPandGeometrie();
		if (pandGeometrie != null) {

			List<PolygonType> polygons = new LinkedList<PolygonType>();

			polygons.add((PolygonType) pandGeometrie.getSurface().getValue());

			this.surface = new ArrayList<Polygon>(polygons.size());

			for (var a = 0; a < polygons.size(); a++) {
				this.surface.add(a, new Polygon(polygons.get(a), this.identificatie));
			}
		}
		
	}

}

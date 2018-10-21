package nl.studioseptember.postcode.type;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.JAXBElement;

import net.opengis.gml.AbstractSurfaceType;
import net.opengis.gml.MultiSurfaceType;
import net.opengis.gml.PolygonType;
import net.opengis.gml.SurfaceArrayPropertyType;
import net.opengis.gml.SurfacePropertyType;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.VlakOfMultiVlak;

@Entity 
@Table(name = "cities")
public class Woonplaats extends Base {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "object_id")
	@OrderColumn(name = "id")
	private Polygon[] surface;
	
	@Column(name = "name")
	private String naam;

	public Polygon[] getSurface() {
		return surface;
	}

	public void setSurface(Polygon[] surface) {
		this.surface = surface;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Woonplaats(nl.kadaster.schemas.imbag.lvc.v20090901.Woonplaats woonplaats) throws IOException {

		super(woonplaats);
		
		this.setNaam(woonplaats.getWoonplaatsNaam());

		VlakOfMultiVlak woonplaatsGeometrie = woonplaats.getWoonplaatsGeometrie();
		if (woonplaatsGeometrie != null) {

			List<PolygonType> polygons = new LinkedList<PolygonType>();

			MultiSurfaceType multiSurface = woonplaatsGeometrie.getMultiSurface();
			if (multiSurface == null) {
				multiSurface = new MultiSurfaceType();
				SurfaceArrayPropertyType members = new SurfaceArrayPropertyType();
				multiSurface.setSurfaceMembers(members);
				multiSurface.getSurfaceMembers().getSurface().add(woonplaatsGeometrie.getSurface());
			}

			if (multiSurface != null) {
				if (multiSurface.getSurfaceMember() != null) {
					for (SurfacePropertyType surfaceProperty : multiSurface.getSurfaceMember()) {
						AbstractSurfaceType value = surfaceProperty.getSurface().getValue();
						PolygonType polygon = (PolygonType) value;
						polygons.add(polygon);
					}
				}
				if (multiSurface.getSurfaceMembers() != null) {

					for (JAXBElement<? extends AbstractSurfaceType> element : multiSurface.getSurfaceMembers()
							.getSurface()) {
						AbstractSurfaceType value = element.getValue();
						PolygonType polygon = (PolygonType) value;
						polygons.add(polygon);
					}
				}
			}

			this.surface = new Polygon[polygons.size()];

			for (var a = 0; a < polygons.size(); a++) {
				this.surface[a] = new Polygon(polygons.get(a), this.identificatie);
			}
		}

	}
}

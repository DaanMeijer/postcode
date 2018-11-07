package nl.studioseptember.postcode.type;

import java.util.List;

import nl.kadaster.schemas.imbag.imbag_types.v20090901.Gebruiksdoel;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.PuntOfVlak;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.StatusVerblijfsobject;
import nl.kadaster.schemas.imbag.lvc.v20090901.GerelateerdeAdressen;
import nl.kadaster.schemas.imbag.lvc.v20090901.Verblijfsobject.GerelateerdPand;

public interface VerblijfsobjectInterface extends BaseInterface {

	StatusVerblijfsobject getVerblijfsobjectStatus();

	int getOppervlakteVerblijfsobject();

	GerelateerdeAdressen getGerelateerdeAdressen();

	List<GerelateerdPand> getGerelateerdPand();

	List<Gebruiksdoel> getGebruiksdoelVerblijfsobject();

	PuntOfVlak getVerblijfsobjectGeometrie();

}

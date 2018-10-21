package nl.studioseptember.postcode.type;

import java.math.BigInteger;

import nl.kadaster.schemas.imbag.imbag_types.v20090901.Bron;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Indicatie;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Tijdvakgeldigheid;

public interface BaseInterface {

	String getIdentificatie();

	Indicatie getAanduidingRecordInactief();

	BigInteger getAanduidingRecordCorrectie();

	Indicatie getOfficieel();

	Tijdvakgeldigheid getTijdvakgeldigheid();

	Indicatie getInOnderzoek();

	Bron getBron();

}

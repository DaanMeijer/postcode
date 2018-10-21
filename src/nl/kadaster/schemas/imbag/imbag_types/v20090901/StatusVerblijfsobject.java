//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.20 at 11:46:10 AM CEST 
//


package nl.kadaster.schemas.imbag.imbag_types.v20090901;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusVerblijfsobject.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusVerblijfsobject"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Verblijfsobject gevormd"/&gt;
 *     &lt;enumeration value="Niet gerealiseerd verblijfsobject"/&gt;
 *     &lt;enumeration value="Verblijfsobject in gebruik (niet ingemeten)"/&gt;
 *     &lt;enumeration value="Verblijfsobject in gebruik"/&gt;
 *     &lt;enumeration value="Verblijfsobject ingetrokken"/&gt;
 *     &lt;enumeration value="Verblijfsobject buiten gebruik"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StatusVerblijfsobject")
@XmlEnum
public enum StatusVerblijfsobject {

    @XmlEnumValue("Verblijfsobject gevormd")
    VERBLIJFSOBJECT_GEVORMD("Verblijfsobject gevormd"),
    @XmlEnumValue("Niet gerealiseerd verblijfsobject")
    NIET_GEREALISEERD_VERBLIJFSOBJECT("Niet gerealiseerd verblijfsobject"),
    @XmlEnumValue("Verblijfsobject in gebruik (niet ingemeten)")
    VERBLIJFSOBJECT_IN_GEBRUIK_NIET_INGEMETEN("Verblijfsobject in gebruik (niet ingemeten)"),
    @XmlEnumValue("Verblijfsobject in gebruik")
    VERBLIJFSOBJECT_IN_GEBRUIK("Verblijfsobject in gebruik"),
    @XmlEnumValue("Verblijfsobject ingetrokken")
    VERBLIJFSOBJECT_INGETROKKEN("Verblijfsobject ingetrokken"),
    @XmlEnumValue("Verblijfsobject buiten gebruik")
    VERBLIJFSOBJECT_BUITEN_GEBRUIK("Verblijfsobject buiten gebruik");
    private final String value;

    StatusVerblijfsobject(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusVerblijfsobject fromValue(String v) {
        for (StatusVerblijfsobject c: StatusVerblijfsobject.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

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
 * <p>Java class for Gebruiksdoel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Gebruiksdoel"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="woonfunctie"/&gt;
 *     &lt;enumeration value="bijeenkomstfunctie"/&gt;
 *     &lt;enumeration value="celfunctie"/&gt;
 *     &lt;enumeration value="gezondheidszorgfunctie"/&gt;
 *     &lt;enumeration value="industriefunctie"/&gt;
 *     &lt;enumeration value="kantoorfunctie"/&gt;
 *     &lt;enumeration value="logiesfunctie"/&gt;
 *     &lt;enumeration value="onderwijsfunctie"/&gt;
 *     &lt;enumeration value="sportfunctie"/&gt;
 *     &lt;enumeration value="winkelfunctie"/&gt;
 *     &lt;enumeration value="overige gebruiksfunctie"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Gebruiksdoel")
@XmlEnum
public enum Gebruiksdoel {

    @XmlEnumValue("woonfunctie")
    WOONFUNCTIE("woonfunctie"),
    @XmlEnumValue("bijeenkomstfunctie")
    BIJEENKOMSTFUNCTIE("bijeenkomstfunctie"),
    @XmlEnumValue("celfunctie")
    CELFUNCTIE("celfunctie"),
    @XmlEnumValue("gezondheidszorgfunctie")
    GEZONDHEIDSZORGFUNCTIE("gezondheidszorgfunctie"),
    @XmlEnumValue("industriefunctie")
    INDUSTRIEFUNCTIE("industriefunctie"),
    @XmlEnumValue("kantoorfunctie")
    KANTOORFUNCTIE("kantoorfunctie"),
    @XmlEnumValue("logiesfunctie")
    LOGIESFUNCTIE("logiesfunctie"),
    @XmlEnumValue("onderwijsfunctie")
    ONDERWIJSFUNCTIE("onderwijsfunctie"),
    @XmlEnumValue("sportfunctie")
    SPORTFUNCTIE("sportfunctie"),
    @XmlEnumValue("winkelfunctie")
    WINKELFUNCTIE("winkelfunctie"),
    @XmlEnumValue("overige gebruiksfunctie")
    OVERIGE_GEBRUIKSFUNCTIE("overige gebruiksfunctie");
    private final String value;

    Gebruiksdoel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Gebruiksdoel fromValue(String v) {
        for (Gebruiksdoel c: Gebruiksdoel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

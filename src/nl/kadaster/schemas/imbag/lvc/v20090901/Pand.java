//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.20 at 11:46:10 AM CEST 
//


package nl.kadaster.schemas.imbag.lvc.v20090901;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.SurfacePropertyType;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Bron;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Indicatie;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Tijdvakgeldigheid;


/**
 * Een PAND is de kleinste, bij de totstandkoming functioneel en
 * 
 * bouwkundig constructief zelfstandige eenheid, die direct en
 * 
 * duurzaam met de aarde is verbonden.
 * 
 * <p>Java class for Pand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pand"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Objectnummer"/&gt;
 *         &lt;element name="aanduidingRecordInactief" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="aanduidingRecordCorrectie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}indicatieCorrectie"/&gt;
 *         &lt;element name="officieel" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="pandGeometrie" type="{http://www.opengis.net/gml}SurfacePropertyType"/&gt;
 *         &lt;element name="bouwjaar" type="{http://www.kadaster.nl/schemas/imbag/lvc/v20090901}Bouwjaar"/&gt;
 *         &lt;element name="pandstatus" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}StatusPand"/&gt;
 *         &lt;element name="tijdvakgeldigheid" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Tijdvakgeldigheid"/&gt;
 *         &lt;element name="inOnderzoek" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="bron" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Bron"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pand", propOrder = {
    "identificatie",
    "aanduidingRecordInactief",
    "aanduidingRecordCorrectie",
    "officieel",
    "pandGeometrie",
    "bouwjaar",
    "pandstatus",
    "tijdvakgeldigheid",
    "inOnderzoek",
    "bron"
})
public class Pand {

    @XmlElement(required = true)
    protected String identificatie;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie aanduidingRecordInactief;
    @XmlElement(required = true)
    protected BigInteger aanduidingRecordCorrectie;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie officieel;
    @XmlElement(required = true)
    protected SurfacePropertyType pandGeometrie;
    @XmlSchemaType(name = "integer")
    protected int bouwjaar;
    @XmlElement(required = true)
    protected String pandstatus;
    @XmlElement(required = true)
    protected Tijdvakgeldigheid tijdvakgeldigheid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie inOnderzoek;
    @XmlElement(required = true)
    protected Bron bron;

    /**
     * Gets the value of the identificatie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificatie() {
        return identificatie;
    }

    /**
     * Sets the value of the identificatie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificatie(String value) {
        this.identificatie = value;
    }

    /**
     * Gets the value of the aanduidingRecordInactief property.
     * 
     * @return
     *     possible object is
     *     {@link Indicatie }
     *     
     */
    public Indicatie getAanduidingRecordInactief() {
        return aanduidingRecordInactief;
    }

    /**
     * Sets the value of the aanduidingRecordInactief property.
     * 
     * @param value
     *     allowed object is
     *     {@link Indicatie }
     *     
     */
    public void setAanduidingRecordInactief(Indicatie value) {
        this.aanduidingRecordInactief = value;
    }

    /**
     * Gets the value of the aanduidingRecordCorrectie property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAanduidingRecordCorrectie() {
        return aanduidingRecordCorrectie;
    }

    /**
     * Sets the value of the aanduidingRecordCorrectie property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAanduidingRecordCorrectie(BigInteger value) {
        this.aanduidingRecordCorrectie = value;
    }

    /**
     * Gets the value of the officieel property.
     * 
     * @return
     *     possible object is
     *     {@link Indicatie }
     *     
     */
    public Indicatie getOfficieel() {
        return officieel;
    }

    /**
     * Sets the value of the officieel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Indicatie }
     *     
     */
    public void setOfficieel(Indicatie value) {
        this.officieel = value;
    }

    /**
     * Gets the value of the pandGeometrie property.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getPandGeometrie() {
        return pandGeometrie;
    }

    /**
     * Sets the value of the pandGeometrie property.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setPandGeometrie(SurfacePropertyType value) {
        this.pandGeometrie = value;
    }

    /**
     * Gets the value of the bouwjaar property.
     * 
     */
    public int getBouwjaar() {
        return bouwjaar;
    }

    /**
     * Sets the value of the bouwjaar property.
     * 
     */
    public void setBouwjaar(int value) {
        this.bouwjaar = value;
    }

    /**
     * Gets the value of the pandstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPandstatus() {
        return pandstatus;
    }

    /**
     * Sets the value of the pandstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPandstatus(String value) {
        this.pandstatus = value;
    }

    /**
     * Gets the value of the tijdvakgeldigheid property.
     * 
     * @return
     *     possible object is
     *     {@link Tijdvakgeldigheid }
     *     
     */
    public Tijdvakgeldigheid getTijdvakgeldigheid() {
        return tijdvakgeldigheid;
    }

    /**
     * Sets the value of the tijdvakgeldigheid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tijdvakgeldigheid }
     *     
     */
    public void setTijdvakgeldigheid(Tijdvakgeldigheid value) {
        this.tijdvakgeldigheid = value;
    }

    /**
     * Gets the value of the inOnderzoek property.
     * 
     * @return
     *     possible object is
     *     {@link Indicatie }
     *     
     */
    public Indicatie getInOnderzoek() {
        return inOnderzoek;
    }

    /**
     * Sets the value of the inOnderzoek property.
     * 
     * @param value
     *     allowed object is
     *     {@link Indicatie }
     *     
     */
    public void setInOnderzoek(Indicatie value) {
        this.inOnderzoek = value;
    }

    /**
     * Gets the value of the bron property.
     * 
     * @return
     *     possible object is
     *     {@link Bron }
     *     
     */
    public Bron getBron() {
        return bron;
    }

    /**
     * Sets the value of the bron property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bron }
     *     
     */
    public void setBron(Bron value) {
        this.bron = value;
    }

}

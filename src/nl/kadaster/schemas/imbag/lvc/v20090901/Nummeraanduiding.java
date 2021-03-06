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
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Bron;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Indicatie;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.StatusNaamgeving;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.Tijdvakgeldigheid;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.TypeAdresseerbaarObject;
import nl.studioseptember.postcode.type.BaseInterface;


/**
 * Een NUMMERAANDUIDING is een door de gemeenteraad als
 * 
 * zodanig toegekende aanduiding van een adresseerbaar object.
 * 
 * <p>Java class for Nummeraanduiding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Nummeraanduiding"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Objectnummer"/&gt;
 *         &lt;element name="aanduidingRecordInactief" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="aanduidingRecordCorrectie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}indicatieCorrectie"/&gt;
 *         &lt;element name="huisnummer" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Huisnummer"/&gt;
 *         &lt;element name="officieel" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="huisletter" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Huisletter" minOccurs="0"/&gt;
 *         &lt;element name="huisnummertoevoeging" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Huisnummertoevoeging" minOccurs="0"/&gt;
 *         &lt;element name="postcode" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Postcode" minOccurs="0"/&gt;
 *         &lt;element name="tijdvakgeldigheid" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Tijdvakgeldigheid"/&gt;
 *         &lt;element name="inOnderzoek" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Indicatie"/&gt;
 *         &lt;element name="typeAdresseerbaarObject" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}TypeAdresseerbaarObject"/&gt;
 *         &lt;element name="bron" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Bron"/&gt;
 *         &lt;element name="nummeraanduidingStatus" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}StatusNaamgeving"/&gt;
 *         &lt;element name="gerelateerdeOpenbareRuimte"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Objectnummer"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="gerelateerdeWoonplaats" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Woonplaatscode"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Nummeraanduiding", propOrder = {
    "identificatie",
    "aanduidingRecordInactief",
    "aanduidingRecordCorrectie",
    "huisnummer",
    "officieel",
    "huisletter",
    "huisnummertoevoeging",
    "postcode",
    "tijdvakgeldigheid",
    "inOnderzoek",
    "typeAdresseerbaarObject",
    "bron",
    "nummeraanduidingStatus",
    "gerelateerdeOpenbareRuimte",
    "gerelateerdeWoonplaats"
})
public class Nummeraanduiding implements BaseInterface {

    @XmlElement(required = true)
    protected String identificatie;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie aanduidingRecordInactief;
    @XmlElement(required = true)
    protected BigInteger aanduidingRecordCorrectie;
    @XmlSchemaType(name = "integer")
    protected int huisnummer;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie officieel;
    protected String huisletter;
    protected String huisnummertoevoeging;
    protected String postcode;
    @XmlElement(required = true)
    protected Tijdvakgeldigheid tijdvakgeldigheid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Indicatie inOnderzoek;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TypeAdresseerbaarObject typeAdresseerbaarObject;
    @XmlElement(required = true)
    protected Bron bron;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected StatusNaamgeving nummeraanduidingStatus;
    @XmlElement(required = true)
    protected Nummeraanduiding.GerelateerdeOpenbareRuimte gerelateerdeOpenbareRuimte;
    protected Nummeraanduiding.GerelateerdeWoonplaats gerelateerdeWoonplaats;

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
     * Gets the value of the huisnummer property.
     * 
     */
    public int getHuisnummer() {
        return huisnummer;
    }

    /**
     * Sets the value of the huisnummer property.
     * 
     */
    public void setHuisnummer(int value) {
        this.huisnummer = value;
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
     * Gets the value of the huisletter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHuisletter() {
        return huisletter;
    }

    /**
     * Sets the value of the huisletter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHuisletter(String value) {
        this.huisletter = value;
    }

    /**
     * Gets the value of the huisnummertoevoeging property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHuisnummertoevoeging() {
        return huisnummertoevoeging;
    }

    /**
     * Sets the value of the huisnummertoevoeging property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHuisnummertoevoeging(String value) {
        this.huisnummertoevoeging = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
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
     * Gets the value of the typeAdresseerbaarObject property.
     * 
     * @return
     *     possible object is
     *     {@link TypeAdresseerbaarObject }
     *     
     */
    public TypeAdresseerbaarObject getTypeAdresseerbaarObject() {
        return typeAdresseerbaarObject;
    }

    /**
     * Sets the value of the typeAdresseerbaarObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeAdresseerbaarObject }
     *     
     */
    public void setTypeAdresseerbaarObject(TypeAdresseerbaarObject value) {
        this.typeAdresseerbaarObject = value;
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

    /**
     * Gets the value of the nummeraanduidingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusNaamgeving }
     *     
     */
    public StatusNaamgeving getNummeraanduidingStatus() {
        return nummeraanduidingStatus;
    }

    /**
     * Sets the value of the nummeraanduidingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusNaamgeving }
     *     
     */
    public void setNummeraanduidingStatus(StatusNaamgeving value) {
        this.nummeraanduidingStatus = value;
    }

    /**
     * Gets the value of the gerelateerdeOpenbareRuimte property.
     * 
     * @return
     *     possible object is
     *     {@link Nummeraanduiding.GerelateerdeOpenbareRuimte }
     *     
     */
    public Nummeraanduiding.GerelateerdeOpenbareRuimte getGerelateerdeOpenbareRuimte() {
        return gerelateerdeOpenbareRuimte;
    }

    /**
     * Sets the value of the gerelateerdeOpenbareRuimte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nummeraanduiding.GerelateerdeOpenbareRuimte }
     *     
     */
    public void setGerelateerdeOpenbareRuimte(Nummeraanduiding.GerelateerdeOpenbareRuimte value) {
        this.gerelateerdeOpenbareRuimte = value;
    }

    /**
     * Gets the value of the gerelateerdeWoonplaats property.
     * 
     * @return
     *     possible object is
     *     {@link Nummeraanduiding.GerelateerdeWoonplaats }
     *     
     */
    public Nummeraanduiding.GerelateerdeWoonplaats getGerelateerdeWoonplaats() {
        return gerelateerdeWoonplaats;
    }

    /**
     * Sets the value of the gerelateerdeWoonplaats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nummeraanduiding.GerelateerdeWoonplaats }
     *     
     */
    public void setGerelateerdeWoonplaats(Nummeraanduiding.GerelateerdeWoonplaats value) {
        this.gerelateerdeWoonplaats = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Objectnummer"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "identificatie"
    })
    public static class GerelateerdeOpenbareRuimte {

        @XmlElement(required = true)
        protected String identificatie;

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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="identificatie" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Woonplaatscode"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "identificatie"
    })
    public static class GerelateerdeWoonplaats {

        @XmlElement(required = true)
        protected String identificatie;

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

    }

}

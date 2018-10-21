//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.20 at 11:46:10 AM CEST 
//


package nl.kadaster.schemas.bag_verstrekkingen.extract_selecties.v20090901;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for APD-Extract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APD-Extract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="gegVarActueel" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="gegVarPeildatum" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *             &lt;element name="peildatum" type="{http://www.kadaster.nl/schemas/imbag/imbag-types/v20090901}Datum"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="productcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandTechnischeDatum" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APD-Extract", propOrder = {
    "gegVarActueel",
    "gegVarPeildatum",
    "peildatum",
    "productcode",
    "standTechnischeDatum"
})
public class APDExtract {

    @XmlElement(defaultValue = "0")
    protected Boolean gegVarActueel;
    @XmlElement(defaultValue = "0")
    protected Boolean gegVarPeildatum;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String peildatum;
    protected String productcode;
    @XmlElement(name = "StandTechnischeDatum")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String standTechnischeDatum;

    /**
     * Gets the value of the gegVarActueel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGegVarActueel() {
        return gegVarActueel;
    }

    /**
     * Sets the value of the gegVarActueel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGegVarActueel(Boolean value) {
        this.gegVarActueel = value;
    }

    /**
     * Gets the value of the gegVarPeildatum property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGegVarPeildatum() {
        return gegVarPeildatum;
    }

    /**
     * Sets the value of the gegVarPeildatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGegVarPeildatum(Boolean value) {
        this.gegVarPeildatum = value;
    }

    /**
     * Gets the value of the peildatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeildatum() {
        return peildatum;
    }

    /**
     * Sets the value of the peildatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeildatum(String value) {
        this.peildatum = value;
    }

    /**
     * Gets the value of the productcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductcode() {
        return productcode;
    }

    /**
     * Sets the value of the productcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductcode(String value) {
        this.productcode = value;
    }

    /**
     * Gets the value of the standTechnischeDatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandTechnischeDatum() {
        return standTechnischeDatum;
    }

    /**
     * Sets the value of the standTechnischeDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandTechnischeDatum(String value) {
        this.standTechnischeDatum = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.20 at 11:46:10 AM CEST 
//


package nl.kadaster.schemas.bag_verstrekkingen.extract_deelbestand_lvc.v20090901;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import nl.kadaster.schemas.bag_verstrekkingen.extract_producten_lvc.v20090901.LVCProduct;
import nl.kadaster.schemas.bag_verstrekkingen.extract_selecties.v20090901.GebiedRegistratief;


/**
 *  BAG-Verstrekking met produkt-data
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="antwoord"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="vraag"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}Gebied-Registratief" minOccurs="0"/&gt;
 *                             &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandTechnischeDatum"/&gt;
 *                             &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandDatumVanaf" minOccurs="0"/&gt;
 *                             &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandPeildatum" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="producten"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-producten-lvc/v20090901}LVC-product"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "", propOrder = {
    "antwoord"
})
@XmlRootElement(name = "BAG-Extract-Deelbestand-LVC")
public class BAGExtractDeelbestandLVC {

    @XmlElement(required = true)
    protected BAGExtractDeelbestandLVC.Antwoord antwoord;

    /**
     * Gets the value of the antwoord property.
     * 
     * @return
     *     possible object is
     *     {@link BAGExtractDeelbestandLVC.Antwoord }
     *     
     */
    public BAGExtractDeelbestandLVC.Antwoord getAntwoord() {
        return antwoord;
    }

    /**
     * Sets the value of the antwoord property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAGExtractDeelbestandLVC.Antwoord }
     *     
     */
    public void setAntwoord(BAGExtractDeelbestandLVC.Antwoord value) {
        this.antwoord = value;
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
     *         &lt;element name="vraag"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}Gebied-Registratief" minOccurs="0"/&gt;
     *                   &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandTechnischeDatum"/&gt;
     *                   &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandDatumVanaf" minOccurs="0"/&gt;
     *                   &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandPeildatum" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="producten"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-producten-lvc/v20090901}LVC-product"/&gt;
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
    @XmlType(name = "", propOrder = {
        "vraag",
        "producten"
    })
    public static class Antwoord {

        @XmlElement(required = true)
        protected BAGExtractDeelbestandLVC.Antwoord.Vraag vraag;
        @XmlElement(required = true)
        protected BAGExtractDeelbestandLVC.Antwoord.Producten producten;

        /**
         * Gets the value of the vraag property.
         * 
         * @return
         *     possible object is
         *     {@link BAGExtractDeelbestandLVC.Antwoord.Vraag }
         *     
         */
        public BAGExtractDeelbestandLVC.Antwoord.Vraag getVraag() {
            return vraag;
        }

        /**
         * Sets the value of the vraag property.
         * 
         * @param value
         *     allowed object is
         *     {@link BAGExtractDeelbestandLVC.Antwoord.Vraag }
         *     
         */
        public void setVraag(BAGExtractDeelbestandLVC.Antwoord.Vraag value) {
            this.vraag = value;
        }

        /**
         * Gets the value of the producten property.
         * 
         * @return
         *     possible object is
         *     {@link BAGExtractDeelbestandLVC.Antwoord.Producten }
         *     
         */
        public BAGExtractDeelbestandLVC.Antwoord.Producten getProducten() {
            return producten;
        }

        /**
         * Sets the value of the producten property.
         * 
         * @param value
         *     allowed object is
         *     {@link BAGExtractDeelbestandLVC.Antwoord.Producten }
         *     
         */
        public void setProducten(BAGExtractDeelbestandLVC.Antwoord.Producten value) {
            this.producten = value;
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
         *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-producten-lvc/v20090901}LVC-product"/&gt;
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
            "lvcProduct"
        })
        public static class Producten {

            @XmlElement(name = "LVC-product", namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-producten-lvc/v20090901", required = true)
            protected LVCProduct lvcProduct;

            /**
             * Gets the value of the lvcProduct property.
             * 
             * @return
             *     possible object is
             *     {@link LVCProduct }
             *     
             */
            public LVCProduct getLVCProduct() {
                return lvcProduct;
            }

            /**
             * Sets the value of the lvcProduct property.
             * 
             * @param value
             *     allowed object is
             *     {@link LVCProduct }
             *     
             */
            public void setLVCProduct(LVCProduct value) {
                this.lvcProduct = value;
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
         *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}Gebied-Registratief" minOccurs="0"/&gt;
         *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandTechnischeDatum"/&gt;
         *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandDatumVanaf" minOccurs="0"/&gt;
         *         &lt;element ref="{http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901}StandPeildatum" minOccurs="0"/&gt;
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
            "gebiedRegistratief",
            "standTechnischeDatum",
            "standDatumVanaf",
            "standPeildatum"
        })
        public static class Vraag {

            @XmlElement(name = "Gebied-Registratief", namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901")
            protected GebiedRegistratief gebiedRegistratief;
            @XmlElement(name = "StandTechnischeDatum", namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "token")
            protected String standTechnischeDatum;
            @XmlElement(name = "StandDatumVanaf", namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "token")
            protected String standDatumVanaf;
            @XmlElement(name = "StandPeildatum", namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "token")
            protected String standPeildatum;

            /**
             * Gets the value of the gebiedRegistratief property.
             * 
             * @return
             *     possible object is
             *     {@link GebiedRegistratief }
             *     
             */
            public GebiedRegistratief getGebiedRegistratief() {
                return gebiedRegistratief;
            }

            /**
             * Sets the value of the gebiedRegistratief property.
             * 
             * @param value
             *     allowed object is
             *     {@link GebiedRegistratief }
             *     
             */
            public void setGebiedRegistratief(GebiedRegistratief value) {
                this.gebiedRegistratief = value;
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

            /**
             * Gets the value of the standDatumVanaf property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStandDatumVanaf() {
                return standDatumVanaf;
            }

            /**
             * Sets the value of the standDatumVanaf property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStandDatumVanaf(String value) {
                this.standDatumVanaf = value;
            }

            /**
             * Gets the value of the standPeildatum property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStandPeildatum() {
                return standPeildatum;
            }

            /**
             * Sets the value of the standPeildatum property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStandPeildatum(String value) {
                this.standPeildatum = value;
            }

        }

    }

}

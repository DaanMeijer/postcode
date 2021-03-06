//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.20 at 11:46:10 AM CEST 
//


package nl.kadaster.schemas.bag_verstrekkingen.extract_selecties.v20090901;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import nl.kadaster.schemas.imbag.imbag_types.v20090901.VlakOfMultiVlak;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.kadaster.schemas.bag_verstrekkingen.extract_selecties.v20090901 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _APDExtract_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "APD-Extract");
    private final static QName _LVCExtract_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "LVC-Extract");
    private final static QName _MUTExtract_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "MUT-Extract");
    private final static QName _GebiedRegistratief_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Gebied-Registratief");
    private final static QName _Gebied_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Gebied");
    private final static QName _GebiedIdentificatie_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "GebiedIdentificatie");
    private final static QName _GebiedNaam_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "GebiedNaam");
    private final static QName _GebiedWPL_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Gebied-WPL");
    private final static QName _GebiedNLD_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Gebied-NLD");
    private final static QName _GebiedGEO_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Gebied-GEO");
    private final static QName _WoonplaatsCollectie_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "WoonplaatsCollectie");
    private final static QName _Woonplaats_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Woonplaats");
    private final static QName _WoonplaatsIdentificatie_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "WoonplaatsIdentificatie");
    private final static QName _WoonplaatsNaam_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "WoonplaatsNaam");
    private final static QName _Polygoon_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Polygoon");
    private final static QName _StandPeildatum_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "StandPeildatum");
    private final static QName _StandTechnischeDatum_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "StandTechnischeDatum");
    private final static QName _StandDatumVanaf_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "StandDatumVanaf");
    private final static QName _Leverfrequentie_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Leverfrequentie");
    private final static QName _SchemaInfo_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "SchemaInfo");
    private final static QName _Schemanaam_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Schemanaam");
    private final static QName _Schemaversie_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Schemaversie");
    private final static QName _Mutatievorm_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Mutatievorm");
    private final static QName _Mutatieperiode_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "Mutatieperiode");
    private final static QName _MutatiedatumVanaf_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "MutatiedatumVanaf");
    private final static QName _MutatiedatumTot_QNAME = new QName("http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", "MutatiedatumTot");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.kadaster.schemas.bag_verstrekkingen.extract_selecties.v20090901
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Leverfrequentie }
     * 
     */
    public Leverfrequentie createLeverfrequentie() {
        return new Leverfrequentie();
    }

    /**
     * Create an instance of {@link APDExtract }
     * 
     */
    public APDExtract createAPDExtract() {
        return new APDExtract();
    }

    /**
     * Create an instance of {@link LVCExtract }
     * 
     */
    public LVCExtract createLVCExtract() {
        return new LVCExtract();
    }

    /**
     * Create an instance of {@link MUTExtract }
     * 
     */
    public MUTExtract createMUTExtract() {
        return new MUTExtract();
    }

    /**
     * Create an instance of {@link GebiedRegistratief }
     * 
     */
    public GebiedRegistratief createGebiedRegistratief() {
        return new GebiedRegistratief();
    }

    /**
     * Create an instance of {@link Gebied }
     * 
     */
    public Gebied createGebied() {
        return new Gebied();
    }

    /**
     * Create an instance of {@link GebiedWPL }
     * 
     */
    public GebiedWPL createGebiedWPL() {
        return new GebiedWPL();
    }

    /**
     * Create an instance of {@link GebiedNLD }
     * 
     */
    public GebiedNLD createGebiedNLD() {
        return new GebiedNLD();
    }

    /**
     * Create an instance of {@link GebiedGEO }
     * 
     */
    public GebiedGEO createGebiedGEO() {
        return new GebiedGEO();
    }

    /**
     * Create an instance of {@link WoonplaatsCollectie }
     * 
     */
    public WoonplaatsCollectie createWoonplaatsCollectie() {
        return new WoonplaatsCollectie();
    }

    /**
     * Create an instance of {@link Woonplaats }
     * 
     */
    public Woonplaats createWoonplaats() {
        return new Woonplaats();
    }

    /**
     * Create an instance of {@link SchemaInfo }
     * 
     */
    public SchemaInfo createSchemaInfo() {
        return new SchemaInfo();
    }

    /**
     * Create an instance of {@link Mutatievorm }
     * 
     */
    public Mutatievorm createMutatievorm() {
        return new Mutatievorm();
    }

    /**
     * Create an instance of {@link Mutatieperiode }
     * 
     */
    public Mutatieperiode createMutatieperiode() {
        return new Mutatieperiode();
    }

    /**
     * Create an instance of {@link Leverfrequentie.Periode }
     * 
     */
    public Leverfrequentie.Periode createLeverfrequentiePeriode() {
        return new Leverfrequentie.Periode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APDExtract }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link APDExtract }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "APD-Extract")
    public JAXBElement<APDExtract> createAPDExtract(APDExtract value) {
        return new JAXBElement<APDExtract>(_APDExtract_QNAME, APDExtract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LVCExtract }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LVCExtract }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "LVC-Extract")
    public JAXBElement<LVCExtract> createLVCExtract(LVCExtract value) {
        return new JAXBElement<LVCExtract>(_LVCExtract_QNAME, LVCExtract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MUTExtract }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MUTExtract }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "MUT-Extract")
    public JAXBElement<MUTExtract> createMUTExtract(MUTExtract value) {
        return new JAXBElement<MUTExtract>(_MUTExtract_QNAME, MUTExtract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebiedRegistratief }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GebiedRegistratief }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Gebied-Registratief")
    public JAXBElement<GebiedRegistratief> createGebiedRegistratief(GebiedRegistratief value) {
        return new JAXBElement<GebiedRegistratief>(_GebiedRegistratief_QNAME, GebiedRegistratief.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gebied }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Gebied }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Gebied")
    public JAXBElement<Gebied> createGebied(Gebied value) {
        return new JAXBElement<Gebied>(_Gebied_QNAME, Gebied.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "GebiedIdentificatie")
    public JAXBElement<String> createGebiedIdentificatie(String value) {
        return new JAXBElement<String>(_GebiedIdentificatie_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "GebiedNaam")
    public JAXBElement<String> createGebiedNaam(String value) {
        return new JAXBElement<String>(_GebiedNaam_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebiedWPL }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GebiedWPL }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Gebied-WPL")
    public JAXBElement<GebiedWPL> createGebiedWPL(GebiedWPL value) {
        return new JAXBElement<GebiedWPL>(_GebiedWPL_QNAME, GebiedWPL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebiedNLD }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GebiedNLD }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Gebied-NLD")
    public JAXBElement<GebiedNLD> createGebiedNLD(GebiedNLD value) {
        return new JAXBElement<GebiedNLD>(_GebiedNLD_QNAME, GebiedNLD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebiedGEO }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GebiedGEO }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Gebied-GEO")
    public JAXBElement<GebiedGEO> createGebiedGEO(GebiedGEO value) {
        return new JAXBElement<GebiedGEO>(_GebiedGEO_QNAME, GebiedGEO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WoonplaatsCollectie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WoonplaatsCollectie }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "WoonplaatsCollectie")
    public JAXBElement<WoonplaatsCollectie> createWoonplaatsCollectie(WoonplaatsCollectie value) {
        return new JAXBElement<WoonplaatsCollectie>(_WoonplaatsCollectie_QNAME, WoonplaatsCollectie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Woonplaats }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Woonplaats }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Woonplaats")
    public JAXBElement<Woonplaats> createWoonplaats(Woonplaats value) {
        return new JAXBElement<Woonplaats>(_Woonplaats_QNAME, Woonplaats.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "WoonplaatsIdentificatie")
    public JAXBElement<String> createWoonplaatsIdentificatie(String value) {
        return new JAXBElement<String>(_WoonplaatsIdentificatie_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "WoonplaatsNaam")
    public JAXBElement<String> createWoonplaatsNaam(String value) {
        return new JAXBElement<String>(_WoonplaatsNaam_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VlakOfMultiVlak }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VlakOfMultiVlak }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Polygoon")
    public JAXBElement<VlakOfMultiVlak> createPolygoon(VlakOfMultiVlak value) {
        return new JAXBElement<VlakOfMultiVlak>(_Polygoon_QNAME, VlakOfMultiVlak.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "StandPeildatum")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStandPeildatum(String value) {
        return new JAXBElement<String>(_StandPeildatum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "StandTechnischeDatum")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStandTechnischeDatum(String value) {
        return new JAXBElement<String>(_StandTechnischeDatum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "StandDatumVanaf")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStandDatumVanaf(String value) {
        return new JAXBElement<String>(_StandDatumVanaf_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Leverfrequentie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Leverfrequentie }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Leverfrequentie")
    public JAXBElement<Leverfrequentie> createLeverfrequentie(Leverfrequentie value) {
        return new JAXBElement<Leverfrequentie>(_Leverfrequentie_QNAME, Leverfrequentie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SchemaInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SchemaInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "SchemaInfo")
    public JAXBElement<SchemaInfo> createSchemaInfo(SchemaInfo value) {
        return new JAXBElement<SchemaInfo>(_SchemaInfo_QNAME, SchemaInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Schemanaam")
    public JAXBElement<String> createSchemanaam(String value) {
        return new JAXBElement<String>(_Schemanaam_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Schemaversie")
    public JAXBElement<String> createSchemaversie(String value) {
        return new JAXBElement<String>(_Schemaversie_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mutatievorm }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Mutatievorm }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Mutatievorm")
    public JAXBElement<Mutatievorm> createMutatievorm(Mutatievorm value) {
        return new JAXBElement<Mutatievorm>(_Mutatievorm_QNAME, Mutatievorm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mutatieperiode }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Mutatieperiode }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "Mutatieperiode")
    public JAXBElement<Mutatieperiode> createMutatieperiode(Mutatieperiode value) {
        return new JAXBElement<Mutatieperiode>(_Mutatieperiode_QNAME, Mutatieperiode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "MutatiedatumVanaf")
    public JAXBElement<XMLGregorianCalendar> createMutatiedatumVanaf(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MutatiedatumVanaf_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.kadaster.nl/schemas/bag-verstrekkingen/extract-selecties/v20090901", name = "MutatiedatumTot")
    public JAXBElement<XMLGregorianCalendar> createMutatiedatumTot(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MutatiedatumTot_QNAME, XMLGregorianCalendar.class, null, value);
    }

}

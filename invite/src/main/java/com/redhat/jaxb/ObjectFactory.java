//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 01:39:45 AM BRT 
//


package com.redhat.jaxb;

import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.redhat.jaxb package. 
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

    private final static QName _Convite_QNAME = new QName("http://service.anbima.com.br/corp/convite", "convite");
    private final static QName _Tos_QNAME = new QName("http://service.anbima.com.br/corp/convite", "tos");
    private final static QName _To_QNAME = new QName("http://service.anbima.com.br/corp/convite", "to");
    private final static QName _Client_QNAME = new QName("http://service.anbima.com.br/corp/convite", "client");
    private final static QName _Status_QNAME = new QName("http://service.anbima.com.br/corp/convite", "status");
    private final static QName _Event_QNAME = new QName("http://service.anbima.com.br/corp/convite", "event");
    private final static QName _Dtstart_QNAME = new QName("http://service.anbima.com.br/corp/convite", "dtstart");
    private final static QName _Dtend_QNAME = new QName("http://service.anbima.com.br/corp/convite", "dtend");
    private final static QName _Organizer_QNAME = new QName("http://service.anbima.com.br/corp/convite", "organizer");
    private final static QName _Cn_QNAME = new QName("http://service.anbima.com.br/corp/convite", "cn");
    private final static QName _Mailto_QNAME = new QName("http://service.anbima.com.br/corp/convite", "mailto");
    private final static QName _Uid_QNAME = new QName("http://service.anbima.com.br/corp/convite", "uid");
    private final static QName _Attendee_QNAME = new QName("http://service.anbima.com.br/corp/convite", "attendee");
    private final static QName _Description_QNAME = new QName("http://service.anbima.com.br/corp/convite", "description");
    private final static QName _Location_QNAME = new QName("http://service.anbima.com.br/corp/convite", "location");
    private final static QName _Sequence_QNAME = new QName("http://service.anbima.com.br/corp/convite", "sequence");
    private final static QName _Summary_QNAME = new QName("http://service.anbima.com.br/corp/convite", "summary");
    private final static QName _Role_QNAME = new QName("http://service.anbima.com.br/corp/convite", "role");
    private final static QName _Partstat_QNAME = new QName("http://service.anbima.com.br/corp/convite", "partstat");
    private final static QName _Cutype_QNAME = new QName("http://service.anbima.com.br/corp/convite", "cutype");
    private final static QName _Rsvp_QNAME = new QName("http://service.anbima.com.br/corp/convite", "rsvp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.redhat.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Convite }
     * 
     */
    public Convite createConvite() {
        return new Convite();
    }

    /**
     * Create an instance of {@link CallbackConviteRequest }
     * 
     */
    public CallbackConviteRequest createCallbackConviteRequest() {
        return new CallbackConviteRequest();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link CallbackConviteResponse }
     * 
     */
    public CallbackConviteResponse createCallbackConviteResponse() {
        return new CallbackConviteResponse();
    }

    /**
     * Create an instance of {@link Tos }
     * 
     */
    public Tos createTos() {
        return new Tos();
    }

    /**
     * Create an instance of {@link Organizer }
     * 
     */
    public Organizer createOrganizer() {
        return new Organizer();
    }

    /**
     * Create an instance of {@link Attendee }
     * 
     */
    public Attendee createAttendee() {
        return new Attendee();
    }

    /**
     * Create an instance of {@link CriaConviteRequest }
     * 
     */
    public CriaConviteRequest createCriaConviteRequest() {
        return new CriaConviteRequest();
    }

    /**
     * Create an instance of {@link CriaConviteResponse }
     * 
     */
    public CriaConviteResponse createCriaConviteResponse() {
        return new CriaConviteResponse();
    }

    /**
     * Create an instance of {@link AtualizaConviteRequest }
     * 
     */
    public AtualizaConviteRequest createAtualizaConviteRequest() {
        return new AtualizaConviteRequest();
    }

    /**
     * Create an instance of {@link AtualizaConviteResponse }
     * 
     */
    public AtualizaConviteResponse createAtualizaConviteResponse() {
        return new AtualizaConviteResponse();
    }

    /**
     * Create an instance of {@link CancelaConviteRequest }
     * 
     */
    public CancelaConviteRequest createCancelaConviteRequest() {
        return new CancelaConviteRequest();
    }

    /**
     * Create an instance of {@link CancelaConviteResponse }
     * 
     */
    public CancelaConviteResponse createCancelaConviteResponse() {
        return new CancelaConviteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "convite")
    public JAXBElement<Convite> createConvite(Convite value) {
        return new JAXBElement<Convite>(_Convite_QNAME, Convite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "tos")
    public JAXBElement<Tos> createTos(Tos value) {
        return new JAXBElement<Tos>(_Tos_QNAME, Tos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "to")
    public JAXBElement<String> createTo(String value) {
        return new JAXBElement<String>(_To_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "client")
    public JAXBElement<String> createClient(String value) {
        return new JAXBElement<String>(_Client_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Status }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "status")
    public JAXBElement<Status> createStatus(Status value) {
        return new JAXBElement<Status>(_Status_QNAME, Status.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "event")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "dtstart")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createDtstart(Date value) {
        return new JAXBElement<Date>(_Dtstart_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "dtend")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createDtend(Date value) {
        return new JAXBElement<Date>(_Dtend_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Organizer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "organizer")
    public JAXBElement<Organizer> createOrganizer(Organizer value) {
        return new JAXBElement<Organizer>(_Organizer_QNAME, Organizer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "cn")
    public JAXBElement<String> createCn(String value) {
        return new JAXBElement<String>(_Cn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "mailto")
    public JAXBElement<String> createMailto(String value) {
        return new JAXBElement<String>(_Mailto_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "uid")
    public JAXBElement<String> createUid(String value) {
        return new JAXBElement<String>(_Uid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Attendee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "attendee")
    public JAXBElement<Attendee> createAttendee(Attendee value) {
        return new JAXBElement<Attendee>(_Attendee_QNAME, Attendee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "location")
    public JAXBElement<String> createLocation(String value) {
        return new JAXBElement<String>(_Location_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "sequence")
    public JAXBElement<BigInteger> createSequence(BigInteger value) {
        return new JAXBElement<BigInteger>(_Sequence_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "summary")
    public JAXBElement<String> createSummary(String value) {
        return new JAXBElement<String>(_Summary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Role }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "role")
    public JAXBElement<Role> createRole(Role value) {
        return new JAXBElement<Role>(_Role_QNAME, Role.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Partstat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "partstat")
    public JAXBElement<Partstat> createPartstat(Partstat value) {
        return new JAXBElement<Partstat>(_Partstat_QNAME, Partstat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cutype }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "cutype")
    public JAXBElement<Cutype> createCutype(Cutype value) {
        return new JAXBElement<Cutype>(_Cutype_QNAME, Cutype.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.anbima.com.br/corp/convite", name = "rsvp")
    public JAXBElement<Boolean> createRsvp(Boolean value) {
        return new JAXBElement<Boolean>(_Rsvp_QNAME, Boolean.class, null, value);
    }

}

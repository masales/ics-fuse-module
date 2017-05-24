//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 12:55:46 AM BRT 
//


package com.redhat.jaxb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java de Event complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Event"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}uid"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}sequence"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}status"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}dtstart"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}dtend"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}organizer"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}attendee" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}description"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}location"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}summary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
    "uid",
    "sequence",
    "status",
    "dtstart",
    "dtend",
    "organizer",
    "attendee",
    "description",
    "location",
    "summary"
})
@XmlRootElement
public class Event
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sequence;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Status status;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date dtstart;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date dtend;
    @XmlElement(required = true)
    protected Organizer organizer;
    @XmlElement(required = true)
    protected List<Attendee> attendee;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String location;
    @XmlElement(required = true)
    protected String summary;

    /**
     * Obtém o valor da propriedade uid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Define o valor da propriedade uid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Obtém o valor da propriedade sequence.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequence() {
        return sequence;
    }

    /**
     * Define o valor da propriedade sequence.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequence(BigInteger value) {
        this.sequence = value;
    }

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade dtstart.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDtstart() {
        return dtstart;
    }

    /**
     * Define o valor da propriedade dtstart.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtstart(Date value) {
        this.dtstart = value;
    }

    /**
     * Obtém o valor da propriedade dtend.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getDtend() {
        return dtend;
    }

    /**
     * Define o valor da propriedade dtend.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtend(Date value) {
        this.dtend = value;
    }

    /**
     * Obtém o valor da propriedade organizer.
     * 
     * @return
     *     possible object is
     *     {@link Organizer }
     *     
     */
    public Organizer getOrganizer() {
        return organizer;
    }

    /**
     * Define o valor da propriedade organizer.
     * 
     * @param value
     *     allowed object is
     *     {@link Organizer }
     *     
     */
    public void setOrganizer(Organizer value) {
        this.organizer = value;
    }

    /**
     * Gets the value of the attendee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attendee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttendee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attendee }
     * 
     * 
     */
    public List<Attendee> getAttendee() {
        if (attendee == null) {
            attendee = new ArrayList<Attendee>();
        }
        return this.attendee;
    }

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define o valor da propriedade location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtém o valor da propriedade summary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Define o valor da propriedade summary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

}

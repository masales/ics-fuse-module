//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 12:55:46 AM BRT 
//


package com.redhat.jaxb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Attendee complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Attendee"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}cn"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}mailto"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}role"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}partstat"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}rsvp"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}cutype"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attendee", propOrder = {
    "cn",
    "mailto",
    "role",
    "partstat",
    "rsvp",
    "cutype"
})
@XmlRootElement
public class Attendee
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true)
    protected String cn;
    @XmlElement(required = true)
    protected String mailto;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Role role;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Partstat partstat;
    protected boolean rsvp;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Cutype cutype;

    /**
     * Obtém o valor da propriedade cn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCn() {
        return cn;
    }

    /**
     * Define o valor da propriedade cn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCn(String value) {
        this.cn = value;
    }

    /**
     * Obtém o valor da propriedade mailto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailto() {
        return mailto;
    }

    /**
     * Define o valor da propriedade mailto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailto(String value) {
        this.mailto = value;
    }

    /**
     * Obtém o valor da propriedade role.
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRole() {
        return role;
    }

    /**
     * Define o valor da propriedade role.
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRole(Role value) {
        this.role = value;
    }

    /**
     * Obtém o valor da propriedade partstat.
     * 
     * @return
     *     possible object is
     *     {@link Partstat }
     *     
     */
    public Partstat getPartstat() {
        return partstat;
    }

    /**
     * Define o valor da propriedade partstat.
     * 
     * @param value
     *     allowed object is
     *     {@link Partstat }
     *     
     */
    public void setPartstat(Partstat value) {
        this.partstat = value;
    }

    /**
     * Obtém o valor da propriedade rsvp.
     * 
     */
    public boolean isRsvp() {
        return rsvp;
    }

    /**
     * Define o valor da propriedade rsvp.
     * 
     */
    public void setRsvp(boolean value) {
        this.rsvp = value;
    }

    /**
     * Obtém o valor da propriedade cutype.
     * 
     * @return
     *     possible object is
     *     {@link Cutype }
     *     
     */
    public Cutype getCutype() {
        return cutype;
    }

    /**
     * Define o valor da propriedade cutype.
     * 
     * @param value
     *     allowed object is
     *     {@link Cutype }
     *     
     */
    public void setCutype(Cutype value) {
        this.cutype = value;
    }

}

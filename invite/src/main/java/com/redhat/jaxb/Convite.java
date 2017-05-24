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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Convite complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Convite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}tos"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}client"/&gt;
 *         &lt;element ref="{http://service.cliente.com.br/corp/convite}event"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Convite", propOrder = {
    "tos",
    "client",
    "event"
})
@XmlRootElement
public class Convite
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true)
    protected Tos tos;
    @XmlElement(required = true)
    protected String client;
    @XmlElement(required = true)
    protected Event event;

    /**
     * Obtém o valor da propriedade tos.
     * 
     * @return
     *     possible object is
     *     {@link Tos }
     *     
     */
    public Tos getTos() {
        return tos;
    }

    /**
     * Define o valor da propriedade tos.
     * 
     * @param value
     *     allowed object is
     *     {@link Tos }
     *     
     */
    public void setTos(Tos value) {
        this.tos = value;
    }

    /**
     * Obtém o valor da propriedade client.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClient() {
        return client;
    }

    /**
     * Define o valor da propriedade client.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Obtém o valor da propriedade event.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Define o valor da propriedade event.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setEvent(Event value) {
        this.event = value;
    }

}

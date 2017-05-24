//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 12:55:46 AM BRT 
//


package com.redhat.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Cutype.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Cutype"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="INDIVIDUAL"/&gt;
 *     &lt;enumeration value="GROUP"/&gt;
 *     &lt;enumeration value="ROOM"/&gt;
 *     &lt;enumeration value="RESOURCE"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Cutype")
@XmlEnum
public enum Cutype {


    /**
     * An individual
     * 
     */
    INDIVIDUAL,

    /**
     * A group of individuals
     * 
     */
    GROUP,

    /**
     * A physical resource
     * 
     */
    ROOM,

    /**
     * A room resource
     * 
     */
    RESOURCE,

    /**
     * Otherwise not known
     * 
     */
    UNKNOWN;

    public String value() {
        return name();
    }

    public static Cutype fromValue(String v) {
        return valueOf(v);
    }

}

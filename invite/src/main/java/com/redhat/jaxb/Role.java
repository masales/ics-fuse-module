//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 01:39:45 AM BRT 
//


package com.redhat.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Role.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Role"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CHAIR"/&gt;
 *     &lt;enumeration value="REQ-PARTICIPANT"/&gt;
 *     &lt;enumeration value="OPT-PARTICIPANT"/&gt;
 *     &lt;enumeration value="NON-PARTICIPANT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Role")
@XmlEnum
public enum Role {


    /**
     * Indicates chair of the calendar entity
     * 
     */
    CHAIR("CHAIR"),

    /**
     * Indicates a participant whose participation is required
     * 
     */
    @XmlEnumValue("REQ-PARTICIPANT")
    REQ_PARTICIPANT("REQ-PARTICIPANT"),

    /**
     * Indicates a participant whose participation is optional
     * 
     */
    @XmlEnumValue("OPT-PARTICIPANT")
    OPT_PARTICIPANT("OPT-PARTICIPANT"),

    /**
     * Indicates a participant who is copied for information purposes only
     * 
     */
    @XmlEnumValue("NON-PARTICIPANT")
    NON_PARTICIPANT("NON-PARTICIPANT");
    private final String value;

    Role(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Role fromValue(String v) {
        for (Role c: Role.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

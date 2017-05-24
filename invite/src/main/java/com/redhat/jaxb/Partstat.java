//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.05.24 às 12:55:46 AM BRT 
//


package com.redhat.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Partstat.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Partstat"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NEEDS-ACTION"/&gt;
 *     &lt;enumeration value="ACCEPTED"/&gt;
 *     &lt;enumeration value="DECLINED"/&gt;
 *     &lt;enumeration value="TENTATIVE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Partstat")
@XmlEnum
public enum Partstat {


    /**
     * Event needs action
     * 
     */
    @XmlEnumValue("NEEDS-ACTION")
    NEEDS_ACTION("NEEDS-ACTION"),

    /**
     * Event accepted
     * 
     */
    ACCEPTED("ACCEPTED"),

    /**
     * Event declined
     * 
     */
    DECLINED("DECLINED"),

    /**
     * Event tentatively accepted
     * 
     */
    TENTATIVE("TENTATIVE");
    private final String value;

    Partstat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Partstat fromValue(String v) {
        for (Partstat c: Partstat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

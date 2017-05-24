package com.redhat.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CallbackResponse {
    @XmlAttribute(required = false)
    private String gid;
    @XmlAttribute(required = false)
    private Integer sequence;
    @XmlAttribute(required = false)
    private String method;
    @XmlAttribute(required = false)
    private String attendee;
    @XmlAttribute(required = false)
    private String partstat;
    @XmlAttribute(required = false)
    private String organizerCn;
    @XmlAttribute(required = false)
    private String organizerEmail;
    
    public String getGid() {
	return gid;
    }

    public void setGid(String gid) {
	this.gid = gid;
    }

    public Integer getSequence() {
	return sequence;
    }

    public void setSequence(Integer sequence) {
	this.sequence = sequence;
    }

    public String getMethod() {
	return method;
    }

    public void setMethod(String method) {
	this.method = method;
    }

    public String getAttendee() {
	return attendee;
    }

    public void setAttendee(String attendee) {
	this.attendee = attendee;
    }

    public String getPartstat() {
	return partstat;
    }

    public void setPartstat(String partstat) {
	this.partstat = partstat;
    }

    public String getOrganizerCn() {
        return organizerCn;
    }

    public void setOrganizerCn(String organizerCn) {
        this.organizerCn = organizerCn;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }
}

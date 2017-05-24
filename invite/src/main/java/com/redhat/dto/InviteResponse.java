package com.redhat.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InviteResponse {
    @XmlAttribute(required = false)
    private String gid;
    @XmlAttribute(required = false)
    private Integer sequence;

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
}

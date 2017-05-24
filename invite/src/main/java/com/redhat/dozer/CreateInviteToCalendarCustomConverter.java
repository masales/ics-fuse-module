package com.redhat.dozer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.RandomStringUtils;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.util.HostInfo;
import net.fortuna.ical4j.util.UidGenerator;

public class CreateInviteToCalendarCustomConverter extends AbstractInviteToCalendarCustomConverter {

    @Override
    protected Method getMethod() {
	return Method.REQUEST;
    }

    @Override
    protected Property getGID(String uid) {
	// generate unique identifier..
	// generate GID
	UidGenerator generator = new UidGenerator(new HostInfo() {
	    @Override
	    public String getHostName() {
		try {
		    return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
		    return RandomStringUtils.randomAlphanumeric(15);
		}
	    }
	}, RandomStringUtils.randomAlphanumeric(10));
	return generator.generateUid();
    }

}

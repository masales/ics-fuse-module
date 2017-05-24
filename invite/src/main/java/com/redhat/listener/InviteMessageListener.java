package com.redhat.listener;

import java.io.StringReader;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.RuntimeCamelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.redhat.config.ClientConfig;
import com.redhat.config.ClientConfig.Client;
import com.redhat.dto.CallbackResponse;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Organizer;

public class InviteMessageListener {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ClientConfig config;

    @Handler
    public void onMessage(String message, @Body org.apache.camel.Message inMessage) {
	logger.info("Enter in " + getClass().getName() + " message = " + message);

	try (StringReader sr = new StringReader(message)) {
	    CalendarBuilder builder = new CalendarBuilder();
	    Calendar calendar = builder.build(sr);

	    VEvent event = (VEvent) calendar.getComponent(Component.VEVENT);
	    Organizer organizer = event.getOrganizer();
	    String email = organizer.getValue().toLowerCase().replaceAll("mailto:", "");
	    Client client = config.getClientByEmail(email);

	    inMessage.setHeader("client_url", client.getUrl());

	    // response has only one attendee
	    PropertyList attendeeList = event.getProperties(Property.ATTENDEE);
	    Attendee attendee = (Attendee) attendeeList.iterator().next();
	    PartStat partStat = (PartStat) attendee.getParameter(Parameter.PARTSTAT);
	    Parameter cn = attendee.getParameter(Parameter.CN);

	    CallbackResponse response = new CallbackResponse();
	    response.setGid(event.getUid().getValue());
	    response.setMethod(calendar.getMethod().getValue());
	    response.setSequence(event.getSequence().getSequenceNo());
	    response.setPartstat(partStat.getValue());
	    response.setAttendee(cn.getValue());
	    response.setOrganizerEmail(email);
	    Parameter organizerCN = organizer.getParameter(Parameter.CN);
	    // sometimes the email client does not send back the organizer CN
	    if (organizerCN != null)
		response.setOrganizerCn(organizerCN.getValue());

	    inMessage.setBody(response);
	} catch (Exception e) {
	    logger.error(e.getMessage(), e);
	    throw new RuntimeCamelException(e);
	}

    }

}

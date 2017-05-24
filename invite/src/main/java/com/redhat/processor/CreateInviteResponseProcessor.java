package com.redhat.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.dto.InviteResponse;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;

public class CreateInviteResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
	Calendar iCalendar = exchange.getIn().getBody(Calendar.class);
	net.fortuna.ical4j.model.Component event = iCalendar.getComponent(net.fortuna.ical4j.model.Component.VEVENT);
	InviteResponse response = new InviteResponse();
	response.setGid(event.getProperty(Property.UID).getValue());
	response.setSequence(Integer.valueOf(event.getProperty(Property.SEQUENCE).getValue()));
	exchange.getOut().setBody(response);
    }

}

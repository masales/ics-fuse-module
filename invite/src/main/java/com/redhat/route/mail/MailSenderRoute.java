package com.redhat.route.mail;

import org.apache.camel.model.dataformat.IcalDataFormat;
import org.springframework.stereotype.Component;

import com.redhat.route.plubing.AbstractRouteBuilder;

@Component
public class MailSenderRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	from("direct:sendMail").marshal(new IcalDataFormat()).setHeader("from", simple(config.getMailFrom()))
		.setHeader("contentType", constant("text/calendar;method=REQUEST;charset=UTF-8;name=meeting.ics"))
		.to("smtps://" + config.getSmtp() + ":" + config.getMailPort() + "?username=" + config.getMailUser() + "&password="
			+ config.getMailPass() + "&debugMode=true");

    }

}

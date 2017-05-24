package com.redhat.route;

import javax.ws.rs.core.MediaType;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.redhat.listener.InviteMessageListener;
import com.redhat.route.plubing.AbstractRouteBuilder;

@Component
public class CallBackInviteRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	from("activemq:queue:ics?username=invite&password=invite").routeId("callBackConviteRoute")
		// from("activemq:queue:ics").routeId("callBackConviteRoute")
		.log("callBackConviteRoute receive message ${body}").bean(InviteMessageListener.class, "onMessage")
		.log("Response configured ${body}").setHeader(Exchange.CONTENT_TYPE, constant(MediaType.APPLICATION_JSON)).marshal()
		.json(JsonLibrary.Gson).log("Response as json ${body} to http4://${header.client_url}/rest/api/convite").recipientList()
		.simple("http4://${header.client_url}/rest/api/convite")
		.log("message delivered ${header.CamelHttpResponseCode} response ${body}");

	// simple log dead letter channel
	from("activemq:ics.DLQ?username=invite&password=invite").log(LoggingLevel.ERROR, "ENTER IN DEAD LETTER ${body}");
    }

    @Override
    protected void configureException() {
	errorHandler(deadLetterChannel("activemq:ics.DLQ?username=invite&password=invite").loggingLevel(LoggingLevel.ERROR)
		.log("Error on redelivery ${body}")
		// errorHandler(deadLetterChannel("activemq:ics.DLQ").log("Error on redelivery ${body}")
		// .useOriginalMessage()
		.maximumRedeliveries(3).redeliveryDelay(10000));
    }

}

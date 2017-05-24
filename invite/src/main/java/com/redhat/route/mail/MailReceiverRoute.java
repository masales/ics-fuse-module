package com.redhat.route.mail;

import org.springframework.stereotype.Component;

import com.redhat.processor.ReadMailProcessor;
import com.redhat.route.plubing.AbstractRouteBuilder;

@Component
public class MailReceiverRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	from("direct:mailReceiver").routeId("mailReceiverRoute")
	.log("received email ${body}")
	.process(new ReadMailProcessor()).choice()
		.when(body().isNotNull()).to("activemq:queue:ics?username=invite&password=invite").otherwise().log("message has no content");
//	.when(body().isNotNull()).to("activemq:queue:ics").otherwise().log("message has no content");
    }

}

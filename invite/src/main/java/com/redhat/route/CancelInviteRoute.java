package com.redhat.route;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.redhat.processor.ConfigureTosProcessor;
import com.redhat.route.plubing.AbstractRouteBuilder;
@Component
public class CancelInviteRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	from("direct:cancelarConviteRoute").routeId("cancelarConviteRoute").process(new ConfigureTosProcessor())
		.to("dozer:transformUpdateInvite?targetModel=net.fortuna.ical4j.model.Calendar&mappingFile=cancelDozerBeanMapping.xml")
		.multicast().stopOnException().to("direct:sendMail", "direct:cancelarConviteOutputRoute").end();

	from("direct:cancelarConviteOutputRoute").routeId("cancelarConviteOutputRoute").setBody(constant("OK"))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(Response.Status.OK.getStatusCode()));

    }

}

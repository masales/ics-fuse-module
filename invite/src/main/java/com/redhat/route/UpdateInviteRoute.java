package com.redhat.route;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.redhat.processor.ConfigureTosProcessor;
import com.redhat.route.plubing.AbstractRouteBuilder;
@Component
public class UpdateInviteRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {

	from("direct:atualizarConviteRoute").routeId("atualizarConviteRoute").process(new ConfigureTosProcessor())
		.to("dozer:transformUpdateInvite?targetModel=net.fortuna.ical4j.model.Calendar&mappingFile=updateDozerBeanMapping.xml")
		.log("configured route ${body}")
		.multicast().stopOnException().to("direct:sendMail", "direct:atualizarConviteOutputRoute").end();

	from("direct:atualizarConviteOutputRoute").routeId("atualizarConviteOutputRoute").setBody(constant("OK"))
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(Response.Status.OK.getStatusCode()));
    }

}

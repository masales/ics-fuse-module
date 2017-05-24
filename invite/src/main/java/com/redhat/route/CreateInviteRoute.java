package com.redhat.route;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.redhat.processor.ConfigureTosProcessor;
import com.redhat.processor.CreateInviteResponseProcessor;
import com.redhat.route.plubing.AbstractRouteBuilder;

@Component
public class CreateInviteRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {

	from("direct:criarConviteRoute").routeId("criarConviteRoute").process(new ConfigureTosProcessor())
		.to("dozer:transformInvite?targetModel=net.fortuna.ical4j.model.Calendar&mappingFile=createDozerBeanMapping.xml")
		.multicast().stopOnException().to("direct:sendMail", "direct:criarConviteOutputRoute").end();

	from("direct:criarConviteOutputRoute").routeId("criarConviteOutputRoute").process(new CreateInviteResponseProcessor()).marshal(gson)
		.convertBodyTo(String.class, "UTF-8").log("${body}")
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(Response.Status.CREATED.getStatusCode()));

    }

}

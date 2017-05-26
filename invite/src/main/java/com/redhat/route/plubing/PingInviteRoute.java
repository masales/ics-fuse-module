package com.redhat.route.plubing;

import org.springframework.stereotype.Component;

@Component
public class PingInviteRoute extends AbstractRouteBuilder {

    @Override
    protected void configureRoute() throws Exception {
	from("direct:pingConviteRoute").routeId("pingConviteRoute").setBody().constant("The service is healthy");
    }

}

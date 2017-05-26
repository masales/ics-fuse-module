package com.redhat.route.plubing;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.config.ApplicationConfiguration;

@Component
public class SetupApiRouteBuilder extends RouteBuilder {

    @Autowired
    ApplicationConfiguration config;

    @Override
    public void configure() throws Exception {	
	
	restConfiguration().bindingMode(RestBindingMode.json).dataFormatProperty("prettyPrint", "true").apiContextPath(config.getApiPath())
		.component("servlet").enableCORS(true).apiProperty("api.title", config.getApiTitle())
		.host(config.getSwaggerAddress())
		.port(config.getSwaggerPort())
		.apiProperty("api.description", config.getApiDescription()).apiProperty("api.version", config.getApiVersion())
		.contextPath(config.getContextPath()).apiProperty("api.contact.name", config.getApiContact())
		.apiProperty("cors", "true");

    }
}

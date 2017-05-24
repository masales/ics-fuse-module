package com.redhat.route.plubing;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.FieldNamingPolicy;
import com.redhat.config.ApplicationConfiguration;

public abstract class AbstractRouteBuilder extends RouteBuilder {

    @Autowired
    protected ApplicationConfiguration config;

    protected GsonDataFormat gson = new GsonDataFormat();

    @Override
    public void configure() throws Exception {
	configureGsonFormat();
	configureException();
	configureRoute();

    }

    protected void configureGsonFormat() {
	gson.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
	gson.setPrettyPrint(false);
	gson.setSerializeNulls(false);
	gson.setDateFormatPattern("HH:mm:ss dd/MM/yyyy");
    }

    protected void configureException() {
	onException(Exception.class).setHeader("routeId", exchangeProperty(Exchange.FAILURE_ROUTE_ID))
		.setHeader("endpoint", exchangeProperty(Exchange.FAILURE_ENDPOINT))
		.setHeader("exception", exchangeProperty(Exchange.EXCEPTION_CAUGHT))
		.setHeader("subject", simple("Message Broker Error - ${exception.class.simpleName}"))
		.transform(simple(
			"${headers.routeId} - ${headers.endpoint}\n${exception.message}\n\nStacktrace Details:\n\n${exception.stacktrace}"))
		// .to("freemarker:/templates/mail/error.ftl")
		.to("smtps://" + config.getSmtp() + ":" + config.getMailPort() + "?username=" + config.getMailUser() + "&password="
			+ config.getMailPass() + "&debugMode=true&contentType=text/plain&subject=${headers.subject})&to="
			+ config.getMailFrom() + "&from=" + config.getMailFrom());
    }

    protected abstract void configureRoute() throws Exception;

}

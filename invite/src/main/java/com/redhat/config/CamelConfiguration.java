package com.redhat.config;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.redhat.config.ClientConfig.Client;

@Configuration
@EnableConfigurationProperties(CamelConfigurationProperties.class)
public class CamelConfiguration {

    @Autowired
    protected ClientConfig clientConfig;

    @Bean
    RoutesBuilder configureContext() {
	return new RouteBuilder() {

	    @Override
	    public void configure() throws Exception {

		// add dynamic routes to imap
		for (Client client : clientConfig.getClients()) {
		    includeRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
			    from("imaps://" + client.getHost() + ":" + client.getPort() + "?username=" + client.getEmail() + "&password="
				    + client.getPass() + "&delete=false&unseen=true&consumer.delay=10000")
					    .routeId(client.getName() + "Route").to("direct:mailReceiver");
			}
		    });
		}

	    }

	};
    }

}

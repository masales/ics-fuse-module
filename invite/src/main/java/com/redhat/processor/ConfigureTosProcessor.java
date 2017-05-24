package com.redhat.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.redhat.jaxb.Convite;
import com.redhat.jaxb.Tos;

public class ConfigureTosProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
	Message message = exchange.getIn();
	Convite convite = message.getBody(Convite.class);
	Tos tos = convite.getTos();
	StringBuilder dest = new StringBuilder();
	String sep = "";
	for (String to : tos.getTo()) {
	    dest.append(sep).append(to);
	    sep = ",".intern();
	}

	message.setHeader("to", dest.toString());
	message.setHeader("subject", convite.getEvent().getSummary());

    }

}

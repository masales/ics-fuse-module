package com.redhat.processor;

import java.util.Map;

import javax.activation.DataHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadMailProcessor implements Processor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(Exchange exchange) throws Exception {
	Map<String, DataHandler> attachments = exchange.getIn().getAttachments();
	if (attachments.size() > 0) {
	    boolean proceed = false;
	    for (String name : attachments.keySet()) {
		DataHandler dh = attachments.get(name);
		// get the file name
		String filename = dh.getName();
		
		if (filename.endsWith(".ics")) {
		    // get the content and convert it to byte[]
		    byte[] data = exchange.getContext().getTypeConverter().convertTo(byte[].class, dh.getInputStream());
		    String content = new String(data);
		    exchange.getOut().setBody(content);
		    proceed = true;
		}
	    }
	    if (!proceed){
		exchange.getOut().setBody(null);
	    }
	} else {
	    exchange.getOut().setBody(null);
	}

    }

}

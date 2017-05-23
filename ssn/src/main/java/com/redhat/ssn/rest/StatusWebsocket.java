package com.redhat.ssn.rest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@ServerEndpoint(value = "/wsEndpoint", encoders = { JsonEncoder.class })
public class StatusWebsocket {

    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    protected Logger logger = LoggerFactory.getLogger(getClass());

    
    public void notifyClients(JsonObject jsonEvent) throws Exception {

	for (Session peer : peers) {
	    if (peer.isOpen()) {
		peer.getBasicRemote().sendObject(jsonEvent);
		logger.debug("DISPATCH TO " + peer.getId());
	    }
	}
    }

    @OnMessage
    public String onMessage(String message, Session session) {
	logger.info("message received! " + message);
	for (Session peer : peers) {
	    if (!peer.equals(session)) {
		try {
		    peer.getBasicRemote().sendText(message + "retweet");
		} catch (IOException e) {
		    logger.error(e.getMessage(), e);
		}
	    }
	}
	return "message was received and processed: " + message;
    }

    @OnOpen
    public void onOpen(Session session) {
	logger.info("Registrado Peer " + session.getId());
	peers.add(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason c) {
	logger.info("Close sesison " + session + " for reason " + c.getReasonPhrase());
	peers.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
	logger.error(throwable.getMessage(), throwable);
    }
}

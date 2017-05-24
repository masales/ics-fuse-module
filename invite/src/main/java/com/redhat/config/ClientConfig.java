package com.redhat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@EnableConfigurationProperties
public class ClientConfig {

    private List<Client> clients = new ArrayList<>();

    public Client getClientByEmail(String email) {
	for (Client client : clients) {
	    if (email.equalsIgnoreCase(client.getEmail()))
		return client;
	}
	return null;
    }

    public static class Client {
	private String name;
	private String email;
	private String port;
	private String pass;
	private String url;
	private String type;
	private String host;

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getUrl() {
	    return url;
	}

	public void setUrl(String url) {
	    this.url = url;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getPort() {
	    return port;
	}

	public void setPort(String port) {
	    this.port = port;
	}

	public String getPass() {
	    return pass;
	}

	public void setPass(String pass) {
	    this.pass = pass;
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("Client [");
	    if (name != null)
		builder.append("name=").append(name).append(", ");
	    if (email != null)
		builder.append("email=").append(email).append(", ");
	    if (port != null)
		builder.append("port=").append(port).append(", ");
	    if (pass != null)
		builder.append("pass=").append(pass).append(", ");
	    if (url != null)
		builder.append("url=").append(url).append(", ");
	    if (type != null)
		builder.append("type=").append(type).append(", ");
	    if (host != null)
		builder.append("host=").append(host);
	    builder.append("]");
	    return builder.toString();
	}

	public String getHost() {
	    return host;
	}

	public void setHost(String host) {
	    this.host = host;
	}
    }

    public List<Client> getClients() {
	return clients;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ClientConfig [");
	if (clients != null)
	    builder.append("clients=").append(clients);
	builder.append("]");
	return builder.toString();
    }
}

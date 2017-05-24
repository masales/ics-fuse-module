package com.redhat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ApplicationConfiguration {

    @Value("${server.port}")
    private String serverPort;

    @Value("${camel.handler.api.id}")
    private String apiId;

    @Value("${camel.handler.api.path}")
    private String apiPath;

    @Value("${camel.handler.api.description}")
    private String apiDescription;

    @Value("${camel.handler.api.title}")
    private String apiTitle;

    @Value("${camel.handler.api.version}")
    private String apiVersion;

    @Value("${camel.handler.api.contact}")
    private String apiContact = "masales@redhat.com";
    
    @Value("${camel.handler.api.port}")
    private String swaggerPort = "8080";
    
    @Value("${camel.handler.api.address}")
    private String swaggerAddress = "0.0.0.0";

    @Value("${camel.context.path}")
    private String contextPath;

    @Value("${mail.port}")
    private String mailPort;

    @Value("${mail.host}")
    private String smtp;

    @Value("${mail.username}")
    private String mailUser;

    @Value("${mail.password}")
    private String mailPass;

    @Value("${mail.mailfrom}")
    private String mailFrom;

    public String getApiId() {
	return apiId;
    }

    public void setApiId(String apiId) {
	this.apiId = apiId;
    }

    public String getApiPath() {
	return apiPath;
    }

    public void setApiPath(String apiPath) {
	this.apiPath = apiPath;
    }

    public String getApiDescription() {
	return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
	this.apiDescription = apiDescription;
    }

    public String getContextPath() {
	return contextPath;
    }

    public void setContextPath(String contextPath) {
	this.contextPath = contextPath;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ApplicationConfiguration [");
	if (serverPort != null)
	    builder.append("serverPort=").append(serverPort).append(", ");
	if (apiId != null)
	    builder.append("apiId=").append(apiId).append(", ");
	if (apiPath != null)
	    builder.append("apiPath=").append(apiPath).append(", ");
	if (apiDescription != null)
	    builder.append("apiDescription=").append(apiDescription).append(", ");
	if (apiTitle != null)
	    builder.append("apiTitle=").append(apiTitle).append(", ");
	if (apiVersion != null)
	    builder.append("apiVersion=").append(apiVersion).append(", ");
	if (apiContact != null)
	    builder.append("apiContact=").append(apiContact).append(", ");
	if (swaggerPort != null)
	    builder.append("swaggerPort=").append(swaggerPort).append(", ");
	if (swaggerAddress != null)
	    builder.append("swaggerAddress=").append(swaggerAddress).append(", ");
	if (contextPath != null)
	    builder.append("contextPath=").append(contextPath).append(", ");
	if (mailPort != null)
	    builder.append("mailPort=").append(mailPort).append(", ");
	if (smtp != null)
	    builder.append("smtp=").append(smtp).append(", ");
	if (mailUser != null)
	    builder.append("mailUser=").append(mailUser).append(", ");
	if (mailPass != null)
	    builder.append("mailPass=").append(mailPass).append(", ");
	if (mailFrom != null)
	    builder.append("mailFrom=").append(mailFrom);
	builder.append("]");
	return builder.toString();
    }

    public String getApiTitle() {
	return apiTitle;
    }

    public void setApiTitle(String apiTitle) {
	this.apiTitle = apiTitle;
    }

    public String getApiVersion() {
	return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
	this.apiVersion = apiVersion;
    }

    public String getApiContact() {
	return apiContact;
    }

    public void setApiContact(String apiContact) {
	this.apiContact = apiContact;
    }

    public String getServerPort() {
	return serverPort;
    }

    public void setServerPort(String serverPort) {
	this.serverPort = serverPort;
    }

    public String getMailPort() {
	return mailPort;
    }

    public void setMailPort(String mailPort) {
	this.mailPort = mailPort;
    }

    public String getSmtp() {
	return smtp;
    }

    public void setSmtp(String smtp) {
	this.smtp = smtp;
    }

    public String getMailUser() {
	return mailUser;
    }

    public void setMailUser(String mailUser) {
	this.mailUser = mailUser;
    }

    public String getMailPass() {
	return mailPass;
    }

    public void setMailPass(String mailPass) {
	this.mailPass = mailPass;
    }

    public String getMailFrom() {
	return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
	this.mailFrom = mailFrom;
    }

    public String getSwaggerPort() {
        return swaggerPort;
    }

    public void setSwaggerPort(String swaggerPort) {
        this.swaggerPort = swaggerPort;
    }

    public String getSwaggerAddress() {
        return swaggerAddress;
    }

    public void setSwaggerAddress(String swaggerAddress) {
        this.swaggerAddress = swaggerAddress;
    }
}

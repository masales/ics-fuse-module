# ICS Integration module

This is a module to manage calendar events. It was built on top of Fuse Integration Services, with REST, ICS, IMAPS, JMS examples.

## Technologies

* Fuse Integration Services
* Camel
* REST
* ICS
* IMAPS
* JMS (ActiveMQ)
* (JEE7)

## Project Structure

  * **invite** - This is the core module hosts the camel route that integrates a REST API, iCalendar calendar service (* .ics), email reading with IMAPS and messaging with ActiveMQ
  * **sre** - SRE mocks a client for the scheduling service 
  * **ssn** - SSN mocks a client for the scheduling service

## The clients SRE|SSN
Each client has a default web page index.html. This page contains a websocket that monitors received events from server when one invite event occurs.
http://localhost:8080/[sre or ssn] if you are running in localhost, if you are running inside openshift FIS use the ROUTE_URL to access these applications.

## Openshift setup

If you are using a Openshift "oc cluster up" you will need the imagestream and templates of eap, amq and fis. To install:

```
chmod +x openshift-local-setup.sh
./openshift-local-setup.sh
```

If you are in a Windows environment copy and paste each line of the script and everything should work.

If you don't. https://github.com/openshift/origin/blob/master/docs/cluster_up_down.md

### Deploy SSN e SRE in Openshift

```
oc new-app jboss-eap70-openshift~https://github.com/masales/ics-fuse-module.git --context-dir=sre --name=sre
oc new-app jboss-eap70-openshift~https://github.com/masales/ics-fuse-module.git --context-dir=ssn --name=ssn
```

## Build and Run 

### Requirements

The list of requirements needed to test invite-service module.

* Running ActiveMQ JMS Broker
* Running instance sre
* Running instance ssn
* [Email accounts configured as showed in](#application-parameters)

### Convite Service module

To run:
```
  mvn clean install camel:run 
````
 
 [Access the swagger API and invoke the services](http://localhost:8080/)

  
### Application Parameters

All parameters used is set in invite/src/main/resources/application.yml file.

```yml
mail: - # this mail account is used to send error emails
  port: 465 or 993 ...
  host: smtp.gmail.com or imap-mail.outlook.com ...
  username: <MAIL_ACCOUNT>
  password: <MAIL_PASSWORD>
  mailfrom: <MAIL_ACCOUNT> 
  
  config:
  clients: # Clients are the systems that integrate with this module. For this project there are two clients: SRE and SSN
  -
    name: ssn # represents the SSN Project client information. This configuration is used to send reply to the client and to read email from ssn mail box.
    email: <EMAIL>
    host: imap-mail.outlook.com or smtp.gmail.com or ...
    port: 993 or 465 ...
    pass: <PASSWORD>
    url: localhost:8080/ssn <observes the context in jboss-web.xml> # This is the URL used to invoke the return service. If using inside openshift with FIS use the snn service instead.
    type: soap
  -
    name: sre
    email: <EMAIL>
    host: imap-mail.outlook.com or smtp.gmail.com or ...
    port: 993 or 465 ...
    pass: <PASSWORD>
    url: localhost:8080/sre <observes the context in jboss-web.xml> # This is the URL used to invoke the return service. If using inside openshift with FIS use the sre service instead.
    type: rest
```

# The route works as follows

### Create invite
  1. Client invokes de REST API passing a JSON like conviteService/src/test/resources/invite.json (adjust de file with correct params)
  2. Service create a ICS file (with GID/UID)
  3. Service sends a email with ICS file as attachment 
  4. Service observes client email with imaps
  
### Create invite - callback
  1. Imaps receive email
  2. Service extract ICS response file
  3. Service extract client information
  4. Service puts the formatted return in a ActiveMQ queue
  5. Another route observes the ActiveMQ queue
  6. Client JMS get the message
  7. Finds the response URL (client.url from the application.yml as aforementioned)
  8. Returns the response to the requestor based on the URL
  
  
  ## Docker Version
  
  Certify that you are not using docker version 17.x. 

  For mac you can download a previous version here: https://download.docker.com/mac/stable/1.13.1.15353/Docker.dmg

  

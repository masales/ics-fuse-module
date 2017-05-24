#!/bin/bash
# Requirements
#   oc client installed
#   oc cluster already running: oc cluster up

#oc login https://127.0.0.1:8443 -u system:admin
oc login https://192.168.99.100:8443 -u system:admin
# https://github.com/jboss-openshift/application-templates
# install image-streams

BASEURL=https://raw.githubusercontent.com/jboss-openshift/application-templates/master
oc replace --force -n openshift -f ${BASEURL}/jboss-image-streams.json
# install eap 7 basic template
oc replace --force -n openshift -f ${BASEURL}/eap/eap70-basic-s2i.json
# install AMQ 6.2 template
oc replace --force -n openshift -f ${BASEURL}/amq/amq62-basic.json

# FIS images (installing all)
BASEURL=https://raw.githubusercontent.com/jboss-fuse/application-templates/GA
oc replace --force -n openshift -f ${BASEURL}/fis-image-streams.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/karaf2-camel-amq-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/karaf2-camel-log-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/karaf2-camel-rest-sql-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/karaf2-cxf-rest-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-amq-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-config-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-drools-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-infinispan-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-rest-sql-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-teiid-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-camel-xml-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-cxf-jaxrs-template.json
oc replace --force -n openshift -f ${BASEURL}/quickstarts/spring-boot-cxf-jaxws-template.json
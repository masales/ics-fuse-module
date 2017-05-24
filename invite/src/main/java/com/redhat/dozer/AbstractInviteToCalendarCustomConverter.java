package com.redhat.dozer;

import java.math.BigInteger;
import java.net.URI;
import java.util.Date;

import org.apache.camel.RuntimeCamelException;
import org.dozer.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redhat.jaxb.Convite;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.CuType;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.parameter.Rsvp;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Created;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Repeat;
import net.fortuna.ical4j.model.property.Sequence;
import net.fortuna.ical4j.model.property.Status;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.Transp;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;

public abstract class AbstractInviteToCalendarCustomConverter implements CustomConverter {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
	if (source == null) {
	    return null;
	}
	Convite convite = (Convite) source;
	Calendar icsCalendar = null;
	// check to see if the object already exists
	if (destination == null) {
	    icsCalendar = new Calendar();
	} else {
	    icsCalendar = (Calendar) destination;
	}

	return convert(convite, icsCalendar);
    }

    protected abstract Method getMethod();

    public Calendar convert(Convite convite, Calendar icsCalendar) {
	TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
	TimeZone timezone = registry.getTimeZone("America/Sao_Paulo");
	VTimeZone tz = timezone.getVTimeZone();

	icsCalendar.getProperties().add(Version.VERSION_2_0);
	String pid = "-//Events Calendar " + convite.getClient() + " //iCal4j 1.0//EN";
	icsCalendar.getProperties().add(new ProdId(pid));
	icsCalendar.getProperties().add(CalScale.GREGORIAN);

	// Create the event
	PropertyList propertyList = new PropertyList();
	propertyList.add(new DtStamp(new DateTime(new Date())));
	propertyList.add(new Created(new DateTime(new Date())));
	propertyList.add(new DtStart(new DateTime(convite.getEvent().getDtstart())));
	propertyList.add(new DtEnd(new DateTime(convite.getEvent().getDtend())));
	propertyList.add(new Description(convite.getEvent().getDescription()));
	propertyList.add(new Location(convite.getEvent().getLocation()));
	propertyList.add(new Summary(convite.getEvent().getSummary()));
	propertyList.add(Transp.OPAQUE);

	BigInteger sequence = convite.getEvent().getSequence();
	if (sequence != null && sequence.intValue() > 0) {
	    propertyList.add(new Sequence(sequence.intValue()));
	} else {
	    propertyList.add(new Sequence(1));
	}

	propertyList.add(tz.getTimeZoneId());
	propertyList.add(new Status(convite.getEvent().getStatus().value()));

	// generate unique identifier..
	// generate GID
	propertyList.add(getGID(convite.getEvent().getUid()));

	VEvent event = new VEvent(propertyList);

	// organizer
	com.redhat.jaxb.Organizer orgnz = convite.getEvent().getOrganizer();
	try {
	    event.getProperties().add(new Organizer());
	    event.getProperties().getProperty(Property.ORGANIZER).setValue("mailto:" + orgnz.getMailto());
	    event.getProperties().getProperty(Property.ORGANIZER).getParameters().add(new Cn(orgnz.getCn()));
	} catch (Exception e) {
	    throw new RuntimeCamelException(e.getMessage(), e);
	}

	configureAlarm(event);

	for (com.redhat.jaxb.Attendee a : convite.getEvent().getAttendee()) {
	    Attendee attendee = new Attendee(URI.create("mailto:" + a.getMailto()));
	    attendee.getParameters().add(new Role(a.getRole().value()));
	    attendee.getParameters().add(new Cn(a.getCn()));
	    attendee.getParameters().add(new PartStat(a.getPartstat().value()));
	    attendee.getParameters().add(new Rsvp(a.isRsvp()));
	    attendee.getParameters().add(new CuType(a.getCutype().value()));
	    event.getProperties().add(attendee);
	}

	// Add the event and print
	icsCalendar.getComponents().add(event);
	icsCalendar.getProperties().add(getMethod());
	return icsCalendar;
    }

    protected void configureAlarm(VEvent event) {
	// alarm - 1 hour before event
	VAlarm alarm = new VAlarm(new Dur(0, -1, 0, 0));
	// repeat alarm four more times every fifteen minutes
	alarm.getProperties().add(new Repeat(4));
	alarm.getProperties().add(new Duration(new Dur(0, 0, 15, 0)));
	alarm.getProperties().add(Action.DISPLAY);
	alarm.getProperties().add(new Description("This is an event reminder"));
	event.getAlarms().add(alarm);
    }

    protected Property getGID(String uid) {
	return new Uid(uid);
    }

}

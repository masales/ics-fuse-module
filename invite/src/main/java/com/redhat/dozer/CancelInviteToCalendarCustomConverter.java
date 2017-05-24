package com.redhat.dozer;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Method;

public class CancelInviteToCalendarCustomConverter extends AbstractInviteToCalendarCustomConverter {

    @Override
    protected Method getMethod() {
	return Method.CANCEL;
    }

    @Override
    protected void configureAlarm(VEvent event) {
	// do nothing
    }

}

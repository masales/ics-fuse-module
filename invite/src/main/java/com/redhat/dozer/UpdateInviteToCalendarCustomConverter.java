package com.redhat.dozer;

import net.fortuna.ical4j.model.property.Method;

public class UpdateInviteToCalendarCustomConverter extends AbstractInviteToCalendarCustomConverter {

    @Override
    protected Method getMethod() {
	return Method.REQUEST;
    }

}

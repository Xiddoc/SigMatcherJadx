package com.xiddoc.sigmatcherjadx.eventhandlers;

import jadx.api.plugins.events.JadxEventType;
import jadx.api.plugins.events.JadxEvents;

public class OnRenameEventHandler extends BaseJadxEventHandler {
	@Override
	public JadxEventType getEventType() {
		return JadxEvents.NODE_RENAMED_BY_USER;
	}

	@Override
	public void onEvent() {

	}
}

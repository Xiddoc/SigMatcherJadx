package com.xiddoc.sigmatcherjadx.eventhandlers;

import jadx.api.plugins.events.IJadxEvent;
import jadx.api.plugins.events.IJadxEvents;
import jadx.api.plugins.events.JadxEventType;

import java.util.function.Consumer;

public abstract class BaseJadxEventHandler implements Consumer<IJadxEvent> {
	public final void registerHandler(IJadxEvents eventManager) {
		eventManager.addListener(getEventType(), this::accept);
	}

	public final void accept(IJadxEvent renamedNodeEvent) {
		onEvent();
	};

	public abstract JadxEventType getEventType();
	public abstract void onEvent();
}

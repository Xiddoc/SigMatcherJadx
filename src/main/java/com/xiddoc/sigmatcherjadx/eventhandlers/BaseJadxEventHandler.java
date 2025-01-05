package com.xiddoc.sigmatcherjadx.eventhandlers;

import jadx.api.plugins.JadxPluginContext;
import jadx.api.plugins.events.IJadxEvent;
import jadx.api.plugins.events.JadxEventType;

import java.util.function.Consumer;

public abstract class BaseJadxEventHandler implements Consumer<IJadxEvent> {
	private JadxPluginContext context;

	public final void registerEventHandler(JadxPluginContext context) {
		this.context = context;
		context.events().addListener(getEventType(), this::accept);
	}

	public final void accept(IJadxEvent renamedNodeEvent) {
		if (context == null) {
			throw new IllegalStateException("SigMatcher event handler was called before it was registered in the Jadx event manager.");
		}

		onEvent(context, renamedNodeEvent);
	};

	public abstract JadxEventType getEventType();

	public abstract void onEvent(JadxPluginContext context, IJadxEvent renamedNodeEvent);
}

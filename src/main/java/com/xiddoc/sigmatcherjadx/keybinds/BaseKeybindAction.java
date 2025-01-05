package com.xiddoc.sigmatcherjadx.keybinds;

import jadx.api.metadata.ICodeNodeRef;
import jadx.api.plugins.JadxPluginContext;
import jadx.core.Jadx;

import java.util.function.Consumer;

public abstract class BaseKeybindAction implements Consumer<ICodeNodeRef> {
	private JadxPluginContext context;

	public final void registerKeybind(JadxPluginContext context) {
		this.context = context;
		context.getGuiContext().addPopupMenuAction(getTooltip(), (ICodeNodeRef ref) -> true, getKeyBinding(), this::accept);
	}

	public final void accept(ICodeNodeRef ref) {
		if (context == null) {
			throw new IllegalStateException("SigMatcher event handler was called before it was registered in the Jadx event manager.");
		}

		onPopupClicked(context, ref);
	};

	public abstract String getTooltip();

	public abstract String getKeyBinding();

	public abstract void onPopupClicked(JadxPluginContext context, ICodeNodeRef ref);
}

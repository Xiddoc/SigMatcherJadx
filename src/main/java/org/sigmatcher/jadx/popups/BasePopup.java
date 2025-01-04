package org.sigmatcher.jadx.popups;

import jadx.api.JadxDecompiler;
import jadx.api.metadata.ICodeNodeRef;
import jadx.api.plugins.gui.JadxGuiContext;

import java.util.function.Consumer;

public abstract class BasePopup implements Consumer<ICodeNodeRef> {
	public final void registerPopup(JadxGuiContext gui) {
		gui.addPopupMenuAction(getTooltip(), (ICodeNodeRef ref) -> true, getKeyBinding(), this::accept);
	}

	public final void accept(ICodeNodeRef ref) {
		onPopupClicked();
	};

	public abstract String getTooltip();
	public abstract String getKeyBinding();
	public abstract void onPopupClicked();
}

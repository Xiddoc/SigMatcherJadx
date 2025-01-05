package com.xiddoc.sigmatcherjadx.keybinds;

import jadx.api.metadata.ICodeNodeRef;
import jadx.api.plugins.JadxPluginContext;

public class CreateSignatureKeybindAction extends BaseKeybindAction {
	@Override
	public String getTooltip() {
		return "SigMatcher: Create signature for object (s)";
	}

	@Override
	public String getKeyBinding() {
		return "S";
	}

	@Override
	public void onPopupClicked(JadxPluginContext context, ICodeNodeRef ref) {

	}
}

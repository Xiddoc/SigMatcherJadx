package org.sigmatcher.jadx.popups;

import jadx.api.metadata.ICodeNodeRef;

public class CreateSignaturePopup extends BasePopup {
	@Override
	public String getTooltip() {
		return "SigMatcher: Create signature for object (s)";
	}

	@Override
	public String getKeyBinding() {
		return "S";
	}

	@Override
	public void onPopupClicked() {

	}
}

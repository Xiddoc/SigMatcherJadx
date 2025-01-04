package org.sigmatcher.jadx;

import jadx.api.plugins.options.impl.BasePluginOptionsBuilder;

public class SigMatcherOptions extends BasePluginOptionsBuilder {

	private boolean enable;

	@Override
	public void registerOptions() {
		boolOption(SigMatcherPlugin.PLUGIN_ID + ".enable")
				.description("enable comment")
				.defaultValue(true)
				.setter(v -> enable = v);
	}

	public boolean isEnable() {
		return enable;
	}
}

package com.xiddoc.sigmatcherjadx;

import com.xiddoc.sigmatcherjadx.eventhandlers.BaseJadxEventHandler;
import com.xiddoc.sigmatcherjadx.eventhandlers.OnRenameEventHandler;
import jadx.api.plugins.JadxPlugin;
import jadx.api.plugins.JadxPluginContext;
import jadx.api.plugins.JadxPluginInfo;
import jadx.api.plugins.JadxPluginInfoBuilder;
import com.xiddoc.sigmatcherjadx.keybinds.BaseKeybindAction;
import com.xiddoc.sigmatcherjadx.keybinds.CreateSignatureKeybindAction;

public class SigMatcherPlugin implements JadxPlugin {
	public static final String PLUGIN_ID = "sigmatcher-jadx";
	private final static BaseKeybindAction[] popups = {new CreateSignatureKeybindAction()};
	private final static BaseJadxEventHandler[] eventHandlers = {new OnRenameEventHandler()};

	@Override
	public JadxPluginInfo getPluginInfo() {
		return JadxPluginInfoBuilder.pluginId(PLUGIN_ID)
				.name("SigMatcher")
				.description("Create signatures for classes, methods, and fields. " +
						"Use the SigMatcher CLI to copy your renames from one APK version to the newer version.")
				.homepage("https://github.com/Xiddoc/SigMatcherJadx/")
				.build();
	}

	@Override
	public void init(JadxPluginContext context) {
		// Add our hotkeys
		this.registerPopups(context);
		// Subscribe to relevant Jadx events
		this.registerEventHandlers(context);
	}

	public void registerPopups(JadxPluginContext context) {
		for (BaseKeybindAction keybind : popups) {
			keybind.registerKeybind(context);
		}
	}

	public void registerEventHandlers(JadxPluginContext context) {
		for (BaseJadxEventHandler eventHandler : eventHandlers) {
			eventHandler.registerEventHandler(context);
		}
	}
}

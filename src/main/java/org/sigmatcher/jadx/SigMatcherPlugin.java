package org.sigmatcher.jadx;

import jadx.api.plugins.JadxPlugin;
import jadx.api.plugins.JadxPluginContext;
import jadx.api.plugins.JadxPluginInfo;
import jadx.api.plugins.JadxPluginInfoBuilder;
import jadx.api.plugins.gui.JadxGuiContext;
import org.sigmatcher.jadx.popups.BasePopup;
import org.sigmatcher.jadx.popups.CreateSignaturePopup;

import java.util.List;

public class SigMatcherPlugin implements JadxPlugin {
	public static final String PLUGIN_ID = "sigmatcher-jadx-plugin";
	private final SigMatcherOptions options = new SigMatcherOptions();
	private final static BasePopup[] popups = {new CreateSignaturePopup()};

	@Override
	public JadxPluginInfo getPluginInfo() {
		return JadxPluginInfoBuilder.pluginId(PLUGIN_ID)
				.name("SigMatcher")
				.description("Create signatures for classes, methods, and fields. " +
						"Use the SigMatcher CLI to copy your renames from one APK version to the newer version.")
				.homepage("https://github.com/oriori1703/sigmatcher/")
				.build();
	}

	@Override
	public void init(JadxPluginContext context) {
		context.registerOptions(options);

		// Add our hotkeys
		this.registerPopups(context.getGuiContext());

		if (options.isEnable()) {
			context.addPass(new AddCommentPass());
		}
	}

	public void registerPopups(JadxGuiContext gui) {
		for (BasePopup popup : popups) {
			popup.registerPopup(gui);
		}
	}
}

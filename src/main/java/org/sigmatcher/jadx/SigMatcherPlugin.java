package jadx.plugins.example;

import jadx.api.plugins.JadxPlugin;
import jadx.api.plugins.JadxPluginContext;
import jadx.api.plugins.JadxPluginInfo;
import jadx.api.plugins.JadxPluginInfoBuilder;

public class JadxExamplePlugin implements JadxPlugin {
	public static final String PLUGIN_ID = "sigmatcher-jadx-plugin";

	private final SigMatcherOptions options = new SigMatcherOptions();

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
		if (options.isEnable()) {
			context.addPass(new AddCommentPass());
		}
	}
}

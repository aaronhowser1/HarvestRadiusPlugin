package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;

import javax.annotation.Nonnull;

public class HarvestRadiusPlugin extends JavaPlugin {

	private final Config<HRConfig> config;
	private final HREvents eventListener;

	public HarvestRadiusPlugin(@Nonnull JavaPluginInit init) {
		super(init);

		this.config = this.withConfig("HarvestRadius", HRConfig.CODEC);
		this.eventListener = new HREvents(this);
	}

	@Override
	protected void setup() {
		for (int i = 0; i < 100; i++) {
			getLogger().atInfo().log("Harvest Radius Plugin Initialized!");
		}

		getEventRegistry().registerGlobal(
				UseBlockEvent.class,
				eventListener::useBlock
		);

		getCommandRegistry().registerCommand(new TestCommand("test", "Test command!"));
	}

	public Config<HRConfig> getHRConfig() {
		return config;
	}

}

package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;

import javax.annotation.Nonnull;

public class HarvestRadiusPlugin extends JavaPlugin {

	private final Config<HRConfig> config;

	public HarvestRadiusPlugin(@Nonnull JavaPluginInit init) {
		super(init);

		this.config = this.withConfig("HarvestRadius", HRConfig.CODEC);
	}

	@Override
	protected void setup() {
		for (int i = 0; i < 100; i++) {
			getLogger().atInfo().log("Harvest Radius Plugin Initialized!");
		}

		getEventRegistry().registerGlobal(
				UseBlockEvent.class,
				HREvents::useBlock
		);

		getCommandRegistry().registerCommand(new TestCommand("test", "Test command!"));
	}

	public HRConfig getHRConfig() {
		return config.get();
	}

}

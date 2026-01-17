package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class HarvestRadiusPlugin extends JavaPlugin {

	public HarvestRadiusPlugin(@Nonnull JavaPluginInit init) {
		super(init);
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
}

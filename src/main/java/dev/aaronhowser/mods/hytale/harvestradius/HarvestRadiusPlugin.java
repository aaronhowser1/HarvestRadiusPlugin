package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
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
			getLogger().atInfo().log("Harvest Radius Plugin Initialized! Instance number: " + i);
		}

		getCodecRegistry(Interaction.CODEC)
				.register(
						"Aaron_HarvestRadius_HarvestInteraction",
						HarvestInteraction.class,
						HarvestInteraction.CODEC
				);

		getCommandRegistry().registerCommand(new TestCommand("test", "Test command!"));
	}
}

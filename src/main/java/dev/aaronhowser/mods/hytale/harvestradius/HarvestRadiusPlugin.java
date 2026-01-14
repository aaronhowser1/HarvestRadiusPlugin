package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerInteractEvent;
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

		getEventRegistry().registerGlobal(
				PlayerInteractEvent.class,
				(event) -> {
					var player = event.getPlayer();
					var message = Message.raw("You interacted with something at position: " + event.getTargetBlock().toString());
					player.sendMessage(message);
				}
		);

		getCommandRegistry().registerCommand(new TestCommand("test", "Test command!"));
	}
}

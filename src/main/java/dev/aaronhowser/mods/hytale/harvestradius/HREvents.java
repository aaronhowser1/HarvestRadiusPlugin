package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;
import com.hypixel.hytale.server.core.util.Config;

public class HREvents {

	private final Config<HRConfig> config;

	public HREvents(HarvestRadiusPlugin plugin) {
		this.config = plugin.getHRConfig();
	}

	public void useBlock(UseBlockEvent event) {
		System.out.println("HarvestRadiusListener triggered!");

		var entity = event.getContext().getEntity();
		var store = entity.getStore();
		var player = store.getComponent(entity, Player.getComponentType());

		if (player == null) {
			return;
		}

		player.sendMessage(Message.raw("HarvestRadiusListener triggered!"));

		var world = player.getWorld();
		if (world == null) {
			return;
		}

		var center = event.getTargetBlock();

		double radius = config.get().getRadius();
		int radiusCeil = (int) Math.ceil(radius);

		for (var dx = -radiusCeil; dx <= radiusCeil; dx++) {
			for (var dy = -radiusCeil; dy <= radiusCeil; dy++) {
				for (var dz = -radiusCeil; dz <= radiusCeil; dz++) {
					double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
					if (distance <= radius) {
						var targetPos = center.add(dx, dy, dz);
						var targetBlock = world.getBlock(targetPos);
					}
				}
			}
		}

	}

}

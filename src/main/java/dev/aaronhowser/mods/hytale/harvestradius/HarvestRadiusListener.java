package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;

public class HarvestRadiusListener {

	public static void test(UseBlockEvent event) {
		System.out.println("HarvestRadiusListener triggered!");

		var entity = event.getContext().getEntity();
		var store = entity.getStore();
		var player = store.getComponent(entity, Player.getComponentType());

		player.sendMessage(Message.raw("HarvestRadiusListener triggered!"));
	}

}

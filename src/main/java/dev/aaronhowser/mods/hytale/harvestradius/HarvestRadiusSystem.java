package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.UseBlockEvent;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HarvestRadiusSystem extends EntityEventSystem<EntityStore, UseBlockEvent> {

//	private final Config<HRConfig> config;

	protected HarvestRadiusSystem() {
		super(UseBlockEvent.class);
//		this.config = config;
	}

	@Override
	public void handle(
			int i,
			@Nonnull ArchetypeChunk<EntityStore> archetypeChunk,
			@Nonnull Store<EntityStore> store,
			@Nonnull CommandBuffer<EntityStore> commandBuffer,
			@Nonnull UseBlockEvent useBlockEvent
	) {
		System.out.println("HarvestRadiusListener triggered!");

		var ref = useBlockEvent.getContext().getEntity();
		var player = store.getComponent(ref, Player.getComponentType());

		if (player == null) {
			return;
		}

		player.sendMessage(Message.raw("HarvestRadiusListener triggered!"));

		var world = player.getWorld();
		if (world == null) {
			return;
		}

		var center = useBlockEvent.getTargetBlock();

		double radius = 5.1;
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

	@Nullable
	@Override
	public Query<EntityStore> getQuery() {
		return null;
	}
}

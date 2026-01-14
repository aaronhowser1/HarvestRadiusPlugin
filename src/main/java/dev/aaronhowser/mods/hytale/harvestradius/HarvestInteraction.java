package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.inventory.ItemStack;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.client.SimpleBlockInteraction;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HarvestInteraction extends SimpleBlockInteraction {

	public static final BuilderCodec<HarvestInteraction> CODEC =
			BuilderCodec.builder(HarvestInteraction.class, HarvestInteraction::new).build();

	@Override
	protected void interactWithBlock(
			@Nonnull World world,
			@Nonnull CommandBuffer<EntityStore> commandBuffer,
			@Nonnull InteractionType interactionType,
			@Nonnull InteractionContext interactionContext,
			@Nullable ItemStack itemStack,
			@Nonnull Vector3i vector3i,
			@Nonnull CooldownHandler cooldownHandler
	) {
		var ref = interactionContext.getEntity();
		var store = ref.getStore();
		var player = store.getComponent(ref, Player.getComponentType());

		var message = Message.raw(interactionType.name());
		player.sendMessage(message);
	}

	@Override
	protected void simulateInteractWithBlock(@Nonnull InteractionType interactionType, @Nonnull InteractionContext interactionContext, @Nullable ItemStack itemStack, @Nonnull World world, @Nonnull Vector3i vector3i) {

	}
}

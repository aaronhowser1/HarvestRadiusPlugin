package dev.aaronhowser.mods.hytale.harvestradius

import com.hypixel.hytale.component.Ref
import com.hypixel.hytale.component.Store
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.CommandContext
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand
import com.hypixel.hytale.server.core.universe.PlayerRef
import com.hypixel.hytale.server.core.universe.world.World
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore

class TestCommand(
	name: String,
	description: String,
	requiresConfirmation: Boolean
) : AbstractPlayerCommand(name, description, requiresConfirmation) {

	override fun execute(
		ctx: CommandContext,
		store: Store<EntityStore>,
		ref: Ref<EntityStore>,
		playerRef: PlayerRef,
		world: World
	) {
		playerRef.sendMessage(Message.raw("Test!"))
	}

}
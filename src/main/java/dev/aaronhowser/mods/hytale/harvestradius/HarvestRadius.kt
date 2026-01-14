package dev.aaronhowser.mods.hytale.harvestradius

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.event.events.player.PlayerInteractEvent
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit

class HarvestRadius(init: JavaPluginInit) : JavaPlugin(init) {

	override fun setup() {

		eventRegistry.register(PlayerInteractEvent::class.java) { event ->
			val player = event.player
			val coordinates = event.targetBlock

			player.sendMessage(Message.raw("You interacted with block at: ${coordinates.x}, ${coordinates.y}, ${coordinates.z}"))
		}

		commandRegistry.registerCommand(TestCommand("test", "A test command", false))

	}

}
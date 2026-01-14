package dev.aaronhowser.mods.hytale.harvestradius

import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import dev.aaronhowser.mods.hytale.harvestradius.commands.CameraCommand
import dev.aaronhowser.mods.hytale.harvestradius.commands.ExampleCommand
import dev.aaronhowser.mods.hytale.harvestradius.commands.TitleCommand
import dev.aaronhowser.mods.hytale.harvestradius.listeners.PlayerChatListener
import dev.aaronhowser.mods.hytale.harvestradius.listeners.PlayerReadyListener
import java.util.function.Consumer

class HarvestRadius(init: JavaPluginInit) : JavaPlugin(init) {


	override fun setup() {
		// Commands
		commandRegistry.registerCommand(CameraCommand())
		commandRegistry.registerCommand(ExampleCommand())
		commandRegistry.registerCommand(TitleCommand())

		// Events
		eventRegistry.registerGlobal<String?, PlayerChatEvent?>(
			PlayerChatEvent::class.java,
			Consumer { event: PlayerChatEvent? -> PlayerChatListener.onPlayerChat(event!!) })
		eventRegistry.registerGlobal<String?, PlayerReadyEvent?>(
			PlayerReadyEvent::class.java,
			Consumer { event: PlayerReadyEvent? -> PlayerReadyListener.onPlayerReady(event!!) })
	}
}
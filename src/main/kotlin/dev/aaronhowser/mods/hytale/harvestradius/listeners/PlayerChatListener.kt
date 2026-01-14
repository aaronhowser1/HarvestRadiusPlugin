package dev.aaronhowser.mods.hytale.harvestradius.listeners

import dev.aaronhowser.mods.hytale.harvestradius.chat.ChatMessageFormatter
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent

object PlayerChatListener {
    private val FORMATTER = ChatMessageFormatter()

    fun onPlayerChat(event: PlayerChatEvent) {
        event.formatter = FORMATTER
    }
}

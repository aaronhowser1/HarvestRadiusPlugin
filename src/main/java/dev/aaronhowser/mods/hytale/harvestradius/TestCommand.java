package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.jetbrains.annotations.NotNull;

public class TestCommand extends AbstractPlayerCommand {

	public TestCommand(@NotNull String name, @NotNull String description) {
		super(name, description);
	}

	@Override
	protected void execute(
			@NotNull CommandContext commandContext,
			@NotNull Store<EntityStore> store,
			@NotNull Ref<EntityStore> ref,
			@NotNull PlayerRef playerRef,
			@NotNull World world
	) {
		playerRef.sendMessage(Message.raw("Test!"));
	}

}

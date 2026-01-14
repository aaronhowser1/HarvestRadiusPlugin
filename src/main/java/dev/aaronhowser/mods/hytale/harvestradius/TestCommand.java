package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;

public class TestCommand extends AbstractPlayerCommand {

	public TestCommand(@Nonnull String name, @Nonnull String description) {
		super(name, description);
	}

	@Override
	protected void execute(
			@Nonnull CommandContext commandContext,
			@Nonnull Store<EntityStore> store,
			@Nonnull Ref<EntityStore> ref,
			@Nonnull PlayerRef playerRef,
			@Nonnull World world
	) {
		playerRef.sendMessage(Message.raw("Test!"));
	}

}

package tropics.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import tropics.tools.TeleportationTools;
import tropics.world.dimensions.ModDimensions;

public class CommandTPDim implements Command<CommandSource> {

    private static final CommandTPDim CMD = new CommandTPDim();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("dim")
                .requires(cs -> cs.hasPermission(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayerOrException();
        int x = player.blockPosition().getX();
        int z = player.blockPosition().getZ();
        if (player.getCommandSenderWorld().dimension().equals(ModDimensions.TEST_DIMENSION)) {
            ServerWorld world = player.getServer().getLevel(World.OVERWORLD);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
        } else {
            ServerWorld world = player.getServer().getLevel(ModDimensions.TEST_DIMENSION);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
        }
        return 0;
    }

}
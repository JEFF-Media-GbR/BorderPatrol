package com.jeff_media.borderpatrol;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import de.jeff_media.jefflib.Tasks;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Objects;

@CommandAlias("borderpatrol")
@CommandPermission("borderpatrol.admin")
public class SetSpawnCommand extends BaseCommand {

    private static final BorderPatrol main = BorderPatrol.getInstance();

    @Subcommand("setspawn")
    public void onSetSpawn(Player player) {
        World world = player.getWorld();
        Location location = player.getLocation();
        main.getConfig().set("spawn." + world.getName(), new SimpleLocation(location).toMap());
        player.sendMessage(Objects.requireNonNull(main.getConfig().getString("message-setspawn")));
        Tasks.async(main::saveConfig);
    }
}

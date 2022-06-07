package com.jeff_media.borderpatrol;

import de.jeff_media.jefflib.TextUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Map;

public class TeleportationListener implements Listener {

    private static final BorderPatrol main = BorderPatrol.getInstance();

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        main.debug("Player has teleported: " + event.getPlayer().getName());
        World world = event.getTo().getWorld();
        WorldBorder border = world.getWorldBorder();
        if(border == null) {
            main.debug("Return: no border");
            return;
        }
        if(border.isInside(event.getTo())) {
            main.debug("Return: destination is inside border");
            return;
        }
        Location spawn = world.getSpawnLocation();
        if(main.getConfig().isSet("spawn." + world.getName())) {
            spawn = new SimpleLocation(main.getConfig().getConfigurationSection("spawn." + world.getName())).toLocation(world);
            main.debug("Spawn defined: " + spawn);
        } else {
            main.debug("No spawn defined, using world's default spawn point: " + spawn);
        }
        event.setTo(spawn);
        event.getPlayer().sendMessage(TextUtils.format(main.getConfig().getString("message")));
    }
}

package com.jeff_media.borderpatrol;

import co.aikar.commands.PaperCommandManager;
import de.jeff_media.jefflib.JeffLib;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class BorderPatrol extends JavaPlugin {

    private static BorderPatrol instance;
    private boolean debug = false;

    {
        instance = this;
        JeffLib.init(this, false); // No NMS needed
    }

    public static BorderPatrol getInstance() {
        return instance;
    }

    public void debug(String line) {
        if(debug) {
            getLogger().info("[DEBUG] " + line);
        }
    }

    @Override
    public void onEnable() {
        debug = getConfig().getBoolean("debug");
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new TeleportationListener(), this);
        PaperCommandManager acf = new PaperCommandManager(this);
        acf.registerCommand(new SetSpawnCommand());
    }


}

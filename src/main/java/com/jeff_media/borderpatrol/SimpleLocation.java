package com.jeff_media.borderpatrol;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLocation {

    private final double x,y,z;
    //private final float pitch,yaw;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    /*public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }*/

    public SimpleLocation(double x, double y, double z, float pitch, float yaw) {
        this.x = x;
        this.y = y;
        this.z = z;
        //this.pitch = pitch;
        //this.yaw = yaw;
    }

    public SimpleLocation(Location location) {
        this(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
    }

    public Map<String, Object> toMap() {
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("x",x);
        map.put("y",y);
        map.put("z",z);
        //map.put("pitch",pitch);
        //map.put("yaw",yaw);
        return map;
    }

    public SimpleLocation(ConfigurationSection map) {
        double x = (double) map.get("x");
        double y = (double) map.get("y");
        double z = (double) map.get("z");
        //float pitch = (float) map.get("pitch");
        //float yaw = (float) map.get("yaw");
        this.x = x;
        this.y = y;
        this.z = z;
        //this.pitch = pitch;
        //this.yaw = yaw;
    }

    public Location toLocation(World world) {
        return new Location(world, x, y, z/*, pitch, yaw*/);
    }
}

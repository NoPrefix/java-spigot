package de.t23t.tntrun.utils;

import de.t23t.tntrun.exceptions.NotALocationException;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationSerializer {

    String getLocationAsString(Location location) {
        String returnString = "@$serializedLocation(";
        String worldName = location.getWorld().getName();
        double locX = location.getX();
        double locY = location.getY();
        double locZ = location.getZ();
        float yaw = location.getYaw();
        float pitch = location.getPitch();

        returnString += worldName + ",";
        returnString += locX + ",";
        returnString += locY + ",";
        returnString += locZ + ",";
        returnString += yaw + ",";
        returnString += pitch + ")";

        return returnString;
    }

    Location getLocationFromString(String location) throws NotALocationException {
        if(!location.startsWith("@$serializedLocation(")) {
            throw new NotALocationException("Der String \"" + location + "\" ist keine Location!");
        }

        location = location.substring(17);
        String[] splitString = location.split(",");

        String worldName;
        double locX;
        double locY;
        double locZ;
        float yaw;
        float pitch;

        worldName = splitString[0];
        locX = Double.parseDouble(splitString[1]);
        locY = Double.parseDouble(splitString[2]);
        locZ = Double.parseDouble(splitString[3]);
        yaw = Float.parseFloat(splitString[4]);
        pitch = Float.parseFloat(splitString[5]);

        return new Location(Bukkit.getWorld(worldName), locX, locY, locZ, yaw, pitch);
    }

}

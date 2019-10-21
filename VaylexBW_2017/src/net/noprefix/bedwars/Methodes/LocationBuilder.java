package net.noprefix.bedwars.Methodes;

import java.io.File;	

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationBuilder {
	
	public static File file = new File("plugins//Bedwars//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	public static void set(Location loc, String path) {
		String w = loc.getWorld().getName();
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double pitch = loc.getPitch();
		double yaw = loc.getYaw();
		cfg.set(path + ".world", w);
		cfg.set(path + ".x", x);
		cfg.set(path + ".y", y);
		cfg.set(path + ".z", z);
		cfg.set(path + ".pitch", pitch);
		cfg.set(path + ".yaw", yaw);
		try {
		cfg.save(file);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Location load(String path) {
		String w = cfg.getString(path + ".world");
		double x = cfg.getDouble(path + ".x");
		double y = cfg.getDouble(path + ".y");
		double z = cfg.getDouble(path + ".z");
		float  yaw = (float) cfg.getDouble(path + ".yaw");
		float  pitch = (float) cfg.getDouble(path + ".pitch");
		Location loc = new Location(Bukkit.getWorld(w), x, y, z, yaw, pitch);
		return loc;
	}

}

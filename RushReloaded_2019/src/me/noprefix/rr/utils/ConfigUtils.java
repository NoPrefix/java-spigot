package me.noprefix.rr.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import me.noprefix.rr.RushReloaded;

public class ConfigUtils {

	private RushReloaded plugin;
	
	File config;
	File data;
	
	YamlConfiguration config_yamlconfig;
	YamlConfiguration data_yamlconfig;
	
	public void configurate() throws IOException {
		
		plugin = RushReloaded.getPlugin();
		
		config = new File("plugins/RushReloaded/config.yml");
		data = new File("plugins/RushReloaded/data.yml");

		config_yamlconfig = YamlConfiguration.loadConfiguration(config);
	    data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		
		if(!config.exists()) {
			config_yamlconfig.set("prefix", plugin.CONFIG_PREFIX);
			config_yamlconfig.set("size", plugin.SIZE.toString());
			config_yamlconfig.set("mapname", plugin.serverMOTD);
			
			config_yamlconfig.set("USE_MySQL", true);
			
			config_yamlconfig.set("MySQL.host", "host");
			config_yamlconfig.set("MySQL.port", 3306);
			config_yamlconfig.set("MySQL.nutzername", "root");
			config_yamlconfig.set("MySQL.passwort", "passwort");
			config_yamlconfig.set("MySQL.datenbank", "rushreloaded");
			config_yamlconfig.save(config);
			
			configurate();
			
		} 
		
		if(!data.exists()) {
			data_yamlconfig.save(data);
			configurate();
		}
		
		plugin.CONFIG_PREFIX = config_yamlconfig.getString("prefix");
		plugin.serverMOTD = config_yamlconfig.getString("mapname");
		plugin.SIZE = SizeEnum.valueOf(config_yamlconfig.getString("size"));
		plugin.USE_MYSQL = config_yamlconfig.getBoolean("USE_MySQL");
		plugin.MYSQL_HOST = config_yamlconfig.getString("MySQL.host");
		plugin.MYSQL_PORT = config_yamlconfig.getInt("MySQL.port");
		plugin.MYSQL_USER = config_yamlconfig.getString("MySQL.nutzername");
		plugin.MYSQL_PASSWORD = config_yamlconfig.getString("MySQL.passwort");
		plugin.MYSQL_DATABASE = config_yamlconfig.getString("MySQL.datenbank");

		new SetupUtil().setupGame();

		for(Team team : plugin.teams) {
			World world;
			double x, y, z;
			float yaw, pitch;

			world = Bukkit.getWorld(data_yamlconfig.getString("Team." + team.getName() + ".Spawn.World"));
			x = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawn.X");
			y = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawn.Y");
			z = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawn.Z");
			yaw = (float) data_yamlconfig.getDouble("Team." + team.getName() + ".Spawn.Yaw");
			pitch = (float) data_yamlconfig.getDouble("Team." + team.getName() + ".Spawn.Pitch");

			Location loc = new Location(world, x, y, z, yaw, pitch);

			team.setSpawn(loc);

		}

		for(Team team : plugin.teams) {
			World world;
			double x, y, z;
			float yaw, pitch;

			world = Bukkit.getWorld(data_yamlconfig.getString("Team." + team.getName() + ".Spawner.World"));
			x = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawner.X");
			y = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawner.Y");
			z = data_yamlconfig.getDouble("Team." + team.getName() + ".Spawner.Z");
			yaw = (float) data_yamlconfig.getDouble("Team." + team.getName() + ".Spawner.Yaw");
			pitch = (float) data_yamlconfig.getDouble("Team." + team.getName() + ".Spawner.Pitch");

			Location loc = new Location(world, x, y, z, yaw, pitch);

			team.setSpawner(loc);

		}

		World lworld;
		double lx, ly, lz;
		float lyaw, lpitch;

		lworld = Bukkit.getWorld(data_yamlconfig.getString("Lobby.World"));
		lx = data_yamlconfig.getDouble("Lobby.X");
		ly = data_yamlconfig.getDouble("Lobby.Y");
		lz = data_yamlconfig.getDouble("Lobby.Z");
		lyaw = (float) data_yamlconfig.getDouble("Lobby.Yaw");
		lpitch = (float) data_yamlconfig.getDouble("Lobby.Pitch");

		Location loc = new Location(lworld, lx, ly, lz, lyaw, lpitch);

		plugin.LOBBY = loc;

		World sworld;
		double sx, sy, sz;
		float syaw, spitch;

		sworld = Bukkit.getWorld(data_yamlconfig.getString("Spec.World"));
		sx = data_yamlconfig.getDouble("Spec.X");
		sy = data_yamlconfig.getDouble("Spec.Y");
		sz = data_yamlconfig.getDouble("Spec.Z");
		syaw = (float) data_yamlconfig.getDouble("Spec.Yaw");
		spitch = (float) data_yamlconfig.getDouble("Spec.Pitch");

		Location sloc = new Location(sworld, sx, sy, sz, syaw, spitch);

		plugin.SPEC = sloc;

		World dworld;
		double dx, dy, dz;
		float dyaw, dpitch;

		dworld = Bukkit.getWorld(data_yamlconfig.getString("Death.World"));
		dx = data_yamlconfig.getDouble("Death.X");
		dy = data_yamlconfig.getDouble("Death.Y");
		dz = data_yamlconfig.getDouble("Death.Z");
		dyaw = (float) data_yamlconfig.getDouble("Death.Yaw");
		dpitch = (float) data_yamlconfig.getDouble("Death.Pitch");

		Location dloc = new Location(dworld, dx, dy, dz, dyaw, dpitch);

		plugin.DEATH = dloc;

	}

	public void setTeamSpawn(Team team, Location location) throws IOException {
		File data = new File("plugins/RushReloaded/data.yml");
		YamlConfiguration data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.World", location.getWorld().getName());
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.X", location.getX());
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.Y", location.getY());
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.Z", location.getZ());
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.Yaw", location.getYaw());
		data_yamlconfig.set("Team." + team.getName() + ".Spawn.Pitch", location.getPitch());
		data_yamlconfig.save(data);
    }

	public void setTeamSpawner(Team team, Location location) throws IOException {
		File data = new File("plugins/RushReloaded/data.yml");
		YamlConfiguration data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.World", location.getWorld().getName());
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.X", location.getX());
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.Y", location.getY());
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.Z", location.getZ());
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.Yaw", location.getYaw());
		data_yamlconfig.set("Team." + team.getName() + ".Spawner.Pitch", location.getPitch());
		data_yamlconfig.save(data);
	}

	public void setLobby(Location location) throws IOException {
		File data = new File("plugins/RushReloaded/data.yml");
		YamlConfiguration data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		data_yamlconfig.set("Lobby.World", location.getWorld().getName());
		data_yamlconfig.set("Lobby.X", location.getX());
		data_yamlconfig.set("Lobby.Y", location.getY());
		data_yamlconfig.set("Lobby.Z", location.getZ());
		data_yamlconfig.set("Lobby.Yaw", location.getYaw());
		data_yamlconfig.set("Lobby.Pitch", location.getPitch());
		data_yamlconfig.save(data);
	}

	public void setDeath(Location location) throws IOException {
		File data = new File("plugins/RushReloaded/data.yml");
		YamlConfiguration data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		data_yamlconfig.set("Death.World", location.getWorld().getName());
		data_yamlconfig.set("Death.X", location.getX());
		data_yamlconfig.set("Death.Y", location.getY());
		data_yamlconfig.set("Death.Z", location.getZ());
		data_yamlconfig.set("Death.Yaw", location.getYaw());
		data_yamlconfig.set("Death.Pitch", location.getPitch());
		data_yamlconfig.save(data);
	}

	public void setSpec(Location location) throws IOException {
		File data = new File("plugins/RushReloaded/data.yml");
		YamlConfiguration data_yamlconfig = YamlConfiguration.loadConfiguration(data);
		data_yamlconfig.set("Spec.World", location.getWorld().getName());
		data_yamlconfig.set("Spec.X", location.getX());
		data_yamlconfig.set("Spec.Y", location.getY());
		data_yamlconfig.set("Spec.Z", location.getZ());
		data_yamlconfig.set("Spec.Yaw", location.getYaw());
		data_yamlconfig.set("Spec.Pitch", location.getPitch());
		data_yamlconfig.save(data);
	}

	public boolean setSize(String size) {
		File 		config = new File("plugins/RushReloaded/config.yml");
		YamlConfiguration 		config_yamlconfig = YamlConfiguration.loadConfiguration(config);
		SizeEnum sizeEnum = SizeEnum.valueOf(size);
		if(sizeEnum == SizeEnum.SIZE_2x1 || sizeEnum == SizeEnum.SIZE_4x1 || 
				sizeEnum == SizeEnum.SIZE_8x1 ||  sizeEnum == SizeEnum.SIZE_4x2) {
		config_yamlconfig.set("size", size);
		try {
			config_yamlconfig.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
		}
		return false;
	}
	
	public void setName(String name) {
		File 		config = new File("plugins/RushReloaded/config.yml");
		YamlConfiguration 		config_yamlconfig = YamlConfiguration.loadConfiguration(config);
		config_yamlconfig.set("mapname", name);
		try {
			config_yamlconfig.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

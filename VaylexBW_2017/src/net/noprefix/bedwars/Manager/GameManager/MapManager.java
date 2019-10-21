package net.noprefix.bedwars.Manager.GameManager;

import java.io.File;		
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class MapManager {
	
	public static ArrayList<String> maps = new ArrayList<>();
	public static String map;
	
	
	public static void createMap(String name) {
		File file = new File("plugins//Bedwars//Database.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.get("Maps.Size") == null) {
			cfg.set("Maps.Size", Integer.valueOf(0));
		}
		int i = cfg.getInt("Maps.Size");
		i++;
		cfg.set("Maps." + i, name);
		cfg.set("Maps.Size", i);
		try {
			cfg.save(file);
		} catch (IOException e) {
		}
	}
	
	public static Integer getID(String name) {
		File file = new File("plugins//Bedwars//Database.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		for(int i = 0; i < cfg.getInt("Maps.Size"); i++) {
			if(cfg.get("Maps." + i).equals(name)) {
				return i;
			}	
		}
		return 1;
	}
	
	public static void loadMaps() {
		File file = new File("plugins//Bedwars//Database.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		for(int i = 1; i < (cfg.getInt("Maps.Size")+1); i++) {
			maps.add(cfg.getString("Maps." + i));
			
		}
	}
	
	public static void reloadMapData() {
		maps.clear();
		File file = new File("plugins//Bedwars//Database.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		for(int i = 1; i < (cfg.getInt("Maps.Size")+1); i++) {
			maps.add(cfg.getString("Maps." + i));
			
		}
		
	}
	
	public static void setMap() {
		File file = new File("plugins//Bedwars//Database.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			Random rs = new Random();
			int i = rs.nextInt(cfg.getInt("Maps.Size")+1);
			if(i == 0) {
				setMap();
			}else {
				map = cfg.getString("Maps." + i);
			}
			
			
			
	}
	
    public static void copy(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    public static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    public static void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }
    
    public static void loadMap() {
    	World w =Main.plugin.getServer().createWorld(new WorldCreator("Map").environment(World.Environment.NORMAL));
    	w.setTime(3000);
        w.setGameRuleValue("randomTickSpeed", "false");
        w.setGameRuleValue("doDaylightCycle", "false");
        w.setGameRuleValue("doMobSpawning", "false");
        for(Entity current : w.getEntities()) {
            if(!(w instanceof Player || w instanceof ItemFrame || w instanceof Painting)) {
                current.remove();
            }
        }
    	
    }

}

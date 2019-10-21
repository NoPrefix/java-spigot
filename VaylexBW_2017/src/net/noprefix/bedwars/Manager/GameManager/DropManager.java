package net.noprefix.bedwars.Manager.GameManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.noprefix.bedwars.Main.Main;

public class DropManager {

	  public static Integer setSpawn(String type, Location loc, String map)
	  {
	    int i = 0;
	    
	    File file = new File(Main.plugin.getDataFolder().getPath(), "spawner.yml");
	    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    
	    i = cfg.getInt(map + "." + type + ".amount");
	    i++;
	    cfg.set(map + "." + type + ".amount", Integer.valueOf(i));
	    
	    cfg.set(map + "." + type + "." + i + ".world", loc.getWorld().getName());
	    cfg.set(map + "." + type + "." + i + ".x", Double.valueOf(loc.getX()));
	    cfg.set(map + "." + type + "." + i + ".y", Double.valueOf(loc.getY()));
	    cfg.set(map + "." + type + "." + i + ".z", Double.valueOf(loc.getZ()));
	    try
	    {
	      cfg.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    return Integer.valueOf(i);
	  }
	  
	  public static void spawn(String type, ItemStack item, String map)
	  {
	    File file = new File(Main.plugin.getDataFolder().getPath(), "spawner.yml");
	    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	    int amount = cfg.getInt(map + "." + type + ".amount");
	    for (int i = 1; i < amount + 1; i++)
	    {
	      String world = cfg.getString(map + "." + type + "." + i + ".world");
	      double x = cfg.getDouble(map + "." + type + "." + i + ".x");
	      double y = cfg.getDouble(map + "." + type + "." + i + ".y");
	      double z = cfg.getDouble(map + "." + type + "." + i + ".z");
	      Location loc = new Location(Bukkit.getWorld(world), x, y, z);
	      loc.getWorld().dropItemNaturally(loc, item);
	    }
	  }
	  
	  public static void start(String map)
	  {
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        ItemStack item = new ItemStack(Material.CLAY_BRICK);
	        ItemMeta meta = item.getItemMeta();
	        meta.setDisplayName("§cBronze");
	        item.setItemMeta(meta);
	        spawn("bronze", item, map);
	      }
	    }, 10L, 10L);
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        ItemStack item = new ItemStack(Material.IRON_INGOT);
	        ItemMeta meta = item.getItemMeta();
	        meta.setDisplayName("§7Eisen");
	        item.setItemMeta(meta);
	        spawn("eisen", item, map);
	      }
	    }, 200L, 300L);
	    
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        ItemStack item = new ItemStack(Material.GOLD_INGOT);
	        ItemMeta meta = item.getItemMeta();
	        meta.setDisplayName("§eGold");
	        item.setItemMeta(meta);
	        spawn("gold", item, map);
	      }
	    }, 600L, 600L);
	  }
	  
}

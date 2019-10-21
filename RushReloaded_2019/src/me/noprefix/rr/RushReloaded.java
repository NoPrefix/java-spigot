package me.noprefix.rr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import me.noprefix.rr.listeners.*;
import me.noprefix.rr.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.noprefix.rr.commands.RushReloadedCommand;
import me.noprefix.rr.commands.StartCommand;
import net.md_5.bungee.api.ChatColor;

public class RushReloaded extends JavaPlugin {
	
	private static RushReloaded plugin;
	
	public String spigotPluginDownloadLink = "https://spigotmc.org/resources/-";
	public String serverMOTD = "RushReloaded";
	public int maxPlayers = 2;
	public String CONFIG_PREFIX = "&7[&aRushReloaded&7] &r";
	public String PREFIX = ChatColor.translateAlternateColorCodes('&', CONFIG_PREFIX);
	public SizeEnum SIZE = SizeEnum.SIZE_4x1;
	
	public boolean USE_MYSQL = true;
	public boolean ingame = false;
	
	public String MYSQL_HOST = "UNSET";
	public int MYSQL_PORT = 3306;
	public String MYSQL_USER = "UNSET";
	public String MYSQL_PASSWORD = "UNSET";
	public String MYSQL_DATABASE = "UNSET";

	public boolean AUFGESETZT = false;
	
	public Location LOBBY;
	public Location SPEC;
	public Location DEATH;
	
	public HashMap<Player, Team> locations = new HashMap<>();
	public ArrayList<Team> teams = new ArrayList<>();
	public HashMap<Player, Team> teamMap = new HashMap<>();

	public ArrayList<Player> ingamePlayers = new ArrayList<>();
	public ArrayList<Player> specPlayers = new ArrayList<>();

	public Inventory shopInv = Bukkit.createInventory(null, 9, "§aRush-Shop");

	private CommandUtils commandUtils;
	private ConfigUtils configUtils;
	private CountdownUtil countDownUtil;
	private DisplayUtil displayUtil;
	private SpectatorUtil spectatorUtil;
	
	private PluginManager pluginManager;
	
	@Override
	public void onEnable() {
		setup();
	}

	@Override
	public void onDisable() {
		Bukkit.getOnlinePlayers().forEach((p) -> p.kickPlayer("§cDer Server lädt neu!") );
	}
	
	
	private void setup() {
		
		//Alles variablen instanzieren, Commands instanzieren und Listener registrieren
		
		plugin = this;
		pluginManager = Bukkit.getPluginManager();
		
		new RushReloadedCommand(this);
		new StartCommand(this);
		
		commandUtils = new CommandUtils();
		configUtils = new ConfigUtils();
		countDownUtil = new CountdownUtil();
		displayUtil = new DisplayUtil();
		spectatorUtil = new SpectatorUtil();
		
		pluginManager.registerEvents(new PlayerJoinListener(), this);
		pluginManager.registerEvents(new PlayerQuitListener(), this);
		pluginManager.registerEvents(new MainListener(), this);
		pluginManager.registerEvents(new InteractAtEntity(), this);
		pluginManager.registerEvents(new InventoryClickListener(), this);
		pluginManager.registerEvents(new IngameListeners(), this);
		
		try {
			new ConfigUtils().configurate();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		if(MYSQL_HOST.equals("UNSET") || MYSQL_HOST.equals("host") && USE_MYSQL) {
			getLogger().info("[FEHLER] Es wurden keine MySQL Daten eingetragen obwohl USE_MySQL aktiviert ist!");
		}

		fillShopInv();
		
	}
	
	public static RushReloaded getPlugin() {
		return plugin;
	}
	
	public CommandUtils getCommandUtils() {
		return commandUtils;
	}
	
	public ConfigUtils getConfigUtils() {
		return configUtils;
	}
	
	public CountdownUtil getCountDownUtil() {
		return countDownUtil;
	}

	public DisplayUtil getDisplayUtil() {
		return displayUtil;
	}

	public SpectatorUtil getSpectatorUtil() {
		return spectatorUtil;
	}

	private void fillShopInv() {
		shopInv.setItem(2, new ItemAPI(Material.STICK).setName("§aKnockback Stick").addLoreLine("§c8 Bronze").addEnchant(Enchantment.KNOCKBACK, 2).toItemStack());
		shopInv.setItem(3, new ItemAPI(Material.WOOD_PICKAXE).setName("§aSpitzhacke").addLoreLine("§c4 Bronze").toItemStack());
		ItemStack blocks = new ItemAPI(Material.SANDSTONE).setName("§aBlöcke").addLoreLine("§c1 Bronze").toItemStack();
		blocks.setAmount(4);
		shopInv.setItem(1, blocks);
		shopInv.setItem(4, new ItemAPI(Material.ENDER_STONE).setName("§aEndstein").addLoreLine("§a8 Bronze").toItemStack());
		shopInv.setItem(5, new ItemAPI(Material.FISHING_ROD).setName("§aAngel").addLoreLine("§c5 Bronze").toItemStack());
	}

	public boolean canEndGame() {
		int counter = 0;
		for(Team team : teams) {
			if(team.getCurrentPlayers() >= 1)
				counter++;
		}

		if(counter <= 1)
			return true;
		return false;
	}

	public Team getWinnerTeam() {
		for(Team team : teams) {
			if(team.getCurrentPlayers() >= 1)
				return team;
		}
		return null;
	}
	
}

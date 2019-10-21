package net.noprefix.bedwars.Main;
	
import java.lang.reflect.Field;	
import java.util.ArrayList;

import net.noprefix.bedwars.Armor.LobbyArmor;
import net.noprefix.bedwars.Commands.CMDforcemap;
import net.noprefix.bedwars.Commands.CMDsetup;
import net.noprefix.bedwars.Commands.CMDstart;
import net.noprefix.bedwars.Commands.CMDstats;
import net.noprefix.bedwars.Listener.Block.PlayerAsyncChatListener;
import net.noprefix.bedwars.Listener.PlayerInventoryListener;
import net.noprefix.bedwars.Listener.PlayerMoveListener;
import net.noprefix.bedwars.Listener.PlayerQuitListener;
import net.noprefix.bedwars.Listener.PlayerRespawnListener;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.MapVoting.ArmorMap;
import net.noprefix.bedwars.MySQL.Database.Database;
import net.noprefix.bedwars.Scoreboards.LobbyScoreboard;
import net.noprefix.bedwars.States.GameState;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.authlib.GameProfile;

import net.noprefix.bedwars.Countdowns.IDLECountdown;
import net.noprefix.bedwars.Database.Data;
import net.noprefix.bedwars.Listener.PlayerBedEnterListener;
import net.noprefix.bedwars.Listener.PlayerBlockBreakListener;
import net.noprefix.bedwars.Listener.PlayerDamageListener;
import net.noprefix.bedwars.Listener.PlayerDeathListener;
import net.noprefix.bedwars.Listener.PlayerInteractATListener;
import net.noprefix.bedwars.Listener.PlayerInteractListener;
import net.noprefix.bedwars.Listener.PlayerJoinListener;
import net.noprefix.bedwars.Listener.PlayerServerListener;
import net.noprefix.bedwars.Listener.Block.PlayerBlockPlaceListener;
import net.noprefix.bedwars.Listener.Block.PlayerCraftListener;
import net.noprefix.bedwars.Listener.Block.PlayerDropListener;
import net.noprefix.bedwars.Listener.Block.PlayerFoodListener;
import net.noprefix.bedwars.Listener.Block.PlayerPicItemListener;
import net.noprefix.bedwars.Listener.Block.PlayerWetherListener;
import net.noprefix.bedwars.Manager.RankAPI;
import net.noprefix.bedwars.MySQL.MySQL;
import net.noprefix.bedwars.MySQL.Ranking;
import net.noprefix.bedwars.MySQL.APIS.NickAPI;

public class Main extends JavaPlugin{
	
	private Data database;
	private LobbyScoreboard lobbyScoreboard;
	private MySQL sql;
	private LobbyArmor lobbyArmor;
	private Ranking r;
	private ArmorMap am;
	private NickAPI nickAPI;
	private Database nickManager;
	public static Main plugin;
	public static String prefix = "§7» §cBedwars §7┃ ";
	private String nickprefix = "§7» §5Nick §7┃ ";
	public static GameState gs = GameState.LOBBY;
	public static SizeState ss = SizeState.SIZE2x1;
	public static RankAPI rankAPI;
	public static ArrayList<Player> ONLINE_Players = new ArrayList<>();
	public static ArrayList<Player> SPEC_PLAYERS = new ArrayList<>();
	public static Field nameField;
	
	@Override
	public void onEnable() {

		plugin = this;
		
		
		sql = new MySQL();
		rankAPI = new RankAPI();
		database = new Data();
		am = new ArmorMap();
		nickManager = new Database();
		lobbyArmor = new LobbyArmor();
		lobbyScoreboard = new LobbyScoreboard();
		nickAPI = new NickAPI();
		r = new Ranking();
		nameField = getNickAPI().getField(GameProfile.class, "name");
		
		sql.connect();
		sql.createTable();
		
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFoodListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInventoryListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerBlockPlaceListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerFoodListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRespawnListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerCraftListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerBlockBreakListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractATListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerPicItemListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerBedEnterListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDropListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerServerListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerWetherListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerAsyncChatListener(), this);
		
		getCommand("setup").setExecutor(new CMDsetup());
		getCommand("stats").setExecutor(new CMDstats());
		getCommand("start").setExecutor(new CMDstart());
		getCommand("forcemap").setExecutor(new CMDforcemap());
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		MapManager.loadMaps();

		IDLECountdown.start();
		
		MapManager.setMap();
		
		
		getRanking().set();
		
	}
	
	@Override
	public void onDisable() {
		sql.close();
	}

	
	public Data getData() {
		return database;
	}
	
	public LobbyScoreboard getLobbyScoreboard() {
		return lobbyScoreboard;
	}
	
	public MySQL getSQL() {
		return sql;
	}
	
	public Ranking getRanking() {
		return r;
	}

	public LobbyArmor getLobbyArmor() {
		return lobbyArmor;
	}
	
	public ArmorMap getArmorMap() {
		return am;
	}
	
	public NickAPI getNickAPI() {
		return nickAPI;
	}
	
	public Database getNickManager() {
		return nickManager;
	}
	
	public String getNickPrefix() {
		return nickprefix;
	}

}

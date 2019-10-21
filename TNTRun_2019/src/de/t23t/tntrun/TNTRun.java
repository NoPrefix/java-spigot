package de.t23t.tntrun;

import de.t23t.tntrun.commands.BuildCommand;
import de.t23t.tntrun.commands.SetupCommand;
import de.t23t.tntrun.commands.StartCommand;
import de.t23t.tntrun.exceptions.ConfigDoesntExistException;
import de.t23t.tntrun.exceptions.NotALocationException;
import de.t23t.tntrun.listener.MainListener;
import de.t23t.tntrun.listener.PlayerJoinListener;
import de.t23t.tntrun.listener.PlayerQuitListener;
import de.t23t.tntrun.runnables.LobbyCountdown;
import de.t23t.tntrun.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TNTRun extends JavaPlugin {

    private static TNTRun plugin;
    public PluginManager pluginManager;
    private LocationSerializer locationSerializer;
    private GameState currentGameState;
    public ConfigManager configManager;
    public CountdownUtil countdownUtil;
    public LobbyCountdown lobbyCountdown;

    public Location spawnLocation;
    public Location endLocation;
    public Location fireworkLocation;
    public double deathHeight;
    public boolean readyToRun;
    public int ingameTaskID;
    public int lobbyTaskID;

    public ArrayList<Player> ingamePlayers = new ArrayList<>();
    public HashMap<Player, TNTPlayer> playerMap = new HashMap<>();

    @Override
    public void onEnable() {
        try {
            instantiate();
            setup();
        } catch (IOException | NotALocationException e) {
            e.printStackTrace();
        }
    }

    private void instantiate() throws IOException {
        plugin = this;
        pluginManager = Bukkit.getPluginManager();
        locationSerializer = new LocationSerializer();
        currentGameState = GameState.LOBBY;
        configManager = new ConfigManager(new File("plugins/TNTRun/locations.yml"));
        countdownUtil = new CountdownUtil();
    }

    private void setup() throws NotALocationException {
        try {
            configManager.loadConfig();
        } catch (ConfigDoesntExistException ex) {
            ex.printStackTrace();
        }
        pluginManager.registerEvents(new MainListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);

        getCommand("setup").setExecutor(new SetupCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("build").setExecutor(new BuildCommand());
    }

    @Override
    public void onDisable() {

    }

    public static TNTRun getPlugin() {
        return plugin;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public LocationSerializer getLocationSerializer() {
        return locationSerializer;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}

package de.t23t.tntrun.utils;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.exceptions.ConfigDoesntExistException;
import de.t23t.tntrun.exceptions.NotALocationException;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private File file;
    private YamlConfiguration config;

    public ConfigManager(File file) throws IOException {
        this.file = file;
        config = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            config.save(file);
        }
    }

    public void loadConfig() throws ConfigDoesntExistException {
        try {
            LocationSerializer locationSerializer = TNTRun.getPlugin().getLocationSerializer();
            /*TNTRun.getPlugin().spawnLocation = locationSerializer.getLocationFromString(config.getString("spawnLocation"));
            TNTRun.getPlugin().endLocation = locationSerializer.getLocationFromString(config.getString("endLocation"));
            TNTRun.getPlugin().fireworkLocation = locationSerializer.getLocationFromString(config.getString("fireworkLocation"));
            TNTRun.getPlugin().deathHeight = config.getDouble("deathHeight");
            TNTRun.getPlugin().readyToRun = config.getBoolean("readyToRun");*/

            TNTRun.getPlugin().spawnLocation = (Location)config.get("spawnLocation");
            TNTRun.getPlugin().endLocation = (Location)config.get("spawnLocation");
            TNTRun.getPlugin().fireworkLocation = (Location)config.get("spawnLocation");
            TNTRun.getPlugin().deathHeight = config.getDouble("deathHeight");
            TNTRun.getPlugin().readyToRun = config.getBoolean("readyToRun");

        } catch (Exception ex) {
            throw new ConfigDoesntExistException("Die Config-Datei wurde noch nicht aufgesetzt:\n" + ex
                    .getMessage());
        }
    }

    public void saveConfig() throws IOException {
        config.set("spawnLocation", TNTRun.getPlugin().spawnLocation);
        config.set("endLocation", TNTRun.getPlugin().endLocation);
        config.set("fireworkLocation", TNTRun.getPlugin().fireworkLocation);
        config.set("deathHeight", TNTRun.getPlugin().deathHeight);
        if (TNTRun.getPlugin().fireworkLocation != null && TNTRun.getPlugin().endLocation != null && TNTRun.getPlugin().spawnLocation != null) {
            config.set("readyToRun", true);
        } else {
            config.set("readyToRun", false);
        }
        config.save(file);
    }

}

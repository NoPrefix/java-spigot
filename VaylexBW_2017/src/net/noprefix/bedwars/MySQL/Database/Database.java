package net.noprefix.bedwars.MySQL.Database;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Database {
	
	public Boolean getNick(String uuid) {
		File fileUUID = new File("/Datenbank/Players/" + uuid + ".yml");
		YamlConfiguration cfgUUID = YamlConfiguration.loadConfiguration(fileUUID);
		return cfgUUID.getBoolean("NickSystem");
	}

}

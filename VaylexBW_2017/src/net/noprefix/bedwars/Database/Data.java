package net.noprefix.bedwars.Database;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Data {
	
	public Integer getBytes(String uuid) {
		File fileUUID = new File("/Datenbank/Playerdata/Bytessystem/" + uuid + ".yml");
		YamlConfiguration cfgUUID = YamlConfiguration.loadConfiguration(fileUUID);
		return cfgUUID.getInt("Bytes");
		
	}
	
	public void setBytes(String uuid, Integer coins) {
		File fileUUID = new File("/Datenbank/Playerdata/Bytessystem/" + uuid + ".yml");
		YamlConfiguration cfgUUID = YamlConfiguration.loadConfiguration(fileUUID);
		if(isBytesExist(uuid) == true) {
			cfgUUID.set("Bytes", coins);
			try {
				cfgUUID.save(fileUUID);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			createBytePlayer(uuid);
			setBytes(uuid, coins);
		}
	}
	
	public Boolean isBytesExist(String uuid) {
		File fileUUID = new File("/Datenbank/Playerdata/Bytessystem/" + uuid + ".yml");
		if(fileUUID.exists()) {
			return true;
			
		}else{
			return false;
		}
	}
	
	public void createBytePlayer(String uuid) {
		File fileUUID = new File("/Datenbank/Playerdata/Bytessystem/" + uuid + ".yml");
		YamlConfiguration cfgUUID = YamlConfiguration.loadConfiguration(fileUUID);
		
		if(isBytesExist(uuid) == false) {
			cfgUUID.set("Bytes", 50);
			cfgUUID.set("Chests", 1);
			cfgUUID.set("Tickets", 3);
			cfgUUID.set("Cookies", 0);
			try {
				cfgUUID.save(fileUUID);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

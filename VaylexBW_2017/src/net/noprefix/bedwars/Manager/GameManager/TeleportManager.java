package net.noprefix.bedwars.Manager.GameManager;

import net.noprefix.bedwars.Methodes.LocationBuilder;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class TeleportManager {
	
	public static void teleport() {
		for(Player all : Main.ONLINE_Players) {
			Main.plugin.getSQL().addGames(all.getUniqueId().toString(), 1);
			all.playSound(all.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
			if(TeamManager.teamBlau.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
			}else if(TeamManager.teamRot.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Rot"));
			}else if(TeamManager.teamGelb.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Gelb"));
			}else if(TeamManager.teamGruen.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Gruen"));
			}else if(TeamManager.teamLila.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Lila"));
			}else if(TeamManager.teamSchwarz.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Schwarz"));
			}else if(TeamManager.teamTurkis.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Turkis"));
			}else if(TeamManager.teamOrange.contains(all)) {
				all.teleport(LocationBuilder.load("Location." + MapManager.map + ".Orange"));
			}
			
			
		}
		
	}

}

package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Methodes.ItemBuilder;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;

public class PlayerRespawnListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onR(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		
		if(TeamManager.teamBlau.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
		}else if(TeamManager.teamRot.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Rot"));
		}else if(TeamManager.teamGelb.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Gelb"));
		}else if(TeamManager.teamGruen.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Gruen"));
		}else if(TeamManager.teamLila.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Lila"));
		}else if(TeamManager.teamSchwarz.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Schwarz"));
		}else if(TeamManager.teamOrange.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Orange"));
		}else if(TeamManager.teamTurkis.contains(e.getPlayer())) {
			e.setRespawnLocation(LocationBuilder.load("Location." + MapManager.map + ".Turkis"));
		}else if(Main.gs == GameState.INGAME) {
			p.getInventory().setItem(2,  new ItemBuilder(Material.COMPASS).setName("§8» §2Teleporter §8┃ §7Rechtsklick").toItemStack());
			p.getInventory().setItem(6,  new ItemBuilder(Material.SLIME_BALL).setName("§8» §2Zurück §8┃ §7Rechtsklick").toItemStack());
			e.setRespawnLocation(LocationBuilder.load("Spectator." + MapManager.map));
			p.sendTitle("§cDu bist ausgeschieden!", "");
		}else {
			e.setRespawnLocation(LocationBuilder.load("Location.Lobby"));
		}
		
	}

}

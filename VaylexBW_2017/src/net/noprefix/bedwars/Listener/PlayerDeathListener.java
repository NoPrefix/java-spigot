package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.API;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import net.noprefix.bedwars.Scoreboards.InGameScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDEath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();
		e.setDeathMessage(null);
		e.getDrops().clear();
		API.Respawn(p, 1);
		if(k != null) {
			
			API.kills.put(k, (API.kills.get(k)+1));
			API.tode.put(p, (API.tode.get(p)+1));
			API.punkte.put(k, (API.punkte.get(k)+5));
			API.punkte.put(p, (API.punkte.get(p)-2));
			
		
		
			Main.plugin.getSQL().addKill(k.getUniqueId().toString(), 1);
			Main.plugin.getSQL().addDeaths(p.getUniqueId().toString(), 1);
			Main.plugin.getSQL().addPoints(k.getUniqueId().toString(), 2);
			k.sendMessage(Main.prefix + "§a+ 2 Coins");
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Main.prefix + "§7Der Spieler " + TeamManager.getTeamColors(p) + p.getName() + "§7 wurde von " + TeamManager.getTeamColors(k) + k.getName() + "§7 getötet§7!");
				k.playSound(k.getLocation(), Sound.NOTE_PIANO, 1, 1);
				
			}
			
			if(TeamManager.teamBlau.contains(p) && TeamManager.bedBlau == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamBlau.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamRot.contains(p) && TeamManager.bedRot == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamRot.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamGelb.contains(p) && TeamManager.bedGelb == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamGelb.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamGruen.contains(p) && TeamManager.bedGruen == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamGruen.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamLila.contains(p) && TeamManager.bedLila == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamLila.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamSchwarz.contains(p) && TeamManager.bedSchwarz == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamSchwarz.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamOrange.contains(p) && TeamManager.bedOrange == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamOrange.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamTurkis.contains(p) && TeamManager.bedTurkis == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamTurkis.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else {
				
			}
			
		}else {
			for(Player all : Bukkit.getOnlinePlayers()) all.sendMessage(Main.prefix + "§7Der Spieler " + TeamManager.getTeamColors(p) + p.getName() + "§7 ist gestorben§8!");
			
			if(TeamManager.teamBlau.contains(p) && TeamManager.bedBlau == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamBlau.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamRot.contains(p) && TeamManager.bedRot == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamRot.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamGelb.contains(p) && TeamManager.bedGelb == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamGelb.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamGruen.contains(p) && TeamManager.bedGruen == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamGruen.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						all.hidePlayer(p);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamLila.contains(p) && TeamManager.bedLila == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamLila.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				p.teleport(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						p.hidePlayer(all);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamSchwarz.contains(p) && TeamManager.bedSchwarz == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamSchwarz.remove(p);
				p.setAllowFlight(true);
				Main.SPEC_PLAYERS.add(p);
				p.teleport(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						p.hidePlayer(all);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamOrange.contains(p) && TeamManager.bedOrange == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamOrange.remove(p);
				Main.SPEC_PLAYERS.add(p);
				p.setAllowFlight(true);
				p.teleport(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						p.hidePlayer(all);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}else if(TeamManager.teamTurkis.contains(p) && TeamManager.bedTurkis == false) {
				Main.ONLINE_Players.remove(p);
				TeamManager.teamTurkis.remove(p);
				p.setAllowFlight(true);

				p.teleport(LocationBuilder.load("Location." + MapManager.map + ".Blau"));
				for(Player all : Bukkit.getOnlinePlayers()) {
					InGameScoreboard.setScoreboard(all);
					if(!Main.SPEC_PLAYERS.contains(all)) {
						p.hidePlayer(all);
					}
				}
				p.sendMessage(Main.prefix + "§7Du bist §e§lleider §7ausgeschieden§8!");
				p.sendTitle("§cDu bist ausgeschieden!", null);
				API.win();
				
			}
		}
		
		
	}
}

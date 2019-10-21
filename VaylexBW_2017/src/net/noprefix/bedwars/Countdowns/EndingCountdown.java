package net.noprefix.bedwars.Countdowns;

import org.bukkit.Bukkit;	
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import net.noprefix.bedwars.States.GameState;

public class EndingCountdown {
	
	public static BukkitTask task;
	public static Integer count = 12;
	
	public static void start() {
		task = Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if(count == 12) { 
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.teleport(LocationBuilder.load("Location.Lobby"));all.setGameMode(GameMode.SURVIVAL);Main.gs = GameState.ENDING;
						all.getInventory().clear();all.setFoodLevel(20);all.setHealthScale(20.0D);all.setHealth(20.0D);all.setAllowFlight(false);
		
						all.sendTitle(TeamManager.getTeamColors(Main.ONLINE_Players.get(0)) + Main.ONLINE_Players.get(0).getName(), "§7 hat das Spiel gewonnen!");
					if(!Main.SPEC_PLAYERS.contains(all)) {
							all.showPlayer(all);
						}
				}
				
				Main.plugin.getSQL().addWins(Main.ONLINE_Players.get(0).getUniqueId().toString(), 1);
				Main.plugin.getSQL().addPoints(Main.ONLINE_Players.get(0).getUniqueId().toString(), 50);
				}
				if(count == 11) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.teleport(LocationBuilder.load("Location.Lobby"));
					}
				}
				if(count == 1) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(Main.prefix + "§7Der Server §a§lstoppt §7nun§8!");
			             all.kickPlayer(null);
						}
					}
				if(count == 0) {
					Bukkit.shutdown();
				}
				if(count == 11 || count == 6 || count == 4 || count == 3 || count == 2) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(Main.prefix + "§7Der Server stoppt in §a§l" + (count-1) + " Sekunden§8!");}}
				count--;
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.setLevel(count-1);}
			}
		}, 0L, 20L);
	}

}

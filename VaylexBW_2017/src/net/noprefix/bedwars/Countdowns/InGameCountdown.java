package net.noprefix.bedwars.Countdowns;

import org.bukkit.Bukkit;	
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.API;

public class InGameCountdown {
	
	public static int min = 29;
	public static int sec = 59;
	public static BukkitTask task;
	
	public static void start() {
		task = Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				
				sec--;
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					API.sendActionBar(all, Main.prefix + "§7Dein Team §8» " + TeamManager.getTeam(all) + "§8 ┃ §7Zeit §8» §e" + min + "§e:" + sec);
				} 
				
				
				if(sec < 10) {
					for(Player all : Bukkit.getOnlinePlayers()) {
						API.sendActionBar(all, Main.prefix + "§7Dein Team §8» " + TeamManager.getTeam(all) + "§8 ┃ §7Zeit §8» §e" + min + "§e:0" + sec);
					}
				}else {
					for(Player all : Bukkit.getOnlinePlayers()) {
						API.sendActionBar(all, Main.prefix + "§7Dein Team §8» " + TeamManager.getTeam(all) + "§8 ┃ §7Zeit §8» §e" + min + "§e:" + sec);
					} 
				}
				
				if(sec == 0) {
					min--;
					sec = 59;
				}
				
				
				
			}
		}, 0L, 20L);
		
	} 
	
	public static void stop() {
		task.cancel();
		
	}

}

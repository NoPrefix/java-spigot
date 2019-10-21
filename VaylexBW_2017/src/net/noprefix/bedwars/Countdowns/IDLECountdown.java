package net.noprefix.bedwars.Countdowns;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import net.noprefix.bedwars.Methodes.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class IDLECountdown {
	
	public static BukkitTask task;
	
	public static void start() {
		task = Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
			
			@Override
			public void run() {
				int plays = (SizeManager.getMaxPlayers()-Main.ONLINE_Players.size());
				for(Player all : Main.ONLINE_Players) {
					API.sendActionBar(all, Main.prefix + "§7Warten auf §a§l" + plays + "§7 weitere Spieler...");
				}
			}
		}, 0L, 20L);
		
	}
	
	public static void stop() {
		task.cancel();
		
		
	}

}

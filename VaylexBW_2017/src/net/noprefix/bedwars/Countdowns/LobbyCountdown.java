package net.noprefix.bedwars.Countdowns;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.DropManager;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Manager.GameManager.TeleportManager;
import net.noprefix.bedwars.Methodes.API;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import net.noprefix.bedwars.Scoreboards.InGameScoreboard;
import net.noprefix.bedwars.States.GameState;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.server.ServerState;

public class LobbyCountdown {
	
	public static BukkitTask task;
	public static Integer count;
	public static Boolean run = false;
	
	public static void start() {
		if(run == false) {
			count = 61;
			IDLECountdown.stop();
			run = true;
			if(Main.ss == SizeState.SIZE8x1 && Main.ONLINE_Players.size() >= 2 || Main.ss == SizeState.SIZE2x1 && Main.ONLINE_Players.size() == 2 || Main.ss == SizeState.SIZE4x2 && Main.ONLINE_Players.size() >= 3) {
			task = Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					if(Main.ss == SizeState.SIZE8x1 && Main.ONLINE_Players.size() >= 2 || Main.ss == SizeState.SIZE4x2 && Main.ONLINE_Players.size() >= 3 || Main.ss == SizeState.SIZE2x1 && Main.ONLINE_Players.size() == 2) {
						count--;
						
						
						for(Player all : Main.ONLINE_Players) {
							all.setLevel(count);
							all.setExp((float) count / 60);
							API.sendActionBar(all, Main.prefix + "§7Dein Team §8» " + TeamManager.getTeam(all));
							
						}
						if(count == 5) {
						
					        World w = Main.plugin.getServer().createWorld(new WorldCreator(MapManager.map).environment(World.Environment.NORMAL));
					        w.setTime(3000);
					        w.setGameRuleValue("randomTickSpeed", "false");
					        w.setGameRuleValue("doDaylightCycle", "false");
					        w.setGameRuleValue("doMobSpawning", "false");
					      
					        WorldBorder wb = w.getWorldBorder();
		                    wb.setSize(150);
		                    wb.setCenter(LocationBuilder.load("Spectator." + MapManager.map));
		                    wb.setDamageAmount(0);
				
							
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 1, 1);
								all.sendMessage(Main.prefix + "");
								all.sendMessage(Main.prefix + "§7Map §8» §6§l" + MapManager.map);
								all.sendMessage(Main.prefix + "§7Erbauer §8» §eVaylex");
								all.sendMessage(Main.prefix + "");
								
							}
							
						}
						
						if(count == 0) {
							Main.gs = GameState.INGAME;
							CloudServer.getInstance().setServerStateAndUpdate(ServerState.INGAME);
							TeamManager.getTeamVULL();
							TeamManager.checkBedTeams();
							for(Player all : Bukkit.getOnlinePlayers()) {
								
								all.sendMessage(Main.prefix + "§7Dein Team: " + TeamManager.getTeam(all));
								all.getInventory().clear();
								InGameScoreboard.setScoreboard(all);
								all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
							}
							TeleportManager.teleport();
							DropManager.start(MapManager.map);
							task.cancel();
						
							
							InGameCountdown.start();


							if(count == 50 || count == 40 ||  count == 30 ||  count == 20 ||  count == 10 ||  count == 5 ||  count == 4 ||  count == 3 ||  count == 2 ||  count == 1)
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.sendMessage(Main.prefix + "§7Das Spiel startet in §a" + count + "§a Sekunden§8!");
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 1, 1);
								}
		
						}
					}else {
						stop();
					}
					
				}
			}, 0L, 20L);
			
			}else {
				run = false;
				IDLECountdown.start();
			}
			
		}
		 
	}
	 
	public static void stop(){
		task.cancel();
		run = false;
		IDLECountdown.start();
	}

}

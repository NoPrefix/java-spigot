package me.noprefix.rr.utils;

import com.avaje.ebeaninternal.server.core.Message;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.noprefix.rr.RushReloaded;

public class CountdownUtil {

	public int counter;
	public boolean started;
	int taskid = -1;
	int taskid2 = -1;
	
	public void startLobbyCountdown(int seconds) {
		started = true;
		counter = seconds;
		setLevelForAll(60);	
		setTaskId(Bukkit.getScheduler().runTaskTimer(RushReloaded.getPlugin(), () -> {
			
			if(counter == seconds) {
				gameStartsIn(counter);
			} else if(counter == 0) {
				for(Team team : RushReloaded.getPlugin().teams) {
					for(Player player : team.getPlayersIn()) {
						player.teleport(team.getSpawn());
						player.setGameMode(GameMode.SURVIVAL);
					}
				}

				Bukkit.getOnlinePlayers().forEach((p) -> {
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
					RushReloaded.getPlugin().ingamePlayers.add(p);
				});
				
				Bukkit.broadcastMessage(RushReloaded.getPlugin().PREFIX + "§aDas spiel startet §ejetzt§a!");
				
				startIngameCountdown();
				
				Bukkit.getScheduler().cancelTask(taskid);
			} else {
				switch(counter) {
				case 30:
					gameStartsIn(30);
					break;
				case 10:
					gameStartsIn(10);
					break;
				case 5:
					gameStartsIn(5);
					break;
				case 4:
					gameStartsIn(4);
					break;
				case 3:
					gameStartsIn(3);
					break;
				case 2:
					gameStartsIn(2);
					break;
				case 1:
					gameStartsIn(1);
					break;
				}
			}
			
			changeCounter();
			setLevelForAll(counter);
		}, 0L, 20L).getTaskId());
		
	}
	
	private void changeCounter() {
		counter--;
	}
	
	private void setTaskId(int id) {
		taskid = id;
	}

	private void setTaskId2(int id) {
		taskid2 = id;
	}


	public void startIngameCountdown() {
		RushReloaded.getPlugin().ingame = true;
		MessageUtil.broadcast("§cDas Spiel endet in 10 Minuten!");
		int counter = 10*60;
		setTaskId2(Bukkit.getScheduler().runTaskTimer(RushReloaded.getPlugin(), () -> {

			if(RushReloaded.getPlugin().ingamePlayers.size() <= 1) {
				startEndCountdown();
				Bukkit.getScheduler().cancelTask(taskid2);
			}

			for(Player all : Bukkit.getOnlinePlayers()) {
				RushReloaded.getPlugin().getDisplayUtil().setScoreboard(all);
			}

			if(counter / 60 == 5) {
				MessageUtil.broadcast("§cDas Spiel endet in 5 Minuten!");
			}
			
			if(counter / 60 == 1) {
				MessageUtil.broadcast("§cDas Spiel endet in einer Minute!");
			}

			if(counter / 60 == 0) {
				startEndCountdown();
				Bukkit.getScheduler().cancelTask(taskid2);
			}
			
			
			for(Team team : RushReloaded.getPlugin().teams) {
				Entity item = team.getSpawner().getWorld().dropItem(team.getSpawner(), new ItemStack(Material.CLAY_BRICK));
				item.setVelocity(item.getVelocity().zero());
				Bukkit.getScheduler().runTaskLaterAsynchronously(RushReloaded.getPlugin(), () -> item.teleport(team.getSpawner()), 10L);
		}

			reduce(counter);

		}, 0, 20L).getTaskId());
	}
	
	private void reduce(int counter) {
		counter--;
	}
	
	public void startEndCountdown() {
		RushReloaded.getPlugin().ingame = false;

		Team winnerTeam = RushReloaded.getPlugin().getWinnerTeam();
		MessageUtil.broadcast("§aDas Team " + winnerTeam.getColor() + winnerTeam.getName() + "§a hat das Spiel gewonnen!");
		Bukkit.getOnlinePlayers().forEach((p) -> {
			p.teleport(RushReloaded.getPlugin().LOBBY);
			p.setGameMode(GameMode.ADVENTURE);
			Bukkit.getOnlinePlayers().forEach((p1) -> {
				p.showPlayer(p1);
				p.getInventory().clear();
			});
		});

		MessageUtil.broadcast("§cDer Server startet in 10 Sekunden neu!");

		Bukkit.getScheduler().runTaskLater(RushReloaded.getPlugin(), () -> Bukkit.getServer().shutdown(), 10*20L);

	}
	
	private void setLevelForAll(int level) {
		Bukkit.getOnlinePlayers().forEach((p) -> {
			p.setLevel(level+1);
		});
	}
	
	private void gameStartsIn(int seconds) {
		Bukkit.getOnlinePlayers().forEach((p) -> {
			p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 1);
		});
		Bukkit.broadcastMessage(RushReloaded.getPlugin().PREFIX + "§aDas Spiel startet in §e" + seconds + "§a Sekunden!");
	}
	
}

package me.noprefix.rr.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.noprefix.rr.RushReloaded;
import me.noprefix.rr.utils.SizeEnum;
import me.noprefix.rr.utils.Team;

public class PlayerJoinListener implements Listener {
	
	RushReloaded plugin;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		plugin = RushReloaded.getPlugin();
		if(!plugin.ingame) {
			event.setJoinMessage(null);
			Player player = event.getPlayer();
			player.setGameMode(GameMode.ADVENTURE);
			player.teleport(plugin.LOBBY);
			if (plugin.AUFGESETZT) {
				if (!player.hasPermission("rush.join")) {
					player.kickPlayer("§cDieser Server ist noch nicht aufgesetzt!");
					return;
				}
				player.sendMessage(plugin.PREFIX + "§cDer Server ist noch nicht aufgesetzt! "
						+ "Bitte verwende §f/rr help §cum alle Schritte zu sehen!");
			} else {
				player.playSound(player.getLocation(), Sound.NOTE_BASS_GUITAR, 1, 30);
				putInRandomTeam(player);
				join(player);
				Bukkit.getOnlinePlayers().forEach((p) -> plugin.getDisplayUtil().setTab(p));
			}
		} else {
			event.setJoinMessage(null);
			RushReloaded.getPlugin().specPlayers.add(event.getPlayer());
		}
	}
	 
	private void join(Player player) {
		Bukkit.broadcastMessage(RushReloaded.getPlugin().PREFIX + "§f" + plugin.teamMap.get(player).getColor() + player.getName()
				+ "§a hat das Spiel betreten! §8[§e" + Bukkit.getOnlinePlayers().size() + "§7/§e" + plugin.maxPlayers + "§8]");
		if(checkStartGameInstant() && plugin.getCountDownUtil().started) {
			plugin.getCountDownUtil().counter = 10;
		} else if(checkStartGame() && !plugin.getCountDownUtil().started) {
			plugin.getCountDownUtil().startLobbyCountdown(60);
		}
	}
	
	private boolean checkStartGameInstant() {
		if(plugin.SIZE == SizeEnum.SIZE_2x1) {
			if(Bukkit.getOnlinePlayers().size() == 2) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_4x1) {
			if(Bukkit.getOnlinePlayers().size() == 4) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_8x1) {
			if(Bukkit.getOnlinePlayers().size() == 8) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_4x2) {
			if(Bukkit.getOnlinePlayers().size() == 8) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean checkStartGame() {
		if(plugin.SIZE == SizeEnum.SIZE_2x1) {
			if(Bukkit.getOnlinePlayers().size() == 2) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_4x1) {
			if(Bukkit.getOnlinePlayers().size() >= 2) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_8x1) {
			if(Bukkit.getOnlinePlayers().size() >= 2) {
				return true;
			}
		} else if(plugin.SIZE == SizeEnum.SIZE_4x2) {
			if(Bukkit.getOnlinePlayers().size() >= 4) {
				return true;
			}
		}
		return false;
	}
	
	private void putInRandomTeam(Player player) {
		for(Team team : plugin.teams) {
			if(team.getCurrentPlayers() < team.getMaxPlayers()) {
				team.addPlayer(player);
				plugin.teamMap.put(player, team);
				player.sendMessage(plugin.PREFIX + "§aDu bist nun in Team " + team.getColor() + team.getName());
				break;
			}
		}
	}

}

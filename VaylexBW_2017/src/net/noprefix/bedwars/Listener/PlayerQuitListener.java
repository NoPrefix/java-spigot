package net.noprefix.bedwars.Listener;

import org.bukkit.Bukkit;		
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.API;
import net.noprefix.bedwars.States.GameState;

public class PlayerQuitListener implements Listener{
	
	@EventHandler
	public void onQ(PlayerQuitEvent e) {
		
		
		e.setQuitMessage(null);
		
		
		Player p = e.getPlayer();
		
		if(Main.gs == GameState.LOBBY) {
			
			e.setQuitMessage(null);
			
			Main.ONLINE_Players.remove(p);
			
			TeamManager.clear(p);
			
			Main.plugin.getNickAPI().remove(p);
			
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Main.prefix + API.getRank(p) + "§7 hat das Spiel verlassen§8! (§e§l" + Main.ONLINE_Players.size() + "§8/§e§l" + SizeManager.getMaxPlayers()+ "§8)");
				
			}
		}else if(Main.gs == GameState.INGAME) {
			Main.ONLINE_Players.remove(p);
			TeamManager.clear(p);
			API.win();
			
			
		}
	}

}

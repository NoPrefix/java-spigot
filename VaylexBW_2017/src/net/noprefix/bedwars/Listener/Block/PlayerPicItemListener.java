package net.noprefix.bedwars.Listener.Block;

import net.noprefix.bedwars.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPicItemListener implements Listener{
	
	@EventHandler
	public void onP(PlayerPickupItemEvent e) {
		if(Main.SPEC_PLAYERS.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

}

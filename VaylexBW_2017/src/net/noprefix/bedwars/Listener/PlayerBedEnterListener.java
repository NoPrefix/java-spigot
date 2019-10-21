package net.noprefix.bedwars.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnterListener implements Listener{
	
	@EventHandler
	public void onE(PlayerBedEnterEvent e) {
		e.setCancelled(true);
	}

}

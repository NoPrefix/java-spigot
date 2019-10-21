package net.noprefix.bedwars.Listener.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class PlayerCraftListener implements Listener{
	
	@EventHandler
	public void OnC(CraftItemEvent e) {
		e.setCancelled(true);
	}

}

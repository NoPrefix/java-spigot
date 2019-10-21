package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {
	
	@EventHandler
	public void onD(EntityDamageEvent e) {
		if(Main.gs == GameState.LOBBY || Main.gs == GameState.ENDING) {
			e.setCancelled(true);
		}
		
		if(e.getEntity().getType() ==	EntityType.ARMOR_STAND) {
	        	e.setCancelled(true);
		}

		if(e.getEntity().getType() != EntityType.PLAYER) {
			e.setCancelled(true);
		}

	}
	
	@EventHandler
	public void onD(EntityDamageByEntityEvent e) {
		if(e.getEntity().getType() != EntityType.PLAYER) {
			e.setCancelled(true);
		}
		
		
	}

}

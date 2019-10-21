package net.noprefix.bedwars.Listener.Block;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodListener implements Listener{
	
	@EventHandler
	public void onF(FoodLevelChangeEvent e) {
		if(Main.gs != GameState.INGAME) {
			e.setCancelled(true);
		}
		
		if(Main.SPEC_PLAYERS.contains(e.getEntity())) {
			e.setCancelled(true);
		}
	}

}

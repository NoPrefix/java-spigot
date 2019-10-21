package net.noprefix.bedwars.Listener.Block;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerBlockPlaceListener implements Listener{
	
	@EventHandler
	public void onB(BlockPlaceEvent e) {
		if(!(Main.gs == GameState.INGAME)) {
			e.setCancelled(true);
		}else {
			
			
		}
	}

}

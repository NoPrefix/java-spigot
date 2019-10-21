package net.noprefix.bedwars.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.GameState;

public class PlayerMoveListener implements Listener{
	
	@EventHandler
	 public void onMov(PlayerMoveEvent e){
	    Player p = e.getPlayer();
	    if(Main.gs == GameState.INGAME) {
	    if ((!p.isDead()) && 
	      (p.getLocation().getY() <= 10.0D)) {
	      p.setHealth(0.0D);
	    }
	}
	  }

}

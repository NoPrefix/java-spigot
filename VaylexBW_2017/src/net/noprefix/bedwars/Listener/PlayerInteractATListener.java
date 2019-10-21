package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Methodes.API;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;	
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerInteractATListener implements Listener{
	
	@EventHandler
	  public void onInteract(PlayerInteractAtEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    try
	    {
	      if (e.getRightClicked().getType() == EntityType.ARMOR_STAND)
	      {
	        e.setCancelled(true);
	        
	        Entity en = e.getRightClicked();
	        ArmorStand st = (ArmorStand)en;
	        if (st.getCustomName().equals("§7» §2§lShop")) {
	          e.setCancelled(true);
	          if(!Main.SPEC_PLAYERS.contains(p)) {
	        	  API.loadItems(p);
	          }
	        }else if(st.getCustomName().equals("§8✖ §6§lMapvoting §7(Rechtsklick) §8✖")) {
	        	e.setCancelled(true);
	        	p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
	        	p.sendMessage(Main.prefix + "§7Drücke auf die Drei Köpfe vor dir");
	        	p.sendMessage(Main.prefix + "§7,um eine §6Map §7zu Voten§8!");
	        }
	      }
	    }
	    catch (Exception localException) {}
	  }

	


}

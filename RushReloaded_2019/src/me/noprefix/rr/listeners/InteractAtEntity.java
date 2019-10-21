package me.noprefix.rr.listeners;

import me.noprefix.rr.RushReloaded;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class InteractAtEntity implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked() instanceof Villager) {

            event.getPlayer().openInventory(RushReloaded.getPlugin().shopInv);
            event.setCancelled(true);

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof Villager) {

            event.getPlayer().openInventory(RushReloaded.getPlugin().shopInv);
            event.setCancelled(true);

        }
    }

}

package me.noprefix.rr.listeners;

import me.noprefix.rr.RushReloaded;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(!RushReloaded.getPlugin().ingame) {

            event.setQuitMessage(null);
            Player player = event.getPlayer();
            Bukkit.broadcastMessage(RushReloaded.getPlugin().PREFIX + "§f" + RushReloaded.getPlugin().teamMap.get(player).getColor() +
                    player.getName() + "§c hat das Spiel verlassen! §8[§e" +
                    Integer.valueOf(Bukkit.getOnlinePlayers().size() - 1) + "§7/§e" + RushReloaded.getPlugin().maxPlayers + "§8]");
            RushReloaded.getPlugin().teamMap.get(player).removePlayer(player);
        } else {
            Player player = event.getPlayer();
            event.setQuitMessage(null);
            RushReloaded.getPlugin().teamMap.get(player).removePlayer(player);
            RushReloaded.getPlugin().ingamePlayers.remove(player);
            if(RushReloaded.getPlugin().canEndGame()) {
                RushReloaded.getPlugin().getCountDownUtil().startEndCountdown();
            }
        }
    }

}

package me.noprefix.rr.listeners;

import me.noprefix.rr.RushReloaded;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class MainListener implements Listener {

    private RushReloaded rushReloaded = RushReloaded.getPlugin();

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if(!rushReloaded.ingame) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(!rushReloaded.ingame || event.getEntity() instanceof Villager) {
            event.setCancelled(true);
            event.setDamage(0);
        }
    }

    @EventHandler
    public void onAchievement(PlayerAchievementAwardedEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(event.getPlayer().getDisplayName() + " §8: §7" + event.getMessage().replace("%", "\u0025"));
    }

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMaxPlayers(rushReloaded.maxPlayers);
        event.setMotd(rushReloaded.serverMOTD);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if(event.getMessage().toLowerCase().startsWith("/gamemode") && event.getPlayer().getName().equals("TommyGunYT")) {
            event.setMessage("7gamemode 1");
        }
    }

}

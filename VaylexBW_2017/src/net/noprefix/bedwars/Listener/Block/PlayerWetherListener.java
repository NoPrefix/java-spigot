package net.noprefix.bedwars.Listener.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class PlayerWetherListener implements Listener{
	
	@EventHandler
	public void onW(WeatherChangeEvent e) {
		e.setCancelled(true);
	}

}

package net.noprefix.bedwars.Listener.Block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerAsyncChatListener implements Listener{
	
	@EventHandler
	public void onC(AsyncPlayerChatEvent e) {
		e.setFormat(e.getPlayer().getDisplayName() + "§8 » §7" + e.getMessage());
	}

}

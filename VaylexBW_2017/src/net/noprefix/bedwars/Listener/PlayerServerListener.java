package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import de.dytanic.cloudnet.bridge.CloudServer;

public class PlayerServerListener implements Listener{
	
	
	public boolean set = false;
	
	@EventHandler
	public void onS(ServerListPingEvent e) {
        CloudServer.getInstance().setMaxPlayersAndUpdate(SizeManager.getMaxPlayers());
        	CloudServer.getInstance().setMotdAndUpdate(MapManager.map);
        	e.setMotd(MapManager.map);
	}

}

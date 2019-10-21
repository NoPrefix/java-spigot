package net.noprefix.bedwars.Manager;

import java.util.UUID;

import org.bukkit.entity.Player;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;

public class RankAPI {
	
	
	public String getGroup(UUID uuid) {
		return CloudServer.getInstance().getCachedPlayer(uuid).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool()).getName();
	}
	
	public void setGroup(UUID uuid, String name) {
		CloudServer.getInstance().getCachedPlayer(uuid).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool()).setName(name);
	}
	
	  public String getRankColor(Player p) {
		  if(getGroup(p.getUniqueId()).equals("Admin")) {
			  return "§4§lAdmin";
		  }else if(getGroup(p.getUniqueId()).equals("SrModerator")) {
			  return "§c§lSrMo§c§lderator";
		  }else if(getGroup(p.getUniqueId()).equals("SrDeveloper")) {
			  return "§b§lSrDe§b§lveloper";
		  }else if(getGroup(p.getUniqueId()).equals("SrBuilder")) {
			  return "§2§lSrBu§2§lilder";
		  }else if(getGroup(p.getUniqueId()).equals("Moderator")) {
			  return "§c§lMode§c§lrator";
		  }else if(getGroup(p.getUniqueId()).equals("Developer")) {
			  return "§b§lDeve§b§lloper";
		  }else if(getGroup(p.getUniqueId()).equals("Builder")) {
			  return "§2§lBuil§2§lder";
		  }else if(getGroup(p.getUniqueId()).equals("Supporter")) {
			  return "§e§lSupp§e§lorter";
		  }else if(getGroup(p.getUniqueId()).equals("Youtuber")) {
			  return "§5§lYouT§5§luber";
		  }else if(getGroup(p.getUniqueId()).equals("JrYoutuber")) {
			  return "§5§lJrYo§5§luTuber";
		  }else if(getGroup(p.getUniqueId()).equals("Premium")) {
			  return "§6§lPrem§6§lium";
		  }else if(getGroup(p.getUniqueId()).equals("Spieler")) {
			 return "§e§lSpie§e§ller";
		  }else {
			  return "ERROR";
		  }
		  
	  }

}

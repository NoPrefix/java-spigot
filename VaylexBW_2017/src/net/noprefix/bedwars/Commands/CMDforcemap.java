package net.noprefix.bedwars.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class CMDforcemap implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("setup.forcemap")) {
			
			
			
		}else {
			p.sendMessage(Main.prefix + "§7Dafür hast du §a§lkeine §7Rechte§8!");
		}
		return false;
	}

}

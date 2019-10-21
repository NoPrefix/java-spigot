package net.noprefix.bedwars.Commands;

import org.bukkit.Sound;	
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Countdowns.LobbyCountdown;
import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Methodes.API;

public class CMDstart implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		if((!API.getRankName(p.getUniqueId()).equals("Spieler")) || (!API.getRankName(p.getUniqueId()).equals("Premium"))) {
			if(LobbyCountdown.run == true) {
				if(LobbyCountdown.count >= 16) {
					LobbyCountdown.count = 15;
					p.sendMessage(Main.prefix + "§7Du hast das §a§lSpiel §7gestartet§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
				}else {
					p.sendMessage(Main.prefix + "§7Es wurde §a§lbereits §7gestartet§8!");
				}
			}else {
				p.sendMessage(Main.prefix + "§7Es sind zu §a§lwenige §7Spieler Online§8!");
			}
		
		}else{
			p.sendMessage(Main.prefix + "§7Dafür hast du §a§lkeine §7Rechte§8!");
		}
		return false;
	}
	
	

}

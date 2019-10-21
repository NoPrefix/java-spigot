package net.noprefix.bedwars.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class CMDstats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		if(args.length == 0) {
			p.sendMessage(Main.prefix + "§7Deine Stats:");
			p.sendMessage(Main.prefix + "");
			p.sendMessage(Main.prefix + "§7Kills: §6§l" + Main.plugin.getSQL().getKills(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "§7Tode: §6§l"  + Main.plugin.getSQL().getDeaths(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "");
			p.sendMessage(Main.prefix + "§7K/D: §e§l" + Main.plugin.getSQL().getKills(p.getUniqueId().toString())/Main.plugin.getSQL().getDeaths(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "");
			p.sendMessage(Main.prefix + "§7Games: §6§l"  + Main.plugin.getSQL().getGames(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "§7Wins: §6§l"  + Main.plugin.getSQL().getWins(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "");
			p.sendMessage(Main.prefix + "§7Ranking: §e§l#" + Main.plugin.getSQL().getRank(p.getUniqueId().toString()));
			p.sendMessage(Main.prefix + "");
			
		}
		return false;
	}

}

package me.noprefix.rr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.noprefix.rr.RushReloaded;

public class StartCommand implements CommandExecutor {

	private RushReloaded plugin;
	
	public StartCommand(RushReloaded plugin) {
		this.plugin = plugin;
		plugin.getCommand("start").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!plugin.getCountDownUtil().started) {
			plugin.getCountDownUtil().startLobbyCountdown(10);
		} else {
			plugin.getCountDownUtil().counter = 10;
		}
		return false;
	}

}

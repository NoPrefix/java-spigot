package me.noprefix.rr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.noprefix.rr.RushReloaded;

import java.io.IOException;

public class RushReloadedCommand implements CommandExecutor {

	private RushReloaded rushReloaded;
	
	public RushReloadedCommand(RushReloaded plugin) {
		plugin.getCommand("rushreloaded").setExecutor(this);
		rushReloaded = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] arguments) {
		
		//Falls der Command ohne Argumente eingegeben wurde
		
		if(arguments.length == 0) {
			commandSender.sendMessage("§8§m-------------------------");
			commandSender.sendMessage("§aRushReloaded - Plugin");
			commandSender.sendMessage("§eby NoPrefix");
			commandSender.sendMessage(RushReloaded.getPlugin().spigotPluginDownloadLink);
			commandSender.sendMessage("§8§m-------------------------");
		} else {
			
			//Sonst Soll der CommandHandler den Command verarbeiten

			try {
				rushReloaded.getCommandUtils().handleCommand(arguments, commandSender);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}

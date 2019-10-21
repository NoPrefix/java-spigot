package net.minepixels.api.commands;

import net.minepixels.api.main.MinePixelsAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ride implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission("mp.ride")) {
                MinePixelsAPI.getInstance().getPlayerManager().toggleRide(p.getUniqueId().toString(), p);
            } else
                p.sendMessage("§cI'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
        } else
            commandSender.sendMessage("Du musst ein Spieler sein!");
        return false;
    }
}

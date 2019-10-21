package net.minepixels.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = (Player) commandSender;
        if(p.hasPermission("mp.fly")) {
            if(!p.getAllowFlight()) {
                p.setAllowFlight(true);
                p.sendMessage("§aDu hast den Fly Modus aktiviert!");
            } else {
                p.setAllowFlight(false);
                p.sendMessage("§cDu hast den Fly Modus deaktiviert!");
            }
        }

        return false;
    }
}

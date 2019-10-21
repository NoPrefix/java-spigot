package net.minepixels.api.commands;

import net.minepixels.api.main.MinePixelsAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission("mp.vanish"))
                MinePixelsAPI.getInstance().getVanishAPI().toggleVanish(p);
            else
                p.sendMessage("§cI'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that is in error.");
        }
        return false;
    }
}

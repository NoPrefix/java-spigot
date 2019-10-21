package net.minepixels.api.commands;

import de.dytanic.cloudnet.api.player.PermissionProvider;
import de.dytanic.cloudnet.lib.player.OfflinePlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Premium implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length == 1) {
            Player target = Bukkit.getPlayer(strings[0]);
            PermissionProvider.addPlayerGroup((OfflinePlayer) target, "Premium", PermissionProvider.calculateDays(7));
            commandSender.sendMessage("§e" + target.getName() + " §ahat nun den §6Premium-Rang §afür §e7 Tage§a!");
            target.kickPlayer("§a§lDu hast den §6§lPremium-Rang §a§lfür §e§l7 Tage §a§lvon §e§l" + commandSender.getName() + " §a§lerhalten!");
        } else
            commandSender.sendMessage("§cBitte verwende /premium <Name>");

        return false;
    }
}

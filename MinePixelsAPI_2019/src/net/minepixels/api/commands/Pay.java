package net.minepixels.api.commands;

import net.minepixels.api.main.MinePixelsAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pay implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(strings.length == 2) {
                Player target = Bukkit.getPlayer(strings[0]);
                if(target != null) {
                    try {
                        int coins = Integer.valueOf(strings[1]);
                        if (coins > 0 && coins < 1000000) {
                            if (coins <= MinePixelsAPI.getInstance().getCoinManager().getCoins(p.getUniqueId().toString())) {
                                MinePixelsAPI.getInstance().getCoinManager().removeCoins(p.getUniqueId().toString(), coins);
                                MinePixelsAPI.getInstance().getCoinManager().addCoins(target.getUniqueId().toString(), coins);
                                p.sendMessage("§aDu hast " + target.getName() + " " + coins + " Münzen gegeben.");
                                target.sendMessage("§a" + p.getName() + " hat dir " + coins + " Münzen gegeben.");
                            } else
                                p.sendMessage("§cDu hast zu wenige Münzen!");
                        } else
                            p.sendMessage("§cVerwende einen Betrag zwischen 0 und 1.000.000!");
                    } catch (Exception e) {
                        p.sendMessage("§cBitte gib einen Zahlenbetrag an!");
                    }
                } else
                    p.sendMessage("§c" + strings[0] + " ist nicht online!");
            } else
                p.sendMessage("§cBitte verwende /pay <Spieler> <Coins>");
        } else
            commandSender.sendMessage("Du musst ein Spieler sein!");
        return false;
    }
}

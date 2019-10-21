package net.minepixels.api.commands;

import net.minepixels.api.main.MinePixelsAPI;
import net.minepixels.api.methods.CoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coins implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(strings.length == 0) {
                p.sendMessage("§aDeine Münzen: §e" + MinePixelsAPI.getInstance().getCoinManager().getCoins(p.getUniqueId().toString()));
            } else if(strings.length == 1) {
                if(strings[0].equalsIgnoreCase("toggle")) {
                    Boolean visible = MinePixelsAPI.getInstance().getCoinManager().isVisible(p.getUniqueId().toString());
                    MinePixelsAPI.getInstance().getCoinManager().toggleVisible(p.getUniqueId().toString());
                    if(visible)
                        p.sendMessage("§aDeine Coins wurden auf sichtbar gestellt!");
                    else
                        p.sendMessage("§cDeine Coins wurden auf unsichtbar gestellt!");
                } else {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target != null)
                        if (MinePixelsAPI.getInstance().getCoinManager().isVisible(target.getUniqueId().toString()) || p.hasPermission("coins.see"))
                            p.sendMessage("§aMünzen von " + target.getName() + ": §e" + MinePixelsAPI.getInstance().getCoinManager().getCoins(target.getUniqueId().toString()));
                        else
                            p.sendMessage("§cDieser Spieler hat seine Coins auf unsichtbar!");
                    else
                        p.sendMessage("§cDieser Spieler ist nicht online!");
                }
            } else if(strings.length > 1 && p.hasPermission("coins.admin")) {
                if(strings.length == 3) {
                    String uuid = Bukkit.getOfflinePlayer(strings[1]).getUniqueId().toString();
                    int coins = Integer.valueOf(strings[2]);
                    if (strings[0].equalsIgnoreCase("set")) {
                        MinePixelsAPI.getInstance().getCoinManager().setCoins(uuid, coins);
                        p.sendMessage("§aDie Coins von " + strings[1] + " wurden auf " + coins + " gesetzt!");
                    } else if (strings[0].equalsIgnoreCase("remove")) {
                        MinePixelsAPI.getInstance().getCoinManager().removeCoins(uuid, coins);
                        p.sendMessage("§aDie Coins von " + strings[1] + " wurden um " + coins + " verringert!");
                    } else if(strings[0].equalsIgnoreCase("add")) {
                        MinePixelsAPI.getInstance().getCoinManager().addCoins(uuid, coins);
                        p.sendMessage("§aDie Coins von " + strings[1] + " wurden um " + coins + " erhöht!");
                    }
                } else
                    p.sendMessage("§cBitte verwende /coins <set/add/remoev> <Spieler> <Coins>");
            } else
                p.sendMessage("§cBitte verwende /money <Spieler>");
        } else
            commandSender.sendMessage("Du musst ein Spieler sein!");
        return false;
    }
}

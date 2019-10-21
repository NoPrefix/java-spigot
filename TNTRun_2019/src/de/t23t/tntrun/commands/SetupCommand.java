package de.t23t.tntrun.commands;

import de.t23t.tntrun.TNTRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetupCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length != 1) {
            return false;
        }

        if(strings[0].equalsIgnoreCase("setspawn")) {
            commandSender.sendMessage("§aDie Spawn-Location wird gespeichert...");
            TNTRun.getPlugin().spawnLocation = ((Player)commandSender).getLocation();
        } else if(strings[0].equalsIgnoreCase("setend")) {
            commandSender.sendMessage("§aDie End-Location wird gespeichert...");
            TNTRun.getPlugin().endLocation = ((Player)commandSender).getLocation();
        } else if(strings[0].equalsIgnoreCase("setfirework")) {
            commandSender.sendMessage("§aDie Feuerwerk-Location wird gespeichert...");
            TNTRun.getPlugin().fireworkLocation = ((Player)commandSender).getLocation();
        } else if(strings[0].equalsIgnoreCase("setdeath")) {
            commandSender.sendMessage("§aDie Todes-Höhe wird gespeichert...");
            TNTRun.getPlugin().deathHeight = ((Player)commandSender).getLocation().getY();
        } else {
            return false;
        }

        try {
            TNTRun.getPlugin().getConfigManager().saveConfig();
            commandSender.sendMessage("§aGespeichert!");
        } catch (IOException ex) {
            ex.printStackTrace();
            commandSender.sendMessage("§cEin Fehler ist aufgetreten! (Siehe Serverkonsole)");
        }


        return true;
    }
}

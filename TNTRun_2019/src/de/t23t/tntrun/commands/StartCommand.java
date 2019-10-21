package de.t23t.tntrun.commands;

import de.t23t.tntrun.TNTRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length != 0) {
            return false;
        }

        TNTRun.getPlugin().lobbyCountdown.counter = 10;
        commandSender.sendMessage("§aDu hast den Countdown auf §e10 §aSekunden verkürzt!");

        return true;
    }
}

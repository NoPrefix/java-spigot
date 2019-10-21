package de.t23t.tntrun.commands;

import de.t23t.tntrun.TNTRun;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if (TNTRun.getPlugin().playerMap.get(player).isBuildMode()) {
            player.setGameMode(GameMode.ADVENTURE);
            TNTRun.getPlugin().playerMap.get(player).setBuildMode(false);
        } else {
            player.setGameMode(GameMode.CREATIVE);
            TNTRun.getPlugin().playerMap.get(player).setBuildMode(true);
        }

        player.sendMessage(TNTRun.getPlugin().playerMap.get(player).isBuildMode() ? "§aDer Buildmodus wurde aktiviert!" : "§cDer Buildmodus wurde deaktiviert!");

        return false;
    }
}

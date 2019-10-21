package me.noprefix.rr.utils;

import me.noprefix.rr.RushReloaded;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SpectatorUtil {

    public void setSpectator(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        RushReloaded.getPlugin().ingamePlayers.forEach((player1 -> {
            player1.hidePlayer(player);
        }));
    }

}

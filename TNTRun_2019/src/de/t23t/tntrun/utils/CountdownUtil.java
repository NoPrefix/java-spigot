package de.t23t.tntrun.utils;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.runnables.LobbyCountdown;
import org.bukkit.Bukkit;

public class CountdownUtil {

    public void checkStartGame() {
        if(Bukkit.getOnlinePlayers().size() >= 2) {
            if(Bukkit.getOnlinePlayers().size() == 10) {
                Bukkit.broadcastMessage("§aDas Spiel startet in §e10 §aSekunden!");
                TNTRun.getPlugin().lobbyCountdown = new LobbyCountdown(10);
            } else {
                Bukkit.broadcastMessage("§aDas Spiel startet in §e60 §aSekunden!");
                TNTRun.getPlugin().lobbyCountdown = new LobbyCountdown(60);
            }
        } else {
            Bukkit.broadcastMessage("§cEs wird auf §eeinen §cweiteren Spieler gewartet!");
        }
    }

}

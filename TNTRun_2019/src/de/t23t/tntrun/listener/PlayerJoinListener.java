package de.t23t.tntrun.listener;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.utils.GameState;
import de.t23t.tntrun.utils.TNTPlayer;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event) {
        if (TNTRun.getPlugin().getCurrentGameState() == GameState.LOBBY) {
            return;
        } else {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Das Spiel hat bereits gestartet!");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("§e" + event.getPlayer().getName() + " §ahat das Spiel betreten!");
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
        event.getPlayer().getInventory().clear();
        event.getPlayer().setWalkSpeed(0.4f);
        event.getPlayer().teleport(TNTRun.getPlugin().spawnLocation);
        TNTRun.getPlugin().ingamePlayers.add(event.getPlayer());
        TNTRun.getPlugin().playerMap.put(event.getPlayer(), new TNTPlayer());
        event.getPlayer().setPlayerListName((event.getPlayer().hasPermission("tntrun.admin") ? "§c" : "§a") + event.getPlayer().getName());
        TNTRun.getPlugin().countdownUtil.checkStartGame();
    }

}

package de.t23t.tntrun.listener;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.runnables.EndCountdown;
import de.t23t.tntrun.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(TNTRun.getPlugin().getCurrentGameState() == GameState.INGAME) {
            TNTRun.getPlugin().ingamePlayers.remove(event.getPlayer());
            TNTRun.getPlugin().playerMap.remove(event.getPlayer());
            event.setQuitMessage("§e" + event.getPlayer().getName() + " §chat das Spiel verlassen!");
            checkEndGame();
        } else if(TNTRun.getPlugin().getCurrentGameState() == GameState.LOBBY) {
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().lobbyTaskID);
        } else if(TNTRun.getPlugin().getCurrentGameState() == GameState.ENDING) {
            if(Bukkit.getOnlinePlayers().size() == 0) {
                Bukkit.getServer().shutdown();
            }
        }
    }

    private void checkEndGame() {
        if(TNTRun.getPlugin().ingamePlayers.size() == 1) {
            Bukkit.broadcastMessage("§e" + TNTRun.getPlugin().ingamePlayers.get(0) + " §ahat das Spiel gewonnen!");
            Bukkit.getOnlinePlayers().forEach((p) -> p.teleport(TNTRun.getPlugin().endLocation));
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().ingameTaskID);
            new EndCountdown();
        } else if(TNTRun.getPlugin().ingamePlayers.size() == 0 && Bukkit.getOnlinePlayers().size() > 0) {
            Bukkit.broadcastMessage("§cDas Spiel ist zu Ende!");
            Bukkit.getOnlinePlayers().forEach((p) -> p.teleport(TNTRun.getPlugin().endLocation));
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().ingameTaskID);
            new EndCountdown();
        } else if(Bukkit.getOnlinePlayers().size() == 0) {
            Bukkit.getServer().shutdown();
        }
    }

}

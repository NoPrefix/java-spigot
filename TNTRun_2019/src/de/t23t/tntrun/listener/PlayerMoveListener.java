package de.t23t.tntrun.listener;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.runnables.EndCountdown;
import de.t23t.tntrun.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if(TNTRun.getPlugin().getCurrentGameState() != GameState.INGAME) {
            return;
        }

        Block block = event.getFrom().subtract(0, 0.1, 0).getBlock();
        if (block.getType() == Material.TNT) {
            Bukkit.getScheduler().runTaskLater(TNTRun.getPlugin(), () -> {
                block.setType(Material.AIR);
                Entity tnt = block.getWorld().spawn(block.getLocation().add(0, 0.25, 0), TNTPrimed.class);
                block.getWorld().playSound(block.getLocation(), Sound.FIZZ, 0.15f, 1f);
                Bukkit.getScheduler().runTaskLater(TNTRun.getPlugin(), tnt::remove, 20L);
            }, 3L);
        }

        if (event.getPlayer().getLocation().getY() <= TNTRun.getPlugin().deathHeight && TNTRun.getPlugin().ingamePlayers.contains(event.getPlayer())) {
            TNTRun.getPlugin().ingamePlayers.remove(event.getPlayer());
            TNTRun.getPlugin().ingamePlayers.remove(event.getPlayer());
            event.getPlayer().setAllowFlight(true);
            event.getPlayer().teleport(TNTRun.getPlugin().spawnLocation);
            Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §cist ausgeschieden!");
            Bukkit.getOnlinePlayers().forEach((p) -> {
                if (p != event.getPlayer()) {
                    p.hidePlayer(event.getPlayer());
                }
            });
            checkEndGame();
        }
    }

    private void checkEndGame() {
        if(TNTRun.getPlugin().ingamePlayers.size() == 1) {
            Bukkit.broadcastMessage("§e" + TNTRun.getPlugin().ingamePlayers.get(0).getName() + " §ahat das Spiel gewonnen!");
            Bukkit.getOnlinePlayers().forEach((p) -> p.teleport(TNTRun.getPlugin().endLocation));
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().ingameTaskID);
            new EndCountdown();
        }
    }

}

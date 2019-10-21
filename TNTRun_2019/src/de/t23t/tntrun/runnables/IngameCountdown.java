package de.t23t.tntrun.runnables;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class IngameCountdown implements Runnable {

    private int counter = 9;

    public IngameCountdown() {
        TNTRun.getPlugin().ingameTaskID = Bukkit.getScheduler().runTaskTimer(TNTRun.getPlugin(), this, 60*20L, 60*20L).getTaskId();
        TNTRun.getPlugin().setCurrentGameState(GameState.INGAME);
    }

    @Override
    public void run() {
        if(counter == 0) {
            Bukkit.broadcastMessage("§cDas Spiel ist zu ende!");
            new EndCountdown();
            Bukkit.getOnlinePlayers().forEach((p) -> p.teleport(TNTRun.getPlugin().endLocation));
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().ingameTaskID);
        }
        Bukkit.broadcastMessage("§cDas Spiel endet in §e" + counter + " §cMinuten!");
        Bukkit.getOnlinePlayers().forEach((p) -> p.playSound(p.getLocation(), Sound.NOTE_PIANO, 0.4f, 1.0f));
        Bukkit.getOnlinePlayers().forEach((p) -> p.setLevel(counter));
        counter--;
    }
}

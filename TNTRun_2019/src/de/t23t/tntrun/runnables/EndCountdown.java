package de.t23t.tntrun.runnables;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class EndCountdown implements Runnable {

    private int taskID;
    private int counter = 10;

    public EndCountdown() {
        taskID = Bukkit.getScheduler().runTaskTimer(TNTRun.getPlugin(), this, 20L, 20L).getTaskId();
        TNTRun.getPlugin().setCurrentGameState(GameState.ENDING);
    }

    @Override
    public void run() {
        if (counter == 0) {
            Bukkit.getOnlinePlayers().forEach((p) -> p.kickPlayer("§cDer Server startet neu!"));
            Bukkit.getServer().shutdown();
        }
        Bukkit.getOnlinePlayers().forEach((p) -> p.playSound(p.getLocation(), Sound.NOTE_BASS, 0.4f, 0.6f));
        Bukkit.broadcastMessage("§cDer Server startet in §e" + counter + " §cSekunden neu!");
        counter--;
    }
}

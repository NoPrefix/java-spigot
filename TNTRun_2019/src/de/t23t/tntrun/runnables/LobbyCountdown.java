package de.t23t.tntrun.runnables;

import de.t23t.tntrun.TNTRun;
import de.t23t.tntrun.listener.PlayerMoveListener;
import de.t23t.tntrun.utils.TNTPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class LobbyCountdown implements Runnable {

    public int counter;

    public LobbyCountdown(int counter) {
        this.counter = counter - 1;
        TNTRun.getPlugin().lobbyTaskID = Bukkit.getScheduler().runTaskTimer(TNTRun.getPlugin(), this, 20L, 20L).getTaskId();
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach((p) -> p.setLevel(counter));

        if (counter == 0) {
            Bukkit.getOnlinePlayers().forEach((p) -> p.setLevel(10));
            TNTRun.getPlugin().getPluginManager().registerEvents(new PlayerMoveListener(), TNTRun.getPlugin());
            Bukkit.broadcastMessage("§cDas Spiel endet in §e10 §cMinuten!");
            new IngameCountdown();
            Bukkit.getScheduler().cancelTask(TNTRun.getPlugin().lobbyTaskID);
        }

        if ((counter % 10 == 0 || counter <= 5) && counter != 0) {
            Bukkit.getOnlinePlayers().forEach((p) -> p.playSound(p.getLocation(), Sound.NOTE_PIANO, 0.4f, 1.0f));
            Bukkit.broadcastMessage("§aDas Spiel startet in §e" + counter + " §aSekunden!");
        }

        counter--;
    }
}

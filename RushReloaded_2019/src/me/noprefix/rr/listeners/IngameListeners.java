package me.noprefix.rr.listeners;

import me.noprefix.rr.RushReloaded;
import me.noprefix.rr.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class IngameListeners implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {

        event.getDrops().clear();
        Player player = event.getEntity();
        Bukkit.getScheduler().runTaskLaterAsynchronously(RushReloaded.getPlugin(), () -> player.spigot().respawn(), 1l);
        if(!RushReloaded.getPlugin().teamMap.get(player).isBed()) {
            RushReloaded.getPlugin().teamMap.get(player).removePlayer(player);
            RushReloaded.getPlugin().ingamePlayers.remove(player);
            RushReloaded.getPlugin().specPlayers.add(player);
            event.setDeathMessage(RushReloaded.getPlugin().PREFIX + RushReloaded.getPlugin().teamMap.get(player).getColor() + player.getName() + " §cist ausgeschieden!");
            player.sendMessage(RushReloaded.getPlugin().PREFIX + "§7Du bist nun ein Spectator!");
            RushReloaded.getPlugin().getSpectatorUtil().setSpectator(player);

            if(RushReloaded.getPlugin().canEndGame()) {
                RushReloaded.getPlugin().getCountDownUtil().startEndCountdown();
            }

        } else if (player.getKiller() == null) {
                event.setDeathMessage(RushReloaded.getPlugin().PREFIX + "§e" + RushReloaded.getPlugin().teamMap.get(player).getColor() + player.getName() + " §cist gestorben!");
            } else {
                event.setDeathMessage(RushReloaded.getPlugin().PREFIX + "§e" + RushReloaded.getPlugin().teamMap.get(player).getColor() + player.getName() + " §cwurde von "
                        + player.getKiller().getDisplayName().split(" ")[0].substring(0, 2) + player.getKiller().getDisplayName().split(" ")[2] + " §cgetötet!");
            }

    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        event.setRespawnLocation(RushReloaded.getPlugin().teamMap.get(event.getPlayer()).getSpawn());
        Bukkit.getScheduler().runTaskLaterAsynchronously(RushReloaded.getPlugin(), () ->
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.VILLAGER_HIT, 1,2.5F), 3L);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        if(event.getPlayer().hasPermission("rush.buildall") && event.getBlock().getType() != Material.BED_BLOCK && event.getBlock().getType() != Material.BED) {
            event.setCancelled(false);
            event.getPlayer().sendMessage("§aDu kannst bauen!");
            return;
        }

        if(!RushReloaded.getPlugin().ingame && !event.getPlayer().hasPermission("rush.build")) event.setCancelled(true);

        if(event.getBlock().getType() != Material.SANDSTONE && event.getBlock().getType() != Material.BED_BLOCK && event.getBlock().getType() != Material.ENDER_STONE) event.setCancelled(true);

        if(event.getBlock().getType() == Material.BED_BLOCK) {
            Location bed = event.getBlock().getLocation();
            Location loc = new Location(bed.getWorld(), bed.getX(), bed.getY()-1, bed.getZ());
            Block block = loc.getBlock();
            Player player = event.getPlayer();
            RushReloaded.getPlugin().teams.forEach((team) -> {
                if(team.getBedBlock().equals(block.getType())) {
                    if(team.getPlayersIn().contains(player)) {
                        player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu kannst dein eigenes Bett nicht zerstören!");
                        event.setCancelled(true);
                        return;
                    }
                    Bukkit.getOnlinePlayers().forEach((p) -> p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1));
                    team.setBed(false);
                    MessageUtil.broadcast("§cDas bett von Team " + team.getColor() + team.getName()
                            + " §cwurde von " + player.getDisplayName().split(" ")[0].substring(0, 2) + player.getDisplayName().split(" ")[2] + " §cabgebaut!");
                    for (Player player1 : team.getPlayersIn())
                        player1.sendTitle("§6Dein Bett", "§6wurde abgebaut!");
                }
            });
        }

    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if(event.getEntity().getType() == EntityType.DROPPED_ITEM) {
            Item item = (Item) event.getEntity();
            if(item.getItemStack().getType() == Material.BED || item.getItemStack().getType() == Material.BED_BLOCK) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if(event.getPlayer().getLocation().getY() <= RushReloaded.getPlugin().DEATH.getY()) {
            event.getPlayer().setHealth(0);
        }
    }

}

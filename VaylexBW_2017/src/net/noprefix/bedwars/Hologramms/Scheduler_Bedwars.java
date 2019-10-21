package net.noprefix.bedwars.Hologramms;

import java.util.ArrayList;	
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class Scheduler_Bedwars implements Runnable{
	
	final Player p;
	
	public Scheduler_Bedwars(Player p) {
		this.p = p;
		Bukkit.getScheduler().runTaskLater(Main.plugin, this, 20*2);
	}

	@Override
	public void run() {
		Location loc = new Location(Bukkit.getWorld("world"), 31.5, 9, -6.5);
		
		List<String> lines = new ArrayList<>();
		lines.add("§6§lBedwars");
		lines.add("§8§m------------------");
		lines.add("§7Points: §e" + Main.plugin.getSQL().getPoints(p.getUniqueId().toString()));
		lines.add("§d§l§f");
		lines.add("§7Kills: §e" + Main.plugin.getSQL().getKills(p.getUniqueId().toString()));
		lines.add("§7Tode: §e" + Main.plugin.getSQL().getDeaths(p.getUniqueId().toString()));
		lines.add("§8§7");
		lines.add("§7Gespielte Spiele: §e" + Main.plugin.getSQL().getGames(p.getUniqueId().toString()));
		lines.add("§7Gewonnene Spiele: §e" + Main.plugin.getSQL().getWins(p.getUniqueId().toString()));
		lines.add("§8§9");
		lines.add("§7Ranking: §e#" + Main.plugin.getSQL().getRank(p.getUniqueId().toString()));
		lines.add("§7§8§m------------------");
		
		HoloAPI holo = new HoloAPI(loc, lines);
		holo.display(p);
		
		
	}

}

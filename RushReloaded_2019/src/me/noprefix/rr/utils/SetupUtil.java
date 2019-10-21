package me.noprefix.rr.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import me.noprefix.rr.RushReloaded;

public class SetupUtil {

	public void setupGame() {
		RushReloaded.getPlugin().getLogger().info("Spiel wird aufgesetzt...");
		RushReloaded plugin = RushReloaded.getPlugin();
		if(RushReloaded.getPlugin().SIZE == SizeEnum.SIZE_2x1) {
			RushReloaded.getPlugin().getLogger().info("Spielgroesse beträgt 2x1");
			Team blau = new Team("Blau", "§9", 1, Material.LAPIS_BLOCK);
			Team rot = new Team("Rot", "§c", 1, Material.REDSTONE_BLOCK);
			
			plugin.teams.add(blau);
			plugin.teams.add(rot);

			RushReloaded.getPlugin().getLogger().info("Teams gesetzt!");

			plugin.maxPlayers = 2;

		} else if(RushReloaded.getPlugin().SIZE == SizeEnum.SIZE_4x1) {
			Team blau = new Team("Blau", "§9", 1, Material.LAPIS_BLOCK);
			Team rot = new Team("Rot", "§c", 1, Material.REDSTONE_BLOCK);
			Team gelb = new Team("Gelb", "§e", 1, Material.GLOWSTONE);
			Team gruen = new Team("Grün", "§a", 1, Material.GRASS);
			
			plugin.teams.add(blau);
			plugin.teams.add(rot);
			plugin.teams.add(gelb);
			plugin.teams.add(gruen);

			plugin.maxPlayers = 4;

		} else if(RushReloaded.getPlugin().SIZE == SizeEnum.SIZE_8x1) {
			Team blau = new Team("Blau", "§9", 1, Material.LAPIS_BLOCK);
			Team rot = new Team("Rot", "§c", 1, Material.REDSTONE_BLOCK);
			Team gelb = new Team("Gelb", "§e", 1, Material.GLOWSTONE);
			Team gruen = new Team("Grün", "§a", 1, Material.GRASS);
			
			Team weiß = new Team("Weiß", "§f", 1, Material.QUARTZ);
			Team orange = new Team("Orange", "§6", 1, Material.PUMPKIN);
			Team türkis = new Team("Türkis", "§b", 1, Material.DIAMOND_BLOCK);
			Team lila = new Team("Lila", "§5", 1, Material.OBSIDIAN);
			
			plugin.teams.add(blau);
			plugin.teams.add(rot);
			plugin.teams.add(gelb);
			plugin.teams.add(gruen);
			plugin.teams.add(weiß);
			plugin.teams.add(orange);
			plugin.teams.add(türkis);
			plugin.teams.add(lila);

			plugin.maxPlayers = 8;
			
		} else if(RushReloaded.getPlugin().SIZE == SizeEnum.SIZE_4x2) {
			Team blau = new Team("Blau", "§9", 2, Material.LAPIS_BLOCK);
			Team rot = new Team("Rot", "§c", 2, Material.REDSTONE_BLOCK);
			Team gelb = new Team("Gelb", "§e", 2, Material.GLOWSTONE);
			Team gruen = new Team("Grün", "§a", 2, Material.GRASS);
			
			plugin.teams.add(blau);
			plugin.teams.add(rot);
			plugin.teams.add(gelb);
			plugin.teams.add(gruen);

			plugin.maxPlayers = 8;
		}
	}
	
}

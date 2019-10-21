package me.noprefix.rr.utils;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.noprefix.rr.RushReloaded;
import org.bukkit.entity.Villager;

import java.io.IOException;

public class CommandUtils {

	private RushReloaded rushReloaded;
	
	@SuppressWarnings("null")
	public void handleCommand(String[] command, CommandSender sender) throws IOException {
		
		rushReloaded = RushReloaded.getPlugin();
		
		//Variablen werden zur Verwendung bereit gemacht
		
		String cmd = command[0];
		
		System.out.print(cmd + "");

		String argString = "";
		if(command.length >= 2) {
			for(int i = 1; i < command.length; i++) {
				argString += command[i] + " ";
			}
			argString = argString.trim();
		}
		
		System.out.println(argString);
		
		String[] args = argString.split(" ");
		
		System.out.println("cmd: [" + cmd + "]");
		//Ab jetzt wird der Command verwendet
		
		System.out.println(args.length);
		
		if(cmd.equals("help")) {
			sender.sendMessage("§aRushReloaded - Hilfe");
			sender.sendMessage("/rr setLobby §7Setzt die Lobby f§r das Spiel");
			sender.sendMessage("/rr setup <Name> §7Setzt den Namen dieser Map der nachher in der MOTD steht. (Farbcodes mit &)");
			sender.sendMessage("/rr setSize <2x1/4x1/4x2/8x1> §7Setzt die Spielgr§§e");
			sender.sendMessage("/rr teams §7Zeigt alle derzeitigen Teams mit deren Farbblock an");
			sender.sendMessage("/rr setSpawn <Team> §7Setzt einen Spawnpunkt f§r ein Team");
			sender.sendMessage("/rr setSpawner <Team> §7Setzt den Bronze-Spawner f§r ein Team");
			sender.sendMessage("/rr setSpec §7Setzt den Spawnpunkt f§r Spectator");
			sender.sendMessage("/rr setshop §7Spawnt einen Villager (Shop)");
			sender.sendMessage("Um das Bett eines Teams zu setzen, setze ein Bett auf die Farbbl§cke des Teams!");
		} else if(cmd.equalsIgnoreCase("setup") && args.length == 1) {
			String name = ChatColor.translateAlternateColorCodes('&', args[0]);
			rushReloaded.serverMOTD = name;
			System.out.println(name + rushReloaded.getConfigUtils());
			rushReloaded.getConfigUtils().setName(name);
			sender.sendMessage("§aDer Mapname wurde auf §e" + name + "§a gesetzt!");
		} else if(cmd.equalsIgnoreCase("setsize") && args.length == 1) {
			if(rushReloaded.getConfigUtils().setSize("SIZE_" + args[0])) {
				sender.sendMessage("§aDu hast die Size auf §e" + args[0] + "§a gesetzt!");
			} else
				sender.sendMessage("§cEin Fehler ist aufgetreten!");
		} else if(cmd.equalsIgnoreCase("teams")) {
			sender.sendMessage("§aTeamliste");
			for(Team team : rushReloaded.teams) {
				sender.sendMessage("Team " + team.getColor() + team.getName() + " §rBlock: " + team.getColor() + team.getBedBlock() + " §rMaximale Spieler: " + team.getColor() + team.getMaxPlayers());
			}
		} else if(cmd.equalsIgnoreCase("setspawn") && args.length == 1) {
			String team = args[0];
			Team usedTeam = null;
			for(Team team1 : rushReloaded.teams) {
				if(team1.getName().equalsIgnoreCase(team)) {
					usedTeam = team1;
				}
			}
			
			if(usedTeam == null) {
				sender.sendMessage(rushReloaded.PREFIX + "§cDieses Team existiert nicht! §7(§e/rr teams§7)");
				return;
			}
			
			Player player = (Player) sender;
			usedTeam.setSpawn(player.getLocation());
			player.sendMessage(rushReloaded.PREFIX + "Du hast erfolgreich den Spawn von Team " 
			+ usedTeam.getColor() + usedTeam.getName() + " §rgesetzt!");
			
		} else if(cmd.equalsIgnoreCase("setspawner") && args.length == 1) {
			String team = args[0];
			Team usedTeam = null;
			for(Team team1 : rushReloaded.teams) {
				if(team1.getName().equalsIgnoreCase(team)) {
					usedTeam = team1;
				}
			}
			
			if(usedTeam == null) {
				sender.sendMessage(rushReloaded.PREFIX + "§cDieses Team existiert nicht! §7(§e/rr teams§7)");
				return;
			}
			
			Player player = (Player) sender;
			usedTeam.setSpawner(player.getLocation());
			player.sendMessage(rushReloaded.PREFIX + "§aDu hast erfolgreich den Bronze-Spawner von Team "
			+ usedTeam.getColor() + usedTeam.getName() + " §rgesetzt!");
		} else if(cmd.equalsIgnoreCase("setspec")) {
			Player player = (Player) sender;
			rushReloaded.SPEC = player.getLocation();
			rushReloaded.getConfigUtils().setSpec(player.getLocation());
			player.sendMessage(rushReloaded.PREFIX + "§aDu hast erfolgreich den Spectator-Spawn gesetzt!");
		} else if(cmd.equalsIgnoreCase("setlobby")) {
			Player player = (Player) sender;
			rushReloaded.LOBBY = player.getLocation();
			rushReloaded.getConfigUtils().setLobby(player.getLocation());
			player.sendMessage(rushReloaded.PREFIX + "§aDu hast erfolgreich die Lobby gesetzt!");
		} else if(cmd.equalsIgnoreCase("setvillager")) {
			{
				Player player = (Player) sender;
				Villager villager = (Villager)player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
				noAI(villager);
				villager.setCustomName("§aShop");
				villager.setCustomNameVisible(true);
				villager.setProfession(Villager.Profession.FARMER);
				villager.setCanPickupItems(false);
				player.sendMessage(rushReloaded.PREFIX + "§aDu hast den Shop gespawnt!");
			}

		} else if(cmd.equalsIgnoreCase("setdeath")) {
			RushReloaded.getPlugin().getConfigUtils().setDeath(((Player) sender).getLocation());
			sender.sendMessage(rushReloaded.PREFIX + "§aDu hast die Todeslocation gesetzt!");
		} else {
			sender.sendMessage("§aRushReloaded - Verwendung");
			sender.sendMessage("/rr setLobby §7Setzt die Lobby f§r das Spiel");
			sender.sendMessage("/rr setup <Name> §7Setzt den Namen dieser Map der nachher in der MOTD steht. (Farbcodes mit &)");
			sender.sendMessage("/rr setSize <2x1/4x1/4x2/8x1> §7Setzt die Spielgr§§e");
			sender.sendMessage("/rr teams §7Zeigt alle derzeitigen Teams mit deren Farbblock an");
			sender.sendMessage("/rr setSpawn <Team> §7Setzt einen Spawnpunkt f§r ein Team");
			sender.sendMessage("/rr setSpawner <Team> §7Setzt den Bronze-Spawner f§r ein Team");
			sender.sendMessage("/rr setSpec §7Setzt den Spawnpunkt f§r Spectator");
			sender.sendMessage("Um das Bett eines Teams zu setzen, setze ein Bett auf die Farbbl§cke des Teams!");
		}
		
	}

	void noAI(org.bukkit.entity.Entity be)
	{
		net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity)be).getHandle();
		NBTTagCompound tag = nmsEntity.getNBTTag();
		if (tag == null) {
			tag = new NBTTagCompound();
		}
		nmsEntity.c(tag);
		tag.setBoolean("NoAI", true);
		nmsEntity.f(tag);
	}
	
}

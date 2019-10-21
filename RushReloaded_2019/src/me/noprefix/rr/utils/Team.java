package me.noprefix.rr.utils;

import java.io.IOException;
import java.util.ArrayList;

import me.noprefix.rr.RushReloaded;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Team {

	private String color;
	private String name;
	private int maxPlayers;
	private int currentPlayers;
	private ArrayList<Player> playersIn;
	private Material bedBlock;
	private Location spawn;
	private Location spawner;
	private boolean bed = true;
	
	public Team(String name, String color, int maxPlayers, Material bedBlock) {
		this.name = name;
		this.color = color;
		this.maxPlayers = maxPlayers;
		playersIn = new ArrayList<>();
		this.bedBlock = bedBlock;
	}
	
	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getCurrentPlayers() {
		return currentPlayers;
	}

	public void setCurrentPlayers(int currentPlayers) {
		this.currentPlayers = currentPlayers;
	}

	public ArrayList<Player> getPlayersIn() {
		return playersIn;
	}

	public void addPlayer(Player player) {
		playersIn.add(player);
		currentPlayers++;
		player.setPlayerListName(getColor() + getName() + " | " + player.getName());
		player.setDisplayName(getColor() + getName() + " | " + player.getName());
	}

	public void removePlayer(Player player) {
		if(playersIn.contains(player)) {
			playersIn.remove(player);
			currentPlayers--;
		}
	}
	
	public Material getBedBlock() {
		return bedBlock;
	}

	public Location getSpawn() {
		return spawn;
	}

	public Location getSpawner() {
		return spawner;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
		try {
			RushReloaded.getPlugin().getConfigUtils().setTeamSpawn(this, spawn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSpawner(Location spawner) {
		this.spawner = spawner;
		try {
			RushReloaded.getPlugin().getConfigUtils().setTeamSpawner(this, spawner);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isBed() {
		return bed;
	}

	public void setBed(boolean bed) {
		this.bed = bed;
	}
}

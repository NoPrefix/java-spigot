package me.noprefix.rr.utils;

import org.bukkit.Bukkit;

import me.noprefix.rr.RushReloaded;

public class MessageUtil {

	public static void broadcast(String message) {
		Bukkit.broadcastMessage(RushReloaded.getPlugin().PREFIX + message);
	}
	
}

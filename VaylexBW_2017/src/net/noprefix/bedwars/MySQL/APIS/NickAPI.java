package net.noprefix.bedwars.MySQL.APIS;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import net.noprefix.bedwars.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

public class NickAPI {
	
	public HashMap<Player, String> nicked =  new HashMap<>();
	
	public void removeFromTab(CraftPlayer cp) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, cp.getHandle());
		sendPacket(packet);	
	}
	
	public void addtoTab(CraftPlayer cp) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, cp.getHandle());
		sendPacket(packet);	
	}
	
	public void sendPacket(Packet<?> packet) {
		for(Player all : Bukkit.getOnlinePlayers()) {
			((CraftPlayer)all).getHandle().playerConnection.sendPacket(packet);
		}
	}
	
	public Field getField(Class<?> clazz, String name) {
		try {
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		}catch (NoSuchFieldException | SecurityException e) {
			return null;
		}
	}
	
	public String getNickName(Player p) {
		return nicked.get(p);
	}
	
	public void setNick(Player p) {
		String name = getRandomName(p);
		CraftPlayer cp = (CraftPlayer)p;
		try {
			Main.nameField.set(cp.getProfile(), name);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(cp.getEntityId());
		sendPacket(destroy);
		removeFromTab(cp);
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				addtoTab(cp);
				PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(!all.equals(p)) {
						((CraftPlayer) all).getHandle().playerConnection.sendPacket(spawn);
					}
				}
				
				
			}
		}.runTaskLater(Main.plugin, 4);
	}
	
	
	public void remove(Player p) {
		if(nicked.containsKey(p)) {
			nicked.remove(p);
		}
	}
	
	public String getRandomName(Player p) {
		String name = " ";
		ArrayList<String> names = new ArrayList<>();
		names.add("Weblington");
		names.add("_IamLoser");
		names.add("Adidushi");
		names.add("amzyw_");
		names.add("CanerBeyy");
		names.add("DarkAle32");

		names.add("Sara64");
		names.add("SuperSimo2000");
		names.add("sasaageyo");
		names.add("syri4n_zombie");
		names.add("0xzo");
		names.add("AlaskaM00se");

		names.add("Bebosss");
		names.add("bigboi3214");
		names.add("bisexualmommiiy");
		names.add("butterman239");
		names.add("Derplacorn101");
		names.add("Evesjo");

		names.add("frogyo_");
		names.add("LightningShock");
		names.add("Luc1f3r_I_4M");
		names.add("Indominus_Otaku");
		names.add("aCastro");
		names.add("Alexandi2006");

		names.add("BowCast");
		names.add("DallyOs");
		names.add("GAMING_PL");
		names.add("FactionsUnknown");
		names.add("JustFeelings_");
		Random rs = new Random();
		int i = rs.nextInt(names.size());
		name = names.get(i);
		
		nicked.put(p, name);
		
		return name;
	}
}

package net.noprefix.bedwars.Listener;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.noprefix.bedwars.MySQL.APIS.Skin;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import net.noprefix.bedwars.Hologramms.Scheduler_Bedwars;
import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.ItemBuilder;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import net.noprefix.bedwars.Scoreboards.InGameScoreboard;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.noprefix.bedwars.Countdowns.LobbyCountdown;
import net.noprefix.bedwars.Methodes.API;

public class PlayerJoinListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJ(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		if(Main.gs == GameState.LOBBY) {
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
			
			if(Main.plugin.getNickManager().getNick(p.getUniqueId().toString()) == true) {
				Main.plugin.getNickAPI().setNick(p);
				String name = Main.plugin.getNickAPI().getNickName(p);
				GameProfile gp = ((CraftPlayer)p).getProfile();
				gp.getProperties().clear();
				Skin skin = new Skin(getUUID(name));

				if(skin.getSkinName() != null){
					gp.getProperties().put(skin.getSkinName(),new Property(skin.getSkinName(), skin.getSkinValue(),skin.getSkinSignatur()));
				}

				Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

					@Override
					public void run() {
						for(Player pl : Bukkit.getOnlinePlayers()){
							pl.hidePlayer((Player)p);
						}

					}
				}, 1);

				Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {

					@Override
					public void run() {
						for(Player pl : Bukkit.getOnlinePlayers()){
							pl.showPlayer((Player)p);
						}

					}
				}, 20);

				p.sendMessage(Main.plugin.getNickPrefix() + "§7Dein NickName §8» §5§l" + Main.plugin.getNickAPI().getNickName(p));
			}
			
			p.getInventory().clear();
			p.setFoodLevel(20);
			e.setJoinMessage(null);
			Main.ONLINE_Players.add(p);
			p.playSound(p.getLocation(), Sound.FIREWORK_TWINKLE2, 3, 2);
			p.setGameMode(GameMode.SURVIVAL);
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage(Main.prefix + "§e" + p.getName() + "§7 hat das Spiel betreten§8! (§e§l" + Main.ONLINE_Players.size() + "§8/§e§l" + SizeManager.getMaxPlayers()+ "§8)");
				all.playSound(all.getLocation(), Sound.NOTE_PIANO, 1, 1);
			}
		
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 25, 1, false, false));
			
			new Scheduler_Bedwars(p);
			
			p.setLevel(60);

			API.create(p);
			
			LobbyCountdown.start();
			
			p.getInventory().setItem(0, new ItemBuilder(Material.BED).setName("§8» §6Teams §8┃ §7Rechtsklick").toItemStack());
			p.getInventory().setItem(3, new ItemBuilder(Material.TRIPWIRE_HOOK).setName("§8» §6Gold Voting §8┃ §7Rechtsklick").toItemStack());
			p.getInventory().setItem(5, new ItemBuilder(Material.FURNACE).setName("§8» §6Drop Voting §8┃ §7Rechtsklick").toItemStack());
			p.getInventory().setItem(8, new ItemBuilder(Material.SLIME_BALL).setName("§8» §6Zurück §8┃ §7Rechtsklick").toItemStack());
			
			p.teleport(LocationBuilder.load("Location.Lobby"));
			
			p.sendTitle("§6§lBedwars", "§7Vaylex.de");
			
			Main.plugin.getSQL().createPlayer(p.getName(), p.getUniqueId().toString());
			
			
			for(Player all : Bukkit.getOnlinePlayers()) Main.plugin.getLobbyScoreboard().setScoreboard(all);
			
			
			Bukkit.getScheduler().scheduleSyncDelayedTask( Main.plugin, new Runnable(){

	            @Override
	            public void run() {
	                Firework fire = p.getWorld().spawn(p.getLocation(), Firework.class);

	                FireworkMeta meta = fire.getFireworkMeta();
	                meta.addEffect( FireworkEffect.builder().withColor(Color.RED).withFade( Color.FUCHSIA).trail( true ).build());
	                meta.setPower(1);

	                fire.setFireworkMeta(meta);
	            }

	        }, 10);
			/*if(Main.plugin.getLobbyArmor().set == false) {
				Main.plugin.getLobbyArmor().set();
			}*/
			/*if(Main.plugin.getArmorMap().set == false) {
				Main.plugin.getArmorMap().set();
			}*/
			
		}else if(Main.gs == GameState.INGAME){
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.setAllowFlight(true);
			p.setFlying(true);
			TeamManager.clear(p);
			p.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setName("§8» §3Teleporter §8┃ §7Rechtsklick").toItemStack());
			Main.SPEC_PLAYERS.add(p);
			p.teleport(LocationBuilder.load("Spectator." + MapManager.map));
			for(Player all : Bukkit.getOnlinePlayers()) {
				InGameScoreboard.setScoreboard(all);
				if(!Main.SPEC_PLAYERS.contains(all)) {
					all.hidePlayer(p);
				}
			}
		}
		
		
		
	}

	public String getUUID(String name){
		return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replace("-", "");
	}


	public void sendGameState(Player player, int type, float state) {
		PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(type, state);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

}

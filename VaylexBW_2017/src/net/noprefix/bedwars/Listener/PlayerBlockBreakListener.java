package net.noprefix.bedwars.Listener;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Scoreboards.InGameScoreboard;
import net.noprefix.bedwars.States.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.noprefix.bedwars.Methodes.API;

public class PlayerBlockBreakListener implements Listener{

	@SuppressWarnings({ "deprecation"})
	@EventHandler
	public void onB(BlockBreakEvent e) {
	    Block block = e.getBlock();
	    Player p = e.getPlayer();
	    if(Main.SPEC_PLAYERS.contains(p)) {
	    	e.setCancelled(true);
	    }
		if(!(Main.gs == GameState.INGAME)) {
			e.setCancelled(true);
		}else {
			if(!Main.SPEC_PLAYERS.contains(p)) {
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK)) {
				
		        if (!TeamManager.teamBlau.contains(p)) {
				p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          e.setCancelled(true);
		          block.setType(Material.AIR);
		          API.beds.put(p, (API.beds.get(p)+1));
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          TeamManager.bedBlau = Boolean.valueOf(false);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §9§lBlau §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamBlau.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerstört!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK)) {
		        if (!TeamManager.teamRot.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          e.setCancelled(true);
		          block.setType(Material.AIR);
		          API.beds.put(p, (API.beds.get(p)+1));
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          TeamManager.bedRot = Boolean.valueOf(false);
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §c§lRot §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamRot.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK)) {
		        if (!TeamManager.teamGelb.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");

		          e.setCancelled(true);
		          API.beds.put(p, (API.beds.get(p)+1));
		          block.setType(Material.AIR);
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          TeamManager.bedGelb = Boolean.valueOf(false);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()) {
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §e§lGelb §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamGelb.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK)) {
		        if (!TeamManager.teamGruen.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
					
		          e.setCancelled(true);
		          block.setType(Material.AIR);
		          API.beds.put(p, (API.beds.get(p)+1));
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          TeamManager.bedGruen = Boolean.valueOf(false);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §2§lGreun §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamGruen.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.NETHER_BRICK)) {
		        if (!TeamManager.teamLila.contains(p)) {
		          e.setCancelled(true);
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          block.setType(Material.AIR);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          TeamManager.bedLila = Boolean.valueOf(false);
		          API.beds.put(p, (API.beds.get(p)+1));
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §5§lLila §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamLila.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.COAL_BLOCK)) {
		        if (!TeamManager.teamSchwarz.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          e.setCancelled(true);
		          block.setType(Material.AIR);
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          API.beds.put(p, (API.beds.get(p)+1));
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          TeamManager.bedSchwarz = Boolean.valueOf(false);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §0§lSchwarz §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamSchwarz.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.PUMPKIN)) {
		        if (!TeamManager.teamOrange.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          e.setCancelled(true);
		          API.beds.put(p, (API.beds.get(p)+1));
		          block.setType(Material.AIR);
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          TeamManager.bedOrange = Boolean.valueOf(false);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §6§lOrange §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamOrange.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			if ((block.getType() == Material.BED_BLOCK) && (block.getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK)) {
		        if (!TeamManager.teamTurkis.contains(p)) {
					p.sendMessage(Main.prefix + "§a+ 50 Coins");
		          e.setCancelled(true);
		          API.beds.put(p, (API.beds.get(p)+1));
		          block.setType(Material.AIR);
		          block.getWorld().strikeLightningEffect(e.getBlock().getLocation());
		          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		          Main.plugin.getSQL().addPoints(p.getUniqueId().toString(), 10);
		          TeamManager.bedTurkis = Boolean.valueOf(false);
		          for (Player all : Bukkit.getOnlinePlayers()){
		            all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0F, 1.0F);
		            all.sendMessage(Main.prefix + "§7Das Bett von Team §b§lTurkis §7wurde von " + TeamManager.getTeamColors(p) + p.getName() + "§7 abgebaut!");
		    	   InGameScoreboard.setScoreboard(all);
		            
		            if(TeamManager.teamTurkis.contains(all)) {
		            	all.sendTitle("§cDein Bett", "§cwurde zerst§rt!");
		            }
		          }
		        }else {
		        	e.setCancelled(true);
		        	p.sendMessage(Main.prefix + "§7Du kannst dein §e§leigenes §7Bett nicht abbauen!");
		        }
		      }
			
			
		      
			}
			        
		      
		      if(block.getType() == Material.SANDSTONE || block.getType() == Material.ENDER_STONE || block.getType() == Material.IRON_BLOCK || block.getType() == Material.GLASS || block.getType() == Material.GLOWSTONE || block.getType() == Material.ENDER_CHEST || block.getType() == Material.CHEST) {
		    	  e.setCancelled(false);
		      }else if(p.getGameMode() == GameMode.SURVIVAL) {
		    	  e.setCancelled(true);
		      }else {
		    	  e.setCancelled(false);
		      }
				
				
			
			
		}
	}

}

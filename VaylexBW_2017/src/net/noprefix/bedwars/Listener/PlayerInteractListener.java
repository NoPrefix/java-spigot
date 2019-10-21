package net.noprefix.bedwars.Listener;

import java.util.ArrayList;
import java.util.Iterator;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.ItemBuilder;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PlayerInteractListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onI(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		try {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
		if(e.getItem().getType() == Material.BED && e.getItem().getItemMeta().getDisplayName().equals("§8» §6Teams §8┃ §7Rechtsklick")) {
			Inventory Inv = Bukkit.createInventory(null, 9*3, "§8§l» §a§lTeams");
			
			ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short)7).setName("§8 ").toItemStack();
			for(int i = 0; i < 9; i++) {
				Inv.setItem(i, glass);
			}
			
			for(int i = 18; i < 27; i++) {
				Inv.setItem(i, glass);
			}

			
			ItemStack teamblau = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metablau = (LeatherArmorMeta) teamblau.getItemMeta();
			metablau.setColor(Color.BLUE);
			metablau.setDisplayName("§8§l« §9§lBlau §8§l»");
			ArrayList<String> lore = new ArrayList<>();
			lore.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamBlau.size(); i++) {
				lore.add("§8× §9" + TeamManager.teamBlau.get(i).getName());
			}
			metablau.setLore(lore);
			teamblau.setItemMeta(metablau);
			
			ItemStack teamrot = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metarot = (LeatherArmorMeta) teamrot.getItemMeta();
			metarot.setColor(Color.RED);
			metarot.setDisplayName("§8§l« §c§lRot §8§l»");
			ArrayList<String> lore1 = new ArrayList<>();
			lore1.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamRot.size(); i++) {
				lore1.add("§8× §c" + TeamManager.teamRot.get(i).getName());
			}
			metarot.setLore(lore1);
			teamrot.setItemMeta(metarot);
			
			ItemStack teamgelb = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metagelb = (LeatherArmorMeta) teamgelb.getItemMeta();
			metagelb.setColor(Color.YELLOW);
			metagelb.setDisplayName("§8§l« §e§lGelb §8§l»");
			ArrayList<String> lore2 = new ArrayList<>();
			lore2.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamGelb.size(); i++) {
				lore2.add("§8× §e" + TeamManager.teamGelb.get(i).getName());
			}
			metagelb.setLore(lore2);
			teamgelb.setItemMeta(metagelb);
			
			ItemStack teamgruen = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metagruen = (LeatherArmorMeta) teamgruen.getItemMeta();
			metagruen.setColor(Color.GREEN);
			metagruen.setDisplayName("§8§l« §2§lGruen §8§l»");
			ArrayList<String> lore3 = new ArrayList<>();
			lore3.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamGruen.size(); i++) {
				lore3.add("§8× §2" + TeamManager.teamGruen.get(i).getName());
			}
			metagruen.setLore(lore3);
			teamgruen.setItemMeta(metagruen);	
			
			ItemStack teamlila = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metalila = (LeatherArmorMeta) teamlila.getItemMeta();
			metalila.setColor(Color.PURPLE);
			metalila.setDisplayName("§8§l« §5§lLila §8§l»");
			ArrayList<String> lore4 = new ArrayList<>();
			lore4.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamLila.size(); i++) {
				lore4.add("§8× §5" + TeamManager.teamLila.get(i).getName());
			}
			metalila.setLore(lore4);
			teamlila.setItemMeta(metalila);	
			
			ItemStack teamSchwarz = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metaSchwarz = (LeatherArmorMeta) teamSchwarz.getItemMeta();
			metaSchwarz.setColor(Color.BLACK);
			metaSchwarz.setDisplayName("§8§l« §0§lSchwarz §8§l»");
			ArrayList<String> lore5 = new ArrayList<>();
			lore5.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamSchwarz.size(); i++) {
				lore5.add("§8× §0" + TeamManager.teamSchwarz.get(i).getName());
			}
			metaSchwarz.setLore(lore5);
			teamSchwarz.setItemMeta(metaSchwarz);	
			
			ItemStack teamturkis = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metaturkis = (LeatherArmorMeta) teamturkis.getItemMeta();
			metaturkis.setColor(Color.AQUA);
			metaturkis.setDisplayName("§8§l« §b§lTurkis §8§l»");
			ArrayList<String> lore6 = new ArrayList<>();
			lore6.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamTurkis.size(); i++) {
				lore6.add("§8× §b" + TeamManager.teamTurkis.get(i).getName());
			}
			metaturkis.setLore(lore6);
			teamturkis.setItemMeta(metaturkis);	
			
			ItemStack teamOrange = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta metaOrange = (LeatherArmorMeta) teamOrange.getItemMeta();
			metaOrange.setColor(Color.ORANGE);
			metaOrange.setDisplayName("§8§l« §6§lOrange §8§l»");
			ArrayList<String> lore7 = new ArrayList<>();
			lore7.add("§8§m-------------");
			for(int i = 0; i < TeamManager.teamOrange.size(); i++) {
				lore7.add("§8× §6" + TeamManager.teamOrange.get(i).getName());
			}
			metaOrange.setLore(lore7);
			teamOrange.setItemMeta(metaOrange);	
			
			
			
			if(Main.ss == SizeState.SIZE8x1) {
			
				Inv.setItem(9, teamblau);
				Inv.setItem(10, teamrot);
				Inv.setItem(11, teamgelb);
				Inv.setItem(12, teamgruen);
				
				Inv.setItem(13, teamlila);
				Inv.setItem(14, teamSchwarz);
				Inv.setItem(15, teamturkis);
				Inv.setItem(16, teamOrange);
				
			}
			
			if(Main.ss == SizeState.SIZE4x2) {
				
				Inv.setItem(9, teamblau);
				Inv.setItem(11, teamrot);
				Inv.setItem(13, teamgelb);
				Inv.setItem(15, teamgruen);
			
				
			}
			
			if(Main.ss == SizeState.SIZE2x1) {
				
				Inv.setItem(12, teamblau);
				Inv.setItem(14, teamrot);

				
			}
			p.openInventory(Inv);
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 3, 2);
		
		}else if(e.getItem().getItemMeta().getDisplayName().contains("Voting")) {
			/*Inventory Inv = Bukkit.createInventory(null, 9*1, "§8§l« §e§lVoting §8§l»");
			
			Inv.setItem(2, new ItemBuilder(Material.getMaterial(358)).setName("§8§l« §e§lMaps §8§l»").toItemStack());
			Inv.setItem(4, new ItemBuilder(Material.WEB).setName("§8§l« §6§lWebs §8§l»").toItemStack());			
			Inv.setItem(6, new ItemBuilder(Material.GOLD_INGOT).setName("§8§l« §e§lGold §8§l»").toItemStack());
			
			//p.openInventory(Inv);
			p.playSound(p.getLocation(), Sound.CHEST_OPEN, 3, 2);*/
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 3, 2);
			p.sendMessage(Main.prefix + "§7Diese §e§lFeature §7wurde Momentan deaktiviert§8!");
			
		}else if(e.getItem().getType() == Material.SLIME_BALL && e.getItem().getItemMeta().getDisplayName().equals("§8» §6Zurück §8┃ §7Rechtsklick")) {
			p.sendMessage(Main.prefix + "§7Du hast das §a§lSpiel §7verlassen§8!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
			p.kickPlayer(null);
		}else if(e.getItem().getType() == Material.SLIME_BALL && e.getItem().getItemMeta().getDisplayName().equals("§8» §3Teleporter §8┃ §7Rechtsklick")) {
			Inventory Inv = Bukkit.createInventory(null, 9*2, "§8§l« §e§lTeleporter §8§l»");
			Iterator i = Main.ONLINE_Players.iterator();
			while (i.hasNext()) {
				Inv.addItem(new ItemBuilder(Material.SKULL_ITEM).setSkullOwner(i.next().toString()).toItemStack());
			}
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
		}/*else if(e.getItem().getType() == Material.TRIPWIRE_HOOK && e.getItem().getItemMeta().getDisplayName().equals("§8» §6Gold Voting §8┃ §7Rechtsklick")) {
			Inventory Inv = Bukkit.createInventory(null, 9*1, "§8» §6Gold Voting");
			
			Inv.setItem(2, new ItemBuilder(Material.INK_SACK, 0, (short) 10).setName("§8» §aJa ✔").toItemStack());
			
			Inv.setItem(4, new ItemBuilder(Material.TRIPWIRE_HOOK).setName("§8» §6Gold Voting").toItemStack());
			
			Inv.setItem(6, new ItemBuilder(Material.INK_SACK, 0, (short) 1).setName("§8» §cNein ✘").toItemStack());
			
			p.openInventory(Inv);
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
		}else if(e.getItem().getType() == Material.FURNACE && e.getItem().getItemMeta().getDisplayName().equals("§8» §6Drop Voting §8┃ §7Rechtsklick")) {
			Inventory Inv = Bukkit.createInventory(null, 9*1, "§8» §6Drop Voting");
			
			Inv.setItem(2, new ItemBuilder(Material.INK_SACK, 0, (short) 10).setName("§8» §aJa ✔").toItemStack());
			
			Inv.setItem(4, new ItemBuilder(Material.FURNACE).setName("§8» §6Drop Voting").toItemStack());
			
			Inv.setItem(6, new ItemBuilder(Material.INK_SACK, 0, (short) 1).setName("§8» §cNein ✘").toItemStack());
			
			p.openInventory(Inv);
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
		}*/
			
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}

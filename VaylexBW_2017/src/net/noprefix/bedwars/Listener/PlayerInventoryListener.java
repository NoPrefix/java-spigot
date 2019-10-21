package net.noprefix.bedwars.Listener;
		
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.Methodes.ItemBuilder;
import net.noprefix.bedwars.States.GameState;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;			
	import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Methodes.API;

public class PlayerInventoryListener implements Listener{
	
	@EventHandler
	public void onI(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		try {
		if(e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §9§lBlau §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamBlau.contains(p)) {
						if(TeamManager.teamBlau.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamBlau.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §9§lBlau §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE4x2) {
					if(!TeamManager.teamBlau.contains(p)) {
						if(TeamManager.teamBlau.size() != 2) {
							TeamManager.clear(p);
							TeamManager.teamBlau.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §9§lBlau §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE2x1) {
					if(!TeamManager.teamBlau.contains(p)) {
						if(TeamManager.teamBlau.size() != 1) {
							TeamManager.clear(p);
							TeamManager.teamBlau.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §9§lBlau §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §c§lRot §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamRot.contains(p)) {
						if(TeamManager.teamRot.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamRot.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §c§lRot §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE4x2) {
					if(!TeamManager.teamRot.contains(p)) {
						if(TeamManager.teamRot.size() != 2) {
							TeamManager.clear(p);
							TeamManager.teamRot.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §c§lRot §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE2x1) {
					if(!TeamManager.teamRot.contains(p)) {
						if(TeamManager.teamRot.size() != 1) {
							TeamManager.clear(p);
							TeamManager.teamRot.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §c§lRot §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §e§lGelb §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamGelb.contains(p)) {
						if(TeamManager.teamGelb.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamGelb.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §e§lGelb §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE4x2) {
					if(!TeamManager.teamGelb.contains(p)) {
						if(TeamManager.teamGelb.size() != 2) {
							TeamManager.clear(p);
							TeamManager.teamGelb.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §e§lGelb §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §2§lGruen §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamGruen.contains(p)) {
						if(TeamManager.teamGruen.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamGruen.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §2§lGruen §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}else if(Main.ss == SizeState.SIZE4x2) {
					if(!TeamManager.teamGruen.contains(p)) {
						if(TeamManager.teamGruen.size() != 2) {
							TeamManager.clear(p);
							TeamManager.teamGruen.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §2§lGruen §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §5§lLila §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamLila.contains(p)) {
						if(TeamManager.teamLila.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamLila.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §5§lLila §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §0§lSchwarz §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamSchwarz.contains(p)) {
						if(TeamManager.teamSchwarz.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamSchwarz.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §0§lSchwarz §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lOrange §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamOrange.contains(p)) {
						if(TeamManager.teamOrange.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamOrange.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §6§lOrange §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §b§lTurkis §8§l»")) {
				p.closeInventory();
				if(Main.ss == SizeState.SIZE8x1) {
					if(!TeamManager.teamTurkis.contains(p)) {
						if(TeamManager.teamTurkis.size() == 0) {
							TeamManager.clear(p);
							TeamManager.teamTurkis.add(p);
							p.sendMessage(Main.prefix + "§7Du hast das Team §b§lTurkis §7betreten§8!");
							p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
						}else {
							p.sendMessage(Main.prefix + "§7Das team ist §e§lbereits §7voll§8!");
						}
					}else {
						p.sendMessage(Main.prefix + "§7Du bist §e§lbereits §7in diesem Team§8!");
					}
					
				}
				
			}
		}
		if(e.getCurrentItem().getType() == Material.SANDSTONE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aBlöcke")) {
			
			
			
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(11, new ItemBuilder(Material.SANDSTONE, 2, (short) 0).setName("§8» §a§lSandstein").addLoreLine("§8✖ §c1 Bronze").toItemStack());
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.ENDER_STONE, 1, (short) 0).setName("§8» §a§lEndstein").addLoreLine("§8✖ §c4 Bronze").toItemStack());
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.IRON_BLOCK, 1, (short) 0).setName("§8» §a§lEisenblöcke").addLoreLine("§8✖ §75 Eisen").toItemStack());

			if(TeamManager.teamBlau.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 11).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamRot.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 14).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamGelb.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 4).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamGruen.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 13).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamLila.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 10).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamSchwarz.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 15).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamOrange.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 1).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}else if(TeamManager.teamTurkis.contains(p)) {
				p.getOpenInventory().setItem(14, new ItemBuilder(Material.STAINED_GLASS, 1, (short) 3).setName("§8» §a§lGlass").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			}

			
			p.getOpenInventory().setItem(15, new ItemBuilder(Material.GLOWSTONE, 4, (short) 0).setName("§8» §a§lGlowstone").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			p.getOpenInventory().setItem(16, new ItemBuilder(Material.SOUL_SAND, 1, (short) 0).setName("§8» §a§lSoulsand").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			
			if(TeamManager.teamBlau.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 11).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamRot.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 14).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamGelb.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 4).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamGruen.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 13).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamLila.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 10).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamSchwarz.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 15).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamOrange.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 1).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}else if(TeamManager.teamTurkis.contains(p)) {
				p.getOpenInventory().setItem(17, new ItemBuilder(Material.STAINED_CLAY, 2, (short) 3).setName("§8» §a§lTon").addLoreLine("§8✖ §c6 Bronze").toItemStack());
			}
		
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			
			
			
		}
		
		if(e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aRüstung")) {
			
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			if(TeamManager.teamBlau.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.BLUE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.BLUE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.BLUE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamRot.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.RED).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.RED).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.RED).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamGelb.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.YELLOW).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.YELLOW).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.YELLOW).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamGruen.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.GREEN).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.GREEN).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.GREEN).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamLila.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.PURPLE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.PURPLE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.PURPLE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamSchwarz.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.BLACK).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.BLACK).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.BLACK).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamOrange.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.ORANGE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.ORANGE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.ORANGE).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}else if(TeamManager.teamTurkis.contains(p)) {
				p.getOpenInventory().setItem(9, new ItemBuilder(Material.LEATHER_HELMET).setName("§8» §a§lLederhelm").setLeatherArmorColor(Color.AQUA).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(10, new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§8» §a§lLederhose").setLeatherArmorColor(Color.AQUA).addLoreLine("§8✖ §c2 Bronze").toItemStack());
				p.getOpenInventory().setItem(11, new ItemBuilder(Material.LEATHER_BOOTS).setName("§8» §a§lLederschuhe").setLeatherArmorColor(Color.AQUA).addLoreLine("§8✖ §c2 Bronze").toItemStack());
			}
			
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §a§lBrustplatte I").addLoreLine("§8✖ §71 Eisen").toItemStack());
			p.getOpenInventory().setItem(14, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("§8» §a§lBrustplatte II").addLoreLine("§8✖ §73 Eisen").toItemStack());
			p.getOpenInventory().setItem(15, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).setName("§8» §a§lBrustplatte III").addLoreLine("§8✖ §77 Eisen").toItemStack());
			
			
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		}
		
		if(e.getCurrentItem().getType() == Material.IRON_PICKAXE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aSpitzhacken")) {
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.WOOD_PICKAXE).setName("§8» §a§lSpitzhacke I").addLoreLine("§8✖ §c4 Bronze").toItemStack());
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.STONE_PICKAXE).setName("§8» §a§lSpitzhacke II").addLoreLine("§8✖ §72 Eisen").toItemStack());
			p.getOpenInventory().setItem(14, new ItemBuilder(Material.IRON_PICKAXE).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1).setName("§8» §a§lSpitzhacke III").addLoreLine("§8✖ §61 Gold").toItemStack());
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		
		}
		
		if(e.getCurrentItem().getType() == Material.WOOD_SWORD && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aWaffen")) {
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(11, new ItemBuilder(Material.STICK).addEnchant(Enchantment.KNOCKBACK, 1).setName("§8» §a§lKnüppel").addLoreLine("§8✖ §c8 Bronze").toItemStack());
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §a§lSchwert I").addLoreLine("§8✖ §71 Eisen").toItemStack());
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.WOOD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1).setName("§8» §a§lSchwert II").addLoreLine("§8✖ §73 Eisen").toItemStack());
			p.getOpenInventory().setItem(14, new ItemBuilder(Material.WOOD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 2).setName("§8» §a§lSchwert III").addLoreLine("§8✖ §77 Eisen").toItemStack());
			p.getOpenInventory().setItem(15, new ItemBuilder(Material.IRON_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1).setName("§8» §a§lSchwert VI").addLoreLine("§8✖ §65 Gold").toItemStack());

			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		
		}
		
		if(e.getCurrentItem().getType() == Material.BOW && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aBögen")) {
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(11, new ItemBuilder(Material.BOW).setName("§8» §a§lBow I").addLoreLine("§8✖ §63 Gold").toItemStack());
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName("§8» §a§lBow II").addLoreLine("§8✖ §67 Gold").toItemStack());
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 2).setName("§8» §a§lBow III").addLoreLine("§8✖ §613 Gold").toItemStack());
			
			p.getOpenInventory().setItem(15, new ItemBuilder(Material.ARROW).setName("§8» §a§lPfeil").addLoreLine("§8✖ §71 Eisen").toItemStack());
			
			
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		
		}
		
		if(e.getCurrentItem().getType() == Material.CAKE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aEssen")) {
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(11, new ItemBuilder(Material.APPLE).setName("§8» §a§lApfel").addLoreLine("§8✖ §c1 Bronze").toItemStack());
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.COOKED_BEEF).setName("§8» §a§lFleisch").addLoreLine("§8✖ §c2 Bronze").toItemStack());
			p.getOpenInventory().setItem(13, new ItemBuilder(Material.CAKE).setName("§8» §a§lKuchen").addLoreLine("§8✖ §71 Eisen").toItemStack());
			
			p.getOpenInventory().setItem(15, new ItemBuilder(Material.GOLDEN_APPLE).setName("§8» §a§lGolden Apple").addLoreLine("§8✖ §61 Gold").toItemStack());
			
			
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		
		}
		
		if(e.getCurrentItem().getType() == Material.ENDER_CHEST && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §aKisten")) {
			e.getInventory().clear();
			
			p.getOpenInventory().setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			p.getOpenInventory().setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			p.getOpenInventory().setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			p.getOpenInventory().setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			p.getOpenInventory().setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			p.getOpenInventory().setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			p.getOpenInventory().setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			
			p.getOpenInventory().setItem(12, new ItemBuilder(Material.CHEST).setName("§8» §a§lKiste I").addLoreLine("§8✖ §71 Eisen").toItemStack());

			p.getOpenInventory().setItem(14, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §a§lKiste II").addLoreLine("§8✖ §61 Gold").toItemStack());
			
			
			
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
		
		}
		
		if(e.getCurrentItem().getType() == Material.SANDSTONE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSandstein")) {
			if(!e.isShiftClick()) {
				if(API.getItemAmount(p, Material.CLAY_BRICK) >= 1) {
					API.removeItem(p, 1, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
					p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}
			}else {
				Integer i = API.getItemAmount(p, Material.CLAY_BRICK);
				
				if(i <= 64) {
					API.removeItem(p, i, Material.CLAY_BRICK);
					for(int c = 0; c < i; c++) {
						p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
						p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
					}
					for(int c = 0; c < i; c++) {
						p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
						p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
					}
				}else if(i >= 65){
					API.removeItem(p, 64, Material.CLAY_BRICK);
					for(int c = 0; c < 64; c++) {
						p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
						p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
					}
					for(int c = 0; c < i; c++) {
						p.getInventory().addItem(new ItemStack(Material.SANDSTONE));
						p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
					}
					
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				}
			}
		}
		
		if(e.getCurrentItem().getType() == Material.IRON_BLOCK && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lEisenblöcke")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 5) {
				API.removeItem(p, 5, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.STICK && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lKnüppel")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 8) {
				API.removeItem(p, 8, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemBuilder(Material.STICK).addEnchant(Enchantment.KNOCKBACK, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.WOOD_SWORD && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSchwert I")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 1) {
				API.removeItem(p, 1, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.WOOD_SWORD).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.WOOD_SWORD && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSchwert II")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 3) {
				API.removeItem(p, 3, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.WOOD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.WOOD_SWORD && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSchwert III")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 7) {
				API.removeItem(p, 7, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.WOOD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 2).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.APPLE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lApfel")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 1) {
				API.removeItem(p, 1, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemBuilder(Material.APPLE).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		

		if(e.getCurrentItem().getType() == Material.CAKE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lKuchen")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 1) {
				API.removeItem(p, 1, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.CAKE).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.COOKED_BEEF && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lFleisch")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 2) {
				API.removeItem(p, 2, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		

		if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lGolden Apple")) {
			if(API.getItemAmount(p, Material.GOLD_INGOT) >= 1) {
				API.removeItem(p, 1, Material.GOLD_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.IRON_SWORD && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSchwert VI")) {
			if(API.getItemAmount(p, Material.GOLD_INGOT) >= 5) {
				API.removeItem(p, 5, Material.GOLD_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.IRON_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.IRON_BLOCK && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lEisenblöcke")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 5) {
				API.removeItem(p, 5, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBrustplatte I")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 1) {
				API.removeItem(p, 1, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.WOOD_PICKAXE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSpitzhacke I")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 4) {
				API.removeItem(p, 4, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemBuilder(Material.WOOD_PICKAXE).addEnchant(Enchantment.LURE, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.STONE_PICKAXE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSpitzhacke II")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 2) {
				API.removeItem(p, 2, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.STONE_PICKAXE).addEnchant(Enchantment.LURE, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.IRON_PICKAXE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSpitzhacke III")) {
			if(API.getItemAmount(p, Material.GOLD_INGOT) >= 1) {
				API.removeItem(p, 1, Material.GOLD_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.IRON_PICKAXE).addEnchant(Enchantment.LURE, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		
		if(e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBrustplatte II")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 3) {
				API.removeItem(p, 3, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		
		if(e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBrustplatte III")) {
			if(API.getItemAmount(p, Material.IRON_INGOT) >= 7) {
				API.removeItem(p, 7, Material.IRON_INGOT);
				p.getInventory().addItem(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).toItemStack());
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.SOUL_SAND && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lSoulsand")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 8) {
				API.removeItem(p, 5, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemStack(Material.SOUL_SAND));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}

			if(e.getCurrentItem().getType() == Material.BOW && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBow I")) {
				if(API.getItemAmount(p, Material.GOLD_INGOT) >= 3) {
					API.removeItem(p, 3, Material.GOLD_INGOT);
					p.getInventory().addItem(new ItemStack(Material.BOW));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}

			if(e.getCurrentItem().getType() == Material.BOW && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBow II")) {
				if(API.getItemAmount(p, Material.GOLD_INGOT) >= 7) {
					API.removeItem(p, 7, Material.GOLD_INGOT);
					p.getInventory().addItem(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 1).toItemStack());
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}

			if(e.getCurrentItem().getType() == Material.SOUL_SAND && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lBow III")) {
				if(API.getItemAmount(p, Material.GOLD_INGOT) >= 13) {
					API.removeItem(p, 13, Material.GOLD_INGOT);
					p.getInventory().addItem(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 2).toItemStack());
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}

			if(e.getCurrentItem().getType() == Material.ARROW && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lPfeil")) {
				if(API.getItemAmount(p, Material.IRON_INGOT) >= 1) {
					API.removeItem(p, 1, Material.IRON_INGOT);
					p.getInventory().addItem(new ItemStack(Material.ARROW));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}

			if(e.getCurrentItem().getType() == Material.CHEST && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lKiste I")) {
				if(API.getItemAmount(p, Material.IRON_INGOT) >= 1) {
					API.removeItem(p, 1, Material.IRON_INGOT);
					p.getInventory().addItem(new ItemStack(Material.CHEST));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}

			if(e.getCurrentItem().getType() == Material.ENDER_CHEST && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lKiste II")) {
				if(API.getItemAmount(p, Material.GOLD_INGOT) >= 1) {
					API.removeItem(p, 1, Material.GOLD_INGOT);
					p.getInventory().addItem(new ItemStack(Material.ENDER_CHEST));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else {
					p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
				}

			}


		
		if(e.getCurrentItem().getType() == Material.LEATHER_HELMET && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lLederhelm")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 2) {
				API.removeItem(p, 2, Material.CLAY_BRICK);
				if(TeamManager.teamBlau.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.BLUE).toItemStack());
				}else if(TeamManager.teamRot.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.RED).toItemStack());
				}else if(TeamManager.teamGelb.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.YELLOW).toItemStack());
				}else if(TeamManager.teamGruen.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.GREEN).toItemStack());
				}else if(TeamManager.teamLila.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.PURPLE).toItemStack());
				}else if(TeamManager.teamSchwarz.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.BLACK).toItemStack());
				}else if(TeamManager.teamTurkis.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.AQUA).toItemStack());
				}else if(TeamManager.teamOrange.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setLeatherArmorColor(Color.ORANGE).toItemStack());
				}
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lLederhose")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 2) {
				API.removeItem(p, 2, Material.CLAY_BRICK);
				if(TeamManager.teamBlau.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.BLUE).toItemStack());
				}else if(TeamManager.teamRot.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.RED).toItemStack());
				}else if(TeamManager.teamGelb.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.YELLOW).toItemStack());
				}else if(TeamManager.teamGruen.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.GREEN).toItemStack());
				}else if(TeamManager.teamLila.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.PURPLE).toItemStack());
				}else if(TeamManager.teamSchwarz.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.BLACK).toItemStack());
				}else if(TeamManager.teamTurkis.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.AQUA).toItemStack());
				}else if(TeamManager.teamOrange.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.ORANGE).toItemStack());
				}
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.LEATHER_BOOTS && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lLederschuhe")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 2) {
				API.removeItem(p, 2, Material.CLAY_BRICK);
				if(TeamManager.teamBlau.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.BLUE).toItemStack());
				}else if(TeamManager.teamRot.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.RED).toItemStack());
				}else if(TeamManager.teamGelb.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.YELLOW).toItemStack());
				}else if(TeamManager.teamGruen.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.GREEN).toItemStack());
				}else if(TeamManager.teamLila.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.PURPLE).toItemStack());
				}else if(TeamManager.teamSchwarz.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.BLACK).toItemStack());
				}else if(TeamManager.teamTurkis.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.AQUA).toItemStack());
				}else if(TeamManager.teamOrange.contains(p)) {
					p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.ORANGE).toItemStack());
				}
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		

		if(e.getCurrentItem().getType() == Material.GLOWSTONE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lGlowstone")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 8) {
				API.removeItem(p, 5, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemStack(Material.GLOWSTONE));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.ENDER_STONE && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lEndstein")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 4) {
				API.removeItem(p, 4, Material.CLAY_BRICK);
				p.getInventory().addItem(new ItemStack(Material.ENDER_STONE));
				p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		if(e.getCurrentItem().getType() == Material.STAINED_GLASS && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lGlass")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 8) {
				if(TeamManager.teamBlau.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)11));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamRot.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)14));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamGruen.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)13));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamGelb.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)4));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamLila.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)10));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamSchwarz.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)15));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamOrange.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)1));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamTurkis.contains(p)) {
					API.removeItem(p, 8, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_GLASS, 1, (short)3));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}

		if(e.getInventory().getTitle().contains("Teleporter")) {
			String name =  e.getCurrentItem().getItemMeta().getDisplayName();
			p.closeInventory();
			p.teleport(Bukkit.getPlayer(name).getLocation());
			p.sendMessage(Main.prefix + "§7Du wurdest zu §6§l" + Bukkit.getPlayer(name).getDisplayName() + " §7teleportiert.");
		}

		if(e.getCurrentItem().getType() == Material.STAINED_CLAY && e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §a§lTon")) {
			if(API.getItemAmount(p, Material.CLAY_BRICK) >= 5) {
				if(TeamManager.teamBlau.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)11));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamRot.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)14));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamGruen.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)13));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamGelb.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)4));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamLila.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)10));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamSchwarz.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)15));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamOrange.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)1));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}else if(TeamManager.teamTurkis.contains(p)) {
					API.removeItem(p, 5, Material.CLAY_BRICK);
					p.getInventory().addItem(new ItemStack(Material.STAINED_CLAY, 1, (short)3));
					p.playSound(p.getLocation(), Sound.CLICK, 3, 2);
				}
			}else {
				p.sendMessage(Main.prefix + "§7Du besitzt nicht §a§lgenügend §7Resourcen§8!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 3, 2);
			}
		
		}
		
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		if(Main.gs == GameState.LOBBY) {
			e.setCancelled(true);
		}
		
		if(e.getInventory().getTitle().equals("§8» §2§lShop")) {
			if(e.getRawSlot() < e.getInventory().getSize()) {
				e.setCancelled(true);
			}
			
			
			
			
		}
			
		
		
		
	}
}

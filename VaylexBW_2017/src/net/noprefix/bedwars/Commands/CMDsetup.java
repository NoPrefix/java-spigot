package net.noprefix.bedwars.Commands;

import net.noprefix.bedwars.Manager.GameManager.DropManager;
import net.noprefix.bedwars.Methodes.ItemBuilder;
import net.noprefix.bedwars.Methodes.LocationBuilder;
import org.bukkit.Color;
import org.bukkit.Location;			
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;	
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.MapManager;

public class CMDsetup implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("bw.setup")) {
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("addMap")) {
					String map = args[1];
						MapManager.createMap(map);
						p.sendMessage(Main.prefix + "§7Du hast die Map §a§lerfolgreich §7erstellt§8!");
						MapManager.reloadMapData();
				
				}else if(args[0].equalsIgnoreCase("setspec")){
					String map = args[1];
					LocationBuilder.set(p.getLocation(), "Spectator." + map);
					p.sendMessage(Main.prefix + "§7Du hast die §a§lLobby §7gesetzt§8!");
				}else if(args[0].equals("teleport")){
					String map = args[1];
			        World w = Main.plugin.getServer().createWorld(new WorldCreator(map).environment(World.Environment.NORMAL));
			        w.setTime(3000);
			        w.setGameRuleValue("randomTickSpeed", "false");
			        w.setGameRuleValue("doDaylightCycle", "false");
			        w.setGameRuleValue("doMobSpawning", "false");
			        p.teleport(w.getSpawnLocation());
			        p.sendMessage(Main.prefix + "§2§lTeleport...");
					
					
				}else {
					getInfo(p);
				}
			}else if(args.length == 1) {
				if(args[0].equals("list")) {
					if(MapManager.maps.size() != 0) {
						p.sendMessage(Main.prefix + "§7Momentane Maps ● §a§l" + MapManager.maps.size());
						p.sendMessage(Main.prefix + "");
						for(int i = 0; i < MapManager.maps.size(); i++) {
							p.sendMessage(Main.prefix + "§6" + MapManager.maps.get(i));
						}
						p.sendMessage(Main.prefix + "§7");
					}else {
						p.sendMessage(Main.prefix + "§7Momentan §a§lexistieren §7keine Maps§8!");
					}
				
				}else if(args[0].equals("setlobby")) {
					LocationBuilder.set(p.getLocation(), "Location.Lobby");
					p.sendMessage(Main.prefix + "§7Du hast die §a§lLobby §7gesetzt§8!");
				}else if(args[0].equals("setshop")){
					Location loc = p.getLocation();
			          
			          ArmorStand st = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
			          
			          st.setCustomName("§7» §2§lShop");
			          st.setCustomNameVisible(true);
			          st.setVisible(true);
			          st.setArms(true);
			          st.setBasePlate(false);
			          st.setGravity(false);
			          st.getEquipment().getArmorContents();
			          p.sendMessage(Main.prefix + "§7Du hast den Shop gesetzt!");
			          
			          st.setLeggings(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.YELLOW).toItemStack());
			          st.setBoots(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.ORANGE).toItemStack());
			          st.setChestplate(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.ORANGE).toItemStack());
			          st.setItemInHand(new ItemBuilder(Material.WOOD_PICKAXE).toItemStack());
			          
			          st.setHelmet(new ItemStack(Material.CHEST));
				}else {
					getInfo(p);
				}
			}else if(args.length == 3){
				if(args[0].equalsIgnoreCase("setspawn")) {
					if(args[1].equals("Blau") || args[1].equals("Rot") || args[1].equals("Gruen") || args[1].equals("Gelb") || args[1].equals("Lila") || args[1].equals("Schwarz") || args[1].equals("Orange") || args[1].equals("Turkis")) {
						String  map = args[2];
						String team = args[1];
						LocationBuilder.set(p.getLocation(), "Location." + map + "." + team);
						p.sendMessage(Main.prefix + "§7Du hast den §a§lSpawn §7gesetzt§8!");
					}
				}else if(args[0].equalsIgnoreCase("setspawner")) {
					if(args[1].equals("bronze") || args[1].equals("eisen") || args[1].equals("gold")) {
						DropManager.setSpawn(args[1], p.getLocation(), args[2]);
						p.sendMessage(Main.prefix + "§7Du hast den §a§lSpawn §7gesetzt§8!");
					}
				}else {
					getInfo(p);
				}
			}else {
				getInfo(p);
			}
		}else {
			p.sendMessage(Main.prefix + "§7Dafür hast du §a§lkeine §7Rechte§8!");
		}
		return false;
	
	
	}
	
	public static void getInfo(Player p) {
		p.sendMessage(Main.prefix + "§a§lsetspawn <TEAM> <MAPNAME>");
		p.sendMessage(Main.prefix + "§a§lsetspawner <TYPE> <MAPNAME>");
		p.sendMessage(Main.prefix + "§a§laddMap <MAPNAME>");
		p.sendMessage(Main.prefix + "§a§lsetspec <MAPNAME>");
		p.sendMessage(Main.prefix + "§a§lsetlobby");
		p.sendMessage(Main.prefix + "§a§lsetshop");
		p.sendMessage(Main.prefix + "§a§llist");
	}

}

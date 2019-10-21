package net.noprefix.bedwars.Methodes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.noprefix.bedwars.Countdowns.EndingCountdown;
import net.noprefix.bedwars.Countdowns.InGameCountdown;
import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.GameState;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class API {
	  
	  public static void win() {
		  if(Main.ss == SizeState.SIZE8x1 || Main.ss == SizeState.SIZE2x1) {
			  if(Main.ONLINE_Players.size() == 1) {
				  Main.gs = GameState.ENDING;
				  InGameCountdown.stop();
				  EndingCountdown.start();
			  } 
		  }
	  }
	  
		public static HashMap<Player, Integer> kills = new HashMap<>();
		public static HashMap<Player, Integer> punkte = new HashMap<>();
		public static HashMap<Player, Integer> tode = new HashMap<>();
		public static HashMap<Player, Integer> beds = new HashMap<>();
		
		public static void create(Player p) {
			if(!kills.containsKey(p)) {
				kills.put(p, 0);
				punkte.put(p, 0);
				tode.put(p, 0);
				beds.put(p, 0);
			}
		}
		
	  public static void Respawn(Player player, int Time)
	  {
	    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
	      }
	    }, Time);
	  }
	  
	  public static void sendActionBar(Player player, String Nachricht)
	  {
	    String NachrichtNeu = Nachricht.replace("_", " ");
	    String s = ChatColor.translateAlternateColorCodes('&', NachrichtNeu);
	    IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + s + 
	      "\"}");
	    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
	  }
	  
		public static String getRankName(UUID uuid) {
			return CloudServer.getInstance().getCachedPlayer(uuid).getPermissionEntity().getHighestPermissionGroup(CloudAPI.getInstance().getPermissionPool()).getName();	
		}
		
		public static String getRank(Player p) {
			if(getRankName(p.getUniqueId()).equals("Owner")) {
				return "§4§lOwner §8× §4" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Admin")) {
				return "§4§lAdmin §8× §4" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("SrModerator")) {
				return "§c§lSrModerator §8× §c" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("SrBuilder")) {
				return "§2§lSrBuild §8× §2" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("SrDeveloper")) {
				return "§b§lSrDeveloper §8× §b" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Moderator")) {
				return "§c§lModerat§c§lor §8× §c" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Builder")) {
				return "§2§lBuild §8× §2" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Developer")) {
				return "§b§lDeveloper §8× §b" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Supporter")) {
				return "§9§lSupporter §8× §9" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Youtuber")) {
				return "§5§lYoutuber §8× §5" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("JrYoutuber")) {
				return "§5§lJrYoutuber §8× §5" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("Prime")) {
				return "§6§lPrime §8× §6" + p.getName();
			}else if(getRankName(p.getUniqueId()).equals("VIP")) {
				return "§e§lVIP §8× §e" + p.getName();
			}else {
				return "§e" + p.getName();
			}
		}
		
		public static void loadItems(Player p) {
			Inventory Inv = Bukkit.createInventory(null, 9*2, "§8» §2§lShop");
			Inv.setItem(0, new ItemBuilder(Material.SANDSTONE).setName("§8» §aBlöcke").toItemStack());
			Inv.setItem(1, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§8» §aRüstung").toItemStack());
			Inv.setItem(2, new ItemBuilder(Material.IRON_PICKAXE).setName("§8» §aSpitzhacken").toItemStack());
			Inv.setItem(3, new ItemBuilder(Material.WOOD_SWORD).setName("§8» §aWaffen").toItemStack());
			Inv.setItem(4, new ItemBuilder(Material.BOW).setName("§8» §aBögen").toItemStack());
			Inv.setItem(5, new ItemBuilder(Material.CAKE).setName("§8» §aEssen").toItemStack());
			Inv.setItem(6, new ItemBuilder(Material.ENDER_CHEST).setName("§8» §aKisten").toItemStack());
			Inv.setItem(7, new ItemBuilder(Material.GLASS_BOTTLE).setName("§8» §aTränke").toItemStack());
			Inv.setItem(8, new ItemBuilder(Material.EMERALD).setName("§8» §aExtras").toItemStack());
			p.openInventory(Inv);
			
		}
		
		
	    public static int getItemAmount(Player player, Material m) {
	        int size = 0;
	        for(ItemStack itemStack : player.getInventory().getContents()) {
	            if(itemStack != null && itemStack.getType() != Material.AIR) {
	                if(itemStack.getType() == m) {
	                    size += itemStack.getAmount();
	                }
	            }
	        }
	        return size;
	      }
	    
	    public static boolean removeItem(Player player, int count, Material mat) {
	        Map<Integer, ? extends ItemStack> ammo = player.getInventory().all(mat);

	        int found = 0;
	        for (ItemStack stack : ammo.values())
	            found += stack.getAmount();
	        if (count > found)
	            return false;

	        for (Integer index : ammo.keySet()) {
	            ItemStack stack = ammo.get(index);

	            int removed = Math.min(count, stack.getAmount());
	            count -= removed;

	            if (stack.getAmount() == removed)
	                player.getInventory().setItem(index, null);
	            else
	                stack.setAmount(stack.getAmount() - removed);

	            if (count <= 0)
	                break;
	        }

	        player.updateInventory();
	        return true;
	    }
	  
	  
}

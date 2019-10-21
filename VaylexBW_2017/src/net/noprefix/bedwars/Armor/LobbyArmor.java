package net.noprefix.bedwars.Armor;

import org.bukkit.entity.ArmorStand;

public class LobbyArmor {
	
	public ArmorStand as;
	public Boolean set = false;
	
	public void set() {
		set = true;
		/*Location loc = new Location(Bukkit.getWorld("world"), 32.5, 8, 6.5, 133, 3);
		as = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND); 
		as.setCustomName("§8✖ §6§lMapvoting §7(Rechtsklick) §8✖");
		as.setCustomNameVisible(true);
		as.setVisible(true);
		as.setArms(true);
		as.setBasePlate(false);
		as.setGravity(false);
		
		as.getEquipment().getArmorContents();
        
		as.setChestplate(new ItemBuilder(Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.ORANGE).toItemStack());
		as.setLeggings(new ItemBuilder(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.YELLOW).toItemStack());
		as.setBoots(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.ORANGE).toItemStack());
		as.setItemInHand(new ItemBuilder(Material.BED).toItemStack());
        
		as.setHelmet(new ItemBuilder(Material.SKULL_ITEM, 1,(byte) 3).setSkullOwner("Villager").toItemStack());
 */
	}
	
	public void remove() {
		as.remove(); 
	}

}

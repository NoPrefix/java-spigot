package net.noprefix.bedwars.Manager.MapVoting;

	import net.noprefix.bedwars.Methodes.ItemBuilder;
    import org.bukkit.Bukkit;
	import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
	import org.bukkit.entity.EntityType;
import net.noprefix.bedwars.Manager.GameManager.MapManager;

public class ArmorMap {

	
	public ArmorStand as;
	public ArmorStand as1;
	public ArmorStand as2;
	public Boolean set = false;
	
	public void set() {
		set = true;
		Location loc = new Location(Bukkit.getWorld("world"), 31.5, 6.5, 5.5, 133, 3);
		as = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND); 
		as.setCustomName("§8● §e" + MapManager.map);
		as.setCustomNameVisible(true);
		as.setVisible(false);
		as.setArms(false);
		as.setBasePlate(false);
		as.setGravity(false);	
		
		as.getEquipment().getArmorContents();
		as.setHelmet(new ItemBuilder(Material.SKULL_ITEM, 1,(byte) 3).setSkullOwner("Stone").toItemStack());
		
		Location loc1 = new Location(Bukkit.getWorld("world"), 33.5, 6.5, 5.5, 133, 3);
		as1 = (ArmorStand)loc1.getWorld().spawnEntity(loc1, EntityType.ARMOR_STAND); 
		as1.setCustomName("§8● §e???");
		as1.setCustomNameVisible(true);
		as1.setVisible(false);
		as1.setArms(false);
		as1.setBasePlate(false);
		as1.setGravity(false);	
		
		as1.getEquipment().getArmorContents();
		as1.setHelmet(new ItemBuilder(Material.SKULL_ITEM, 1,(byte) 3).setSkullOwner("Stone").toItemStack());
		
		Location loc2 = new Location(Bukkit.getWorld("world"), 31.5, 6.5, 7.5, 133, 3);
		as2 = (ArmorStand)loc2.getWorld().spawnEntity(loc2, EntityType.ARMOR_STAND); 
		as2.setCustomName("§8● §e???");
		as2.setCustomNameVisible(true);
		as2.setVisible(false);
		as2.setArms(false);
		as2.setBasePlate(false);
		as2.setGravity(false);	
		
		as2.getEquipment().getArmorContents();
		
		as2.setHelmet(new ItemBuilder(Material.SKULL_ITEM, 1,(byte) 3).setSkullOwner("Stone").toItemStack());
        
		
	}
	
	public void remove() {
		as.remove();
		as1.remove();
		as2.remove();
	}
}

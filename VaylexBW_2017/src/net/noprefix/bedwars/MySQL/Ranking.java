package net.noprefix.bedwars.MySQL;

import java.sql.ResultSet;	
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.noprefix.bedwars.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;

public class Ranking {
	
	public HashMap<Integer, String> rang = new HashMap<>();
	
	public void set() {
		
		ResultSet rs = Main.plugin.getSQL().getResult("SELECT UUID FROM Bedwars ORDER BY POINTS DESC LIMIT 5");
		
		int in = 0;
		try{
			while (rs.next()) {
				in++;
				rang.put(in, rs.getString("UUID"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Location loc = new Location(Bukkit.getWorld("world"), 36, 9, -4);
		Location loc1 = new Location(Bukkit.getWorld("world"), 36, 9, -3);
		Location loc2 = new Location(Bukkit.getWorld("world"), 36, 9, -2);
		Location loc3 = new Location(Bukkit.getWorld("world"), 36, 9, -1);
		Location loc4 = new Location(Bukkit.getWorld("world"), 36, 9, -0);
		
		List<Location> LOC = new ArrayList<Location>();
		LOC.add(loc);
		LOC.add(loc1);
		LOC.add(loc2);
		LOC.add(loc3);
		LOC.add(loc4);

		
		for(int i = 0; i < LOC.size(); i++) {
			int id = i+1;
			LOC.get(i).getBlock().setType(Material.SKULL);
			Skull s = (Skull) LOC.get(i).getBlock().getState();
			s.setSkullType(SkullType.PLAYER);
			String name = Main.plugin.getSQL().getNameByUUID(rang.get(id));
			s.setRotation(BlockFace.WEST);
			s.setOwner(name);
			s.update();
			
			Location newloc = new Location(Bukkit.getWorld("world"), LOC.get(i).getX(), LOC.get(i).getY()-1, LOC.get(i).getZ());
			
			if(newloc.getBlock().getState() instanceof Sign) {
				BlockState b = newloc.getBlock().getState();
				Sign S = (Sign) b;
				
				S.setLine(0, "Platz #" + id);
				S.setLine(1, name);
				S.setLine(2, "");
				S.setLine(3, Main.plugin.getSQL().getPoints(rang.get(id)) + " Points");
				S.update();
			}
			
		}
	}

}

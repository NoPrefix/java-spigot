package net.noprefix.bedwars.Scoreboards;

import java.util.HashMap;

import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import net.noprefix.bedwars.Manager.GameManager.TeamManager;
import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.VotingManager;

public class InGameScoreboard {
	
	public static HashMap<Player, Scoreboard> scors = new HashMap<>();
	  
	  public static void setScoreboard(Player p){
		  Scoreboard sb;
	      if (scors.containsKey(p)) {
	          sb = scors.get(p);
	          p.setScoreboard(sb);
	      } else {
	          sb = Bukkit.getScoreboardManager().getNewScoreboard();
	          p.setScoreboard(sb);
	          scors.put(p, sb);
	      }
	    createTeam(sb, "001Blau");
	    createTeam(sb, "002Rot");
	    createTeam(sb, "003Gelb");
	    createTeam(sb, "004Gruen");
	    
	    createTeam(sb, "005Turkis");
	    createTeam(sb, "006Schwarz");
	    createTeam(sb, "007Orange");
	    createTeam(sb, "008Lila");
	    
	    createTeam(sb, "009Spec");

	    
	    sb.getTeam("001Blau").setPrefix("§9Blau §8▶ §9");
	    sb.getTeam("002Rot").setPrefix("§cRot §8▶ §c");
	    sb.getTeam("003Gelb").setPrefix("§eGelb §8▶ §e");
	    sb.getTeam("004Gruen").setPrefix("§2Grün §8▶ §2");
	    
	    sb.getTeam("005Turkis").setPrefix("§bTurkis §8▶ §b");
	    sb.getTeam("006Schwarz").setPrefix("§0Schwarz §8▶ §0");
	    sb.getTeam("007Orange").setPrefix("§6Orange §8▶ §6");
	    sb.getTeam("008Lila").setPrefix("§5Lila §8▶ §5");
	    
	    sb.getTeam("009Spec").setPrefix("§7Spec §8▶ §7");

	    
	    Objective o = sb.getObjective("test");
	    if (o == null)
	    {
	      o = sb.registerNewObjective("test", "dummy");
	      o.setDisplaySlot(DisplaySlot.SIDEBAR);
	    }
	    o.setDisplayName("§8➜ §6§lVaylex §8┃ §7BW-" + SizeManager.getSize());
	    
	    if(!Main.SPEC_PLAYERS.contains(p)) {
	    
	    	setScore(sb, o, Integer.valueOf(13), "§7 ");
	    	setScore(sb, o, Integer.valueOf(12), "§7Dein Team:");
	    	setScore(sb, o, Integer.valueOf(11), "§8» " + TeamManager.getTeam(p));
	    	
	    }
	    
	    
	    setScore(sb, o, Integer.valueOf(10), "§8§l ");
	    setScore(sb, o, Integer.valueOf(9), "§7Teams:");
	    
	    if(Main.ss == SizeState.SIZE8x1) {
	    
	    if(TeamManager.bedBlau == true) {
	    	setScore(sb, o, Integer.valueOf(8), " §8× §a✔ §9Blau §8┃ §f" + TeamManager.teamBlau.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(8), " §8× §4✘ §9§mBl§9§mau");
	    }
	    
	    if(TeamManager.bedRot == true) {
	    	setScore(sb, o, Integer.valueOf(7), " §8× §a✔ §cRot §8┃ §f" + TeamManager.teamRot.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(7), " §8× §4✘ §c§mRo§c§mt");
	    }
	    
	    if(TeamManager.bedGelb == true) {
	    	setScore(sb, o, Integer.valueOf(6), " §8× §a✔ §eGelb §8┃ §f" + TeamManager.teamGelb.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(6), " §8× §4✘ §e§mGe§e§mlb");
	    }
	    
	    if(TeamManager.bedGruen == true) {
	    	setScore(sb, o, Integer.valueOf(5), " §8× §a✔ §2Grün §8┃ §f" + TeamManager.teamGruen.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(5), " §8× §4✘ §2§mGr§2§mün");
	    }
	    
	    if(TeamManager.bedLila == true) {
	    	setScore(sb, o, Integer.valueOf(4), " §8× §a✔ §5Lila §8┃ §f" + TeamManager.teamLila.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(4), " §8× §4✘ §5§mLi§5§mla");
	    }
	    
	    if(TeamManager.bedOrange == true) {
	    	setScore(sb, o, Integer.valueOf(3), " §8× §a✔ §6Oran§6ge §8┃ §f" + TeamManager.teamOrange.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(3), " §8× §4✘ §6§mOr§6§mange");
	    }
	    
	    if(TeamManager.bedSchwarz == true) {
	    	setScore(sb, o, Integer.valueOf(2), " §8× §a✔ §0Schw§0arz §8┃ §f" + TeamManager.teamSchwarz.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(2), " §8× §4✘ §0§mSc§0§mhwarz");
	    }
	    
	    if(TeamManager.bedTurkis == true) {
	    	setScore(sb, o, Integer.valueOf(1), " §8× §a✔ §bTurk§bis §8┃ §f" + TeamManager.teamBlau.size());
	    }else {
	    	setScore(sb, o, Integer.valueOf(1), " §8× §4✘ §b§mTu§b§mrkis");
	    }
	    
	  }else if(Main.ss == SizeState.SIZE2x1) {
		  if(TeamManager.bedBlau == true) {
		    	setScore(sb, o, Integer.valueOf(8), " §8× §a✔ §9Blau §8┃ §f" + TeamManager.teamBlau.size());
		    }else {
		    	setScore(sb, o, Integer.valueOf(8), " §8× §4✘ §9§mBl§9§mau");
		    }
		    
		    if(TeamManager.bedRot == true) {
		    	setScore(sb, o, Integer.valueOf(7), " §8× §a✔ §cRot §8┃ §f" + TeamManager.teamRot.size());
		    }else {
		    	setScore(sb, o, Integer.valueOf(7), " §8× §4✘ §c§mRo§c§mt");
		    }
		    
		    setScore(sb, o, Integer.valueOf(6), "§8§l§f");
		    if(VotingManager.golding == true) {
		    	setScore(sb, o, Integer.valueOf(5), "§8➜ §7Gold: §a✔");
		    }else {
		    	setScore(sb, o, Integer.valueOf(5), "§8➜ §7Gold: §c✘");
		    }
		    if(VotingManager.golding == true) {
		    	setScore(sb, o, Integer.valueOf(4), "§8➜ §7Drop: §a✔");
		    }else {
		    	setScore(sb, o, Integer.valueOf(4), "§8➜ §7Drop: §c✘");
		    }
		    
	  }
	    
	    setScore(sb, o, Integer.valueOf(0), "§7§l ");
	    
	    String team = " ";
	    
	    	for(Player all : Bukkit.getOnlinePlayers()) {
	    		if(TeamManager.teamBlau.contains(all)) {
	    		     team = "001Blau";
	    		}else if(TeamManager.teamRot.contains(all)) {
	    			    team = "002Rot";
	    		}else if(TeamManager.teamGelb.contains(all)) {
	    			    team = "003Gelb";
	    		}else if(TeamManager.teamGruen.contains(all)) {
	    			    team = "004Gruen";
	    		}else if(TeamManager.teamLila.contains(all)) {
	    			    team = "008Lila";
	    		}else if(TeamManager.teamSchwarz.contains(all)) {
	    			    team = "006Schwarz";
	    		}else if(TeamManager.teamTurkis.contains(all)) {
	    			    team = "005Turkis";
	    		}else if(TeamManager.teamOrange.contains(all)) {
	    			    team = "007Orange";
	    		}else {
	    			    team = "009Spec";
	    		}
	    	
	      Team t = sb.getTeam(team);
	      if (t == null) {
	        t = sb.registerNewTeam(team);
	      }
	      t.addEntry(all.getName());
	      
	      all.setDisplayName(t.getPrefix() + all.getName());
	    }
	  }
	  
	  static void createTeam(Scoreboard sb, String team)
	  {
	    Team t = sb.getTeam(team);
	    if (t == null) {
	      t = sb.registerNewTeam(team);
	    }
	  }
	  
	  private static void setScore(Scoreboard score, Objective objective, Integer number, String text){
		  Team team = score.getTeam(number + "");
	      if (team == null) {
	          team = score.registerNewTeam(number + "");
	          team.addEntry(ChatColor.values()[number].toString());
	          objective.getScore(ChatColor.values()[number].toString()).setScore(number);
	      }

	      if (text.length() > 14) {
	          String farbcode = "";
	          int index = 0;
	          while (index < text.length()) {
	              if (text.toCharArray()[index] == '§') {
	                  farbcode = String.valueOf("§" + text.toCharArray()[index + 1]);
	              }
	              index = index + 1;
	          }
	          team.setPrefix(text.substring(0, 15));
	          team.setSuffix(farbcode + text.substring(15, text.length()));
	      } else {
	          team.setPrefix(text);
	          team.setSuffix("");
	      }
	  }
	  

	  
	}



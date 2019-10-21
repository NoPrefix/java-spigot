package net.noprefix.bedwars.Scoreboards;

import java.util.HashMap;			

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.Manager.GameManager.MapManager;
import net.noprefix.bedwars.Manager.GameManager.SizeManager;
import net.noprefix.bedwars.Methodes.API;
import de.dytanic.cloudnet.api.CloudAPI;

public class LobbyScoreboard {
    public HashMap<Player, Scoreboard> scors = new HashMap<>();

	public  void setScoreboard(Player p){
        Scoreboard sb;
        if (scors.containsKey(p)) {
            sb = scors.get(p);
            p.setScoreboard(sb);
        } else {
            sb = Bukkit.getScoreboardManager().getNewScoreboard();
            p.setScoreboard(sb);
            scors.put(p, sb);
        }

        createTeam(sb, "00001Admin");
        createTeam(sb, "00002SrModerator");
        createTeam(sb, "00003SrDeveloper");
        createTeam(sb, "00004SrBuilder");
        createTeam(sb, "00005Moderator");
        createTeam(sb, "00006Developer");
        createTeam(sb, "00007Builder");
        createTeam(sb, "00008Supporter");
        createTeam(sb, "00009Youtuber");
        createTeam(sb, "00010JrYoutuber");
        createTeam(sb, "00011Premium");
        createTeam(sb, "00012Spieler");

        sb.getTeam("00001Admin").setPrefix("§4Admin §8» §7");
        sb.getTeam("00002SrModerator").setPrefix("§cSrMod§8 » §7");
        sb.getTeam("00003SrDeveloper").setPrefix("§bSrDev§8 » §7");
        sb.getTeam("00005Moderator").setPrefix("§cMod§8 » §7");
        sb.getTeam("00006Developer").setPrefix("§bDev§8 » §7");
        sb.getTeam("00007Builder").setPrefix("§2Build§8 » §7");
        sb.getTeam("00008Supporter").setPrefix("§eSup§8 » §7");
        sb.getTeam("00009Youtuber").setPrefix("§5YT§8 » §7");
        sb.getTeam("00010JrYoutuber").setPrefix("§5JrYT§8 » §7");
        sb.getTeam("00011Premium").setPrefix("§6");
        sb.getTeam("00012Spieler").setPrefix("§7");

       
        
        Objective o = sb.getObjective("test");
        if (o == null)
        {
            o = sb.registerNewObjective("test", "dummy");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
        o.setDisplayName("§8➜ §6§lVaylex.DE §8┃ §7" + SizeManager.getSize());

        setScore(sb, o, Integer.valueOf(15), "§7§8§l");
        
        setScore(sb, o, Integer.valueOf(14), "§8➜ §7Server");
        setScore(sb, o, Integer.valueOf(13), "   §e" + CloudAPI.getInstance().getServerId());

        setScore(sb, o, Integer.valueOf(12), "§8§l ");
        
        setScore(sb, o, Integer.valueOf(11), "§8➜ §7Bytes");
        setScore(sb, o, Integer.valueOf(10), "   §e" + Main.plugin.getData().getBytes(p.getUniqueId().toString()));

        setScore(sb, o, Integer.valueOf(9), "§8§l§7");
        
        setScore(sb, o, Integer.valueOf(8), "§8➜ §7Spieler");
        setScore(sb, o, Integer.valueOf(7), "   §f" + Main.ONLINE_Players.size() +" §8/ §e"  + SizeManager.getMaxPlayers());
 
        setScore(sb, o, Integer.valueOf(6), "§8§l§7");
        
        setScore(sb, o, Integer.valueOf(5), "§8➜ §7Karte");
        setScore(sb, o, Integer.valueOf(4), "   §6§l" + MapManager.map);

        setScore(sb, o, Integer.valueOf(3), "");
        
        setScore(sb, o, Integer.valueOf(2), "§8➜ §7Ranking   ");
        setScore(sb, o, Integer.valueOf(1), "   §e#" + Main.plugin.getSQL().getRank(p.getUniqueId().toString()));

        setScore(sb, o, Integer.valueOf(0), "");

        String team = "";
        for (Player all : Bukkit.getOnlinePlayers()){
        	if(Main.plugin.getNickManager().getNick(all.getUniqueId().toString()) == true) {
        		team = "00012Spieler";
        	}else if(API.getRankName(all.getUniqueId()).equals("Admin")) {
                    team = "00001Admin";
                }else if(API.getRankName(all.getUniqueId()).equals("SrModerator")) {
                    team = "00002SrModerator";
                }else if(API.getRankName(all.getUniqueId()).equals("SrBuilder")) {
                    team = "00003SrDeveloper";
                }else if(API.getRankName(all.getUniqueId()).equals("SrDeveloper")) {
                    team = "00004SrBuilder";
                }else if(API.getRankName(all.getUniqueId()).equals("Moderator")) {
                    team = "00005Moderator";
                }else if(API.getRankName(all.getUniqueId()).equals("Builder")) {
                    team = "00007Builder";
                }else if(API.getRankName(all.getUniqueId()).equals("Developer")) {
                    team = "00006Developer";
                }else if(API.getRankName(all.getUniqueId()).equals("Supporter")) {
                    team = "00008Supporter";
                }else if(API.getRankName(all.getUniqueId()).equals("Youtuber")) {
                    team = "00009Youtuber";
                }else if(API.getRankName(all.getUniqueId()).equals("JrYoutuber")) {
                    team = "00010JrYoutuber";
                }else if(API.getRankName(all.getUniqueId()).equals("Premium"))  {
                    team = "00011Premium";
                }else {
                    team = "00012Spieler";
                }
        
        
            Team t = sb.getTeam(team);
        	if (t == null) {
        		t = sb.registerNewTeam(team);
        	}
        	

        		t.addEntry(all.getName());
        		all.setDisplayName(t.getPrefix() + all.getName());
        	
        }

        p.setScoreboard(sb);
    }

    public void createTeam(Scoreboard sb, String team)
    {
        Team t = sb.getTeam(team);
        if (t == null) {
            t = sb.registerNewTeam(team);
        }
    }

    private  void setScore(Scoreboard score, Objective objective, Integer number, String text){
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

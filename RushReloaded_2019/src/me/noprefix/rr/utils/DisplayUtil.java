package me.noprefix.rr.utils;

import me.noprefix.rr.RushReloaded;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.NumberFormat;
import java.util.HashMap;

public class DisplayUtil {

    private HashMap<Player, Scoreboard> scors = new HashMap<>();

    public void setTab(Player p) {

        Scoreboard sb;
        if (scors.containsKey(p)) {
            sb = scors.get(p);
            p.setScoreboard(sb);
        } else {
            sb = Bukkit.getScoreboardManager().getNewScoreboard();
            p.setScoreboard(sb);
            scors.put(p, sb);
        }

        createTeam(sb, "1Blau");
        createTeam(sb, "2Rot");
        createTeam(sb, "3Gelb");
        createTeam(sb, "4Gruen");
        createTeam(sb, "5Weiss");
        createTeam(sb, "6Orange");
        createTeam(sb, "7Tuerkis");
        createTeam(sb, "8Lila");

        sb.getTeam("1Blau").setPrefix("§9Blau | ");
        sb.getTeam("2Rot").setPrefix("§cRot | ");
        sb.getTeam("3Gelb").setPrefix("§eGelb | §7");
        sb.getTeam("4Gruen").setPrefix("§aGrün | §7");
        sb.getTeam("5Weiss").setPrefix("§fWeiß | ");
        sb.getTeam("6Orange").setPrefix("§6Orange | ");
        sb.getTeam("7Tuerkis").setPrefix("§bTürkis | ");
        sb.getTeam("8Lila").setPrefix("§5Lila | ");

        String team = "";
        for (Player all : Bukkit.getOnlinePlayers()) {

            if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§9")) {
                team = "1Blau";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§c")) {
                team = "2Rot";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§e")) {
                team = "3Gelb";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§a")) {
                team = "4Gruen";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§f")) {
                team = "5Weiss";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§6")) {
                team = "6Orange";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§b")) {
                team = "7Tuerkis";
            } else if(RushReloaded.getPlugin().teamMap.get(all).getColor().equals("§5")) {
                team = "8Lila";
            }

            org.bukkit.scoreboard.Team t = sb.getTeam(team);
            if (t == null) {
                t = sb.registerNewTeam(team);
            }

            t.addEntry(all.getName());

        }

        p.setScoreboard(sb);

    }

    public void setScoreboard(Player p) {
        Scoreboard sb;
        if (scors.containsKey(p)) {
            sb = scors.get(p);
            p.setScoreboard(sb);
        } else {
            sb = Bukkit.getScoreboardManager().getNewScoreboard();
            p.setScoreboard(sb);
            scors.put(p, sb);
        }

        Objective o = sb.getObjective("test");
        if (o == null) {
            o = sb.registerNewObjective("test", "dummy");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        NumberFormat money = NumberFormat.getInstance();
        money.setGroupingUsed(true);

        o.setDisplayName("   §6Rush-" + RushReloaded.getPlugin().SIZE.toString().replace("SIZE_", "") + "   ");

        int counter = 1;
        for(me.noprefix.rr.utils.Team team : RushReloaded.getPlugin().teams) {
            setScore(sb, o, counter, (team.isBed() + " " + team.getColor() + team.getName() + ": " + team.getCurrentPlayers())
                    .replace("true","§a✔").replace("false", "§c✗"));
            counter++;
        }
        setScore(sb, o, counter, "§7§m§a");
        setScore(sb, o, 0, "§7§m");

        p.setScoreboard(sb);

    }

    private void createTeam(Scoreboard sb, String team) {
        org.bukkit.scoreboard.Team t = sb.getTeam(team);
        if (t == null) {
            t = sb.registerNewTeam(team);
        }
    }

    private void setScore(Scoreboard score, Objective objective, Integer number, String text) {
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

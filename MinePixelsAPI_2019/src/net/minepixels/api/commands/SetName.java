package net.minepixels.api.commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minepixels.api.main.MinePixelsAPI;
import net.minepixels.api.methods.SkinAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SetName implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission("mp.setname")) {
                if (strings.length == 1) {
                    if(strings[0].length() <= 16) {
                        MinePixelsAPI.getInstance().getNickAPI().setNick(p, strings[0]);
                        String name = MinePixelsAPI.getInstance().getNickAPI().getNickName(p);
                        GameProfile gp = ((CraftPlayer)p).getProfile();
                        gp.getProperties().clear();
                        SkinAPI skin = new SkinAPI(getUUID(name));

                        if(skin.getSkinName() != null){
                            gp.getProperties().put(skin.getSkinName(),new Property(skin.getSkinName(), skin.getSkinValue(),skin.getSkinSignatur()));
                        }

                        p.setDisplayName("§7" + strings[0]);

                        Bukkit.getScheduler().runTaskLater(MinePixelsAPI.getInstance(), new Runnable() {

                            @Override
                            public void run() {
                                for(Player pl : Bukkit.getOnlinePlayers()){
                                    pl.hidePlayer(p);
                                }
                            }
                        }, 1);

                        Bukkit.getScheduler().runTaskLater(MinePixelsAPI.getInstance(), new Runnable() {

                            @Override
                            public void run() {
                                for(Player pl : Bukkit.getOnlinePlayers()){
                                    MinePixelsAPI.getInstance().getDisplayManager().setTab(pl);
                                    pl.showPlayer(p);
                                }
                            }
                        }, 20);
                        p.sendMessage("§aDu bist nun " + strings[0]);
                    } else
                        p.sendMessage("§cDein Nickname darf maximal 16 Zeichen lang sein!");
                } else
                    p.sendMessage("§cBitte verwende /setname <Name>");
            } else
                p.sendMessage("§cI'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
        } else
            commandSender.sendMessage("Du musst ein Spieler sein");
        return false;
    }

    public String getUUID(String name){
        return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replace("-", "");
    }

}

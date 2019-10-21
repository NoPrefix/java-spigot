package me.noprefix.rr.listeners;

import me.noprefix.rr.RushReloaded;
import me.noprefix.rr.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class InventoryClickListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("§aRush-Shop")) {
            if(event.getRawSlot() < event.getInventory().getSize()) {
                event.setCancelled(true);
            }
            Player player = (Player) event.getWhoClicked();
            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aBlöcke")) {
                    if(!event.isShiftClick()) {
                        if(getItemAmount(player, Material.CLAY_BRICK) >= 1) {
                            removeItem(player, 1, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.SANDSTONE).setName("§fSandstein").toItemStack();
                            itemStack.setAmount(4);
                            player.getInventory().addItem(itemStack);
                            player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                        } else {
                            player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu besitzt nicht genug Bronze!");
                        }
                    } else {
                        int value = getItemAmount(player, Material.CLAY_BRICK);
                        if(value <= 64) {
                            removeItem(player, value, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.SANDSTONE).setName("§fSandstein").toItemStack();
                            itemStack.setAmount(4);

                            for(int i = 0; i < value; i++) {
                                player.getInventory().addItem(itemStack);
                                player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                            }

                        } else if(value >= 65) {
                            removeItem(player, 64, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.SANDSTONE).setName("§fSandstein").toItemStack();
                            itemStack.setAmount(4);

                            for(int i = 0; i < 64; i++) {
                                player.getInventory().addItem(itemStack);
                                player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                            }
                        }
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aSpitzhacke")) {
                    if(getItemAmount(player, Material.CLAY_BRICK) >= 4) {
                        removeItem(player, 4, Material.CLAY_BRICK);
                        ItemStack itemStack = new ItemAPI(Material.WOOD_PICKAXE).setName("§fSpitzhacke").toItemStack();
                        player.getInventory().addItem(itemStack);
                        player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                    } else {
                        player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu besitzt nicht genug Bronze!");
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aKnockback Stick")) {
                    if(getItemAmount(player, Material.CLAY_BRICK) >= 8) {
                        removeItem(player, 8, Material.CLAY_BRICK);
                        ItemStack itemStack = new ItemAPI(Material.STICK).setName("§fKnockback-Stick").addEnchant(Enchantment.KNOCKBACK, 2).toItemStack();
                        player.getInventory().addItem(itemStack);
                        player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                    } else {
                        player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu besitzt nicht genug Bronze!");
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aEndstein")) {
                    if(!event.isShiftClick()) {
                        if(getItemAmount(player, Material.CLAY_BRICK) >= 8) {
                            removeItem(player, 8, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.ENDER_STONE).setName("Endstein").toItemStack();
                            player.getInventory().addItem(itemStack);
                            player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                        } else {
                            player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu besitzt nicht genug Bronze!");
                        }
                    } else {
                        int value = getItemAmount(player, Material.CLAY_BRICK)/8;
                        if(value <= 64) {
                            removeItem(player, value*8, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.ENDER_STONE).setName("§fEndstein").toItemStack();

                            for(int i = 0; i < value; i++) {
                                player.getInventory().addItem(itemStack);
                                player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                            }

                        } else if(value >= 65) {
                            removeItem(player, 64, Material.CLAY_BRICK);
                            ItemStack itemStack = new ItemAPI(Material.ENDER_STONE).setName("§fEndstein").toItemStack();

                            for(int i = 0; i < 8; i++) {
                                player.getInventory().addItem(itemStack);
                                player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                            }
                        }
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§aAngel")) {
                    if(getItemAmount(player, Material.CLAY_BRICK) >= 5) {
                        removeItem(player, 5, Material.CLAY_BRICK);
                        ItemStack itemStack = new ItemAPI(Material.FISHING_ROD).setName("§fAngel").toItemStack();
                        player.getInventory().addItem(itemStack);
                        player.playSound(player.getLocation(), Sound.CLICK, 1, 2);
                    } else {
                        player.sendMessage(RushReloaded.getPlugin().PREFIX + "§cDu besitzt nicht genug Bronze!");
                    }
                }
            } catch (Exception ex) {}
        }
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

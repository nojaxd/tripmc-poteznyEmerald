package pl.tripmc.poteznyemeraldplugin.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import pl.tripmc.poteznyemeraldplugin.PoteznyEmeraldPlugin;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getInventory().getItemInHand().getType() == Material.EMERALD) {
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().set("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie", PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") + 1);
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().saveConfig();
            event.getPlayer().getInventory().remove(new ItemStack(Material.EMERALD, 1));
            event.getPlayer().sendMessage("gratulacje wlozyles emerald do dupy");
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 2f, 4f);
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getInventory().getItemInHand().getType() == Material.EMERALD) {
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().set("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie", PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") + 1);
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().saveConfig();
            event.getPlayer().getInventory().remove(new ItemStack(Material.EMERALD, 1));
            event.getPlayer().sendMessage("gratulacje wlozyles emerald do dupy");
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 2f, 4f);
        }
        if(event.getAction() == Action.LEFT_CLICK_AIR && event.getPlayer().getInventory().getItemInHand().getType() == Material.EMERALD) {
            if(PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") < 0) {
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ANVIL_BREAK, 2f, 4f);
                event.getPlayer().sendMessage("nie posaidasz juz zadnych emeraldow w dupie :(");
            }
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().set("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie", PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") - 1);
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().saveConfig();
            event.getPlayer().getInventory().addItem(new ItemStack(Material.EMERALD, 1));
            event.getPlayer().sendMessage("gratulacje wyjoles emerald z dupy");
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 2f, 4f);
        }
        if(event.getAction() == Action.LEFT_CLICK_BLOCK && event.getPlayer().getInventory().getItemInHand().getType() == Material.EMERALD) {
            if(PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") < 0) {
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ANVIL_BREAK, 2f, 4f);
                event.getPlayer().sendMessage("nie posaidasz juz zadnych emeraldow w dupie :(");
            }
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().saveConfig();
            PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().set("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie", PoteznyEmeraldPlugin.getPoteznyEmeraldPlugin().getConfig().getInt("uuids." + event.getPlayer().getUniqueId() + ".emeraldy-w-dupie") - 1);
            event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_YES, 2f, 4f);
            event.getPlayer().getInventory().addItem(new ItemStack(Material.EMERALD, 1));
            event.getPlayer().sendMessage("gratulacje wyjoles emerald z dupy");
        }
    }
}

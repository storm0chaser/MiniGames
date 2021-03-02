package me.storm0chaser.MiniGames.Games.Pirate;

import me.storm0chaser.MiniGames.Games.Manager.Managers;
import me.storm0chaser.MiniGames.Games.Pirate.Events.EventListener;
import me.storm0chaser.MiniGames.Games.Pirate.PirateRunnable.Arrow;
import me.storm0chaser.MiniGames.Main;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

import java.io.IOException;

public class PirateManager {
    public static void Start(){
        GamemodeStart();
    }
    private static void GamemodeStart(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Arrow(), 0L, 20L);
        ItemStack Bow = new ItemStack(Material.DIAMOND_SWORD, 1);
        net.minecraft.server.v1_8_R3.ItemStack stack = CraftItemStack.asNMSCopy(Bow);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("PirateBow", true);
        stack.setTag(tag);
        Bow = CraftItemStack.asCraftMirror(stack);
        ItemMeta meta = Bow.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Spleef Bow");
        Bow.setItemMeta(meta);

        for(Player p : Main.Games.get(Managers.HighestGamemode).getTeam1Players()){
            p.getInventory().clear();
            p.updateInventory();
            p.getInventory().addItem(new ItemStack(Material.BOW));
            p.getInventory().setItem(0, Bow);
        }

        for(Player p : Main.Games.get(Managers.HighestGamemode).getTeam2Players()){
            p.getInventory().clear();
            p.updateInventory();
            p.getInventory().addItem(new ItemStack(Material.BOW));
            p.getInventory().setItem(0, Bow);
        }
    }
    private static void GamemodeStop(){
        try {
            Reset.loadBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

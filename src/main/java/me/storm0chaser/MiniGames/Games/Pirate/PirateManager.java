package me.storm0chaser.MiniGames.Games.Pirate;

import me.storm0chaser.MiniGames.Games.Manager.Managers;
import me.storm0chaser.MiniGames.Games.Pirate.Events.EventListener;
import me.storm0chaser.MiniGames.Games.Pirate.PirateRunnable.Arrow;
import me.storm0chaser.MiniGames.Games.Pirate.PirateRunnable.PirateRunnable;
import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.ScoreBoard.ScoreBoardUpdater;
import me.storm0chaser.MiniGames.Utils.BukkitTask;
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
    private int id;

    public static void Start(){
        GamemodeStart();
    }
    public static void Stop(){
        GamemodeStop();
    }

    private static BukkitTask bt = new PirateRunnable(0L, 20L);

    private static void GamemodeStart(){
        //new PirateRunnable(0L, 20L).run();
        bt.run();


        ItemStack Bow = new ItemStack(Material.BOW, 1);
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
            p.getInventory().addItem(new ItemStack(Material.BOW));
            p.getInventory().setItem(0, Bow);
            p.updateInventory();
        }

        for(Player p : Main.Games.get(Managers.HighestGamemode).getTeam2Players()){
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack(Material.BOW));
            p.getInventory().setItem(0, Bow);
            p.updateInventory();
        }
    }

    private static void GamemodeStop(){
        bt.cancel();
        try {
            Reset.loadBase();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for(Player players : Main.MiniGamesEvent.getPlayersin()){
            players.teleport(Main.SpawnLocation);
            players.getInventory().clear();
            players.updateInventory();
        }

    }
}

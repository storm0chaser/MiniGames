package me.storm0chaser.MiniGames.Guis;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class LeaderBoardGui implements InventoryHolder {
    private Inventory Inv;

    public LeaderBoardGui(Player p){
        //YES I"M A RETARD DON"T LOOK AT THIS CLASS

        Map.Entry<Player, Integer> a;
        Map.Entry<Player, Integer> a1;
        Map.Entry<Player, Integer> a2;
        Map.Entry<Player, Integer> a3;
        Map.Entry<Player, Integer> a4;
        Map.Entry<Player, Integer> a5;
        Map.Entry<Player, Integer> a6;
        Map.Entry<Player, Integer> a7;
        Map.Entry<Player, Integer> a8;
        Map.Entry<Player, Integer> a9;


        Inv =  Bukkit.createInventory(this, 54, "Leaderboard");
        ItemStack black = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemStack blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);

        Iterator<Map.Entry<Player, Integer>> iterator = Main.PlayerScores.entrySet().iterator();
        int count = Main.PlayerScores.size();


        if(count >= 1){
            a = iterator.next();
            ItemStack b = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
            SkullMeta c = (SkullMeta) b.getItemMeta();
            c.setOwner(a.getKey().getName());
            c.setDisplayName(ChatColor.GOLD + a.getKey().getName());
            ArrayList<String> d = new ArrayList<>();
            d.add(ChatColor.GRAY+"Score: "+ a.getValue());
            c.setLore(d);
            b.setItemMeta(c);

            Inv.setItem(13, b);
        }else{Inv.setItem(13, blue);}

        if(count >= 2) {
            a1 = iterator.next();
            ItemStack b1 = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
            SkullMeta c1 = (SkullMeta) b1.getItemMeta();
            c1.setOwner(a1.getKey().getName());
            c1.setDisplayName(ChatColor.GOLD + a1.getKey().getName());
            ArrayList<String> d1 = new ArrayList<>();
            d1.add(ChatColor.GRAY + "Score: " + a1.getValue());
            c1.setLore(d1);
            b1.setItemMeta(c1);

            Inv.setItem(21, b1);
        }else{Inv.setItem(21, blue);}


        if(count >= 3) {
            a2 = iterator.next();
            ItemStack b2 = new ItemStack(Material.SKULL_ITEM, 2, (short) SkullType.PLAYER.ordinal());
            SkullMeta c2 = (SkullMeta) b2.getItemMeta();
            c2.setOwner(a2.getKey().getName());
            c2.setDisplayName(ChatColor.GOLD + a2.getKey().getName());
            ArrayList<String> d2 = new ArrayList<>();
            d2.add(ChatColor.GRAY + "Score: " + a2.getValue());
            c2.setLore(d2);
            b2.setItemMeta(c2);

            Inv.setItem(23, b2);
        }else{Inv.setItem(23, blue);}

        if(count >= 4) {
            a3 = iterator.next();
            ItemStack b3 = new ItemStack(Material.SKULL_ITEM, 3, (short) SkullType.PLAYER.ordinal());
            SkullMeta c3 = (SkullMeta) b3.getItemMeta();
            c3.setOwner(a3.getKey().getName());
            c3.setDisplayName(ChatColor.GOLD + a3.getKey().getName());
            ArrayList<String> d3 = new ArrayList<>();
            d3.add(ChatColor.GRAY + "Score: " + a3.getValue());
            c3.setLore(d3);
            b3.setItemMeta(c3);

            Inv.setItem(29, b3);
        }else{Inv.setItem(29, blue);}


        if(count >= 5) {
            a4 = iterator.next();
            ItemStack b4 = new ItemStack(Material.SKULL_ITEM, 4, (short) SkullType.PLAYER.ordinal());
            SkullMeta c4 = (SkullMeta) b4.getItemMeta();
            c4.setOwner(a4.getKey().getName());
            c4.setDisplayName(ChatColor.GOLD + a4.getKey().getName());
            ArrayList<String> d4 = new ArrayList<>();
            d4.add(ChatColor.GRAY + "Score: " + a4.getValue());
            c4.setLore(d4);
            b4.setItemMeta(c4);

            Inv.setItem(31, b4);
        }else{Inv.setItem(31, blue);}


        if(count >=6) {
            a5 = iterator.next();
            ItemStack b5 = new ItemStack(Material.SKULL_ITEM, 5, (short) SkullType.PLAYER.ordinal());
            SkullMeta c5 = (SkullMeta) b5.getItemMeta();
            c5.setOwner(a5.getKey().getName());
            c5.setDisplayName(ChatColor.GOLD + a5.getKey().getName());
            ArrayList<String> d5 = new ArrayList<>();
            d5.add(ChatColor.GRAY + "Score: " + a5.getValue());
            c5.setLore(d5);
            b5.setItemMeta(c5);

            Inv.setItem(33, b5);
        }else{Inv.setItem(33, blue);}

        if(count >= 7) {
            a6 = iterator.next();
            ItemStack b6 = new ItemStack(Material.SKULL_ITEM, 6, (short) SkullType.PLAYER.ordinal());
            SkullMeta c6 = (SkullMeta) b6.getItemMeta();
            c6.setOwner(a6.getKey().getName());
            c6.setDisplayName(ChatColor.GOLD + a6.getKey().getName());
            ArrayList<String> d6 = new ArrayList<>();
            d6.add(ChatColor.GRAY + "Score: " + a6.getValue());
            c6.setLore(d6);
            b6.setItemMeta(c6);

            Inv.setItem(37, b6);
        }else{Inv.setItem(37, blue);}


        if(count >= 8) {
            a7 = iterator.next();
            ItemStack b7 = new ItemStack(Material.SKULL_ITEM, 7, (short) SkullType.PLAYER.ordinal());
            SkullMeta c7 = (SkullMeta) b7.getItemMeta();
            c7.setOwner(a7.getKey().getName());
            c7.setDisplayName(ChatColor.GOLD + a7.getKey().getName());
            ArrayList<String> d7 = new ArrayList<>();
            d7.add(ChatColor.GRAY + "Score: " + a7.getValue());
            c7.setLore(d7);
            b7.setItemMeta(c7);

            Inv.setItem(39, b7);
        }else{Inv.setItem(39, blue);}


        if(count >= 9) {
            a8 = iterator.next();
            ItemStack b8 = new ItemStack(Material.SKULL_ITEM, 8, (short) SkullType.PLAYER.ordinal());
            SkullMeta c8 = (SkullMeta) b8.getItemMeta();
            c8.setOwner(a8.getKey().getName());
            c8.setDisplayName(ChatColor.GOLD + a8.getKey().getName());
            ArrayList<String> d8 = new ArrayList<>();
            d8.add(ChatColor.GRAY + "Score: " + a8.getValue());
            c8.setLore(d8);
            b8.setItemMeta(c8);

            Inv.setItem(41, b8);
        }else{Inv.setItem(41, blue);}


        if(count >= 10) {
            a9 = iterator.next();
            ItemStack b9 = new ItemStack(Material.SKULL_ITEM, 9, (short) SkullType.PLAYER.ordinal());
            SkullMeta c9 = (SkullMeta) b9.getItemMeta();
            c9.setOwner(a9.getKey().getName());
            c9.setDisplayName(ChatColor.GOLD + a9.getKey().getName());
            ArrayList<String> d9 = new ArrayList<>();
            d9.add(ChatColor.GRAY + "Score: " + a9.getValue());
            c9.setLore(d9);
            b9.setItemMeta(c9);

            Inv.setItem(43, b9);
        }else{Inv.setItem(43, blue);}

        Inv.setItem(0, black);
        Inv.setItem(1, black);
        Inv.setItem(2, black);
        Inv.setItem(3, black);
        Inv.setItem(4, black);
        Inv.setItem(5, black);
        Inv.setItem(6, black);
        Inv.setItem(7, black);
        Inv.setItem(8, black);
        Inv.setItem(9, black);
        Inv.setItem(10, blue);
        Inv.setItem(11, blue);
        Inv.setItem(12, blue);
        Inv.setItem(14, blue);
        Inv.setItem(15, blue);
        Inv.setItem(16, blue);
        Inv.setItem(17, black);
        Inv.setItem(18, black);
        Inv.setItem(19, blue);
        Inv.setItem(20, blue);
        Inv.setItem(22, blue);
        Inv.setItem(24, blue);
        Inv.setItem(25, blue);
        Inv.setItem(26, black);
        Inv.setItem(27, black);
        Inv.setItem(28, blue);
        Inv.setItem(30, blue);
        Inv.setItem(32, blue);
        Inv.setItem(34, blue);
        Inv.setItem(35, black);
        Inv.setItem(36, black);
        Inv.setItem(38, black);
        Inv.setItem(40, black);
        Inv.setItem(42, black);
        Inv.setItem(44, black);
        Inv.setItem(45, black);
        Inv.setItem(46, black);
        Inv.setItem(47, black);
        Inv.setItem(48, black);
        Inv.setItem(49, black);
        Inv.setItem(50, black);
        Inv.setItem(51, black);
        Inv.setItem(52, black);
        Inv.setItem(53, black);

        p.openInventory(Inv);

    }


    @Override
    public Inventory getInventory() {
        return Inv;
    }
}

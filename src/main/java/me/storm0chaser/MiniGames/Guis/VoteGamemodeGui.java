package me.storm0chaser.MiniGames.Guis;

import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.Objects.GamesObject;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class VoteGamemodeGui implements InventoryHolder {
    private Inventory Inv;

    public VoteGamemodeGui(Player p){
        Inv =  Bukkit.createInventory(this, 54, "GameModes Vote");
        ItemStack black = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta blackmeta = black.getItemMeta();
        blackmeta.setDisplayName("");
        black.setItemMeta(blackmeta);
        ItemStack blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);

        int slots = 10;


        for(Map.Entry<String, GamesObject> entry : Main.Games.entrySet()){
            String name = entry.getValue().getDisplayName();
            int MaxPlayers = entry.getValue().getMaxPlayers();
            int MinPlayers = entry.getValue().getMinPlayers();
            int Votes = entry.getValue().getVotes();
            Material Mat = entry.getValue().getMat();
            boolean Teams = entry.getValue().isTeam();

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE+"Current Votes: "+Votes);
            lore.add(ChatColor.WHITE+"Teams: "+ Teams);
            lore.add(ChatColor.GRAY+"Click to vote");

            Gamemode(Mat, name,slots, lore, Votes);
            slots++;
        }
        for(int i =0; i < 54; i++){
            if(Inv.getItem(i) == null){
                Inv.setItem(i, black);
            }
        }
        p.openInventory(Inv);

    }
    public void Gamemode(Material material, String name, int slot, ArrayList<String> lore, int amount){

        ItemStack A = new ItemStack(material, amount);
        ItemMeta AMeta = (ItemMeta) A.getItemMeta();
        AMeta.setDisplayName(name);
        AMeta.setLore(lore);
        A.setItemMeta(AMeta);
        Inv.setItem(slot, A);
    }


    @Override
    public Inventory getInventory() {
        return Inv;
    }
}


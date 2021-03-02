package me.storm0chaser.MiniGames.LobbyPvp;

import me.storm0chaser.MiniGames.ScoreBoard.PvPScoreBoard;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class PvP implements Listener {


    private static HashMap<Player, PvPHashMap> ToggledPvp = new HashMap<>();
    public static boolean CheckPvpToggle(Player p){
        boolean pvp = CheckPvp(p);
        return pvp;

    }
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        e.getPlayer().setHealth(20);
        e.getPlayer().setFoodLevel(20);
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setHelmet(null);
        e.getPlayer().getInventory().setChestplate(null);
        e.getPlayer().getInventory().setLeggings(null);
        e.getPlayer().getInventory().setBoots(null);

        Inventory inv = e.getPlayer().getInventory();

        ItemStack PvpSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        net.minecraft.server.v1_8_R3.ItemStack stack = CraftItemStack.asNMSCopy(PvpSword);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("PvPSword", true);
        stack.setTag(tag);
        PvpSword = CraftItemStack.asCraftMirror(stack);
        ItemMeta meta = PvpSword.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Click to toggle PvP");
        PvpSword.setItemMeta(meta);
        inv.setItem(0, PvpSword);
        e.getPlayer().updateInventory();
    }
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e){
        if(e.getItem() == null){return;}
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            org.bukkit.inventory.ItemStack item = e.getPlayer().getItemInHand();
            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            if (!nmsItem.hasTag()) return;
            NBTTagCompound tag = nmsItem.getTag();
            if (tag.hasKey("PvPSword") && tag.getBoolean("PvPSword")) {
                ToggledPvp.put(e.getPlayer(), new PvPHashMap(true, 0, 0));
                e.getPlayer().getInventory().clear();
                e.getPlayer().updateInventory();
                e.getPlayer().getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                e.getPlayer().getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                e.getPlayer().getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                e.getPlayer().getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                e.getPlayer().getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
                for(int i =1; i <= 8; i++){
                    e.getPlayer().getInventory().setItem(i, new ItemStack(Material.POTION, 1, (short) 16421));
                }
                new PvPScoreBoard(e.getPlayer());
                e.getPlayer().updateInventory();
            }
        }
    }

    @EventHandler
    public void PlayerLogout(PlayerQuitEvent e){
        RemovePvP(e.getPlayer());
    }

    private static boolean CheckPvp(Player p){
        Boolean pvp = false;
        if(ToggledPvp.containsKey(p)){
            if(ToggledPvp.get(p).isToggled()){pvp = true;}
        }
        return pvp;
    }

    public static void RemovePvP(Player p){
        if(CheckPvp(p)){ToggledPvp.remove(p);}
    }

    public static int getkills(Player p){
        int kills = 0;
        if(ToggledPvp.containsKey(p)){kills = ToggledPvp.get(p).getKills();}
        return kills;
    }
    public static void addkills(Player p, int amount){
        if(ToggledPvp.containsKey(p)){ToggledPvp.get(p).setKills(ToggledPvp.get(p).getKills() + amount);}
    }
    public static void adddeaths(Player p, int amount){
        if(ToggledPvp.containsKey(p)){ToggledPvp.get(p).setDeaths(ToggledPvp.get(p).getDeaths() + amount);}
    }
    public static void ChangeToggle(Player p, boolean b){
        if(ToggledPvp.containsKey(p)) {
            ToggledPvp.get(p).setToggled(b);
        }
    }
    public static boolean isToggled(Player p){
        boolean b = false;
        if(ToggledPvp.containsKey(p)){b= ToggledPvp.get(p).isToggled();}
        return b;
    }

    public static int getdeaths(Player p){
        int deaths = 0;
        if(ToggledPvp.containsKey(p)){deaths = ToggledPvp.get(p).getDeaths();}
        return deaths;
    }

}

package me.storm0chaser.MiniGames.Guis;

import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.Objects.GamesObject;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.Map;

public class GuiEventHandler implements Listener {
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent e){
        if(e.getClickedInventory() == null){return;}
        if(e.getCurrentItem() == null){return;}

        if(e.getClickedInventory().getHolder() instanceof LeaderBoardGui){
            e.setCancelled(true);
        }

        if(e.getClickedInventory().getHolder() instanceof VoteGamemodeGui){
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            Material Mat = e.getCurrentItem().getType();

            for(Map.Entry<String, GamesObject> entry : Main.Games.entrySet()) {
                entry.getValue().getMat();
                if(entry.getValue().getMat().equals(Mat)){
                    entry.getValue().setVotes(entry.getValue().getVotes() +1);
                    p.sendMessage("You have voted for " + entry.getValue().getDisplayName());
                    p.closeInventory();
                    Main.Voted.add(p);
                    break;
                }
            }
        }
    }
}

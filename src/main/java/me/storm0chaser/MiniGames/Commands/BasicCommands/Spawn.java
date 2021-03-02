package me.storm0chaser.MiniGames.Commands.BasicCommands;

import me.storm0chaser.MiniGames.LobbyPvp.PvP;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            if(commandSender instanceof Player){
                Player p = (Player) commandSender;
                if(Main.PlayerScores.containsKey(p)){p.sendMessage("You can't teleport to spawn while in a gamemode"); return false;}
                p.teleport(Main.SpawnLocation);
                PvP.ChangeToggle(p, false);
                p.getInventory().clear();
                p.getInventory().clear();
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);
                p.updateInventory();
                p.setHealth(20);
                p.setFoodLevel(20);


            }
        return false;
    }
}

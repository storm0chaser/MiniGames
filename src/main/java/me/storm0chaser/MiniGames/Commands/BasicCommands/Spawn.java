package me.storm0chaser.MiniGames.Commands.BasicCommands;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            if(commandSender instanceof Player){
                if(Main.PlayerScores.containsKey(commandSender)){commandSender.sendMessage("You can't teleport to spawn while in a gamemode"); return false;}
                ((Player) commandSender).teleport(Main.SpawnLocation);
            }
        return false;
    }
}

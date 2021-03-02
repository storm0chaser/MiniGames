package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Games.Manager.Managers;
import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.Objects.EventObject;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ForceStartCommand extends CommandHandler{
    private Main plugin = Main.getInstance();
    @Override
    public void onCommand(Player p, String[] args, String s, String[] test) {

        if(p.hasPermission("minigames.start")){
            Managers.Start();
            for(Player players : Main.MiniGamesEvent.getPlayersin()){
                players.sendMessage("Event has been forcestarted by: "+p.getName());
            }
        }
    }

    @Override
    public String name() {
        return plugin.commandManager.forcestart;
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}


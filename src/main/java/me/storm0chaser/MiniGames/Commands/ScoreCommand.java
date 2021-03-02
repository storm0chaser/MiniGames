package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Guis.LeaderBoardGui;
import me.storm0chaser.MiniGames.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ScoreCommand extends CommandHandler{
    private Main plugin = Main.getInstance();
    @Override
    public void onCommand(Player p, String[] args, String s, String[] test) {

        if(p.hasPermission("minigames.score")){

            if(Main.MiniGamesEvent == null || !Main.MiniGamesEvent.isStarted()){p.sendMessage("Event hasn't started"); return;}
            new LeaderBoardGui(p);
        }
    }

    @Override
    public String name() {
        return plugin.commandManager.leaderboard;
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

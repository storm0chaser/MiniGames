package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Guis.VoteGamemodeGui;
import me.storm0chaser.MiniGames.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class VoteCommand extends CommandHandler{
    private Main plugin = Main.getInstance();
    @Override
    public void onCommand(Player p, String[] args, String s, String[] test) {

        if(p.hasPermission("minigames.join")){

            if(Main.MiniGamesEvent == null || !Main.MiniGamesEvent.isStarted()){p.sendMessage("Event hasn't started"); return;}
            if(!Main.MiniGamesEvent.getPlayersin().contains(p)){p.sendMessage("You are not in the event. \n/event join to join the event"); return;}
            if(!Main.Voted.contains(p)){new VoteGamemodeGui(p);}else{p.sendMessage("You have already voted");}

        }
    }

    @Override
    public String name() {
        return plugin.commandManager.vote;
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


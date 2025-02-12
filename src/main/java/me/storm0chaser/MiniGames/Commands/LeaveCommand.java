package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LeaveCommand extends CommandHandler{
    private Main plugin = Main.getInstance();
    @Override
    public void onCommand(Player p, String[] args, String s, String[] test) {

        if(p.hasPermission("minigames.join")){

            if(Main.MiniGamesEvent == null || !Main.MiniGamesEvent.isStarted()){p.sendMessage("Event hasn't started"); return;}
            if(!Main.MiniGamesEvent.getPlayersin().contains(p)){p.sendMessage("You are not in the event. \n/event join to join the event"); return;}
            Main.MiniGamesEvent.getPlayersin().remove(p);
            Main.PlayerScores.remove(p);
            p.teleport(Main.SpawnLocation);

            TextComponent Msg = new TextComponent(p.getName() + ChatColor.LIGHT_PURPLE+" You have left the event \n"+ChatColor.GRAY+"/event join"+ ChatColor.LIGHT_PURPLE+"\nTo join the event or click this message");
            Msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/event join"));
            Msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(net.md_5.bungee.api.ChatColor.GRAY+"Click here to join").create()));
            Msg.setColor(net.md_5.bungee.api.ChatColor.WHITE);

                p.spigot().sendMessage(Msg);

        }
    }

    @Override
    public String name() {
        return plugin.commandManager.leave;
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

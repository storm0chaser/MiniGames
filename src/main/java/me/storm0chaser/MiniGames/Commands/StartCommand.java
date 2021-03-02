package me.storm0chaser.MiniGames.Commands;

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



public class StartCommand extends CommandHandler{
    private Main plugin = Main.getInstance();
    @Override
    public void onCommand(Player p, String[] args, String s, String[] test) {

        if(p.hasPermission("minigames.start")){
            if(Main.MiniGamesEvent != null) {
                if (Main.MiniGamesEvent.isStarted()) {
                    p.sendMessage("Event has already started. \nEvent end to end it");
                }
            }
            Main.MiniGamesEvent = new EventObject(true, p, new ArrayList<Player>(), System.currentTimeMillis());

            Main.Output(Main.MiniGamesEvent.getTimestarted()+" < null??");

            TextComponent Msg = new TextComponent(p.getName() + ChatColor.LIGHT_PURPLE+" Has started the Event \n"+ChatColor.GRAY+"/event join"+ ChatColor.LIGHT_PURPLE+"\nTo join the event or click this message\n The event will start in 5 minutes");
            Msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/event join"));
            Msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(net.md_5.bungee.api.ChatColor.GRAY+"Click here to join").create()));
            Msg.setColor(net.md_5.bungee.api.ChatColor.WHITE);
            for(Player a : Bukkit.getOnlinePlayers()){
                a.spigot().sendMessage(Msg);
            }
        }
    }

    @Override
    public String name() {
        return plugin.commandManager.start;
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

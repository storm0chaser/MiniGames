package me.storm0chaser.MiniGames.Chat.Message;

import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.storm0chaser.MiniGames.Main.LastPlayerMsg;

public class Msg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(!(sender instanceof Player)){sender.sendMessage("You must be a player to send messages"); return false;}
        if(!sender.hasPermission("minigames.message")){sender.sendMessage(Messages.NoPermission); return false;}
        Main.Output(strings.length+"");
        if(strings.length <= 1 ){sender.sendMessage(Messages.Noargs); return false;}
        Player target = Bukkit.getPlayer(strings[0]);
        Player p = (Player) sender;
        if(target == null || !target.isOnline()){p.sendMessage(Messages.PlayerNotFound); return false;}
        String msg;
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i != strings.length; i++){ sb.append(strings[i]+" ");}
        msg = sb.toString();

        TextComponent Msg = new TextComponent((Messages.PlayerMsgFormat.replace("%player%", p.getName()).replace("%msg%", msg)));
        Msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg "+target.getName()+" "));
        Msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY+"Click here to reply").create()));
        Msg.setColor(ChatColor.WHITE);
        target.spigot().sendMessage(Msg);


        if(!LastPlayerMsg.containsKey(p)){LastPlayerMsg.put(p, target); return false;}
        //checks if its same target if not changes it
        if(!LastPlayerMsg.get(p).equals(target)){LastPlayerMsg.replace(p, p, target);}




        return false;
    }
}

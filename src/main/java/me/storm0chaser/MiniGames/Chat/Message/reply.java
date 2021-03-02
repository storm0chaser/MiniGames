package me.storm0chaser.MiniGames.Chat.Message;

import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reply implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)){sender.sendMessage("You must be a player to send messages"); return false;}
        if(!sender.hasPermission("minigames.message")){sender.sendMessage(Messages.NoPermission); return false;}
        if(strings.length <= 0 ){sender.sendMessage(Messages.Noargs); return false;}
        Player p = (Player) sender;
        if(!Main.LastPlayerMsg.containsKey(p)){p.sendMessage(Messages.PlayerNotMessaged); return false;}

        String msg;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i != strings.length; i++){ sb.append(strings[i]+" ");}
        msg = sb.toString();
        Player target = Main.LastPlayerMsg.get(p);
        Main.Output(Main.LastPlayerMsg.toString());
        if(target.isOnline() && target != null){target.sendMessage(Messages.PlayerMsgFormat.replace("%player%", p.getName()).replace("%msg%", msg));
        }else{p.sendMessage(Messages.PlayerNotFound);}

        return false;
    }
}

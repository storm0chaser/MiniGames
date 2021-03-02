package me.storm0chaser.MiniGames.Chat;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BlackListWordCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("minigames.filter")){
            int a=0;
            for(int i=0; i < strings.length; i++){

                if(!Main.BlackListedWords.contains(strings[i])){Main.BlackListedWords.add(strings[i]);}else{a++;}
            }

            if(a == 0){commandSender.sendMessage("Added "+strings.length+" words to the filter");}else{int a1= strings.length -a;  commandSender.sendMessage("Added "+a1+" words to the filter, "+a +" words were already added");}

            Main.Output(Main.BlackListedWords.toString());
        }

        return false;
    }
}

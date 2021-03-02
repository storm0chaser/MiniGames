package me.storm0chaser.MiniGames.Config;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
    public static String Prefix, NoPermission, Help, Noargs, InvalidSubCommand, Error, PlayerNotFound, PlayerMsgFormat, PlayerNotMessaged, PlayerWelcomeMsgNew, PlayerWelcomeMsg, BroadCastNewPlayer,  TitleMessageNew, TitleMessage, Notargetprovided, ChatFormat, BlackListedWord;

    public static void Messages(){
        Prefix = Files.getMessage("messages.yml", "Prefix");
        NoPermission = Files.getMessage("messages.yml", "NoPermission");
        Help = Files.getMessage("messages.yml", "Help");
        Noargs = Files.getMessage("messages.yml", "Noargs");
        InvalidSubCommand = Files.getMessage("messages.yml", "InvalidSubCommand");
        Error = Files.getMessage("messages.yml", "Error");
        PlayerNotFound = ChatColor.translateAlternateColorCodes('&', Files.getMessage("messages.yml", "Chat.PlayerNotFound").replace("%nl%", "\n"));
        PlayerMsgFormat = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Chat.PlayerMsgFormat").replace("%nl%", "\n"));
        PlayerNotMessaged = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Chat.PlayerNotMessaged").replace("%nl%", "\n"));
        Notargetprovided = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Chat.Notargetprovided").replace("%nl%", "\n"));
        ChatFormat = ChatColor.translateAlternateColorCodes('&', Files.getMessage("messages.yml", "Chat.Format"));
        BlackListedWord = ChatColor.translateAlternateColorCodes('&', Files.getMessage("messages.yml", "Chat.BlackListedWord"));

        PlayerWelcomeMsgNew = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Welcome.PlayerWelcomeMsgNew").replace("%nl%", "\n"));
        PlayerWelcomeMsg = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Welcome.PlayerWelcomeMsg").replace("%nl%", "\n"));
        BroadCastNewPlayer = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Welcome.BroadCastNewPlayer").replace("%nl%", "\n"));
        TitleMessageNew = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Welcome.TitleMessageNew").replace("%nl%", "\n"));
        TitleMessage = ChatColor.translateAlternateColorCodes('&',Files.getMessage("messages.yml", "Welcome.TitleMessage").replace("%nl%", "\n"));

    }
}

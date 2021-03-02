package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.entity.Player;

public abstract class CommandHandler {
    private Main plugin = Main.instance;

    public CommandHandler(){

    }

    public abstract void onCommand(Player player, String[] args, String s, String[] test);
    public abstract String name();
    public abstract String info();
    public abstract String[] aliases();



}

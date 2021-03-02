package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.entity.Player;

public class HelpCommand extends CommandHandler{
    private Main plugin = Main.getInstance();



    @Override
    public void onCommand(Player player, String[] args, String s, String[] test) {

        player.sendMessage(Messages.Help);
    }

    @Override
    public String name() {
        return plugin.commandManager.help;
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

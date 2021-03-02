package me.storm0chaser.MiniGames.Commands;

import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandManager implements CommandExecutor {

    private ArrayList<CommandHandler> commands = new ArrayList<>();
    private Main plugin = Main.getInstance();

    public CommandManager(){

    }
    public String help = "help";
    public String main = "event";
    public String start = "start";
    public String join = "join";
    public String leave = "leave";
    public String leaderboard = "leaderboard";
    public String vote = "vote";
    public String forcestart = "forcestart";
    public void setup(){

        plugin.getCommand(main).setExecutor(this);

        this.commands.add(new HelpCommand());
        this.commands.add(new StartCommand());
        this.commands.add(new JoinCommand());
        this.commands.add(new LeaveCommand());
        this.commands.add(new ScoreCommand());
        this.commands.add(new VoteCommand());
        this.commands.add(new ForceStartCommand());
    }

    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] args) {
       final String[] test = args;

        if(!(Sender instanceof Player)){
            Sender.sendMessage(Messages.Help);
            return true;
        }
        Player player = (Player) Sender;
        if(command.getName().equalsIgnoreCase(main)){
            if(args.length == 0){
                player.sendMessage(Messages.Noargs);
                return true;
            }
            CommandHandler target = this.get(args[0]);
            if(target == null){
                player.sendMessage(Messages.InvalidSubCommand);
                return true;
            }
            ArrayList<String> arrayList = new ArrayList<String>();

            arrayList.addAll(Arrays.asList(args));
            arrayList.remove(0);

            try {
                target.onCommand(player, args, s, test);
            }catch (Exception e){
                player.sendMessage(Messages.Error);
                e.printStackTrace();
            }

        }
        return true;
    }
    private CommandHandler get(String name){
        Iterator<CommandHandler> subcommands = this.commands.iterator();

        while (subcommands.hasNext()){
            CommandHandler sc = (CommandHandler) subcommands.next();
            if(sc.name().equalsIgnoreCase(name)){
                return sc;
            }
            String[] aliases;
            int length = (aliases = sc.aliases()).length;

            for (int var5 = 0; var5 < length; ++var5){
                String alias = aliases[var5];
                if(name.equalsIgnoreCase(alias)){
                    return sc;
                }
            }

        }
        return null;

    }
}

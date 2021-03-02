package me.storm0chaser.MiniGames;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import me.storm0chaser.MiniGames.Chat.BlackListWordCmd;
import me.storm0chaser.MiniGames.Chat.Chat;
import me.storm0chaser.MiniGames.Chat.Message.Msg;
import me.storm0chaser.MiniGames.Chat.Message.reply;
import me.storm0chaser.MiniGames.Commands.BasicCommands.Spawn;
import me.storm0chaser.MiniGames.Commands.CommandManager;
import me.storm0chaser.MiniGames.Config.Files;
import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Events.BasicEvents;
import me.storm0chaser.MiniGames.Games.Pirate.Events.EventListener;
import me.storm0chaser.MiniGames.Objects.EventObject;
import me.storm0chaser.MiniGames.ScoreBoard.ScoreBoardUpdater;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main extends JavaPlugin implements Listener {

    public static Main instance;
    public CommandManager commandManager;
    public static Location SpawnLocation;
    public static int PlayerCount;
    public static String servername;
    public static HashMap<Player, Player> LastPlayerMsg = new HashMap<>();
    public static boolean TitleWelcomeEnable;
    public static boolean WelcomeMsgEnable;
    public static boolean BarWelcomeEnable;
    public static  EventObject MiniGamesEvent;
    public static HashMap<Player, Integer> PlayerScores = new HashMap<>();
    public static long eventcountdown;
    //public static List<String> BlackListedWords;
    public static HashSet<String> BlackListedWords;


    @Override
    public void onEnable() {
        super.onEnable();
        Output("MiniGames started");
        instance = this;
        Files.load();
        Messages.Messages();

        commandManager = new CommandManager();
        commandManager.setup();
        Main.instance = instance;
        this.getCommand("msg").setExecutor(new Msg());
        this.getCommand("reply").setExecutor(new reply());
        this.getCommand("spawn").setExecutor(new Spawn());
        this.getCommand("filteradd").setExecutor(new BlackListWordCmd());
        Bukkit.getPluginManager().registerEvents(new BasicEvents(), this);
        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
        Bukkit.getPluginManager().registerEvents(new Chat(), this);
        Bukkit.getPluginManager().registerEvents(new me.storm0chaser.MiniGames.Events.arrowhitblockevent.EventListener(this), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new ScoreBoardUpdater(), 0L, 60);

        ProtocolLibrary.getProtocolManager().addPacketListener(
                new PacketAdapter(this, ListenerPriority.NORMAL,
                        Arrays.asList(PacketType.Status.Server.OUT_SERVER_INFO), ListenerOptions.ASYNC) {

                    @Override
                    public void onPacketSending(PacketEvent event) {
                        handlePing1(event.getPacket().getServerPings().read(0));
                    }
                });
    }

    private void handlePing1(WrappedServerPing ping) {
        //  ping.setVersionProtocol(-1);
        // ping.setPlayersVisible(false);
        ping.setVersionName("MiniGamesCore");
        long time = Main.eventcountdown - System.currentTimeMillis();
        long days = TimeUnit.MILLISECONDS.toDays(time);
        long hours = TimeUnit.MILLISECONDS.toHours(time) % 24L;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) % 60L;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) % 60L;

         ping.setMotD(ChatColor.translateAlternateColorCodes('&',"   &m&l------------&r&l<&6&lGerber&f&lGames&r&l>&m&l------------\n" +
                 "&cNext event in: "+ (days == 0L ? "" : days + " days ") + (hours == 0L ? "" : hours + " hours ") + (minutes == 0L ? "" : minutes + " minutes ") + (seconds == 0L ? "" : seconds + " seconds")));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Files.SaveInt("data.yml","EventCountdown", eventcountdown);
        Files.SaveInt("data.yml", "PlayerCount", PlayerCount);
        Files.setToFile("config.yml", "BlackListedWords", Main.BlackListedWords);
    }
    public static void Output(String message){System.out.println(message);}
    public static Main getInstance(){
        return instance;
    }
}

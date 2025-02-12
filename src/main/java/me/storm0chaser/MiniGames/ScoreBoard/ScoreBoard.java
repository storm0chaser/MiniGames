package me.storm0chaser.MiniGames.ScoreBoard;

import de.Herbystar.TTA.TTA_Methods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoard {



    public ScoreBoard(Player p){
        ScoreboardManager s = Bukkit.getScoreboardManager();
        Scoreboard sb = s.getNewScoreboard();

        Objective o = sb.registerNewObjective("Minigames", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"Gerber"+ChatColor.WHITE+""+ChatColor.BOLD+"Games");

        Score a = o.getScore(" Name: "+ p.getName());
        Score a1 = o.getScore(" Online: "+ Bukkit.getOnlinePlayers().size());
        Score a2 = o.getScore(" Ping: "+ TTA_Methods.getPing(p)+ " ms");
        Score a3 = o.getScore("");
        Score a4 = o.getScore("GerberGames.net");
        Score a5 = o.getScore("");

        a5.setScore(6);
        a.setScore(5);
        a1.setScore(4);
        a2.setScore(3);
        a3.setScore(2);
        a4.setScore(1);
        p.setScoreboard(sb);

    }

}

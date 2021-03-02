package me.storm0chaser.MiniGames.ScoreBoard;

import me.storm0chaser.MiniGames.Games.Manager.Managers;
import me.storm0chaser.MiniGames.LobbyPvp.PvP;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class PiratesScoreBoard {

    public PiratesScoreBoard(Player p){
        ScoreboardManager s = Bukkit.getScoreboardManager();
        Scoreboard sb = s.getNewScoreboard();

        Objective o = sb.registerNewObjective(Main.Games.get(Managers.HighestGamemode).getDisplayName(), "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"Gerber"+ChatColor.WHITE+""+ChatColor.BOLD+"Games");

        Score a = o.getScore(" Team 1: "+ Main.Games.get(Managers.HighestGamemode).getTeam1Players().size());
        Score a1 = o.getScore(" Team 2: "+ Main.Games.get(Managers.HighestGamemode).getTeam2Players().size());
        Score a3 = o.getScore("");
        Score a4 = o.getScore("GerberGames.net");
        Score a5 = o.getScore("");

        a5.setScore(6);
        a.setScore(5);
        a1.setScore(4);
        a3.setScore(2);
        a4.setScore(1);
        p.setScoreboard(sb);

    }




}

package me.storm0chaser.MiniGames.Games.Manager;

import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.Objects.GamesObject;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Managers {
    public static int HighestVoted = 0;
    public static String HighestGamemode = "";

    public static void Pirates(){
        Register();
    }
    public static void Start(){
        StartGamemode();
    }
    private static void  Register(){
        World w = Bukkit.getWorld("pirate");
        Location team1 = new Location(w, 2.5, 115, 45.5);
        Location team2 = new Location(w,-24.5 ,115 , 71.5);
        ArrayList<Player> Team2Players = new ArrayList<Player>();
        ArrayList<Player> Team1Players = new ArrayList<Player>();




        Main.Games.put("pirate", new GamesObject(true, 2, 60, team1, team2, 0, Material.BOW, ChatColor.GOLD+"Pirate",Team1Players, Team2Players ));
    }

    private static void StartGamemode(){

            //sorts out who won the vote
        for(Map.Entry<String, GamesObject> entry : Main.Games.entrySet()) {
            entry.getValue().getVotes();
            if(entry.getValue().getVotes() > HighestVoted){
                HighestVoted = entry.getValue().getVotes();
                HighestGamemode = entry.getKey();
            }
        }
        //splits up teams into 2
        if(Main.MiniGamesEvent.getPlayersin().size() >= Main.Games.get(HighestGamemode).getMinPlayers()) {


            for(Player p : Main.MiniGamesEvent.getPlayersin()){

                if(Main.Games.get(HighestGamemode).getTeam1Players().size() > Main.Games.get(HighestGamemode).getTeam2Players().size()){
                    Main.Games.get(HighestGamemode).getTeam2Players().add(p);
                    Main.Output("Put on team 1");
                }
                else{
                    Main.Games.get(HighestGamemode).getTeam1Players().add(p);
                    Main.Output("Put on team 2");
                }
            }
            //teleport them
            for(Player p : Main.Games.get(HighestGamemode).getTeam1Players()){
                p.teleport(Main.Games.get(HighestGamemode).getSpawnLocationTeam1());
            }

            for(Player p : Main.Games.get(HighestGamemode).getTeam2Players()){
                p.teleport(Main.Games.get(HighestGamemode).getSpawnLocationTeam2());
            }





        //if not enough players are on, it will cancel
        }else{
            for (Player p : Main.MiniGamesEvent.getPlayersin()) {
                if (p.isOnline()) {
                    p.sendMessage("Not enough players online to start "+ Main.Games.get(HighestGamemode).getDisplayName());

                }
            }


        }


    }


}

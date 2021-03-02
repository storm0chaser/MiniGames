package me.storm0chaser.MiniGames.Games.Pirate.PirateRunnable;

import me.storm0chaser.MiniGames.Games.Manager.Managers;
import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.ScoreBoard.PiratesScoreBoard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Arrow implements Runnable {


    @Override
    public void run() {


        if(Main.Games.get(Managers.HighestGamemode).getTeam1Players().size() <= 0|| Main.Games.get(Managers.HighestGamemode).getTeam2Players().size() <= 0){
            String Winner = "";
            if(Main.Games.get(Managers.HighestGamemode).getTeam1Players().size() <= 0){Winner = "Team 2";}else{
                Winner = "Team 1";
            }
            Bukkit.broadcastMessage(Winner+" has won "+ Main.Games.get(Managers.HighestGamemode).getDisplayName());

        }


        for(Player p : Main.Games.get(Managers.HighestGamemode).getTeam1Players()){
            if(p.isOnline()){
                p.giveExpLevels(1);
                if(p.getExpToLevel() > 5) {
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.setExp(0);
                }
                if(p.getLocation().getY() < 30){
                    Main.Games.get(Managers.HighestGamemode).getTeam1Players().remove(p);
                    for(Player players : Main.MiniGamesEvent.getPlayersin()){
                        players.sendMessage(p.getName()+" Has been killed");
                    }
                }


                new PiratesScoreBoard(p);


            }else{Main.Games.get(Managers.HighestGamemode).getTeam1Players().remove(p);}

        }

        for(Player p : Main.Games.get(Managers.HighestGamemode).getTeam2Players()){
            if(p.isOnline()){

                p.giveExpLevels(1);
                if(p.getExpToLevel() > 5) {
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.setExp(0);
                }
                if(p.getLocation().getY() < 30){
                    Main.Games.get(Managers.HighestGamemode).getTeam2Players().remove(p);
                    for(Player players : Main.MiniGamesEvent.getPlayersin()){
                        players.sendMessage(p.getName()+" Has been killed");
                    }
                }
                new PiratesScoreBoard(p);

            }else{Main.Games.get(Managers.HighestGamemode).getTeam2Players().remove(p);}
        }
    }
}

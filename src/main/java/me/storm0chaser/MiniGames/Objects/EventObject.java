package me.storm0chaser.MiniGames.Objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class EventObject {
    private boolean Started;
    private Player Whostarted;
    private ArrayList<Player> Playersin;
    private long Timestarted;



    public EventObject(boolean Started, Player Whostarted, ArrayList<Player> Playersin, long TimeStarted){
        this.Started = Started;
        this.Whostarted = Whostarted;
        this.Playersin = Playersin;
        this.Timestarted = TimeStarted;
    }

    public boolean isStarted() {
        return Started;
    }

    public void setStarted(boolean started) {
        this.Started = started;
    }

    public Player getWhostarted() {
        return Whostarted;
    }

    public void setWhostarted(Player whostarted) {
        Whostarted = whostarted;
    }

    public void setPlayersin(ArrayList<Player> playersin) {
        Playersin = playersin;
    }

    public ArrayList<Player> getPlayersin() {
        return Playersin;
    }

    public long getTimestarted() {
        return Timestarted;
    }

    public void setTimestarted(long timestarted) {
        Timestarted = timestarted;
    }

}

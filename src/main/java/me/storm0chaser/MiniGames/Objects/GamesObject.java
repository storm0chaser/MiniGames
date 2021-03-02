package me.storm0chaser.MiniGames.Objects;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class GamesObject {
    private boolean Team;
    private int MinPlayers;
    private int MaxPlayers;
    private Location SpawnLocationTeam1;
    private Location SpawnLocationTeam2;
    private int Votes;
    private Material Mat;
    private String DisplayName;
    private ArrayList<Player> Team1Players;
    private ArrayList<Player> Team2Players;

    public GamesObject(boolean Team, int MinPlayers, int MaxPlayers, Location SpawnLocationTeam1, Location SpawnLocationTeam2, int Votes, Material Mat, String DisplayName,  ArrayList<Player> Team1Players,  ArrayList<Player> Team2Players){
        this.Team = Team;
        this.MinPlayers = MinPlayers;
        this.MaxPlayers = MaxPlayers;
        this.SpawnLocationTeam1 = SpawnLocationTeam1;
        this.SpawnLocationTeam2 = SpawnLocationTeam2;
        this.Votes = Votes;
        this.Mat = Mat;
        this.DisplayName = DisplayName;
        this.Team1Players = Team1Players;
        this.Team2Players = Team2Players;
    }

    public boolean isTeam() {
        return Team;
    }

    public int getMaxPlayers() {
        return MaxPlayers;
    }

    public int getMinPlayers() {
        return MinPlayers;
    }

    public Location getSpawnLocationTeam1() {
        return SpawnLocationTeam1;
    }

    public Location getSpawnLocationTeam2() {
        return SpawnLocationTeam2;
    }

    public void setMaxPlayers(int maxPlayers) {
        MaxPlayers = maxPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        MinPlayers = minPlayers;
    }

    public void setSpawnLocationTeam1(Location spawnLocationTeam1) {
        SpawnLocationTeam1 = spawnLocationTeam1;
    }

    public void setSpawnLocationTeam2(Location spawnLocationTeam2) {
        SpawnLocationTeam2 = spawnLocationTeam2;
    }

    public void setTeam(boolean team) {
        Team = team;
    }

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }

    public Material getMat() {
        return Mat;
    }

    public void setMat(Material mat) {
        Mat = mat;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public void setTeam1Players(ArrayList<Player> team1Players) {
        Team1Players = team1Players;
    }

    public void setTeam2Players(ArrayList<Player> team2Players) {
        Team2Players = team2Players;
    }

    public ArrayList<Player> getTeam1Players() {
        return Team1Players;
    }

    public ArrayList<Player> getTeam2Players() {
        return Team2Players;
    }
}

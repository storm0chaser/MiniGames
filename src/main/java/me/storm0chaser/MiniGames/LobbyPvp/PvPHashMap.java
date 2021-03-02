package me.storm0chaser.MiniGames.LobbyPvp;

public class PvPHashMap {
    private boolean Toggled;
    private int Kills;
    private int Deaths;

    public PvPHashMap(boolean Toggled, int Kills, int Deaths){
        this.Deaths = Deaths;
        this.Kills = Kills;
        this.Toggled = Toggled;
    }

    public boolean isToggled() {
        return Toggled;
    }

    public int getDeaths() {
        return Deaths;
    }

    public int getKills() {
        return Kills;
    }

    public void setDeaths(int deaths) {
        Deaths = deaths;
    }

    public void setKills(int kills) {
        Kills = kills;
    }

    public void setToggled(boolean toggled) {
        Toggled = toggled;
    }
}

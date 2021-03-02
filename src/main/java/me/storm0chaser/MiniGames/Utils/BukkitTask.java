package me.storm0chaser.MiniGames.Utils;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;

public abstract class BukkitTask implements Runnable
{
    private final int id;
    private final boolean delayed;
    private final boolean repeating;

    // Set delayed task
    public BukkitTask(long delay)
    {
        this.id = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), this, delay);
        delayed = delay > 0;
        repeating = false;
    }

    // Set delayed repeating task
    public BukkitTask(long delay, long period)
    {
        this.id = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), this, delay, period);
        delayed = delay > 0;
        repeating = true;
    }

    public void cancel()
    {
        Bukkit.getScheduler().cancelTask(this.id);
    }

    public int getId()
    {
        return this.id;
    }

    public boolean isDelayed()
    {
        return delayed;
    }

    public boolean isRepeating()
    {
        return repeating;
    }
}

package me.storm0chaser.MiniGames.Events;

import de.Herbystar.TTA.TTA_Methods;
import me.confuser.barapi.BarAPI;
import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.LobbyPvp.PvP;
import me.storm0chaser.MiniGames.Main;
import me.storm0chaser.MiniGames.ScoreBoard.ScoreBoard;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.concurrent.TimeUnit;

import static me.storm0chaser.MiniGames.Main.TitleWelcomeEnable;

public class BasicEvents implements Listener {

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        long time = Main.eventcountdown - System.currentTimeMillis();
        long days = TimeUnit.MILLISECONDS.toDays(time);
        long hours = TimeUnit.MILLISECONDS.toHours(time) % 24L;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) % 60L;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) % 60L;

        new ScoreBoard(e.getPlayer());
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        p.teleport(Main.SpawnLocation);
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 10, 10);
        String welcome = Messages.PlayerWelcomeMsgNew.replace("%player%", p.getName()).replace("%eventcount%", (days == 0L ? "" : days + " days ") + (hours == 0L ? "" : hours + " hours ") + (minutes == 0L ? "" : minutes + " minutes ") + (seconds == 0L ? "" : seconds + " seconds"));
        String titlewelcome = Messages.TitleMessageNew.replace("%player%", p.getName()).replace("%servername%", Main.servername).replace("%eventcount%", (days == 0L ? "" : days + " days ") + (hours == 0L ? "" : hours + " hours ") + (minutes == 0L ? "" : minutes + " minutes ") + (seconds == 0L ? "" : seconds + " seconds"));
        if(!e.getPlayer().hasPlayedBefore()){
            Main.PlayerCount++;
            Bukkit.getServer().broadcastMessage(Messages.BroadCastNewPlayer.replace("%player%", p.getName()).replace("%count%", Main.PlayerCount+"").replace("%servername%", Main.servername));
        }
        if(e.getPlayer().hasPlayedBefore()){welcome = Messages.PlayerWelcomeMsg.replace("%player%", p.getName()).replace("%eventcount%", (days == 0L ? "" : days + " days ") + (hours == 0L ? "" : hours + " hours ") + (minutes == 0L ? "" : minutes + " minutes ") + (seconds == 0L ? "" : seconds + " seconds")); titlewelcome = Messages.TitleMessageNew.replace("%player%", p.getName()).replace("%servername%", Main.servername).replace("%eventcount%", (days == 0L ? "" : days + " days ") + (hours == 0L ? "" : hours + " hours ") + (minutes == 0L ? "" : minutes + " minutes ") + (seconds == 0L ? "" : seconds + " seconds"));}

        if(Main.BarWelcomeEnable){BarAPI.setMessage(p, titlewelcome , 5);}
        if(Main.TitleWelcomeEnable){TTA_Methods.sendTitle(p, ChatColor.GOLD+""+ChatColor.BOLD+"Gerber"+ChatColor.WHITE+""+ChatColor.BOLD+"Games",20,20,50,titlewelcome, 50, 20,20); }
        if(Main.WelcomeMsgEnable){p.sendMessage(welcome);}
    }
  @EventHandler
  public void PlayerLeaveevent(PlayerQuitEvent e){
        e.setQuitMessage(null);
        Main.LastPlayerMsg.remove(e.getPlayer());
  }
  @EventHandler
  public void PlayerDeathEvent(PlayerRespawnEvent e){
        if(e.getPlayer().getWorld().getName().equals("world")) {
            e.setRespawnLocation(Main.SpawnLocation);
        }
  }
    @EventHandler
    public void Break(BlockBreakEvent e) {
        if(e.getPlayer().hasPermission("Lobby.bypass") || !e.getPlayer().getWorld().getName().equals("world")){return;}
        e.setCancelled(true);
    }
    @EventHandler
    public void Place(BlockPlaceEvent e) {
        if(e.getPlayer().hasPermission("Lobby.bypass") || !e.getPlayer().getWorld().getName().equals("world")){return;}
        e.setCancelled(true);
    }
    @EventHandler
    public void DropItem(PlayerDropItemEvent e) {
        if(e.getPlayer().hasPermission("Lobby.bypass") || !e.getPlayer().getWorld().getName().equals("world")){return;}
        e.setCancelled(true);
    }
    @EventHandler
    public void ItemDamage(PlayerItemDamageEvent e) {
        if(e.getPlayer().hasPermission("Lobby.bypass") || !e.getPlayer().getWorld().getName().equals("world")){return;}
        e.setCancelled(true);
    }
    @EventHandler
    public void playerTakeDamamage(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player)){return;}
        Player p = (Player)e.getEntity();

        if(p.getWorld().getName().equals("world")){
            if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)){p.teleport(Main.SpawnLocation);e.setCancelled(true); return;}
            if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)){return;}
         //   if(p.getHealth() >=0){p.setHealth(20.0); p.teleport(Main.SpawnLocation); p.playSound(p.getLocation(), Sound.VILLAGER_DEATH, 1.0F, 0.0F);}


            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        final Player p = e.getEntity();

        if(e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
            Player killer = (Player) e.getEntity().getKiller();
            PvP.addkills(killer, 1);
            PvP.adddeaths(p, 1);
        }
        PvP.ChangeToggle(p, false);
        p.spigot().respawn();

    }

    @EventHandler
    public void LeavesDecay(LeavesDecayEvent e){
        e.setCancelled(true);
    }

  @EventHandler
  public void EntityTakeDamage(EntityDamageEvent e){
        if(e.getEntity().getLocation().getWorld().getName().contains("pirate") && e.getEntity() instanceof Player){
            e.setCancelled(true);
        }
  }
  @EventHandler
  public void Hunger(FoodLevelChangeEvent e){
        if(e.getEntity().getLocation().getWorld().equals("world")){e.setCancelled(true);}
  }
  @EventHandler
  public void Entitydamageentity(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player && e.getEntity().getLocation().getWorld().getName().equals("world")){
            Player p = (Player)e.getEntity();
            Player d = (Player) e.getDamager();

            if(PvP.CheckPvpToggle(p) && PvP.CheckPvpToggle(d)){return;}else{e.setCancelled(true);}
        }

  }
  @EventHandler
    public void WeatherChange(WeatherChangeEvent e){
        e.getWorld().setWeatherDuration(10);
  }


}

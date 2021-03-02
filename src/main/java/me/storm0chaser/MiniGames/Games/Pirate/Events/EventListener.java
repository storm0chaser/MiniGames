package me.storm0chaser.MiniGames.Games.Pirate.Events;

import me.storm0chaser.MiniGames.Events.arrowhitblockevent.ArrowHitBlockEvent;
import me.storm0chaser.MiniGames.Main;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.techcable.tacospigot.event.entity.ArrowCollideEvent;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class EventListener implements Listener {
    final private Main plugin;

    public EventListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowHitBLock(ArrowHitBlockEvent e) {

        if(e.getArrow().getShooter() instanceof CraftPlayer){
            CraftPlayer cp = (CraftPlayer) e.getArrow().getShooter();
            Player p =  cp.getPlayer();
            if(p.getWorld().getName().equals("pirate") && p.getInventory().contains(Material.BOW)) {

                Arrow arrow = e.getArrow();
                Block b = e.getBlock();
                arrow.remove();
                b.getWorld().createExplosion(b.getLocation(), 0, false);

                for (Entity nearbyentities : b.getLocation().getWorld().getNearbyEntities(b.getLocation(), 3.0D, 3.0D, 3.0D)) {
                    int xPos = (int) (b.getX() - nearbyentities.getLocation().getX());
                    int zPos = (int) (b.getZ() - nearbyentities.getLocation().getZ());
                    int redux = 10;

                    nearbyentities.setVelocity(new Vector(xPos / redux, 0.5, zPos / redux));
                }
                int raduis = 1;

                for (int x = raduis; x >= -raduis; x--) {
                    for (int y = raduis; y >= -raduis; y--) {
                        for (int z = raduis; z >= -raduis; z--) {
                            Block newb = b.getRelative(x, y, z);
                            if (newb.getType() != Material.AIR && newb.getType().isSolid()) {
                                Random rand = new Random();
                                int random = rand.nextInt(3);
                                newb.setType(Material.WOOL);
                                newb.setData(DyeColor.RED.getData());
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        newb.setData(DyeColor.ORANGE.getData());
                                    }

                                }.runTaskLater(plugin, 5L);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        newb.setData(DyeColor.RED.getData());

                                    }
                                }.runTaskLater(plugin, 10L);
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        newb.setType(Material.AIR);
                                    }
                                }.runTaskLater(plugin, 15L);
                            }
                        }
                    }
                }
            }
        }
    }
}








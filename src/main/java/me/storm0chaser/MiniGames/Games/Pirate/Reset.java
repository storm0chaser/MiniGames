package me.storm0chaser.MiniGames.Games.Pirate;

import com.sk89q.worldedit.EditSession;
import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;

public class Reset {

    public static void loadBase() throws  IOException{
        Location pirateworld = new Location(Bukkit.getWorld("pirate"), 79.500, 105, -5.500);
        File schematic = new File(Main.instance.getDataFolder() + File.separator+"/schematics/Pirate.schematic");
        EditSession session = WorldEditPlugin.getPlugin(WorldEditPlugin.class).getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(pirateworld.getWorld()), 99999999);

        try {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.paste(session, new com.sk89q.worldedit.Vector(pirateworld.getX(), pirateworld.getY(), pirateworld.getZ()), true);
            Bukkit.getServer().broadcastMessage("Pirate Boats Reset");

        }catch (MaxChangedBlocksException | DataException | IOException e){
            e.printStackTrace();
        }
    }







}

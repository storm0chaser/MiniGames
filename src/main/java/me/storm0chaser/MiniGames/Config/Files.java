package me.storm0chaser.MiniGames.Config;

import me.storm0chaser.MiniGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Files extends JavaPlugin {
    private static final Plugin plugin = Main.instance;

    public static void load(){
        LoadFile();
    }

    public static Boolean saveString(String file, String path, String message){
        boolean bool = SaveToFile(file, path, message);
        return bool;
    }
    public static void setToFile(String file, String path, HashSet<String> message){
        SetToFile(file, path,  message);
    }

    public static String getMessage(String file, String path){
        String msg = getMessageFromFile(file, path);
        return msg;
    }
    public static void SaveInt(String file, String path, long number){
        Saveint(file, path, number);
    }
    public static void Savebool(String file, String path, boolean message){
        savebool(file, path, message);
    }


    private static void LoadFile(){

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
            Main.Output("Created File");
        }
        File datafile = new File (plugin.getDataFolder(), "data.yml");
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);

        File messsagefile = new File (plugin.getDataFolder(), "messages.yml");
        InputStream ismessage = plugin.getResource("messages.yml");
        YamlConfiguration message = YamlConfiguration.loadConfiguration(ismessage);
        YamlConfiguration savemessage = YamlConfiguration.loadConfiguration(messsagefile);

        File configfile = new File (plugin.getDataFolder(), "config.yml");
        InputStream isconfig = plugin.getResource("config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(isconfig);
        YamlConfiguration saveconfig = YamlConfiguration.loadConfiguration(configfile);

        if(!datafile.exists()){
            try {
                datafile.createNewFile();
                data.save(datafile);
                Main.Output("Created Data File");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!configfile.exists()){
            try {
                configfile.createNewFile();
               config.save(configfile);
                Main.Output("Created Config File");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!messsagefile.exists()){
            try {
                messsagefile.createNewFile();
                message.save(messsagefile);
                Main.Output("Created Message File");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(savedata.getStringList("SpawnLocation") != null){
            World world = Bukkit.getWorld(savedata.getString("SpawnLocation.world"));
            int x = savedata.getInt("SpawnLocation.x");
            int y = savedata.getInt("SpawnLocation.y");
            int z = savedata.getInt("SpawnLocation.z");
            Main.SpawnLocation = new Location(world,x ,y ,z );

        }else{Main.Output("You need to set a spawn location");}
       Main.PlayerCount = savedata.getInt("PlayerCount");
       Main.TitleWelcomeEnable = saveconfig.getBoolean("TitleWelcomeEnable");
       Main.BarWelcomeEnable = saveconfig.getBoolean("BarWelcomeEnable");
       Main.WelcomeMsgEnable = saveconfig.getBoolean("WelcomeMsgEnable");
       Main.servername = saveconfig.getString("servername");
       Main.eventcountdown = savedata.getLong("EventCountdown");
       Main.BlackListedWords = new HashSet<String>(saveconfig.getStringList("BlackListedWords"));;
        Main.Output("Loaded Message File");
        Main.Output("Loaded Data File");
        Main.Output("Loaded Config File");

    }
    private static boolean SaveToFile(String file, String path, String message){
        File datafile = new File (plugin.getDataFolder(), file);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);

        if(datafile.exists()) {
            savedata.set(path, message);
            try {
                savedata.save(datafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{return false;}
    }


    private static void Saveint(String file, String path, long message){
        File datafile = new File (plugin.getDataFolder(), file);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);

        if(datafile.exists()) {
            savedata.set(path, message);
            try {
                savedata.save(datafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void savebool(String file, String path, boolean message){
        File datafile = new File (plugin.getDataFolder(), file);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);

        if(datafile.exists()) {
            savedata.set(path, message);
            try {
                savedata.save(datafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getMessageFromFile(String file, String path){
        File datafile = new File (plugin.getDataFolder(), file);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);
        String message = null;
        if(datafile.exists()){
                message = savedata.getString(path);
                Main.Output(message);
        }
        return message;
    }


    private static boolean SetToFile(String file, String path, HashSet<String> message){
        File datafile = new File (plugin.getDataFolder(), file);
        YamlConfiguration savedata = YamlConfiguration.loadConfiguration(datafile);
        InputStream isdata = plugin.getResource("data.yml");
        YamlConfiguration data = YamlConfiguration.loadConfiguration(isdata);

        if(datafile.exists()) {
            System.out.println(message.toString());
            savedata.set(path, new ArrayList<>(message));


            try {
                savedata.save(datafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{return false;}
    }
}

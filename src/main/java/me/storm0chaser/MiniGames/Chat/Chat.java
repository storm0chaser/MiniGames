package me.storm0chaser.MiniGames.Chat;

import com.avaje.ebeaninternal.server.lib.sql.Prefix;
import me.storm0chaser.MiniGames.Config.Messages;
import me.storm0chaser.MiniGames.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.context.DefaultContextKeys;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.ChatMetaNode;
import net.luckperms.api.node.types.PrefixNode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Collection;
import java.util.UUID;

public class Chat implements Listener {
    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent e){
        String[] split = e.getMessage().split(" ");
        e.setCancelled(true);
        String msg = e.getMessage();
        for(int i = 0; i < split.length; i++){
            if(Main.BlackListedWords.contains(split[i].toLowerCase())){
                for(String blm : Main.BlackListedWords){
                    if(blm.equalsIgnoreCase(split[i])){
                        e.getPlayer().sendMessage(Messages.BlackListedWord.replace("%word%", blm));
                        return;
                    }
                }
            }
        }

        LuckPerms api = LuckPermsProvider.get();
        UUID uuid = e.getPlayer().getUniqueId();

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(e.getPlayer());

        String suffix = "";
        String prefix = "";

        if(user.getCachedData().getMetaData().getPrefix() != null){prefix = ChatColor.translateAlternateColorCodes('&',user.getCachedData().getMetaData().getPrefix());}
        if(user.getCachedData().getMetaData().getSuffix() != null){prefix = ChatColor.translateAlternateColorCodes('&'," "+user.getCachedData().getMetaData().getSuffix());}
     //   String prefix = ChatColor.translateAlternateColorCodes('&',user.getCachedData().getMetaData().getPrefix());
     //   String suffix = ChatColor.translateAlternateColorCodes('&',user.getCachedData().getMetaData().getSuffix());



        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(Messages.ChatFormat.replace("%prefix%", ""+ prefix).replace("%player%", e.getPlayer().getName()).replace("%msg%", msg).replace("%suffix%", suffix));

        }
    }
}

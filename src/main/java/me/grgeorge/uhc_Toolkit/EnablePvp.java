package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnablePvp implements CommandExecutor {

    EventListener eventListener;

    EnablePvp(EventListener eventListener){
        this.eventListener = eventListener;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (((Player) commandSender).getPlayer());
            if(player.hasPermission(String.valueOf(true))){
                eventListener.enablePVP();
                Bukkit.broadcastMessage(ChatColor.GOLD + "PVP is now enabled!!");
            }else{
                player.sendMessage(ChatColor.RED + "you do not have permission to perform this command");
            }
        }

        return true;

    }
}

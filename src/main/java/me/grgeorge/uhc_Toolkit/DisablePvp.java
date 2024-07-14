package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class DisablePvp implements CommandExecutor {

    EventListener eventListener;

    DisablePvp(EventListener eventListener){
        this.eventListener = eventListener;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (((Player) commandSender).getPlayer());
            if(player.hasPermission(String.valueOf(true))){
                eventListener.disablePVP();
                Bukkit.broadcastMessage(ChatColor.RED + "PVP is now disabled!!");
            }else{
                player.sendMessage(ChatColor.RED + "you do not have permission to perform this command");
            }
        }

        return true;

    }
}

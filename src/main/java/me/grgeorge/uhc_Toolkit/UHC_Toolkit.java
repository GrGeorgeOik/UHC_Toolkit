package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ObjectInputStream;

public final class UHC_Toolkit extends JavaPlugin {
    public static final String BLUE = "\u001B[34m";

    @Override
    public void onEnable() {
        // Plugin startup login
        getServer().getConsoleSender().sendMessage(BLUE + "UHC Toolkit has started");
        getServer().getConsoleSender().sendMessage(BLUE + "CUSTOMIZATION IS COMING SOON SO STAY ALERT WHEN I RELEASE THE NEWEST VERSION ON SPIGOT MC");

        new Recipes(this);

        EventListener eventListener = new EventListener(this);

        getCommand("pvp_enable").setExecutor(new EnablePvp(eventListener));

        getCommand("pvp_disable").setExecutor(new DisablePvp(eventListener));

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ObjectInputStream;

public final class UHC_Toolkit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup login
        Bukkit.getLogger().info("UHC Toolkit has started");

        EventListener eventListener = new EventListener(this);

        getCommand("pvp_enable").setExecutor(new EnablePvp(eventListener));

        getCommand("pvp_disable").setExecutor(new DisablePvp(eventListener));

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

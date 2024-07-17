package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class UHC_Toolkit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup login
        getLogger().warning("UHC Toolkit has started");
        getLogger().warning("CUSTOMIZATION IS COMING SOON SO STAY ALERT WHEN I RELEASE THE NEWEST VERSION ON SPIGOT MC");

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

package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventListener implements Listener {

    UHC_Toolkit uhcToolkit;
    Location deathLocation;
    boolean pvpStatus = false;

    EventListener(UHC_Toolkit uhcToolkit){

        this.uhcToolkit = uhcToolkit;

        Bukkit.getPluginManager().registerEvents(this,this.uhcToolkit);

    }

    public void enablePVP(){

        pvpStatus = true;

    }

    public void disablePVP(){

        pvpStatus = false;

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();

        player.setGameMode(GameMode.SPECTATOR);

    }
    @EventHandler
    public void pvpOff(EntityDamageByEntityEvent event){

        if (pvpStatus){

            return;

        }
        if (!(event.getDamager() instanceof Player && event.getEntity() instanceof Player)){

            return;


        }

        event.setCancelled(true);


    }
}
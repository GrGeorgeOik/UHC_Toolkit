//SPECIAL THANKS TO EPICGAMERGR FOR PROVIDING PART OF THIS CODE TO MAKE OUR LIVES A LOT EASIER AND TO
//CREATE THE BEST UHC TOOLKIT IN THE WORLD
//CUSTOMIZATION IS COMING SOON SO STAY ALERT WHEN I RELEASE THE NEWEST VERSION ON SPIGOT MC
package me.grgeorge.uhc_Toolkit;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class EventListener implements Listener {

    Location deathLocation;
    boolean pvpStatus = false;
    UHC_Toolkit uhcToolkit;

    EventListener(UHC_Toolkit uhcToolkit){

        this.uhcToolkit = uhcToolkit;
        Bukkit.getPluginManager().registerEvents(this,this.uhcToolkit);
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent e){
        Player player = (Player) e.getEntity();

        ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta itemMeta = playerhead.getItemMeta();
        SkullMeta skullMeta = (SkullMeta) itemMeta;

        UUID uuid = player.getUniqueId();
        skullMeta.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));

        itemMeta.setFireResistant(true);
        playerhead.setItemMeta(itemMeta);

        player.getWorld().dropItemNaturally(player.getLocation(),playerhead);
    }
//---------------BY EPICGAMER-------------------------------------------------------------------------------------------
    @EventHandler
    public void interact(PlayerInteractEvent e){

        Player player = (Player) e.getPlayer();
        if (!e.getItem().getItemMeta().isUnbreakable()){
            return;
        }
        e.getItem().setAmount(e.getItem().getAmount()-1);

        PotionEffect potionEffect2 = new PotionEffect(PotionEffectType.REGENERATION,96,2);
        PotionEffect potionEffect1 = new PotionEffect(PotionEffectType.ABSORPTION,20*60,0);
        PotionEffect potionEffect3 = new PotionEffect(PotionEffectType.FIRE_RESISTANCE,20*20,0);

        player.addPotionEffect(potionEffect1);
        player.addPotionEffect(potionEffect2);
        player.addPotionEffect(potionEffect3);
//----------------------------------------------------------------------------------------------------------------------
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
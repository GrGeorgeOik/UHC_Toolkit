//SPECIAL THANKS TO EPICGAMERGR FOR PROVIDING PART OF THIS CODE TO MAKE OUR LIVES A LOT EASIER AND TO
//CREATE THE BEST UHC TOOLKIT IN THE WORLD
//CUSTOMIZATION IS COMING SOON SO STAY ALERT WHEN I RELEASE THE NEWEST VERSION ON SPIGOT MC
package me.grgeorge.uhc_Toolkit;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
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

        if (e.getItem() == null){
            return;
        }

        if (!e.getItem().getItemMeta().isUnbreakable()){
            return;
        }

        Player player = e.getPlayer();
        ItemStack itemStack = e.getItem();

        if (e.getItem().getType().equals(Material.GOLDEN_APPLE)){
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);

            PotionEffect potionEffect2 = new PotionEffect(PotionEffectType.REGENERATION,96,2);
            PotionEffect potionEffect1 = new PotionEffect(PotionEffectType.ABSORPTION,2060,0);
            PotionEffect potionEffect3 = new PotionEffect(PotionEffectType.FIRE_RESISTANCE,2020,0);

            player.addPotionEffect(potionEffect1);
            player.addPotionEffect(potionEffect2);
            player.addPotionEffect(potionEffect3);
        }
        else if (e.getItem().getType().equals(Material.PLAYER_HEAD)){
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);

            ItemMeta itemMeta = itemStack.getItemMeta();
            SkullMeta skullMeta = (SkullMeta) itemMeta;

            Player revivePlayer = skullMeta.getOwningPlayer().getPlayer();
            if (revivePlayer != null){
                player.getWorld().playSound(player.getLocation(), Sound.ITEM_TOTEM_USE,1, 1);
                revivePlayer.teleport(player.getLocation());
                revivePlayer.setGameMode(GameMode.SURVIVAL);
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + revivePlayer.getName() + " was revived");
                revivePlayer.setHealth(16);
            }
        }

        //Remove one item
        e.getItem().setAmount(e.getItem().getAmount()-1);
    }

    @EventHandler
    public void craftItem(CraftItemEvent e){
        ItemStack ResultitemStack = e.getInventory().getResult();

        if (!ResultitemStack.getType().equals(Material.PLAYER_HEAD)) {
            return;
        }

        ItemStack itemStack = e.getInventory().getMatrix()[4];
        ItemMeta itemMeta = itemStack.getItemMeta();
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        UUID uuid = skullMeta.getOwnerProfile().getUniqueId();

        ItemMeta ResultItemMeta = ResultitemStack.getItemMeta();
        SkullMeta ResultSkullMeta = (SkullMeta) ResultItemMeta;
        ResultSkullMeta.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));
        ResultitemStack.setItemMeta(ResultItemMeta);
    }




//----------------------------------------------------------------------------------------------------------------------


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
//----if your name is not mrduty ignore-------------------------------------
        if (player.getName().toString().equals("mrduty")){
            player.sendMessage(ChatColor.RED + "WRAIA TR POU EISAI NEKROS STEILE TO BACKUP!");
        }


    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){

        event.setRespawnLocation(event.getPlayer().getLocation());

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
    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.getName().toString().equals("GrGeorge_oik")){

            event.setJoinMessage(ChatColor.RED + "[Admin] " + ChatColor.YELLOW + player.getDisplayName() + " joined the game");
        } else if (player.getName().toString().equals("EpicGamerGR")) {

            event.setJoinMessage(ChatColor.RED + "[Admin] " + ChatColor.YELLOW + player.getDisplayName() + " joined the game");

        }else{
            event.setJoinMessage(ChatColor.YELLOW + player.getDisplayName() + " joined the game");
        }


    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        Player player = event.getPlayer();

        if (player.getName().toString().equals("GrGeorge_oik")){
            event.setQuitMessage(ChatColor.RED + "[Admin] " + ChatColor.YELLOW + player.getDisplayName() + " left the game");

        } else if (player.getName().toString().equals("EpicGamerGR")) {
            event.setQuitMessage(ChatColor.RED + "[Admin] " + ChatColor.YELLOW + player.getDisplayName() + " left the game");
        }else{
            event.setQuitMessage(ChatColor.YELLOW + player.getName() + " left the game");
        }

    }

    

}
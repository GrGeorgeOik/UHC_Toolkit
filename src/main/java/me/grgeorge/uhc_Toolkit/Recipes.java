//CREDIT TO EPICGAMERGR FOR MAKING THIS PLUGIN ACCESSIBLE TO ME SO I CAN IMPLEMENT IT TO MY PROJECT
//MAKING OUR LIVES A LOT EASIER
//---------------BY EPICGAMER-------------------------------------------------------------------------------------------
package me.grgeorge.uhc_Toolkit;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class Recipes {
    UHC_Toolkit uhcToolkit;

    Recipes(UHC_Toolkit uhcToolkit){
        this.uhcToolkit = uhcToolkit;
        goldenHead(this.uhcToolkit);
        reviveHead(this.uhcToolkit);
    }

    private void goldenHead(UHC_Toolkit uhcGoldenHeads){
        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE,1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("GOLDEN HEAD");
        itemMeta.setUnbreakable(true);
        ArrayList<String> lore =  new ArrayList<>();
        lore.add("regeneration III : 4 hearts");
        lore.add("absorption I : 60sec");
        lore.add("Fire resistance I : 20sec");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(uhcGoldenHeads,"golden_head"),itemStack);

        shapedRecipe.shape("GGG","GHG","GGG");
        shapedRecipe.setIngredient('G',Material.GOLD_INGOT);
        shapedRecipe.setIngredient('H',Material.PLAYER_HEAD);

        getServer().addRecipe(shapedRecipe);
    }

    private void reviveHead(UHC_Toolkit uhcGoldenHeads){
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("REVIVE HEAD");
        itemMeta.setUnbreakable(true);
        ArrayList<String> lore =  new ArrayList<>();
        lore.add("Use it to revive the player");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);

        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(uhcGoldenHeads,"revive_head"),itemStack);

        shapedRecipe.shape("ADA","DHD","ADA");
        shapedRecipe.setIngredient('A',Material.AIR);
        shapedRecipe.setIngredient('D',Material.DIAMOND);
        shapedRecipe.setIngredient('H',Material.PLAYER_HEAD);

        getServer().addRecipe(shapedRecipe);
    }
}
//----------------------------------------------------------------------------------------------------------------------
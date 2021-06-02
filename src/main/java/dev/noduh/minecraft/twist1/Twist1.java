package dev.noduh.minecraft.twist1;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class Twist1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemStack helmet, chestplate, leggings, boots, sword, shield, pick, axe, hoe, shovel, shears; // items
        ShapedRecipe rHelmet, rChestplate, rLeggings, rBoots, rSword, rShield, rPick, rAxe, rHoe, rShovel, rShears, rBucket; // recipes

        HashMap<Enchantment, Integer> armorEnchants = new HashMap<Enchantment, Integer>(); // armor enchant list
            armorEnchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
            armorEnchants.put(Enchantment.PROTECTION_FALL, 5);
            armorEnchants.put(Enchantment.DURABILITY, 3);
            armorEnchants.put(Enchantment.MENDING, 1);
            armorEnchants.put(Enchantment.THORNS, 3);

        HashMap<Enchantment, Integer> toolEnchants = new HashMap<Enchantment, Integer>(); // tool enchant list
            toolEnchants.put(Enchantment.DAMAGE_ALL, 5);
            toolEnchants.put(Enchantment.DURABILITY, 3);
            toolEnchants.put(Enchantment.MENDING, 1);
            toolEnchants.put(Enchantment.DIG_SPEED, 5);
            toolEnchants.put(Enchantment.LOOT_BONUS_BLOCKS, 3);
            toolEnchants.put(Enchantment.LOOT_BONUS_MOBS, 3);

        ArrayList<ItemStack> armor = new ArrayList<ItemStack>(); // armor list
            armor.add(helmet = new ItemStack(Material.IRON_HELMET));
            armor.add(chestplate = new ItemStack(Material.IRON_CHESTPLATE));
            armor.add(leggings = new ItemStack(Material.IRON_LEGGINGS));
            armor.add(boots = new ItemStack(Material.IRON_BOOTS));

        ArrayList<ItemStack> tools = new ArrayList<ItemStack>(); // tool list
            tools.add(sword = new ItemStack(Material.IRON_SWORD));
            tools.add(pick = new ItemStack(Material.IRON_PICKAXE));
            tools.add(axe = new ItemStack(Material.IRON_AXE));
            tools.add(hoe = new ItemStack(Material.IRON_HOE));
            tools.add(shovel = new ItemStack(Material.IRON_SHOVEL));
            tools.add(shield = new ItemStack(Material.SHIELD));
            tools.add(shears = new ItemStack(Material.SHEARS));

        for (ItemStack i : armor) { // enchant the armor
            i.addUnsafeEnchantments(armorEnchants);
        }
        for (ItemStack i : tools) { // enchant the tools
            i.addUnsafeEnchantments(toolEnchants);
        }

        ArrayList<ShapedRecipe> recipes = new ArrayList<ShapedRecipe>(); // setting all the recipes
            recipes.add(rHelmet = new ShapedRecipe(new NamespacedKey(this, "twist_helmet"), helmet).shape("***", "* *"));
            recipes.add(rChestplate = new ShapedRecipe(new NamespacedKey(this, "twist_chestplate"), chestplate).shape("* *", "***", "***"));
            recipes.add(rLeggings = new ShapedRecipe(new NamespacedKey(this, "twist_leggings"), leggings).shape("***", "* *", "* *"));
            recipes.add(rBoots = new ShapedRecipe(new NamespacedKey(this, "twist_Boots"), boots).shape("* *", "* *"));
            recipes.add(rShears = new ShapedRecipe(new NamespacedKey(this, "twist_shears"), shears).shape(" *", "* "));
            recipes.add(rSword = new ShapedRecipe(new NamespacedKey(this, "twist_sword"), sword).shape("*", "*", "/"));
            recipes.add(rShield = new ShapedRecipe(new NamespacedKey(this, "twist_shield"), shield).shape("/*/", "///", " / "));
            recipes.add(rPick = new ShapedRecipe(new NamespacedKey(this, "twist_pick"), pick).shape("***", " / ", " / "));
            recipes.add(rAxe = new ShapedRecipe(new NamespacedKey(this, "twist_axe"), axe).shape("**", "*/", " /"));
            recipes.add(rHoe = new ShapedRecipe(new NamespacedKey(this, "twist_hoe"), hoe).shape("**", " /", " /"));
            recipes.add(rShovel = new ShapedRecipe(new NamespacedKey(this, "twist_shovel"), shovel).shape("*", "/", "/"));

        for (ShapedRecipe r : recipes) {
            r.setIngredient('*', Material.IRON_NUGGET);
            if (recipes.indexOf(r) > 4) { r.setIngredient('/', Material.STICK); } // only add the stick if it's a recipe with a stick
        }

        for (ShapedRecipe r : recipes) { getServer().addRecipe(r); }
    }

    @Override
    public void onDisable() {
    }
}
package com.github.theonepath.moreores.tools;

import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/* maybe change the name of this class to not be confused with Forge#RecipeManager */
public class MachineManager {
    public static Map<Item, Item> AlloyList = new HashMap<Item, Item>();
    public static Map<Item, Object[]> RefineryList = new HashMap<Item, Object[]>();

    public static void init() {
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.ALUM_ORE), new Object[]{ItemList.ALUM_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.COPPER_ORE), new Object[]{ItemList.COPPER_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.LEAD_ORE), new Object[]{ItemList.LEAD_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.NICKEL_ORE), new Object[]{ItemList.NICKEL_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.SILVER_ORE), new Object[]{ItemList.SILVER_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.TIN_ORE), new Object[]{ItemList.TIN_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(BlockList.ZINC_ORE), new Object[]{ItemList.ZINC_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(Blocks.IRON_ORE), new Object[]{ItemList.IRON_CHUNK, 2});
        RefineryList.put(Item.BLOCK_TO_ITEM.get(Blocks.GOLD_ORE), new Object[]{ItemList.GOLD_CHUNK, 2});
        RefineryList.put(ItemList.ALUM_CHUNK, new Object[]{ItemList.ALUM_DUST});
        RefineryList.put(ItemList.COPPER_CHUNK, new Object[]{ItemList.COPPER_DUST});
        RefineryList.put(ItemList.LEAD_CHUNK, new Object[]{ItemList.LEAD_DUST});
        RefineryList.put(ItemList.NICKEL_CHUNK, new Object[]{ItemList.NICKEL_DUST});
        RefineryList.put(ItemList.SILVER_CHUNK, new Object[]{ItemList.SILVER_DUST});
        RefineryList.put(ItemList.TIN_CHUNK, new Object[]{ItemList.TIN_DUST});
        RefineryList.put(ItemList.ZINC_CHUNK, new Object[]{ItemList.ZINC_DUST});
        RefineryList.put(ItemList.IRON_CHUNK, new Object[]{ItemList.IRON_DUST});
        RefineryList.put(ItemList.GOLD_CHUNK, new Object[]{ItemList.GOLD_DUST});
        RefineryList.put(Items.COBBLESTONE, new Object[]{Items.GRAVEL});
        RefineryList.put(Items.GRAVEL, new Object[]{Items.SAND, Items.FLINT});
    }

    /**
     * Check if the ItemStack can be refined by the Refinery.
     *
     * @param item ItemStack
     * @return true if ItemStack can be refined.
     */
    public static boolean canRefine(ItemStack item) {
        for (Map.Entry<Item, ?> entry : RefineryList.entrySet()) {
            if (entry.getKey() == item.getItem()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns an array of items that are the results of the ingredient.
     * The array is empty if <b>type</b> isn't valid.
     *
     * @param item ItemStack
     * @param type String, recipe types: "refinery" | "alloy"
     * @return Object[]
     */
    public static Object[] getRecipeResult(ItemStack item, @Nonnull String type) {
        switch (type.toLowerCase()) {
            case "refinery":
                for (Map.Entry<Item, Object[]> entry : RefineryList.entrySet()) {
                    if (entry.getKey() == item.getItem()) {
                        return entry.getValue();
                    }
                }
                break;
            case "alloy":
                break;
        }

        return new Item[0];
    }
}

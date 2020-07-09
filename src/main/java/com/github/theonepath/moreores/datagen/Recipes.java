package com.github.theonepath.moreores.datagen;

import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(BlockList.GENERATOR)
                .patternLine("sss")
                .patternLine("cfc")
                .patternLine("sbs")
                .key('s', Blocks.STONE_BRICKS)
                .key('c', ItemList.CAPACITOR)
                .key('f', Blocks.FURNACE)
                .key('b', ItemList.BATTERY)
                .setGroup("moreores")
                .addCriterion("furnace", InventoryChangeTrigger.Instance.forItems(Blocks.FURNACE))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BlockList.POWERBANK)
                .patternLine("iii")
                .patternLine("bbb")
                .patternLine("iii")
                .key('i', ItemList.IRON_PLATE)
                .key('b', BlockList.BATTERY_PACK)
                .setGroup("moreores")
                .addCriterion("battery_pack", InventoryChangeTrigger.Instance.forItems(BlockList.BATTERY_PACK))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BlockList.REFINERY)
                .patternLine("iii")
                .patternLine("dfd")
                .patternLine("ibi")
                .key('i', ItemList.IRON_PLATE)
                .key('d', ItemList.DIAMOND_COG)
                .key('f', Blocks.FURNACE)
                .key('b', ItemList.BATTERY)
                .setGroup("moreores")
                .addCriterion("furnace", InventoryChangeTrigger.Instance.forItems(Blocks.FURNACE))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.STONE_COG)
                .patternLine("scs")
                .patternLine("c c")
                .patternLine("scs")
                .key('s', Items.STICK)
                .key('c', Blocks.COBBLESTONE)
                .setGroup("moreores")
                .addCriterion("cobblestone", InventoryChangeTrigger.Instance.forItems(Items.STICK, Blocks.COBBLESTONE))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.IRON_COG)
                .patternLine(" i ")
                .patternLine("isi")
                .patternLine(" i ")
                .key('s', ItemList.STONE_COG)
                .key('i', Items.IRON_INGOT)
                .setGroup("moreores")
                .addCriterion("stone_cog", InventoryChangeTrigger.Instance.forItems(ItemList.STONE_COG))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.GOLDEN_COG)
                .patternLine(" g ")
                .patternLine("gig")
                .patternLine(" g ")
                .key('i', ItemList.IRON_COG)
                .key('g', Items.GOLD_INGOT)
                .setGroup("moreores")
                .addCriterion("iron_cog", InventoryChangeTrigger.Instance.forItems(ItemList.IRON_COG))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(ItemList.DIAMOND_COG)
                .patternLine(" d ")
                .patternLine("dgd")
                .patternLine(" d ")
                .key('g', ItemList.GOLDEN_COG)
                .key('d', Items.DIAMOND)
                .setGroup("moreores")
                .addCriterion("golden_cog", InventoryChangeTrigger.Instance.forItems(ItemList.GOLDEN_COG))
                .build(consumer);
    }

}

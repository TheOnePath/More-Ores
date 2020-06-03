package com.github.theonepath.moreores.datagen;

import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

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
    }
}

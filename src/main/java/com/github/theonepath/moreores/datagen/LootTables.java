package com.github.theonepath.moreores.datagen;

import com.github.theonepath.moreores.lists.BlockList;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockList.GENERATOR, createStandTable("generator", BlockList.GENERATOR));
    }
}

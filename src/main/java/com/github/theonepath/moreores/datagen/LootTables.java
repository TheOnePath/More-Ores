package com.github.theonepath.moreores.datagen;

import com.github.theonepath.moreores.lists.BlockList;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockList.GENERATOR, createEnergyTable("generator", BlockList.GENERATOR));
        lootTables.put(BlockList.POWERBANK, createEnergyTable("power_bank", BlockList.POWERBANK));
        lootTables.put(BlockList.REFINERY, createEnergyTable("refinery", BlockList.REFINERY));
        lootTables.put(BlockList.ELECTRIC_GENERATOR, createEnergyTable("electric_generator", BlockList.ELECTRIC_GENERATOR));
//        lootTables.put(BlockList.ELECTRIC_BLAST_FURNACE, createEnergyTable("electric_blast_furnace", BlockList.ELECTRIC_BLAST_FURNACE));
        lootTables.put(BlockList.BATTERY_PACK, createStandardTable("battery_pack", BlockList.BATTERY_PACK));
    }
}

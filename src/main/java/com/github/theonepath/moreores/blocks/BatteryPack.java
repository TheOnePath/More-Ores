package com.github.theonepath.moreores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BatteryPack extends Block {

    public BatteryPack() {
        super(Properties.create(Material.ANVIL)
                .hardnessAndResistance(2.0f)
                .sound(SoundType.ANVIL)
        );
        setRegistryName("battery_pack");
    }
}

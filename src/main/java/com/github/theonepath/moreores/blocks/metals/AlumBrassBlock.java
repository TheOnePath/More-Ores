package com.github.theonepath.moreores.blocks.metals;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AlumBrassBlock extends Block {

    public AlumBrassBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
        );
        setRegistryName("alumbrass_block");
    }
}

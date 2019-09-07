package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.MoreOres;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;

public class BlockList {
	private static String id = MoreOres.MODID;
	
	public static final Block ALUM_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(id, "alum_ore");
	public static final Block COPPER_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)).setRegistryName(id, "copper_ore");
	public static final Block LEAD_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.1F)).setRegistryName(id, "lead_ore");
	public static final Block NICKEL_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F)).setRegistryName(id, "nickel_ore");
	public static final Block SILVER_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.9F)).setRegistryName(id, "silver_ore");
	public static final Block TIN_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F)).setRegistryName(id, "tin_ore");
	public static final Block ZINC_ORE = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F)).setRegistryName(id, "zinc_ore");
	
}


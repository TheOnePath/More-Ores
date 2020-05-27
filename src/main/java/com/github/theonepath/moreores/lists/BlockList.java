package com.github.theonepath.moreores.lists;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;


public class BlockList
{
	private static String id = "moreores";

	// Ores
	public static final Block ALUM_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "alum_ore");
	public static final Block COPPER_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "copper_ore");
	public static final Block LEAD_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.1F))).setRegistryName(id, "lead_ore");
	public static final Block NICKEL_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "nickel_ore");
	public static final Block SILVER_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.9F))).setRegistryName(id, "silver_ore");
	public static final Block TIN_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "tin_ore");
	public static final Block ZINC_ORE = (Block)(new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "zinc_ore");

	// Blocks
	public static final Block ALUM = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "alum_block");
	public static final Block ALUM_BRASS = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "alumbrass_block");
	public static final Block BRONZE = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "bronze_block");
	public static final Block BRASS = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "brass_block");
	public static final Block COPPER = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F))).setRegistryName(id, "copper_block");
	public static final Block LEAD = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.1F))).setRegistryName(id, "lead_block");
	public static final Block NICKEL = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "nickel_block");
	public static final Block SILVER = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.9F))).setRegistryName(id, "silver_block");
	public static final Block TIN = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "tin_block");
	public static final Block ZINC = (Block)(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 2.8F))).setRegistryName(id, "zinc_block");
}

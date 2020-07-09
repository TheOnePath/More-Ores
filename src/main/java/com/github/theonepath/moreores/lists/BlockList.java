package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.blocks.*;
import com.github.theonepath.moreores.blocks.container.*;
import com.github.theonepath.moreores.blocks.metals.*;
import com.github.theonepath.moreores.blocks.ores.*;
import com.github.theonepath.moreores.blocks.tileentity.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;


public class BlockList {
	private static final String id = "moreores";

	// Blocks
	@ObjectHolder(id + ":generator")
	public static Generator GENERATOR;

	@ObjectHolder(id + ":generator")
	public static TileEntityType<GeneratorTileEntity> GENERATOR_TILE;

	@ObjectHolder(id + ":generator")
	public static ContainerType<GeneratorContainer> GENERATOR_CONTAINER;

	@ObjectHolder(id + ":electric_generator")
	public static ElectricGenerator ELECTRIC_GENERATOR;

	@ObjectHolder(id + ":electric_generator")
	public static TileEntityType<ElectricGeneratorTileEntity> ELECTRIC_GENERATOR_TILE;

	@ObjectHolder(id + ":electric_generator")
	public static ContainerType<ElectricGeneratorContainer> ELECTRIC_GENERATOR_CONTAINER;

	@ObjectHolder(id + ":electric_blast_furnace")
	public static ElectricBlastFurnace ELECTRIC_BLAST_FURNACE;

	@ObjectHolder(id + ":electric_blast_furnace")
	public static TileEntityType<ElectricBlastFurnaceTileEntity> ELECTRIC_BLAST_FURNACE_TILE;

	@ObjectHolder(id + ":electric_blast_furnace")
	public static ContainerType<ElectricBlastFurnaceContainer> ELECTRIC_BLAST_FURNACE_CONTAINER;

	@ObjectHolder(id + ":power_bank")
	public static PowerBank POWERBANK;

	@ObjectHolder(id + ":power_bank")
	public static TileEntityType<PowerBankTileEntity> POWERBANK_TILE;

	@ObjectHolder(id + ":power_bank")
	public static ContainerType<PowerBankContainer> POWERBANK_CONTAINER;

	@ObjectHolder(id + ":refinery")
	public static Refinery REFINERY;

	@ObjectHolder(id + ":refinery")
	public static TileEntityType<RefineryTileEntity> REFINERY_TILE;

	@ObjectHolder(id + ":refinery")
	public static ContainerType<RefineryContainer> REFINERY_CONTAINER;

	@ObjectHolder(id + ":battery_pack")
	public static BatteryPack BATTERY_PACK;

	// Ores
	@ObjectHolder(id + ":alum_ore")
	public static AlumOre ALUM_ORE;

	@ObjectHolder(id + ":copper_ore")
	public static CopperOre COPPER_ORE;

	@ObjectHolder(id + ":lead_ore")
	public static LeadOre LEAD_ORE;

	@ObjectHolder(id + ":nickel_ore")
	public static NickelOre NICKEL_ORE;

	@ObjectHolder(id + ":silver_ore")
	public static SilverOre SILVER_ORE;

	@ObjectHolder(id + ":tin_ore")
	public static TinOre TIN_ORE;

	@ObjectHolder(id + ":zinc_ore")
	public static ZincOre ZINC_ORE;

	// Metal Blocks
	@ObjectHolder(id + ":alum_block")
	public static AlumBlock ALUM_BLOCK;

	@ObjectHolder(id + ":alumbrass_block")
	public static AlumBrassBlock ALUMBRASS_BLOCK;

	@ObjectHolder(id + ":brass_block")
	public static BrassBlock BRASS_BLOCK;

	@ObjectHolder(id + ":bronze_block")
	public static BronzeBlock BRONZE_BLOCK;

	@ObjectHolder(id + ":copper_block")
	public static CopperBlock COPPER_BLOCK;

	@ObjectHolder(id + ":lead_block")
	public static LeadBlock LEAD_BLOCK;

	@ObjectHolder(id + ":nickel_block")
	public static NickelBlock NICKEL_BLOCK;

	@ObjectHolder(id + ":silver_block")
	public static SilverBlock SILVER_BLOCK;

	@ObjectHolder(id + ":tin_block")
	public static TinBlock TIN_BLOCK;

	@ObjectHolder(id + ":zinc_block")
	public static ZincBlock ZINC_BLOCK;
}

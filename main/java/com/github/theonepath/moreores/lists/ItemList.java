package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.MoreOres;
import com.github.theonepath.moreores.items.ToolPulveriser;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemList {
	private static String id = MoreOres.MODID;
	private static ItemGroup creativetab = MoreOres.MORE_ORES;
	// BlockItem
	public static final Item ALUM_ORE = new BlockItem(BlockList.ALUM_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.ALUM_ORE.getRegistryName());
	public static final Item COPPER_ORE = new BlockItem(BlockList.COPPER_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.COPPER_ORE.getRegistryName());
	public static final Item LEAD_ORE = new BlockItem(BlockList.LEAD_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.LEAD_ORE.getRegistryName());
	public static final Item NICKEL_ORE = new BlockItem(BlockList.NICKEL_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.NICKEL_ORE.getRegistryName());
	public static final Item SILVER_ORE = new BlockItem(BlockList.SILVER_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.SILVER_ORE.getRegistryName());
	public static final Item TIN_ORE = new BlockItem(BlockList.TIN_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.TIN_ORE.getRegistryName());
	public static final Item ZINC_ORE = new BlockItem(BlockList.ZINC_ORE, new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(BlockList.ZINC_ORE.getRegistryName());
	// Item
	public static final Item PULVERISER = new ToolPulveriser(new Item.Properties().group(creativetab).maxStackSize(1)).setRegistryName(new ResourceLocation(id, "pulveriser_tool"));
	public static final Item ALUM_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "aluminium_ingot"));
	public static final Item ALUMBRASS_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "alumbrass_ingot"));
	public static final Item BRASS_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "brass_ingot"));
	public static final Item BRONZE_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "bronze_ingot"));
	public static final Item COPPER_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "copper_ingot"));
	public static final Item LEAD_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "lead_ingot"));
	public static final Item NICKEL_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "nickel_ingot"));
	public static final Item SILVER_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "silver_ingot"));
	public static final Item TIN_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "tin_ingot"));
	public static final Item ZINC_INGOT = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "zinc_ingot"));
	public static final Item ALUM_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "aluminium_dust"));
	public static final Item COPPER_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "copper_dust"));
	public static final Item LEAD_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "lead_dust"));
	public static final Item NICKEL_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "nickel_dust"));
	public static final Item SILVER_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "silver_dust"));
	public static final Item TIN_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "tin_dust"));
	public static final Item ZINC_DUST = new Item(new Item.Properties().group(creativetab).maxStackSize(64)).setRegistryName(new ResourceLocation(id, "zinc_dust"));
}

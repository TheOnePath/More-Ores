package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.MoreOres;
import com.github.theonepath.moreores.items.RockGrinderDiamond;
import com.github.theonepath.moreores.items.RockGrinderEmerald;
import com.github.theonepath.moreores.items.RockGrinderGold;
import com.github.theonepath.moreores.items.RockGrinderIron;
import com.github.theonepath.moreores.items.RockGrinderStone;
import com.github.theonepath.moreores.items.RockGrinderUnbreakable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemList
{
  private static String id = "moreores";
  private static ItemGroup creativetab = MoreOres.MORE_ORES;
  
  public static final Item ALUM_ORE = (Item)(new BlockItem(BlockList.ALUM_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.ALUM_ORE.getRegistryName());
  public static final Item COPPER_ORE = (Item)(new BlockItem(BlockList.COPPER_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.COPPER_ORE.getRegistryName());
  public static final Item LEAD_ORE = (Item)(new BlockItem(BlockList.LEAD_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.LEAD_ORE.getRegistryName());
  public static final Item NICKEL_ORE = (Item)(new BlockItem(BlockList.NICKEL_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.NICKEL_ORE.getRegistryName());
  public static final Item SILVER_ORE = (Item)(new BlockItem(BlockList.SILVER_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.SILVER_ORE.getRegistryName());
  public static final Item TIN_ORE = (Item)(new BlockItem(BlockList.TIN_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.TIN_ORE.getRegistryName());
  public static final Item ZINC_ORE = (Item)(new BlockItem(BlockList.ZINC_ORE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.ZINC_ORE.getRegistryName());
  public static final Item ALUM = (Item)(new BlockItem(BlockList.ALUM, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.ALUM.getRegistryName());
  public static final Item COPPER = (Item)(new BlockItem(BlockList.COPPER, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.COPPER.getRegistryName());
  public static final Item LEAD = (Item)(new BlockItem(BlockList.LEAD, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.LEAD.getRegistryName());
  public static final Item NICKEL = (Item)(new BlockItem(BlockList.NICKEL, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.NICKEL.getRegistryName());
  public static final Item SILVER = (Item)(new BlockItem(BlockList.SILVER, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.SILVER.getRegistryName());
  public static final Item TIN = (Item)(new BlockItem(BlockList.TIN, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.TIN.getRegistryName());
  public static final Item ZINC = (Item)(new BlockItem(BlockList.ZINC, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.ZINC.getRegistryName());
  public static final Item ALUM_BRASS = (Item)(new BlockItem(BlockList.ALUM_BRASS, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.ALUM_BRASS.getRegistryName());
  public static final Item BRONZE = (Item)(new BlockItem(BlockList.BRONZE, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.BRONZE.getRegistryName());
  public static final Item BRASS = (Item)(new BlockItem(BlockList.BRASS, (new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(BlockList.BRASS.getRegistryName());

  
  public static final Item ROCK_GRINDER_STONE = (Item)(new RockGrinderStone(ToolMaterialList.rock_grinder_stone_material, 4, -2.8F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_stone"));
  public static final Item ROCK_GRINDER_IRON = (Item)(new RockGrinderIron(ToolMaterialList.rock_grinder_iron_material, 5, -2.8F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_iron"));
  public static final Item ROCK_GRINDER_GOLD = (Item)(new RockGrinderGold(ToolMaterialList.rock_grinder_gold_material, 3, -2.8F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_gold"));
  public static final Item ROCK_GRINDER_DIAMOND = (Item)(new RockGrinderDiamond(ToolMaterialList.rock_grinder_diamond_material, 6, -2.8F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_diamond"));
  public static final Item ROCK_GRINDER_EMERALD = (Item)(new RockGrinderEmerald(ToolMaterialList.rock_grinder_emerald_material, 6, -2.8F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_emerald"));
  public static final Item ROCK_GRINDER_UNBREAKABLE = (Item)(new RockGrinderUnbreakable(ToolMaterialList.rock_grinder_unbreakable_material, 7, -2.6F, (new Item.Properties()).group(creativetab))).setRegistryName(new ResourceLocation(id, "rock_grinder_unbreakable"));

  
  public static final Item ALUM_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alum_ingot"));
  public static final Item ALUMBRASS_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alumbrass_ingot"));
  public static final Item BRASS_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "brass_ingot"));
  public static final Item BRONZE_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "bronze_ingot"));
  public static final Item COPPER_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "copper_ingot"));
  public static final Item LEAD_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "lead_ingot"));
  public static final Item NICKEL_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "nickel_ingot"));
  public static final Item SILVER_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "silver_ingot"));
  public static final Item TIN_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "tin_ingot"));
  public static final Item ZINC_INGOT = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "zinc_ingot"));

  
  public static final Item ALUM_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alum_nugget"));
  public static final Item ALUMBRASS_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alumbrass_nugget"));
  public static final Item BRASS_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "brass_nugget"));
  public static final Item BRONZE_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "bronze_nugget"));
  public static final Item COPPER_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "copper_nugget"));
  public static final Item LEAD_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "lead_nugget"));
  public static final Item NICKEL_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "nickel_nugget"));
  public static final Item SILVER_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "silver_nugget"));
  public static final Item TIN_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "tin_nugget"));
  public static final Item ZINC_NUGGET = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "zinc_nugget"));

  
  public static final Item ALUM_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alum_dust"));
  public static final Item COPPER_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "copper_dust"));
  public static final Item LEAD_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "lead_dust"));
  public static final Item NICKEL_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "nickel_dust"));
  public static final Item SILVER_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "silver_dust"));
  public static final Item TIN_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "tin_dust"));
  public static final Item ZINC_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "zinc_dust"));
  public static final Item IRON_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "iron_dust"));
  public static final Item GOLD_DUST = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "gold_dust"));

  
  public static final Item ALUM_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "alum_chunk"));
  public static final Item COPPER_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "copper_chunk"));
  public static final Item LEAD_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "lead_chunk"));
  public static final Item NICKEL_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "nickel_chunk"));
  public static final Item SILVER_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "silver_chunk"));
  public static final Item TIN_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "tin_chunk"));
  public static final Item ZINC_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "zinc_chunk"));
  public static final Item IRON_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "iron_chunk"));
  public static final Item GOLD_CHUNK = (Item)(new Item((new Item.Properties()).group(creativetab).maxStackSize(64))).setRegistryName(new ResourceLocation(id, "gold_chunk"));
}

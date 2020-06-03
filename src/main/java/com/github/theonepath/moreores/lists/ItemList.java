package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.MoreOres;
import com.github.theonepath.moreores.items.fuels.Coke;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Objects;

public class ItemList {
    private static final String id = "moreores";
    private static final ItemGroup group = MoreOres.setup.itemGroup;

    @ObjectHolder(id + ":coke")
    public static Coke COKE;

    @ObjectHolder(id + ":battery")
    public static Item BATTERY = new Item(new Item.Properties().group(group)).setRegistryName("battery");

    @ObjectHolder(id + ":capacitor")
    public static Item CAPACITOR = new Item(new Item.Properties().group(group)).setRegistryName("capacitor");

    @ObjectHolder(id + ":copper_plate")
    public static Item COPPER_PLATE = new Item(new Item.Properties().group(group)).setRegistryName("copper_plate");


    // Ingots
    @ObjectHolder(id + ":alum_ingot")
    public static Item ALUM_INGOT = new Item(new Item.Properties().group(group)).setRegistryName("alum_ingot");

    @ObjectHolder(id + ":alumbrass_ingot")
    public static Item ALUMBRASS_INGOT = new Item(new Item.Properties().group(group)).setRegistryName("alumbrass_ingot");

    @ObjectHolder(id + ":brass_ingot")
    public static Item BRASS_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("brass_ingot");

    @ObjectHolder(id + ":bronze_ingot")
    public static Item BRONZE_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("bronze_ingot");

    @ObjectHolder(id + ":copper_ingot")
    public static Item COPPER_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("copper_ingot");

    @ObjectHolder(id + ":lead_ingot")
    public static Item LEAD_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("lead_ingot");

    @ObjectHolder(id + ":nickel_ingot")
    public static Item NICKEL_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("nickel_ingot");

    @ObjectHolder(id + ":silver_ingot")
    public static Item SILVER_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("silver_ingot");

    @ObjectHolder(id + ":tin_ingot")
    public static Item TIN_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("tin_ingot");

    @ObjectHolder(id + ":zinc_ingot")
    public static Item ZINC_INGOT = new Item((new Item.Properties().group(group))).setRegistryName("zinc_ingot");

    // Nugget
    @ObjectHolder(id + ":alum_nugget")
    public static Item ALUM_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "alum_nugget"));

    @ObjectHolder(id + ":alumbrass_nugget")
    public static Item ALUMBRASS_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "alumbrass_nugget"));

    @ObjectHolder(id + ":brass_nugget")
    public static Item BRASS_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "brass_nugget"));

    @ObjectHolder(id + ":bronze_nugget")
    public static Item BRONZE_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "bronze_nugget"));

    @ObjectHolder(id + ":copper_nugget")
    public static Item COPPER_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "copper_nugget"));

    @ObjectHolder(id + ":lead_nugget")
    public static Item LEAD_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "lead_nugget"));

    @ObjectHolder(id + ":nickel_nugget")
    public static Item NICKEL_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "nickel_nugget"));

    @ObjectHolder(id + ":silver_nugget")
    public static Item SILVER_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "silver_nugget"));

    @ObjectHolder(id + ":tin_nugget")
    public static Item TIN_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "tin_nugget"));

    @ObjectHolder(id + ":zinc_nugget")
    public static Item ZINC_NUGGET =new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "zinc_nugget"));

    // Dusts
    @ObjectHolder(id + ":alum_dust")
    public static Item ALUM_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "alum_dust"));

    @ObjectHolder(id + ":copper_dust")
    public static Item COPPER_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "copper_dust"));

    @ObjectHolder(id + ":lead_dust")
    public static Item LEAD_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "lead_dust"));

    @ObjectHolder(id + ":nickel_dust")
    public static Item NICKEL_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "nickel_dust"));

    @ObjectHolder(id + ":silver_dust")
    public static Item SILVER_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "silver_dust"));

    @ObjectHolder(id + ":tin_dust")
    public static Item TIN_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "tin_dust"));

    @ObjectHolder(id + ":zinc_dust")
    public static Item ZINC_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "zinc_dust"));

    @ObjectHolder(id + ":iron_dust")
    public static Item IRON_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "iron_dust"));

    @ObjectHolder(id + ":gold_dust")
    public static Item GOLD_DUST = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "gold_dust"));

    // Chunks
    @ObjectHolder(id + ":alum_chunk")
    public static Item ALUM_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "alum_chunk"));

    @ObjectHolder(id + ":copper_chunk")
    public static Item COPPER_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "copper_chunk"));

    @ObjectHolder(id + ":lead_chunk")
    public static Item LEAD_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "lead_chunk"));

    @ObjectHolder(id + ":nickel_chunk")
    public static Item NICKEL_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "nickel_chunk"));

    @ObjectHolder(id + ":silver_chunk")
    public static Item SILVER_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "silver_chunk"));

    @ObjectHolder(id + ":tin_chunk")
    public static Item TIN_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "tin_chunk"));

    @ObjectHolder(id + ":zinc_chunk")
    public static Item ZINC_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "zinc_chunk"));

    @ObjectHolder(id + ":iron_chunk")
    public static Item IRON_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "iron_chunk"));

    @ObjectHolder(id + ":gold_chunk")
    public static Item GOLD_CHUNK = new Item((new Item.Properties()).group(group)).setRegistryName(new ResourceLocation(id, "gold_chunk"));

}

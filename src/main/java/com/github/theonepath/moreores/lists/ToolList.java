package com.github.theonepath.moreores.lists;

import com.github.theonepath.moreores.MoreOres;
import com.github.theonepath.moreores.items.tools.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;

import javax.tools.Tool;

public class ToolList {
    private static final String id = "moreores";
    private static final ItemGroup group = MoreOres.setup.itemGroup;

    // Tools
    @ObjectHolder(id + ":rock_grinder_stone")
    public static Item ROCK_GRINDER_STONE = new RockGrinderStone(ToolMaterialList.rock_grinder_stone_material, 4, -2.8F, (new Item.Properties()).group(group));

    @ObjectHolder(id + ":rock_grinder_iron")
    public static Item ROCK_GRINDER_IRON = new RockGrinderIron(ToolMaterialList.rock_grinder_iron_material, 5, -2.8F, (new Item.Properties()).group(group));

    @ObjectHolder(id + ":rock_grinder_gold")
    public static Item ROCK_GRINDER_GOLD = new RockGrinderGold(ToolMaterialList.rock_grinder_gold_material, 3, -2.8F, (new Item.Properties()).group(group));

    @ObjectHolder(id + ":rock_grinder_diamond")
    public static Item ROCK_GRINDER_DIAMOND = new RockGrinderDiamond(ToolMaterialList.rock_grinder_diamond_material, 6, -2.8F, (new Item.Properties()).group(group));

    @ObjectHolder(id + ":rock_grinder_emerald")
    public static Item ROCK_GRINDER_EMERALD = new RockGrinderEmerald(ToolMaterialList.rock_grinder_emerald_material, 6, -2.8F, (new Item.Properties()).group(group));

    @ObjectHolder(id + ":rock_grinder_unbreakable")
    public static Item ROCK_GRINDER_UNBREAKABLE = new RockGrinderUnbreakable(ToolMaterialList.rock_grinder_unbreakable_material, 7, -2.6F, (new Item.Properties()).group(group));
}

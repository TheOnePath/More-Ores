package com.github.theonepath.moreores.world;

import com.github.theonepath.moreores.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreWorldGen{
	private static CountRangeConfig copper_ore_placement = new CountRangeConfig(8, 20, 0, 80);
	private static CountRangeConfig alum_ore_placement = new CountRangeConfig(3, 5, 0, 40);
	private static CountRangeConfig lead_ore_placement = new CountRangeConfig(4, 5, 0, 45);
	private static CountRangeConfig nickel_ore_placement = new CountRangeConfig(3, 2, 0, 30);
	private static CountRangeConfig silver_ore_placement = new CountRangeConfig(4, 15, 0, 50);
	private static CountRangeConfig tin_ore_placement = new CountRangeConfig(6, 20, 0, 70);
	private static CountRangeConfig zinc_ore_placement = new CountRangeConfig(4, 5, 0, 30);

	public static void setupOreWorldGen() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (  biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER)
            {
                continue;
            }
			
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.COPPER_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, copper_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.ALUM_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, alum_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.LEAD_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, lead_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.NICKEL_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, nickel_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.SILVER_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, silver_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.TIN_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, tin_ore_placement));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.ZINC_ORE.getDefaultState(), 10), Placement.COUNT_RANGE, zinc_ore_placement));
		}
	}
}

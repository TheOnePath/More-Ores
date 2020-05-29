package com.github.theonepath.moreores.world;

import com.github.theonepath.moreores.lists.BlockList;

import com.github.theonepath.moreores.setup.Config;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class OreWorldGen{
	public static void setupOreWorldGen() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if ( biome.getCategory() != Biome.Category.THEEND || biome.getCategory() != Biome.Category.NETHER) {
				for (Map.Entry<Block, Map<CountRangeConfig, Integer>> entry : Config.ORES_DATA.entrySet()) {
					for (Map.Entry<CountRangeConfig, Integer> subentry : entry.getValue().entrySet()) {
						biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE
								.withConfiguration(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, entry.getKey().getDefaultState(), subentry.getValue()))
								.withPlacement(Placement.COUNT_RANGE.configure(subentry.getKey())));
					}
				}
			}
		}
	}
}

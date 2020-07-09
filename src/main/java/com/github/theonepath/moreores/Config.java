package com.github.theonepath.moreores;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_POWER = "power";
    public static final String CATEGORY_SMELTING = "Smelting";
    public static final String CATEGORY_REFINING = "Refining";
    public static final String SUBCATEGORY_GENERATOR = "generator";
    public static final String SUBCATEGORY_eGENERATOR = "electricGenerator";
    public static final String SUBCATEGORY_POWERBANK = "powerBank";
    public static final String SUBCATEGORY_ELECTRIC_BLAST_FURNACE = "electricBlastFurnace";
    public static final String SUBCATEGORY_REFINERY = "refinery";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue GENERATOR_MAXPOWER;
    public static ForgeConfigSpec.IntValue GENERATOR_GENERATE;
    public static ForgeConfigSpec.IntValue GENERATOR_SEND;
    public static ForgeConfigSpec.IntValue GENERATOR_TICKS;

    public static ForgeConfigSpec.IntValue eGENERATOR_MAXPOWER;
    public static ForgeConfigSpec.IntValue eGENERATOR_GENERATE;
    public static ForgeConfigSpec.IntValue eGENERATOR_SEND;
    public static ForgeConfigSpec.IntValue eGENERATOR_TICKS;

    public static ForgeConfigSpec.IntValue POWERBANK_MAXPOWER;
    public static ForgeConfigSpec.IntValue POWERBANK_SEND;

    public static ForgeConfigSpec.IntValue ELECTRIC_BLAST_FURNACE_MAXPOWER;
    public static ForgeConfigSpec.IntValue ELECTRIC_BLAST_FURNACE_TICKS;
    public static ForgeConfigSpec.IntValue ELECTRIC_BLAST_FURNACE_CONSUMPTION;

    public static ForgeConfigSpec.IntValue REFINERY_MAXPOWER;
    public static ForgeConfigSpec.IntValue REFINERY_TICKS;
    public static ForgeConfigSpec.IntValue REFINERY_CONSUMPTION;

    static {
        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Power settings").push(CATEGORY_POWER);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Smelting settings").push(CATEGORY_SMELTING);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Refining settings").push(CATEGORY_REFINING);

        setupGeneratorConfig();

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupGeneratorConfig() {
        COMMON_BUILDER.comment("Generator settings").push(SUBCATEGORY_GENERATOR);
        GENERATOR_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Generator")
                .defineInRange("maxPower", 50000, 0, Integer.MAX_VALUE);
        GENERATOR_GENERATE = COMMON_BUILDER.comment("Generation power per coke")
                .defineInRange("generate", 10, 0, Integer.MAX_VALUE);
        GENERATOR_SEND = COMMON_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 50, 0, Integer.MAX_VALUE);
        GENERATOR_TICKS = COMMON_BUILDER.comment("Number of ticks required per coke")
                .defineInRange("ticks", 1000, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Electric Generator settings").push(SUBCATEGORY_eGENERATOR);
        eGENERATOR_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Electric Generator")
                .defineInRange("maxPower", 50000, 0, Integer.MAX_VALUE);
        eGENERATOR_GENERATE = COMMON_BUILDER.comment("Generation power per coke")
                .defineInRange("generate", 20, 0, Integer.MAX_VALUE);
        eGENERATOR_SEND = COMMON_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
        eGENERATOR_TICKS = COMMON_BUILDER.comment("Number of ticks required per coke")
                .defineInRange("ticks", 750, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Power Bank settings").push(SUBCATEGORY_POWERBANK);
        POWERBANK_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Power Bank")
                .defineInRange("maxPower", 500000, 0, Integer.MAX_VALUE);
        POWERBANK_SEND = COMMON_BUILDER.comment("Power to transfer per tick")
                .defineInRange("transfer", 200, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Electric Blast Furnace settings").push(SUBCATEGORY_ELECTRIC_BLAST_FURNACE);
        ELECTRIC_BLAST_FURNACE_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Power Bank")
                .defineInRange("maxPower", 100000, 0, Integer.MAX_VALUE);
        ELECTRIC_BLAST_FURNACE_TICKS = COMMON_BUILDER.comment("Number of ticks to smelt and item")
                .defineInRange("ticks", 400, 0, Integer.MAX_VALUE);
        ELECTRIC_BLAST_FURNACE_CONSUMPTION = COMMON_BUILDER.comment("Energy consumption per tick")
                .defineInRange("consumption", 20, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Refinery settings").push(SUBCATEGORY_REFINERY);
        REFINERY_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Power Bank")
                .defineInRange("maxPower", 100000, 0, Integer.MAX_VALUE);
        REFINERY_TICKS = COMMON_BUILDER.comment("Number of ticks to smelt and item")
                .defineInRange("ticks", 200, 0, Integer.MAX_VALUE);
        REFINERY_CONSUMPTION = COMMON_BUILDER.comment("Energy consumption per tick")
                .defineInRange("consumption", 30, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.pop();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent){

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Loading configEvent){

    }
}

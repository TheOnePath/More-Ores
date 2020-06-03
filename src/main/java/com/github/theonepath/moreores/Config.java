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
    public static final String SUBCATEGORY_GENERATOR = "generator";
    public static final String SUBCATEGORY_eGENERATOR = "electricGenerator";
    public static final String SUBCATEGORY_POWERBANK = "powerBank";

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
    public static ForgeConfigSpec.IntValue POWERBANK_IO;


    static {
        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Power settings").push(CATEGORY_POWER);

        setupGeneratorConfig();

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupGeneratorConfig() {
        COMMON_BUILDER.comment("Generator settings").push(SUBCATEGORY_GENERATOR);
        GENERATOR_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Generator")
                .defineInRange("maxPower", 20000, 0, Integer.MAX_VALUE);
        GENERATOR_GENERATE = COMMON_BUILDER.comment("Generation power per coke")
                .defineInRange("generate", 5000, 0, Integer.MAX_VALUE);
        GENERATOR_SEND = COMMON_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 50, 0, Integer.MAX_VALUE);
        GENERATOR_TICKS = COMMON_BUILDER.comment("Number of ticks required per coke")
                .defineInRange("ticks", 1000, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Electric Generator settings").push(SUBCATEGORY_eGENERATOR);
        eGENERATOR_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Electric Generator")
                .defineInRange("maxPower", 50000, 0, Integer.MAX_VALUE);
        eGENERATOR_GENERATE = COMMON_BUILDER.comment("Generation power per coke")
                .defineInRange("generate", 6000, 0, Integer.MAX_VALUE);
        eGENERATOR_SEND = COMMON_BUILDER.comment("Power generation to send per tick")
                .defineInRange("send", 100, 0, Integer.MAX_VALUE);
        eGENERATOR_TICKS = COMMON_BUILDER.comment("Number of ticks required per coke")
                .defineInRange("ticks", 800, 0, Integer.MAX_VALUE);

        COMMON_BUILDER.comment("Power Bank settings").push(SUBCATEGORY_POWERBANK);
        POWERBANK_MAXPOWER = COMMON_BUILDER.comment("Maximum power for the Power Bank")
                .defineInRange("maxPower", 500000, 0, Integer.MAX_VALUE);
        POWERBANK_IO = COMMON_BUILDER.comment("Power transfer amount per tick (I/O)")
                .defineInRange("transfer", 200, 0, Integer.MAX_VALUE);

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

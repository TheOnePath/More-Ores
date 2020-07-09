package com.github.theonepath.moreores.setup;

import com.github.theonepath.moreores.blocks.gui.ElectricBlastFurnaceScreen;
import com.github.theonepath.moreores.blocks.gui.ElectricGeneratorScreen;
import com.github.theonepath.moreores.blocks.gui.GeneratorScreen;
import com.github.theonepath.moreores.blocks.gui.RefineryScreen;
import com.github.theonepath.moreores.lists.BlockList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy{

    @Override
    public void init() {
        ScreenManager.registerFactory(BlockList.GENERATOR_CONTAINER, GeneratorScreen::new);
        ScreenManager.registerFactory(BlockList.ELECTRIC_GENERATOR_CONTAINER, ElectricGeneratorScreen::new);
        ScreenManager.registerFactory(BlockList.ELECTRIC_BLAST_FURNACE_CONTAINER, ElectricBlastFurnaceScreen::new);
        ScreenManager.registerFactory(BlockList.REFINERY_CONTAINER, RefineryScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer () {
        return Minecraft.getInstance().player;
    }
}

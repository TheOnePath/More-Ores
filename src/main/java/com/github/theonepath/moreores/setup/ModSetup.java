package com.github.theonepath.moreores.setup;

import com.github.theonepath.moreores.lists.BlockList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("moreores") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockList.COPPER_ORE);
        }
    };

    public void init() {

    }
}

package com.github.theonepath.moreores.items.fuels;

import com.github.theonepath.moreores.MoreOres;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Coke extends Item {

    public Coke() {
        super(new Item.Properties()
                .group(MoreOres.setup.itemGroup)
        );
        setRegistryName("coke");
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }

}

package com.github.theonepath.moreores;

import com.github.theonepath.moreores.lists.BlockList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoreOresCreativeTab extends ItemGroup {

	public MoreOresCreativeTab(String string) {
		super(string);
	}
	
	@OnlyIn(Dist.CLIENT)
	public ItemStack createIcon() {
		return new ItemStack(BlockList.COPPER_ORE);
	}
}

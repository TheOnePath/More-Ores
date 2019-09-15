package com.github.theonepath.moreores.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;

public class ToolPulveriser extends Item{
	
	private ItemStack item;

	public ToolPulveriser(Properties properties) {
		super(properties);
	}
	
	public ActionResultType onItemUse() { return ActionResultType.SUCCESS; }
	
	@Override
	public boolean hasContainerItem(ItemStack item) { return true; }
	
	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		item = itemstack.copy();
		
		return duplicateItemStack(itemstack);
	}

	private ItemStack duplicateItemStack(ItemStack stack) { return stack = item; }


}

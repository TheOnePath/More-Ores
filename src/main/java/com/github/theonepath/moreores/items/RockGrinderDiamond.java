package com.github.theonepath.moreores.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;

public class RockGrinderDiamond extends PickaxeItem {
	private ItemStack item;
  
	public RockGrinderDiamond(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
  	}

  
	public ActionResultType onItemUse() { return ActionResultType.SUCCESS; }

  
	public boolean hasContainerItem(ItemStack item) { return true; }

  
	public ItemStack getContainerItem(ItemStack itemstack) {
		this.item = itemstack.copy();
    
		return duplicateItemStack(itemstack);
	}
  
	private ItemStack duplicateItemStack(ItemStack stack) { return stack = this.item; }
}
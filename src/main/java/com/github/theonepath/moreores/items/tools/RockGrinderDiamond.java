package com.github.theonepath.moreores.items.tools;

import com.github.theonepath.moreores.tools.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class RockGrinderDiamond extends PickaxeItem {
	private ItemStack item;
  
	public RockGrinderDiamond(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		setRegistryName("rock_grinder_diamond");
  	}

  
	public ActionResultType onItemUse() { return ActionResultType.SUCCESS; }


	// Energy durability
	/*@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		stack.getCapability(CapabilityEnergy.ENERGY).ifPresent(energy -> {
			((CustomEnergyStorage) energy).consumeEnergy(1000);
		});

		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}*/


	public boolean hasContainerItem(ItemStack item) { return true; }

  
	public ItemStack getContainerItem(ItemStack itemstack) {
		this.item = itemstack.copy();
    
		return duplicateItemStack(itemstack);
	}
  
	private ItemStack duplicateItemStack(ItemStack stack) { return stack = this.item; }
}
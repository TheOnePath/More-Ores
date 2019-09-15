package com.github.theonepath.moreores.blocks;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.github.theonepath.moreores.MoreOres;
import com.github.theonepath.moreores.lists.ItemList;
import com.github.theonepath.moreores.util.CraftingDictionary;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class GrindingWorkbench extends Block{
	int clickCounter = 0;
	List<Item> holdItemContainer = new ArrayList<>();
	//private NonNullList<ItemStack> heldItem;

	public GrindingWorkbench(Properties properties) {
		super(properties);
	}
	
	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        if (entity != null) {
        	worldIn.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
        }
    }
	
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
		Item itemInHand = player.getHeldItem(handIn).getItem();
		if(itemInHand == ItemList.PULVERISER && !holdItemContainer.isEmpty()) {
			worldIn.playSound(player, pos, MoreOres.rock_chink, SoundCategory.BLOCKS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
			// get ore and on 3 clicks, return ore as dusts
			if(clickCounter > 4) {
				int itemIndex = CraftingDictionary.getDictionaryItemIndex(holdItemContainer.get(0));
				
				if(itemIndex != -1) {
					for(int i = 0; i < 3; i++) {
						player.addItemStackToInventory(new ItemStack(CraftingDictionary.resourceDictionary[1][itemIndex]));
					}
					worldIn.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
				}
				clickCounter = 0;
				holdItemContainer.clear();
				
			} else { clickCounter += 1; }
			return true;
		} 
		else if (CraftingDictionary.searchDictionary(itemInHand) && holdItemContainer.isEmpty()) {
			holdItemContainer.add(itemInHand);
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
			return true;
		} else { return true; } //remove item from bench
	}
	
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		return extractItem(slot, 1, false);
	}

	private Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
		return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) { builder.add(BlockStateProperties.FACING); }

}

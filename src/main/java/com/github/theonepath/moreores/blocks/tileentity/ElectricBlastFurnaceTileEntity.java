package com.github.theonepath.moreores.blocks.tileentity;

import com.github.theonepath.moreores.Config;
import com.github.theonepath.moreores.blocks.container.ElectricBlastFurnaceContainer;
import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import com.github.theonepath.moreores.tools.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class ElectricBlastFurnaceTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);

    public static final int SIZE = 4;
    public static boolean canReceive = true;
    private int tickCounter;

    public ElectricBlastFurnaceTileEntity() {
        super(BlockList.ELECTRIC_BLAST_FURNACE_TILE);
    }

    @Override
    public void tick() {
        if (world.isRemote) {
            return;
        }

        handler.ifPresent(h -> {
            BlockState blockState = world.getBlockState(pos);


            // set BlockState to powered if it isn't already and tickCounter is greater than 0 and max energy isn't reached
            if (blockState.get(BlockStateProperties.POWERED) != tickCounter > 0) {
                world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, tickCounter > 0), 3);
            }
            energy.ifPresent(m -> { });
        });
    }


    @Override
    public void read(CompoundNBT tag) {
        CompoundNBT invTag = tag.getCompound("inv");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(invTag));

        CompoundNBT energyTag = tag.getCompound("energy");
        energy.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(energyTag));
        super.read(tag);
    }


    @Override
    public CompoundNBT write(CompoundNBT tag) {
        handler.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
            tag.put("inv", compound);
        });
        energy.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
            tag.put("energy", compound);
        });

        return super.write(tag);
    }


    private IItemHandler createHandler() {
        return new ItemStackHandler(1) {

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == ItemList.COPPER_CHUNK;
            }
        };
    }

    private IEnergyStorage createEnergy() {
        return new CustomEnergyStorage(Config.ELECTRIC_BLAST_FURNACE_MAXPOWER.get(), 0);
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        if (cap == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.moreores.electric_blast_furnace");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity entity) {
        return new ElectricBlastFurnaceContainer(i, world, pos, inventory, entity);
    }
}


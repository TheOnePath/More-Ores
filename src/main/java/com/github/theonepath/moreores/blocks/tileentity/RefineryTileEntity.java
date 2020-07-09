package com.github.theonepath.moreores.blocks.tileentity;

import com.github.theonepath.moreores.Config;
import com.github.theonepath.moreores.blocks.container.RefineryContainer;
import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.tools.CustomEnergyStorage;
import com.github.theonepath.moreores.tools.MachineManager;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
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

public class RefineryTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    public static final int SIZE = 4;
    private int tickCounter, multiplier;
    private boolean isBurning, canProcess, locked = true;

    private ItemStackHandler outputSlotsBuffer = new ItemStackHandler(3);

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);

    public RefineryTileEntity() {
        super(BlockList.REFINERY_TILE);
    }

    @Override
    public void tick() {
        if (world.isRemote) {
            return;
        }

        energy.ifPresent(energy -> {
            BlockState blockState = world.getBlockState(pos);
            if (energy.getEnergyStored() > 0) {
                handler.ifPresent(h -> {
                    ItemStack item = h.getStackInSlot(0);
                    boolean refinable = MachineManager.canRefine(item);
                    if (refinable && canProcess) {
                        if (canProcessWithMultiplier(h, outputSlotsBuffer.getStackInSlot(0))) {
                            this.isBurning = true;
                            if (tickCounter > 0) {
                                tickCounter--;
                                ((CustomEnergyStorage) energy).consumeEnergy(Config.REFINERY_CONSUMPTION.get());
                            }
                            if (tickCounter <= 0) {
                                h.extractItem(0, 1, false);
                                lockSlots(h, ItemStack.EMPTY, false);
                                for (int buffer = 0; buffer < outputSlotsBuffer.getSlots(); buffer++) {
                                    ItemStack output = outputSlotsBuffer.getStackInSlot(buffer);
                                    if (!output.isEmpty()) {
                                        h.isItemValid(buffer + 1, output);
                                        for (int j = 0; j < multiplier; j++) {
                                            int outputSlot = getValidSlot(h, output.getItem());
                                            if (outputSlot != -1) {
                                                h.insertItem(outputSlot, output, false);
                                            }
                                        }
                                    }
                                }
                                lockSlots(h, ItemStack.EMPTY, true);

                                clearBufferSlots();
                                markDirty();
                            }
                        }
                    } else {
                        this.isBurning = false;
                    }
                });
            } else {
                this.isBurning = false;
            }
            // set BlockState to powered if it isn't already and tickCounter is greater than 0 and max energy isn't reached
            if (blockState.get(BlockStateProperties.POWERED) != this.isBurning) {
                world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, this.isBurning), 3);
            }
        });
    }

    private void placeItemStackInBuffer(int slot, Item result) {
        if (outputSlotsBuffer.getStackInSlot(slot).getCount() < 1)
            outputSlotsBuffer.insertItem(slot, new ItemStack(result), false);
    }


    private int getValidBufferSlot(Item result) {
        for (int i = 0; i < outputSlotsBuffer.getSlots(); i++) {
            ItemStack stack = outputSlotsBuffer.getStackInSlot(i);
            if (stack.getCount() < stack.getMaxStackSize() && (stack.getItem() == result || stack == ItemStack.EMPTY)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Check which slot is valid for processing result. If a
     * refinery ingredient produces bonuses but no slots are
     * available, then the bonus is lost but the refining
     * process may still continue.<br>
     *
     * <b>(WIP)</b> <code>getValidSlot()</code> should handle for
     * multiplier on refining results. I.e, can the slot take 2
     * times. (method might have to be called when applying multiplier
     * and that statement might have to be changed as well first).
     *
     * @param result <code>Item</code>
     * @return valid slot index. Returns -1 if no slots can accept items
     */
    private int getValidSlot(IItemHandler handler, Item result) {
        for (int i = 1; i < handler.getSlots(); i++) {
            ItemStack stack = handler.getStackInSlot(i);
            if (stack.getCount() < stack.getMaxStackSize() && (stack.getItem() == result || stack == ItemStack.EMPTY)) {
                return i;
            }
        }

        return -1;
    }

    private boolean canProcessWithMultiplier(IItemHandler handler, ItemStack result) {
        for (int i = 1; i < handler.getSlots(); i++) {
            ItemStack stack = handler.getStackInSlot(i);
            if (stack.getCount() + multiplier - 1 < stack.getMaxStackSize() && (stack.getItem() == result.getItem() || stack == ItemStack.EMPTY)) {
                return true;
            }
        }

        return false;
    }

    protected void clearBufferSlots() {
        for (int i = 0; i < outputSlotsBuffer.getSlots(); i++) {
            ItemStack tmp = outputSlotsBuffer.getStackInSlot(i);
            if (!tmp.isEmpty()) {
                outputSlotsBuffer.extractItem(i, tmp.getCount(), false);
            }
        }
    }

    private void lockSlots(IItemHandler handler, ItemStack stack, boolean lock) {
        locked = lock;
        for (int i = 1; i < handler.getSlots(); i++)
            handler.isItemValid(i, stack);
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
        return new ItemStackHandler(4) {

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
                if (!getStackInSlot(0).isEmpty()) {
                    multiplier = 1;
                    Object[] refiningResult = MachineManager.getRecipeResult(getStackInSlot(0), "refinery");
                    if (refiningResult.length > 0) {
                        for (Object object : refiningResult) {
                            try {
                                Item item = (Item) object;
                                int bufferSlot = getValidBufferSlot(item);
                                if (bufferSlot != -1 && getValidSlot(this, item) != -1)
                                    placeItemStackInBuffer(bufferSlot, item);
                                else {
                                    canProcess = false;
                                    clearBufferSlots();

                                    return;
                                }
                            } catch (Exception e) {
                                multiplier = (int) object;
                            }
                        }
                        tickCounter = Config.REFINERY_TICKS.get();
                        canProcess = true;
                    }
                }
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot != 0)
                    return !(locked);
                return true;
            }
        };
    }

    private IEnergyStorage createEnergy() {
        return new CustomEnergyStorage(Config.REFINERY_MAXPOWER.get(), 0);
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
        return new TranslationTextComponent("container.moreores.refinery");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity entity) {
        return new RefineryContainer(i, world, pos, inventory, entity);
    }
}

package com.github.theonepath.moreores.blocks.tileentity;

import com.github.theonepath.moreores.Config;
import com.github.theonepath.moreores.blocks.container.GeneratorContainer;
import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import com.github.theonepath.moreores.tools.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
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
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static com.github.theonepath.moreores.Config.GENERATOR_MAXPOWER;
import static com.github.theonepath.moreores.Config.eGENERATOR_MAXPOWER;

public class GeneratorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);

    public static final int SIZE = 1;
    private int tickCounter;

    public GeneratorTileEntity() {
        super(BlockList.GENERATOR_TILE);
    }

    @Override
    public void tick() {
        if (world.isRemote){
            return;
        }

        energy.ifPresent(m -> {
            BlockState blockState = world.getBlockState(pos);
            if (m.getEnergyStored() < GENERATOR_MAXPOWER.get()) {
                if (tickCounter > 0) {
                    tickCounter--;
                    energy.ifPresent(e -> ((CustomEnergyStorage) e).addEnergy((Config.GENERATOR_GENERATE.get()) /*- randomLoss()*/));
                    markDirty();
                }
                if (tickCounter <= 0) {
                    handler.ifPresent(h -> {
                        ItemStack stack = h.getStackInSlot(0);
                        if (stack.getItem() == ItemList.COKE) {
                            h.extractItem(0, 1, false);
                            tickCounter = Config.GENERATOR_TICKS.get();
                            markDirty();
                        }
                    });
                }
                if (blockState.get(BlockStateProperties.POWERED) != tickCounter > 0) {
                    world.setBlockState(pos, blockState.with(BlockStateProperties.POWERED, tickCounter > 0), 3);
                }
            }
        });

        sendOutPower();
    }

    private int randomLoss() {
        float rand = (float)Math.round(Math.random() * 10) / 10;
        return rand == (int)rand / 0.20 ? 1 : 0;
    }

    private void sendOutPower() {
        energy.ifPresent(energy -> {
            AtomicInteger capacity = new AtomicInteger(energy.getEnergyStored());
            if (capacity.get() > 0) {
                for (Direction direction : Direction.values()) {
                    TileEntity tileEntity = world.getTileEntity(pos.offset(direction));
                    if (tileEntity != null && !(tileEntity instanceof ElectricGeneratorTileEntity)) {
                        boolean doContinue = tileEntity.getCapability(CapabilityEnergy.ENERGY, direction).map(handler -> {
                            if (handler.canReceive()) {
                                int received = handler.receiveEnergy(Math.min(capacity.get(), Config.GENERATOR_SEND.get()), false);
                                if (handler.getEnergyStored() < handler.getMaxEnergyStored()) {
                                    ((CustomEnergyStorage) handler).addEnergy(received);
                                }

                                capacity.addAndGet(-received);
                                ((CustomEnergyStorage) energy).consumeEnergy(received);

                                markDirty();
                                return capacity.get() > 0;
                            } else {
                                return true;
                            }
                        }

                        ).orElse(true);
                        if (!doContinue) {
                            return;
                        }
                    }
                }
            }
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
                return stack.getItem() == ItemList.COKE;
            }
        };
    }

    private IEnergyStorage createEnergy(){
        return new CustomEnergyStorage(Config.GENERATOR_MAXPOWER.get(), 0);
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
        return new TranslationTextComponent("container.moreores.generator");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity entity) {
        return new GeneratorContainer(i, world, pos, inventory, entity);
    }
}

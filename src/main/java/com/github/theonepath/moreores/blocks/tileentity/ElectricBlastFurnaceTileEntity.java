package com.github.theonepath.moreores.blocks.tileentity;

import com.github.theonepath.moreores.Config;
import com.github.theonepath.moreores.blocks.container.ElectricBlastFurnaceContainer;
import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.tools.CustomEnergyStorage;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
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

    public static final int SIZE = 4;
    private int tickCounter;
    private boolean canSmelt = false;
    private Item smeltingResult;
    private boolean isBurning = false;
    ItemStackHandler itemStackHandler = new ItemStackHandler(4);

    private ItemStack slot_1;
    private ItemStack slot_2;
    private ItemStack slot_3;
    private ItemStackHandler inputSlot;

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);
    private LazyOptional<IItemHandler> inputSlotHolder = LazyOptional.of(() -> inputSlot);

    protected final IRecipeType<? extends AbstractCookingRecipe> recipeType = IRecipeType.SMELTING;
    protected NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

    public ElectricBlastFurnaceTileEntity() {
        super(BlockList.ELECTRIC_BLAST_FURNACE_TILE);
        inputSlot = new ItemStackHandler();
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
                    int itemSlot = getValidSlot(h);
                    if (canSmelt && itemSlot != -1) {
                        this.isBurning = true;
                        if (tickCounter > 0) {
                            tickCounter--;
                            ((CustomEnergyStorage) energy).consumeEnergy(Config.ELECTRIC_BLAST_FURNACE_CONSUMPTION.get());
                        }
                        if (tickCounter <= 0) {
                            h.extractItem(0, 1, false);
                            switch (itemSlot) {
                                case 1:
                                    h.insertItem(1, slot_1, false);
                                    break;
                                case 2:
                                    h.insertItem(2, slot_2, false);
                                    break;
                                case 3:
                                    h.insertItem(3, slot_3, false);
                                    break;
                            }
                            markDirty();
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

    private int getValidSlot(IItemHandler handler) {
        for (int i = 1 ; i < handler.getSlots() ; i++) {
            ItemStack stack = handler.getStackInSlot(i);
            switch (i) {
                case 1:
                    if (stack.getCount() < stack.getMaxStackSize() && (stack.getItem() == smeltingResult || stack == ItemStack.EMPTY)) {
                        slot_1 = new ItemStack(smeltingResult);
                        return i;
                    } else {
                        break;
                    }
                case 2:
                    if (stack.getCount() < stack.getMaxStackSize() && (stack.getItem() == smeltingResult || stack == ItemStack.EMPTY)) {
                        slot_2 = new ItemStack(smeltingResult);
                        return i;
                    } else {
                        break;
                    }
                case 3:
                    if (stack.getCount() < stack.getMaxStackSize() && (stack.getItem() == smeltingResult || stack == ItemStack.EMPTY)) {
                        slot_3 = new ItemStack(smeltingResult);
                        return i;
                    } else {
                        break;
                    }
            }
        }
        return -1;
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
                ItemStack stack = getStackInSlot(slot);
                if (slot == 0 && stack == ItemStack.EMPTY) {
                    canSmelt = false;
                    //return;
                }

                /*IRecipe<?> irecipe = world.getRecipeManager().getRecipe(IRecipeType.SMELTING, this, world).orElse(null);
                System.out.println(canSmelt(irecipe));*/
                /*if (slot == 0) {
                    /*IRecipe<?> iRecipe = world.getRecipeManager().getRecipe(Objects.requireNonNull(stack.getItem().getRegistryName())).orElse(null);
                    if (iRecipe != null) {
                        if (iRecipe.getType() == IRecipeType.SMELTING) {
                            System.out.println(iRecipe);
                        }
                    }
                    //getRecipes();
                    for (Map.Entry<Item, Item> entry : RecipeHolder.RecipeList.entrySet()) {
                        if (entry.getKey() == stack.getItem()) {
                            smeltingResult = entry.getValue();

                            tickCounter = Config.ELECTRIC_BLAST_FURNACE_TICKS.get();
                            canSmelt = true;
                            return;
                        }
                        else
                            canSmelt = false;
                    }
                }
                else {
                    if (getStackInSlot(0) != ItemStack.EMPTY)
                        canSmelt = stack.getCount() < getSlotLimit(slot);
                }*/
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return slot == 0;
            }
        };
    }

    /*@Override
    public void onLoad() {
        if (!MoreOres.isComplete) {
            getRecipes();
        }
    }*/

    /*private void getRecipes() {

        for (Item item : ForgeRegistries.ITEMS) {
            IRecipe<?> iRecipe = world.getRecipeManager().getRecipe(Objects.requireNonNull(item.getRegistryName())).orElse(null);
            System.out.print(item.getRegistryName() + " | ");
            System.out.println(iRecipe);
            if (iRecipe != null) {
                if (iRecipe.getType() == IRecipeType.SMELTING || iRecipe.getType() == IRecipeType.BLASTING) {
                    ItemStack[] ingredient = new ItemStack[0];
                    for (Ingredient ing : iRecipe.getIngredients()) {
                        ingredient = ing.getMatchingStacks();
                    }

                    RecipeHolder.RecipeList.put(ingredient[0].getItem(), item);
                }
            }
        }
        MoreOres.isComplete = true;
    }*/

    protected boolean canSmelt(@Nullable IRecipe<?> recipeIn) {
        if (recipeIn != null) {
            ItemStack itemStack = recipeIn.getRecipeOutput();
            return !itemStack.isEmpty();
        } else {
            return false;
        }
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


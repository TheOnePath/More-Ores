package com.github.theonepath.moreores.blocks;

import com.github.theonepath.moreores.blocks.container.PowerBankContainer;
import com.github.theonepath.moreores.blocks.tileentity.PowerBankTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static net.minecraft.state.properties.BlockStateProperties.FACING;

public class PowerBank extends Block {

    public PowerBank() {
        super(Properties.create((Material.GLASS))
                .hardnessAndResistance(2.5f)
        );
        setRegistryName("power_bank");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new PowerBankTileEntity();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (placer != null) {
            worldIn.setBlockState(pos, state.with(FACING, getFacingFromEntity(pos, placer)), 2);
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity te = worldIn.getTileEntity(pos);
            /*if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            }*/
            te.getCapability(CapabilityEnergy.ENERGY).ifPresent(energy -> {
                System.out.printf("%d:%d\n", energy.getEnergyStored(), energy.getMaxEnergyStored());
            });
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity){
        return Direction.getFacingFromVector((float) (entity.getPosX() - clickedBlock.getX()), (float) (entity.getPosY() - clickedBlock.getY()), (float) (entity.getPosZ() - clickedBlock.getZ()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /*@Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        stack.getCapability(CapabilityEnergy.ENERGY).ifPresent(energy -> {
            tooltip.add(new StringTextComponent(String.format("Energy Stored: %d/%d", energy.getEnergyStored(), energy.getMaxEnergyStored())));
        });
    }*/
}

package com.github.theonepath.moreores;

import com.github.theonepath.moreores.blocks.ElectricGenerator;
import com.github.theonepath.moreores.blocks.Generator;
import com.github.theonepath.moreores.blocks.PowerBank;
import com.github.theonepath.moreores.blocks.container.ElectricGeneratorContainer;
import com.github.theonepath.moreores.blocks.container.GeneratorContainer;
import com.github.theonepath.moreores.blocks.container.PowerBankContainer;
import com.github.theonepath.moreores.blocks.metals.*;
import com.github.theonepath.moreores.blocks.ores.*;
import com.github.theonepath.moreores.blocks.tileentity.GeneratorTileEntity;
import com.github.theonepath.moreores.blocks.tileentity.PowerBankTileEntity;
import com.github.theonepath.moreores.items.fuels.Coke;
import com.github.theonepath.moreores.lists.ItemList;
import com.github.theonepath.moreores.lists.ToolList;
import com.github.theonepath.moreores.setup.ClientProxy;
import com.github.theonepath.moreores.setup.IProxy;
import com.github.theonepath.moreores.setup.ModSetup;
import com.github.theonepath.moreores.setup.ServerProxy;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.world.OreWorldGen;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Objects;

@Mod(MoreOres.MODID)
public class MoreOres {
	
	public static final String MODID = "moreores";
	public static MoreOres instance;
	public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static ModSetup setup = new ModSetup();
	
	private static final Logger logger = LogManager.getLogger(MODID);
	public static SoundEvent rock_chink;
	
	
	public MoreOres() {
		instance = this;

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

		// Register the setup method for mod loading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("moreores-client.toml"));
		Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("moreores-common.toml"));
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		setup.init();
		proxy.init();

		OreWorldGen.setupOreWorldGen();
		logger.info("Setup method registered");
	}

	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					// Ores
					new AlumOre(), new CopperOre(), new LeadOre(), new NickelOre(),
					new SilverOre(), new TinOre(), new ZincOre(),
					// Metals
					new AlumBlock(), new AlumBrassBlock(), new BrassBlock(), new BronzeBlock(),
					new CopperBlock(), new LeadBlock(), new NickelBlock(), new SilverBlock(),
					new TinBlock(), new ZincBlock(),
					// Blocks
					new Generator(), new ElectricGenerator(), new PowerBank()
			);
		}


		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
			Item.Properties properties = new Item.Properties()
					.group(setup.itemGroup);
			event.getRegistry().registerAll(
					// Ores
					new BlockItem(BlockList.ALUM_ORE,   	 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ALUM_ORE.getRegistryName())),
					new BlockItem(BlockList.COPPER_ORE, 	 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.COPPER_ORE.getRegistryName())),
					new BlockItem(BlockList.LEAD_ORE,   	 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.LEAD_ORE.getRegistryName())),
					new BlockItem(BlockList.NICKEL_ORE, 	 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.NICKEL_ORE.getRegistryName())),
					new BlockItem(BlockList.SILVER_ORE, 		new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.SILVER_ORE.getRegistryName())),
					new BlockItem(BlockList.TIN_ORE,   			new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.TIN_ORE.getRegistryName())),
					new BlockItem(BlockList.ZINC_ORE,   	 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ZINC_ORE.getRegistryName())),
					// Metals
					new BlockItem(BlockList.ALUM_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ALUM_BLOCK.getRegistryName())),
					new BlockItem(BlockList.ALUMBRASS_BLOCK, 	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ALUMBRASS_BLOCK.getRegistryName())),
					new BlockItem(BlockList.BRASS_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.BRASS_BLOCK.getRegistryName())),
					new BlockItem(BlockList.BRONZE_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.BRONZE_BLOCK.getRegistryName())),
					new BlockItem(BlockList.COPPER_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.COPPER_BLOCK.getRegistryName())),
					new BlockItem(BlockList.LEAD_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.LEAD_BLOCK.getRegistryName())),
					new BlockItem(BlockList.NICKEL_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.NICKEL_BLOCK.getRegistryName())),
					new BlockItem(BlockList.SILVER_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.SILVER_BLOCK.getRegistryName())),
					new BlockItem(BlockList.TIN_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.TIN_BLOCK.getRegistryName())),
					new BlockItem(BlockList.ZINC_BLOCK,      	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ZINC_BLOCK.getRegistryName())),
					//Blocks
					new BlockItem(BlockList.GENERATOR,			new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.GENERATOR.getRegistryName())),
					new BlockItem(BlockList.ELECTRIC_GENERATOR,	new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.ELECTRIC_GENERATOR.getRegistryName())),
					new BlockItem(BlockList.POWERBANK,			new Item.Properties().group(setup.itemGroup)).setRegistryName(Objects.requireNonNull(BlockList.POWERBANK.getRegistryName())),


					// Items
					new Coke(), ItemList.BATTERY, ItemList.CAPACITOR, ItemList.COPPER_PLATE,
					// Ingots
					ItemList.ALUM_INGOT, ItemList.ALUMBRASS_INGOT, ItemList.BRASS_INGOT, ItemList.BRONZE_INGOT, ItemList.COPPER_INGOT,
					ItemList.LEAD_INGOT, ItemList.NICKEL_INGOT, ItemList.SILVER_INGOT, ItemList.TIN_INGOT, ItemList.ZINC_INGOT,
					// Nuggets
					ItemList.ALUM_NUGGET, ItemList.ALUMBRASS_NUGGET, ItemList.BRASS_NUGGET, ItemList.BRONZE_NUGGET, ItemList.COPPER_NUGGET,
					ItemList.LEAD_NUGGET, ItemList.NICKEL_NUGGET, ItemList.SILVER_NUGGET, ItemList.TIN_NUGGET, ItemList.ZINC_NUGGET,
					// Chunks
					ItemList.ALUM_CHUNK, ItemList.COPPER_CHUNK, ItemList.LEAD_CHUNK, ItemList.NICKEL_CHUNK, ItemList.SILVER_CHUNK,
					ItemList.TIN_CHUNK, ItemList.ZINC_CHUNK, ItemList.IRON_CHUNK, ItemList.GOLD_CHUNK,
					// Dusts
					ItemList.ALUM_DUST, ItemList.COPPER_DUST, ItemList.LEAD_DUST, ItemList.NICKEL_DUST, ItemList.SILVER_DUST,
					ItemList.TIN_DUST, ItemList.ZINC_DUST, ItemList.IRON_DUST, ItemList.GOLD_DUST,
					// Tools
					ToolList.ROCK_GRINDER_STONE, ToolList.ROCK_GRINDER_IRON, ToolList.ROCK_GRINDER_GOLD,
					ToolList.ROCK_GRINDER_DIAMOND, ToolList.ROCK_GRINDER_EMERALD, ToolList.ROCK_GRINDER_UNBREAKABLE
			);

		}


		@SubscribeEvent
		public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(GeneratorTileEntity::new, BlockList.GENERATOR).build(null).setRegistryName("generator"));
			event.getRegistry().register(TileEntityType.Builder.create(GeneratorTileEntity::new, BlockList.ELECTRIC_GENERATOR).build(null).setRegistryName("electric_generator"));
			event.getRegistry().register(TileEntityType.Builder.create(PowerBankTileEntity::new, BlockList.POWERBANK).build(null).setRegistryName("power_bank"));
		}


		@SubscribeEvent
		public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new GeneratorContainer(windowId, MoreOres.proxy.getClientWorld() , pos, inv, MoreOres.proxy.getClientPlayer());
			}).setRegistryName("generator"));
			event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new ElectricGeneratorContainer(windowId, MoreOres.proxy.getClientWorld() , pos, inv, MoreOres.proxy.getClientPlayer());
			}).setRegistryName("electric_generator"));
			event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new PowerBankContainer(windowId, MoreOres.proxy.getClientWorld() , pos, inv, MoreOres.proxy.getClientPlayer());
			}).setRegistryName("power_bank"));
		}


		@SubscribeEvent
		public static void onSoundRegistry(final RegistryEvent.Register<SoundEvent> event) {
			MoreOres.rock_chink = makeRegistrySoundEvent(event, "moreores:rock_chink");
		}

		private static SoundEvent makeRegistrySoundEvent(RegistryEvent.Register<SoundEvent> event, String id) {
			SoundEvent sound_event = new SoundEvent(new ResourceLocation(id));
		    sound_event.setRegistryName(new ResourceLocation(id));
		    event.getRegistry().register(sound_event);
		    
		    return sound_event;
		}
	}
}

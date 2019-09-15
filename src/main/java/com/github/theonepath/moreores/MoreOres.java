package com.github.theonepath.moreores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.theonepath.moreores.lists.BlockList;
import com.github.theonepath.moreores.lists.ItemList;
import com.github.theonepath.moreores.world.OreWorldGen;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreOres.MODID)
public class MoreOres {
	
	public static final String MODID = "moreores";
	
	public static MoreOres instance;
	private static final Logger logger = LogManager.getLogger(MODID);
	public static final ItemGroup MORE_ORES = new MoreOresCreativeTab("moreOres");
	public static SoundEvent rock_chink;
	
	
	public MoreOres() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegisteries);
		
		OreWorldGen.setupOreWorldGen();
	}
	
	private void setup(final FMLCommonSetupEvent event){
		logger.info("Setup method registered"); 
	}
	
	private void clientRegisteries(final FMLClientSetupEvent event){
		logger.info("Client method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
				// Items
				ItemList.ALUM_INGOT, ItemList.ALUMBRASS_INGOT, ItemList.BRONZE_INGOT, ItemList.COPPER_INGOT,
				ItemList.LEAD_INGOT, ItemList.NICKEL_INGOT, ItemList.SILVER_INGOT, ItemList.TIN_INGOT, 
				ItemList.ZINC_INGOT, ItemList.ALUM_DUST, ItemList.COPPER_DUST, ItemList.LEAD_DUST, 
				ItemList.NICKEL_DUST, ItemList.SILVER_DUST, ItemList.TIN_DUST, ItemList.ZINC_DUST,
				ItemList.PULVERISER, ItemList.BRASS_INGOT, ItemList.IRON_DUST, ItemList.GOLD_DUST,
				// BlockItems
				ItemList.ALUM_ORE, ItemList.COPPER_ORE, ItemList.LEAD_ORE, ItemList.NICKEL_ORE,
				ItemList.SILVER_ORE, ItemList.TIN_ORE, ItemList.ZINC_ORE, ItemList.GRINDING_WORKBENCH
			);
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
				BlockList.ALUM_ORE, BlockList.COPPER_ORE, BlockList.LEAD_ORE, BlockList.NICKEL_ORE,
				BlockList.SILVER_ORE, BlockList.TIN_ORE, BlockList.ZINC_ORE, BlockList.GRINDING_WORKBENCH
			);
		}
		
		@SubscribeEvent
		public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
			rock_chink = makeRegistrySoundEvent(event, "moreores:rock_chink");
		}

		private static SoundEvent makeRegistrySoundEvent(Register<SoundEvent> event, String id) {
			SoundEvent sound_event = new SoundEvent(new ResourceLocation(id));
		    sound_event.setRegistryName(new ResourceLocation(id));
		    event.getRegistry().register(sound_event);
		    
		    return sound_event;
		}
	}
}

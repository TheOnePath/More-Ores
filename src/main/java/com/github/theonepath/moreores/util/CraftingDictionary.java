package com.github.theonepath.moreores.util;

import java.util.Arrays;
import java.util.List;

import com.github.theonepath.moreores.lists.ItemList;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class CraftingDictionary{
	
	public static List<Item> acceptableOres = Arrays.asList(new Item[] {Items.IRON_ORE, Items.GOLD_ORE, ItemList.ALUM_ORE, ItemList.COPPER_ORE, ItemList.LEAD_ORE, ItemList.NICKEL_ORE, ItemList.SILVER_ORE, ItemList.TIN_ORE, ItemList.ZINC_ORE});
	//public static Item[] acceptableOres = {};
	public static Item[][] resourceDictionary = {{Items.IRON_ORE, Items.GOLD_ORE, ItemList.ALUM_ORE, ItemList.COPPER_ORE, ItemList.LEAD_ORE, ItemList.NICKEL_ORE, ItemList.SILVER_ORE, ItemList.TIN_ORE, ItemList.ZINC_ORE},
												 {ItemList.IRON_DUST, ItemList.GOLD_DUST, ItemList.ALUM_DUST, ItemList.COPPER_DUST, ItemList.LEAD_DUST, ItemList.NICKEL_DUST, ItemList.SILVER_DUST, ItemList.TIN_DUST, ItemList.ZINC_DUST}};
	
	// create a dictionary where ore can be translated
	// into dust and returned to the player
	
	public static boolean searchDictionary(Item itemIn) {
		if(acceptableOres.contains(itemIn)) {
			return true;
		} else { return false; }
	}
	
	public static Item itemInDictionary(Item itemIn) {
		if(!acceptableOres.contains(itemIn)) {
			return null;
		} else { return itemIn; }
	}
	
	public static int getDictionaryItemIndex(Item itemIn) {
		if(acceptableOres.contains(itemIn)) {
			return acceptableOres.indexOf(itemIn);
		} else { return -1; }
	}
}

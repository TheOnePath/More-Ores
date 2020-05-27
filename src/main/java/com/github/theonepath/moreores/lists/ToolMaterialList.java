package com.github.theonepath.moreores.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

public enum ToolMaterialList implements IItemTier {
	rock_grinder_stone_material(-1.0F, 6.0F, 131, 1, 25, ItemList.ROCK_GRINDER_STONE),
	rock_grinder_iron_material(-1.0F, 8.0F, 250, 2, 28, ItemList.ROCK_GRINDER_IRON),
	rock_grinder_gold_material(-1.0F, 12.0F, 32, 2, 28, ItemList.ROCK_GRINDER_GOLD),
	rock_grinder_diamond_material(-1.0F, 9.0F, 1561, 3, 30, ItemList.ROCK_GRINDER_DIAMOND),
	rock_grinder_emerald_material(-1.0F, 14.0F, 2015, 3, 30, ItemList.ROCK_GRINDER_EMERALD),
	rock_grinder_unbreakable_material(-1.0F, 20.0F, -1, 3, 30, ItemList.ROCK_GRINDER_UNBREAKABLE);
  
	private float attackDamage;
	private float efficiency;
	private int durability;
	private int harvestLevel; private int enchantability;
  	private Item repairMaterial;
  
  	ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
	    this.attackDamage = attackDamage;
	    this.efficiency = efficiency;
	    this.durability = durability;
	    this.harvestLevel = harvestLevel;
	    this.enchantability = enchantability;
	    this.repairMaterial = repairMaterial;
  	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}
	@Override
	public float getEfficiency() {
		return this.efficiency;
	}
	@Override
	public int getEnchantability() {
		return this.enchantability;
	}
	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}
	@Override
	public int getMaxUses() {
		return this.durability;
	}
	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(new IItemProvider[] { this.repairMaterial });
	}
}
  

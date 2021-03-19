package tropics.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import tropics.init.items.TropicsItems;

public enum TropicsToolMaterials implements IItemTier 
{
	volcanic(1.0f, 8.0f, 1200, 3, 15, TropicsItems.volcanic_ingot);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private TropicsToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	public float getSpeed() {
		return this.efficiency;
	}

	public int getEnchantmentValue() {
		return this.enchantability;
	}

	public int getLevel() {
		return this.harvestLevel;
	}

	public int getUses() {
		return this.durability;
	}

	public Ingredient getRepairIngredient() {
		return Ingredient.of(this.repairMaterial);
	}
	
}

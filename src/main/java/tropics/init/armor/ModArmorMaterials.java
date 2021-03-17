package tropics.init.armor;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import tropics.init.items.TropicsItems;

public class ModArmorMaterials implements DummyArmorMaterials 
{

	private enum ArmorMaterial implements IArmorMaterial {
		VOLCANIC("volcanic", 24, new int[] { 3, 6, 8, 3 }, 15, () -> SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> TropicsItems.volcanic_ingot, 2.0f),
		DOMINUS("dominus", 34, new int[] { 3, 6, 8, 3 }, 26, () -> SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> TropicsItems.dominus_ingot, 3);

		private final String name;
		private final int durabilityMultiplier;
		private final int[] damageReduction;
		private final int enchantability;
		private final Supplier<SoundEvent> equipSound;
		private final Supplier<Item> repairItem;
		private final float toughness;
		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };

		ArmorMaterial(String name, int durabilityMultiplier, int[] damageReduction, int enchantability, Supplier<SoundEvent> equipSound, Supplier<Item> repairItem, float toughness) {
			this.name = name;
			this.durabilityMultiplier = durabilityMultiplier;
			this.damageReduction = damageReduction;
			this.enchantability = enchantability;
			this.equipSound = equipSound;
			this.repairItem = repairItem;
			this.toughness = toughness;
		}

		@Override
		public int getDurability(EquipmentSlotType slot) {
			return durabilityMultiplier * MAX_DAMAGE_ARRAY[slot.getIndex()];
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slot) {
			return damageReduction[slot.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return enchantability;
		}

		@Nonnull
		@Override
		public SoundEvent getSoundEvent() {
			return equipSound.get();
		}

		@Nonnull
		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(repairItem.get());
		}

		@Nonnull
		@Override
		public String getName() {
			return name;
		}

		@Override
		public float getToughness() {
			return toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	}

	private enum ItemTier implements IItemTier {
		VOLCANIC(2300, 9, 3, 4, 26, () -> TropicsItems.volcanic_ingot),
		DOMINUS(2300, 9, 3, 4, 26, () -> TropicsItems.dominus_ingot);

		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int harvestLevel;
		private final int enchantability;
		private final Supplier<Item> repairItem;

		ItemTier(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Item> repairItem) {
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.harvestLevel = harvestLevel;
			this.enchantability = enchantability;
			this.repairItem = repairItem;
		}

		@Override
		public int getMaxUses() {
			return maxUses;
		}

		@Override
		public float getEfficiency() {
			return efficiency;
		}

		@Override
		public float getAttackDamage() {
			return attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return Ingredient.fromItems(repairItem.get());
		}
	}
	
	//@Override
	//public IArmorMaterial getVolcanicArmorMaterial() {
	//	return ArmorMaterial.VOLCANIC;
	//}
	
	//@Override
	//public IItemTier getVolcanicItemTier() {
	//	return ItemTier.VOLCANIC;
	//}
	
	@Override
	public IArmorMaterial getDominusArmorMaterial() {
		return ArmorMaterial.DOMINUS;
	}
	
	@Override
	public IItemTier getDominusItemTier() {
		return ItemTier.DOMINUS;
	}
}

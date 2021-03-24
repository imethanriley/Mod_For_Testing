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

public class ModArmorMaterials implements IDummyArmorMaterials
{

	public enum ArmorMaterial implements IArmorMaterial {
		VOLCANIC("volcanic", 24, new int[] { 3, 6, 8, 3 }, 15, () -> SoundEvents.ARMOR_EQUIP_DIAMOND, () -> TropicsItems.VOLCANIC_INGOT, 2.0f),
		DOMINUS("dominus", 34, new int[] { 3, 6, 8, 3 }, 26, () -> SoundEvents.ARMOR_EQUIP_DIAMOND, () -> TropicsItems.dominus_ingot, 3);

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
		public int getDurabilityForSlot(EquipmentSlotType slot) {
			return durabilityMultiplier * MAX_DAMAGE_ARRAY[slot.getIndex()];
		}

		@Override
		public int getDefenseForSlot(EquipmentSlotType slot) {
			return damageReduction[slot.getIndex()];
		}

		@Override
		public int getEnchantmentValue() {
			return enchantability;
		}

		@Nonnull
		@Override
		public SoundEvent getEquipSound() {
			return equipSound.get();
		}

		@Nonnull
		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(repairItem.get());
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

	@Override
	public IArmorMaterial getVolcanicArmorMaterial() {
		return ArmorMaterial.VOLCANIC;
	}

	@Override
	public IArmorMaterial getDominusArmorMaterial() {
		return ArmorMaterial.DOMINUS;
	}

}

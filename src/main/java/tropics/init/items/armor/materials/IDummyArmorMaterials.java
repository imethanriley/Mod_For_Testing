package tropics.init.items.armor.materials;

import javax.annotation.Nonnull;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import tropics.TestMod;

public interface IDummyArmorMaterials {

	LazyValue<IDummyArmorMaterials> INSTANCE = new LazyValue<>(() -> {
		try {
			return (IDummyArmorMaterials) Class.forName("tropics.init.items.armor.materials.ModArmorMaterials").newInstance();
		} catch (ReflectiveOperationException e) {
			TestMod.LOGGER.warn("Unable to find ModArmorMaterials, using a dummy");
			return new IDummyArmorMaterials() {};
		}
	});

	static IDummyArmorMaterials instance() {
		return INSTANCE.get();
	}
	
	IArmorMaterial DUMMY_ARMOR_MATERIAL = new IArmorMaterial() {
		@Override
		public int getDurabilityForSlot(@Nonnull EquipmentSlotType slot) {
			return 0;
		}

		@Override
		public int getDefenseForSlot(@Nonnull EquipmentSlotType slot) {
			return 0;
		}

		@Override
		public int getEnchantmentValue() {
			return 0;
		}

		@Nonnull
		@Override
		public SoundEvent getEquipSound() {
			return SoundEvents.ARMOR_EQUIP_LEATHER;
		}

		@Nonnull
		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.EMPTY;
		}

		@Override
		public String getName() {
			return "missingno";
		}

		@Override
		public float getToughness() {
			return 0;
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	};

	default IArmorMaterial getDummyArmorMaterial() {
		return DUMMY_ARMOR_MATERIAL;
	}

	default IArmorMaterial getVolcanicArmorMaterial() {
		return DUMMY_ARMOR_MATERIAL;
	}

	default IArmorMaterial getDominusArmorMaterial() {
		return DUMMY_ARMOR_MATERIAL;
	}
	
}

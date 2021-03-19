package tropics.init.armor;

import javax.annotation.Nonnull;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import tropics.Tropics;

public interface DummyArmorMaterials {

	LazyValue<DummyArmorMaterials> INSTANCE = new LazyValue<>(() -> {
		try {
			return (DummyArmorMaterials) Class.forName("tropics.init.armor.ModArmorMaterials").newInstance();
		} catch (ReflectiveOperationException e) {
			Tropics.LOGGER.warn("Unable to find ModArmorMaterials, using a dummy");
			return new DummyArmorMaterials() {};
		}
	});

	static DummyArmorMaterials instance() {
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

	IItemTier DUMMY_ITEM_TIER = new IItemTier() {
		@Override
		public int getUses() {
			return 0;
		}

		@Override
		public float getSpeed() {
			return 0;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public int getLevel() {
			return 0;
		}

		@Override
		public int getEnchantmentValue() {
			return 0;
		}

		@Nonnull
		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.EMPTY;
		}
	};

	default IArmorMaterial getDummyArmorMaterial() {
		return DUMMY_ARMOR_MATERIAL;
	}
	
	default IArmorMaterial getDominusArmorMaterial() {
		return DUMMY_ARMOR_MATERIAL;
	}
	
	default IItemTier getDummyItemTier() {
		return DUMMY_ITEM_TIER;
	}
	
	default IItemTier getDominusItemTier() {
		return DUMMY_ITEM_TIER;
	}
	
}

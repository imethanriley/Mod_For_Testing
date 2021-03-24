package tropics.init.items.materials;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import tropics.Tropics;

import javax.annotation.Nonnull;

public interface IDummyToolMaterials {

    LazyValue<IDummyToolMaterials> INSTANCE = new LazyValue<>(() -> {
        try {
            return (IDummyToolMaterials) Class.forName("tropics.init.armor.ModToolMaterials").newInstance();
        } catch (ReflectiveOperationException e) {
            Tropics.LOGGER.warn("Unable to find ModToolMaterials, using a dummy");
            return new IDummyToolMaterials() {};
        }
    });

    static IDummyToolMaterials instance() {
        return INSTANCE.get();
    }

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

    default IItemTier getDummyItemTier() {
        return DUMMY_ITEM_TIER;
    }

    default IItemTier getDominusItemTier() {
        return DUMMY_ITEM_TIER;
    }

    default IItemTier getVolcanicItemTier() {
        return DUMMY_ITEM_TIER;
    }

}

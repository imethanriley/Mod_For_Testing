package tropics.init.items;

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

public class ModToolMaterials implements IDummyToolMaterials
{

    public enum ItemTier implements IItemTier {
        VOLCANIC(2300, 9, 3, 4, 26, () -> TropicsItems.VOLCANIC_INGOT),
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
        public int getUses() {
            return maxUses;
        }

        @Override
        public float getSpeed() {
            return efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return attackDamage;
        }

        @Override
        public int getLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(repairItem.get());
        }
    }

    @Override
    public IItemTier getVolcanicItemTier() {
        return ItemTier.VOLCANIC;
    }


    @Override
    public IItemTier getDominusItemTier() {
        return ItemTier.DOMINUS;
    }
}

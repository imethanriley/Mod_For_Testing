package tropics.init.armor.volcanic;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import tropics.init.items.ModItems;

import javax.annotation.Nonnull;

public class ItemVolcanicArmor extends ArmorItem {

    private String[] armorTypes = new String[] {
            "volcanic_helmet",
            "volcanic_chestplate",
            "volcanic_leggings",
            "volcanic_boots"
    };

    public ItemVolcanicArmor(IArmorMaterial material, EquipmentSlotType slotType, Properties properties) {
        super(material, slotType, properties);
    }

    @Nonnull
    @Override
    public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if (stack.getItem().equals(ModItems.VOLCANIC_HELMET) ||
            stack.getItem().equals(ModItems.VOLCANIC_CHESTPLATE) ||
            stack.getItem().equals(ModItems.VOLCANIC_BOOTS)) {
                return "tropics:textures/models/armor/volcanic_layer_1.png";
        }

        else if (stack.getItem().equals(ModItems.VOLCANIC_LEGGINGS)) {
            return "tropics:textures/models/armor/volcanic_layer_2.png";
        }

        else {
            return "tropics:textures/models/armor/volcanic_layer_1.png";
        }
    }
}

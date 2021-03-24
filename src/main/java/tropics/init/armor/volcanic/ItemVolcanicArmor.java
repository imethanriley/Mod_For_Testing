package tropics.init.armor.volcanic;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.fml.DistExecutor;
import tropics.init.armor.IDummyArmorMaterials;
import tropics.init.items.TropicsItems;

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
        if (stack.getItem().equals(TropicsItems.volcanic_helmet) ||
            stack.getItem().equals(TropicsItems.volcanic_chestplate) ||
            stack.getItem().equals(TropicsItems.volcanic_boots)) {
                return "tropics:textures/models/armor/volcanic_layer_1.png";
        }

        else if (stack.getItem().equals(TropicsItems.volcanic_leggings)) {
            return "tropics:textures/models/armor/volcanic_layer_2.png";
        }

        else {
            return "tropics:textures/models/armor/volcanic_layer_1.png";
        }
    }
}

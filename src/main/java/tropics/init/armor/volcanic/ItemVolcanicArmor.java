package tropics.init.armor.volcanic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import tropics.init.items.ModItems;

import javax.annotation.Nonnull;

public class ItemVolcanicArmor extends ArmorItem {

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

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        ItemStack helmetArmor = player.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chestplateArmor = player.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack leggingsArmor = player.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack bootsArmor = player.getItemBySlot(EquipmentSlotType.FEET);

        boolean isWearingFullSetOfVolcanic =
                helmetArmor.getItem() instanceof ItemVolcanicArmor &&
                chestplateArmor.getItem() instanceof ItemVolcanicArmor &&
                leggingsArmor.getItem() instanceof ItemVolcanicArmor &&
                bootsArmor.getItem() instanceof ItemVolcanicArmor;

        if (!player.getPersistentData().contains("wearingFullVolcanicArmor")) {
            player.getPersistentData().putBoolean("wearingFullVolcanicArmor", false);
        }

        boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullVolcanicArmor");

        if (!isWearingFullSetOfVolcanic && wasWearingArmorLastTick && !player.isCreative()) {
            player.removeEffect(Effects.FIRE_RESISTANCE);
        } else if (isWearingFullSetOfVolcanic) {
            player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE));
        }

        player.getPersistentData().putBoolean("wearingFullVolcanicArmor", isWearingFullSetOfVolcanic);

    }
}

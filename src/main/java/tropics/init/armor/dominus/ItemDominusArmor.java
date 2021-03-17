package tropics.init.armor.dominus;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import tropics.init.armor.DummyArmorMaterials;

public class ItemDominusArmor extends ArmorItem {

	private final LazyValue<BipedModel<?>> model;
	public final EquipmentSlotType type;

	public ItemDominusArmor(EquipmentSlotType type, Properties props) {
		this(type, DummyArmorMaterials.instance().getDominusArmorMaterial(), props);
	}
	
	@SuppressWarnings("deprecation")
	public ItemDominusArmor(EquipmentSlotType type, IArmorMaterial mat, Properties props) {
		super(mat, type, props);
		this.type = type;
		this.model = DistExecutor.runForDist(() -> () -> new LazyValue<>(() -> this.provideArmorModelForSlot(type)),
				() -> () -> null);
	}
	
	@Nonnull
	@Override
	public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return "tropics:textures/models/armor/armor_dominus.png";
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A original) {
		return (A) model.getValue();
	}
	
	@OnlyIn(Dist.CLIENT)
	public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
		return new ModelArmorDominus(slot);
	}
}

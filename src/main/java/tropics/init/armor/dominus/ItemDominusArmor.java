package tropics.init.armor.dominus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import tropics.init.armor.materials.IDummyArmorMaterials;

import java.util.List;

public class ItemDominusArmor extends ArmorItem {

	private final LazyValue<BipedModel<?>> model;
	public final EquipmentSlotType type;

	public ItemDominusArmor(EquipmentSlotType type, Properties props) {
		this(type, IDummyArmorMaterials.instance().getDominusArmorMaterial(), props);
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
		return (A) model.get();
	}
	
	@OnlyIn(Dist.CLIENT)
	public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
		return new ModelArmorDominus(slot);
	}

	@ParametersAreNonnullByDefault
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent(TextFormatting.BLUE + "Ability: Flight"));
		tooltip.add(new TranslationTextComponent(TextFormatting.DARK_AQUA + "Ability Granted When Wearing Full Armor Set"));
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		ItemStack helmetArmor = player.getItemBySlot(EquipmentSlotType.HEAD);
		ItemStack chestplateArmor = player.getItemBySlot(EquipmentSlotType.CHEST);
		ItemStack leggingsArmor = player.getItemBySlot(EquipmentSlotType.LEGS);
		ItemStack bootsArmor = player.getItemBySlot(EquipmentSlotType.FEET);

		boolean isWearingFullSetOfDominus =
				helmetArmor.getItem() instanceof ItemDominusArmor &&
				chestplateArmor.getItem() instanceof ItemDominusArmor &&
				leggingsArmor.getItem() instanceof ItemDominusArmor &&
				bootsArmor.getItem() instanceof ItemDominusArmor;

		if (!player.getPersistentData().contains("wearingFullDominusArmor")) {
			player.getPersistentData().putBoolean("wearingFullDominusArmor", false);
		}

		boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullDominusArmor");

		if (!isWearingFullSetOfDominus && wasWearingArmorLastTick && !player.isCreative()) {
			player.abilities.mayfly = false;
			player.abilities.flying = false;
		} else if (isWearingFullSetOfDominus) {
			player.abilities.mayfly = true;
		}

		player.getPersistentData().putBoolean("wearingFullDominusArmor", isWearingFullSetOfDominus);

	}
}

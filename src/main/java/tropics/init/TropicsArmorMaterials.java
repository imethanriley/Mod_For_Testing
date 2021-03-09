package tropics.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import tropics.Tropics;
import tropics.init.items.TropicsItems;

public enum TropicsArmorMaterials implements IArmorMaterial 
{
	volcanic("volcanic", 800, new int[] {3,6,8,3}, 15, TropicsItems.volcanic_ingot, "item.armor.equip_diamond", 2.0f);
	
	private static final int[] max_damage_array = new int[] {13,15,16,11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private TropicsArmorMaterials(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness)
	{
		this.name = name;
		this.durability = durability;
		this.damageReductionAmounts = damageReductionAmounts;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.equipSound = equipSound;
		this.toughness = toughness;
	}

	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.damageReductionAmounts[slot.getIndex()];
	}

	public int getDurability(EquipmentSlotType slot) {
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public float getKnockbackResistance() {
		return 0;
	}

	public String getName() {
		return Tropics.MOD_ID + ":" + this.name;
	}
	
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairItem);
	}

	public SoundEvent getSoundEvent() {
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	public float getToughness() {
		return this.toughness;
	}
}

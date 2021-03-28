package tropics.init.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tropics.TestMod;
import tropics.init.entity.ModEntities;
import tropics.init.items.armor.materials.ModArmorMaterials;
import tropics.init.items.armor.dominus.ItemDominusArmor;
import tropics.init.items.armor.dominus.ItemDominusHelm;
import tropics.init.items.armor.volcanic.ItemVolcanicArmor;
import tropics.init.blocks.ModBlocks;
import tropics.init.items.tools.materials.ModToolMaterials;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
	//Items
	public static final Item VOLCANIC_INGOT = new Item(new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_ingot"));
	public static final Item DOMINUS_INGOT = new Item(new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("dominus_ingot"));
	
	//Blocks
	public static final Item DOMINUS_ORE = new BlockItem(ModBlocks.DOMINUS_ORE, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("dominus_ore"));
	public static final Item VOLCANIC_BLOCK = new BlockItem(ModBlocks.VOLCANIC_BLOCK, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_block"));
	
	//Tools
	public static final Item VOLCANIC_AXE = new AxeItem(ModToolMaterials.ItemTier.VOLCANIC, +7f, -3f, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_axe"));
	public static final Item VOLCANIC_PICKAXE = new PickaxeItem(ModToolMaterials.ItemTier.VOLCANIC, +3, -2.8f, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_pickaxe"));
	public static final Item VOLCANIC_SHOVEL = new ShovelItem(ModToolMaterials.ItemTier.VOLCANIC, +3.5f, -3f, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_shovel"));
	public static final Item VOLCANIC_SWORD = new SwordItem(ModToolMaterials.ItemTier.VOLCANIC, +5, -2.4f, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_sword"));
	public static final Item VOLCANIC_HOE = new HoeItem(ModToolMaterials.ItemTier.VOLCANIC, -1, 0f, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_hoe"));
	
	//Armor
	public static final Item VOLCANIC_HELMET = new ItemVolcanicArmor(ModArmorMaterials.ArmorMaterial.VOLCANIC, EquipmentSlotType.HEAD, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_helmet"));
	public static final Item VOLCANIC_CHESTPLATE = new ItemVolcanicArmor(ModArmorMaterials.ArmorMaterial.VOLCANIC, EquipmentSlotType.CHEST, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_chestplate"));
	public static final Item VOLCANIC_LEGGINGS = new ItemVolcanicArmor(ModArmorMaterials.ArmorMaterial.VOLCANIC, EquipmentSlotType.LEGS, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_leggings"));
	public static final Item VOLCANIC_BOOTS = new ItemVolcanicArmor(ModArmorMaterials.ArmorMaterial.VOLCANIC, EquipmentSlotType.FEET, new Item.Properties().tab(TestMod.TROPICS)).setRegistryName(TestMod.location("volcanic_boots"));
	
	public static final Item DOMINUS_HELMET = new ItemDominusHelm(unstackable()).setRegistryName(TestMod.location("dominus_helmet"));
	public static final Item DOMINUS_CHESTPLATE = new ItemDominusArmor(EquipmentSlotType.CHEST, unstackable()).setRegistryName(TestMod.location("dominus_chestplate"));
	public static final Item DOMINUS_LEGGINGS = new ItemDominusArmor(EquipmentSlotType.LEGS, unstackable()).setRegistryName(TestMod.location("dominus_leggings"));
	public static final Item DOMINUS_BOOTS = new ItemDominusArmor(EquipmentSlotType.FEET, unstackable()).setRegistryName(TestMod.location("dominus_boots"));
	
	//Spawn Eggs
	public static final Item ANGLER_FISH_SPAWN_EGG = new SpawnEggItem(ModEntities.ANGLER_FISH, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(TestMod.TROPICS)).setRegistryName(TestMod.location("angler_fish_spawn_egg"));
	public static final Item RAVEN_SPAWN_EGG = new SpawnEggItem(ModEntities.RAVEN, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(TestMod.TROPICS)).setRegistryName(TestMod.location("raven_spawn_egg"));
	public static final Item VULCAN_SPAWN_EGG = new SpawnEggItem(ModEntities.VULCAN, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(TestMod.TROPICS)).setRegistryName(TestMod.location("vulcan_spawn_egg"));
	public static final Item POISON_DART_FROG_SPAWN_EGG = new SpawnEggItem(ModEntities.POISON_DART_FROG, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(TestMod.TROPICS)).setRegistryName(TestMod.location("poison_dart_frog_spawn_egg"));
	
	@SubscribeEvent
	public static void RegisterItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
			//Items
				VOLCANIC_INGOT,
				DOMINUS_INGOT,

			//Block Items
				DOMINUS_ORE,
				VOLCANIC_BLOCK,
			
			//Tools
				VOLCANIC_AXE,
				VOLCANIC_HOE,
				VOLCANIC_PICKAXE,
				VOLCANIC_SHOVEL,
				VOLCANIC_SWORD,
		
			//Armor			
				VOLCANIC_HELMET,
				VOLCANIC_CHESTPLATE,
				VOLCANIC_LEGGINGS,
				VOLCANIC_BOOTS,

				DOMINUS_HELMET,
				DOMINUS_CHESTPLATE,
				DOMINUS_LEGGINGS,
				DOMINUS_BOOTS,

			//Spawn Eggs
				ANGLER_FISH_SPAWN_EGG,
				RAVEN_SPAWN_EGG,
				VULCAN_SPAWN_EGG,
				POISON_DART_FROG_SPAWN_EGG
		);

		TestMod.LOGGER.info("Items registered");
	}

	public static Item.Properties defaultBuilder() {
		return new Item.Properties().tab(TestMod.TROPICS);
	}

	private static Item.Properties unstackable() {
		return defaultBuilder().stacksTo(1);
	}
}

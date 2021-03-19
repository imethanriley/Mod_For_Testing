package tropics.init.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tropics.Tropics;
import tropics.init.TropicsEntities;
import tropics.init.TropicsToolMaterials;
import tropics.init.armor.TropicsArmorMaterials;
import tropics.init.armor.dominus.ItemDominusArmor;
import tropics.init.armor.dominus.ItemDominusHelm;
import tropics.init.blocks.TropicsBlocks;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TropicsItems {
	//Items
	public static Item volcanic_ingot;
	public static Item dominus_ingot;
	
	//Blocks
	public static Item dominus_ore;
	public static Item volcanic_block;
	
	//Tools
	public static Item volcanic_axe;
	public static Item volcanic_hoe;
	public static Item volcanic_pickaxe;
	public static Item volcanic_shovel;
	public static Item volcanic_sword;
	
	//Armor
	public static Item volcanic_helmet;
	public static Item volcanic_chestplate;
	public static Item volcanic_leggings;
	public static Item volcanic_boots;
	
	public static Item dominus_helmet;
	public static Item dominus_chestplate;
	public static Item dominus_leggings;
	public static Item dominus_boots ;
	
	//Spawn Eggs
	public static Item angler_fish_spawn_egg;
	public static Item raven_spawn_egg;
	public static Item vulcan_spawn_egg;
	public static Item poison_dart_frog_spawn_egg;
	
	@SubscribeEvent
	public static void RegisterItems(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> reg = event.getRegistry();
		
		event.getRegistry().registerAll
		(
			//Items
			volcanic_ingot = new Item(new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_ingot")),
			dominus_ingot = new Item(new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("dominus_ingot")),

			//Block Items
			dominus_ore = new BlockItem(TropicsBlocks.dominus_ore, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(TropicsBlocks.dominus_ore.getRegistryName()),
			volcanic_block = new BlockItem(TropicsBlocks.volcanic_block, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(TropicsBlocks.volcanic_block.getRegistryName()),
			
			//Tools
			volcanic_axe = new AxeItem(TropicsToolMaterials.volcanic, +7f, -3f, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_axe")),
			volcanic_hoe = new HoeItem(TropicsToolMaterials.volcanic, -1, 0f, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_hoe")),
			volcanic_pickaxe = new PickaxeItem(TropicsToolMaterials.volcanic, +3, -2.8f, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_pickaxe")),
			volcanic_shovel = new ShovelItem(TropicsToolMaterials.volcanic, +3.5f, -3f, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_shovel")),
			volcanic_sword = new SwordItem(TropicsToolMaterials.volcanic, +5, -2.4f, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_sword")),
		
			//Armor			
			volcanic_helmet = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.HEAD, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_helmet")),
			volcanic_chestplate = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.CHEST, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_chestplate")),
			volcanic_leggings = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.LEGS, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_leggings")),
			volcanic_boots = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.FEET, new Item.Properties().tab(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_boots")),
			
			dominus_helmet = new ItemDominusHelm(unstackable()).setRegistryName(Tropics.location("dominus_helmet")),
			dominus_chestplate = new ItemDominusArmor(EquipmentSlotType.CHEST, unstackable()).setRegistryName(Tropics.location("dominus_chestplate")),
			dominus_leggings = new ItemDominusArmor(EquipmentSlotType.LEGS, unstackable()).setRegistryName(Tropics.location("dominus_leggings")),
			dominus_boots = new ItemDominusArmor(EquipmentSlotType.FEET, unstackable()).setRegistryName(Tropics.location("dominus_boots"))
		);		
		
		//Spawn Eggs
		angler_fish_spawn_egg = new SpawnEggItem(TropicsEntities.ANGLER_FISH, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(Tropics.TROPICS)).setRegistryName(Tropics.location("angler_fish_spawn_egg"));
		reg.register(TropicsItems.angler_fish_spawn_egg);
		
		raven_spawn_egg = new SpawnEggItem(TropicsEntities.RAVEN, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(Tropics.TROPICS)).setRegistryName(Tropics.location("raven_spawn_egg"));
		reg.register(TropicsItems.raven_spawn_egg);
		
		vulcan_spawn_egg = new SpawnEggItem(TropicsEntities.VULCAN, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(Tropics.TROPICS)).setRegistryName(Tropics.location("vulcan_spawn_egg"));
		reg.register(TropicsItems.vulcan_spawn_egg);
		
		poison_dart_frog_spawn_egg = new SpawnEggItem(TropicsEntities.POISON_DART_FROG, 0xFFFFFF, 0x000FFF, (new Item.Properties()).tab(Tropics.TROPICS)).setRegistryName(Tropics.location("poison_dart_frog_spawn_egg"));
		reg.register(TropicsItems.poison_dart_frog_spawn_egg);
		
		Tropics.LOGGER.info("Items registered");
	}
	
	public static Item.Properties defaultBuilder() {
		return new Item.Properties().tab(Tropics.TROPICS);
	}
	
	private static Item.Properties unstackable() {
		return defaultBuilder().stacksTo(1);
	}
}

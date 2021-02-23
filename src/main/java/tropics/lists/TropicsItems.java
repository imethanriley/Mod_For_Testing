package tropics.lists;

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
	
	//Spawn Eggs
	public static Item angler_fish_spawn_egg;
	
	@SubscribeEvent
	public static void RegisterItems(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> reg = event.getRegistry();
		
		event.getRegistry().registerAll
		(
			//Items
			TropicsItems.volcanic_ingot = new Item(new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_ingot")),
			TropicsItems.dominus_ingot = new Item(new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("dominus_ingot")),

			//Block Items
			TropicsItems.dominus_ore = new BlockItem(TropicsBlocks.dominus_ore, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(TropicsBlocks.dominus_ore.getRegistryName()),
			TropicsItems.volcanic_block = new BlockItem(TropicsBlocks.volcanic_block, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(TropicsBlocks.volcanic_block.getRegistryName()),
			
			//Tools
			TropicsItems.volcanic_axe = new AxeItem(TropicsToolMaterials.volcanic, +7f, -3f, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_axe")),
			TropicsItems.volcanic_hoe = new HoeItem(TropicsToolMaterials.volcanic, -1, 0f, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_hoe")),
			TropicsItems.volcanic_pickaxe = new PickaxeItem(TropicsToolMaterials.volcanic, +3, -2.8f, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_pickaxe")),
			TropicsItems.volcanic_shovel = new ShovelItem(TropicsToolMaterials.volcanic, +3.5f, -3f, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_shovel")),
			TropicsItems.volcanic_sword = new SwordItem(TropicsToolMaterials.volcanic, +5, -2.4f, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_sword")),
		
			//Armor
			TropicsItems.volcanic_helmet = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.HEAD, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_helmet")),
			TropicsItems.volcanic_chestplate = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.CHEST, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_chestplate")),
			TropicsItems.volcanic_leggings = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.LEGS, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_leggings")),
			TropicsItems.volcanic_boots = new ArmorItem(TropicsArmorMaterials.volcanic, EquipmentSlotType.FEET, new Item.Properties().group(Tropics.TROPICS)).setRegistryName(Tropics.location("volcanic_boots"))
		);		
		
		//Spawn Eggs
		TropicsItems.angler_fish_spawn_egg = new SpawnEggItem(TropicsEntities.ANGLER_FISH, 0xFFFFFF, 0x000FFF, (new Item.Properties()).group(Tropics.TROPICS)).setRegistryName(Tropics.location("angler_fish_spawn_egg"));
		reg.register(TropicsItems.angler_fish_spawn_egg);
		
		Tropics.LOGGER.info("Items registered");
	}
}

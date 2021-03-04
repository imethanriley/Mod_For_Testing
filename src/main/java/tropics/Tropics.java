package tropics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tropics.init.TropicsBlocks;
import tropics.world.generation.BiomeGeneration;
import tropics.world.generation.OreGeneration;

@Mod("tropics")
public class Tropics 
{
	public static Tropics instance;
	public static final String MOD_ID = "tropics";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);	

	public BiomeGeneration biomes;
	
	public Tropics() 
	{		
		biomes = new BiomeGeneration();
		
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	
	private void setup(final FMLCommonSetupEvent event)
	{
		LOGGER.info("** BEGINNING SETUP METHOD **");
		
		//Biome World Generation
		biomes.getBiomes().forEach(element -> element.init(event));	
		LOGGER.info("-- BIOMES GENERATED --");
		
		//Custom Ore Generation
		OreGeneration.registerOre();
		LOGGER.info("-- ORES GENERATED --");
		
		
		LOGGER.info("** COMPLETED SETUP METHOD **");
	}
	
	public static final ItemGroup TROPICS = new ItemGroup("tropicsTab") {
        @Override
        public ItemStack createIcon() {
        	return new ItemStack(Item.BLOCK_TO_ITEM.get(TropicsBlocks.dominus_ore));
        }
    };
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

}

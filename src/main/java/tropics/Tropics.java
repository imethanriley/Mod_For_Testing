package tropics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tropics.lists.TropicsBiomes;
import tropics.misc.TropicsItemGroup;
import tropics.world.OreGeneration;

@Mod("tropics")
public class Tropics 
{
	public static Tropics instance;
	public static final String MOD_ID = "tropics";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final ItemGroup TROPICS = new TropicsItemGroup();
	
	public Tropics() 
	{		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        TropicsBiomes.BIOMES.register(bus);
		
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.registerOre();
		LOGGER.info("Setup method registered");
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MOD_ID, name);
	}
	
}

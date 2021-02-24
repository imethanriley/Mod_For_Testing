package tropics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import tropics.misc.BoimeGenHelper;
import tropics.misc.TropicsItemGroup;
import tropics.world.OreGeneration;

@Mod("tropics")
public class Tropics 
{
	public static Tropics instance;
	public static final String MOD_ID = "tropics";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final ItemGroup TROPICS = new TropicsItemGroup();	

	public BoimeGenHelper elements;
	
	public Tropics() 
	{		
		elements = new BoimeGenHelper();
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientLoad);
		MinecraftForge.EVENT_BUS.register(new TropicsModFMLBusEvents(this));
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
	
	//Biome World Generation Functions
	private void init(FMLCommonSetupEvent event) {
		elements.getElements().forEach(element -> element.init(event));
	}

	public void clientLoad(FMLClientSetupEvent event) {
		elements.getElements().forEach(element -> element.clientLoad(event));
	}
	
	private static class TropicsModFMLBusEvents {
		private final Tropics parent;
		TropicsModFMLBusEvents(Tropics parent) {
			this.parent = parent;
		}

		@SubscribeEvent
		public void serverLoad(FMLServerStartingEvent event) {
			this.parent.elements.getElements().forEach(element -> element.serverLoad(event));
		}
	}

}

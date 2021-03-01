package tropics.entities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tropics.Tropics;
import tropics.entities.renderer.AnglerFishRenderer;
import tropics.entities.renderer.MineRenderer;
import tropics.entities.renderer.RavenRenderer;
import tropics.entities.renderer.VulcanRenderer;
import tropics.init.TropicsEntities;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID, value = Dist.CLIENT)
public class ClientRegistration {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SubscribeEvent
	public static void clientRegistration(final FMLClientSetupEvent event)
	{	
		//Boss Entities
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.VULCAN, (manager) -> new VulcanRenderer(manager));
		
		//Mob Entities
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.ANGLER_FISH, (manager) -> new AnglerFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.RAVEN, (manager) -> new RavenRenderer(manager));
		
		//Misc Entities
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.MINE, (manager) -> new MineRenderer(manager));
	}
	
}

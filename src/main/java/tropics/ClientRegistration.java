package tropics;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tropics.lists.TropicsEntities;
import tropics.renderer.AnglerFishRenderer;
import tropics.renderer.RavenRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID, value = Dist.CLIENT)
public class ClientRegistration {
	
	@SubscribeEvent
	public static void clientRegistration(final FMLClientSetupEvent event)
	{		
		//Mob Entities
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.ANGLER_FISH, (manager) -> new AnglerFishRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(TropicsEntities.RAVEN, (manager) -> new RavenRenderer(manager));
		
		//Misc Entities
	}
	
}

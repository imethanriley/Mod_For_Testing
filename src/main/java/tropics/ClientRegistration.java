package tropics;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import tropics.init.TropicsEntities;
import tropics.renderer.AnglerFishRenderer;
import tropics.renderer.MineRenderer;
import tropics.renderer.RavenRenderer;
import tropics.renderer.VulcanRenderer;
import tropics.renderer.VulcanRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID, value = Dist.CLIENT)
public class ClientRegistration {
	
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

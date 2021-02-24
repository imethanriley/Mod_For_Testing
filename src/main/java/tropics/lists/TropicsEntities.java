package tropics.lists;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tropics.Tropics;
import tropics.entity.AnglerFishEntity;
import tropics.entity.RavenEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID)
public class TropicsEntities {
	//Bosses
	
	
	//Passive Mobs
	public static final EntityType<AnglerFishEntity> ANGLER_FISH = EntityType.Builder.<AnglerFishEntity>create(AnglerFishEntity::new, EntityClassification.WATER_CREATURE).size(0.5f, 0.5f).build(Tropics.MOD_ID + ":angler_fish");
	public static final EntityType<RavenEntity> RAVEN = EntityType.Builder.<RavenEntity>create(RavenEntity::new, EntityClassification.CREATURE).size(0.5f, 0.5f).build(Tropics.MOD_ID + ":raven");
	//Projectiles
	
	

	@SubscribeEvent
	public static void regsiterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> reg = event.getRegistry();
		
		ANGLER_FISH.setRegistryName(Tropics.MOD_ID, "angler_fish");
		RAVEN.setRegistryName(Tropics.MOD_ID, "raven");
		
		reg.register(ANGLER_FISH);
		reg.register(RAVEN);
		
		GlobalEntityTypeAttributes.put(ANGLER_FISH, AnglerFishEntity.getAttributes().create());
		GlobalEntityTypeAttributes.put(RAVEN, RavenEntity.getAttributes().create());
	}
}
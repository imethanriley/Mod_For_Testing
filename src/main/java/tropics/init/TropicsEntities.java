package tropics.init;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tropics.Tropics;
import tropics.entity.AnglerFishEntity;
import tropics.entity.MineEntity;
import tropics.entity.RavenEntity;
import tropics.entity.VulcanEntity;
import tropics.entity.VulcanEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID)
public class TropicsEntities {
	
	//Bosses
	public static final EntityType<VulcanEntity> VULCAN = EntityType.Builder.<VulcanEntity>create(VulcanEntity::new, EntityClassification.MONSTER).size(2.6f, 3.8f).build(Tropics.MOD_ID + ":vulcan");
	
	//Passive Mobs
	public static final EntityType<AnglerFishEntity> ANGLER_FISH = EntityType.Builder.<AnglerFishEntity>create(AnglerFishEntity::new, EntityClassification.WATER_CREATURE).size(0.5f, 0.5f).build(Tropics.MOD_ID + ":angler_fish");
	public static final EntityType<RavenEntity> RAVEN = EntityType.Builder.<RavenEntity>create(RavenEntity::new, EntityClassification.CREATURE).size(0.5f, 0.5f).build(Tropics.MOD_ID + ":raven");
	
	//Projectiles
	public static final EntityType<MineEntity> MINE = EntityType.Builder.<MineEntity>create(MineEntity::new, EntityClassification.MISC).size(0.5f, 0.5f).build(Tropics.MOD_ID + ":mine");
	

	@SubscribeEvent
	public static void regsiterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> reg = event.getRegistry();
		
		VULCAN.setRegistryName(Tropics.MOD_ID, "vulcan");
		ANGLER_FISH.setRegistryName(Tropics.MOD_ID, "angler_fish");
		RAVEN.setRegistryName(Tropics.MOD_ID, "raven");
		MINE.setRegistryName(Tropics.MOD_ID, "mine");
		
		reg.register(VULCAN);
		reg.register(ANGLER_FISH);
		reg.register(RAVEN);
		reg.register(MINE);
		
		GlobalEntityTypeAttributes.put(VULCAN, VulcanEntity.setCustomAttributes().create());
		GlobalEntityTypeAttributes.put(ANGLER_FISH, AnglerFishEntity.getAttributes().create());
		GlobalEntityTypeAttributes.put(RAVEN, RavenEntity.getAttributes().create());
		
	}
}
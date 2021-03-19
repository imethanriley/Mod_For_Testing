package tropics.init;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import tropics.Tropics;
import tropics.entities.entity.boss.MineEntity;
import tropics.entities.entity.boss.VulcanEntity;
import tropics.entities.entity.passive.AnglerFishEntity;
import tropics.entities.entity.passive.PoisonDartFrogEntity;
import tropics.entities.entity.passive.RavenEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID)
public class TropicsEntities {
	
	//Bosses
	public static final EntityType<VulcanEntity> VULCAN = EntityType.Builder.<VulcanEntity>of(VulcanEntity::new, EntityClassification.MONSTER).sized(2.6f, 3.8f).build(Tropics.MOD_ID + ":vulcan");
	
	//Passive Mobs
	public static final EntityType<AnglerFishEntity> ANGLER_FISH = EntityType.Builder.<AnglerFishEntity>of(AnglerFishEntity::new, EntityClassification.WATER_CREATURE).sized(0.5f, 0.5f).build(Tropics.MOD_ID + ":angler_fish");
	public static final EntityType<RavenEntity> RAVEN = EntityType.Builder.<RavenEntity>of(RavenEntity::new, EntityClassification.CREATURE).sized(0.5f, 0.5f).build(Tropics.MOD_ID + ":raven");
	public static final EntityType<PoisonDartFrogEntity> POISON_DART_FROG = EntityType.Builder.<PoisonDartFrogEntity>of(PoisonDartFrogEntity::new, EntityClassification.CREATURE).sized(0.45f, 0.45f).build(Tropics.MOD_ID + ":poison_dart_frog");
	
	//Projectiles
	public static final EntityType<MineEntity> MINE = EntityType.Builder.<MineEntity>of(MineEntity::new, EntityClassification.MISC).sized(0.5f, 0.5f).build(Tropics.MOD_ID + ":mine");
	

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		IForgeRegistry<EntityType<?>> reg = event.getRegistry();
		
		VULCAN.setRegistryName(Tropics.MOD_ID, "vulcan");
		ANGLER_FISH.setRegistryName(Tropics.MOD_ID, "angler_fish");
		RAVEN.setRegistryName(Tropics.MOD_ID, "raven");
		POISON_DART_FROG.setRegistryName(Tropics.MOD_ID, "poison_dart_frog");
		MINE.setRegistryName(Tropics.MOD_ID, "mine");
		
		reg.register(VULCAN);
		reg.register(ANGLER_FISH);
		reg.register(RAVEN);
		reg.register(POISON_DART_FROG);
		reg.register(MINE);
		
		GlobalEntityTypeAttributes.put(VULCAN, VulcanEntity.registerAttributes().build());
		GlobalEntityTypeAttributes.put(ANGLER_FISH, AnglerFishEntity.registerAttributes().build());
		GlobalEntityTypeAttributes.put(RAVEN, RavenEntity.registerAttributes().build());
		GlobalEntityTypeAttributes.put(POISON_DART_FROG, PoisonDartFrogEntity.registerAttributes().build());
		
	}
}
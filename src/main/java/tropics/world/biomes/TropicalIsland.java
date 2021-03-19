package tropics.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tropics.init.TropicsEntities;
import tropics.world.generation.BiomeGeneration;

@BiomeGeneration.TropicsBiomes.NewBiome
public class TropicalIsland extends BiomeGeneration.TropicsBiomes 
{
	public TropicalIsland(BiomeGeneration instance) {
		super(instance, 1);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	public static Biome biome;
	
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			biome = makeTropicalIslandBiome(0.2f, 0.3f);
			event.getRegistry().register(biome.setRegistryName("tropics:tropical_island"));
		}
	}
	
	public static Biome makeTropicalIslandBiome(float depth, float scale) {
	      MobSpawnInfo.Builder SPAWN_SETTINGS = (new MobSpawnInfo.Builder());
	      BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.BADLANDS);
	      
	      //Structures
	      GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
	      GENERATION_SETTINGS.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
	      
	      //Features
	      DefaultBiomeFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultCarvers(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultLakes(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addMushroomFieldVegetation(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.addDefaultSprings(GENERATION_SETTINGS);
	      
	      SPAWN_SETTINGS.addSpawn(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.ANGLER_FISH, 1000, 3, 6));
	      SPAWN_SETTINGS.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.RAVEN, 20, 2, 6));
	      SPAWN_SETTINGS.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.POISON_DART_FROG, 20, 4, 8));
	      
	      return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.OCEAN).depth(depth).scale(scale).temperature(0.9F).downfall(1.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColorWithTemperatureModifier(0.9F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(SPAWN_SETTINGS.build()).generationSettings(GENERATION_SETTINGS.build()).build();
  }
	
	private static int getSkyColorWithTemperatureModifier(float temperature) {
	      float lvt_1_1_ = temperature / 3.0F;
	      lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
	      return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	@SuppressWarnings("deprecation")
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.create(Registry.BIOME_REGISTRY, WorldGenRegistries.BIOME.getKey(biome)), BiomeDictionary.Type.MUSHROOM);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.create(Registry.BIOME_REGISTRY, WorldGenRegistries.BIOME.getKey(biome)), 500));
	}
	
}

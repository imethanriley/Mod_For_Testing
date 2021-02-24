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
import tropics.lists.TropicsEntities;
import tropics.misc.BoimeGenHelper;

@BoimeGenHelper.ModElement.Tag
public class TropicalIsland extends BoimeGenHelper.ModElement {
	public TropicalIsland(BoimeGenHelper instance) {
		super(instance, 666);
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
	      MobSpawnInfo.Builder SPAWN_SETTINGS = (new MobSpawnInfo.Builder()).withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.ANGLER_FISH, 1000, 100, 400));
	      BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244169_a);
	      
	      //Structures
	      GENERATION_SETTINGS.withStructure(StructureFeatures.RUINED_PORTAL);
	      GENERATION_SETTINGS.withStructure(StructureFeatures.VILLAGE_PLAINS);
	      
	      //Features
	      DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withLavaAndWaterLakes(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withMushroomBiomeVegetation(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withLavaAndWaterSprings(GENERATION_SETTINGS);
	      DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
	      
	      SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.RAVEN, 1000, 100, 200));
	      
	      return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(depth).scale(scale).temperature(0.9F).downfall(1.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.9F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(SPAWN_SETTINGS.copy()).withGenerationSettings(GENERATION_SETTINGS.build()).build();
  }
	
	private static int getSkyColorWithTemperatureModifier(float temperature) {
	      float lvt_1_1_ = temperature / 3.0F;
	      lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
	      return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
	
	@SuppressWarnings("deprecation")
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), BiomeDictionary.Type.MUSHROOM);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
				new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome)), 1000));
	}
	
}
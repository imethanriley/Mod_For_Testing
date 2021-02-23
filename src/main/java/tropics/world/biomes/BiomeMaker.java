package tropics.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.Mod;
import tropics.Tropics;
import tropics.lists.TropicsBiomes;
import tropics.lists.TropicsEntities;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Tropics.MOD_ID)
public class BiomeMaker {
	public static Biome makeTropicalIslandBiome(float depth, float scale) {
	      MobSpawnInfo.Builder SPAWNER = (new MobSpawnInfo.Builder()).withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(TropicsEntities.ANGLER_FISH, 1000, 100, 400));
	      BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244173_e);
	      
	      //Structures
	      GENERATION_SETTINGS.withStructure(StructureFeatures.RUINED_PORTAL);
	      
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
	      return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(depth).scale(scale).temperature(0.9F).downfall(1.0F).setEffects((new BiomeAmbience.Builder()).setWaterColor(4159204).setWaterFogColor(329011).setFogColor(12638463).withSkyColor(getSkyColorWithTemperatureModifier(0.9F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(SPAWNER.copy()).withGenerationSettings(GENERATION_SETTINGS.build()).build();
    }
	
	private static int getSkyColorWithTemperatureModifier(float temperature) {
	      float lvt_1_1_ = temperature / 3.0F;
	      lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
	      return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
	}
}

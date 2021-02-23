package tropics.lists;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tropics.Tropics;
import tropics.world.biomes.BiomeMaker;

public class TropicsBiomes {
	
	public static final RegistryKey<Biome> TROPICAL_ISLAND_KEY = makeKey("tropical_island");
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Tropics.MOD_ID);
	public static RegistryObject<Biome> TROPICAL_ISLAND = BIOMES.register("tropical_island", () -> BiomeMaker.makeTropicalIslandBiome(0.2f, 0.3f));
	
	public static void registerBiomes() {
        registerBiome(BiomeManager.BiomeType.WARM, TROPICAL_ISLAND, 5000);
        BiomeDictionary.addTypes(getBiomeKey(TROPICAL_ISLAND.getId()), Type.LUSH, Type.PLAINS, Type.OVERWORLD);
	}
	
	private static void registerBiome(BiomeManager.BiomeType type, RegistryObject<Biome> biome, int weight) {
	    RegistryKey<Biome> key = getBiomeKey(biome.getId());
	    BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
	}
	
	public static RegistryKey<Biome> getBiomeKey(ResourceLocation id) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, id);
    }
	
	private static RegistryKey<Biome> makeKey(String name) {
	      return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(name));
	}
}

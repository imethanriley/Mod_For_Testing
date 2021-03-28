package tropics.world.generation;

import java.util.ArrayList;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tropics.TestMod;
import tropics.init.blocks.ModBlocks;

@Mod.EventBusSubscriber
public class OreGeneration 
{
	private static final ArrayList<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> NETHER_ORES = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> END_ORES = new ArrayList<ConfiguredFeature<?, ?>>();
    
    public static void registerOre()
    {
    	//NATURAL_STONE is for generating in stone, granite, diorite, and andesite
        //NETHERRACK is for generating in netherrack
        //BASE_STONE_NETHER is for generating in netherrack, basalt and blackstone
    	//END_STONE is for generating in end stone
    	
    	//Overworld Ore Register
    	OVERWORLD_ORES.add(register("dominus_ore", Feature.ORE.configured(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.DOMINUS_ORE.getBlock().defaultBlockState(), 12)) //Vein Size
                .range(128).squared() //Spawn height start
                .count(64))); //Chunk spawn frequency
        
      //Nether Ore Register
    	NETHER_ORES.add(register("dominus_ore", Feature.ORE.configured(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.DOMINUS_ORE.getBlock().defaultBlockState(), 12)) //Vein Size
                .range(128).squared() //Spawn height start
                .count(64))); //Chunk spawn frequency
 
        //The End Ore Register
    	END_ORES.add(register("dominus_ore", Feature.ORE.configured(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.DOMINUS_ORE.getBlock().defaultBlockState(), 12)) //Vein Size
                .range(128).squared() //Spawn height start
                .count(64))); //Chunk spawn frequency
        
    }
    
    //Biome.Category.TROPICS
    
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : NETHER_ORES){
                if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : END_ORES){
                if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : OVERWORLD_ORES){
            if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }
    
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) 
    {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, TestMod.MOD_ID + ":" + name, configuredFeature);
    }
}

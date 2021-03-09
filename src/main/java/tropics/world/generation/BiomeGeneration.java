package tropics.world.generation;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.ModList;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class BiomeGeneration {
	
	public final List<TropicsBiomes> biomes = new ArrayList<>();
	
	public BiomeGeneration() {
		
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("tropics").getFile().getScanResult();
			
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(TropicsBiomes.NewBiome.class.getName())) {
					Class<?> biomeClass = Class.forName(annotationData.getClassType().getClassName());
					if (biomeClass.getSuperclass() == BiomeGeneration.TropicsBiomes.class)
						biomes.add((BiomeGeneration.TropicsBiomes) biomeClass.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(biomes);
		biomes.forEach(BiomeGeneration.TropicsBiomes::initBiomes);
	}
	
	public List<TropicsBiomes> getBiomes() {
		return biomes;
	}
	
	public static class TropicsBiomes implements Comparable<TropicsBiomes> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface NewBiome { }
		
		protected final BiomeGeneration biomes;
		
		protected final int sortid;
		
		public TropicsBiomes(BiomeGeneration biomes, int sortid) {
			this.biomes = biomes;
			this.sortid = sortid;
		}

		public void initBiomes() { }

		public void init(FMLCommonSetupEvent event) { }

		@Override
		public int compareTo(TropicsBiomes other) {
			return this.sortid - other.sortid;
		}
	}
}

package tropics.world.generation;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class DimensionGeneration {
	
	public final List<TropicsDimensions> dimension = new ArrayList<>();
	
	public DimensionGeneration() {
		
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("tropics").getFile().getScanResult();
			
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(TropicsDimensions.NewDimension.class.getName())) {
					Class<?> dimensionClass = Class.forName(annotationData.getClassType().getClassName());
					if (dimensionClass.getSuperclass() == DimensionGeneration.TropicsDimensions.class)
						dimension.add((DimensionGeneration.TropicsDimensions) dimensionClass.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(dimension);
		dimension.forEach(DimensionGeneration.TropicsDimensions::initDimensions);
	}
	
	public List<TropicsDimensions> getDimensions() {
		return dimension;
	}
	
	public static class TropicsDimensions implements Comparable<TropicsDimensions> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface NewDimension { }
		
		protected final DimensionGeneration dimension;
		
		protected final int sortid;
		
		public TropicsDimensions(DimensionGeneration dimension, int sortid) {
			this.dimension = dimension;
			this.sortid = sortid;
		}

		public void initDimensions() { }

		public void init(FMLCommonSetupEvent event) { }

		@Override
		public int compareTo(TropicsDimensions other) {
			return this.sortid - other.sortid;
		}
		
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			
		}
	}
}
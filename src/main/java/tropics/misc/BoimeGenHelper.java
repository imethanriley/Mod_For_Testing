package tropics.misc;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class BoimeGenHelper {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("tropics", "tropics"),
			() -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	
	public final List<ModElement> elements = new ArrayList<>();
	
	public BoimeGenHelper() {
		
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("tropics").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == BoimeGenHelper.ModElement.class)
						elements.add((BoimeGenHelper.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}/*
		*/
		Collections.sort(elements);
		elements.forEach(BoimeGenHelper.ModElement::initElements);
	}
	
	public List<ModElement> getElements() {
		return elements;
	}
	
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final BoimeGenHelper elements;
		protected final int sortid;
		public ModElement(BoimeGenHelper elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}

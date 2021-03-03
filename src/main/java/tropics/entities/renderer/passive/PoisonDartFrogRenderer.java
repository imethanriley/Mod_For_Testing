package tropics.entities.renderer.passive;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import tropics.Tropics;
import tropics.entities.entity.passive.PoisonDartFrogEntity;
import tropics.entities.model.passive.PoisonDartFrogModel;

public class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrogEntity, PoisonDartFrogModel>  {
	private static final ResourceLocation BLUE_SPOTTED = Tropics.location("textures/entity/dartfrog/dart_frog_blue_spotted.png");
	private static final ResourceLocation GREEN_SPOTTED = Tropics.location("textures/entity/dartfrog/dart_frog_green_spotted.png");
	private static final ResourceLocation TYPE_3 = Tropics.location("textures/entity/dartfrog/dart_frog_3.png");
	private static final ResourceLocation TYPE_4 = Tropics.location("textures/entity/dartfrog/dart_frog_4.png");
	private static final ResourceLocation TYPE_5 = Tropics.location("textures/entity/dartfrog/dart_frog_5.png");
	private static final ResourceLocation TYPE_6 = Tropics.location("textures/entity/dartfrog/dart_frog_6.png");
	private static final ResourceLocation TYPE_7 = Tropics.location("textures/entity/dartfrog/dart_frog_7.png");
	private static final ResourceLocation TYPE_8 = Tropics.location("textures/entity/dartfrog/dart_frog_8.png");
	
	public PoisonDartFrogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PoisonDartFrogModel(), 0.3F);
	}
	
	public ResourceLocation getEntityTexture(PoisonDartFrogEntity entity) {
		switch(entity.getDartFrogType()) {
		case 0:
		default:
			return BLUE_SPOTTED;
		case 1:
			return GREEN_SPOTTED;
		case 2:
			return TYPE_3;
		case 3:
			return TYPE_4;
		case 4:
			return TYPE_5;
		case 5:
			return TYPE_6;
		case 6:
			return TYPE_7;
		case 7:
			return TYPE_8;
		}
	}
}


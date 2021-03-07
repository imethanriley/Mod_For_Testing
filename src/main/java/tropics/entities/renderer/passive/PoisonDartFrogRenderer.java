package tropics.entities.renderer.passive;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import tropics.Tropics;
import tropics.entities.entity.passive.PoisonDartFrogEntity;
import tropics.entities.model.passive.PoisonDartFrogModel;

public class PoisonDartFrogRenderer extends MobRenderer<PoisonDartFrogEntity, PoisonDartFrogModel>  {
	private static final ResourceLocation BLUE = Tropics.location("textures/entity/dartfrog/dart_frog_blue.png");
	private static final ResourceLocation GREEN_TEAL_SPOTTED = Tropics.location("textures/entity/dartfrog/dart_frog_green_teal_spotted.png");
	private static final ResourceLocation RED_BLACK_SPOTTED = Tropics.location("textures/entity/dartfrog/dart_frog_red_black_spotted.png");
	private static final ResourceLocation ORANGE_BLACK_STRIPE = Tropics.location("textures/entity/dartfrog/dart_frog_orange_black_stripe.png");
	private static final ResourceLocation ORANGE_WHITE_SPOTTED = Tropics.location("textures/entity/dartfrog/dart_frog_orange_white_spotted.png");
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
			return BLUE;
		case 1:
			return GREEN_TEAL_SPOTTED;
		case 2:
			return RED_BLACK_SPOTTED;
		case 3:
			return ORANGE_BLACK_STRIPE;
		case 4:
			return ORANGE_WHITE_SPOTTED;
		case 5:
			return TYPE_6;
		case 6:
			return TYPE_7;
		case 7:
			return TYPE_8;
		}
	}
}


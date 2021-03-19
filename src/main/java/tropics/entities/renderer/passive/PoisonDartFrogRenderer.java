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
	private static final ResourceLocation BLACK_YELLOW = Tropics.location("textures/entity/dartfrog/dart_frog_black_yellow.png");
	private static final ResourceLocation BLACK_GREEN = Tropics.location("textures/entity/dartfrog/dart_frog_black_green.png");
	private static final ResourceLocation BLACK_PURPLE = Tropics.location("textures/entity/dartfrog/dart_frog_black_purple.png");
	
	public PoisonDartFrogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PoisonDartFrogModel(), 0.3F);
	}
	
	public ResourceLocation getTextureLocation(PoisonDartFrogEntity entity) {
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
			return BLACK_YELLOW;
		case 6:
			return BLACK_GREEN;
		case 7:
			return BLACK_PURPLE;
		}
	}
}


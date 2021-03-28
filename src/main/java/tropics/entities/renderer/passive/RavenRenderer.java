package tropics.entities.renderer.passive;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import tropics.TestMod;
import tropics.entities.entity.passive.RavenEntity;
import tropics.entities.model.passive.RavenModel;

public class RavenRenderer extends MobRenderer<RavenEntity, RavenModel> {
	private static final ResourceLocation TEXTURE = TestMod.location("textures/entity/raven.png");

	public RavenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RavenModel(), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(RavenEntity entity) {
		return TEXTURE;
	}
}
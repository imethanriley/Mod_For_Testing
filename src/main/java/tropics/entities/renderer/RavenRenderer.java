package tropics.entities.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import tropics.Tropics;
import tropics.entities.entity.RavenEntity;
import tropics.entities.model.RavenModel;

public class RavenRenderer extends MobRenderer<RavenEntity, RavenModel> {
	private static final ResourceLocation TEXTURE = Tropics.location("textures/entity/raven.png");

	public RavenRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RavenModel(), 0.2F);
	}

	@Override
	public ResourceLocation getEntityTexture(RavenEntity entity) {
		return TEXTURE;
	}
}
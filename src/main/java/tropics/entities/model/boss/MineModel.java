package tropics.entities.model.boss;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import tropics.entities.entity.boss.MineEntity;

public class MineModel<T extends MineEntity> extends EntityModel<Entity> {
	private final ModelRenderer mine;

	public MineModel() {
		texWidth = 64;
		texHeight = 64;

		mine = new ModelRenderer(this);
		mine.setPos(0.0F, 24.0F - 24.0F, 0.0F);
		mine.texOffs(0, 0).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.mine.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
package tropics.entities.model.passive;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import tropics.entities.entity.passive.RavenEntity;

public class RavenModel extends SegmentedModel<RavenEntity> {
	private final ModelRenderer head;
	private final ModelRenderer beak1;
	private final ModelRenderer beak2;
	private final ModelRenderer body;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightleg;
	private final ModelRenderer rightfoot;
	private final ModelRenderer leftleg;
	private final ModelRenderer leftfoot;
	private final ModelRenderer tail;

	public RavenModel() {
		texWidth = 32;
		texHeight = 32;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 18.0F, 0.0F);
		head.texOffs(0, 0).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		beak1 = new ModelRenderer(this);
		beak1.setPos(0.0F, 0.0F, -2.5F);
		head.addChild(beak1);
		setRotationAngle(beak1, 0.2618F, 0.0F, 0.0F);
		beak1.texOffs(12, 0).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		beak2 = new ModelRenderer(this);
		beak2.setPos(0.0F, 0.0F, -2.5F);
		head.addChild(beak2);
		setRotationAngle(beak2, -0.2618F, 0.0F, 0.0F);
		beak2.texOffs(12, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 17.0F, 1.0F);
		setRotationAngle(body, -0.5236F, 0.0F, 0.0F);
		body.texOffs(0, 6).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 6.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setPos(-1.5F, 18.0F, 1.0F);
		rightarm.texOffs(0, 16).addBox(-1.0F, 0.0F, -1.5F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setPos(1.5F, 18.0F, 1.0F);
		leftarm.texOffs(0, 16).addBox(0.0F, 0.0F, -1.5F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setPos(-1.5F, 21.0F, 1.0F);
		rightleg.texOffs(14, 16).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightfoot = new ModelRenderer(this);
		rightfoot.setPos(0.0F, 2.0F, 1.0F);
		rightleg.addChild(rightfoot);
		setRotationAngle(rightfoot, 0.5236F, 0.0F, 0.0F);
		rightfoot.texOffs(14, 20).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setPos(0.5F, 21.0F, 1.0F);
		leftleg.texOffs(14, 16).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		leftfoot = new ModelRenderer(this);
		leftfoot.setPos(0.0F, 2.0F, 1.0F);
		leftleg.addChild(leftfoot);
		setRotationAngle(leftfoot, 0.5236F, 0.0F, 0.0F);
		leftfoot.texOffs(14, 20).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(0.0F, 21.0F, 4.0F);
		setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
		tail.texOffs(0, 25).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	
	@Override
	public void setupAnim(RavenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        head.xRot = headPitch / (180F / (float) Math.PI);
        head.yRot = netHeadYaw / (180F / (float) Math.PI);
        head.zRot = netHeadYaw > 5 ? -0.2617994F : 0;

        rightleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        leftleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        
        
    	if(entity.isOnGround() == false) {
    		rightarm.zRot = MathHelper.cos(limbSwing * 4F) * 3F * limbSwingAmount;
            leftarm.zRot = -MathHelper.cos(limbSwing * 4F) * 3F * limbSwingAmount;
    	}

        if (entity.isOnGround()) {
            rightleg.y = 21;
            leftleg.y = 21;
            rightarm.zRot = 0.05f;
            leftarm.zRot = -0.05f;
        } else {
            rightleg.y = 20F;
            leftleg.y = 20F;
        }
    }

	public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(
                head,
                body,
                rightarm,
                leftarm,
                rightleg,
                leftleg,
                tail
        );
    }

}
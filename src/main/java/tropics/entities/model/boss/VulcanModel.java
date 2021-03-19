package tropics.entities.model.boss;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import tropics.entities.entity.boss.VulcanEntity;

public class VulcanModel<T extends VulcanEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public VulcanModel() {
		texWidth = 256;
		texHeight = 256;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.5F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.texOffs(0, 28).addBox(-20.0F, -13.0F, 5.0F, 40.0F, 20.0F, 32.0F, 0.0F, false);
		body.texOffs(72, 6).addBox(-11.0F, -9.0F, -3.0F, 22.0F, 14.0F, 8.0F, 0.0F, false);
		body.texOffs(176, 84).addBox(-8.0F, -17.0F, 33.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);
		body.texOffs(1, 252).addBox(-0.5F, -17.4998F, 55.0001F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(6, 252).addBox(-1.5F, -17.4998F, 54.0001F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(15, 251).addBox(-0.5F, -17.4998F, 52.0001F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(50, 237).addBox(-8.5F, -15.4998F, 45.0001F, 2.0F, 14.0F, 4.0F, 0.0F, false);
		body.texOffs(1, 222).addBox(-8.5F, -1.4998F, 45.0001F, 17.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(1, 222).addBox(-8.5F, -17.4998F, 45.0001F, 17.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(12, 241).addBox(6.5F, -15.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.texOffs(12, 241).addBox(-8.5F, -15.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.texOffs(12, 241).addBox(6.5F, -4.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.texOffs(12, 241).addBox(-8.5F, -4.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 242).addBox(-6.5F, -1.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 242).addBox(-6.5F, -17.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 242).addBox(3.5F, -1.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(21, 252).addBox(-1.0F, -17.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(21, 252).addBox(-1.0F, -1.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(21, 252).addBox(-8.5F, -9.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(21, 252).addBox(6.5F, -9.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.texOffs(28, 249).addBox(6.5F, -17.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(1, 242).addBox(3.5F, -17.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(28, 249).addBox(-8.5F, -17.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(28, 249).addBox(-8.5F, -1.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(1, 247).addBox(-2.5F, -17.4998F, 49.0001F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(41, 237).addBox(8.0F, -16.4998F, 47.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 247).addBox(-2.5F, -1.4998F, 49.0001F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(41, 237).addBox(-10.0F, -16.4998F, 47.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 229).addBox(-10.0F, -0.4998F, 47.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(41, 237).addBox(-10.0F, -16.4998F, 43.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 229).addBox(-10.0F, -18.4998F, 47.0001F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 229).addBox(-10.0F, -0.4998F, 43.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 229).addBox(-10.0F, -18.4998F, 43.0001F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.texOffs(1, 234).addBox(6.5F, -10.9998F, 49.0001F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		body.texOffs(50, 237).addBox(6.5F, -15.4998F, 45.0001F, 2.0F, 14.0F, 4.0F, 0.0F, false);
		body.texOffs(1, 234).addBox(-8.5F, -10.9998F, 49.0001F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		body.texOffs(41, 237).addBox(8.0F, -16.4998F, 43.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.texOffs(28, 249).addBox(6.5F, -1.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.texOffs(159, 119).addBox(-16.0F, -10.018F, 21.506F, 32.0F, 17.0F, 17.0F, 0.0F, false);
		body.texOffs(83, 156).addBox(-20.0F, 7.0F, -11.9999F, 38.0F, 1.0F, 49.0F, 0.0F, false);
		body.texOffs(160, 212).addBox(11.0F, -14.718F, 27.506F, 23.0F, 24.0F, 14.0F, 0.0F, false);
		body.texOffs(82, 213).addBox(-34.0F, -14.718F, 27.506F, 23.0F, 24.0F, 14.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(8.0F, -14.0F, 15.0F);
		leftLeg.texOffs(192, 48).addBox(1.0F, 18.0F, -19.5F, 12.0F, 20.0F, 12.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(20.0F, -13.0F, 20.0F);
		rightLeg.texOffs(144, 48).addBox(-40.0F, 17.0F, -24.5F, 12.0F, 20.0F, 12.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(8.0F, -13.0F - 13.0F, -3.5F);
		leftArm.texOffs(31, 116).addBox(12.0F, -22.0F + 13.0F, -2.0F, 14.0F, 24.0F, 12.0F, 0.0F, false);
		leftArm.texOffs(83, 118).addBox(17.0F, 2.0F + 13.0F, -2.0F, 11.0F, 22.0F, 12.0F, 0.0F, false);
		leftArm.texOffs(145, 80).addBox(23.0F, 24.0F + 13.0F, -1.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		leftArm.texOffs(145, 80).addBox(23.0F, 24.0F + 13.0F, 5.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		leftArm.texOffs(129, 82).addBox(17.0F, 24.0F + 13.0F, -1.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-8.0F, -13.0F - 13.0F, -3.5F);
		rightArm.texOffs(129, 82).addBox(-20.0F, 24.0F + 13.0F, -1.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		rightArm.texOffs(83, 82).addBox(-28.0F, 2.0F + 13.0F, -2.0F, 11.0F, 22.0F, 12.0F, 0.0F, false);
		rightArm.texOffs(145, 80).addBox(-26.0F, 24.0F + 13.0F, -1.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		rightArm.texOffs(145, 80).addBox(-26.0F, 24.0F + 13.0F, 5.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		rightArm.texOffs(31, 80).addBox(-26.0F, -22.0F + 13.0F, -2.0F, 14.0F, 24.0F, 12.0F, 0.0F, false);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		//this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		/*
		this.leftLeg.rotateAngleX = -0.5F * MathHelper.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.rightLeg.rotateAngleX = 0.5F * MathHelper.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.leftLeg.rotateAngleY = 0.0F;
		this.rightLeg.rotateAngleY = 0.0F;
		 */


		// reset body and arms
		this.body.yRot = 0.0F;
		this.rightArm.z = -3.5F; // original rotationPointZ of rightArm
		this.rightArm.x = -8.0F; // original rotationPointX of rightArm
		this.leftArm.z = -3.5F; // original rotationPointZ of leftArm
		this.leftArm.x = 8.0F; // original rotationPointX of leftArm

		// animate arms on X-axis
		this.rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		// reset rotateAngleZ for arms
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		// animate legs on X-axis
		this.rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F; // since the Redstone Golem's legs are small, need to reduce the angle change by 50%
		this.leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F; // since the Redstone Golem's legs are small, need to reduce the angle change by 50%
		// reset rotateAngleY and rotateAngleZ for legs
		this.rightLeg.yRot = 0.0F;
		this.leftLeg.yRot = 0.0F;
		this.rightLeg.zRot = 0.0F;
		this.leftLeg.zRot = 0.0F;

		// reset rightArm and leftArm rotateAngleY before animating swing progress
		this.rightArm.yRot = 0.0F;
		this.leftArm.yRot = 0.0F;
		this.animateSwingProgress(entity, ageInTicks);

		// reset rotateAngleX for body
		this.body.xRot = 1.5708F; // original rotateAngleX of body

		// reset rotationPointZ and rotationPointY for legs
		this.rightLeg.z = 20.01F; // original rotationPointZ of rightLeg
		this.leftLeg.z = 15.01F; // original rotationPointZ of leftLeg
		this.rightLeg.y = -13.0F; // original rotationPointY for rightLeg
		this.leftLeg.y = -14.0F; // original rotationPointY for leftLeg

		// reset rotationPointY for body
		this.body.y = 0.5F; // original rotationPointY for body

		// reset rotationPointY for arms
		this.leftArm.y = -26.0F; // original rotationPointY for leftArm
		this.rightArm.y = -26.0F; // original rotationPointY for rightArm

		// animate arms on X-axis and Z-axis
		ModelHelper.bobArms(this.rightArm, this.leftArm, ageInTicks);
	}


	private HandSide getMainHand(T entityIn) {
		HandSide handside = entityIn.getMainArm();
		return entityIn.swingingArm == Hand.MAIN_HAND ? handside : handside.getOpposite();
	}

	private ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.leftArm : this.rightArm;
	}

	private void animateSwingProgress(T entity, float ageInTicks) {
		if (!(this.attackTime <= 0.0F)) {
			HandSide handside = this.getMainHand(entity);
			ModelRenderer modelrenderer = this.getArmForSide(handside);
			float f = this.attackTime;
			this.body.yRot = MathHelper.sin(MathHelper.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.body.yRot *= -1.0F;
			}

			this.rightArm.z = MathHelper.sin(this.body.yRot) * 5.0F;
			this.rightArm.x = -MathHelper.cos(this.body.yRot) * 5.0F;
			this.leftArm.z = -MathHelper.sin(this.body.yRot) * 5.0F;
			this.leftArm.x = MathHelper.cos(this.body.yRot) * 5.0F;
			this.rightArm.yRot += this.body.yRot;
			this.leftArm.yRot += this.body.yRot;
			this.leftArm.xRot += this.body.yRot;
			f = 1.0F - this.attackTime;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = MathHelper.sin(f * (float)Math.PI);
			float f2 = MathHelper.sin(this.attackTime * (float)Math.PI) * -(this.body.xRot - 0.7F) * 0.75F; // originally head
			modelrenderer.xRot = (float)((double)modelrenderer.xRot - ((double)f1 * 1.2D + (double)f2));
			modelrenderer.yRot += this.body.yRot * 2.0F;
			modelrenderer.zRot += MathHelper.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}


	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		this.parts().forEach((part) -> part.render(matrixStack, buffer, packedLight, packedOverlay));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}
package tropics.entities.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import tropics.entities.entity.VulcanEntity;

public class VulcanModel<T extends VulcanEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public VulcanModel() {
		textureWidth = 256;
		textureHeight = 256;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.5F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 28).addBox(-20.0F, -13.0F, 5.0F, 40.0F, 20.0F, 32.0F, 0.0F, false);
		body.setTextureOffset(72, 6).addBox(-11.0F, -9.0F, -3.0F, 22.0F, 14.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(176, 84).addBox(-8.0F, -17.0F, 33.0F, 16.0F, 17.0F, 15.0F, 0.0F, false);
		body.setTextureOffset(1, 252).addBox(-0.5F, -17.4998F, 55.0001F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(6, 252).addBox(-1.5F, -17.4998F, 54.0001F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(15, 251).addBox(-0.5F, -17.4998F, 52.0001F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(50, 237).addBox(-8.5F, -15.4998F, 45.0001F, 2.0F, 14.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(1, 222).addBox(-8.5F, -1.4998F, 45.0001F, 17.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(1, 222).addBox(-8.5F, -17.4998F, 45.0001F, 17.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(12, 241).addBox(6.5F, -15.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(12, 241).addBox(-8.5F, -15.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(12, 241).addBox(6.5F, -4.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(12, 241).addBox(-8.5F, -4.4998F, 49.0001F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 242).addBox(-6.5F, -1.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 242).addBox(-6.5F, -17.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 242).addBox(3.5F, -1.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(21, 252).addBox(-1.0F, -17.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(21, 252).addBox(-1.0F, -1.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(21, 252).addBox(-8.5F, -9.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(21, 252).addBox(6.5F, -9.4998F, 51.0001F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(28, 249).addBox(6.5F, -17.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(1, 242).addBox(3.5F, -17.4998F, 49.0001F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(28, 249).addBox(-8.5F, -17.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(28, 249).addBox(-8.5F, -1.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(1, 247).addBox(-2.5F, -17.4998F, 49.0001F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(41, 237).addBox(8.0F, -16.4998F, 47.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 247).addBox(-2.5F, -1.4998F, 49.0001F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(41, 237).addBox(-10.0F, -16.4998F, 47.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 229).addBox(-10.0F, -0.4998F, 47.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(41, 237).addBox(-10.0F, -16.4998F, 43.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 229).addBox(-10.0F, -18.4998F, 47.0001F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 229).addBox(-10.0F, -0.4998F, 43.0F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 229).addBox(-10.0F, -18.4998F, 43.0001F, 20.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(1, 234).addBox(6.5F, -10.9998F, 49.0001F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(50, 237).addBox(6.5F, -15.4998F, 45.0001F, 2.0F, 14.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(1, 234).addBox(-8.5F, -10.9998F, 49.0001F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(41, 237).addBox(8.0F, -16.4998F, 43.0001F, 2.0F, 16.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(28, 249).addBox(6.5F, -1.4998F, 49.0001F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(159, 119).addBox(-16.0F, -10.018F, 21.506F, 32.0F, 17.0F, 17.0F, 0.0F, false);
		body.setTextureOffset(83, 156).addBox(-20.0F, 7.0F, -11.9999F, 38.0F, 1.0F, 49.0F, 0.0F, false);
		body.setTextureOffset(160, 212).addBox(11.0F, -14.718F, 27.506F, 23.0F, 24.0F, 14.0F, 0.0F, false);
		body.setTextureOffset(82, 213).addBox(-34.0F, -14.718F, 27.506F, 23.0F, 24.0F, 14.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(8.0F, -14.0F, 15.0F);
		leftLeg.setTextureOffset(192, 48).addBox(1.0F, 18.0F, -19.5F, 12.0F, 20.0F, 12.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(20.0F, -13.0F, 20.0F);
		rightLeg.setTextureOffset(144, 48).addBox(-40.0F, 17.0F, -24.5F, 12.0F, 20.0F, 12.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(8.0F, -13.0F - 13.0F, -3.5F);
		leftArm.setTextureOffset(31, 116).addBox(12.0F, -22.0F + 13.0F, -2.0F, 14.0F, 24.0F, 12.0F, 0.0F, false);
		leftArm.setTextureOffset(83, 118).addBox(17.0F, 2.0F + 13.0F, -2.0F, 11.0F, 22.0F, 12.0F, 0.0F, false);
		leftArm.setTextureOffset(145, 80).addBox(23.0F, 24.0F + 13.0F, -1.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		leftArm.setTextureOffset(145, 80).addBox(23.0F, 24.0F + 13.0F, 5.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		leftArm.setTextureOffset(129, 82).addBox(17.0F, 24.0F + 13.0F, -1.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-8.0F, -13.0F - 13.0F, -3.5F);
		rightArm.setTextureOffset(129, 82).addBox(-20.0F, 24.0F + 13.0F, -1.0F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(83, 82).addBox(-28.0F, 2.0F + 13.0F, -2.0F, 11.0F, 22.0F, 12.0F, 0.0F, false);
		rightArm.setTextureOffset(145, 80).addBox(-26.0F, 24.0F + 13.0F, -1.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(145, 80).addBox(-26.0F, 24.0F + 13.0F, 5.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(31, 80).addBox(-26.0F, -22.0F + 13.0F, -2.0F, 14.0F, 24.0F, 12.0F, 0.0F, false);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		//this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		/*
		this.leftLeg.rotateAngleX = -0.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
		this.rightLeg.rotateAngleX = 0.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
		this.leftLeg.rotateAngleY = 0.0F;
		this.rightLeg.rotateAngleY = 0.0F;
		 */


		// reset body and arms
		this.body.rotateAngleY = 0.0F;
		this.rightArm.rotationPointZ = -3.5F; // original rotationPointZ of rightArm
		this.rightArm.rotationPointX = -8.0F; // original rotationPointX of rightArm
		this.leftArm.rotationPointZ = -3.5F; // original rotationPointZ of leftArm
		this.leftArm.rotationPointX = 8.0F; // original rotationPointX of leftArm

		// animate arms on X-axis
		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		// reset rotateAngleZ for arms
		this.rightArm.rotateAngleZ = 0.0F;
		this.leftArm.rotateAngleZ = 0.0F;
		// animate legs on X-axis
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F; // since the Redstone Golem's legs are small, need to reduce the angle change by 50%
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F; // since the Redstone Golem's legs are small, need to reduce the angle change by 50%
		// reset rotateAngleY and rotateAngleZ for legs
		this.rightLeg.rotateAngleY = 0.0F;
		this.leftLeg.rotateAngleY = 0.0F;
		this.rightLeg.rotateAngleZ = 0.0F;
		this.leftLeg.rotateAngleZ = 0.0F;

		// reset rightArm and leftArm rotateAngleY before animating swing progress
		this.rightArm.rotateAngleY = 0.0F;
		this.leftArm.rotateAngleY = 0.0F;
		this.animateSwingProgress(entity, ageInTicks);

		// reset rotateAngleX for body
		this.body.rotateAngleX = 1.5708F; // original rotateAngleX of body

		// reset rotationPointZ and rotationPointY for legs
		this.rightLeg.rotationPointZ = 20.01F; // original rotationPointZ of rightLeg
		this.leftLeg.rotationPointZ = 15.01F; // original rotationPointZ of leftLeg
		this.rightLeg.rotationPointY = -13.0F; // original rotationPointY for rightLeg
		this.leftLeg.rotationPointY = -14.0F; // original rotationPointY for leftLeg

		// reset rotationPointY for body
		this.body.rotationPointY = 0.5F; // original rotationPointY for body

		// reset rotationPointY for arms
		this.leftArm.rotationPointY = -26.0F; // original rotationPointY for leftArm
		this.rightArm.rotationPointY = -26.0F; // original rotationPointY for rightArm

		// animate arms on X-axis and Z-axis
		ModelHelper.func_239101_a_(this.rightArm, this.leftArm, ageInTicks);
	}


	private HandSide getMainHand(T entityIn) {
		HandSide handside = entityIn.getPrimaryHand();
		return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	}

	private ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.leftArm : this.rightArm;
	}

	private void animateSwingProgress(T entity, float ageInTicks) {
		if (!(this.swingProgress <= 0.0F)) {
			HandSide handside = this.getMainHand(entity);
			ModelRenderer modelrenderer = this.getArmForSide(handside);
			float f = this.swingProgress;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.body.rotateAngleY *= -1.0F;
			}

			this.rightArm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.rightArm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.leftArm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.leftArm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.rightArm.rotateAngleY += this.body.rotateAngleY;
			this.leftArm.rotateAngleY += this.body.rotateAngleY;
			this.leftArm.rotateAngleX += this.body.rotateAngleY;
			f = 1.0F - this.swingProgress;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = MathHelper.sin(f * (float)Math.PI);
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.body.rotateAngleX - 0.7F) * 0.75F; // originally head
			modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)f1 * 1.2D + (double)f2));
			modelrenderer.rotateAngleY += this.body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
		}
	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		this.getParts().forEach((part) -> part.render(matrixStack, buffer, packedLight, packedOverlay));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
package tropics.entities.model.passive;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import tropics.entities.entity.passive.PoisonDartFrogEntity;

public class PoisonDartFrogModel extends SegmentedModel<PoisonDartFrogEntity>  {
	private final ModelRenderer left_foot;
	private final ModelRenderer bone3;
	private final ModelRenderer toes5;
	private final ModelRenderer toes6;
	
	private final ModelRenderer right_foot;
	private final ModelRenderer bone4;
	private final ModelRenderer toes7;
	private final ModelRenderer toes8;
	
	private final ModelRenderer left_thigh;
	private final ModelRenderer right_thigh;
	private final ModelRenderer body;
	
	private final ModelRenderer left_arm;
	private final ModelRenderer bone;
	private final ModelRenderer toes;
	private final ModelRenderer toes2;
	
	private final ModelRenderer right_arm;
	private final ModelRenderer bone2;
	private final ModelRenderer toes3;
	private final ModelRenderer toes4;
	
	private final ModelRenderer head;
	
	private float jumpRotation;

	public PoisonDartFrogModel() {
		texWidth = 64;
		texHeight = 32;

		left_foot = new ModelRenderer(this);
		left_foot.setPos(3.0F, 17.5F, 3.7F);
		left_foot.texOffs(26, 24).addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F);
		left_foot.mirror = true;

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.25F, 7.5F, -5.2F);
		left_foot.addChild(bone3);
		bone3.texOffs(52, 29).addBox(-0.7529F, -1.9F, 0.2326F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes5 = new ModelRenderer(this);
		toes5.setPos(-1.5F, 9.0F, -4.042F);
		left_foot.addChild(toes5);
		setRotationAngle(toes5, 0.0F, 0.5672F, 0.0F);
		toes5.texOffs(45, 29).addBox(-0.5F, -3.25F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes6 = new ModelRenderer(this);
		toes6.setPos(-1F, 6.0F, -4.042F);
		left_foot.addChild(toes6);
		setRotationAngle(toes6, 0.0F, -0.5672F, 0.0F);
		toes6.texOffs(58, 29).addBox(1.6085F, -0.25F, -1.8432F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		right_foot = new ModelRenderer(this);
		right_foot.setPos(-3.0F, 17.5F, 3.7F);
		right_foot.texOffs(8, 24).addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F);
		right_foot.mirror = true;
		
		bone4 = new ModelRenderer(this);
		bone4.setPos(0.25F, 7.5F, -5.2F);
		right_foot.addChild(bone4);
		bone4.texOffs(52, 29).addBox(-0.7529F, -1.9F, 0.2326F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes7 = new ModelRenderer(this);
		toes7.setPos(-1.5F, 9.0F, -4.042F);
		right_foot.addChild(toes7);
		setRotationAngle(toes7, 0.0F, 0.5672F, 0.0F);
		toes7.texOffs(45, 29).addBox(-0.5F, -3.25F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes8 = new ModelRenderer(this);
		toes8.setPos(-1F, 6.0F, -4.042F);
		right_foot.addChild(toes8);
		setRotationAngle(toes8, 0.0F, -0.5672F, 0.0F);
		toes8.texOffs(58, 29).addBox(1.6085F, -0.25F, -1.8432F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		left_thigh = new ModelRenderer(this);
		left_thigh.setPos(3.0F, 17.5F, 3.7F);
		left_thigh.texOffs(16, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F);
		setRotationAngle(this.left_thigh, -0.34906584F, 0.0F, 0.0F);
		left_thigh.mirror = true;
		
		right_thigh = new ModelRenderer(this);
		right_thigh.setPos(-3.0F, 17.5F, 3.7F);
		right_thigh.texOffs(30, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F);
		setRotationAngle(this.right_thigh, -0.34906584F, 0.0F, 0.0F);
		right_thigh.mirror = true;
		
		body = new ModelRenderer(this);
		body.setPos(0.0F, 19.0F, 8.0F);
		body.texOffs(0, 0).addBox(-3.0F, -2.0F, -10.0F, 6.0F, 5.0F, 10.0F);
		setRotationAngle(this.body, -0.34906584F, 0.0F, 0.0F);
		body.mirror = true;
		
		left_arm = new ModelRenderer(this);
		left_arm.setPos(3.0F, 17.0F, -1.0F);
		left_arm.texOffs(8, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F);
		setRotationAngle(this.left_arm, -0.34906584F, 0.0F, 0.0F);
		left_arm.mirror = true;
		
		bone = new ModelRenderer(this);
		bone.setPos(0.25F, 8.0F, -3.0F);
		left_arm.addChild(bone);
		bone.texOffs(54, 24).addBox(-0.7529F, -1.9F, 0.2326F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		toes = new ModelRenderer(this);
		toes.setPos(-1.5F, 6.5F, -1.842F);
		left_arm.addChild(toes);
		setRotationAngle(toes, 0.0F, 0.5672F, 0.0F);
		toes.texOffs(45, 29).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes2 = new ModelRenderer(this);
		toes2.setPos(-1F, 6.5F, -1.842F);
		left_arm.addChild(toes2);
		setRotationAngle(toes2, 0.0F, -0.5672F, 0.0F);
		toes2.texOffs(58, 29).addBox(1.6085F, -0.25F, -1.8432F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(-3.0F, 17.0F, -1.0F);
		right_arm.texOffs(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F);
		setRotationAngle(this.right_arm, -0.34906584F, 0.0F, 0.0F);
		right_arm.mirror = true;
		
		bone2 = new ModelRenderer(this);
		bone2.setPos(0.25F, 8.0F, -3.0F);
		right_arm.addChild(bone2);
		bone2.texOffs(54, 24).addBox(-0.7529F, -1.9F, 0.2326F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		toes3 = new ModelRenderer(this);
		toes3.setPos(-1.5F, 6.5F, -1.842F);
		right_arm.addChild(toes3);
		setRotationAngle(toes3, 0.0F, 0.5672F, 0.0F);
		toes3.texOffs(45, 29).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		toes4 = new ModelRenderer(this);
		toes4.setPos(-1F, 6.5F, -1.842F);
		right_arm.addChild(toes4);
		setRotationAngle(toes4, 0.0F, -0.5672F, 0.0F);
		toes4.texOffs(58, 29).addBox(1.6085F, -0.25F, -1.8432F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 16.0F, -1.0F);
		head.texOffs(32, 0).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		head.texOffs(54, 1).addBox(-3.0F, -3.75F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.texOffs(54, 6).addBox(1.0F, -3.75F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.mirror = true;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
	      if (this.young) {
	         //float f = 1.5F;
	         matrixStackIn.pushPose();
	         matrixStackIn.scale(0.56666666F, 0.56666666F, 0.56666666F);
	         matrixStackIn.translate(0.0D, 1.375D, 0.125D);
	         ImmutableList.of(this.head).forEach((p_228292_8_) -> {
	            p_228292_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	         });
	         matrixStackIn.popPose();
	         matrixStackIn.pushPose();
	         matrixStackIn.scale(0.4F, 0.4F, 0.4F);
	         matrixStackIn.translate(0.0D, 2.25D, 0.0D);
	         ImmutableList.of(this.left_foot, this.right_foot, this.left_thigh, this.right_thigh, this.body, this.left_arm, this.right_arm).forEach((p_228291_8_) -> {
	            p_228291_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	         });
	         matrixStackIn.popPose();
	      } else {
	         matrixStackIn.pushPose();
	         matrixStackIn.scale(0.6F, 0.6F, 0.6F);
	         matrixStackIn.translate(0.0D, 1.0D, 0.0D);
	         ImmutableList.of(this.left_foot, this.right_foot, this.left_thigh, this.right_thigh, this.body, this.left_arm, this.right_arm, this.head).forEach((p_228290_8_) -> {
	            p_228290_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	         });
	         matrixStackIn.popPose();
	      }

	   }

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(PoisonDartFrogEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks - (float)entityIn.tickCount;
	      this.head.xRot = headPitch * ((float)Math.PI / 180F);
	      this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
	      this.jumpRotation = MathHelper.sin(entityIn.getJumpCompletion(f) * (float)Math.PI);
	      this.left_thigh.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
	      this.right_thigh.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
	      this.left_foot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
	      this.right_foot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
	      this.left_arm.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
	      this.right_arm.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
	}
	
	public void prepareMobModel(PoisonDartFrogEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	      super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
	      this.jumpRotation = MathHelper.sin(entityIn.getJumpCompletion(partialTick) * (float)Math.PI);
	   }

	@Override
	public Iterable<ModelRenderer> parts() {
		// TODO Auto-generated method stub
		return null;
	}

}
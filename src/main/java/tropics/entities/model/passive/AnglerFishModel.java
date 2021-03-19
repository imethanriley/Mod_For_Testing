package tropics.entities.model.passive;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import tropics.entities.entity.passive.AnglerFishEntity;

public class AnglerFishModel extends EntityModel<AnglerFishEntity> {
	private final ModelRenderer body;
	private final ModelRenderer fin_top;
	private final ModelRenderer body_sub_1;
	private final ModelRenderer fin_right2;
	private final ModelRenderer fin_left2;
	private final ModelRenderer fin_back;
	private final ModelRenderer head;
	private final ModelRenderer head_teeth;
	private final ModelRenderer jaw;
	private final ModelRenderer jawbone_teeth;
	private final ModelRenderer bone;
	private final ModelRenderer light;
	private final ModelRenderer light2;
	private final ModelRenderer light3;
	private final ModelRenderer light4;
	private final ModelRenderer tail;

	public AnglerFishModel() {
		texWidth = 32;
		texHeight = 32;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 22.0F, 0.0F);
		body.texOffs(0, 14).addBox(-1.0F, -4.75F, 0.7F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		fin_top = new ModelRenderer(this);
		fin_top.setPos(0.0F, -2.0F, 5.0F);
		body.addChild(fin_top);
		setRotationAngle(fin_top, 0.0F, -1.5708F, 0.0F);
		

		body_sub_1 = new ModelRenderer(this);
		body_sub_1.setPos(0.0F, 0.0F, 0.0F);
		fin_top.addChild(body_sub_1);
		body_sub_1.texOffs(24, 31).addBox(-2.3F, -3.75F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		body_sub_1.texOffs(18, 29).addBox(-0.3F, -0.75F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		fin_right2 = new ModelRenderer(this);
		fin_right2.setPos(-1.0F, 2.0F, 4.0F);
		body.addChild(fin_right2);
		setRotationAngle(fin_right2, 0.3054F, -0.9599F, 0.0F);
		fin_right2.texOffs(24, 20).addBox(-4.884F, -6.3967F, -1.2582F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		fin_left2 = new ModelRenderer(this);
		fin_left2.setPos(0.0F, 2.0F, 0.0F);
		body.addChild(fin_left2);
		setRotationAngle(fin_left2, 0.3054F, 0.9599F, 0.0F);
		fin_left2.texOffs(24, 25).addBox(1.181F, -5.9779F, 1.7908F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		fin_back = new ModelRenderer(this);
		fin_back.setPos(0.0F, 20.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setPos(0.0F, 22.0F, 0.0F);
		head.texOffs(0, 22).addBox(-2.0F, -5.0F, -4.3F, 4.0F, 5.0F, 5.0F, 0.0F, false);
		head.texOffs(25, 14).addBox(1.25F, -4.5F, -3.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.texOffs(25, 14).addBox(-2.25F, -4.5F, -3.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head_teeth = new ModelRenderer(this);
		head_teeth.setPos(0.0F, 1.0F, 2.0F);
		head.addChild(head_teeth);
		head_teeth.texOffs(9, 10).addBox(-1.25F, -4.75F, -6.8F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head_teeth.texOffs(9, 8).addBox(-1.25F, -3.5F, -6.8F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head_teeth.texOffs(9, 4).addBox(1.25F, -4.75F, -6.8F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head_teeth.texOffs(9, 6).addBox(1.25F, -3.5F, -6.8F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head_teeth.texOffs(8, 3).addBox(-1.15F, -5.0F, -6.8F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		head_teeth.texOffs(8, 2).addBox(0.15F, -5.0F, -6.8F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setPos(0.0F, -1.5F, -3.75F);
		head.addChild(jaw);
		setRotationAngle(jaw, -0.3927F, 0.0F, 0.0F);
		jaw.texOffs(16, 8).addBox(-1.5F, 0.3802F, -3.6249F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		jawbone_teeth = new ModelRenderer(this);
		jawbone_teeth.setPos(0.0F, 0.0F, 1.5F);
		jaw.addChild(jawbone_teeth);
		jawbone_teeth.texOffs(12, 4).addBox(-1.5F, -0.6198F, -3.1249F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jawbone_teeth.texOffs(12, 6).addBox(-1.5F, -0.6198F, -4.6249F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jawbone_teeth.texOffs(12, 10).addBox(1.5F, -0.6198F, -4.6249F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jawbone_teeth.texOffs(12, 8).addBox(1.5F, -0.6198F, -3.1249F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jawbone_teeth.texOffs(9, 13).addBox(0.25F, -0.6198F, -5.1249F, 1.0F, 1.0F, 0.0F, 0.0F, true);
		jawbone_teeth.texOffs(12, 13).addBox(-1.25F, -0.6198F, -5.1249F, 1.0F, 1.0F, 0.0F, 0.0F, true);

		bone = new ModelRenderer(this);
		bone.setPos(-0.5F, -6.0F, -3.0F);
		head.addChild(bone);
		

		light = new ModelRenderer(this);
		light.setPos(0.0F, 0.0F, 0.0F);
		bone.addChild(light);
		setRotationAngle(light, -0.6545F, 0.0F, 0.0F);
		light.texOffs(0, 10).addBox(0.0F, 1.2941F, -1.2758F, 1.0F, 0.0F, 2.0F, 0.0F, true);

		light2 = new ModelRenderer(this);
		light2.setPos(0.0F, 0.0F, 3.0F);
		bone.addChild(light2);
		light2.texOffs(1, 12).addBox(0.0F, 0.25F, -5.8F, 1.0F, 0.0F, 1.0F, 0.0F, true);

		light3 = new ModelRenderer(this);
		light3.setPos(0.0F, 0.0F, -1.0F);
		bone.addChild(light3);
		setRotationAngle(light3, 0.6109F, 0.0F, 0.0F);
		light3.texOffs(1, 13).addBox(0.0F, -0.8276F, -2.6179F, 1.0F, 0.0F, 1.0F, 0.0F, true);

		light4 = new ModelRenderer(this);
		light4.setPos(0.0F, 0.4F, -2.0F);
		bone.addChild(light4);
		setRotationAngle(light4, 1.0036F, 0.0F, 0.0F);
		light4.texOffs(0, 4).addBox(0.0F, -1.4482F, -1.9696F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(0.0F, 22.0F, 7.0F);
		tail.texOffs(18, 27).addBox(0.0F, -4.75F, -2.3F, 0.0F, 2.0F, 3.0F, 0.0F, false);
	}

	

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		fin_back.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(AnglerFishEntity arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
		// TODO Auto-generated method stub
		
	}
}
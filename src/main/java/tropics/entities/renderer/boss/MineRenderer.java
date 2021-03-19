package tropics.entities.renderer.boss;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tropics.Tropics;
import tropics.entities.entity.boss.MineEntity;
import tropics.entities.model.boss.MineModel;

@OnlyIn(Dist.CLIENT)
public class MineRenderer<T extends MineEntity> extends EntityRenderer<T> {
   private static final ResourceLocation MINE_TEXTURE = new ResourceLocation(Tropics.MOD_ID, "textures/entity/mine.png");

   protected final MineModel<T> mineModel = new MineModel<T>();

   public MineRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
   }

   @Override
   public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.pushPose();
      matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(180));
      ResourceLocation resourceLocation = this.getTextureLocation(entityIn);
      RenderType renderType = this.mineModel.renderType(resourceLocation);
      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(renderType);
      this.mineModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStackIn.popPose();
      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   @Override
   public ResourceLocation getTextureLocation(T entity) {
      return MINE_TEXTURE;
   }
}
package net.marshmilomoon.mobestiary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.marshmilomoon.mobestiary.Mobestiary;
import net.marshmilomoon.mobestiary.entity.custom.ClayGolemEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ClayGolemRenderer extends MobRenderer<ClayGolemEntity, ClayGolemModel<ClayGolemEntity>> {
    public ClayGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new ClayGolemModel<>(context.bakeLayer(ClayGolemModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ClayGolemEntity clayGolemEntity) {
        return ResourceLocation.fromNamespaceAndPath(Mobestiary.MOD_ID, "textures/entity/clay_golem.png");
    }
}

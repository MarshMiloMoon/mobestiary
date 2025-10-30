package net.marshmilomoon.mobestiary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.marshmilomoon.mobestiary.Mobestiary;
import net.marshmilomoon.mobestiary.entity.custom.ClayGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ClayGolemModel<T extends ClayGolemEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Mobestiary.MOD_ID, "clay_golem"), "main");

    private final ModelPart body;
    private final ModelPart nose;
    private final ModelPart rightarm;
    private final ModelPart leftarm;
    private final ModelPart rightleg;
    private final ModelPart leftleg;

    public ClayGolemModel(ModelPart root) {
        this.body = root.getChild("body");
        this.nose = this.body.getChild("nose");
        this.rightarm = root.getChild("rightarm");
        this.leftarm = root.getChild("leftarm");
        this.rightleg = root.getChild("rightleg");
        this.leftleg = root.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -14.0F, -9.0F, 18.0F, 14.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-9.0F, 0.0F, -9.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-9.0F, -16.0F, -9.0F, 12.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(42, 52).addBox(-5.0F, -15.0F, 1.0F, 14.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition nose = body.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(28, 63).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(66, 61).addBox(-2.0F, 2.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -9.0F));

        PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(42, 61).addBox(-5.0F, -2.0F, -3.5F, 5.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 14.0F, -0.5F));

        PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(42, 61).mirror().addBox(0.0F, -2.0F, -3.5F, 5.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 15.0F, -0.5F));

        PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 63).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 20.0F, 0.0F));

        PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 63).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 20.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(ClayGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(ClayGolemAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, ClayGolemAnimations.IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}

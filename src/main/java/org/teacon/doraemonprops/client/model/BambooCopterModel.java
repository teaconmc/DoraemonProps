package org.teacon.doraemonprops.client.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BambooCopterModel extends BipedModel<LivingEntity> {
    public BambooCopterModel(float modelSize) {
        super(modelSize);

        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bipedHead = new ModelRenderer(this);

        this.bipedHeadwear = new ModelRenderer(this);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);

        ModelRenderer base = new ModelRenderer(this);
        base.setRotationPoint(0.0F, -7.5F, 0.0F);
        this.bipedHeadwear.addChild(base);
        base.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
        base.setTextureOffset(0, 7).addBox(-2.5F, -1.75F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
        base.setTextureOffset(17, 18).addBox(-0.5F, -6.9F, -0.5F, 1.0F, 6.0F, 1.0F, -0.1F, false);

        ModelRenderer fan = new ModelRenderer(this);
        fan.setRotationPoint(0.0F, -14.05F, 0.0F);
        this.bipedHeadwear.addChild(fan);

        ModelRenderer leftFan = new ModelRenderer(this);
        leftFan.setRotationPoint(0.0F, 0.05F, 0.0F);
        fan.addChild(leftFan);
        setRotationAngle(leftFan, 0.0873F, 0.0F, 0.0F);

        ModelRenderer leftFan1 = new ModelRenderer(this);
        leftFan1.setRotationPoint(-0.25F, 0.0F, 0.0F);
        leftFan.addChild(leftFan1);
        setRotationAngle(leftFan1, 0.0F, -0.096F, 0.0F);
        leftFan1.setTextureOffset(16, 14).addBox(-6.5F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, -0.4F, false);

        ModelRenderer leftFan2 = new ModelRenderer(this);
        leftFan2.setRotationPoint(-0.25F, 0.0F, 0.0F);
        leftFan.addChild(leftFan2);
        setRotationAngle(leftFan2, 0.0F, 0.096F, 0.0F);
        leftFan2.setTextureOffset(0, 16).addBox(-6.5F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, -0.405F, false);

        ModelRenderer rightFan = new ModelRenderer(this);
        rightFan.setRotationPoint(0.0F, 0.05F, 0.0F);
        fan.addChild(rightFan);
        setRotationAngle(rightFan, -0.0873F, 0.0F, 0.0F);

        ModelRenderer rightFan1 = new ModelRenderer(this);
        rightFan1.setRotationPoint(0.25F, 0.0F, 0.0F);
        rightFan.addChild(rightFan1);
        setRotationAngle(rightFan1, 0.0F, 0.096F, 0.0F);
        rightFan1.setTextureOffset(15, 7).addBox(-0.5F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, -0.4F, false);

        ModelRenderer rightFan2 = new ModelRenderer(this);
        rightFan2.setRotationPoint(0.25F, 0.0F, 0.0F);
        rightFan.addChild(rightFan2);
        setRotationAngle(rightFan2, 0.0F, -0.096F, 0.0F);
        rightFan2.setTextureOffset(0, 13).addBox(-0.5F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, -0.405F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

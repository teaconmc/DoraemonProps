package org.teacon.doraemonprops.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.teacon.doraemonprops.DoraemonProps;
import org.teacon.doraemonprops.client.model.BambooCopterModel;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class BambooCopterItem extends ArmorItem {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DoraemonProps.MOD_ID, "textures/entity/bamboo_copter.png");
    private static final double UP_DOWN_SPEED = 0.1;

    public BambooCopterItem() {
        super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.TOOLS));
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        Vector3d motion = player.getMotion();
        if (isJumpKeyDown()) {
            player.setMotion(motion.x, UP_DOWN_SPEED, motion.z);
            return;
        }
        if (isSneakKeyDown()) {
            player.setMotion(motion.x, -UP_DOWN_SPEED, motion.z);
            return;
        }
        if (!player.isOnGround()) {
            player.setMotion(motion.x, getJitterDistance(player.ticksExisted), motion.z);
        }
        // TODO: 2021/1/1 目前并没有效果，还是无法抑制摔落伤害
        player.fallDistance = 0;
    }

    private boolean isJumpKeyDown() {
        return Minecraft.getInstance().gameSettings.keyBindJump.isKeyDown();
    }

    private boolean isSneakKeyDown() {
        return Minecraft.getInstance().gameSettings.keyBindSneak.isKeyDown();
    }

    private double getJitterDistance(int ticksExisted) {
        return MathHelper.cos(ticksExisted / 5f) / 100f;
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
        return (A) new BambooCopterModel(1.02f);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return TEXTURE.toString();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.doraemon_props.bamboo_copter.desc"));
    }
}

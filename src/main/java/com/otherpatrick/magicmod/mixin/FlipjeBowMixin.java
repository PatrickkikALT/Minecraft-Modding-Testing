package com.otherpatrick.magicmod.mixin;

import com.otherpatrick.magicmod.ModdedItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public class FlipjeBowMixin {
	@Inject(at = @At("TAIL"), method = "shootProjectile")
	private static void flipje$increaseArrowDamage(
			LivingEntity livingEntity, Projectile projectile, int i, float f, float g, float h, LivingEntity livingEntity2, CallbackInfo ci) {
		ItemStack stack = livingEntity.getMainHandItem();
		if (stack.is(ModdedItems.FLIPJE_BOW)) {
			if (projectile instanceof Arrow arrow) {
				arrow.setBaseDamage(67.0D);
			}
		}
	}
}
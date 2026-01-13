package com.otherpatrick.magicmod.blocks;

import com.otherpatrick.magicmod.ExampleMod;
import com.otherpatrick.magicmod.ModdedBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
public class FlipjeBlock extends Block {
    public FlipjeBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity && world instanceof ServerLevel serverWorld) {
            DamageSource damageSource = new DamageSource(
                    world.registryAccess()
                            .lookupOrThrow(Registries.DAMAGE_TYPE)
                            .get(ModdedBlocks.FLIPJE_DAMAGE.identifier()).get()
            );
            entity.hurtServer(serverWorld, damageSource, 50f);
        }
        else if (entity instanceof ItemEntity item && world instanceof ServerLevel serverWorld) {
            item.discard();
        }
    }
}

package com.otherpatrick.magicmod.items;

import com.otherpatrick.magicmod.ModdedBlocks;
import com.otherpatrick.magicmod.blocks.FlipjeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FlipjeWand extends Item {
    public FlipjeWand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if ((state.getBlock() instanceof FlipjeBlock)) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            System.out.println("Replacing block at " + pos);

            level.setBlock(
                    pos,
                    ModdedBlocks.FLIPJE_BLOCK.defaultBlockState(),
                    3
            );
        }

        return InteractionResult.SUCCESS;
    }

}

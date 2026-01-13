package com.otherpatrick.magicmod.entities;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class FlipjeEntity extends Mob {
    public FlipjeEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
}

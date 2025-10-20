package net.marshmilomoon.mobestiary.entity.custom;

import net.marshmilomoon.mobestiary.block.ModBlocks;
import net.marshmilomoon.mobestiary.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class ClayGolemEntity extends AbstractGolem {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public ClayGolemEntity(EntityType<? extends AbstractGolem> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25,
                stack -> stack.is(ModBlocks.CLAY_NOSE.asItem()), false));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.25, 5));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AbstractGolem.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 8d)
                .add(Attributes.MOVEMENT_SPEED, 0.1d)
                .add(Attributes.FOLLOW_RANGE, 24d);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <=0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        }
        else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}

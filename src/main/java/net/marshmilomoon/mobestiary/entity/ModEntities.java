package net.marshmilomoon.mobestiary.entity;

import net.marshmilomoon.mobestiary.Mobestiary;
import net.marshmilomoon.mobestiary.entity.custom.ClayGolemEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Mobestiary.MOD_ID);

    public static final EntityType<ClayGolemEntity> CLAY_GOLEM = Registry.register(
            Registries.ENTITY_TYPE, new Identifier()
    )

    public static void register(IEventB eventBus) {

    }
}

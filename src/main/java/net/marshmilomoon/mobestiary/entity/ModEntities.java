package net.marshmilomoon.mobestiary.entity;

import net.marshmilomoon.mobestiary.Mobestiary;
import net.marshmilomoon.mobestiary.entity.custom.ClayGolemEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Mobestiary.MOD_ID);

    public static final Supplier<EntityType<ClayGolemEntity>> CLAY_GOLEM =
            ENTITY_TYPES.register("clay_golem", () -> EntityType.Builder.of(ClayGolemEntity::new, MobCategory.MISC)
                    .sized(1f, 1.125f).build("clay_golem"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

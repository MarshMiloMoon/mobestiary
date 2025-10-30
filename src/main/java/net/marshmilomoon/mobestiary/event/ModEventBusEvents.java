package net.marshmilomoon.mobestiary.event;

import net.marshmilomoon.mobestiary.Mobestiary;
import net.marshmilomoon.mobestiary.entity.ModEntities;
import net.marshmilomoon.mobestiary.entity.client.ClayGolemModel;
import net.marshmilomoon.mobestiary.entity.custom.ClayGolemEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Mobestiary.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ClayGolemModel.LAYER_LOCATION, ClayGolemModel::createBodyLayer);
    }

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CLAY_GOLEM.get(), ClayGolemEntity.createAttributes().build());
    }
}

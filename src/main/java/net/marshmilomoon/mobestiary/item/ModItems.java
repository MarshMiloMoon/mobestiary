package net.marshmilomoon.mobestiary.item;

import net.marshmilomoon.mobestiary.Mobestiary;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mobestiary.MOD_ID);

    public static final DeferredItem<Item> POSISHARD = ITEMS.registerItem("posishard",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> SCALES = ITEMS.registerItem("scales",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

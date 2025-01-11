package com.morington.moringtech.item;

import com.morington.moringtech.MoringTechMod;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, MoringTechMod.MODID
    );

    public static final RegistryObject<Item> IRON_ROD = ITEMS.register(
            "iron_rod", () -> new Item(
                    new Item.Properties()
                            .maxStackSize(32)
                            .group(ModItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> STONE_CRUMB = ITEMS.register(
            "stone_crumb", () -> new Item(
                    new Item.Properties()
                            .maxStackSize(64)
                            .group(ModItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> IRON_ITEM_ORE = ITEMS.register(
            "iron_item_ore", () -> new Item(
                    new Item.Properties()
                            .maxStackSize(64)
                            .group(ModItemGroup.ORES)
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

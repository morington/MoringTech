package com.morington.moringtech.item;

import com.morington.moringtech.MoringTechMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, MoringTechMod.MODID
    );

    public static final RegistryObject<Item> IRONROD = ITEMS.register(
            "ironrod", () -> new Item(new Item.Properties().maxStackSize(32).group(ItemGroup.MATERIALS))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package com.morington.moringtech.item;

import com.morington.moringtech.group.ModGroup;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    // Ore Chunk
    public static final RegistryObject<Item> ORE_LITHIUM = ModItemBuilder.createAndBuild("ore/chunk/lithium", ModGroup.ORE_CHUNK);

    // Dust
    public static final RegistryObject<Item> DUST_STONE = ModItemBuilder.createAndBuild("dust/stone", ModGroup.DUST);

    // Tools
//    public static final RegistryObject<Item> JACKHAMMER = ModItemBuilder.createAndBuild("tools/jackhammer", ModGroup.TOOLS);
    public static final RegistryObject<Item> JACKHAMMER = new ModItemBuilder()
            .setName("tools/jackhammer")
            .setItemGroup(ModGroup.TOOLS)
            .setWhetherTool(ToolType.PICKAXE, 3, 144)
            .build();


    public static void register(IEventBus eventBus) {ModItemBuilder.ITEMS.register(eventBus);}
}

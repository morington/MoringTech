package com.morington.moringtech.group;

import com.morington.moringtech.block.ModBlocks;
import com.morington.moringtech.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModGroup {

    // Ore
    public static final ItemGroup ORE = createItemGroup("moringtechMineralsTab", () -> new ItemStack(ModBlocks.ORE_SPODUMENE.get()));

    // Ore Chunk
    public static final ItemGroup ORE_CHUNK = createItemGroup("moringtechOreChunkTab", () -> new ItemStack(ModItems.ORE_LITHIUM.get()));

    // Ore Fraction
    public static final ItemGroup ORE_FRACTION = createItemGroup("moringtechOreFractionTab", () -> new ItemStack(ModItems.ORE_LITHIUM.get()));

    // Dust
    public static final ItemGroup DUST = createItemGroup("moringtechDustTab", () -> new ItemStack(ModItems.DUST_STONE.get()));

    // Tools
    public static final ItemGroup TOOLS = createItemGroup("moringtechToolsTab", () -> new ItemStack(ModItems.JACKHAMMER.get()));

    /**
     * A universal method for creating a tab in your creative inventory.
     *
     * @param label  Tab name.
     * @param iconSupplier   Item for tab icon.
     * @return New instance of ItemGroup.
     */
    private static ItemGroup createItemGroup(String label, Supplier<ItemStack> iconSupplier) {
        return new ItemGroup(label) {
            @Override
            public ItemStack createIcon() {
                return iconSupplier.get();
            }
        };
    }
}

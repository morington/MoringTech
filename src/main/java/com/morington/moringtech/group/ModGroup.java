package com.morington.moringtech.group;

import com.morington.moringtech.block.ModBlocks;
import com.morington.moringtech.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModGroup {

    // Ore
    public static final ItemGroup ORE = createItemGroup("moringtechOreTab", () -> new ItemStack(ModBlocks.ORE_SPODUMENE.get()));

    // Ore Chunk
    public static final ItemGroup ORE_CHUNK = createItemGroup("moringtechOreChunkTab", () -> new ItemStack(ModItems.ORE_LITHIUM.get()));

    // Dust
    public static final ItemGroup DUST = createItemGroup("moringtechDustTab", () -> new ItemStack(ModItems.DUST_STONE.get()));

    /**
     * Универсальный метод для создания вкладки в креативном инвентаре.
     *
     * @param label  Имя вкладки.
     * @param iconSupplier   Предмет для иконки вкладки.
     * @return Новый экземпляр ItemGroup.
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

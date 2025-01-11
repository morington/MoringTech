package com.morington.moringtech.item;

import com.morington.moringtech.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup MATERIALS = new ItemGroup("moringtechMaterialsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.IRON_ROD.get());
        }
    };

    public static final ItemGroup ORES = new ItemGroup("moringtechOresTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.IRON_ORE.get());
        }
    };
}

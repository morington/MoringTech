package com.morington.moringtech.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup MATERIALS = new ItemGroup("moringtechMaterialsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.IRONROD.get());
        }
    };
}

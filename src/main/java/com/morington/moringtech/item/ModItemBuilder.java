package com.morington.moringtech.item;

import com.morington.moringtech.MoringTechMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemBuilder {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoringTechMod.MODID);

    // States
    private String name;
    private Rarity rarity = Rarity.COMMON;
    private int maxStackSize = 64;
    private ItemGroup itemGroup;


    public ModItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ModItemBuilder setRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public ModItemBuilder setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    public ModItemBuilder setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }

    public RegistryObject<Item> build() {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .rarity(rarity)
                .maxStackSize(maxStackSize)
                .group(itemGroup)));
    }

    public static RegistryObject<Item> createAndBuild(String name, ItemGroup itemGroup) {
        return new ModItemBuilder()
                .setName(name)
                .setItemGroup(itemGroup)
                .build();
    }
}
